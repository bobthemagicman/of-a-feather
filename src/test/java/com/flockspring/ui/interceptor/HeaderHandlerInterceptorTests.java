/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.interceptor;

import static org.junit.Assert.fail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * AuthenticationRequestCachingHandlerInterceptorTest.java
 * 
 * @author Justen L. Britain
 * @date Jul 5, 2014
 * 
 */
public class HeaderHandlerInterceptorTests
{
    protected void setUp() throws Exception
    {
        String[] configFiles = new String[]
        { "file:///c:/abc.xml", };

        /*
         * Ref:
         * http://www.koders.com/java/fid78745323A147B238F4B366225C31603C6F87CE75
         * .aspx?s=%22Seth+Ladd%22
         */
        MockServletContext sctx = new MockServletContext("");
        ctx = new XmlWebApplicationContext();
        ctx.setServletContext(sctx);

        ctx.setConfigLocations(configFiles);
        ctx.refresh();
    }

    private void testRequest(HttpServletRequest request, HttpServletResponse response)
    {

        try
        {
            MockHttpServletRequest request = new MockHttpServletRequest("GET", "/urlpath/soemname");
            MockHttpServletResponse response = new MockHttpServletResponse();

            request.setServerName("www.domainname.com");

            HandlerMapping handlerMapping = (HandlerMapping) this.getCtx().getBean("beanname");

            HandlerExecutionChain hec = handlerMapping.getHandler(request);
            Controller handler = (Controller) hec.getHandler();

            HandlerInterceptor interceptors[] = hec.getInterceptors();

            /*
             * Calling preHandle on interceptors
             */
            for (int i = 0; i < interceptors.length; i++)
            {

                interceptors[i].preHandle(request, response, handler);
            }

            /*
             * calling the controller handleRequest
             */
            ModelAndView modelAndView = handler.handleRequest(request, response);

            /*
             * Calling postHandle on interceptors
             */
            for (int i = 0; i < interceptors.length; i++)
            {
                interceptors[i].postHandle(request, response, handler, modelAndView);
            }

            /*
             * Validating the response
             */

        } catch (Exception e)
        {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void test()
    {
        fail("Not yet implemented");
    }

}
