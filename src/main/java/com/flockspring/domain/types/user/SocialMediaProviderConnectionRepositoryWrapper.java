/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.user;

import java.util.List;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.util.MultiValueMap;

/**
 * SocialMediaProviderConnectionRepositoryWrapper.java
 *
 * @author Justen L. Britain
 * @date Jun 15, 2014
 *
 */
public class SocialMediaProviderConnectionRepositoryWrapper implements ConnectionRepository
{
    private final Connection<?> connection;
    
    public SocialMediaProviderConnectionRepositoryWrapper(Connection<?> connection)
    {
        this.connection = connection;
    }
    
    @Override
    public MultiValueMap<String, Connection<?>> findAllConnections()
    {
        return null;
    }

    @Override
    public List<Connection<?>> findConnections(String providerId)
    {
        return null;
    }

    @Override
    public <A> List<Connection<A>> findConnections(Class<A> apiType)
    {
        return null;
    }

    @Override
    public MultiValueMap<String, Connection<?>> findConnectionsToUsers(MultiValueMap<String, String> providerUserIds)
    {
        return null;
    }

    @Override
    public Connection<?> getConnection(ConnectionKey connectionKey)
    {
        return null;
    }

    @Override
    public <A> Connection<A> getConnection(Class<A> apiType, String providerUserId)
    {
        return null;
    }

    @Override
    public <A> Connection<A> getPrimaryConnection(Class<A> apiType)
    {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <A> Connection<A> findPrimaryConnection(Class<A> apiType)
    {
        if(apiType.getName().toLowerCase().contains(connection.getKey().getProviderId().toLowerCase()))
        {
            return (Connection<A>) connection;
        }
        
        return null;
    }

    @Override
    public void addConnection(Connection<?> connection)
    {
        
    }

    @Override
    public void updateConnection(Connection<?> connection)
    {
        
    }

    @Override
    public void removeConnections(String providerId)
    {
        
    }

    @Override
    public void removeConnection(ConnectionKey connectionKey)
    {
        
    }
    
}