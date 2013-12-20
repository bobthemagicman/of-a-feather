/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import scala.collection.generic.BitOperations.Int;

import com.flockspring.domain.service.OrganizationDiscoveryService;
import com.flockspring.domain.types.GlobalRegionType;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.Region;
import com.flockspring.ui.mapper.OrganizationUIModelMapper;
import com.flockspring.ui.model.OrganizationUIModel;

@Controller
@RequestMapping("/church-profiles")
public class ProfilePageController
{
    private static final String VIEW_NAME = "profilePage";

    private final OrganizationDiscoveryService organizationDiscoveryService;
    private OrganizationUIModelMapper organizationUIModelMapper;

    @Autowired
    public ProfilePageController(final OrganizationDiscoveryService organizationDiscoveryService, OrganizationUIModelMapper organizationUIModelMapper)
    {
        super();

        this.organizationUIModelMapper = organizationUIModelMapper;
        this.organizationDiscoveryService = organizationDiscoveryService;
    }

    @RequestMapping("/{statRegionName}/{cityRegionName}/{neighborhoodRegionName}/{organizationName}")
    public ModelAndView renderOrganizationProfileByName(@PathVariable String organizationName, @PathVariable String stateRegionName,
            @PathVariable String cityRegionName, @PathVariable String neighborhoodRegionName)
    {
        // TODO: sanitize organizationId
        Organization organization = organizationDiscoveryService.getOrganizationByRegionAndOrganizationNames(organizationName, stateRegionName,
                cityRegionName, neighborhoodRegionName);

        return buildModelAndView(organization, -1);
    }

    @RequestMapping("/{stateRegionName}/{cityRegionName}/{organizationName}")
    public ModelAndView renderOrganizationProfileByName(@PathVariable String organizationName, @PathVariable String stateRegionName,
            @PathVariable String cityRegionName)
    {
        // TODO: sanitize organizationId
        Organization organization = organizationDiscoveryService.getOrganizationByRegionAndOrganizationNames(organizationName, stateRegionName,
                cityRegionName);

        return null;
    }

    private ModelAndView buildModelAndView(Organization organization, double distance)
    {
        ModelAndView mav = new ModelAndView(VIEW_NAME);
        
        OrganizationUIModel organizationUI = organizationUIModelMapper.map(organization, distance);
        mav.addObject("organization", organizationUI);

        return mav;
    }

    @RequestMapping("/{organizationId}")
    public ModelAndView renderOrganizationProfileById(@PathVariable String organizationId, 
            @RequestParam(value = "dist", required = false) String distance)
    {
        double dist = -1;
        if(StringUtils.hasText(distance))
        {
            try
            {
                dist = Double.parseDouble(distance);
            }catch(NumberFormatException nfe)
            {
                //log invalid distance here
            }
        }
        
        // TODO: sanitize organizationId
        Organization organization = organizationDiscoveryService.getOrganizationById(organizationId);

        throwExceptionIfOrganizationIsNull(organization, organizationId);

        return buildModelAndView(organization, dist); 
    }

//    private ModelAndView buildRedirectUrl(Organization organization)
//    {
////        String organizationName = organization.getName().replaceAll(" ", "-");
////        Region organizationRegion = organization.getRegion();
////        Region state = getParentRegionTypeFromOrganizationRegion(GlobalRegionType.STATE, organizationRegion);
////        Region city = getParentRegionTypeFromOrganizationRegion(GlobalRegionType.CITY, organizationRegion);
////        Region neighborhood = getParentRegionTypeFromOrganizationRegion(GlobalRegionType.NEIGHBORHOOS, organizationRegion);
////
////        StringBuilder seoUrl = new StringBuilder("redirect:").append(state.getEnglishName()).append("/");
////
////        if (city != null)
////        {
////            seoUrl.append(city.getEnglishName()).append("/");
////        }
////
////        if (neighborhood != null)
////        {
////            seoUrl.append(neighborhood.getEnglishName()).append("/");
////        }
////
////        seoUrl.append(organizationName);
////
////        return new ModelAndView(seoUrl.toString(), "organization", organization);
////        
//        return null;
//    }

    /**
     * @param neighborhood
     * @param organizationRegion
     * @return
     */
    private Region getParentRegionTypeFromOrganizationRegion(GlobalRegionType regionType, Region region)
    {
        if (region == null)
        {
            return null;
        }

        if (region.getRegionType() == regionType)
        {
            return region;
        } else
        {
            return getParentRegionTypeFromOrganizationRegion(regionType, region.getParentRegion());
        }
    }

    /**
     * @param organization
     */
    private void throwExceptionIfOrganizationIsNull(Organization organization, String id)
    {
        if (organization == null)
        {
            throw new PageNotFoundException("Unable to find profile for organization with organizationId: " + id);
        }
    }
}
