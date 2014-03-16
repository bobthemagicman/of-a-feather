/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.config.annotation.EnableFacebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SocialAuthenticationProvider;
import org.springframework.social.security.SocialAuthenticationServiceLocator;
import org.springframework.social.security.SocialAuthenticationServiceRegistry;
import org.springframework.social.security.provider.OAuth2AuthenticationService;

import com.flockspring.dataaccess.mongodb.MongoUsersConnectionRepository;
import com.flockspring.dataaccess.mongodb.UserSocialConnectionRepository;
import com.flockspring.domain.service.user.UserService;

/**
 * SocailAndSecurityConfig.java
 *
 * @author Justen L. Britain
 * @date Mar 8, 2014
 *
 */
@Configuration
@EnableSpringSocialSecurity
//@EnableTwitter(appId = "${twitter.consumerKey}", appSecret = "${twitter.consumerSecret}")
@EnableFacebook(appId = "${facebook.clientId}", appSecret = "${facebook.clientSecret}")
public class SocialSecurityWebappConfig {
    @Inject
    private Environment environment;

    @Inject
    UserService userService;

    @Inject
    private AuthenticationManager authenticationManager;

    @Inject
    private UserSocialConnectionRepository userSocialConnectionRepository;

    @Bean
    public SocialAuthenticationServiceLocator socialAuthenticationServiceLocator() {
        SocialAuthenticationServiceRegistry registry = new SocialAuthenticationServiceRegistry();

//        //add google
//        OAuth2ConnectionFactory<Google> googleConnectionFactory = new GoogleConnectionFactory(environment.getProperty("google.clientId"),
//                environment.getProperty("google.clientSecret"));
//        OAuth2AuthenticationService<Google> googleAuthenticationService = new OAuth2AuthenticationService<Google>(googleConnectionFactory);
//        googleAuthenticationService.setScope("https://www.googleapis.com/auth/userinfo.profile");
//        registry.addAuthenticationService(googleAuthenticationService);
//
//        //add twitter
//        OAuth1ConnectionFactory<Twitter> twitterConnectionFactory = new TwitterConnectionFactory(environment.getProperty("twitter.consumerKey"),
//                environment.getProperty("twitter.consumerSecret"));
//        OAuth1AuthenticationService<Twitter> twitterAuthenticationService = new OAuth1AuthenticationService<Twitter>(twitterConnectionFactory);
//        registry.addAuthenticationService(twitterAuthenticationService);

        //add facebook
        OAuth2ConnectionFactory<Facebook> facebookConnectionFactory = new FacebookConnectionFactory(environment.getProperty("facebook.app.id"),
                environment.getProperty("facebook.app.secret"));
        OAuth2AuthenticationService<Facebook> facebookAuthenticationService = new OAuth2AuthenticationService<Facebook>(facebookConnectionFactory);
        facebookAuthenticationService.setScope("");
        registry.addAuthenticationService(facebookAuthenticationService);

        return registry;
    }

    /**
     * Singleton data access object providing access to connections across all users.
     */
    @Bean
    public UsersConnectionRepository usersConnectionRepository() {
        MongoUsersConnectionRepository repository = new MongoUsersConnectionRepository(userSocialConnectionRepository,
                socialAuthenticationServiceLocator(), Encryptors.noOpText());
        repository.setConnectionSignUp(autoConnectionSignUp());
        return repository;
    }

    /**
     * Request-scoped data access object providing access to the current user"s connections.
     */
    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public ConnectionRepository connectionRepository() {
        UserAccount user = AccountUtils.getLoginUserAccount();
        return usersConnectionRepository().createConnectionRepository(user.getUsername());
    }

    /**
     * A proxy to a request-scoped object representing the current user"s primary Google account.
     * 
     * @throws NotConnectedException
     *             if the user is not connected to Google.
     */
    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public Google google() {
        Connection<Google> google = connectionRepository().findPrimaryConnection(Google.class);
        return google != null ? google.getApi() : new GoogleTemplate();
    }

    @Bean
    @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)   
    public Facebook facebook() {
        Connection<Facebook> facebook = connectionRepository().findPrimaryConnection(Facebook.class);
        return facebook != null ? facebook.getApi() : new FacebookTemplate();
    }

    @Bean
    @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)   
    public Twitter twitter() {
        Connection<Twitter> twitter = connectionRepository().findPrimaryConnection(Twitter.class);
        return twitter != null ? twitter.getApi() : new TwitterTemplate();
    }

    @Bean
    public ConnectionSignUp autoConnectionSignUp() {
        return new AutoConnectionSignUp(userService);
    }

    @Bean
    public SocialAuthenticationFilter socialAuthenticationFilter() {
        SocialAuthenticationFilter filter = new SocialAuthenticationFilter(authenticationManager, userService, 
                usersConnectionRepository(), socialAuthenticationServiceLocator());
                
        filter.setFilterProcessesUrl("/signin");
        filter.setSignupUrl(null); 
        filter.setConnectionAddedRedirectUrl("/myAccount");
        filter.setPostLoginUrl("/myAccount");
        return filter;
    }

    @Bean
    public SocialAuthenticationProvider socialAuthenticationProvider(){
        return new SocialAuthenticationProvider(usersConnectionRepository(), userService);
    }

    @Bean
    public LoginUrlAuthenticationEntryPoint socialAuthenticationEntryPoint(){
        return new LoginUrlAuthenticationEntryPoint("/signin");
    }

}