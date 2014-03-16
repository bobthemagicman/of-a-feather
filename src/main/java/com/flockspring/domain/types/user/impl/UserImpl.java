/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.user.impl;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

import com.flockspring.domain.types.user.SocialMediaProvider;
import com.flockspring.domain.types.user.User;
import com.flockspring.domain.types.user.UserRole;

/**
 * UserImpl.java
 *
 * @author Justen L. Britain
 * @date Mar 8, 2014
 *
 */
@Document(collection = "users")
public class UserImpl implements User
{
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private UserRole userRole;
    private Set<SocialMediaProvider> signInProviders;
  
    public UserImpl(String id, String email, String firstName, String lastName, String password, UserRole userRole,
            Set<SocialMediaProvider> signInProviders)
    {
        super();
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userRole = userRole;
        this.signInProviders = signInProviders;
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
    
    public Set<SocialMediaProvider> getSignInProviders()
    {
        return signInProviders;
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
    
    public void setSignInProviders(Set<SocialMediaProvider> signInProviders)
    {
        this.signInProviders = signInProviders;
    }
}
