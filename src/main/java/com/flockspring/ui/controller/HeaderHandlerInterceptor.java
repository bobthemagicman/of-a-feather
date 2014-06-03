/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.flockspring.domain.types.impl.ApplicationUserImpl;
import com.flockspring.domain.types.user.SocialMediaProvider;
import com.flockspring.ui.mapper.user.HeaderUIModelMapper;
import com.flockspring.ui.model.user.UserRegistrationUICommand;

/**
 * HeaderHandlerInterceptor.java
 *
 * @author Justen L. Britain
 * @date May 10, 2014
 *
 */
public class HeaderHandlerInterceptor extends HandlerInterceptorAdapter implements HandlerInterceptor
{

    private final ConnectionRepository connectionRepository;
    private final HeaderUIModelMapper headerUIModelMapper;
    
    public HeaderHandlerInterceptor (final ConnectionRepository connectionRepository, final HeaderUIModelMapper headerUIModelMapper)
    {
        this.connectionRepository = connectionRepository;
        this.headerUIModelMapper = headerUIModelMapper;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object obj = auth.getPrincipal();
        if(obj == null || (obj.equals("anonymousUser")))
        {
            setupHeaderForms(modelAndView, request);
        }
        
        if(obj !=null && obj instanceof ApplicationUserImpl)
        {
           createHeaderModels(modelAndView);
        }
    }

    private void createHeaderModels(ModelAndView modelAndView)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ApplicationUserImpl user = (ApplicationUserImpl)auth.getPrincipal();
        
        createUserModelForHeader(user, modelAndView);
    }

    private void setupHeaderForms(ModelAndView modelAndView, HttpServletRequest request)
    {
        UserRegistrationUICommand registration = new UserRegistrationUICommand();
        modelAndView.addObject("user", registration);
        
    }
    
    private void createUserModelForHeader(ApplicationUserImpl obj, ModelAndView modelAndView)
    {
        ApplicationUserImpl user = (ApplicationUserImpl)obj;
        
        if(user.getSignInProviders() != null && user.getSignInProviders().contains(SocialMediaProvider.FACEBOOK))
        {
            Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);
            Facebook facebook = connection != null ? connection.getApi() : new FacebookTemplate();
            FacebookProfile profile = facebook.userOperations().getUserProfile();
    
            modelAndView.addObject("user", headerUIModelMapper.map(profile));
        }
        else if(user.getSignInProviders() != null && user.getSignInProviders().contains(SocialMediaProvider.TWITTER))
        {
            Connection<Twitter> connection = connectionRepository.findPrimaryConnection(Twitter.class);
            Twitter twitter = connection != null ? connection.getApi() : new TwitterTemplate("");
            TwitterProfile profile = twitter.userOperations().getUserProfile();
    
            modelAndView.addObject("user", headerUIModelMapper.map(profile));
        }
        else
        {
            modelAndView.addObject("user", headerUIModelMapper.map(user));
        }
    }
}
