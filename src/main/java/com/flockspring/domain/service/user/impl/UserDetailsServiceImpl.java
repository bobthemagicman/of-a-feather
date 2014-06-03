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
    public ApplicationUserImpl registerNewUserAccount(ApplicationUserImpl userAccountData) throws DuplicateEmailException {
        if (emailExist(userAccountData.getEmail())) {
            throw new DuplicateEmailException("The email address: " + userAccountData.getEmail() + " is already in use.");
        }

        String encodedPassword = passwordEncoder.encode(userAccountData.getPassword());

        ApplicationUserModelMapper modelMapper = new ApplicationUserModelMapper();
        modelMapper.withEmail(userAccountData.getEmail())
                .withFirstName(userAccountData.getFirstName())
                .withLastName(userAccountData.getLastName())
                .withPassword(encodedPassword);
        
        if (userAccountData.getSignInProviders() != null && !userAccountData.getSignInProviders().isEmpty()) {
            modelMapper.withSignInProvider(userAccountData.getSignInProviders().first());
        }

        UserModel registered = modelMapper.build();

        return modelMapper.map(userRepository.save(registered));
    }

    private boolean emailExist(String email) {
        UserModel user = userRepository.findByEmail(email);

        if (user != null) {
            return true;
        }

        return false;
    }
}