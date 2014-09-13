package com.flockspring.ui.model.user;

@PasswordsNotEmpty(triggerFieldName = "signInProvider", passwordFieldName = "password", passwordVerificationFieldName = "passwordVerification")
@PasswordsNotEqual(passwordFieldName = "password", passwordVerificationFieldName = "passwordVerification")
public class UserRegistrationCommand extends UserCommand
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
