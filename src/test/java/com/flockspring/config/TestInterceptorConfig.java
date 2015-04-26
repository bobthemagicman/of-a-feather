/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.flockspring.ui.mapper.AddressUIModelMapper;
import com.flockspring.ui.mapper.LanguageUIModelMapper;
import com.flockspring.ui.mapper.LeaderUIModelMapper;
import com.flockspring.ui.mapper.MultimediaUIModelMapper;
import com.flockspring.ui.mapper.OrganizationFilterMapper;
import com.flockspring.ui.mapper.OrganizationUIModelMapper;
import com.flockspring.ui.mapper.SearchFilterUIModelMapper;

/**
 * TestConfig.java
 *
 * @author Justen L. Britain
 * @date Jul 5, 2014
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.flockspring.ui.interceptor"})
public class TestInterceptorConfig extends TestWebConfig 
{
 
    @Bean 
    public AddressUIModelMapper getAddressUIModelMapper()
    {
    	return Mockito.mock(AddressUIModelMapper.class);
    }
    
    @Bean 
    public LanguageUIModelMapper getLanguageUIModelMapper()
    {
    	return Mockito.mock(LanguageUIModelMapper.class);
    }
    
    @Bean 
    public LeaderUIModelMapper getLeaderUIModelMapper()
    {
    	return Mockito.mock(LeaderUIModelMapper.class);
    }
    
    @Bean 
    public MultimediaUIModelMapper getMultimediaUIModelMapper()
    {
    	return Mockito.mock(MultimediaUIModelMapper.class);
    }
    
    @Bean 
    public OrganizationFilterMapper getOrganizationFilterMapper()
    {
    	return Mockito.mock(OrganizationFilterMapper.class);
    }
    
    @Bean
    public OrganizationUIModelMapper getOrganizationUIModelMapper() 
    {
        return Mockito.mock(OrganizationUIModelMapper.class);
    }
    
    @Bean 
    public SearchFilterUIModelMapper getSearchFilterUIModelMapper()
    {
    	return Mockito.mock(SearchFilterUIModelMapper.class);
    }
}