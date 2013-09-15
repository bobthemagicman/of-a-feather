/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.flockspring.domain.service.OrganizationDiscoveryService;
import com.flockspring.domain.types.Affiliation;
import com.flockspring.domain.types.Organization;
import com.flockspring.ui.mapper.SearchResultsModelMapper;
import com.flockspring.ui.model.ImageUIModel;
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
    public ModelAndView search(@RequestParam String query, @RequestParam(required = false) String stubMode)
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

            List<Organization> organizations = organizationDiscoveryService.searchForOrganizations(query);
            results = searchResultsModelMapper.map(organizations);
        }

        return new ModelAndView("searchResultsPage", "results", results);
    }

    private NavigableSet<SearchResultUIModel> getStubbedOrganization()
    {
        NavigableSet<SearchResultUIModel> results = new TreeSet<SearchResultUIModel>();
        
        String serviceTimes = "Sunday 8:20, 9:00";
        ImageUIModel image = new ImageUIModel("This is the alt", "", "testImage.jpg", "This is the image title", 0, 0);
        
        results.add(new SearchResultUIModel(image, "Bob's Church of Christ", serviceTimes, Affiliation.BAPTISTS.getLocalizedStringCode(), 
                1, false, false));
        
        results.add(new SearchResultUIModel(image, "Ted's Church of Christ", serviceTimes, Affiliation.NONDENOMINATIONAL.getLocalizedStringCode(), 
                3, true, false));
        
        results.add(new SearchResultUIModel(image, "Roberts's Church of Christ", serviceTimes, Affiliation.BAPTISTS.getLocalizedStringCode(), 
                5, false, true));
        
        results.add(new SearchResultUIModel(image, "Larry's Church of Christ",  serviceTimes, Affiliation.NONDENOMINATIONAL.getLocalizedStringCode(), 
                2, false, false));
        
        results.add(new SearchResultUIModel(image, "Fred's Church of Christ",  serviceTimes, Affiliation.NONDENOMINATIONAL.getLocalizedStringCode(), 
                14, false, false));
        
        results.add(new SearchResultUIModel(image, "John's Church of Christ",  serviceTimes, Affiliation.NONDENOMINATIONAL.getLocalizedStringCode(), 
                19, false, false));
        
        results.add(new SearchResultUIModel(image, "Dave's Church of Christ",  serviceTimes, Affiliation.CATHOLICISM.getLocalizedStringCode(), 
                4, false, false));
        
        results.add(new SearchResultUIModel(image, "Terry's Church of Christ",  serviceTimes, Affiliation.CATHOLICISM.getLocalizedStringCode(), 
                20, false, true));
        
        results.add(new SearchResultUIModel(image, "James's Church of Christ",  serviceTimes, Affiliation.CATHOLICISM.getLocalizedStringCode(), 
                22, false, false));
        
        results.add(new SearchResultUIModel(image, "Mathew's Church of Christ",  serviceTimes, Affiliation.LUTHERANISM.getLocalizedStringCode(), 
                26, false, false));
        
        results.add(new SearchResultUIModel(image, "Don's Church of Christ",  serviceTimes, Affiliation.BAPTISTS.getLocalizedStringCode(), 
                15, false, false));
        
        results.add(new SearchResultUIModel(image, "Jerry's Church of Christ",  serviceTimes, Affiliation.BAPTISTS.getLocalizedStringCode(), 
                19, false, false));
        
        results.add(new SearchResultUIModel(image, "Tims's Church of Christ",  serviceTimes, Affiliation.NONDENOMINATIONAL.getLocalizedStringCode(), 
                12, false, false));
        
        results.add(new SearchResultUIModel(image, "Jed's Church of Christ",  serviceTimes, Affiliation.CATHOLICISM.getLocalizedStringCode(), 
                21, false, false));
        
        results.add(new SearchResultUIModel(image, "Bill's Church of Christ",  serviceTimes, Affiliation.BAPTISTS.getLocalizedStringCode(), 
                8, false, false));
        
        results.add(new SearchResultUIModel(image, "Gabe's Church of Christ",  serviceTimes, Affiliation.METHODISTS.getLocalizedStringCode(), 
                15, false, false));
        
        results.add(new SearchResultUIModel(image, "Carter's Church of Christ",  serviceTimes, Affiliation.NONDENOMINATIONAL.getLocalizedStringCode(), 
                20, false, false));
        
        results.add(new SearchResultUIModel(image, "Declan's Church of Christ",  serviceTimes, Affiliation.CATHOLICISM.getLocalizedStringCode(), 
                28, false, false));
        
        results.add(new SearchResultUIModel(image, "Braden's Church of Christ",  serviceTimes, Affiliation.CATHOLICISM.getLocalizedStringCode(), 
                11, false, false));
        
        results.add(new SearchResultUIModel(image, "Justin's Church of Christ",  serviceTimes, Affiliation.NONDENOMINATIONAL.getLocalizedStringCode(), 
                10, false, false));
        
        return results;
        
    }
}
