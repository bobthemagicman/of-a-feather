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
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.flockspring.domain.OrganizationFilter;
import com.flockspring.domain.service.OrganizationDiscoveryService;
import com.flockspring.domain.service.UserService;
import com.flockspring.domain.types.AccessibilitySupport;
import com.flockspring.domain.types.Address;
import com.flockspring.domain.types.Affiliation;
import com.flockspring.domain.types.Category;
import com.flockspring.domain.types.Language;
import com.flockspring.domain.types.Programs;
import com.flockspring.domain.types.ServiceDay;
import com.flockspring.domain.types.impl.AddressImpl;
import com.flockspring.domain.types.impl.OrganizationImpl;
import com.flockspring.domain.types.impl.UpdateEmailImpl;
import com.flockspring.ui.mapper.CategoryUIMapConverter;
import com.flockspring.ui.mapper.OrganizationFilterMapper;
import com.flockspring.ui.mapper.SearchFilterUIModelMapper;
import com.flockspring.ui.mapper.SearchResultsUIModelMapper;
import com.flockspring.ui.model.AjaxSearchFilterResponse;
import com.flockspring.ui.model.CongregationSize;
import com.flockspring.ui.model.SearchFilterUICommand;
import com.flockspring.ui.model.SearchResultsUIModel;
import com.flockspring.ui.model.ServiceTimeRange;
import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderAddressComponent;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.LatLng;
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
public class SearchPageController
{
    /**
     * 
     */
    private static final String USER_KEY = "userKey";
    /**
     * 
     */
    private static final String LOCALITY = "locality";
    /**
     * 
     */
    private static final String POSTAL_CODE = "postal_code";
    private static final String VIEW_NAME = "searchResultsPage";
    private static final String ERROR_STATE_BAD_REGION = "user_search_out_of_region";
    private static final String ERROR_STATE_BAD_INPUT = "user_input_error";

    private final OrganizationDiscoveryService organizationDiscoveryService;
    private final SearchResultsUIModelMapper searchResultsModelMapper;
    private final OrganizationFilterMapper organizationFilterMapper;
    private final SearchFilterUIModelMapper searchFilterUIModelMapper;
    private final UserService userService;
    
    @Value("#{'${search.allowedZipCodes}'.split(',')}")
    private List<Integer> allowedZipCodeList;
    
    @Value("#{'${search.allowedCityNames}'.split(',')}")
    private List<String> allowedCityList;

