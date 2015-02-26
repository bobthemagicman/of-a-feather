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

import com.ofafeather.ui.model.validation.annotation.PasswordsNotEmpty;
import com.ofafeather.ui.model.validation.annotation.PasswordsNotEqual;

@PasswordsNotEmpty(passwordFieldName = "password", passwordVerificationFieldName = "passwordVerification")
@PasswordsNotEqual(passwordFieldName = "password", passwordVerificationFieldName = "passwordVerification")
public class UserRegistrationCommand extends SignUpCommandObject
{

	private String password;
	private String passwordVerification;
	
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
}
