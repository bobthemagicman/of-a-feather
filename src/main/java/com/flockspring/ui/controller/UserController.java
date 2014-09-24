/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.flockspring.domain.mapper.ApplicationUserBuilder;
import com.flockspring.domain.service.OrganizationDiscoveryService;
import com.flockspring.domain.service.user.UserService;
import com.flockspring.domain.types.impl.ApplicationUserImpl;
import com.flockspring.domain.types.impl.OrganizationImpl;
import com.flockspring.ui.AsyncUserError;
import com.flockspring.ui.IdentifiedPage;
import com.flockspring.ui.editors.LocalDateEditor;
import com.flockspring.ui.mapper.SearchResultsUIModelMapper;
import com.flockspring.ui.model.AsyncBindingResultError;
import com.flockspring.ui.model.AsyncUserFavoriteResponse;
import com.flockspring.ui.model.AsyncUserPreferencesResponse;
import com.flockspring.ui.model.ChurchListingUIModel;
import com.flockspring.ui.model.async.AsyncStatus;
import com.flockspring.ui.model.user.PasswordChangeCommandObject;
import com.flockspring.ui.model.user.ProfileCommandObject;
import com.flockspring.ui.model.user.SearchCriteriaCommandObject;
import com.flockspring.ui.model.user.SignUpCommandObject;

/**
 * UserPreferencesController.java
 *
 * @author Justen L. Britain
 * @date Jun 7, 2014
 *
 */
@Controller
@RequestMapping("/user")
public class UserController extends IdentifiedPage
{

    private static final String PAGE_ID = "user";
    
    private final UserService userService;
    private final OrganizationDiscoveryService organizationDiscoveryService;
    private final SearchResultsUIModelMapper searchResultsModelMapper;
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    public UserController(final UserService userService, final OrganizationDiscoveryService organizationDiscoveryService,
            final SearchResultsUIModelMapper searchResultsModelMapper, final PasswordEncoder passwordEncoder)
    {
        this.userService = userService;
        this.organizationDiscoveryService = organizationDiscoveryService;
        this.searchResultsModelMapper = searchResultsModelMapper;
        this.passwordEncoder = passwordEncoder;
    }
    
    @RequestMapping("/favorites")
    public ModelAndView renderUserFavorites(@AuthenticationPrincipal ApplicationUserImpl user, HttpServletRequest request)
    {
        ModelAndView mv = new ModelAndView("userFavoritesPage");
    
        if(user != null && user.getFavoriteChurches() != null && !user.getFavoriteChurches().isEmpty())
        {
            Map<String, Object> model = new HashMap<>();
            NavigableSet<String> churchIds = user.getFavoriteChurches();
            
            List<OrganizationImpl> organizations = organizationDiscoveryService.getOrganizationsByIds(churchIds);
            
            List<ChurchListingUIModel> favorites = searchResultsModelMapper.map(organizations, request.getLocale(), user);
            model.put("favorites", favorites );            
            mv.addAllObjects(model);
        }
            
        return mv;   
    }
    
    @RequestMapping("/preferences")
    public String renderPreferencesPage(WebRequest request, Model model, @AuthenticationPrincipal ApplicationUserImpl principleUser)
    {
    	ProfileCommandObject profileCommand = new ProfileCommandObject(principleUser);
    	model.addAttribute("profileCommand", profileCommand);
    	
    	SearchCriteriaCommandObject searchCriteriaCommandObject = new SearchCriteriaCommandObject(principleUser.getOrganizationFilter());
    	model.addAttribute("searchCriteriaCommandObject", searchCriteriaCommandObject);
    	
    	PasswordChangeCommandObject passwordChangeCommandObject = new PasswordChangeCommandObject();
    	model.addAttribute("passwordChangeCommandObject", passwordChangeCommandObject);
        
        return "userPreferencesPage";
    }
    
