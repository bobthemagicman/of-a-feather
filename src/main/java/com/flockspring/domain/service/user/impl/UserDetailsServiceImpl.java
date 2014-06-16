/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.stereotype.Service;

import com.flockspring.dataaccess.mongodb.EmailUpdateRepository;
import com.flockspring.dataaccess.mongodb.UserRepository;
import com.flockspring.dataaccess.mongodb.model.UserModel;
import com.flockspring.domain.DuplicateEmailException;
import com.flockspring.domain.mapper.ApplicationUserModelMapper;
import com.flockspring.domain.service.user.UserService;
import com.flockspring.domain.types.impl.ApplicationUserImpl;
import com.flockspring.domain.types.impl.UpdateEmailImpl;

/**
 * UserDetailsServiceImpl.java
 *
 * @author Justen L. Britain
 * @date Feb 9, 2014
 *
 */
@Service
public class UserDetailsServiceImpl implements UserService
{
    private EmailUpdateRepository emailUpdateRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    

    @Autowired
    public UserDetailsServiceImpl(EmailUpdateRepository emailUpdateRepository, UserRepository userRepository,
            PasswordEncoder passwordEncoder)
    {
        super();
        
        this.passwordEncoder = passwordEncoder;
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
        UserModel user = userRepository.findByEmail(username);
        
        if(user == null)
        {
            throw new UsernameNotFoundException("Unable to load user with username \""+ username);
        }
        
        return new ApplicationUserModelMapper().map(user);
    }

    @Override
    public void saveUpdateEmail(UpdateEmailImpl updateEmailImpl)
    {

        emailUpdateRepository.save(updateEmailImpl);
    }
    
    @Override
    public ApplicationUserImpl registerNewUserAccount(ApplicationUserImpl user) throws DuplicateEmailException {
        if (emailExist(user.getEmail())) {
            throw new DuplicateEmailException("The email address: " + user.getEmail() + " is already in use.");
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());

        ApplicationUserModelMapper modelMapper = new ApplicationUserModelMapper();
        UserModel registered = convertApplicationUserToUserModel(user, encodedPassword, modelMapper);

        return modelMapper.map(userRepository.save(registered));
    }

    private UserModel convertApplicationUserToUserModel(ApplicationUserImpl user, String encodedPassword,
            ApplicationUserModelMapper modelMapper)
    {
        modelMapper.withEmail(user.getEmail())
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withPassword(encodedPassword);
        
        if (user.getSignInProviders() != null && !user.getSignInProviders().isEmpty()) {
            modelMapper.withSignInProvider(user.getSignInProviders().first());
        }

        UserModel userModel = modelMapper.build();
        return userModel;
    }

    private boolean emailExist(String email) {
        UserModel user = userRepository.findByEmail(email);

        if (user != null) {
            return true;
        }

        return false;
    }

    @Override
    public ApplicationUserImpl saveUser(ApplicationUserImpl user)
    {
        ApplicationUserModelMapper modelMapper = new ApplicationUserModelMapper();
        
        UserModel userModel = convertApplicationUserToUserModel(user, user.getPassword(), modelMapper);
        
        return modelMapper.map(userRepository.save(userModel));
    }
}