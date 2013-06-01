/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import java.util.List;

import com.flockspring.ui.model.LeaderUIModel;
import com.flockspring.ui.model.UIMusicStyle;
import com.lehman.technology.group.common.web.ui.model.AddressUIModel;
import com.lehman.technology.group.common.web.ui.model.DayUIModel;
import com.lehman.technology.group.common.web.ui.model.FormattedTimeUIModel;
import com.lehman.technology.group.common.web.ui.model.ImageUIModel;
import com.lehman.technology.group.common.web.ui.model.LanguageUIModel;

/**
 * Community.java
 *
 * @author Justen L. Britain
 * @date May 27, 2013
 *
 */
public class CommunityImpl {

    private final AddressUIModel address;
    private  UIMusicStyle musicStyle;
    private FormattedTimeUIModel yearFounded;

    private List<FormattedTimeUIModel> serviceTimes;
    private List<LanguageUIModel> languages;
    private List<DayUIModel> serviceDays;
    private List<ImageUIModel> images;
    private List<LeaderUIModel> leadershipTeam;
    
    private String communityCategory;
    private String denomination;
    private String subDenomination;
    private String name;
    private  String programsOffered;
    private  String ageDemographics;
    private  String ethnicDemographics;
    private  String srLdrBiography;
    private  String description;
    private  String websiteUrl;
    private  String facebookUrl;
    
    private int averageServiceCongregationSize;
    
    private  boolean envFriendly;
    private  boolean parkingLot;
    private  boolean gayAffirming;
}
