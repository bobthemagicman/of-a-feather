/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import java.io.Serializable;
import java.util.Set;

import com.lehman.technology.group.common.domain.types.Address;
import com.lehman.technology.group.common.domain.types.Image;
import com.lehman.technology.group.common.domain.types.Language;

public interface Organization extends Serializable
{
    Address getAddress();

    MusicStyle getMusicStyle();

    int getYearFounded();

    String getServiceTimes();

    Set<Language> getLanguages();

    Set<Image> getImages();

    Set<Leader> getLeadershipTeam();

    Affiliation getPrimaryAffiliation();

    Affiliation getAffilationDenomination();

    Affiliation getSubAffiliationDenomination();

    String getName();

    String getProgramsOffered();

    String getAgeDemographics();

    String getEthnicDemographics();

    String getDescription();

    String getWebsiteUrl();

    String getFacebookUrl();

    String getServiceDays();
    
    int getAverageServiceCongregationSize();

    boolean isGayAffirming();

    boolean isParkingLot();

    boolean isEnvFriendly();

    long getId();

    Region getRegion();
}
