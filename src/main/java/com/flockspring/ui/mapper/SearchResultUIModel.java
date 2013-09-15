/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.mapper;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.flockspring.ui.model.ImageUIModel;
import com.google.common.collect.ComparisonChain;

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
    
    private ImageUIModel displayImage;

    public SearchResultUIModel(String organizationName, String serviceTimes, String denomination, int distanceFromSearchPoint, boolean usersFavorite,
            boolean featured, ImageUIModel displayImage)
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

    public ImageUIModel getDisplayImage()
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
                .compare(this.getDistanceFromSearchPoint(), right.getDistanceFromSearchPoint())
                .compare(this.getOrganizationName(), right.getOrganizationName())
                .result();
    }   
}
