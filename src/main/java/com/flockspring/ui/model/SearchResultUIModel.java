/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.google.common.collect.ComparisonChain;

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
    private String serviceTimes;
    private String denomination;
    private int distanceFromSearchPoint;
    private boolean featured;
    private boolean usersFavorite;
    
    public SearchResultUIModel(ImageUIModel displayImage, String organizationName, String serviceTimes, String denomination,
            int distanceFromSearchPoint, boolean featured, boolean usersFavorite)
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
                .compare(this.getDistanceFromSearchPoint(), right.getDistanceFromSearchPoint())
                .compare(this.getOrganizationName(), right.getOrganizationName())
                .result();
    }
}
