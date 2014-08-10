/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.mongodb.core.geo.GeoPage;
import org.springframework.data.mongodb.core.geo.GeoResult;
import org.springframework.stereotype.Component;

import com.flockspring.domain.types.Address;
import com.flockspring.domain.types.MultimediaObject;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.ServiceDetails;
import com.flockspring.domain.types.impl.AddressImpl;
import com.flockspring.domain.types.impl.ApplicationUserImpl;
import com.flockspring.domain.types.impl.Atmosphere;
import com.flockspring.domain.types.impl.OrganizationImpl;
import com.flockspring.ui.model.ChurchListingUIModel;
import com.flockspring.ui.model.MultimediaUIModel;
import com.flockspring.ui.model.SearchFilterUICommand;
import com.flockspring.ui.model.SearchResultsUIModel;

/**
 * SearchResultsModelMapper.java
 *
 * @author Justen L. Britain
 * @date Sep 15, 2013
 *
 */
@Component
public class SearchResultsUIModelMapper
{

    private MessageSource messageSource;
    private MultimediaUIModelMapper imageUIModelMapper;
    
    @Autowired    
    public SearchResultsUIModelMapper(MultimediaUIModelMapper imageUIModelMapper, MessageSource messageSource)
    {
        super();
        
        this.imageUIModelMapper = imageUIModelMapper;
        this.messageSource = messageSource;
    }

    public SearchResultsUIModel map(GeoPage<OrganizationImpl> geoPageResult, Address address, Locale locale, String query, ApplicationUserImpl user)
    {
        return map(geoPageResult, address, new SearchFilterUICommand(), locale, query, user);
    }

    public SearchResultsUIModel map(GeoPage<OrganizationImpl> geoPageResult, SearchFilterUICommand filterRequest, Locale locale, ApplicationUserImpl user)
    {
        AddressImpl address = new AddressImpl("", "", "", "", "", "", new double[]{filterRequest.getPoint().getX(), filterRequest.getPoint().getY()});
       
        return map(geoPageResult, address, filterRequest, locale, "", user);
    }
    
    private SearchResultsUIModel map(GeoPage<OrganizationImpl> geoPageResult, Address address, SearchFilterUICommand filterRequest, 
            Locale locale, String query, ApplicationUserImpl user)
    {
        
        NavigableSet<ChurchListingUIModel> results = new TreeSet<>();
        for(GeoResult<OrganizationImpl> geoResult : geoPageResult)
        {
            results.add(map(geoResult, filterRequest, locale, user));
        }
        
        int currentPage = geoPageResult.getNumber();
        long totalResults = geoPageResult.getTotalElements();
        int numResultsOnPage = geoPageResult.getNumberOfElements();
        int numResultsPerPage = geoPageResult.getSize();
        int totalNumberOfPages = geoPageResult.getTotalPages();
        int pageStartIndex = 1;
        
        if(!geoPageResult.isFirstPage())
        {
            pageStartIndex = (currentPage * numResultsPerPage); 
        }         
        
        int pageEndIndex = (pageStartIndex + numResultsOnPage) - 1;
        
        return new SearchResultsUIModel(results, currentPage, totalResults, pageStartIndex, pageEndIndex, 
                address.getLatitude(), address.getLongitude(), query, totalNumberOfPages);
    }

    public ChurchListingUIModel map(GeoResult<OrganizationImpl> geoResult, SearchFilterUICommand filterRequest, Locale locale, ApplicationUserImpl user)
    {
        return map(geoResult.getContent(), filterRequest, locale, geoResult.getDistance().getValue(), user);
    }

