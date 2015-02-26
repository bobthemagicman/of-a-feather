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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.Metrics;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.ofafeather.domain.OrganizationFilter;
import com.ofafeather.domain.service.GeoLocationService;
import com.ofafeather.domain.service.OrganizationDiscoveryService;
import com.ofafeather.domain.types.Address;
import com.ofafeather.domain.types.Affiliation;
import com.ofafeather.domain.types.Organization;
import com.ofafeather.domain.types.impl.ApplicationUserImpl;
import com.ofafeather.ui.IdentifiedPage;
import com.ofafeather.ui.exception.PageNotFoundException;
import com.ofafeather.ui.mapper.OrganizationUIModelMapper;

@Controller
@RequestMapping("/church-profile")
public class ProfilePageController extends IdentifiedPage
{
    private static final String VIEW_NAME = "profilePage";
    static final String PAGE_ID = "profile";

    private final OrganizationDiscoveryService organizationDiscoveryService;
    private final OrganizationUIModelMapper organizationUIModelMapper;
    private final GeoLocationService geoLocationService;
    
    @Autowired
    public ProfilePageController(final OrganizationDiscoveryService organizationDiscoveryService, final OrganizationUIModelMapper organizationUIModelMapper,
    		final GeoLocationService geoLocationService)
    {
        super();

        this.organizationUIModelMapper = organizationUIModelMapper;
        this.organizationDiscoveryService = organizationDiscoveryService;
        this.geoLocationService = geoLocationService;
    }
    
    // organization name based SEO url or region and denomination based SEO url
    @RequestMapping({"/{cityRegionName}-{stateAbrevRegionName}/{denomination}/{organizationName}", "/{cityRegionName}-{stateAbrevRegionName}/{organizationName}"})
    public ModelAndView renderOrganizationProfileByRegionAndName(final @PathVariable String cityName, final @PathVariable String stateAbrev,  
    		final @PathVariable String organizationName, final @AuthenticationPrincipal ApplicationUserImpl user, final @Valid @PathVariable Affiliation denomination,
            final HttpSession session, HttpServletRequest request)
    {

    	final Address address = geoLocationService.getAddressFromQuery(new StringBuilder(cityName).append(", ").append(stateAbrev).toString());
    	
    	Organization organization = organizationDiscoveryService.getOrganization(address, organizationName);
        
    	if(organization == null)
    	{
    		throw new PageNotFoundException("page.not.found.exception.no.such.organization");
    	}
    	
    	validateOrganizationDenomination(organization, denomination);
    	
    	String urlCriteria = String.format("organization with name: %1, in %2 %3", organizationName, cityName, stateAbrev);
        
        SiteSearchHelper searchHelper = new SiteSearchHelper(session);
        OrganizationFilter organizationFilter = searchHelper.getOrganizationFilterFromSession();
        
        double dist = getDistanceFromQuery(organization.getAddress(), organizationFilter.getSearchPoint());
        		
        return buildModelAndView(organization, dist, session, request.getLocale(), user, urlCriteria); 
    }

    private void validateOrganizationDenomination(final Organization organization, final Affiliation denomination)
    {
    	if("".equals(denomination) || denomination == null)
    	{
    		return ;
    	}
    	
    	Affiliation organizationAffiliation = organization.getDenomination();
    	boolean isChildAffiliation = Arrays.asList(organizationAffiliation.getChildAffiliations()).contains(organizationAffiliation);
	  
    	if(denomination != organizationAffiliation && !isChildAffiliation)
    	{
		   // Log this failure, something is trying to access a church by the correct name and wrong denomination.
    		throw new PageNotFoundException("page.not.found.exception.no.such.organization");
    	}
    }

	@Deprecated
    @RequestMapping("/{organizationId}")
    public String renderOrganizationProfileById(@AuthenticationPrincipal ApplicationUserImpl user,
            @PathVariable String organizationId, HttpSession session, HttpServletRequest request, HttpServletResponse response)
    {
		Organization organization = organizationDiscoveryService.getOrganization(organizationId);
		
		if(organization == null)
		{
			// log here, someone tried to access a church via id and it wasn't found
			throw new PageNotFoundException("page.not.found.no.organization.found.for.id");
		}
		
		String canonicalUrl = new StringBuilder(request.getContextPath())
				.append("/church-profile/")
				.append(organization.getAddress().getCity()).append("-")
				.append(organization.getAddress().getState().toUpperCase())
				.append("/")
				.append(getOrganizationNameForUrl(organization.getName()))
				.toString().toLowerCase();
		
        return "redirect: " + UriComponentsBuilder.fromPath(canonicalUrl);
    }

    private String getOrganizationNameForUrl(String name)
    {
	    String preparedName = name.replaceAll(" ", "_");
	    preparedName = preparedName.replaceAll("'", "");
	    preparedName = preparedName.replaceAll("&", "and");
	    
	    return preparedName;
    }

	private ModelAndView buildModelAndView(final Organization organization, final double distance, final HttpSession session, 
    		final  Locale locale, final ApplicationUserImpl user, final String urlCriteria)
    {
    	throwExceptionIfOrganizationIsNull(organization, urlCriteria);
    	
        SiteSearchHelper searchHelper = new SiteSearchHelper(session);
        
        Map<String, Object> model = new HashMap<>();
        model.put("organization", organizationUIModelMapper.map(organization, distance, locale, user));
        model.put("hasPreviousSearch", searchHelper.hasPreviousSearch());
        model.put("searchQuery", searchHelper.getSearchQuery());
        
        return new ModelAndView(VIEW_NAME, model);
    }

    private void throwExceptionIfOrganizationIsNull(Organization organization, String urlCriteria)
    {
        if (organization == null)
        {
            throw new PageNotFoundException("Unable to find profile for " + urlCriteria);
        }
    }
    
	private double getDistanceFromQuery(Address organizationAddress, Point queryPoint)
	{
		//TODO: fix for internationalization
		Metrics unit = Metrics.MILES;
		
		double orgLong = organizationAddress.getLongitude();
		double queryLong = queryPoint.getY();
		
		double orgLat = organizationAddress.getLatitude();
		double queryLat = queryPoint.getX();
		
		double theta = orgLong - queryLong;
		double dist = Math.sin(deg2rad(orgLat)) * Math.sin(deg2rad(queryLat))
		        + Math.cos(deg2rad(orgLat)) * Math.cos(deg2rad(queryLat))
		        * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		
		if (unit == Metrics.KILOMETERS)
		{
			dist = dist * 1.609344;
		} 
		
		return (dist);
	}

	private double deg2rad(double deg)
	{
		return (deg * Math.PI / 180.0);
	}

	private double rad2deg(double rad)
	{
		return (rad * 180.0 / Math.PI);
	}

    @Override
    protected String getPageId()
    {
        return PAGE_ID;
    }
}
