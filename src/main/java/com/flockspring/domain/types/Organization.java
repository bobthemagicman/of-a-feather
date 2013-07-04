/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import java.util.List;

import com.lehman.technology.group.common.domain.types.Address;
import com.lehman.technology.group.common.domain.types.Image;
import com.lehman.technology.group.common.domain.types.Language;

public interface Organization
{
    Address getAddress();

    MusicStyle getMusicStyle();

    int getYearFounded();

    String getServiceTimes();

    List<Language> getLanguages();

    List<Image> getImages();

    List<Leader> getLeadershipTeam();

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

    /**
     * @return
     */
    Leader getPrimaryLeader();
}
