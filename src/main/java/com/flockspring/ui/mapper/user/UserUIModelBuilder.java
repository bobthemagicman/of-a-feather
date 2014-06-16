/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.mapper.user;

import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.google.api.userinfo.GoogleUserInfo;
import org.springframework.social.twitter.api.TwitterProfile;

import com.flockspring.domain.types.impl.ApplicationUserImpl;
import com.flockspring.domain.types.user.SocialMediaProvider;
import com.flockspring.ui.model.user.HeaderUIModel;
import com.flockspring.ui.model.user.UserRegistrationUICommand;

/**
 * UserUIModelMapper.java
 *
 * @author Justen L. Britain
 * @date May 10, 2014
 *
 */
public class UserUIModelBuilder 
{

    private String lastName;
    private String firstName;
    private String email;
    private String displayImageUrl;
    private String displayName;
    private SocialMediaProvider socialSigninProvider;

    public UserUIModelBuilder withFacebookProfile(FacebookProfile profile)
    {
        this.firstName = profile.getFirstName();
        this.lastName = profile.getLastName();
        this.email = profile.getEmail();
        
        return this;
    }
    
    public UserUIModelBuilder withTwitterProfile(TwitterProfile profile)
    {
        return this;
    }
    
    public UserUIModelBuilder withGoogleProfile(GoogleUserInfo profile)
    {
        return this;
    }
    
    public UserUIModelBuilder withApplicationUserImpl(ApplicationUserImpl user)
    {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        
        createDisplayName();
        
        return this;
    }
      
    public UserUIModelBuilder withEmail(String email)
    {
        this.email = email;
        
        return this;               
    }
    
    public UserUIModelBuilder withFirstName(String firstName)
    {
        this.firstName = firstName;
        
        return this;
    }
    
    public UserUIModelBuilder withLastName(String lastName)
    {
        this.lastName = lastName;
        
        return this;
    }
    
    public UserUIModelBuilder withDisplayName(String displayName)
    {
        this.displayName = displayName;
        return this;
    }
    
    public UserUIModelBuilder withDisplayImageUrl(String displayImageUrl)
    {
        this.displayImageUrl = displayImageUrl;
        return this;
    }
    
    public UserUIModelBuilder withSocialSignInProvider(SocialMediaProvider socialSigninProvider)
    {
        this.socialSigninProvider = socialSigninProvider;
        
        return this;        
    }
    
    public HeaderUIModel buildHeaderUIModel()
    {
        if("".equals(displayName) || displayName == null)
        {
            createDisplayName();
        }
        
        return new HeaderUIModel(displayName, displayImageUrl);
    }

    private void createDisplayName()
    {
        this.displayName = new StringBuilder(this.firstName).append(" ").append(this.lastName).toString();
    }
    
    public UserRegistrationUICommand buildUserRegistrationUICommand()
    {
        UserRegistrationUICommand command = new UserRegistrationUICommand();
        
        command.setEmail(email);
        command.setFirstName(firstName);
        command.setLastName(lastName);
        command.setSignInProvider(socialSigninProvider);
        command.setDisplayImageUrl(displayImageUrl);        
        
        return command;
    }
}
