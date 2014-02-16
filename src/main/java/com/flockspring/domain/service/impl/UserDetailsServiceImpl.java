/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;

import com.flockspring.dataaccess.mongodb.EmailUpdateRepository;
import com.flockspring.dataaccess.mongodb.UserRepository;
import com.flockspring.domain.service.UserService;
import com.flockspring.domain.types.impl.UpdateEmailImpl;
import com.flockspring.domain.types.impl.UserImpl;

/**
 * UserDetailsServiceImpl.java
 *
 * @author Justen L. Britain
 * @date Feb 9, 2014
 *
 */
public class UserDetailsServiceImpl implements UserService
{
    private EmailUpdateRepository emailUpdateRepository;
    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(EmailUpdateRepository emailUpdateRepository, UserRepository userRepository)
    {
        super();
        this.emailUpdateRepository = emailUpdateRepository;
        this.userRepository = userRepository;
    }
    
    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException, DataAccessException
    {
        return (SocialUserDetails) loadUserByUsername(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        UserImpl user = userRepository.findByUsername(username);
        
        if(user == null)
        {
            throw new UsernameNotFoundException("Unable to load user with username \""+ username);
        }
        
        return user;
    }

    @Override
    public void saveUpdateEmail(UpdateEmailImpl updateEmailImpl)
    {

        emailUpdateRepository.save(updateEmailImpl);

    }
}
