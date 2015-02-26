/**
 *
 *   Copyright 2015 Justen L. Britain
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 **/
package com.ofafeather.ui.model;

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
public class ChurchListingUIModel implements Comparable<ChurchListingUIModel>
{

    private final MultimediaUIModel displayImage;
    private final String organizationName;
    private final String denomination;
    private final String id;
    private final double distanceFromSearchPoint;
    private final boolean featured;
    private final boolean usersFavorite;
    private final String city;
    private final String state;
    private final String postalCode;
    private final double latitude;
    private final double longitude;
    private final int musicStyleSliderValue;
    private final int serviceStyleSliderValue;
    private final int dressAttireSliderValue;
    
    public ChurchListingUIModel(MultimediaUIModel displayImage, String organizationName, String denomination,
            String id, double distanceFromSearchPoint, boolean featured, boolean usersFavorite, String city, String state, String postalCode,
            double latitude, double longitude, int musicStyleSliderValue, int serviceStyleSliderValue, int dressAttireSliderValue)
    {
        super();
        
        this.displayImage = displayImage;
        this.organizationName = organizationName;
        this.denomination = denomination;
        this.id = id;
        this.distanceFromSearchPoint = distanceFromSearchPoint;
        this.featured = featured;
        this.usersFavorite = usersFavorite;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.musicStyleSliderValue = musicStyleSliderValue;
        this.serviceStyleSliderValue = serviceStyleSliderValue;
        this.dressAttireSliderValue = dressAttireSliderValue;
    }
    
    public MultimediaUIModel getDisplayImage()
    {
        return displayImage;
    }

    public String getOrganizationName()
    {
        return organizationName;
    }

    public String getDenomination()
    {
        return denomination;
    }

    public String getId()
    {
        return id;
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

    public double getLatitude()
    {
        return latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public int getMusicStyleSliderValue()
    {
        return musicStyleSliderValue;
    }

    public int getServiceStyleSliderValue()
    {
        return serviceStyleSliderValue;
    }

    public int getDressAttireSliderValue()
    {
        return dressAttireSliderValue;
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
    public int compareTo(ChurchListingUIModel right)
    {

        ChurchListingUIModel left = this;
        return ComparisonChain.start()
                .compare(left.getDistanceFromSearchPoint(), right.getDistanceFromSearchPoint(), Ordering.natural().nullsFirst())
                .compare(left.getOrganizationName(), right.getOrganizationName(), Ordering.natural().nullsFirst())
                .compare(left.getId(), right.getId())
                .result();
    }
}
