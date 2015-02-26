/**
 *
 *   Copyright 2015 Justen L. Britain
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 **/
package com.ofafeather.ui.config;

import java.util.List;
import java.util.Properties;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.ofafeather.ui.interceptor.AuthenticationRequestCachingHandlerInterceptor;
import com.ofafeather.ui.interceptor.HeaderHandlerInterceptor;
import com.ofafeather.ui.interceptor.SearchBarHandlerInterceptor;

/**
 * WebappConfig.java
 * 
 * @author Justen L. Britain
 * @date Mar 29, 2014
 * 
 */

@EnableWebMvc
@Configuration  
public class WebappConfig extends WebMvcConfigurerAdapter
{
    @Configuration  
    @Profile({"dev", "prod"})
    @PropertySource("classpath:ui.properties")
    @ComponentScan(basePackages = { "com.ofafeather.ui.controller", "com.ofafeather.ui.mapper" })
    static class Default  
    {  
    }
    
    @Configuration
    @Profile("test")  
    @PropertySource("classpath:ui.properties")
    static class Test  
    {  
    }
    
    static @Bean  
    public PropertySourcesPlaceholderConfigurer myPropertySourcesPlaceholderConfigurer()  
    {  
        return new PropertySourcesPlaceholderConfigurer();  
    }

    @Value("#{'${pages.with.no.search}'.split(',')}")
    private List<String> noSearchBarList;
    
    @Inject
    private ConnectionRepository connectionRepository;  
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/static/**").addResourceLocations("/resources/");

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
        configurer.enable();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/about").setViewName("aboutPage");
        registry.addViewController("/addYourChurch").setViewName("addChurchPage");
        registry.addViewController("/contact").setViewName("contactUsPage");
        registry.addViewController("/profile").setViewName("profilePage");
        registry.addViewController("/privacyPolicy").setViewName("privacyPolicyPage");
        registry.addViewController("/termsConditions").setViewName("termsConditionsPage");
        registry.addViewController("/signin").setViewName("signinPage");
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        super.addInterceptors(registry);
        registry.addInterceptor(new HeaderHandlerInterceptor(connectionRepository));
        registry.addInterceptor(new SearchBarHandlerInterceptor(noSearchBarList));
        registry.addInterceptor(new AuthenticationRequestCachingHandlerInterceptor());
    }

    @Bean
    public LocalValidatorFactoryBean validator()
    {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public MessageSource messageSource()
    {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages/messages");
        return messageSource;
    }

    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver()
    {
        SimpleMappingExceptionResolver b = new SimpleMappingExceptionResolver();

        Properties mappings = new Properties();
        mappings.put("org.springframework.web.servlet.PageNotFound", "404Page");
        b.setExceptionMappings(mappings);

        return b;
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver()
    {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public CommonsMultipartResolver getMultipartResolver()
    {
        CommonsMultipartResolver mr = new CommonsMultipartResolver();
        mr.setMaxUploadSize(10000);

        return mr;
    }
}
