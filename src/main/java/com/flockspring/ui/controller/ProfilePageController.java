/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.flockspring.domain.service.OrganizationDiscoveryService;
import com.flockspring.domain.types.GlobalRegionType;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.Region;
import com.flockspring.ui.mapper.OrganizationUIModelMapper;
import com.flockspring.ui.model.OrganizationUIModel;

@Controller
@RequestMapping("/communities")
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

        return buildModelAndView(organization);
    }

    @RequestMapping("/{stateRegionName}/{cityRegionName}/{organizationName}")
    public ModelAndView renderOrganizationProfileByName(@PathVariable String organizationName, @PathVariable String stateRegionName,
            @PathVariable String cityRegionName)
    {
        // TODO: sanitize organizationId
        Organization organization = organizationDiscoveryService.getOrganizationByRegionAndOrganizationNames(organizationName, stateRegionName,
                cityRegionName);

        return buildModelAndView(organization);
    }

    private ModelAndView buildModelAndView(Organization organization)
    {
        ModelAndView mav = new ModelAndView(VIEW_NAME);
        OrganizationUIModel organizationUI = organizationUIModelMapper.map(organization);
        mav.addObject("organization", organizationUI);

        return mav;
    }

    @RequestMapping("/{organizationId}")
    public ModelAndView renderOrganizationProfileById(@PathVariable String organizationId)
    {
        // TODO: sanitize organizationId
        Organization organization = organizationDiscoveryService.getOrganizationById(Long.valueOf(organizationId));

        throwExceptionIfOrganizationIsNull(organization, organizationId);

        return buildRedirectUrl(organization);
    }

    private ModelAndView buildRedirectUrl(Organization organization)
    {
        String organizationName = organization.getName().replaceAll(" ", "-");
        Region organizationRegion = organization.getRegion();
        Region state = getParentRegionTypeFromOrganizationRegion(GlobalRegionType.STATE, organizationRegion);
        Region city = getParentRegionTypeFromOrganizationRegion(GlobalRegionType.CITY, organizationRegion);
        Region neighborhood = getParentRegionTypeFromOrganizationRegion(GlobalRegionType.NEIGHBORHOOS, organizationRegion);

        StringBuilder seoUrl = new StringBuilder("redirect:").append(state.getEnglishName()).append("/");

        if (city != null)
        {
            seoUrl.append(city.getEnglishName()).append("/");
        }

        if (neighborhood != null)
        {
            seoUrl.append(neighborhood.getEnglishName()).append("/");
        }

        seoUrl.append(organizationName);

        return new ModelAndView(seoUrl.toString(), "organization", organization);
    }

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
