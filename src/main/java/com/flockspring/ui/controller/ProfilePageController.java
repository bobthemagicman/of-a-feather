/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import java.util.Arrays;
import java.util.Set;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.flockspring.domain.service.OrganizationDiscoveryService;
import com.flockspring.domain.types.AccessibilitySupport;
import com.flockspring.domain.types.Affiliation;
import com.flockspring.domain.types.DressAttire;
import com.flockspring.domain.types.GlobalRegionType;
import com.flockspring.domain.types.Language;
import com.flockspring.domain.types.MusicStyle;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.Programs;
import com.flockspring.domain.types.Region;
import com.flockspring.domain.types.ServiceDay;
import com.flockspring.domain.types.ServiceDetailsImpl;
import com.flockspring.domain.types.ServiceStyle;
import com.flockspring.domain.types.TimeAndDay;
import com.flockspring.domain.types.impl.AddressImpl;
import com.flockspring.domain.types.impl.AgeDemographics;
import com.flockspring.domain.types.impl.AtmosphereImpl;
import com.flockspring.domain.types.impl.LeaderImpl;
import com.flockspring.domain.types.impl.LeaderRole;
import com.flockspring.domain.types.impl.MultimediaObjectImpl;
import com.flockspring.domain.types.impl.MusicalInstruments;
import com.flockspring.domain.types.impl.OrganizationImpl;
import com.flockspring.domain.types.impl.SocialMediaImpl;
import com.flockspring.ui.exception.PageNotFoundException;
import com.flockspring.ui.mapper.OrganizationUIModelMapper;
import com.flockspring.ui.model.CongregationSize;
import com.flockspring.ui.model.OrganizationUIModel;
import com.google.common.collect.Sets;

@Controller
@RequestMapping("/church-profile")
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

    @RequestMapping("/test-save")
    public void renderOrganizationProfileByName()
    {
        AddressImpl address = new AddressImpl("123456 78th St", "", "97888", "NC", "South Bridge", "USA", new double[] {123.444, 56.123});
        
        TimeAndDay timeAndDay = new TimeAndDay(new LocalDateTime(1, 1, 1, 9, 20), ServiceDay.SUNDAY);
        Set<MusicalInstruments> instruments = Sets.newTreeSet();
        ServiceDetailsImpl serviceDetailsImpl1 = new ServiceDetailsImpl(MusicStyle.NEUTRAL_5, ServiceStyle.HIGH_ENERGY_8, DressAttire.FORMAL_2, AgeDemographics.NEUTRAL_4, instruments ,
                90, timeAndDay, "Service 1", Sets.newTreeSet(Arrays.asList(Language.SPANISH)));
        Set<ServiceDetailsImpl> services = Sets.newTreeSet(Arrays.asList(serviceDetailsImpl1));
        
        AtmosphereImpl atmosphere = new AtmosphereImpl(CongregationSize.LARGE, services, false, false, 90);
        SocialMediaImpl socialMedia = new SocialMediaImpl("", "", "", "", "", "", "", "", "");
        
        MultimediaObjectImpl image1 = new MultimediaObjectImpl("Leader 1 picture", "5.jpg", "alt text", "title text", false, false);;
        MultimediaObjectImpl image2 = new MultimediaObjectImpl("Leader 1 picture", "5.jpg", "alt text", "title text", false, false);;
        MultimediaObjectImpl image3 = new MultimediaObjectImpl("Leader 1 picture", "5.jpg", "alt text", "title text", false, false);;
        MultimediaObjectImpl image4 = new MultimediaObjectImpl("Leader 1 picture", "5.jpg", "alt text", "title text", false, false);;
        Set<MultimediaObjectImpl> multimedia = Sets.newTreeSet(Arrays.asList(image1, image2, image3, image4));
        
        MultimediaObjectImpl leaderImage1 = new MultimediaObjectImpl("Leader 1 picture", "5.jpg", "alt text", "title text", false, false);;
        MultimediaObjectImpl leaderImage2 = new MultimediaObjectImpl("Leader 2 picture", "5.jpg", "alt text", "title text", false, false);;
        LeaderImpl leader1 = new LeaderImpl("Leader 1", "Leader 1 bio", "Lead pastor", LeaderRole.PASTOR, leaderImage1, false, true, "test@test.com", "509-991-0195", 2005);        
        LeaderImpl leader2 = new LeaderImpl("Leader 2", "Leader 2 bio", "Community Pastor", LeaderRole.PASTOR, leaderImage2, true, false, "test2@test.com", "509-991-0111", 2010);
        Set<LeaderImpl> leadershipTeam = Sets.newTreeSet(Arrays.asList(leader1, leader2));
        
        Set<Programs> programsOffered = Sets.newTreeSet(Arrays.asList(Programs.ADDICTION_RECOVERY_COUNSELING, Programs.AGE_GROUPS_AND_CREATIVE_ARTS));
        Set<AccessibilitySupport> accessabilitysupport = Sets.newTreeSet(Arrays.asList(AccessibilitySupport.WHEELCHAIR_ACCESS, AccessibilitySupport.CARPOOL));
        
        OrganizationImpl organization = new OrganizationImpl(null, 1999, "test save time", "mission statement", "statement of faith", 
                "welcome Message", address, atmosphere, socialMedia, Affiliation.NONDENOMINATIONAL, Affiliation.NONE, null, multimedia, 
                leadershipTeam, programsOffered, accessabilitysupport);
        
        organizationDiscoveryService.saveOrganization(organization);
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
