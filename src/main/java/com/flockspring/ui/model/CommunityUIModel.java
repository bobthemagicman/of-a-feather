/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import java.util.List;

import com.lehman.technology.group.common.web.ui.model.AddressUIModel;
import com.lehman.technology.group.common.web.ui.model.DayUIModel;
import com.lehman.technology.group.common.web.ui.model.FormattedTimeUIModel;
import com.lehman.technology.group.common.web.ui.model.ImageUIModel;
import com.lehman.technology.group.common.web.ui.model.LanguageUIModel;

/**
 * CommunityUIModel.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public class CommunityUIModel {

    private final AddressUIModel address;
    private final UIMusicStyle musicStyle;
    private FormattedTimeUIModel yearFounded;

    private final List<FormattedTimeUIModel> serviceTimes;
    private final List<LanguageUIModel> languages;
    private final List<DayUIModel> serviceDays;
    private final List<ImageUIModel> images;
    private final List<LeaderUIModel> leadershipTeam;
    
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
    
    private int averageServiceCongregationSize;
    
    private final boolean envFriendly;
    private final boolean parkingLot;
    private final boolean gayAffirming;
  
    public CommunityUIModel(AddressUIModel address, UIMusicStyle musicStyle, FormattedTimeUIModel yearFounded,
            List<FormattedTimeUIModel> serviceTimes, List<LanguageUIModel> languages, List<DayUIModel> serviceDays, List<ImageUIModel> images,
            String communityCategory, String denomination, String subDenomination, String name, String programsOffered, String ageDemographics,
            String ethnicDemographics, String srLdrBiography, String description, String websiteUrl, String facebookUrl,
            int averageServiceCongregationSize, boolean envFriendly, boolean parkingLot, boolean gayAffirming, List<LeaderUIModel> leadershipTeam) {
        
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
}
