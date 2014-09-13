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
import com.flockspring.domain.mapper.ApplicationUserBuilder;
import com.flockspring.domain.service.user.UserService;
import com.flockspring.domain.types.impl.ApplicationUserImpl;
import com.flockspring.domain.types.impl.UpdateEmailImpl;
import com.google.common.collect.Sets;

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
        
        return new ApplicationUserBuilder().map(user).build();
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

        ApplicationUserBuilder modelMapper = new ApplicationUserBuilder();
        UserModel registered = convertApplicationUserToUserModel(user, encodedPassword, modelMapper);

        return modelMapper.map(userRepository.save(registered)).build();
    }

    private UserModel convertApplicationUserToUserModel(ApplicationUserImpl user, String encodedPassword,
    		ApplicationUserBuilder modelMapper)
    {
        return new UserModel(user.getId(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword(), 
        		user.getUserRole(), user.getSignInProviders(), Sets.newTreeSet(user.getFavoriteChurches()), user.getBirthDate(), user.getDisplayName(),
        		user.getOrganizationFilter());
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
    	ApplicationUserBuilder modelMapper = new ApplicationUserBuilder();
        
        UserModel userModel = convertApplicationUserToUserModel(user, user.getPassword(), modelMapper);
        
        return modelMapper.map(userRepository.save(userModel)).build();
    }
}