/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.flockspring.domain.types.MusicStyle;
import com.lehman.technology.group.common.web.ui.model.AddressUIModel;
import com.lehman.technology.group.common.web.ui.model.ImageUIModel;
import com.lehman.technology.group.common.web.ui.model.LanguageUIModel;

/**
 * CommunityUIModel.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public class OrganizationUIModel {

    private final AddressUIModel address;
    private final MusicStyle musicStyle;
    
    private final Set<LanguageUIModel> languages;
    private final Set<ImageUIModel> images;
    private final Set<LeaderUIModel> leadershipTeam;
    
    private final String serviceTimes;
    private final String serviceDays;
    private final String communityCategory;
    private final String denomination;
    private final String subDenomination;
    private final String name;
    private final String programsOffered;
    private final String ageDemographics;
    private final String ethnicDemographics;
    private final String srLdrBiography;
    private final String description;
    private final String websiteUrl;
    private final String facebookUrl;
    
    private final int yearFounded;
    private final int averageServiceCongregationSize;
    
    private final boolean envFriendly;
    private final boolean parkingLot;
    private final boolean gayAffirming;
  
    public OrganizationUIModel(AddressUIModel address, MusicStyle musicStyle, int yearFounded,
            String serviceTimes, Set<LanguageUIModel> languages, String serviceDays, Set<ImageUIModel> images,
            String communityCategory, String denomination, String subDenomination, String name, String programsOffered, String ageDemographics,
            String ethnicDemographics, String srLdrBiography, String description, String websiteUrl, String facebookUrl,
            int averageServiceCongregationSize, boolean envFriendly, boolean parkingLot, boolean gayAffirming, Set<LeaderUIModel> leadershipTeam) {
        
        super();
    
        this.address = address;
        this.musicStyle = musicStyle;
        this.yearFounded = yearFounded;
        this.serviceTimes = serviceTimes;
        this.languages = languages;
        this.serviceDays = serviceDays;
        this.images = images;
        this.communityCategory = communityCategory;
        this.denomination = denomination;
        this.subDenomination = subDenomination;
        this.name = name;
        this.programsOffered = programsOffered;
        this.ageDemographics = ageDemographics;
        this.ethnicDemographics = ethnicDemographics;
        this.srLdrBiography = srLdrBiography;
        this.description = description;
        this.websiteUrl = websiteUrl;
        this.facebookUrl = facebookUrl;
        this.averageServiceCongregationSize = averageServiceCongregationSize;
        this.envFriendly = envFriendly;
        this.parkingLot = parkingLot;
        this.gayAffirming = gayAffirming;
        this.leadershipTeam = leadershipTeam;
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

    public String getServiceTimes()
    {
        return serviceTimes;
    }

    public Set<LanguageUIModel> getLanguages()
    {
        return languages;
    }

    public String getServiceDays()
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

    public String getProgramsOffered()
    {
        return programsOffered;
    }

    public String getAgeDemographics()
    {
        return ageDemographics;
    }

    public String getEthnicDemographics()
    {
        return ethnicDemographics;
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

    public int getAverageServiceCongregationSize()
    {
        return averageServiceCongregationSize;
    }

    public boolean isEnvFriendly()
    {
        return envFriendly;
    }

    public boolean isParkingLot()
    {
        return parkingLot;
    }

    public boolean isGayAffirming()
    {
        return gayAffirming;
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
}
