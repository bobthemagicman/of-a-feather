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
package com.ofafeather.ui.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;
import org.springframework.social.security.SocialAuthenticationServiceLocator;

import com.ofafeather.dataaccess.mongodb.MongoUsersConnectionRepository;
import com.ofafeather.dataaccess.mongodb.UserSocialConnectionRepository;

/**
 * SocialConfig.java
 *
 * @author Justen L. Britain
 * @date Mar 30, 2014
 *
 */
@EnableSocial
@Configuration
public class SocialConfig implements SocialConfigurer
{
    @Inject
    private UserSocialConnectionRepository userSocialConnectionRepository;
    
    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment env) {
//        String twitterKey = env.getProperty("twitter.consumer.key");
//        String twitterSecret = env.getProperty("twitter.consumer.secret");
//        cfConfig.addConnectionFactory(new TwitterConnectionFactory(twitterKey, twitterSecret));
        
        String facebookAppId = env.getProperty("facebook.app.id");
        String facebookAppSecret = env.getProperty("facebook.app.secret");
        cfConfig.addConnectionFactory(new FacebookConnectionFactory(facebookAppId, facebookAppSecret));
    }

    @Override
    public UserIdSource getUserIdSource() {
        return new AuthenticationNameUserIdSource();
    }
        
    
    @Override
    @Profile({"dev", "default"})
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
       
        MongoUsersConnectionRepository repository = new MongoUsersConnectionRepository(Encryptors.noOpText(), userSocialConnectionRepository, 
                (SocialAuthenticationServiceLocator)connectionFactoryLocator);
        
//        repository.setConnectionSignUp(autoConnectionSignUp());
        
        return repository;
    }
    
//    @Bean
//    public ConnectionSignUp autoConnectionSignUp() {
//        return new AutoConnectionSignUp(userDetailsService);
//    }
    
    @Bean
    public ConnectController connectController(ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository) {
        return new ConnectController(connectionFactoryLocator, connectionRepository);
    }
}
