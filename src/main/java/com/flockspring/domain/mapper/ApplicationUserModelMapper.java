/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.flockspring.dataaccess.mongodb.model.UserModel;
import com.flockspring.domain.types.user.UserRole;
import com.flockspring.domain.types.user.impl.ApplicationUser;

/**
 * UserUIModelMapper.java
 * 
 * @author Justen L. Britain
 * @date Mar 8, 2014
 * 
 */
public class ApplicationUserModelMapper
{

    private Set<SimpleGrantedAuthority> createAuthorities(UserRole userRole)
    {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.toString());
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(authority);
        
        return authorities;
    }

    public ApplicationUser map(UserModel user)
    {
        String password = "";
        
        return new ApplicationUser(user.getId(), user.getEmail(), password , createAuthorities(user.getUserRole()), user.getEmail(),
                user.getFirstName(), user.getLastName(), user.getSignInProviders());        
    }
}
