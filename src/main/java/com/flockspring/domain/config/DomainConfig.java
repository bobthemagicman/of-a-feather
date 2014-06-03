/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * CoreConfig.java
 *
 * @author Justen L. Britain
 * @date Mar 29, 2014
 *
 */
@ComponentScan(basePackages={"com.flockspring.domain.service"})
@Configuration
@PropertySource("classpath:com/flockspring/domain/service/config/organizationDiscoveryService.properties")
public class DomainConfig
{
    static @Bean  
    public PropertySourcesPlaceholderConfigurer myPropertySourcesPlaceholderConfigurer()  
    {  
        return new PropertySourcesPlaceholderConfigurer();  
    }  
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
