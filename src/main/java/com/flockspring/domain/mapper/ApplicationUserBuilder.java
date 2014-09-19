/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.mapper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import org.joda.time.LocalDate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.flockspring.dataaccess.mongodb.model.UserModel;
import com.flockspring.domain.OrganizationFilter;
import com.flockspring.domain.types.impl.ApplicationUserImpl;
import com.flockspring.domain.types.user.SocialMediaProvider;
import com.flockspring.domain.types.user.UserRole;
import com.flockspring.ui.model.user.ProfileCommandObject;
import com.flockspring.ui.model.user.SignUpCommandObject;
import com.google.common.collect.Sets;

/**
 * UserUIModelMapper.java
 *  
 * @author Justen L. Britain
 * @date Mar 8, 2014
 * 
 */
public class ApplicationUserBuilder
{

    private NavigableSet<SocialMediaProvider> signInProviders;
    private String encodedPassword;
    private String lastName;
    private String firstName;
    private String email;
    private NavigableSet<String> favoriteChurches;
    private String id;
	private LocalDate birthDate;
	private String displayName;
	private UserRole userRole;
	private OrganizationFilter organizationFilter;

    private Set<SimpleGrantedAuthority> createAuthorities(final UserRole userRole)
    {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.toString());
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(authority);
        
        return authorities;
    }

    public ApplicationUserBuilder map(final UserModel user)
    {
        this.id = user.getId();
        this.encodedPassword = user.getPassword();
        this.email = user.getEmail();
        this.firstName = user.getFirstName(); 
        this.lastName = user.getLastName();
        this.signInProviders = user.getSignInProviders(); 
        this.userRole = user.getUserRole();
        this.favoriteChurches = user.getFavoriteChurches(); 
        this.birthDate = user.getBirthDate();
    	this.displayName = user.getDisplayName();        
    	this.organizationFilter = user.getOrganizationFilter();
    	
    	return this;
    }

    public ApplicationUserBuilder map(final SignUpCommandObject signup)
	{
        this.email = signup.getEmail();
        this.firstName = signup.getFirstName(); 
        this.lastName = signup.getLastName();
        this.signInProviders =  signup.getSignInProvider() != null ? Sets.newTreeSet(Arrays.asList(signup.getSignInProvider())) : null; 
    	
    	return this;
	}
    
    public ApplicationUserBuilder map(final ProfileCommandObject profile)
	{
    	this.birthDate = profile.getBirthDate();
    	this.displayName = profile.getDisplayName();
    	this.email = profile.getEmail();
    	this.lastName = profile.getLastName();
    	this.firstName = profile.getFirstName();
    	
    	return this;
	}
    
    public ApplicationUserBuilder map(final ApplicationUserImpl user)
	{
    	this.id = user.getId();
    	this.encodedPassword = user.getPassword();
        this.email = user.getEmail();
        this.firstName = user.getFirstName(); 
        this.lastName = user.getLastName();
        this.signInProviders = user.getSignInProviders(); 
        this.userRole = user.getUserRole();
        this.favoriteChurches = user.getFavoriteChurches(); 
        this.birthDate = user.getBirthDate();
 		this.displayName = user.getDisplayName();  
 		this.organizationFilter = user.getOrganizationFilter();
     	
     	return this;
	}
    
    public ApplicationUserImpl build()
    {
        return new ApplicationUserImpl(email, encodedPassword, createAuthorities(userRole), id, email, firstName, lastName, 
        		Sets.newTreeSet(signInProviders), favoriteChurches, userRole, birthDate, displayName, organizationFilter);
    }
    
    public ApplicationUserBuilder withEmail(final String email)
    {
        this.email = email;
        return this;
    }

    public ApplicationUserBuilder withFirstName(final String firstName)
    {
        this.firstName = firstName;
        return this;
    }

    public ApplicationUserBuilder withLastName(final String lastName)
    {
        this.lastName = lastName;
        return this;
    }

    public ApplicationUserBuilder withPassword(final String encodedPassword)
    {
        this.encodedPassword = encodedPassword;
        return this;
    }
    
    public ApplicationUserBuilder withSignInProvider(final SocialMediaProvider signInProvider)
    {
        if(this.signInProviders == null)
        {
            signInProviders = new TreeSet<>(); 
        }
        this.signInProviders.add(signInProvider);
        
        return this;
    }

    public ApplicationUserBuilder withFavoriteChurches(final NavigableSet<String> favoriteChurches)
    {
        this.favoriteChurches = Sets.newTreeSet(favoriteChurches);
        return this;
    }
    
    public ApplicationUserBuilder withDisplayName(final String displayName)
    {
        this.displayName = displayName;
        return this;
    }

    public ApplicationUserBuilder withId(final String id)
    {
        this.id = id;
        return this;
        
    }
    
    public ApplicationUserBuilder withBirthDate(final LocalDate birthDate)
    {
    	this.birthDate = birthDate;
    	return this;
    }

	public ApplicationUserBuilder withUserRole(final UserRole userRole)
	{
		this.userRole = userRole;
		return this;
	}

	public ApplicationUserBuilder withSignInProviders(TreeSet<SocialMediaProvider> signInProviders)
	{
		this.signInProviders = signInProviders;
		return this;
	}
}