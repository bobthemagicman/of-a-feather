/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.mongodb.model;

import java.util.TreeSet;

import org.springframework.data.mongodb.core.mapping.Document;

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
  
    public UserModel(String id, String email, String firstName, String lastName, String password, UserRole userRole,
            TreeSet<SocialMediaProvider> signInProviders)
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
    
    public void TreeSetPassword(String password)
    {
        this.password = password;
    }
    
    public void TreeSetUserRole(UserRole userRole)
    {
        this.userRole = userRole;
    }
    
    public void TreeSetSignInProviders(TreeSet<SocialMediaProvider> signInProviders)
    {
        this.signInProviders = signInProviders;
    }
}
