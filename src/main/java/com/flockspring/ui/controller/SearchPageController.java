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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.flockspring.domain.service.OrganizationDiscoveryService;
import com.flockspring.domain.types.Organization;
import com.flockspring.ui.mapper.SearchResultsModelMapper;
import com.flockspring.ui.model.AjaxSearchFilterRequest;
import com.flockspring.ui.model.AjaxSearchFilterResponse;
import com.flockspring.ui.model.SearchResultUIModel;

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
    private final SearchResultsModelMapper searchResultsModelMapper;

    @Autowired
    public SearchPageController(final OrganizationDiscoveryService organizationDiscoveryService,
            final SearchResultsModelMapper searchResultsModelMapper)
    {
        super();

        this.organizationDiscoveryService = organizationDiscoveryService;
        this.searchResultsModelMapper = searchResultsModelMapper;
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam(value = "search-bar") String query, HttpSession session)
    {
        Map<String, Object> model = new HashMap<>();
        NavigableSet<SearchResultUIModel> results = new TreeSet<SearchResultUIModel>();

        // check for special characters
        if (!query.matches("\\d{5}") && !query.matches(".?\\s.?"))
        {
            // redirect to error page, likely a bad deeplink
        }

        NavigableSet<Organization> organizations = organizationDiscoveryService.searchForOrganizations(query);
        storeResultIdsInSession(organizations, session);
        results = searchResultsModelMapper.map(organizations);

        model.put("results", results);
        model.put("totalNumberOfResults", 10);
        model.put("resultsPageStartNum", 10);
        model.put("resultsPageEndNum", 10);
        
        return new ModelAndView("searchResultsPage", model);
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
        NavigableSet<Organization> organizations = organizationDiscoveryService.getFilteredOrganizations(filterRequest);
        if (organizations != null && !organizations.isEmpty())
        {

            Map<String, Organization> organizationMap = createOrganizationMap(organizations);
            NavigableSet<String> filteredResultIds = filterResultIdsWithRetrievedOrganizations(organizationMap, resultIds);
            NavigableSet<Organization> filteredOrganization = filterRetrievedOrganizationsWithResultIds(organizationMap, resultIds);

            storeResultIdsInSession(filteredOrganization, session);
            NavigableSet<SearchResultUIModel> searchResultUIModels = searchResultsModelMapper.map(filteredOrganization);
            AjaxSearchFilterResponse response = new AjaxSearchFilterResponse(filteredResultIds, searchResultUIModels);

            return response;
        }

        return new AjaxSearchFilterResponse();
    }

    private NavigableSet<Organization> filterRetrievedOrganizationsWithResultIds(Map<String, Organization> organizationMap,
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

        return filteredOrganizations;
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