    @Autowired
    public SearchPageController(final OrganizationDiscoveryService organizationDiscoveryService,
            final SearchResultsUIModelMapper searchResultsModelMapper, final OrganizationFilterMapper organizationFilterMapper,
            final SearchFilterUIModelMapper searchFilterUIModelMapper, final UserService userService)
    {
        super();

        this.organizationDiscoveryService = organizationDiscoveryService;
        this.searchResultsModelMapper = searchResultsModelMapper;
        this.organizationFilterMapper = organizationFilterMapper;
        this.searchFilterUIModelMapper = searchFilterUIModelMapper;
        this.userService = userService;
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam(value = "search-bar", required = false) String query,
            @RequestParam(value = "page", required = false, defaultValue = "0") String page, HttpSession session, HttpServletRequest request)
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
        } catch (NumberFormatException nfe)
        {
            // well fuck
        }

        // check for special characters

        Map<String, Object> model = new HashMap<>();

        String uuid = searchHelper.createAndSaveUUIDIfNoneExists();
        model.put(USER_KEY, uuid);
        
        final Geocoder geocoder = new Geocoder();
        GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(query).setLanguage("en").getGeocoderRequest();
        GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);

        List<GeocoderResult> googleResults = geocoderResponse.getResults();
        if (googleResults.size() != 1)
        {
            // return error state to search results page asking user to select
            // address
            
            //Store google call in session/cache to prevent additional call
            model.put("error", ERROR_STATE_BAD_INPUT);
            //Hardcoded to SF for now
            model.put("results", new SearchResultsUIModel(null, 0, 0L, 0, 0, 37.7749295, -122.4194155, query, 0));
            
            return buildSearchModelAndView(model);
        }

        //There can only be one result in the results list here 
        GeocoderResult resolvedResult = googleResults.get(0);
        if (resolvedResult == null || !queryInAllowedRegion(resolvedResult))
        {
            model.put("error", ERROR_STATE_BAD_REGION);
            model.put("results", new SearchResultsUIModel(null, 0, 0L, 0, 0, 37.7749295, -122.4194155, query, 0));
            
            String resolvedSearchTerm = getCityForSearchTerm(resolvedResult);
            model.put("errorSearchTerm", StringUtils.hasText(resolvedSearchTerm) ? resolvedSearchTerm : query);
            
            return buildSearchModelAndView(model);
        }

        Address address = mapGoogleResultToAddress(resolvedResult);

        GeoPage<OrganizationImpl> geoPageResult;
        if (!StringUtils.hasText(organizationFilter.getUserQuery()) && organizationFilter.getSearchPoint() == null)
        {
            geoPageResult = organizationDiscoveryService.searchForOrganizations(address, pageNum);
            searchHelper.setOrganizationFilter(new OrganizationFilter(null, null, null, null, null, null, null, null, null, null, false, address
                    .getLocation(), query));
        } else
        {
            geoPageResult = organizationDiscoveryService.getFilteredOrganizations(organizationFilter);
            SearchFilterUICommand searchFilterUIModel = searchFilterUIModelMapper.map(organizationFilter);
            model.put("filters", searchFilterUIModel);
        }

        SearchResultsUIModel searchResultsUIModel = searchResultsModelMapper.map(geoPageResult, address, request.getLocale(), query);
        model.put("results", searchResultsUIModel);
        model.put("paging", createPagingModel(geoPageResult));

        return buildSearchModelAndView(model);
    }

    private String getCityForSearchTerm(GeocoderResult resolvedResult)
    {
        return Strings.emptyToNull(findGeometryComponentFromResult(resolvedResult, LOCALITY));
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

        return new ModelAndView(VIEW_NAME, model);
    }

    private Address mapGoogleResultToAddress(GeocoderResult geocoderResult)
    {
        String streetNumber = "", route = "", postalCode = "", state = "", city = "", country = "";

        for (GeocoderAddressComponent component : geocoderResult.getAddressComponents())
        {
            switch (component.getTypes().get(0))
            {
                case POSTAL_CODE:
                    postalCode = component.getShortName();
                    break;

                case "country":
                    country = component.getShortName();
                    break;

                case "administrative_area_level_1":
                    state = component.getShortName();
                    break;

                case LOCALITY:
                    city = component.getShortName();
                    break;

                case "street_number":
                    streetNumber = component.getShortName();
                    break;

                case "route":
                    route = component.getShortName();
                    break;
            }
        }

        LatLng latLng = geocoderResult.getGeometry().getLocation();
        double[] location = new double[]
        {latLng.getLng().doubleValue(), latLng.getLat().doubleValue()};

        return new AddressImpl(new StringBuilder(streetNumber).append(route).toString(), "", postalCode, state, city, country, location);
    }

    private boolean queryInAllowedRegion(GeocoderResult result)
    {
            return this.allowedZipCodeList.contains(findGeometryComponentFromResult(result, POSTAL_CODE))
                    || this.allowedCityList.contains(findGeometryComponentFromResult(result, LOCALITY));
    }

    private String findGeometryComponentFromResult(GeocoderResult result, String componentName)
    {
        for (GeocoderAddressComponent component : result.getAddressComponents())
        {
            if (component.getTypes().contains(componentName))
            {
                return component.getLongName();
            }
        }

        return "";
    }

    private int createPagingModel(GeoPage<OrganizationImpl> geoPageResult)
    {
        if (geoPageResult.getTotalPages() > 9)
        {
            return 9;
        }

        return geoPageResult.getTotalPages();
    }

    private Map<Category<AccessibilitySupport>, Set<AccessibilitySupport>> getAccessibilitySupportValuesMap()
    {
        return new CategoryUIMapConverter<AccessibilitySupport>().convertCategoryToMap(AccessibilitySupport.values());
    }

    private Map<Category<Programs>, Set<Programs>> getProgramValuesMap()
    {
        return new CategoryUIMapConverter<Programs>().convertCategoryToMap(Programs.values());
    }

    @RequestMapping(value = "/ajax/out-of-region-search")
    public void saveUserEmail(@RequestParam(value = "email-address") String email, @RequestParam(value = "user-key") String userKey,
            @RequestParam(value = "user-search-city") String userSearchCity, HttpSession session, HttpServletRequest request)
    {
        SiteSearchHelper searchHelper = new SiteSearchHelper(session);
        String userKeyFromSession = searchHelper.getUUID();
        
        if(userKeyFromSession.equals(userKey))
        {
            userService.saveUpdateEmail(new UpdateEmailImpl(email, userSearchCity, new DateTime()));
        }
        else
        {
            //log event here for posterity
        }
    }
    
    @RequestMapping(value = "/ajax/filter-results", method = RequestMethod.POST, headers =
    { "content-type=application/json" })
    public @ResponseBody
    AjaxSearchFilterResponse ajaxResultsFilter(@RequestBody SearchFilterUICommand filterRequest, HttpSession session, HttpServletRequest request)
    {
        SiteSearchHelper searchHelper = new SiteSearchHelper(session);
        OrganizationFilter organizationFilter = searchHelper.getOrganizationFilterFromSession();
        organizationFilter = organizationFilterMapper.map(filterRequest, organizationFilter.getUserQuery());
        searchHelper.setOrganizationFilter(organizationFilter);

        GeoPage<OrganizationImpl> geoResult = organizationDiscoveryService.getFilteredOrganizations(organizationFilter);

        if (geoResult.getNumberOfElements() != 0)
        {

            SearchResultsUIModel searchResultUIModels = searchResultsModelMapper.map(geoResult, filterRequest, request.getLocale());
            AjaxSearchFilterResponse response = new AjaxSearchFilterResponse(searchResultUIModels);

            return response;
        }

        return new AjaxSearchFilterResponse();
    }
}
