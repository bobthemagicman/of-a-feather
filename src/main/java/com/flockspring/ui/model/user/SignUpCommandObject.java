/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model.user;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.flockspring.domain.types.user.SocialMediaProvider;
import com.flockspring.ui.model.validation.annotation.PasswordsNotEmpty;
import com.flockspring.ui.model.validation.annotation.PasswordsNotEqual;

/**
 * SignUpCommandObject.java
 * 
 * @author Justen L. Britain
 * @date Apr 5, 2014
 * 
 */
@PasswordsNotEmpty(triggerFieldName = "signInProvider", passwordFieldName = "password", passwordVerificationFieldName = "passwordVerification")
@PasswordsNotEqual(passwordFieldName = "password", passwordVerificationFieldName = "passwordVerification")
public class SignUpCommandObject
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
	
	@NotEmpty
	@Size(max = 100)	
	private String password;
	
	@NotEmpty
	@Size(max = 100)	
	private String passwordVerification;
	
	private SocialMediaProvider signInProvider;
	
	public boolean isSocialSignIn()
    {
        return signInProvider != null;
    }

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPasswordVerification()
	{
		return passwordVerification;
	}

	public void setPasswordVerification(String passwordVerification)
	{
		this.passwordVerification = passwordVerification;
	}

	public SocialMediaProvider getSignInProvider()
	{
		return signInProvider;
	}

	public void setSignInProvider(SocialMediaProvider signInProvider)
	{
		this.signInProvider = signInProvider;
	}
}
