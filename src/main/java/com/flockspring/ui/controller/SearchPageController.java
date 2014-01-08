/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
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

import scala.sys.process.processInternal;

import com.flockspring.dataaccess.service.client.MapQuestServiceClient;
import com.flockspring.dataaccess.service.client.USPSAddressAPIService;
import com.flockspring.domain.OrganizationFilter;
import com.flockspring.domain.service.OrganizationDiscoveryService;
import com.flockspring.domain.types.AccessibilitySupport;
import com.flockspring.domain.types.Address;
import com.flockspring.domain.types.Affiliation;
import com.flockspring.domain.types.Category;
import com.flockspring.domain.types.Language;
import com.flockspring.domain.types.Programs;
import com.flockspring.domain.types.ServiceDay;
import com.flockspring.domain.types.impl.AddressImpl;
import com.flockspring.domain.types.impl.OrganizationImpl;
import com.flockspring.ui.mapper.CategoryUIMapConverter;
import com.flockspring.ui.mapper.OrganizationFilterMapper;
import com.flockspring.ui.mapper.SearchFilterUIModelMapper;
import com.flockspring.ui.mapper.SearchResultsUIModelMapper;
import com.flockspring.ui.model.AjaxSearchFilterResponse;
import com.flockspring.ui.model.CongregationSize;
import com.flockspring.ui.model.SearchFilterUICommand;
import com.flockspring.ui.model.SearchResultsUIModel;
import com.flockspring.ui.model.ServiceTimeRange;

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
    private static final String ORG_FILTER = "com.flockspring.organization.filters";
    
    private final OrganizationDiscoveryService organizationDiscoveryService;
    private final SearchResultsUIModelMapper searchResultsModelMapper;
    private final OrganizationFilterMapper organizationFilterMapper;
    private final MapQuestServiceClient mapQuestServiceClient;
    private final USPSAddressAPIService uspsAddressAPIService;
    private final SearchFilterUIModelMapper searchFilterUIModelMapper;
    
    @Autowired
    public SearchPageController(final OrganizationDiscoveryService organizationDiscoveryService,
            final SearchResultsUIModelMapper searchResultsModelMapper, final OrganizationFilterMapper organizationFilterMapper,
            final MapQuestServiceClient mapQuestServiceClient, final USPSAddressAPIService uspsAddressAPIService, 
            final SearchFilterUIModelMapper searchFilterUIModelMapper)
    {
        super();

        this.organizationDiscoveryService = organizationDiscoveryService;
        this.searchResultsModelMapper = searchResultsModelMapper;
        this.organizationFilterMapper = organizationFilterMapper;
        this.mapQuestServiceClient = mapQuestServiceClient;
        this.uspsAddressAPIService = uspsAddressAPIService;
        this.searchFilterUIModelMapper = searchFilterUIModelMapper;
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam(value = "search-bar") String query, 
            @RequestParam(value = "page", required = false, defaultValue = "0") String page, HttpSession session,
            HttpServletRequest request)
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

        Map<String, Object> model = new HashMap<>();
        
        //Address address = verifyQuery(query.trim());
        Address address = new AddressImpl("", "", "98052", "WA", "REDMOND", "USA", new double[]{0.0, 0.0});
        address = mapQuestServiceClient.getAddressGeoCode(address);
        
        OrganizationFilter organizationFilter = (OrganizationFilter) session.getAttribute(ORG_FILTER);
        
        GeoPage<OrganizationImpl> geoPageResult;
        if(organizationFilter == null)
        {
            geoPageResult = organizationDiscoveryService.searchForOrganizations(address, pageNum);
        }
        else
        {
            geoPageResult = organizationDiscoveryService.getFilteredOrganizations(organizationFilter);
            SearchFilterUICommand searchFilterUIModel = searchFilterUIModelMapper.map(organizationFilter);
            model.put("filters", searchFilterUIModel);
        }
        
        SearchResultsUIModel searchResultsUIModel = searchResultsModelMapper.map(geoPageResult, address, request.getLocale());
        model.put("results", searchResultsUIModel);
        
        //Enum values for filters
        model.put("denominationValues", Affiliation.values());
        model.put("serviceTimeRangeValues", ServiceTimeRange.values());
        model.put("serviceDayValues", ServiceDay.values());
        model.put("congregationSizeValues", CongregationSize.values());
        model.put("programsValues", getProgramValuesMap());
        model.put("accessibilitySupportValues", getAccessibilitySupportValuesMap());
        model.put("languageValues", Language.values());
        model.put("nurseryValues", Arrays.asList(Programs.INFANT_CARE, Programs.TODDLER_CARE));
        model.put("educationValues", Arrays.asList(Programs.SENIOR_GROUP, Programs.BIBLE_STUDY, Programs.SPIRITUAL_CLASSES, Programs.ADULT_EDUCATION));
            
        return new ModelAndView("searchResultsPage", model);
    }

    private Map<Category<AccessibilitySupport>, Set<AccessibilitySupport>> getAccessibilitySupportValuesMap()
    {
        return new CategoryUIMapConverter<AccessibilitySupport>().convertCategoryToMap(AccessibilitySupport.values());
    }

    private Map<Category<Programs>, Set<Programs>> getProgramValuesMap()
    {
        return new CategoryUIMapConverter<Programs>().convertCategoryToMap(Programs.values());
    }

    @RequestMapping(value = "/ajax/filter-results", method = RequestMethod.POST, headers = { "content-type=application/json" })
    public @ResponseBody AjaxSearchFilterResponse ajaxResultsFilter(@RequestBody SearchFilterUICommand filterRequest, HttpSession session, 
            HttpServletRequest request)
    {

        OrganizationFilter organizationFilter = organizationFilterMapper.map(filterRequest);
        session.setAttribute(ORG_FILTER, organizationFilter);
        GeoPage<OrganizationImpl> geoResult = organizationDiscoveryService.getFilteredOrganizations(organizationFilter);
        
        if (geoResult.getNumberOfElements() != 0)
        {

            SearchResultsUIModel searchResultUIModels = searchResultsModelMapper.map(geoResult, filterRequest, request.getLocale());
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
