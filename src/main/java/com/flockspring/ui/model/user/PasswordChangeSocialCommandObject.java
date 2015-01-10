/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model.user;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.flockspring.domain.types.impl.ApplicationUserImpl;
import com.flockspring.domain.types.user.SocialMediaProvider;
import com.flockspring.ui.model.validation.annotation.PasswordNotEqualToOldPassword;
import com.flockspring.ui.model.validation.annotation.PasswordsNotEmpty;
import com.flockspring.ui.model.validation.annotation.PasswordsNotEqual;

/**
 * PasswordChangeCommandObject.java
 * 
 * @author Justen L. Britain
 * @date Sept 14, 2014
 * 
 */
@PasswordsNotEmpty(passwordFieldName = "password", passwordVerificationFieldName = "passwordVerification")
@PasswordNotEqualToOldPassword(passwordFieldName = "password", originalPasswordFieldName = "originalPassword")
@PasswordsNotEqual(passwordFieldName = "password", passwordVerificationFieldName = "passwordVerification")
public class PasswordChangeSocialCommandObject
{

	@NotEmpty
	@Size(max = 100)	
	private String password;
	
	@NotEmpty
	@Size(max = 100)	
	private String passwordVerification;
	
	@NotEmpty
	@Size(max = 100)	
	private String originalPassword;

	private boolean facebookSignInEnabled;
	
	public PasswordChangeSocialCommandObject()
	{
		super();
	}
	
	public PasswordChangeSocialCommandObject(ApplicationUserImpl principleUser)
	{
		facebookSignInEnabled = principleUser.getSignInProviders().contains(SocialMediaProvider.FACEBOOK);
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

	public String getOriginalPassword()
	{
		return originalPassword;
	}

	public void setOriginalPassword(String originalPassword)
	{
		this.originalPassword = originalPassword;
	}

	public boolean getFacebookSignInEnabled()
	{
		return facebookSignInEnabled;
	}

	public void setFacebookSignInEnabled(boolean facebookSignInEnabled)
	{
		this.facebookSignInEnabled = facebookSignInEnabled;
	}

	
}
