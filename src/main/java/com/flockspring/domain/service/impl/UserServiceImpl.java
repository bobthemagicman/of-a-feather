/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flockspring.dataaccess.mongodb.EmailUpdateRepository;
import com.flockspring.dataaccess.mongodb.UserRepository;
import com.flockspring.domain.service.UserService;
import com.flockspring.domain.types.impl.UpdateEmailImpl;

/**
 * UserServiceImpl.java
 * 
 * @author Justen L. Britain
 * @date Jan 18, 2014
 * 
 */
@Service
public class UserServiceImpl implements UserService
{

    private EmailUpdateRepository emailUpdateRepository;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(EmailUpdateRepository emailUpdateRepository, UserRepository userRepository)
    {
        super();
        this.emailUpdateRepository = emailUpdateRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void saveUpdateEmail(UpdateEmailImpl updateEmailImpl)
    {

        emailUpdateRepository.save(updateEmailImpl);

    }

}
