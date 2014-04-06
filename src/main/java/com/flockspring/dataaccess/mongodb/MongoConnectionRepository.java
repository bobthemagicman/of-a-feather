/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.mongodb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.DuplicateConnectionException;
import org.springframework.social.connect.NoSuchConnectionException;
import org.springframework.social.connect.NotConnectedException;
import org.springframework.social.security.SocialAuthenticationServiceLocator;
import org.springframework.social.security.provider.SocialAuthenticationService;
import org.springframework.social.security.provider.SocialAuthenticationService.ConnectionCardinality;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * MongoConnectionRepository.java
 * 
 * @author Justen L. Britain
 * @date Mar 8, 2014
 * 
 */
public class MongoConnectionRepository implements ConnectionRepository
{

    private final String userId;
    private final TextEncryptor textEncryptor;
    private final UserSocialConnectionRepository userSocialConnectionRepository;
    private final SocialAuthenticationServiceLocator socialAuthenticationServiceLocator;
    
    public MongoConnectionRepository(String userId, UserSocialConnectionRepository userSocialConnectionRepository, 
            TextEncryptor textEncryptor, SocialAuthenticationServiceLocator socialAuthenticationServiceLocator)
    {

        this.userId = userId;
        this.userSocialConnectionRepository = userSocialConnectionRepository;
        this.textEncryptor = textEncryptor;
        this.socialAuthenticationServiceLocator = socialAuthenticationServiceLocator;
        
    }

    @Override
    public void addConnection(Connection<?> connection)
    {
        
        SocialAuthenticationService<?> socialAuthenticationService = 
                socialAuthenticationServiceLocator.getAuthenticationService(connection.getKey().getProviderId());
        
        if (socialAuthenticationService.getConnectionCardinality() == ConnectionCardinality.ONE_TO_ONE ||
                socialAuthenticationService.getConnectionCardinality() == ConnectionCardinality.ONE_TO_MANY){
            List<UserSocialConnection> storedConnections = 
                    userSocialConnectionRepository.findByProviderIdAndProviderUserId(
                            connection.getKey().getProviderId(), connection.getKey().getProviderUserId());
            if (storedConnections.size() > 0){
                //not allow one providerId connect to multiple userId
                throw new DuplicateConnectionException(connection.getKey());
            }
        }
        
        UserSocialConnection userSocialConnection = userSocialConnectionRepository
                .findByUserIdAndProviderIdAndProviderUserId(userId, connection.getKey().getProviderId(), 
                        connection.getKey().getProviderUserId());
        
        if (userSocialConnection == null) {
            ConnectionData data = connection.createData();
            userSocialConnection = new UserSocialConnection(userId, data.getProviderId(), data.getProviderUserId(), 0,
                    data.getDisplayName(), data.getProfileUrl(), data.getImageUrl(), encrypt(data.getAccessToken()),
                    encrypt(data.getSecret()), encrypt(data.getRefreshToken()), data.getExpireTime());
            userSocialConnectionRepository.save(userSocialConnection);
        } else {
            throw new DuplicateConnectionException(connection.getKey());
        }
    }

    @Override
    public MultiValueMap<String, Connection<?>> findAllConnections()
    {
        
        List<UserSocialConnection> userSocialConnectionList = this.userSocialConnectionRepository
                .findByUserId(userId);

        MultiValueMap<String, Connection<?>> connections = new LinkedMultiValueMap<String, Connection<?>>();
        Set<String> registeredProviderIds = socialAuthenticationServiceLocator.registeredProviderIds();
        for (String registeredProviderId : registeredProviderIds)
        {
            connections.put(registeredProviderId, Collections.<Connection<?>> emptyList());
        }

        for (UserSocialConnection userSocialConnection : userSocialConnectionList) {
            String providerId = userSocialConnection.getProviderId();
            if (connections.get(providerId).size() == 0) {
                connections.put(providerId, new LinkedList<Connection<?>>());
            }
            connections.add(providerId, buildConnection(userSocialConnection));
        }
        return connections;
    }

    /**
     * Find the connections the current user has to the provider of the given
     * API
     */
    @SuppressWarnings("unchecked")
    @Override
    public <A> List<Connection<A>> findConnections(Class<A> apiType)
    {
        List<?> connections = findConnections(getProviderId(apiType));
        return (List<Connection<A>>) connections;
    }

    @Override
    public List<Connection<?>> findConnections(String providerId)
    {
        List<Connection<?>> resultList = new LinkedList<Connection<?>>();
        List<UserSocialConnection> userSocialConnectionList = userSocialConnectionRepository.findByUserIdAndProviderId(
                userId, providerId);
        
        for (UserSocialConnection userSocialConnection : userSocialConnectionList) 
        {
            resultList.add(buildConnection(userSocialConnection));
        }
        
        return resultList;
    }

