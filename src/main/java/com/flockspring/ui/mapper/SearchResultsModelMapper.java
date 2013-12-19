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
import com.flockspring.domain.types.impl.OrganizationImpl;
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
public class SearchResultsModelMapper
{

    private MultimediaUIModelMapper imageUIModelMapper;
    
    @Autowired    
    public SearchResultsModelMapper(MultimediaUIModelMapper imageUIModelMapper)
    {
        super();
        
        this.imageUIModelMapper = imageUIModelMapper;
    }

    public SearchResultsUIModel map(GeoPage<OrganizationImpl> geoPageResult)
    {
        
        NavigableSet<SearchResultUIModel> results = new TreeSet<>();
        for(GeoResult<OrganizationImpl> geoResult : geoPageResult)
        {
            results.add(map(geoResult));
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
        
        return new SearchResultsUIModel(results, currentPage, totalResults, pageStartIndex, pageEndIndex);
    }

    public SearchResultUIModel map(GeoResult<OrganizationImpl> geoResult)
    {
        Organization organization = geoResult.getContent(); 
        MultimediaUIModel image = imageUIModelMapper.map(getPrimaryOrganizationImage(organization.getMultimedia()));
        Address address = organization.getAddress();
        
        return new SearchResultUIModel(image, organization.getName(), organization.getServiceTimes(), 
                organization.getDenomination().getLocalizedStringCode(), organization.getId(), geoResult.getDistance().getValue(),
                isOrganizationFeatured(organization), isOrganizationUserFavorite(organization), address.getCity(), 
                address.getState(), address.getPostalCode());
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
