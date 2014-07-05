/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.interceptor;

import static com.flockspring.ui.IdentifiedPage.PAGE_ID_MAP_KEY;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.flockspring.domain.types.impl.ApplicationUserImpl;
import com.flockspring.domain.types.user.SocialMediaProvider;
import com.flockspring.ui.config.ConfigUtils;
import com.flockspring.ui.mapper.user.UserUIModelBuilder;
import com.flockspring.ui.model.user.HeaderUIModel;
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

    private static final String LOGIN_URL = "loginUrl";
    private static final String LOGOUT_URL = "logoutUrl";
    
    private final ConnectionRepository connectionRepository;
        
    public HeaderHandlerInterceptor (final ConnectionRepository connectionRepository)
    {
        this.connectionRepository = connectionRepository;
    
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object obj = auth.getPrincipal();
        String pageId = (mv.getModel().containsKey(PAGE_ID_MAP_KEY) ? (String) mv.getModel().get(PAGE_ID_MAP_KEY) : "");
        
        if((obj == null || (obj.equals("anonymousUser"))) && (pageId != null && !pageId.equals("signUp")))
        {
            setupHeaderForms(mv, request);
        }
        
        if(obj !=null && obj instanceof ApplicationUserImpl)
        {
           createHeaderModels(mv);
        }
        
        mv.addObject(LOGIN_URL, ConfigUtils.LOGIN_PAGE_URL);
        mv.addObject(LOGOUT_URL, ConfigUtils.LOGOUT_PAGE_URL);
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
    
    private void createUserModelForHeader(ApplicationUserImpl user, ModelAndView modelAndView)
    {
        if(user.getSignInProviders() != null && user.getSignInProviders().contains(SocialMediaProvider.FACEBOOK))
        {
            UserUIModelBuilder userUIModelBuilder = SocialMediaProvider.FACEBOOK.mapProfile(new UserUIModelBuilder(), connectionRepository);
            
            modelAndView.addObject("user", userUIModelBuilder.buildHeaderUIModel());
        }
        else if(user.getSignInProviders() != null && user.getSignInProviders().contains(SocialMediaProvider.TWITTER))
        {
            UserUIModelBuilder userUIModelBuilder = SocialMediaProvider.TWITTER.mapProfile(new UserUIModelBuilder(), connectionRepository);
            
            modelAndView.addObject("user", userUIModelBuilder.buildHeaderUIModel());
        }
        else if(user.getSignInProviders() != null && user.getSignInProviders().contains(SocialMediaProvider.GOOGLE))
        {
            UserUIModelBuilder userUIModelBuilder = SocialMediaProvider.GOOGLE.mapProfile(new UserUIModelBuilder(), connectionRepository);
            
            modelAndView.addObject("user", userUIModelBuilder.buildHeaderUIModel());
        }
        else
        {
            HeaderUIModel userModel = new UserUIModelBuilder().withApplicationUserImpl(user)
                    .buildHeaderUIModel();
            
            modelAndView.addObject("user", userModel);
        }
    }
}
