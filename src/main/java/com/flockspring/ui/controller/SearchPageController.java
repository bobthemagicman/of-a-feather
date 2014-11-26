/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.geo.GeoPage;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.flockspring.domain.NoGeoLocationResultsException;
import com.flockspring.domain.OrganizationFilter;
import com.flockspring.domain.service.GeoLocationService;
import com.flockspring.domain.service.OrganizationDiscoveryService;
import com.flockspring.domain.service.user.UserService;
import com.flockspring.domain.types.AccessibilitySupport;
import com.flockspring.domain.types.Address;
import com.flockspring.domain.types.Affiliation;
import com.flockspring.domain.types.Category;
import com.flockspring.domain.types.Language;
import com.flockspring.domain.types.Programs;
import com.flockspring.domain.types.ServiceDay;
import com.flockspring.domain.types.impl.ApplicationUserImpl;
import com.flockspring.domain.types.impl.OrganizationImpl;
import com.flockspring.domain.types.impl.UpdateEmailImpl;
import com.flockspring.ui.IdentifiedPage;
import com.flockspring.ui.mapper.CategoryUIMapConverter;
import com.flockspring.ui.mapper.OrganizationFilterMapper;
import com.flockspring.ui.mapper.SearchFilterUIModelMapper;
import com.flockspring.ui.mapper.SearchResultsUIModelMapper;
import com.flockspring.ui.model.AsyncSearchFilterResponse;
import com.flockspring.ui.model.CongregationSize;
import com.flockspring.ui.model.SearchFilterUICommand;
import com.flockspring.ui.model.SearchResultsUIModel;
import com.flockspring.ui.model.ServiceTimeRange;
import com.google.common.base.Strings;

/**
 * SearchPageController.java
 * 
 * @author Justen L. Britain
 * @date May 18, 2013
 * 
 */
@Controller
@RequestMapping("/search")
public class SearchPageController extends IdentifiedPage
{
    private static final String USER_KEY = "userKey";
    private static final String VIEW_NAME = "searchResultsPage";
    private static final String ERROR_STATE_BAD_REGION = "user_search_out_of_region";
    private static final String ERROR_STATE_BAD_INPUT = "user_input_error";
    private static final String PAGE_ID = "search";

    private final OrganizationDiscoveryService organizationDiscoveryService;
    private final SearchResultsUIModelMapper searchResultsModelMapper;
    private final OrganizationFilterMapper organizationFilterMapper;
    private final SearchFilterUIModelMapper searchFilterUIModelMapper;
    private final UserService userService;
    private final GeoLocationService geoLocationService;
    
    @Value("#{'${search.allowedZipCodes}'.split(',')}")
    private List<Integer> allowedZipCodeList;
    
    @Value("#{'${search.allowedCityNames}'.split(',')}")
    private List<String> allowedCityList;

    @Autowired
    public SearchPageController(final OrganizationDiscoveryService organizationDiscoveryService,
            final SearchResultsUIModelMapper searchResultsModelMapper, final OrganizationFilterMapper organizationFilterMapper,
            final SearchFilterUIModelMapper searchFilterUIModelMapper, final UserService userService,
            final GeoLocationService geoLocationService)
    {
        super();

        this.organizationDiscoveryService = organizationDiscoveryService;
        this.searchResultsModelMapper = searchResultsModelMapper;
        this.organizationFilterMapper = organizationFilterMapper;
        this.searchFilterUIModelMapper = searchFilterUIModelMapper;
        this.userService = userService;
        this.geoLocationService = geoLocationService;
    }

