/**
 *
 *  Copyright 2015 Justen L. Britain
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
package com.ofafeather.ui.model.user;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.ofafeather.domain.types.impl.ApplicationUserImpl;
import com.ofafeather.domain.types.user.SocialMediaProvider;
import com.ofafeather.ui.model.validation.annotation.PasswordNotEqualToOldPassword;
import com.ofafeather.ui.model.validation.annotation.PasswordsNotEmpty;
import com.ofafeather.ui.model.validation.annotation.PasswordsNotEqual;

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
