/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.mapper;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flockspring.domain.types.MultimediaObject;
import com.flockspring.domain.types.Organization;
import com.flockspring.ui.model.MultimediaUIModel;
import com.flockspring.ui.model.SearchResultUIModel;

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

    public NavigableSet<SearchResultUIModel> map(NavigableSet<Organization> organizations)
    {
        
        NavigableSet<SearchResultUIModel> results = new TreeSet<>();
        for(Organization o : organizations)
        {
            results.add(map(o));
        }
        
        return results;
    }

    public SearchResultUIModel map(Organization organization)
    {
        MultimediaUIModel image = imageUIModelMapper.map(getPrimaryOrganizationImage(organization.getMultimedia()));
        
        return new SearchResultUIModel(image, organization.getName(), organization.getServiceTimes(), 
                organization.getDenomination().getLocalizedStringCode(), organization.getDistanceFromSearchPoint(),
                isOrganizationFeatured(organization), isOrganizationUserFavorite(organization));
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
