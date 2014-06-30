/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.flockspring.ui.config.ConfigUtils;

/**
 * AuthenticationRequestCachingHandlerInterceptor.java
 *
 * @author Justen L. Britain
 * @date Jun 28, 2014
 *
 */
public class AuthenticationRequestCachingHandlerInterceptor extends HandlerInterceptorAdapter
{
    
    private RequestCache requestCache = new HttpSessionRequestCache();
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        if(!request.getContextPath().contains(ConfigUtils.LOGIN_PAGE_URL))
        {
            requestCache.saveRequest(request, response);
        }
    }
}
