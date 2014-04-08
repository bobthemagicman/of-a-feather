/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.service.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.social.security.SocialUserDetailsService;

import com.flockspring.domain.DuplicateEmailException;
import com.flockspring.domain.service.user.impl.ApplicationUserImpl;
import com.flockspring.domain.types.impl.UpdateEmailImpl;
import com.flockspring.ui.model.user.UserRegistrationUICommand;

/**
 * UserService.java
 *
 * @author Justen L. Britain
 * @date Jan 18, 2014
 *
 */
public interface UserService extends UserDetailsService, SocialUserDetailsService
{

    void saveUpdateEmail(UpdateEmailImpl updateEmailImpl);
    
    ApplicationUserImpl registerNewUserAccount(UserRegistrationUICommand userAccountData) throws DuplicateEmailException;
}
