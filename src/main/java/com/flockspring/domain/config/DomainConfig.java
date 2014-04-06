/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * CoreConfig.java
 *
 * @author Justen L. Britain
 * @date Mar 29, 2014
 *
 */
@ComponentScan(basePackages={"com.flockspring.domain.service"})
@Configuration
public class DomainConfig
{
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer props = new PropertySourcesPlaceholderConfigurer();
        props.setLocation(new ClassPathResource("com/flockspring/domain/service/config/organizationDiscoveryService.properties"));
        
        return props;
    }
}
