/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import com.flockspring.domain.DuplicateEmailException;
import com.flockspring.domain.service.user.UserService;
import com.flockspring.domain.service.user.impl.ApplicationUserImpl;
import com.flockspring.domain.types.user.SocialMediaProvider;
import com.flockspring.ui.model.user.UserRegistrationUICommand;

/**
 * SignUpController.java
 * 
 * @author Justen L. Britain
 * @date Apr 5, 2014
 * 
 */
@Controller
@SessionAttributes("user")
public class SignUpController
{
    private UserService service;

    @Autowired
    public SignUpController(UserService service)
    {
        this.service = service;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String redirectRequestToRegistrationPage()
    {
        return "redirect:/user/register";
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String showUserRegistrationUICommand(WebRequest request, Model model)
    {
        ProviderSignInUtils providerSignInUtils = new ProviderSignInUtils();
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);

        UserRegistrationUICommand registration = createRegistrationDTO(connection);
        model.addAttribute("user", registration);

        return "user/registrationForm";
    }

    private UserRegistrationUICommand createRegistrationDTO(Connection<?> connection)
    {
        UserRegistrationUICommand dto = new UserRegistrationUICommand();

        if (connection != null)
        {
            UserProfile socialMediaProfile = connection.fetchUserProfile();
            dto.setEmail(socialMediaProfile.getEmail());
            dto.setFirstName(socialMediaProfile.getFirstName());
            dto.setLastName(socialMediaProfile.getLastName());

            ConnectionKey providerKey = connection.getKey();
            dto.setSignInProvider(SocialMediaProvider.valueOf(providerKey.getProviderId().toUpperCase()));
        }

        return dto;
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String registerUserAccount(@Valid @ModelAttribute("user") UserRegistrationUICommand userAccountData, BindingResult result,
            WebRequest request) throws DuplicateEmailException
    {
        if (result.hasErrors())
        {
            return "user/registrationForm";
        }

        ApplicationUserImpl registered = createUserAccount(userAccountData, result);

        if (registered == null)
        {
            return "user/registrationForm";
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(registered, null, registered.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        ProviderSignInUtils.handlePostSignUp(registered.getEmail(), request);

        return "redirect:/";
    }

    private ApplicationUserImpl createUserAccount(UserRegistrationUICommand userAccountData, BindingResult result)
    {
        ApplicationUserImpl registered = null;

        try
        {
            registered = service.registerNewUserAccount(userAccountData);
        } catch (DuplicateEmailException ex)
        {
            addFieldError("user", "email", userAccountData.getEmail(), "NotExist.user.email", result);
        }

        return registered;
    }

    private void addFieldError(String objectName, String fieldName, String fieldValue, String errorCode, BindingResult result)
    {
        FieldError error = new FieldError(objectName, fieldName, fieldValue, false, new String[]
        { errorCode }, new Object[] {}, errorCode);

        result.addError(error);
    }
}
