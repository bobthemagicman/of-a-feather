/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

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

import com.flockspring.domain.OrganizationFilter;
import com.flockspring.domain.service.OrganizationDiscoveryService;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.impl.OrganizationImpl;
import com.flockspring.ui.mapper.SearchResultsUIModelMapper;
import com.flockspring.ui.model.AjaxSearchFilterRequest;
import com.flockspring.ui.model.AjaxSearchFilterResponse;
import com.flockspring.ui.model.SearchResultUIModel;
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
    private final static String RESULT_IDS = "resultIds";
    private final OrganizationDiscoveryService organizationDiscoveryService;
    private final SearchResultsUIModelMapper searchResultsModelMapper;

    @Autowired
    public SearchPageController(final OrganizationDiscoveryService organizationDiscoveryService,
            final SearchResultsUIModelMapper searchResultsModelMapper)
    {
        super();

        this.organizationDiscoveryService = organizationDiscoveryService;
        this.searchResultsModelMapper = searchResultsModelMapper;
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
        
        Map<String, Object> model = new HashMap<>();
        NavigableSet<SearchResultUIModel> results = new TreeSet<SearchResultUIModel>();

        // check for special characters
        if (!query.matches("\\d{5}") && !query.matches(".?\\s.?"))
        {
            // redirect to error page, likely a bad deeplink
        }

        GeoPage<OrganizationImpl> geoPageResult = organizationDiscoveryService.searchForOrganizations(query, pageNum);
//        storeResultIdsInSession(organizations, session);
        SearchResultsUIModel searchResultsUIModel = searchResultsModelMapper.map(geoPageResult);

        return new ModelAndView("searchResultsPage", "results", searchResultsUIModel);
    }

    private void storeResultIdsInSession(Set<Organization> organizations, HttpSession session)
    {
        @SuppressWarnings("unchecked")
        NavigableSet<String> resultIds = (NavigableSet<String>) session.getAttribute(RESULT_IDS);
        if (resultIds == null || resultIds.isEmpty())
        {
            resultIds = new TreeSet<>();
        }

        if (organizations != null && !organizations.isEmpty())
        {
            for (Organization o : organizations)
            {
                resultIds.add(o.getId());
            }
        }

        session.setAttribute(RESULT_IDS, resultIds);
    }

    @RequestMapping(value = "/ajax/filter-results", method = RequestMethod.POST, headers =
    { "content-type=application/json" })
    public @ResponseBody
    AjaxSearchFilterResponse ajaxResultsFilter(@RequestBody AjaxSearchFilterRequest filterRequest, HttpSession session)
    {

        @SuppressWarnings("unchecked")
        NavigableSet<String> resultIds = (NavigableSet<String>) session.getAttribute(RESULT_IDS);
        
        OrganizationFilter organizationFilter = new OrganizationFilter();
        NavigableSet<Organization> organizations = organizationDiscoveryService.getFilteredOrganizations(organizationFilter);
        if (organizations != null && !organizations.isEmpty())
        {

            Map<String, Organization> organizationMap = createOrganizationMap(organizations);
            NavigableSet<String> filteredResultIds = filterResultIdsWithRetrievedOrganizations(organizationMap, resultIds);
            GeoPage<OrganizationImpl> filteredOrganization = filterRetrievedOrganizationsWithResultIds(organizationMap, resultIds);

            //storeResultIdsInSession(filteredOrganization, session);
            SearchResultsUIModel searchResultUIModels = searchResultsModelMapper.map(filteredOrganization, filterRequest);
            AjaxSearchFilterResponse response = new AjaxSearchFilterResponse(filteredResultIds, searchResultUIModels);

            return response;
        }

        return new AjaxSearchFilterResponse();
    }

    private GeoPage<OrganizationImpl> filterRetrievedOrganizationsWithResultIds(Map<String, Organization> organizationMap,
            NavigableSet<String> resultIds)
    {
        NavigableSet<Organization> filteredOrganizations = new TreeSet<>();

        for (String s : resultIds)
        {
            if (organizationMap.containsKey(s))
            {
                filteredOrganizations.add(organizationMap.get(s));
            }
        }

        return null;
    }

    private NavigableSet<String> filterResultIdsWithRetrievedOrganizations(Map<String, Organization> organizationMap, NavigableSet<String> resultIds)
    {
        return null;
    }

    private Map<String, Organization> createOrganizationMap(Set<Organization> organizations)
    {
        Map<String, Organization> organizationMap = new HashMap<>();
        for (Organization o : organizations)
        {
            organizationMap.put(o.getId(), o);
        }
        return organizationMap;
    }

}
