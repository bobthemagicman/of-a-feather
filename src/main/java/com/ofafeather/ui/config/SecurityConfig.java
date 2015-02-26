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

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ofafeather.domain.service.user.impl.UserDetailsServiceImpl;

/**
 * SecurityConfig.java
 *
 * @author Justen L. Britain
 * @date Mar 30, 2014
 *
 */
@EnableWebMvcSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    
    @Inject
    private UserDetailsServiceImpl userDetailsService;

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
                                "/church-profile/**",
                                "/search/async/filter-results",
                                "/search/async/out-of-region-search",
                                "/**-churches",
                                "/**/**-churches",
                                "/**/"
                        ).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/user/async/favorite/*", "PUT")).hasRole("USER")
                        .requestMatchers(new AntPathRequestMatcher("/user/async/favorite/*", "DELETE")).hasRole("USER")
                        .requestMatchers(new AntPathRequestMatcher("/user/async/preferences/*", "PUT")).hasRole("USER")
                        .antMatchers("/**").hasRole("USER")
                .and()
                    .apply(new AjaxEnabledSpringSocialConfigurer());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManager) throws Exception {
        authenticationManager
            .eraseCredentials(false)
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
    }
        
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
