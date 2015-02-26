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

import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ofafeather.ui.config.ConfigUtils;

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
        if(!request.getRequestURI().contains(ConfigUtils.LOGIN_PAGE_URL))
        {
            requestCache.saveRequest(request, response);
        }
    }
}
