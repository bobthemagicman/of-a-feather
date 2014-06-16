/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.user;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.api.userinfo.GoogleUserInfo;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

import com.flockspring.ui.mapper.user.UserUIModelBuilder;


/**
 * SocialMediaService.java
 *
 * @author Justen L. Britain
 * @date Feb 9, 2014
 *
 */
public enum SocialMediaProvider
{
    FACEBOOK("Facebook") {
        @Override
        public UserUIModelBuilder mapProfile(UserUIModelBuilder userUIModelBuilder, ConnectionRepository connectionRepository)
        {
            Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);
            Facebook facebook = connection != null ? connection.getApi() : new FacebookTemplate();
            FacebookProfile profile = facebook.userOperations().getUserProfile();
            
            userUIModelBuilder.withDisplayImageUrl(connection.getImageUrl());
            
            return userUIModelBuilder.withFacebookProfile(profile);
        }
    }, TWITTER("Twitter") {
        @Override
        public UserUIModelBuilder mapProfile(UserUIModelBuilder userUIModelBuilder, ConnectionRepository connectionRepository)
        {
            Connection<Twitter> connection = connectionRepository.findPrimaryConnection(Twitter.class);
            Twitter twitter = connection != null ? connection.getApi() : new TwitterTemplate("");
            TwitterProfile profile = twitter.userOperations().getUserProfile();
            
            userUIModelBuilder.withDisplayImageUrl(connection.getImageUrl());
            
            return userUIModelBuilder.withTwitterProfile(profile);
        }
    }, GOOGLE("Google") {
        @Override
        public UserUIModelBuilder mapProfile(UserUIModelBuilder userUIModelBuilder, ConnectionRepository connectionRepository)
        {
            Connection<Google> connection = connectionRepository.findPrimaryConnection(Google.class);
            Google google = connection != null ? connection.getApi() : new GoogleTemplate();
            GoogleUserInfo profile = google.userOperations().getUserInfo();;
            
            return userUIModelBuilder.withGoogleProfile(profile);
        }
    };

    private String providerDisplayName;
    
    private SocialMediaProvider(String providerDisplayName)
    {
       this.providerDisplayName = providerDisplayName;
    }
    
    public String getProviderDisplayName()
    {
        return providerDisplayName;
    }
    
    public abstract UserUIModelBuilder mapProfile(UserUIModelBuilder userUIModelBuilder, ConnectionRepository connectionRepository);
}
