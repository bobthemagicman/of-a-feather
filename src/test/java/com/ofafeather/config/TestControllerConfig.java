/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.ofafeather.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.ofafeather.ui.mapper.AddressUIModelMapper;
import com.ofafeather.ui.mapper.LanguageUIModelMapper;
import com.ofafeather.ui.mapper.LeaderUIModelMapper;
import com.ofafeather.ui.mapper.MultimediaUIModelMapper;
import com.ofafeather.ui.mapper.OrganizationFilterMapper;
import com.ofafeather.ui.mapper.OrganizationUIModelMapper;
import com.ofafeather.ui.mapper.SearchFilterUIModelMapper;
import com.ofafeather.ui.mapper.SearchResultsUIModelMapper;
import com.ofafeather.ui.mapper.SocialMediaUIModelMapper;

/**
 * TestConfig.java
 *
 * @author Justen L. Britain
 * @date Jul 5, 2014
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.ofafeather.ui.controller"})
@PropertySource("classpath:ui.properties")
public class TestControllerConfig extends TestWebConfig 
{
 
	static @Bean  
    public PropertySourcesPlaceholderConfigurer myPropertySourcesPlaceholderConfigurer()  
    {  
        return new PropertySourcesPlaceholderConfigurer();  
    }
	
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
    
    @Bean 
    public SearchResultsUIModelMapper getSearchResultsUIModelMapper()
    {
    	return Mockito.mock(SearchResultsUIModelMapper.class);
    }
    
    @Bean 
    public SocialMediaUIModelMapper getSocialMediaUIModelMapper()
    {
    	return Mockito.mock(SocialMediaUIModelMapper.class);
    }
}