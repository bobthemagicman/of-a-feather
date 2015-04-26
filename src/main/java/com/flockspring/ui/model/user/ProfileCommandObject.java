/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model.user;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.flockspring.domain.types.impl.ApplicationUserImpl;

/**
 * ProfileCommandObject.java
 * 
 * @author Justen L. Britain
 * @date Sep 13, 2014
 * 
 */
public class ProfileCommandObject
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
	
	@Size(max = 50)
	private String displayName;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate birthDate;
	
	public ProfileCommandObject()
	{
	}
	
	public ProfileCommandObject(ApplicationUserImpl appUser)
	{
		this.email = appUser.getEmail();
		this.firstName = appUser.getFirstName();
		this.lastName = appUser.getLastName();
		this.displayName = appUser.getDisplayName();
		this.birthDate = appUser.getBirthDate();
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
	
	public String getDisplayName()
	{
		return displayName;
	}
	
	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}
	
	public LocalDate getBirthDate()
	{
		return birthDate;
	}
	
	public void setBirthDate(LocalDate birthDate)
	{
		this.birthDate = birthDate;
	}
}
