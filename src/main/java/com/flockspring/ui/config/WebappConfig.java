/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.config;

import java.util.Properties;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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

import com.flockspring.ui.controller.HeaderHandlerInterceptor;
import com.flockspring.ui.mapper.user.HeaderUIModelMapper;

/**
 * WebappConfig.java
 * 
 * @author Justen L. Britain
 * @date Mar 29, 2014
 * 
 */
@EnableWebMvc
@ComponentScan(basePackages = { "com.flockspring.ui.controller", "com.flockspring.ui.mapper" })
@Configuration
@PropertySource("classpath:ui.properties")
public class WebappConfig extends WebMvcConfigurerAdapter
{

    static @Bean  
    public PropertySourcesPlaceholderConfigurer myPropertySourcesPlaceholderConfigurer()  
    {  
        return new PropertySourcesPlaceholderConfigurer();  
    }

    private ConnectionRepository connectionRepository;  
    
    // @Autowired
    // private FlowExecutor flowExecutor;
    //
    // @Autowired
    // private FlowDefinitionRegistry flowRegistry;

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
        registry.addInterceptor(new HeaderHandlerInterceptor(connectionRepository, getHeaderModelMapper()));
    }

    private HeaderUIModelMapper getHeaderModelMapper()
    {
        return new HeaderUIModelMapper();
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

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer properties() {
//        PropertySourcesPlaceholderConfigurer props = new PropertySourcesPlaceholderConfigurer();
//        props.setLocation(new ClassPathResource("ui.properties"));
//        
//        return props;
//    }
//    
    // @Bean
    // public FlowHandlerAdapter flowHandlerAdapter()
    // {
    // FlowHandlerAdapter flowHandlerAdapter = new FlowHandlerAdapter();
    // flowHandlerAdapter.setFlowExecutor(flowExecutor);
    // return flowHandlerAdapter;
    // }
    //
    // @Bean
    // public FlowHandlerMapping flowHandlerMapping()
    // {
    // FlowHandlerMapping flowHandlerMapping = new FlowHandlerMapping();
    // flowHandlerMapping.setInterceptors(new Object[]
    // { localeChangeInterceptor() });
    // flowHandlerMapping.setFlowRegistry(flowRegistry);
    // return flowHandlerMapping;
    // }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public CommonsMultipartResolver getMultipartResolver()
    {
        CommonsMultipartResolver mr = new CommonsMultipartResolver();
        mr.setMaxUploadSize(10000);

        return mr;
    }
}
