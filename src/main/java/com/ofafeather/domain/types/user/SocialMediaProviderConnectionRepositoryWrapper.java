/**
 *
 *   Copyright 2015 Justen L. Britain
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 **/
package com.ofafeather.domain.types.user;

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