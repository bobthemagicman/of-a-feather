/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.config;

import javax.servlet.Filter;

import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.flockspring.dataaccess.config.MongoConfiguration;
import com.flockspring.domain.config.DomainConfig;
import com.flockspring.ui.config.SecurityConfig;
import com.flockspring.ui.config.SocialConfig;
import com.flockspring.ui.config.WebappConfig;


/**
 * WebAppInitializer.java
 *
 * @author Justen L. Britain
 * @date Mar 29, 2014
 *
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class<?>[] { MongoConfiguration.class, DomainConfig.class, SecurityConfig.class, SocialConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class<?>[] { WebappConfig.class };
    }

    @Override
    protected String[] getServletMappings()
    {
        return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] { new DelegatingFilterProxy("springSecurityFilterChain") };
    }
}
