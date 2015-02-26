/**
 *
 *   Copyright 2015 Justen L. Britain
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
package com.ofafeather.domain.types.impl;

import java.util.Collection;
import java.util.NavigableSet;
import java.util.TreeSet;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.LocalDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.social.security.SocialUser;

import com.ofafeather.domain.OrganizationFilter;
import com.ofafeather.domain.types.user.SocialMediaProvider;
import com.ofafeather.domain.types.user.UserRole;

/**
 * UserImpl.java
 *
 * @author Justen L. Britain
 * @date Feb 8, 2014
 *
 */
public class ApplicationUserImpl extends SocialUser
{
    private static final long serialVersionUID = 3247713418605012233L;

    private final String id;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final TreeSet<SocialMediaProvider> signInProviders;
    private final NavigableSet<String> favoriteChurches;
    private final UserRole userRole;
    private final LocalDate birthDate;
	private final String displayName;
	private final OrganizationFilter organizationFilter;
    
    public ApplicationUserImpl(final String username, final String password, final Collection<? extends GrantedAuthority> authorities, 
    		final String id, final String email, final String firstName, final String lastName, final TreeSet<SocialMediaProvider> signInProviders,
    		final NavigableSet<String> favoriteChurches, final UserRole userRole, final LocalDate birthDate, final String displayName, 
    		final OrganizationFilter organizationFilter)
	{
		super(username, password, authorities);
		
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.signInProviders = signInProviders;
		this.favoriteChurches = favoriteChurches;
		this.userRole = userRole;
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
    
    public TreeSet<SocialMediaProvider> getSignInProviders()
    {
        return signInProviders;
    }
    
    public NavigableSet<String> getFavoriteChurches()
    {
        return favoriteChurches;
    }

    public UserRole getUserRole()
    {
        return userRole;
    }

    public LocalDate getBirthDate() 
    {
		return birthDate;
	}

    public String getDisplayName()
	{
		return this.displayName;
	}
    
	public OrganizationFilter getOrganizationFilter()
	{
		return organizationFilter;
	}

	@Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object rhs)
    {   
        return EqualsBuilder.reflectionEquals(this, rhs);
    }
}
