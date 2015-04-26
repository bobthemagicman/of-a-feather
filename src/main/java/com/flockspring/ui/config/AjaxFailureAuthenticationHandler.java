/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.config;

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
