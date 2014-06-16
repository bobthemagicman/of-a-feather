/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model.user;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.flockspring.domain.types.user.SocialMediaProvider;

/**
 * UserRegistrationUICommand.java
 * 
 * @author Justen L. Britain
 * @date Apr 5, 2014
 * 
 */
@PasswordsNotEmpty(triggerFieldName = "signInProvider", passwordFieldName = "password", passwordVerificationFieldName = "passwordVerification")
@PasswordsNotEqual(passwordFieldName = "password", passwordVerificationFieldName = "passwordVerification")
public class UserRegistrationUICommand
{

    @Email
    @NotEmpty
    @Size(max = 100)
    private String email;

    @NotEmpty
    @Size(max = 100)
    private String firstName;

    @NotEmpty
    @Size(max = 100)
    private String lastName;

    private String password;

    private String passwordVerification;

    private SocialMediaProvider signInProvider;

    private String displayImageUrl;

    // Constructor is omitted for the of clarity.

    public boolean isSocialSignIn()
    {
        return signInProvider != null;
    }

    public String getEmail()
    {
        return email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getPassword()
    {
        return password;
    }

    public String getPasswordVerification()
    {
        return passwordVerification;
    }

    public SocialMediaProvider getSignInProvider()
    {
        return signInProvider;
    }

    public String getDisplayImageUrl()
    {
        return this.displayImageUrl;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setPasswordVerification(String passwordVerification)
    {
        this.passwordVerification = passwordVerification;
    }

    public void setSignInProvider(SocialMediaProvider signInProvider)
    {
        this.signInProvider = signInProvider;
    }

    public void setDisplayImageUrl(String displayImageUrl)
    {
        this.displayImageUrl = displayImageUrl;
    }
}