    /**
     * @param geoResult
     * @param filterRequest
     * @param locale
     * @param organization
     * @return
     */
    private ChurchListingUIModel map(Organization organization, SearchFilterUICommand filterRequest, Locale locale, double distanceValue,
            ApplicationUserImpl user)
    {
        Atmosphere atmosphere = organization.getAtmosphere();
        
        boolean userFavorited = false;
        if(user != null)
        {
            userFavorited = user.getFavoriteChurches() != null && user.getFavoriteChurches().contains(organization.getId());
        }

        
        MultimediaUIModel image = imageUIModelMapper.map(getPrimaryOrganizationImage(organization.getMultimedia()));
        Address address = organization.getAddress();
        ServiceDetails serviceDetails = getMatchingServiceDetails(atmosphere, filterRequest);
        String denominationString = messageSource.getMessage(organization.getDenomination().getLocalizedStringCode(), null, locale);
                
        return new ChurchListingUIModel(image, organization.getName(),  
                denominationString, organization.getId(), distanceValue,
                isOrganizationFeatured(organization), userFavorited, address.getCity(), 
                address.getState(), address.getPostalCode(), address.getLatitude(), address.getLongitude(), 
                getMusicStyleSliderValue(serviceDetails), getServiceStyleSliderValue(serviceDetails), 
                getDressAttireSliderValue(serviceDetails));
    }

    private ServiceDetails getMatchingServiceDetails(Atmosphere atmosphere, SearchFilterUICommand filterRequest)
    {
        ServiceDetails sd = null;
        Set<ServiceDetails> serviceDetailsSet = atmosphere.getServiceDetails();
        
        sd = findServiceDetailsFromSliderData(filterRequest.getAtmosphereServiceStyleFloor(), 
                filterRequest.getAtmosphereServiceStyleCeiling(), serviceDetailsSet);
        
        if(sd == null)
        {
            sd = findServiceDetailsFromSliderData(filterRequest.getAtmosphereMusicStyleFloor(), 
                    filterRequest.getAtmosphereServiceStyleCeiling(), serviceDetailsSet);
        }
        
        if(sd == null)
        {       
            sd = findServiceDetailsFromSliderData(filterRequest.getAtmosphereDressAttireFloor(), 
                    filterRequest.getAtmosphereDressAttireCeiling(), serviceDetailsSet);
        }
        
        if(sd == null)
        {
            //hack hack hack
            sd = atmosphere.getServiceDetails().iterator().next();
        }
        
        return sd;
    }

    private ServiceDetails findServiceDetailsFromSliderData(Integer floor, Integer ceiling, Set<ServiceDetails> serviceDetailsSet)
    {
        ServiceDetails serviceDetails = null;
        if(floor != null && floor != 0 && ceiling != null && ceiling != 0)
        {
            for(ServiceDetails sd : serviceDetailsSet)
            {
                int translatedSliderValue = sd.getDressAttire().ordinal() + 1;
                if(translatedSliderValue > floor && translatedSliderValue < ceiling) 
                {
                    serviceDetails = sd;
                }
            }
        }
        
        return serviceDetails;
    }

    private int getDressAttireSliderValue(ServiceDetails serviceDetails)
    {
        
        return serviceDetails.getDressAttire().getOrdinal() + 1;
    }

    private int getServiceStyleSliderValue(ServiceDetails serviceDetails)
    {

        return serviceDetails.getServiceStyle().ordinal() + 1;
    }

    private int getMusicStyleSliderValue(ServiceDetails serviceDetails)
    {

        return serviceDetails.getMusicStyle().ordinal() + 1;
    }

    private boolean isOrganizationFeatured(Organization organization)
    {
        // TODO Auto-generated method stub
        return false;
    }

    private MultimediaObject getPrimaryOrganizationImage(Set<MultimediaObject> images)
    {
        for(MultimediaObject i : images)
        {
            if(i.isPrimary())
            {
                return i;
            }
        }
        
        return images.isEmpty() ? null : images.iterator().next();
    }

    public List<ChurchListingUIModel> map(List<OrganizationImpl> organizations, Locale locale, ApplicationUserImpl user)
    {
        List<ChurchListingUIModel> churchListings = new ArrayList<>();
        if(organizations != null && !organizations.isEmpty())
        {
            for(OrganizationImpl org : organizations)
            {
                churchListings.add(this.map(org, new SearchFilterUICommand(), locale, 0, user));
            }
        }
        
        return churchListings;
    }
}
