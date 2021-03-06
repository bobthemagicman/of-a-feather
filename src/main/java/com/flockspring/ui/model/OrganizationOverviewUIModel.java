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
    private final String denominationLocalizationCode;
    private final String subDenominationLocalizationCode;
    private final int yearFounded;
    private final String leadPastorName;
    private final CongregationSize averageServiceCongregationSize;
    private final String phoneNumber;
    private final String websiteUrl;
    private final String serviceTimeShortString1;
    private final String serviceTimeShortString2;
    private final boolean userFavorited;
    private final SocialMediaUIModel socialMedia;
    private final AddressUIModel address;
    private final double distanceFromSearchPoint;
    private final boolean parkingLotAvailable;
   
    public OrganizationOverviewUIModel(String name, String denomination, String subDenomination, int yearFounded, String leadPastorName,
            CongregationSize averageServiceCongregationSize, String phoneNumber, String websiteUrl, String serviceTimeShortString1, String serviceTimeShortString2, boolean userFavorited,
            SocialMediaUIModel socialMedia, AddressUIModel address, double distanceFromSearchPoint, boolean parkingLotAvailable)
    {
        super();
      
        this.name = name;
        this.denominationLocalizationCode = denomination;
        this.subDenominationLocalizationCode = subDenomination;
        this.yearFounded = yearFounded;
        this.leadPastorName = leadPastorName;
        this.averageServiceCongregationSize = averageServiceCongregationSize;
        this.phoneNumber = phoneNumber;
        this.websiteUrl = websiteUrl;
        this.serviceTimeShortString1 = serviceTimeShortString1;
        this.serviceTimeShortString2 = serviceTimeShortString2;
        this.userFavorited = userFavorited;
        this.socialMedia = socialMedia;
        this.address = address;
        this.distanceFromSearchPoint = distanceFromSearchPoint;
        this.parkingLotAvailable = parkingLotAvailable;
    }

    public String getName()
    {
        return name;
    }

    public String getDenominationLocalizationCode()
    {
        return denominationLocalizationCode;
    }

    public String getSubDenominationLocalizationCode()
    {
        return subDenominationLocalizationCode;
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

    public String getServiceTimeShortString1()
    {
        return serviceTimeShortString1;
    }
    
    public String getServiceTimeShortString2()
    {
        return serviceTimeShortString2;
    }

    public boolean isUserFavorited()
    {
        return userFavorited;
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