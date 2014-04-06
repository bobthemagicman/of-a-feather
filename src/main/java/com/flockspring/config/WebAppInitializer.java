/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.flockspring.dataaccess.config.MongoConfiguration;
import com.flockspring.domain.config.DomainConfig;
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
        return new Class<?>[] { MongoConfiguration.class, DomainConfig.class };
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

}
