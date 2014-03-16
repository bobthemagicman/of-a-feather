/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.mapper.user;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.flockspring.domain.types.user.User;
import com.flockspring.domain.types.user.UserRole;
import com.flockspring.ui.model.user.UserUIModel;

/**
 * UserUIModelMapper.java
 * 
 * @author Justen L. Britain
 * @date Mar 8, 2014
 * 
 */
public class UserUIModelMapper
{

    private Set<SimpleGrantedAuthority> createAuthorities(UserRole userRole)
    {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.toString());
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(authority);
        
        return authorities;
    }

    public UserUIModel map(User user)
    {
        String password = "";
        
        return new UserUIModel(user.getId(), user.getEmail(), password , createAuthorities(user.getUserRole()), user.getEmail(),
                user.getFirstName(), user.getLastName(), user.getSignInProviders());        
    }
}
