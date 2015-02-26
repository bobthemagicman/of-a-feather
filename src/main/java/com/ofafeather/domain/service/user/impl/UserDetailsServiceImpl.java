/**
 *
 *   Copyright 2015 Justen L. Britain
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 **/
package com.ofafeather.domain.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.stereotype.Service;

import com.google.common.collect.Sets;
import com.ofafeather.dataaccess.mongodb.EmailUpdateRepository;
import com.ofafeather.dataaccess.mongodb.UserRepository;
import com.ofafeather.dataaccess.mongodb.model.UserModel;
import com.ofafeather.domain.DuplicateEmailException;
import com.ofafeather.domain.mapper.ApplicationUserBuilder;
import com.ofafeather.domain.service.user.UserService;
import com.ofafeather.domain.types.impl.ApplicationUserImpl;
import com.ofafeather.domain.types.impl.UpdateEmailImpl;

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
    
    

    @Autowired
    public UserDetailsServiceImpl(EmailUpdateRepository emailUpdateRepository, UserRepository userRepository,
            PasswordEncoder passwordEncoder)
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

        ApplicationUserBuilder modelMapper = new ApplicationUserBuilder();
        UserModel registered = convertApplicationUserToUserModel(user, modelMapper);

        return modelMapper.map(userRepository.save(registered)).build();
    }

    private UserModel convertApplicationUserToUserModel(ApplicationUserImpl user,
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
        
        UserModel userModel = convertApplicationUserToUserModel(user, modelMapper);
        
        return modelMapper.map(userRepository.save(userModel)).build();
    }
}