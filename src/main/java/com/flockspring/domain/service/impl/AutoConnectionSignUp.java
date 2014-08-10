/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;

import com.flockspring.domain.DuplicateEmailException;
import com.flockspring.domain.service.user.UserService;
import com.flockspring.domain.types.impl.ApplicationUserImpl;
import com.flockspring.domain.types.user.SocialMediaProvider;
import com.flockspring.domain.types.user.UserRole;
import com.google.common.collect.Sets;

/**
 * AutoConnectionSignUp.java
 *
 * @author Justen L. Britain
 * @date May 26, 2014
 *
 */
public class AutoConnectionSignUp implements ConnectionSignUp
{

    private final UserService userDetailsService;
    
    public AutoConnectionSignUp(UserService userDetailsService)
    {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public String execute(Connection<?> connection)
    {
        UserProfile profile = connection.fetchUserProfile();
        
        ConnectionKey key = connection.getKey();
        SocialMediaProvider provider = SocialMediaProvider.valueOf(key.getProviderId().toUpperCase());
        TreeSet<SocialMediaProvider> socialSigninProviders = Sets.newTreeSet(Arrays.asList(provider));
        
        ApplicationUserImpl applicaitonUser = new ApplicationUserImpl("", profile.getEmail(), "", Collections.<GrantedAuthority>emptySet(),
                profile.getEmail(), profile.getFirstName(), profile.getLastName(), socialSigninProviders, UserRole.ROLE_USER, null);
        
        try
        {
            return userDetailsService.registerNewUserAccount(applicaitonUser).getUserId();
        } catch (DuplicateEmailException e)
        {
            // TODO jbritain log exception here as warning            
        }
        
        return null;       
    }
}
