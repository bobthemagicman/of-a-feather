/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

/**
 * SearchResultUIModel.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public class SearchResultUIModel implements Comparable<SearchResultUIModel>
{

    private final MultimediaUIModel displayImage;
    private final String organizationName;
    private final Set<ServiceTime> serviceTimes;
    private final String denomination;
    private final String id;
    private final double distanceFromSearchPoint;
    private final boolean featured;
    private final boolean usersFavorite;
    private final String city;
    private final String state;
    private final String postalCode;
    
    public SearchResultUIModel(MultimediaUIModel displayImage, String organizationName, Set<ServiceTime> serviceTimes, String denomination,
            String id, double distanceFromSearchPoint, boolean featured, boolean usersFavorite, String city, String state, String postalCode)
    {
        super();
        
        this.displayImage = displayImage;
        this.organizationName = organizationName;
        this.serviceTimes = serviceTimes;
        this.denomination = denomination;
        this.id = id;
        this.distanceFromSearchPoint = distanceFromSearchPoint;
        this.featured = featured;
        this.usersFavorite = usersFavorite;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public MultimediaUIModel getDisplayImage()
    {
        return displayImage;
    }

    public String getOrganizationName()
    {
        return organizationName;
    }

    public Set<ServiceTime> getServiceTimes()
    {
        return serviceTimes;
    }

    public String getDenomination()
    {
        return denomination;
    }

    public double getDistanceFromSearchPoint()
    {
        return distanceFromSearchPoint;
    }

    public boolean isFeatured()
    {
        return featured;
    }

    public boolean isUsersFavorite()
    {
        return usersFavorite;
    }

    public String getId()
    {
        return this.id;
    }
    
    public String getCity()
    {
        return city;
    }

    public String getState()
    {
        return state;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object that)
    {
        return EqualsBuilder.reflectionEquals(this, that);
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
