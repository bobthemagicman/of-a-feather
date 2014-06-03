/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.config;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.social.UserIdSource;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.security.AuthenticationNameUserIdSource;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SocialAuthenticationProvider;
import org.springframework.social.security.SocialAuthenticationServiceLocator;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * AjaxEnabledSpringSocialConfigurer.java
 *
 * @author Justen L. Britain
 * @date May 18, 2014
 *
 */
public class AjaxEnabledSpringSocialConfigurer extends SpringSocialConfigurer
{

    private UserIdSource userIdSource;

    @Override
    public void configure(HttpSecurity http) throws Exception
    {
        ApplicationContext applicationContext = http.getSharedObject(ApplicationContext.class);
        UsersConnectionRepository usersConnectionRepository = getDependency(applicationContext, UsersConnectionRepository.class);
        SocialAuthenticationServiceLocator authServiceLocator = getDependency(applicationContext, SocialAuthenticationServiceLocator.class);
        SocialUserDetailsService socialUsersDetailsService = getDependency(applicationContext, SocialUserDetailsService.class);
        
        SocialAuthenticationFilter filter = new SocialAuthenticationFilter(
                http.getSharedObject(AuthenticationManager.class), 
                userIdSource != null ? userIdSource : new AuthenticationNameUserIdSource(), 
                usersConnectionRepository, 
                authServiceLocator);

        RememberMeServices rememberMe = http.getSharedObject(RememberMeServices.class);
        if(rememberMe != null) {
            filter.setRememberMeServices(rememberMe);
        }
        
        filter.setAuthenticationFailureHandler(new AjaxFailureAuthenticationHandler(new SimpleUrlAuthenticationFailureHandler("/signin")));
        
        http.authenticationProvider(
                new SocialAuthenticationProvider(usersConnectionRepository, socialUsersDetailsService))
            .addFilterBefore(postProcess(filter), AbstractPreAuthenticatedProcessingFilter.class);
    }
    
    private <T> T getDependency(ApplicationContext applicationContext, Class<T> dependencyType) {
        try {
            T dependency = applicationContext.getBean(dependencyType);
            return dependency;
        } catch (NoSuchBeanDefinitionException e) {
            throw new IllegalStateException("SpringSocialConfigurer depends on " + dependencyType.getName() +". No single bean of that type found in application context.", e);
        }
    }
    
    public SpringSocialConfigurer userIdSource(UserIdSource userIdSource) {
        this.userIdSource = userIdSource;
        return this;
    }
}
