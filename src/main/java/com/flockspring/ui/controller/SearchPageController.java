/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.flockspring.domain.service.OrganizationDiscoveryService;
import com.flockspring.domain.types.Affiliation;
import com.flockspring.domain.types.Organization;
import com.flockspring.ui.mapper.SearchResultsModelMapper;
import com.flockspring.ui.model.AjaxSearchFilterRequest;
import com.flockspring.ui.model.AjaxSearchFilterResponse;
import com.flockspring.ui.model.ImageUIModel;
import com.flockspring.ui.model.SearchResultUIModel;
import com.flockspring.ui.model.ServiceTime;
import com.google.common.collect.Sets;

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
    public ModelAndView search(@RequestParam String query, @RequestParam(required = false) String stubMode, HttpSession session)
    {
        NavigableSet<SearchResultUIModel> results = new TreeSet<SearchResultUIModel>();
        if (StringUtils.hasText(stubMode))
        {
            for (int x = 20; x > 0; x--)
            {
                results = getStubbedOrganization();
            }
        } else
        {
            // check for special characters
            if (!query.matches("\\d{5}") && !query.matches(".?\\s.?"))
            {
                // redirect to error page, likely a bad deeplink
            }

            NavigableSet<Organization> organizations = organizationDiscoveryService.searchForOrganizations(query);
            storeResultIdsInSession(organizations, session);
            results = searchResultsModelMapper.map(organizations);
        }

        return new ModelAndView("searchResultsPage", "results", results);
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

    @RequestMapping("/search/ajax/filter-results")
    public @ResponseBody AjaxSearchFilterResponse ajaxResultsFilter(@RequestBody AjaxSearchFilterRequest filterRequest, HttpSession session)
    {
        
        @SuppressWarnings("unchecked")
        NavigableSet<String> resultIds = (NavigableSet<String>) session.getAttribute(RESULT_IDS);
        NavigableSet<Organization> organizations = organizationDiscoveryService.getFilteredOrganizations(filterRequest);
        if(organizations != null && !organizations.isEmpty())
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

    private NavigableSet<Organization> filterRetrievedOrganizationsWithResultIds(Map<String, Organization> organizationMap, NavigableSet<String> resultIds)
    {
        NavigableSet<Organization> filteredOrganizations = new TreeSet<>();
        
        for(String s: resultIds)
        {
            if(organizationMap.containsKey(s))
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
        for(Organization o : organizations)
        {
            organizationMap.put(o.getId(), o);
        }
        return organizationMap;
    }

    private NavigableSet<SearchResultUIModel> getStubbedOrganization()
    {
        NavigableSet<SearchResultUIModel> results = new TreeSet<SearchResultUIModel>();

        Set<ServiceTime> serviceTimes = Sets.immutableEnumSet(Arrays.asList(ServiceTime.EARLY_MORNING, ServiceTime.MID_MORNING));
        ImageUIModel image = new ImageUIModel("This is the alt", "", "testImage.jpg", "This is the image title", 0, 0);

        results.add(new SearchResultUIModel(image, "Bob's Church of Christ", serviceTimes, Affiliation.BAPTISTS.getLocalizedStringCode(), 1, false,
                false));

        results.add(new SearchResultUIModel(image, "Ted's Church of Christ", serviceTimes, Affiliation.NONDENOMINATIONAL.getLocalizedStringCode(), 3,
                true, false));

        results.add(new SearchResultUIModel(image, "Roberts's Church of Christ", serviceTimes, Affiliation.BAPTISTS.getLocalizedStringCode(), 5,
                false, true));

        results.add(new SearchResultUIModel(image, "Larry's Church of Christ", serviceTimes, Affiliation.NONDENOMINATIONAL.getLocalizedStringCode(),
                2, false, false));

        results.add(new SearchResultUIModel(image, "Fred's Church of Christ", serviceTimes, Affiliation.NONDENOMINATIONAL.getLocalizedStringCode(),
                14, false, false));

        results.add(new SearchResultUIModel(image, "John's Church of Christ", serviceTimes, Affiliation.NONDENOMINATIONAL.getLocalizedStringCode(),
                19, false, false));

        results.add(new SearchResultUIModel(image, "Dave's Church of Christ", serviceTimes, Affiliation.CATHOLICISM.getLocalizedStringCode(), 4,
                false, false));

        results.add(new SearchResultUIModel(image, "Terry's Church of Christ", serviceTimes, Affiliation.CATHOLICISM.getLocalizedStringCode(), 20,
                false, true));

        results.add(new SearchResultUIModel(image, "James's Church of Christ", serviceTimes, Affiliation.CATHOLICISM.getLocalizedStringCode(), 22,
                false, false));

        results.add(new SearchResultUIModel(image, "Mathew's Church of Christ", serviceTimes, Affiliation.LUTHERANISM.getLocalizedStringCode(), 26,
                false, false));

        results.add(new SearchResultUIModel(image, "Don's Church of Christ", serviceTimes, Affiliation.BAPTISTS.getLocalizedStringCode(), 15, false,
                false));

        results.add(new SearchResultUIModel(image, "Jerry's Church of Christ", serviceTimes, Affiliation.BAPTISTS.getLocalizedStringCode(), 19,
                false, false));

        results.add(new SearchResultUIModel(image, "Tims's Church of Christ", serviceTimes, Affiliation.NONDENOMINATIONAL.getLocalizedStringCode(),
                12, false, false));

        results.add(new SearchResultUIModel(image, "Jed's Church of Christ", serviceTimes, Affiliation.CATHOLICISM.getLocalizedStringCode(), 21,
                false, false));

        results.add(new SearchResultUIModel(image, "Bill's Church of Christ", serviceTimes, Affiliation.BAPTISTS.getLocalizedStringCode(), 8, false,
                false));

        results.add(new SearchResultUIModel(image, "Gabe's Church of Christ", serviceTimes, Affiliation.METHODISTS.getLocalizedStringCode(), 15,
                false, false));

        results.add(new SearchResultUIModel(image, "Carter's Church of Christ", serviceTimes, Affiliation.NONDENOMINATIONAL.getLocalizedStringCode(),
                20, false, false));

        results.add(new SearchResultUIModel(image, "Declan's Church of Christ", serviceTimes, Affiliation.CATHOLICISM.getLocalizedStringCode(), 28,
                false, false));

        results.add(new SearchResultUIModel(image, "Braden's Church of Christ", serviceTimes, Affiliation.CATHOLICISM.getLocalizedStringCode(), 11,
                false, false));

        results.add(new SearchResultUIModel(image, "Justin's Church of Christ", serviceTimes, Affiliation.NONDENOMINATIONAL.getLocalizedStringCode(),
                10, false, false));

        return results;

    }
}
