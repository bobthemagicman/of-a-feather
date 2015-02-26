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

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.security.SocialAuthenticationFailureHandler;
import org.springframework.social.security.SocialAuthenticationRedirectException;
import org.springframework.util.StringUtils;

import com.google.gson.JsonObject;

/**
 * AjaxFailureAuthenticationHandler.java
 *
 * @author Justen L. Britain
 * @date May 18, 2014
 *
 */
public class AjaxFailureAuthenticationHandler extends SocialAuthenticationFailureHandler implements AuthenticationFailureHandler
{
    public AjaxFailureAuthenticationHandler(AuthenticationFailureHandler delegate)
    {
        super(delegate);
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        String ajaxRequestString = request.getParameter("ajaxRequest");
        boolean ajaxRequest = StringUtils.hasText(ajaxRequestString) ? Boolean.valueOf(ajaxRequestString) : false;
        
        if (failed instanceof SocialAuthenticationRedirectException && ajaxRequest) {
            response.setContentType("application/json");
               
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("redirectUrl", ((SocialAuthenticationRedirectException) failed).getRedirectUrl());
            PrintWriter out = response.getWriter();
            out.print(jsonObject.toString());
            out.flush();
         
            return;
        }        
        else
        {
            super.onAuthenticationFailure(request, response, failed);
            
            return;
        }
    }

}
