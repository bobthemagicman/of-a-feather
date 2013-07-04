/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.flockspring.domain.service.OrganizationDiscoveryService;
import com.flockspring.domain.types.Organization;
import com.flockspring.ui.model.CommunityUIModel;
import com.lehman.technology.group.common.domain.types.GlobalRegion;

@Controller
@SessionAttributes("organization")
@RequestMapping("/communities")
public class ProfilePageController
{
    private static final String VIEW_NAME = "profilePage";

    private final OrganizationDiscoveryService organizationDiscoveryService;

    @Autowired
    public ProfilePageController(final OrganizationDiscoveryService organizationDiscoveryService)
    {
        super();

        this.organizationDiscoveryService = organizationDiscoveryService;
    }

    @RequestMapping("/{statRegionName}/{cityRegionName}/{neighborhoodRegionName}/{organizationName}")
    public ModelAndView renderOrganizationProfileByName(@ModelAttribute Organization organization, @PathVariable String organizationName, 
            @PathVariable String stateRegionName, @PathVariable String cityRegionName, @PathVariable String neighborhoodRegionName)
    {
        // TODO: sanitize organizationId
        if(organization == null)
        {
            organization = getOrganizationFromPathParameters(organizationName, stateRegionName, cityRegionName, neighborhoodRegionName);
        }

        return buildModelAndView(organization);
    }

    @RequestMapping("/{statRegionName}/{cityRegionName}/{organizationName}")
    public ModelAndView renderOrganizationProfileByName(@ModelAttribute Organization organization, @PathVariable String organizationName, @PathVariable String stateRegionName,
            @PathVariable String cityRegionName)
    {
        // TODO: sanitize organizationId
        if(organization == null)
        {
            organization = getOrganizationFromPathParameters(organizationName, stateRegionName, cityRegionName, "");
        }

        return buildModelAndView(organization);
    }

    private Organization getOrganizationFromPathParameters(String organizationName, String stateRegionName, String cityRegionName,
            String neighborhoodRegionName)
    {
        Organization organization = organizationDiscoveryService.getOrganizationByRegionAndOrganizationNames(organizationName, stateRegionName, cityRegionName, neighborhoodRegionName);
        return organization;
    }

    private ModelAndView buildModelAndView(Organization organization)
    {
        ModelAndView mav = new ModelAndView(VIEW_NAME);
        CommunityUIModel organizationUI = null; // TODO: implement mapping from domain to UI
        mav.addObject("organization", organizationUI);

        return mav;
    }

    @RequestMapping("/{organizationId}")    
    public ModelAndView renderOrganizationProfileById(@PathVariable String organizationId)
    {
        // TODO: sanitize organizationId        
        GlobalRegion region = organizationDiscoveryService.getRegionForOrganization(Long.valueOf(organizationId));
        Organization organization = organizationDiscoveryService.getOrganizationById(Long.valueOf(organizationId));

        throwExceptionIfOrganizationIsNull(organization, organizationId);
        
        return buildRedirectUrl(region, organization);
    }

    private ModelAndView buildRedirectUrl(GlobalRegion region, Organization organization)
    {   
        StringBuilder seoUrl = new StringBuilder("redirect:").append(region.getEnglishName()).append("/").append(organization.getName());
        
        return new ModelAndView(seoUrl.toString(), "organization", organization);
    }

    /**
     * @param organization
     */
    private void throwExceptionIfOrganizationIsNull(Organization organization, String id)
    {
        if(organization == null)
        {
            throw new PageNotFoundException("Unable to find profile for organization with organizationId: " + id);
        }        
    }
}