    @RequestMapping(value = "/async/savePreferences", method=RequestMethod.POST)
    public @ResponseBody AsyncUserPreferencesResponse saveUserPreferences(@Valid @ModelAttribute("user") ProfileCommandObject userPreferences, BindingResult result,
            WebRequest request, @AuthenticationPrincipal ApplicationUserImpl principleUser)
    {
    	if (result.hasErrors())
        {
    		List<AsyncBindingResultError> bindingErrors = new ArrayList<>();
    		for(ObjectError error : result.getAllErrors())
    		{
    			bindingErrors.add(new AsyncBindingResultError(error.getObjectName(), error.getDefaultMessage()));
    		}
    		
            return new AsyncUserPreferencesResponse(bindingErrors, AsyncStatus.FAILURE, "Error during parameter binding");
        }
    	
    	ApplicationUserImpl user = new ApplicationUserBuilder()
    			.map(principleUser)
    			.map(userPreferences)
    			.build();
    	
		userService.saveUser(user);
    	
    	return new AsyncUserPreferencesResponse("Successfully saved user preferences");
    }
    
    @RequestMapping(value = "/async/updatePassword", method=RequestMethod.POST)
    public @ResponseBody AsyncUserPreferencesResponse updatePassword(@Valid @ModelAttribute("user") PasswordChangeCommandObject passwordChange, BindingResult result,
            WebRequest request, @AuthenticationPrincipal ApplicationUserImpl principleUser)
    {
    	if(verifyOriginalPasswordMatches(passwordChange.getOriginalPassword(), principleUser))
    	{
    		String encodedPassword = passwordEncoder.encode(passwordChange.getPassword());
    		
    		ApplicationUserImpl user = new ApplicationUserBuilder()
    				.map(principleUser)
    				.withPassword(encodedPassword)
    				.build();
    		
    		userService.saveUser(user);
    		
    		return new AsyncUserPreferencesResponse("Successfully updated user password");
    	}
    	
    	//result.addError(ValidationUtils.);
    	//TODO: jubritain
    	return new AsyncUserPreferencesResponse("shit failed dog");
    }
    
    private boolean verifyOriginalPasswordMatches(String originalPassword, ApplicationUserImpl principleUser)
	{
    	String originalEncodedPassword = passwordEncoder.encode(originalPassword);
    	
    	return originalEncodedPassword.equals(principleUser.getPassword());
	}

	@RequestMapping(value = "/async/updateSearchCriteria", method=RequestMethod.POST)
    public @ResponseBody AsyncUserPreferencesResponse updateSearchCriteria(@Valid @ModelAttribute("user") SignUpCommandObject userPreferences, BindingResult result,
            WebRequest request, @AuthenticationPrincipal ApplicationUserImpl principleUser)
    {
    	return new AsyncUserPreferencesResponse("Successfully updated user search criteria");	
    }
    
    @RequestMapping(value = "/async/favorite/{churchId}", method=RequestMethod.PUT)
    public @ResponseBody AsyncUserFavoriteResponse addFavoriteForUser(final @AuthenticationPrincipal ApplicationUserImpl user, 
            final @PathVariable String churchId)
    {
        if(user != null)
        {
        	ApplicationUserImpl updatedUser = null;
            NavigableSet<String> favorites = user.getFavoriteChurches();
            if(favorites == null)
            {
                favorites = new TreeSet<>();   
                updatedUser = new ApplicationUserBuilder().map(user)
                		.withFavoriteChurches(favorites)
                		.build();
                
            }
            
            String behaviorType = "";
            boolean currentStatus = false;
            if(favorites.contains(churchId))
            {
                favorites.remove(churchId);
                behaviorType = "removed";
                currentStatus = false;
            }
            else
            {
                favorites.add(churchId);
                behaviorType = "added";
                currentStatus = true;
            }
            
            userService.saveUser(updatedUser);
            
            return new AsyncUserFavoriteResponse(String.format("Successfully %s church with id: %s", behaviorType, churchId), currentStatus);
        }
        
        return new AsyncUserFavoriteResponse(new AsyncUserError(), "Unable to complete request");
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) 
    {
        binder.registerCustomEditor(LocalDate.class, new LocalDateEditor());
    }
    
    @Override
    protected String getPageId()
    {
        return PAGE_ID;
    }
}
