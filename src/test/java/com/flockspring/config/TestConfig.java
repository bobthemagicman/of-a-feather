/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.config;

import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.security.SocialAuthenticationServiceLocator;

import com.flockspring.dataaccess.mongodb.UserSocialConnectionRepository;
import com.flockspring.domain.service.OrganizationDiscoveryService;
import com.flockspring.domain.service.user.impl.UserDetailsServiceImpl;
import com.flockspring.ui.mapper.OrganizationUIModelMapper;

/**
 * TestConfig.java
 *
 * @author Justen L. Britain
 * @date Jul 5, 2014
 *
 */
@Configuration
public class TestConfig 
{
 
    @Bean
    public MessageSource messageSource() 
    {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
 
        messageSource.setBasename("i18n/messages");
        messageSource.setUseCodeAsDefaultMessage(true);
 
        return messageSource;
    }
 
    @Bean
    public ConnectionRepository getConnectionRepository() 
    {
        return Mockito.mock(ConnectionRepository.class);
    }
    
    @Bean
    @Profile("test")
    public OrganizationUIModelMapper getOrganizationUIModelMapper() 
    {
        return Mockito.mock(OrganizationUIModelMapper.class);
    }
    
    @Bean
    public OrganizationDiscoveryService getOrganizationDiscoveryService() 
    {
        return Mockito.mock(OrganizationDiscoveryService.class);
    }
    
    @Bean
    public UserDetailsServiceImpl getUserDetailsServiceImpl() 
    {
        return Mockito.mock(UserDetailsServiceImpl.class);
    }
       
    @Bean
    public UserSocialConnectionRepository getUserSocialConnectionRepository() 
    {
        return Mockito.mock(UserSocialConnectionRepository.class);
    }
    
    @Bean
    public UsersConnectionRepository getUsersConnectionRepository()
    {
    	return Mockito.mock(UsersConnectionRepository.class);
    }
    
    @Bean
    public SocialAuthenticationServiceLocator getSocialAuthenticationServiceLocator()
    {
    	return Mockito.mock(SocialAuthenticationServiceLocator.class); 
    }
}