    @RequestMapping("")
    public ModelAndView search(@RequestParam(value = "search-bar", required = false) String query,
            @RequestParam(value = "page", required = false, defaultValue = "0") String page, 
            @RequestParam(required=false, defaultValue="false") boolean showAll, 
            @AuthenticationPrincipal ApplicationUserImpl user, HttpSession session, HttpServletRequest request)
    {
        SiteSearchHelper searchHelper = new SiteSearchHelper(session);
        OrganizationFilter organizationFilter = searchHelper.getOrganizationFilterFromSession();
        
        if (!StringUtils.hasText(query) && !StringUtils.hasText(organizationFilter.getUserQuery()))
        {
            // return no results scenario here
        } else if (!StringUtils.hasText(query) && StringUtils.hasText(organizationFilter.getUserQuery()))
        {
            query = organizationFilter.getUserQuery();
        }

        int pageNum = 0;
        try
        {
            pageNum = Integer.parseInt(page);
            pageNum = pageNum > 1 ? pageNum - 1 : 0;
        } catch (NumberFormatException nfe)
        {
            // well fuck
        }

        // check for special characters

        Map<String, Object> model = new HashMap<>();

        String uuid = searchHelper.createAndSaveUUIDIfNoneExists();
        model.put(USER_KEY, uuid);
        
        Address address;
        
        try
        {
        	address = geoLocationService.getAddressFromQuery(query);
        }
        catch(NoGeoLocationResultsException nglre)
        {
        	// return error state to search results page asking user to select
            // address
            
            //Store google call in session/cache to prevent additional call
            model.put("error", ERROR_STATE_BAD_INPUT);
            //Hardcoded to SF for now
            model.put("results", new SearchResultsUIModel(null, 0, 0L, 0, 0, 37.7749295, -122.4194155, query, 0));
            
            return buildSearchModelAndView(model);
        }

        if (address == null || !queryInAllowedRegion(address))
        {
            model.put("error", ERROR_STATE_BAD_REGION);
            model.put("results", new SearchResultsUIModel(null, 0, 0L, 0, 0, 37.7749295, -122.4194155, query, 0));
            
            String resolvedSearchTerm = address != null ? address.getCity() : query;
            model.put("errorSearchTerm", StringUtils.hasText(resolvedSearchTerm) ? resolvedSearchTerm : query);
            
            return buildSearchModelAndView(model);
        }

        GeoPage<OrganizationImpl> geoPageResult;
        if(organizationFilter == null || Strings.isNullOrEmpty(organizationFilter.getUserQuery()) ||
                !organizationFilter.getUserQuery().equals(query))
        {
            Point point = new Point(address.getLongitude(), address.getLatitude());
            organizationFilter = new OrganizationFilter(query, point);
            searchHelper.setOrganizationFilter(organizationFilter);
        }
        
        if(!showAll)
        {
            geoPageResult = organizationDiscoveryService.getFilteredOrganizations(organizationFilter, pageNum);
        }
        else
        {
            geoPageResult = organizationDiscoveryService.getFilteredOrganizations(organizationFilter, pageNum, 1000);
        }
        
        SearchFilterUICommand searchFilterUIModel = searchFilterUIModelMapper.map(organizationFilter);
        SearchResultsUIModel searchResultsUIModel = searchResultsModelMapper.map(geoPageResult, address, request.getLocale(), query, user);
       
        model.put("filters", searchFilterUIModel);
        model.put("results", searchResultsUIModel);
        addPagingInfoToModel(geoPageResult, model);
        addPagingBaseUrlToModel(request, model);

        return buildSearchModelAndView(model);
    }

    private void addPagingBaseUrlToModel(HttpServletRequest request, Map<String, Object> model)
    {

        String queryString = request.getQueryString();
        String finalString = queryString;

        int start = queryString.indexOf("&page=");
        
        if(start != -1)
        {
            StringBuilder finalStringBuilder = new StringBuilder(queryString.substring(0, start))
                    .append(queryString.substring(start + 7));
            
            finalString = finalStringBuilder.toString();
        }
        
        model.put("pageRequestQueryString", finalString);
        
    }

