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
package com.ofafeather.ui.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ofafeather.domain.types.impl.ApplicationUserImpl;
import com.ofafeather.domain.types.user.SocialMediaProvider;
import com.ofafeather.ui.config.ConfigUtils;
import com.ofafeather.ui.mapper.user.UserUIModelBuilder;

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
    	if(request.getServletPath().contains("async"))
    	{
    		return;
    	}
    	
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object obj = auth.getPrincipal();
        
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

    private void createUserModelForHeader(ApplicationUserImpl user, ModelAndView modelAndView)
    {
    	UserUIModelBuilder userUIModelBuilder = null;
    	
        if(user.getSignInProviders() != null && user.getSignInProviders().contains(SocialMediaProvider.FACEBOOK))
        {
            userUIModelBuilder = SocialMediaProvider.FACEBOOK.mapProfile(new UserUIModelBuilder(), connectionRepository);
        }
        else if(user.getSignInProviders() != null && user.getSignInProviders().contains(SocialMediaProvider.TWITTER))
        {
            userUIModelBuilder = SocialMediaProvider.TWITTER.mapProfile(new UserUIModelBuilder(), connectionRepository);
        }
        else if(user.getSignInProviders() != null && user.getSignInProviders().contains(SocialMediaProvider.GOOGLE))
        {
            userUIModelBuilder = SocialMediaProvider.GOOGLE.mapProfile(new UserUIModelBuilder(), connectionRepository);
        }
        else
        {
        	userUIModelBuilder = new UserUIModelBuilder();
        }
        
        userUIModelBuilder.withApplicationUserImpl(user);
        modelAndView.addObject("user", userUIModelBuilder.buildHeaderUIModel());
        
    }
}
