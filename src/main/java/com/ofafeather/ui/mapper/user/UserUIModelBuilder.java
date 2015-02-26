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
package com.ofafeather.ui.mapper.user;

import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.google.api.userinfo.GoogleUserInfo;
import org.springframework.social.twitter.api.TwitterProfile;

import com.ofafeather.domain.types.impl.ApplicationUserImpl;
import com.ofafeather.domain.types.user.SocialMediaProvider;
import com.ofafeather.ui.model.user.HeaderUIModel;
import com.ofafeather.ui.model.user.SignUpCommandObject;

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
    	if(this.firstName == null || "".equals(this.firstName))
    	{
    		this.firstName = user.getFirstName();
    	}
        
    	if(this.lastName == null || "".equals(this.lastName))
    	{
    		this.lastName = user.getLastName();
    	}
        
        if(this.email == null || "".equals(this.email))
    	{
        	this.email = user.getEmail();
    	}
        
        String userDisplayName = user.getDisplayName();
        this.displayName = userDisplayName == null || "".equals(userDisplayName) ? createDisplayName() : user.getDisplayName();
        
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

    private String createDisplayName()
    {
        return new StringBuilder(this.firstName).append(" ").append(this.lastName).toString();
    }
    
    public SignUpCommandObject buildUserCommand()
    {
        SignUpCommandObject command = new SignUpCommandObject();
        
        command.setEmail(email);
        command.setFirstName(firstName);
        command.setLastName(lastName);
        command.setSignInProvider(socialSigninProvider);
        command.setDisplayImageUrl(displayImageUrl);
        
        return command;
    }
}
