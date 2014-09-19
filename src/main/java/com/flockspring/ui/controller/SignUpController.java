/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import java.util.TreeSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
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
import com.flockspring.domain.mapper.ApplicationUserBuilder;
import com.flockspring.domain.service.user.UserService;
import com.flockspring.domain.types.impl.ApplicationUserImpl;
import com.flockspring.domain.types.user.SocialMediaProvider;
import com.flockspring.domain.types.user.SocialMediaProviderConnectionRepositoryWrapper;
import com.flockspring.domain.types.user.UserRole;
import com.flockspring.ui.IdentifiedPage;
import com.flockspring.ui.mapper.user.UserUIModelBuilder;
import com.flockspring.ui.model.user.SignUpCommandObject;
import com.google.common.base.Strings;

/**
 * SignUpController.java
 * 
 * @author Justen L. Britain
 * @date Apr 5, 2014
 * 
 */
@Controller
@SessionAttributes("user")
public class SignUpController extends IdentifiedPage
{
    private static final String PAGE_ID = "signUp";
    
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    
    @Autowired
    public SignUpController(final UserService service, final PasswordEncoder passwordEncoder)
    {
        this.userService = service;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String renderSingupPage(WebRequest request, Model model)
    {
        boolean isModalRequest = Boolean.valueOf(Strings.nullToEmpty(request.getParameter("modal")));
        
        ProviderSignInUtils providerSignInUtils = new ProviderSignInUtils();
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
        
        SignUpCommandObject registration = createRegistrationDTO(connection);
        model.addAttribute("user", registration);
        model.addAttribute("isModalRequest", isModalRequest);
        
        return "signupPage";
    }

    private SignUpCommandObject createRegistrationDTO(Connection<?> connection)
    {
        UserUIModelBuilder userUIModelBuilder = new UserUIModelBuilder();

        if (connection != null)
        {
            ConnectionKey providerKey = connection.getKey();
            SocialMediaProvider socialSigninProvider = SocialMediaProvider.valueOf(providerKey.getProviderId().toUpperCase());
            
            userUIModelBuilder = socialSigninProvider.mapProfile(userUIModelBuilder, new SocialMediaProviderConnectionRepositoryWrapper(connection));
            userUIModelBuilder.withSocialSignInProvider(socialSigninProvider);
        }

        return userUIModelBuilder.buildUserCommand();
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String registerUserAccount(@Valid @ModelAttribute("user") SignUpCommandObject userAccountData, BindingResult result,
            WebRequest request) throws DuplicateEmailException
    {
        if (result.hasErrors())
        {
            return "signupPage";
        }

        ApplicationUserImpl registered = createUserAccount(userAccountData, result);

        if (registered == null)
        {
            return "signupPage";
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(registered, null, registered.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        ProviderSignInUtils.handlePostSignUp(registered.getEmail(), request);

        return "redirect:/";
    }

    private ApplicationUserImpl createUserAccount(SignUpCommandObject userAccountData, BindingResult result)
    {
        TreeSet<SocialMediaProvider> socialSignInProviders = new TreeSet<SocialMediaProvider>();
        socialSignInProviders.add(userAccountData.getSignInProvider());
        String encodedPassword = passwordEncoder.encode(userAccountData.getPassword());
        
        ApplicationUserImpl applicationUser = new ApplicationUserBuilder().map(userAccountData)
        		.withUserRole(UserRole.ROLE_USER)
        		.withPassword(encodedPassword)
        		.build(); 

        try
        {
            applicationUser = userService.registerNewUserAccount(applicationUser);
        } catch (DuplicateEmailException ex)
        {
            addFieldError("user", "email", userAccountData.getEmail(), "NotExist.user.email", result);
        }

        return applicationUser;
    }

    private void addFieldError(String objectName, String fieldName, String fieldValue, String errorCode, BindingResult result)
    {
        FieldError error = new FieldError(objectName, fieldName, fieldValue, false, new String[]
        { errorCode }, new Object[] {}, errorCode);

        result.addError(error);
    }

    @Override
    protected String getPageId()
    {
        return PAGE_ID;
    }
}
