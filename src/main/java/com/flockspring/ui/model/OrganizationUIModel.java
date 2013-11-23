/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.flockspring.domain.types.MusicStyle;
import com.flockspring.domain.types.ServiceDay;
import com.google.common.collect.ComparisonChain;

/**
 * CommunityUIModel.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public class OrganizationUIModel implements Comparable<OrganizationUIModel> {

    private final AddressUIModel address;
    private final MusicStyle musicStyle;
    
    private final Set<LanguageUIModel> languages;
    private final Set<ImageUIModel> images;
    private final Set<LeaderUIModel> leadershipTeam;
    
    private final Set<ServiceTime> serviceTimes;
    private final Set<ServiceDay> serviceDays;
    private final String communityCategory;
    private final String denomination;
    private final String subDenomination;
    private final String name;
    private final Set<Programs> programsOffered;
    private final String srLdrBiography;
    private final String description;
    private final String websiteUrl;
    private final String facebookUrl;
    
    private final int yearFounded;
    private final CongregationSize averageServiceCongregationSize;
    private final double distanceFromSearchPoint;
    
    private final boolean parkingLot;
      
    public OrganizationUIModel(AddressUIModel address, MusicStyle musicStyle, int yearFounded,
            Set<ServiceTime> serviceTimes2, Set<LanguageUIModel> languages, Set<ServiceDay> serviceDays2, Set<ImageUIModel> images,
            String communityCategory, String denomination, String subDenomination, String name, Set<Programs> programsOffered2,
            String srLdrBiography, String description, String websiteUrl, String facebookUrl,
            CongregationSize averageServiceCongregationSize2, boolean parkingLot, boolean gayAffirming, Set<LeaderUIModel> leadershipTeam,
            double distanceFromSearchPoint) {
        
        super();
    
        this.address = address;
        this.musicStyle = musicStyle;
        this.yearFounded = yearFounded;
        this.serviceTimes = serviceTimes2;
        this.languages = languages;
        this.serviceDays = serviceDays2;
        this.images = images;
        this.communityCategory = communityCategory;
        this.denomination = denomination;
        this.subDenomination = subDenomination;
        this.name = name;
        this.programsOffered = programsOffered2;
        this.srLdrBiography = srLdrBiography;
        this.description = description;
        this.websiteUrl = websiteUrl;
        this.facebookUrl = facebookUrl;
        this.averageServiceCongregationSize = averageServiceCongregationSize2;
        this.parkingLot = parkingLot;
        this.leadershipTeam = leadershipTeam;
        this.distanceFromSearchPoint = distanceFromSearchPoint;
    }

    public AddressUIModel getAddress()
    {
        return address;
    }

    public MusicStyle getMusicStyle()
    {
        return musicStyle;
    }

    public int getYearFounded()
    {
        return yearFounded;
    }

    public Set<ServiceTime> getServiceTimes()
    {
        return serviceTimes;
    }

    public Set<LanguageUIModel> getLanguages()
    {
        return languages;
    }

    public Set<ServiceDay> getServiceDays()
    {
        return serviceDays;
    }

    public Set<ImageUIModel> getImages()
    {
        return images;
    }

    public Set<LeaderUIModel> getLeadershipTeam()
    {
        return leadershipTeam;
    }

    public String getCommunityCategory()
    {
        return communityCategory;
    }

    public String getDenomination()
    {
        return denomination;
    }

    public String getSubDenomination()
    {
        return subDenomination;
    }

    public String getName()
    {
        return name;
    }

    public Set<Programs> getProgramsOffered()
    {
        return programsOffered;
    }

    public String getSrLdrBiography()
    {
        return srLdrBiography;
    }

    public String getDescription()
    {
        return description;
    }

    public String getWebsiteUrl()
    {
        return websiteUrl;
    }

    public String getFacebookUrl()
    {
        return facebookUrl;
    }

    public CongregationSize getAverageServiceCongregationSize()
    {
        return averageServiceCongregationSize;
    }

    public boolean isParkingLot()
    {
        return parkingLot;
    }
    
    public double getDistanceFromSearchPoint()
    {
        return distanceFromSearchPoint;
    }

    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(this);
    }
    
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
    
    @Override
    public boolean equals(Object obj)
    {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int compareTo(OrganizationUIModel right)
    {
        
        return ComparisonChain.start().compare(this.getDistanceFromSearchPoint(), right.getDistanceFromSearchPoint())
                .result();
    }
}
