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

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ofafeather.domain.service.GeoLocationService;
import com.ofafeather.domain.service.OrganizationDiscoveryService;
import com.ofafeather.domain.types.Address;
import com.ofafeather.domain.types.Affiliation;
import com.ofafeather.domain.types.Organization;
import com.ofafeather.ui.IdentifiedPage;

/**
 * RegionPageController.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
@Controller
public class RegionPageController extends IdentifiedPage
{

    private static final String PAGE_ID = "region";

    private final OrganizationDiscoveryService organizationDiscoveryService;
    private final GeoLocationService geoLocationService;
    
    @Autowired
    public RegionPageController(final OrganizationDiscoveryService organizationDiscoveryService, final GeoLocationService geoLocationService)
    {
	    this.organizationDiscoveryService = organizationDiscoveryService;
	    this.geoLocationService = geoLocationService;
    }
    
    @RequestMapping("/{cityName}-{stateAbrev}-churches")
    public ModelAndView renderCityRegionPage(final @PathVariable String cityName, final @PathVariable String stateAbrev) 
    {
    	ModelAndView cityStateRegionPageView = new ModelAndView("cityStateRegionPage");
    	
    	final Address address = geoLocationService.getAddressFromQuery(new StringBuilder(cityName).append(", ").append(stateAbrev).toString());
    	
    	addOrganizationInformationToModel(cityStateRegionPageView.getModel(), address);
    	
    	return cityStateRegionPageView;
    }
    
	@RequestMapping("/{cityName}-{stateAbrev}/{churchType}-churches")
    public ModelAndView renderNeighborhoodRegionPage(final @PathVariable String cityName, final @PathVariable String stateAbrev,
    		final @PathVariable String churchType) 
    {
    	//churchType can be either denomination or neighborhood
    	ModelAndView mav = attemptToRenderAffiliationRegionPage(cityName, stateAbrev, churchType);
    	
    	if(mav == null) 
    	{
    		mav = attemptToRenderNeighborhoodRegionPage(cityName, stateAbrev, churchType); 
    	}
    	
    	return mav;
    }
    
	private ModelAndView attemptToRenderNeighborhoodRegionPage(final String cityName, final String stateAbrev, final String churchType)
    {
		final Address address = geoLocationService.getAddressFromQuery(new StringBuilder(churchType).append(" ").append(cityName).append(", ").append(stateAbrev).toString());
		
		ModelAndView neighborhoodRegionView = new ModelAndView("neighborhoodRegionPage");
		addOrganizationInformationToModel(neighborhoodRegionView.getModel(), address);
		
	    return neighborhoodRegionView;
    }

	private ModelAndView attemptToRenderAffiliationRegionPage(final String cityName, final String stateAbrev, final String churchType)
    {
		final Affiliation affiliation = attemptToDeriveAffiliationFromParameter(churchType);
		
		if(affiliation == null)
		{
			return null;
		}
		
		final Address address = geoLocationService.getAddressFromQuery(new StringBuilder(cityName).append(", ").append(stateAbrev).toString());
    	
		//TODO: this will need fixed for internatinoalization
		/*
		 * Chagne address to have functions, getShortFormat, getLongFormat, getCityState etc and use 
		 * it here.
		 */
    	final String cityState = new StringBuilder(address.getCity()).append(", ").append(address.getState()).toString();
    	
		ModelAndView denominationModelAndView = new ModelAndView("denominationRegionPage");
		addOrganizationInformationToModel(denominationModelAndView.getModel(), address);
	    addBreadcrumbHeiarchyToModel(denominationModelAndView, getPair(address.getCountry(), false), getPair(cityState, false), getPair(affiliation.getLocalizedStringCode(), true));
	    
		return denominationModelAndView;
    }

	private Affiliation attemptToDeriveAffiliationFromParameter(final String churchType)
    {
 		try
		{
			return Affiliation.valueOf(churchType.toUpperCase());
		}
		catch(Exception e)
		{
			return null;
		}
    }

	private void addOrganizationInformationToModel(final Map<String, Object> model, final Address address)
    {
    	List<Organization> regionOrganizations = organizationDiscoveryService.getOrganizationsForRegion(address);
    	model.put("organizations", regionOrganizations);
    	model.put("totalOrganizations", regionOrganizations.size());
    }
	 
	@Override
    protected String getPageId()
    {
        return PAGE_ID;
    }
}
