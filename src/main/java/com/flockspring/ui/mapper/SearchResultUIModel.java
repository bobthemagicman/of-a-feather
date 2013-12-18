/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.mapper;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.flockspring.ui.model.MultimediaUIModel;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

/**
 * SearchResultUIModel.java
 *
 * @author Justen L. Britain
 * @date Sep 15, 2013
 *
 */
public class SearchResultUIModel implements Comparable<SearchResultUIModel>
{
    
    private String organizationName;
    private String serviceTimes;
    private String denomination;    
    private int distanceFromSearchPoint;
    private boolean usersFavorite;
    private boolean featured;
    
    private MultimediaUIModel displayImage;

    public SearchResultUIModel(String organizationName, String serviceTimes, String denomination, int distanceFromSearchPoint, boolean usersFavorite,
            boolean featured, MultimediaUIModel displayImage)
    {
        super();
        
        this.organizationName = organizationName;
        this.serviceTimes = serviceTimes;
        this.denomination = denomination;
        this.distanceFromSearchPoint = distanceFromSearchPoint;
        this.usersFavorite = usersFavorite;
        this.featured = featured;
        this.displayImage = displayImage;
    }

    public String getOrganizationName()
    {
        return organizationName;
    }

    public String getServiceTimes()
    {
        return serviceTimes;
    }

    public String getDenomination()
    {
        return denomination;
    }

    public int getDistanceFromSearchPoint()
    {
        return distanceFromSearchPoint;
    }

    public boolean isUsersFavorite()
    {
        return usersFavorite;
    }

    public boolean isFeatured()
    {
        return featured;
    }

    public MultimediaUIModel getDisplayImage()
    {
        return displayImage;
    }

    @Override
    public int hashCode()
    {
       return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other)
    {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public int compareTo(SearchResultUIModel right)
    {
        
        return ComparisonChain.start()
                .compare(this.getDistanceFromSearchPoint(), right.getDistanceFromSearchPoint(), Ordering.natural().nullsFirst())
                .compare(this.getOrganizationName(), right.getOrganizationName(), Ordering.natural().nullsFirst())
                .result();
    }   
}
