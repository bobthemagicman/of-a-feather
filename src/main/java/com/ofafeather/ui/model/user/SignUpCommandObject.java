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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.ofafeather.domain.types.user.SocialMediaProvider;
import com.ofafeather.ui.model.validation.annotation.PasswordsNotEmpty;
import com.ofafeather.ui.model.validation.annotation.PasswordsNotEqual;

/**
 * SignUpCommandObject.java
 * 
 * @author Justen L. Britain
 * @date Apr 5, 2014
 * 
 */
@PasswordsNotEmpty(passwordFieldName = "password", passwordVerificationFieldName = "passwordVerification")
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
	
	private String displayImageUrl;
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

	public String getDisplayImageUrl()
	{
		return displayImageUrl;
	}

	public void setDisplayImageUrl(String displayImageUrl)
	{
		this.displayImageUrl = displayImageUrl;
	}
}
