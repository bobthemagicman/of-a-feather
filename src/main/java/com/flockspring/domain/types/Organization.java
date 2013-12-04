/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import java.util.List;
import java.util.Set;

import com.flockspring.domain.types.impl.LeaderImpl;
import com.flockspring.ui.model.CongregationSize;
import com.flockspring.ui.model.Programs;
import com.flockspring.ui.model.ServiceTime;


public interface Organization
{
    Address getAddress();

    Integer getYearFounded();

    Set<ServiceTime> getServiceTimes();

    Set<Language> getLanguages();

    Set<Image> getImages();

    List<LeaderImpl> getLeadershipTeam();

    Affiliation getPrimaryAffiliation();

    Affiliation getDenomination();

    Affiliation getSubDenomination();

    String getName();

    String getDescription();

    String getWebsiteUrl();

    String getFacebookUrl();

    Set<ServiceDay> getServiceDays();
    
    CongregationSize getCongregationSize();

    boolean isGayAffirming();

    String getId();

    Region getRegion();

    double getDistanceFromSearchPoint();

    MusicStyle getMusicStyle();
    
    Set<Programs> getProgramsOffered();
    
    Set<AccessabilitySupport> getAccessabilitySupport();
    
    DressAttire getDressAttire();
    
    ServiceStyle getServiceStyle();

    Set<AccessabilitySupport> getAccessibilitySupport();

    Set<Programs> getProgrammsOffered();

    String getTwitterUrl();

    String getStatementOfFaith();

    String getMissionStatement();
}