    @Override
    public MultiValueMap<String, Connection<?>> findConnectionsToUsers(MultiValueMap<String, String> providerUsers)
    {
        if (providerUsers == null || providerUsers.isEmpty()) 
        {
            throw new IllegalArgumentException("Unable to execute find: no providerUsers provided");
        }

        MultiValueMap<String, Connection<?>> connectionsForUsers = new LinkedMultiValueMap<String, Connection<?>>();
        
        for (Iterator<Entry<String, List<String>>> i = providerUsers.entrySet().iterator(); i.hasNext();) 
        {
            Entry<String, List<String>> entry = i.next();
            
            String providerId = entry.getKey();
            List<String> providerUserIds = entry.getValue();
            
            List<UserSocialConnection> userSocialConnections = userSocialConnectionRepository.findByProviderIdAndProviderUserIdIn(
                    providerId, providerUserIds);
            
            List<Connection<?>> connections = new ArrayList<Connection<?>>(providerUserIds.size());
            
            for (int x = 0; x < providerUserIds.size(); x++) 
            {
                connections.add(null);
            }
            
            connectionsForUsers.put(providerId, connections);

            for (UserSocialConnection userSocialConnection : userSocialConnections) 
            {
                String providerUserId = userSocialConnection.getProviderUserId();
                int connectionIndex = providerUserIds.indexOf(providerUserId);
            
                connections.set(connectionIndex, buildConnection(userSocialConnection));
            }

        }
        
        return connectionsForUsers;
    }

    @Override
    public Connection<?> getConnection(ConnectionKey connectionKey)
    {
        UserSocialConnection userSocialConnection = userSocialConnectionRepository.findByUserIdAndProviderIdAndProviderUserId(
                userId, connectionKey.getProviderId(), connectionKey.getProviderUserId());
        
        if (userSocialConnection != null) 
        {
            return buildConnection(userSocialConnection);
        }
        
        throw new NoSuchConnectionException(connectionKey);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <A> Connection<A> getConnection(Class<A> apiType, String providerUserId)
    {
        String providerId = getProviderId(apiType);
        return (Connection<A>) getConnection(new ConnectionKey(providerId, providerUserId));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <A> Connection<A> getPrimaryConnection(Class<A> apiType)
    {
        String providerId = getProviderId(apiType);
        Connection<A> connection = (Connection<A>) findPrimaryConnection(providerId);
        if (connection == null)
        {
            throw new NotConnectedException(providerId);
        }
        return connection;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <A> Connection<A> findPrimaryConnection(Class<A> apiType)
    {
        String providerId = getProviderId(apiType);
        return (Connection<A>) findPrimaryConnection(providerId);
    }

    @Override
    public void updateConnection(Connection<?> connection)
    {
        ConnectionData data = connection.createData();
        
        UserSocialConnection userSocialConnection = userSocialConnectionRepository
                .findByUserIdAndProviderIdAndProviderUserId(userId, connection.getKey().getProviderId(), connection
                        .getKey().getProviderUserId());
        
        if (userSocialConnection != null) 
        {
            userSocialConnection.setDisplayName(data.getDisplayName());
            userSocialConnection.setProfileUrl(data.getProfileUrl());
            userSocialConnection.setImageUrl(data.getImageUrl());
            userSocialConnection.setAccessToken(encrypt(data.getAccessToken()));
            userSocialConnection.setSecret(encrypt(data.getSecret()));
            userSocialConnection.setRefreshToken(encrypt(data.getRefreshToken()));
            userSocialConnection.setExpireTime(data.getExpireTime());
            
            userSocialConnectionRepository.save(userSocialConnection);
        }
    }

    @Override
    public void removeConnections(String providerId)
    {
        List<UserSocialConnection> userSocialConnectionList = this.userSocialConnectionRepository
                .findByUserIdAndProviderId(userId, providerId);
        
        for (UserSocialConnection userSocialConnection : userSocialConnectionList) 
        {
            this.userSocialConnectionRepository.delete(userSocialConnection);
        }
    }

    @Override
    public void removeConnection(ConnectionKey connectionKey)
    {
        UserSocialConnection userSocialConnection = userSocialConnectionRepository
                .findByUserIdAndProviderIdAndProviderUserId(userId, connectionKey.getProviderId(), connectionKey.getProviderUserId());
        
        userSocialConnectionRepository.delete(userSocialConnection);
    }

    private <A> String getProviderId(Class<A> apiType)
    {
        return socialAuthenticationServiceLocator.getConnectionFactory(apiType).getProviderId();
    }

    private Connection<?> findPrimaryConnection(String providerId) 
    {
        List<UserSocialConnection> userSocialConnectionList = userSocialConnectionRepository
                .findByUserIdAndProviderId(userId, providerId);

        return buildConnection(userSocialConnectionList.get(0));
    }
    
    private Connection<?> buildConnection(UserSocialConnection userSocialConnection) 
    {
        ConnectionData connectionData = new ConnectionData(
                userSocialConnection.getProviderId(), userSocialConnection.getProviderUserId(), userSocialConnection.getDisplayName(),
                userSocialConnection.getProfileUrl(), userSocialConnection.getImageUrl(),
                decrypt(userSocialConnection.getAccessToken()), decrypt(userSocialConnection.getSecret()),
                decrypt(userSocialConnection.getRefreshToken()), userSocialConnection.getExpireTime());
        
        ConnectionFactory<?> connectionFactory = this.socialAuthenticationServiceLocator.getConnectionFactory(connectionData
                .getProviderId());
        
        return connectionFactory.createConnection(connectionData);
    }
    
    private String encrypt(String text) 
    {
        return text != null ? textEncryptor.encrypt(text) : text;
    }

    private String decrypt(String encryptedText) 
    {
        return encryptedText != null ? textEncryptor.decrypt(encryptedText) : encryptedText;
    }
}