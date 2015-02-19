package com.flockspring.ui.model.user;

import com.flockspring.ui.model.validation.annotation.PasswordsNotEmpty;
import com.flockspring.ui.model.validation.annotation.PasswordsNotEqual;

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
