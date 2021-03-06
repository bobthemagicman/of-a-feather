/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.mongodb.model;

import java.util.NavigableSet;
import java.util.TreeSet;

import org.joda.time.LocalDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.flockspring.domain.OrganizationFilter;
import com.flockspring.domain.types.user.SocialMediaProvider;
import com.flockspring.domain.types.user.UserRole;

/**
 * UserImpl.java
 *
 * @author Justen L. Britain
 * @date Mar 8, 2014
 *
 */
@Document(collection = "users")
public class UserModel
{
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private UserRole userRole;
    private TreeSet<SocialMediaProvider> signInProviders;
    private TreeSet<String> favoriteChurches;
	private LocalDate birthDate;
	private String displayName;
	private OrganizationFilter organizationFilter;
  
    public UserModel(String id, String email, String firstName, String lastName, String password, UserRole userRole,
            TreeSet<SocialMediaProvider> signInProviders, TreeSet<String> favoriteChurches, LocalDate birthDate,
            String displayName, OrganizationFilter organizationFilter)
    {
        super();
        
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userRole = userRole;
        this.signInProviders = signInProviders;
        this.favoriteChurches = favoriteChurches;
        this.birthDate = birthDate;
        this.displayName = displayName;
        this.organizationFilter = organizationFilter;
    }

    public String getId()
    {
        return id;
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

    public UserRole getUserRole()
    {
        return userRole;
    }

    public TreeSet<SocialMediaProvider> getSignInProviders()
    {
        return signInProviders;
    }

    public NavigableSet<String> getFavoriteChurches()
    {
        return favoriteChurches;
    }
    
    public LocalDate getBirthDate() 
	{
		return birthDate;
	}

    public void setId(String id)
    {
        this.id = id;
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

    public void setUserRole(UserRole userRole)
    {
        this.userRole = userRole;
    }

    public void setSignInProviders(TreeSet<SocialMediaProvider> signInProviders)
    {
        this.signInProviders = signInProviders;
    }

    public void setFavoriteChurches(TreeSet<String> favoriteChurches)
    {
        this.favoriteChurches = favoriteChurches;
    }
    
    public void setBirthDate(LocalDate birthDate) 
	{
		this.birthDate = birthDate;
	}

	public String getDisplayName()
	{
		return this.displayName;
	}

	public OrganizationFilter getOrganizationFilter()
	{
		return this.organizationFilter;
	}
}
