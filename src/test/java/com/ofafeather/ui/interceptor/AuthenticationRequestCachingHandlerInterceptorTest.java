/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.ofafeather.ui.interceptor;

import org.junit.Test;

/**
 * AuthenticationRequestCachingHandlerInterceptorTest.java
 * 
 * @author Justen L. Britain
 * @date Jul 5, 2014
 * 
 */
public class AuthenticationRequestCachingHandlerInterceptorTest
{
    protected void setUp() throws Exception
    {
        
    }

    @Test
    public void testRequest()
    {

//        try
//        {
//            MockHttpServletRequest request = new MockHttpServletRequest("GET", "/urlpath/soemname");
//            MockHttpServletResponse response = new MockHttpServletResponse();
//
//            request.setServerName("www.domainname.com");
//
//            HandlerMapping handlerMapping = (HandlerMapping) this.getCtx().getBean("beanname");
//
//            HandlerExecutionChain hec = handlerMapping.getHandler(request);
//            Controller handler = (Controller) hec.getHandler();
//
//            HandlerInterceptor interceptors[] = hec.getInterceptors();
//
//            /*
//             * Calling preHandle on interceptors
//             */
//            for (int i = 0; i < interceptors.length; i++)
//            {
//
//                interceptors[i].preHandle(request, response, handler);
//            }
//
//            /*
//             * calling the controller handleRequest
//             */
//            ModelAndView modelAndView = handler.handleRequest(request, response);
//
//            /*
//             * Calling postHandle on interceptors
//             */
//            for (int i = 0; i < interceptors.length; i++)
//            {
//                interceptors[i].postHandle(request, response, handler, modelAndView);
//            }
//
//            /*
//             * Validating the response
//             */
//
//        } catch (Exception e)
//        {
//            e.printStackTrace();
//            fail();
//        }
    }

    @Test
    public void test()
    {
        //pass("Not yet implemented");
    }

}
