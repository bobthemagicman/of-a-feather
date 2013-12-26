/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.flockspring.dataaccess.service.client.MapQuestServiceClient;
import com.flockspring.dataaccess.service.client.USPSAddressAPIService;
import com.flockspring.domain.OrganizationFilter;
import com.flockspring.domain.service.OrganizationDiscoveryService;
import com.flockspring.domain.types.Address;
import com.flockspring.domain.types.impl.AddressImpl;
import com.flockspring.domain.types.impl.OrganizationImpl;
import com.flockspring.ui.mapper.OrganizationFilterMapper;
import com.flockspring.ui.mapper.SearchResultsUIModelMapper;
import com.flockspring.ui.model.AjaxSearchFilterRequest;
import com.flockspring.ui.model.AjaxSearchFilterResponse;
import com.flockspring.ui.model.SearchResultsUIModel;

/**
 * SearchPageController.java
 * 
 * @author Justen L. Britain
 * @date May 18, 2013
 * 
 */
@Controller
@RequestMapping("/search")
public class SearchPageController
{
    private final OrganizationDiscoveryService organizationDiscoveryService;
    private final SearchResultsUIModelMapper searchResultsModelMapper;
    private final OrganizationFilterMapper organizationFilterMapper;
    private final MapQuestServiceClient mapQuestServiceClient;
    private final USPSAddressAPIService uspsAddressAPIService;

    @Autowired
    public SearchPageController(final OrganizationDiscoveryService organizationDiscoveryService,
            final SearchResultsUIModelMapper searchResultsModelMapper, final OrganizationFilterMapper organizationFilterMapper,
            final MapQuestServiceClient mapQuestServiceClient, final USPSAddressAPIService uspsAddressAPIService)
    {
        super();

        this.organizationDiscoveryService = organizationDiscoveryService;
        this.searchResultsModelMapper = searchResultsModelMapper;
        this.organizationFilterMapper = organizationFilterMapper;
        this.mapQuestServiceClient = mapQuestServiceClient;
        this.uspsAddressAPIService = uspsAddressAPIService;
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam(value = "search-bar") String query, 
            @RequestParam(value = "page", required = false, defaultValue = "0") String page, HttpSession session)
    {
        int pageNum = 0;
        try
        {
            pageNum = Integer.parseInt(page);
        }
        catch(NumberFormatException nfe)
        {
            //well fuck
        }
        
        // check for special characters
        if (!query.matches("\\d{5}") && !query.matches(".?\\s.?"))
        {
            // redirect to error page, likely a bad deeplink
        }

        //Address address = verifyQuery(query.trim());
        Address address = new AddressImpl("", "", "98052", "WA", "REDMOND", "USA", new double[]{0.0, 0.0});
        address = mapQuestServiceClient.getAddressGeoCode(address);
        
        GeoPage<OrganizationImpl> geoPageResult = organizationDiscoveryService.searchForOrganizations(address, pageNum);
        SearchResultsUIModel searchResultsUIModel = searchResultsModelMapper.map(geoPageResult, address);

        return new ModelAndView("searchResultsPage", "results", searchResultsUIModel);
    }

    @RequestMapping(value = "/ajax/filter-results", method = RequestMethod.POST, headers =
    { "content-type=application/json" })
    public @ResponseBody
    AjaxSearchFilterResponse ajaxResultsFilter(@RequestBody AjaxSearchFilterRequest filterRequest, HttpSession session)
    {

        OrganizationFilter organizationFilter = organizationFilterMapper.map(filterRequest);
        GeoPage<OrganizationImpl> geoResult = organizationDiscoveryService.getFilteredOrganizations(organizationFilter);
        
        if (geoResult.getNumberOfElements() != 0)
        {

            SearchResultsUIModel searchResultUIModels = searchResultsModelMapper.map(geoResult, filterRequest);
            AjaxSearchFilterResponse response = new AjaxSearchFilterResponse(searchResultUIModels);

            return response;
        }

        return new AjaxSearchFilterResponse();
    }

    private Address verifyQuery(String query)
    {
        
        if(query.matches("\\d{5}"))
        {
            Address address = new AddressImpl("", "", query, "", "", "", new double[]{0, 0});
            return uspsAddressAPIService.lookupCityState(address);
        }
        else if(query.matches(".?\\s"))
        {
            String city = "";
            String state = "";
            String address1 = "";
            String address2 = "";
            
            //Just city and state <--if there is a comment you need to break up the code
            if(query.matches("\\w{2}")){
                
                String[] parts = query.split("(\\w)(\\s+)([\\.,])");                
                if(parts.length > 0)
                {
                    city = parts[0];
                }
                
                if(parts.length > 1)
                {
                    state = parts[1];
                }
            }
           
            Address address = new AddressImpl(address1, address2, "", state, city, "USA", new double[]{0, 0});
            return uspsAddressAPIService.lookupZip(address);
        }
        
        return null;
    }
}
