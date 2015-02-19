/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.interceptor;

import static com.flockspring.ui.IdentifiedPage.PAGE_ID_MAP_KEY;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * HeaderHandlerInterceptor.java
 *
 * @author Justen L. Britain
 * @date May 10, 2014
 *
 */
public class SearchBarHandlerInterceptor extends HandlerInterceptorAdapter implements HandlerInterceptor
{
    private List<String> pageIdsOfPagesNotToShowSearchInHeader;
    
    public SearchBarHandlerInterceptor(List<String> pageIdsOfPagesNotToShowSearchInHeader)
    {
        super();

        this.pageIdsOfPagesNotToShowSearchInHeader = pageIdsOfPagesNotToShowSearchInHeader;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception
    {
        if(mv != null && mv.getModel() != null && !mv.getModel().isEmpty())
        {
            String pageId = (mv.getModel().containsKey(PAGE_ID_MAP_KEY) ? (String) mv.getModel().get(PAGE_ID_MAP_KEY) : "");
            mv.addObject("showHeaderSearch", !pageIdsOfPagesNotToShowSearchInHeader.contains(pageId));
        }
    }
}