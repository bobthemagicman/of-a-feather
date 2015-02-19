/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;

/**
 * TestSocialConfig.java
 *
 * @author Justen L. Britain
 * @date Jul 13, 2014
 *
 */
@Configuration
@EnableSocial
public class TestSocialConfig implements SocialConfigurer 
{
    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment environment)
    {
        cfConfig.addConnectionFactory(new FacebookConnectionFactory("123456", "123456"));
    }

    @Override
    public UserIdSource getUserIdSource()
    {
        return new AuthenticationNameUserIdSource();
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator)
    {
        return Mockito.mock(UsersConnectionRepository.class);
    }
}