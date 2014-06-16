/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.flockspring.domain.service.OrganizationDiscoveryService;
import com.flockspring.domain.service.user.UserService;
import com.flockspring.domain.types.impl.ApplicationUserImpl;
import com.flockspring.domain.types.impl.OrganizationImpl;
import com.flockspring.ui.IdentifiedPage;
import com.flockspring.ui.mapper.SearchResultsUIModelMapper;
import com.flockspring.ui.model.ChurchListingUIModel;

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
    
    @Autowired
    public UserController(final UserService userService, final OrganizationDiscoveryService organizationDiscoveryService,
            final SearchResultsUIModelMapper searchResultsModelMapper)
    {
        this.userService = userService;
        this.organizationDiscoveryService = organizationDiscoveryService;
        this.searchResultsModelMapper = searchResultsModelMapper;
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
            
            List<ChurchListingUIModel> favorites = searchResultsModelMapper.map(organizations, request.getLocale());
            model.put("favorites", favorites );            
            mv.addAllObjects(model);
        }
            
        return mv;   
    }
    
    @RequestMapping("/preferences")
    public ModelAndView renderUserPreferences(@AuthenticationPrincipal ApplicationUserImpl user)
    {
        Map<String, ?> model = new HashMap<>();
        
        
        return new ModelAndView("userPreferencesPage", model);
    }
    
    @RequestMapping("/ajax/add-favorite/{church-id}")
    public void addFavoriteForUser(@PathVariable("church-id") String churchId, @AuthenticationPrincipal ApplicationUserImpl user)
    {
        if(user != null)
        {
            if(user.getFavoriteChurches() != null && user.getFavoriteChurches().contains(churchId))
            {
                user.getFavoriteChurches().remove(churchId);
            }
            else 
            {
                if(user.getFavoriteChurches() == null)
                {
                    user.setFavoriteChurches(new TreeSet<String>());
                }
                
                user.getFavoriteChurches().add(churchId);
            }

            //does the object in the security context update automatically? If not there is work to do here
            userService.saveUser(user);
        }
    }

    @Override
    protected String getPageId()
    {
        return PAGE_ID;
    }
}
