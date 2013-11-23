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

    private ImageUIModel displayImage;
    private String organizationName;
    private Set<ServiceTime> serviceTimes;
    private String denomination;
    private double distanceFromSearchPoint;
    private boolean featured;
    private boolean usersFavorite;
    
    public SearchResultUIModel(ImageUIModel displayImage, String organizationName, Set<ServiceTime> serviceTimes, String denomination,
            double distanceFromSearchPoint, boolean featured, boolean usersFavorite)
    {
        super();
        this.displayImage = displayImage;
        this.organizationName = organizationName;
        this.serviceTimes = serviceTimes;
        this.denomination = denomination;
        this.distanceFromSearchPoint = distanceFromSearchPoint;
        this.featured = featured;
        this.usersFavorite = usersFavorite;
    }

    public ImageUIModel getDisplayImage()
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
