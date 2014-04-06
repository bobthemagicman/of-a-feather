/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SecurityConfig.java
 *
 * @author Justen L. Britain
 * @date Mar 30, 2014
 *
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers("/static/**");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .formLogin()
                    .loginPage("/signin")
                    .loginProcessingUrl("/signin/authenticate")
                    .failureUrl("/signin?error=bad_credentials")
                .and()
                    .logout()
                        .deleteCookies("JSESSIONID")
                        .logoutUrl("/signout")
                        .logoutSuccessUrl("/")
                .and()
                    .authorizeRequests()
                        .antMatchers(
                                "/",
                                "/signin/**",
                                "/signup/**",
                                "/about",
                                "/privacyPolicy",
                                "/termsConditions",
                                "/addYourChurch",
                                "/search",
                                "/contact",
                                "/church-profile/**"
                        ).permitAll()
                        .antMatchers("/**").hasRole("USER");
//                .and()
//                    .apply(new SpringSocialConfigurer());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManager) throws Exception {
        authenticationManager.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
