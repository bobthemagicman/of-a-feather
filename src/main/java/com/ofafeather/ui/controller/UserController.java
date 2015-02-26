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
package com.ofafeather.ui.controller;

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
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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

import com.ofafeather.domain.mapper.ApplicationUserBuilder;
import com.ofafeather.domain.service.OrganizationDiscoveryService;
import com.ofafeather.domain.service.user.UserService;
import com.ofafeather.domain.types.impl.ApplicationUserImpl;
import com.ofafeather.domain.types.impl.OrganizationImpl;
import com.ofafeather.ui.AsyncUserError;
import com.ofafeather.ui.IdentifiedPage;
import com.ofafeather.ui.editors.LocalDateEditor;
import com.ofafeather.ui.mapper.SearchResultsUIModelMapper;
import com.ofafeather.ui.model.AsyncBindingResultError;
import com.ofafeather.ui.model.AsyncUserFavoriteResponse;
import com.ofafeather.ui.model.AsyncUserPreferencesResponse;
import com.ofafeather.ui.model.ChurchListingUIModel;
import com.ofafeather.ui.model.async.AsyncStatus;
import com.ofafeather.ui.model.user.PasswordChangeSocialCommandObject;
import com.ofafeather.ui.model.user.ProfileCommandObject;
import com.ofafeather.ui.model.user.SearchCriteriaCommandObject;
import com.ofafeather.ui.model.user.SignUpCommandObject;

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
    	
    	PasswordChangeSocialCommandObject passwordChangeCommandObject = new PasswordChangeSocialCommandObject(principleUser);
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
    	
    	if(!user.equals(principleUser))
    	{
    		userService.saveUser(user);
    		
    		Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
    	
    		return new AsyncUserPreferencesResponse("Successfully saved user preferences");
    	}
    	
    	return new AsyncUserPreferencesResponse("Request processed successfully, no changes made to User Preferences");
    }
    
    @RequestMapping(value = "/async/updatePassword", method=RequestMethod.POST)
    public @ResponseBody AsyncUserPreferencesResponse updatePassword(@Valid @ModelAttribute("user") PasswordChangeSocialCommandObject passwordChange, BindingResult result,
            WebRequest request, @AuthenticationPrincipal ApplicationUserImpl principleUser)
    {
    	if(!BCrypt.checkpw(passwordChange.getOriginalPassword(), principleUser.getPassword()))
    	{
    		result.addError(new FieldError("passwordChangeCommandObject", "originalPassword", "Current password was incorrect"));
    		return new AsyncUserPreferencesResponse("Nope Nope Nope");
    	}
    	
    	String encodedPassword = passwordEncoder.encode(passwordChange.getPassword());
    		
		ApplicationUserImpl user = new ApplicationUserBuilder()
				.map(principleUser)
				.withPassword(encodedPassword)
				.build();
		
		userService.saveUser(user);
		
		return new AsyncUserPreferencesResponse("Successfully updated user password");
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