    private ModelAndView buildSearchModelAndView(Map<String, Object> model)
    {
        // Enum values for filters
        model.put("denominationValues", Affiliation.values());
        model.put("serviceTimeRangeValues", ServiceTimeRange.values());
        model.put("serviceDayValues", ServiceDay.values());
        model.put("congregationSizeValues", CongregationSize.values());
        model.put("programsValues", getProgramValuesMap());
        model.put("accessibilitySupportValues", getAccessibilitySupportValuesMap());
        model.put("languageValues", Language.values());
        model.put("nurseryValues", Arrays.asList(Programs.INFANT_CARE, Programs.TODDLER_CARE));
        model.put("educationValues", Arrays.asList(Programs.SENIOR_GROUP, Programs.BIBLE_STUDY, Programs.SPIRITUAL_CLASSES, Programs.ADULT_EDUCATION));
        model.put("navSearchEnabled", true);

        return new ModelAndView(VIEW_NAME, model);
    }

    private boolean queryInAllowedRegion(Address address)
    {
            return this.allowedZipCodeList.contains(address.getPostalCode())
                    || this.allowedCityList.contains(address.getFullState());
    }

    private void addPagingInfoToModel(GeoPage<OrganizationImpl> geoPageResult, Map<String, Object> model)
    {
        //TODO: put this in configuration somewhere
        final int totalNumPages = geoPageResult.getTotalPages();
        final int numberOfPagesToDisplay = totalNumPages > 9 ? 10 : totalNumPages;
        
        model.put("numberOfPagesToDisplay", numberOfPagesToDisplay);        
    }

    private Map<Category<AccessibilitySupport>, Set<AccessibilitySupport>> getAccessibilitySupportValuesMap()
    {
        return new CategoryUIMapConverter<AccessibilitySupport>().convertCategoryToMap(AccessibilitySupport.values());
    }

    private Map<Category<Programs>, Set<Programs>> getProgramValuesMap()
    {
        return new CategoryUIMapConverter<Programs>().convertCategoryToMap(Programs.values());
    }

    @RequestMapping(value = "/async/out-of-region-search")
    public void saveUserEmail(@RequestParam(value = "email-address") String email, @RequestParam(value = "user-key") String userKey,
            @RequestParam(value = "user-search-city") String userSearchCity, HttpSession session, HttpServletRequest request)
    {
        SiteSearchHelper searchHelper = new SiteSearchHelper(session);
        String userKeyFromSession = searchHelper.getUUID();
        
        if(userKeyFromSession != null && userKeyFromSession.equals(userKey))
        {
            userService.saveUpdateEmail(new UpdateEmailImpl(email, userSearchCity, new DateTime()));
        }
        else
        {
            //log event here for posterity
        }
    }
    
    @RequestMapping(value = "/async/filter-results", method = RequestMethod.POST, headers =
    { "content-type=application/json" })
    public @ResponseBody
    AsyncSearchFilterResponse ajaxResultsFilter(@RequestBody SearchFilterUICommand filterRequest, @AuthenticationPrincipal ApplicationUserImpl user,
            HttpSession session, HttpServletRequest request)
    {
        SiteSearchHelper searchHelper = new SiteSearchHelper(session);
        OrganizationFilter organizationFilter = searchHelper.getOrganizationFilterFromSession();
        organizationFilter = organizationFilterMapper.map(filterRequest, organizationFilter.getUserQuery());
        searchHelper.setOrganizationFilter(organizationFilter);

        GeoPage<OrganizationImpl> geoResult = organizationDiscoveryService.getFilteredOrganizations(organizationFilter, 0);

        if (geoResult.getNumberOfElements() != 0)
        {

            SearchResultsUIModel searchResultUIModels = searchResultsModelMapper.map(geoResult, filterRequest, request.getLocale(), user);
            
            String statusMessage = String.format("Returning %s church listings for query" , searchResultUIModels.getChurchListings().size());
            AsyncSearchFilterResponse response = new AsyncSearchFilterResponse(searchResultUIModels, statusMessage);

            return response;
        }

        return new AsyncSearchFilterResponse();
    }

    @Override
    protected String getPageId()
    {
        return PAGE_ID;
    }
}
