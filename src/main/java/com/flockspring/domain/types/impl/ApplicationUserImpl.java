/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import java.util.Collection;
import java.util.TreeSet;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.social.security.SocialUser;

import com.flockspring.domain.types.user.SocialMediaProvider;

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

    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private TreeSet<SocialMediaProvider> signInProviders;
    
    public ApplicationUserImpl(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
            boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, String email, String firstName, String lastName,
            TreeSet<SocialMediaProvider> signInProviders)
    {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.signInProviders = signInProviders;
    }

    public ApplicationUserImpl(String id, String username, String password, Collection<? extends GrantedAuthority> authorities, String email, String firstName,
            String lastName, TreeSet<SocialMediaProvider> signInProviders)
    {
        super(username, password, authorities);
        
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.signInProviders = signInProviders;        
    }

    public ApplicationUserImpl(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
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

    public void TreeSetId(String id)
    {
        this.id = id;
    }

    public void TreeSetEmail(String email)
    {
        this.email = email;
    }

    public void TreeSetFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void TreeSetLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void TreeSetSignInProviders(TreeSet<SocialMediaProvider> signInProviders)
    {
        this.signInProviders = signInProviders;
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
