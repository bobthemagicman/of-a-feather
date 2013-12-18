/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

/**
 * OrganizationOverviewUIModel.java
 *
 * @author Justen L. Britain
 * @date Dec 15, 2013
 *
 */
public class OrganizationOverviewUIModel
{
    private final String name;
    private final String denomination;
    private final String subDenomination;
    private final int yearFounded;
    private final String leadPastorName;
    private final CongregationSize averageServiceCongregationSize;
    private final String phoneNumber;
    private final String websiteUrl;
    private final String serviceTimesShort;
    private final boolean isUserFavorite;
    private final SocialMediaUIModel socialMedia;
    private final AddressUIModel address;
    private final double distanceFromSearchPoint;
    private final boolean parkingLotAvailable;
   
    public OrganizationOverviewUIModel(String name, String denomination, String subDenomination, int yearFounded, String leadPastorName,
            CongregationSize averageServiceCongregationSize, String phoneNumber, String websiteUrl, String serviceTimesShort, boolean isUserFavorite,
            SocialMediaUIModel socialMedia, AddressUIModel address, double distanceFromSearchPoint, boolean parkingLotAvailable)
    {
        super();
      
        this.name = name;
        this.denomination = denomination;
        this.subDenomination = subDenomination;
        this.yearFounded = yearFounded;
        this.leadPastorName = leadPastorName;
        this.averageServiceCongregationSize = averageServiceCongregationSize;
        this.phoneNumber = phoneNumber;
        this.websiteUrl = websiteUrl;
        this.serviceTimesShort = serviceTimesShort;
        this.isUserFavorite = isUserFavorite;
        this.socialMedia = socialMedia;
        this.address = address;
        this.distanceFromSearchPoint = distanceFromSearchPoint;
        this.parkingLotAvailable = parkingLotAvailable;
    }

    public String getName()
    {
        return name;
    }

    public String getDenomination()
    {
        return denomination;
    }

    public String getSubDenomination()
    {
        return subDenomination;
    }

    public int getYearFounded()
    {
        return yearFounded;
    }

    public String getLeadPastorName()
    {
        return leadPastorName;
    }

    public CongregationSize getAverageServiceCongregationSize()
    {
        return averageServiceCongregationSize;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getWebsiteUrl()
    {
        return websiteUrl;
    }

    public String getServiceTimesShort()
    {
        return serviceTimesShort;
    }

    public boolean isUserFavorite()
    {
        return isUserFavorite;
    }

    public SocialMediaUIModel getSocialMedia()
    {
        return socialMedia;
    }

    public AddressUIModel getAddress()
    {
        return address;
    }

    public double getDistanceFromSearchPoint()
    {
        return distanceFromSearchPoint;
    }

    public boolean isParkingLotAvailable()
    {
        return parkingLotAvailable;
    }
}