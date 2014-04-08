/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.mapper;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.flockspring.dataaccess.mongodb.model.UserModel;
import com.flockspring.domain.service.user.impl.ApplicationUserImpl;
import com.flockspring.domain.types.user.SocialMediaProvider;
import com.flockspring.domain.types.user.UserRole;

/**
 * UserUIModelMapper.java
 * 
 * @author Justen L. Britain
 * @date Mar 8, 2014
 * 
 */
public class ApplicationUserModelMapper
{

    private Set<SocialMediaProvider> signInProviders;
    private String encodedPassword;
    private String lastName;
    private String firstName;
    private String email;

    private Set<SimpleGrantedAuthority> createAuthorities(UserRole userRole)
    {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.toString());
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(authority);
        
        return authorities;
    }

    public ApplicationUserImpl map(UserModel user)
    {
        String password = "";
        
        return new ApplicationUserImpl(user.getId(), user.getEmail(), password , createAuthorities(user.getUserRole()), user.getEmail(),
                user.getFirstName(), user.getLastName(), user.getSignInProviders());        
    }

    public ApplicationUserModelMapper withEmail(String email)
    {
        this.email = email;
        return this;
    }

    public ApplicationUserModelMapper withFirstName(String firstName)
    {
        this.firstName = firstName;
        return this;
    }

    public ApplicationUserModelMapper withLastName(String lastName)
    {
        this.lastName = lastName;
        return this;
    }

    public ApplicationUserModelMapper withPassword(String encodedPassword)
    {
        this.encodedPassword = encodedPassword;
        return this;
    }

    public ApplicationUserModelMapper withSignInProvider(SocialMediaProvider signInProvider)
    {
        if(this.signInProviders == null)
        {
            signInProviders = new TreeSet<>(); 
        }
        this.signInProviders.add(signInProvider);
        
        return this;
    }

    /**
     * @return
     */
    public UserModel build()
    {
        return new UserModel("", email, firstName, lastName, encodedPassword, UserRole.USER, signInProviders);
    }
}
