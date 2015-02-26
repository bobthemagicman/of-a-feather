/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.ofafeather.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ofafeather.ui.mapper.OrganizationUIModelMapper;
import com.ofafeather.ui.mapper.SearchResultsUIModelMapper;

/**
 * TestConfig.java
 *
 * @author Justen L. Britain
 * @date Jul 5, 2014
 *
 */
@Configuration
public class TestMapperConfig extends TestWebConfig 
{
 
    @Bean
    @Profile("test")
    public OrganizationUIModelMapper getOrganizationUIModelMapper() 
    {
        return Mockito.mock(OrganizationUIModelMapper.class);
    }
    
    @Bean 
    public SearchResultsUIModelMapper getSearchResultsUIModelMapper()
    {
    	return Mockito.mock(SearchResultsUIModelMapper.class);
    }
}