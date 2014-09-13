/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model.user;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.flockspring.domain.OrganizationFilter;
import com.flockspring.domain.types.user.SocialMediaProvider;

/**
 * UserRegistrationCommand.java
 * 
 * @author Justen L. Britain
 * @date Apr 5, 2014
 * 
 */
public class UserCommand
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
	
	private String displayName;
	private SocialMediaProvider signInProvider;
	private String displayImageUrl;
	private OrganizationFilter userPreferredSearch;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate birthDate;
	
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
	
	public OrganizationFilter getUserPreferredSearch()
	{
		return userPreferredSearch;
	}

	public void setUserPreferredSearch(OrganizationFilter userPreferredSearch)
	{
		this.userPreferredSearch = userPreferredSearch;
	}

	public LocalDate getBirthDate()
	{
		return birthDate;
	}

	public OrganizationFilter getOrganizationFilter()
	{
		return userPreferredSearch;
	}
}
