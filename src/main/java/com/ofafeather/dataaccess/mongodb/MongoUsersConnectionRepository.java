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
package com.ofafeather.dataaccess.mongodb;

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