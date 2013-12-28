/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.mapper;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoPage;
import org.springframework.data.mongodb.core.geo.GeoResult;
import org.springframework.stereotype.Component;

import com.flockspring.domain.types.Address;
import com.flockspring.domain.types.MultimediaObject;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.ServiceDetails;
import com.flockspring.domain.types.impl.AddressImpl;
import com.flockspring.domain.types.impl.Atmosphere;
import com.flockspring.domain.types.impl.OrganizationImpl;
import com.flockspring.ui.model.SearchFilterUICommand;
import com.flockspring.ui.model.MultimediaUIModel;
import com.flockspring.ui.model.SearchResultUIModel;
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

    private MultimediaUIModelMapper imageUIModelMapper;
    
    @Autowired    
    public SearchResultsUIModelMapper(MultimediaUIModelMapper imageUIModelMapper)
    {
        super();
        
        this.imageUIModelMapper = imageUIModelMapper;
    }

    public SearchResultsUIModel map(GeoPage<OrganizationImpl> geoPageResult, Address address)
    {
        return map(geoPageResult, address, new SearchFilterUICommand());
    }

    public SearchResultsUIModel map(GeoPage<OrganizationImpl> geoPageResult, SearchFilterUICommand filterRequest)
    {
        AddressImpl address = new AddressImpl("", "", "", "", "", "", filterRequest.getLocation());
       
        return map(geoPageResult, address, filterRequest);
    }
    
    private SearchResultsUIModel map(GeoPage<OrganizationImpl> geoPageResult, Address address, SearchFilterUICommand filterRequest)
    {
        
        NavigableSet<SearchResultUIModel> results = new TreeSet<>();
        for(GeoResult<OrganizationImpl> geoResult : geoPageResult)
        {
            results.add(map(geoResult, filterRequest));
        }
        
        int currentPage = geoPageResult.getNumber();
        long totalResults = geoPageResult.getTotalElements();
        int numResultsOnPage = geoPageResult.getNumberOfElements();
        int numResultsPerPage = geoPageResult.getSize();
        
        int pageStartIndex = 1;
        if(!geoPageResult.isFirstPage())
        {
            pageStartIndex = (currentPage * numResultsPerPage); 
        }         
        
        int pageEndIndex = (pageStartIndex + numResultsOnPage) - 1;
        
        return new SearchResultsUIModel(results, currentPage, totalResults, pageStartIndex, pageEndIndex, 
                address.getLatitude(), address.getLongitude());
    }

    public SearchResultUIModel map(GeoResult<OrganizationImpl> geoResult, SearchFilterUICommand filterRequest)
    {
        
        Organization organization = geoResult.getContent();
        Atmosphere atmosphere = organization.getAtmosphere();
        
        MultimediaUIModel image = imageUIModelMapper.map(getPrimaryOrganizationImage(organization.getMultimedia()));
        Address address = organization.getAddress();
        ServiceDetails serviceDetails = getMatchingServiceDetails(atmosphere, filterRequest);
        
        return new SearchResultUIModel(image, organization.getName(),  
                organization.getDenomination().getLocalizedStringCode(), organization.getId(), geoResult.getDistance().getValue(),
                isOrganizationFeatured(organization), isOrganizationUserFavorite(organization), address.getCity(), 
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

    private boolean isOrganizationUserFavorite(Organization organization)
    {
        // TODO Auto-generated method stub
        return false;
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
}
