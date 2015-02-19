/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.mongodb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.security.SocialAuthenticationServiceLocator;

/**
 * MongoUsersConnectionRepository.java
 * 
 * @author Justen L. Britain
 * @date Mar 8, 2014
 * 
 */
public class MongoUsersConnectionRepository implements UsersConnectionRepository
{
    private final TextEncryptor textEncryptor;
    private ConnectionSignUp connectionSignUp;
    private final UserSocialConnectionRepository userSocialConnectionRepository;
    private final SocialAuthenticationServiceLocator socialAuthenticationServiceLocator;
    
    public MongoUsersConnectionRepository(TextEncryptor textEncryptor, UserSocialConnectionRepository userSocialConnectionRepository,
            SocialAuthenticationServiceLocator socialAuthenticationServiceLocator)
    {

        this.textEncryptor = textEncryptor;
        this.userSocialConnectionRepository = userSocialConnectionRepository;
        this.socialAuthenticationServiceLocator = socialAuthenticationServiceLocator;
    }

    public void setConnectionSignUp(ConnectionSignUp connectionSignUp)
    {
        this.connectionSignUp = connectionSignUp;
    }
    
    @Override
    public List<String> findUserIdsWithConnection(Connection<?> connection)
    {
        ConnectionKey key = connection.getKey();
        List<UserSocialConnection> userSocialConnectionList = userSocialConnectionRepository.findByProviderIdAndProviderUserId(
                key.getProviderId(), key.getProviderUserId());
        List<String> localUserIds = new ArrayList<String>();
        
        for (UserSocialConnection userSocialConnection : userSocialConnectionList){
            localUserIds.add(userSocialConnection.getUserId());
        }
        if (localUserIds.size() == 0 && connectionSignUp != null)
        {
            String newUserId = connectionSignUp.execute(connection);
            if (newUserId != null)
            {
                createConnectionRepository(newUserId).addConnection(connection);
                return Arrays.asList(newUserId);
            }
        }
        return localUserIds;
    }

    @Override
    public Set<String> findUserIdsConnectedTo(String providerId, Set<String> providerUserIds) {
        final Set<String> localUserIds = new HashSet<String>();

        List<UserSocialConnection> userSocialConnectionList = userSocialConnectionRepository.findByProviderIdAndProviderUserIdIn(
                providerId, providerUserIds);
        for (UserSocialConnection userSocialConnection : userSocialConnectionList){
            localUserIds.add(userSocialConnection.getUserId());
        }
        
        return localUserIds;
    }

    @Override
    public ConnectionRepository createConnectionRepository(String userId)
    {
        if (userId == null)
        {
            throw new IllegalArgumentException("userId cannot be null");
        }
        
        return new MongoConnectionRepository(userId, userSocialConnectionRepository, textEncryptor, socialAuthenticationServiceLocator);
    }
}