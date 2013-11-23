/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import java.util.Set;

import com.flockspring.ui.model.CongregationSize;
import com.flockspring.ui.model.Programs;
import com.flockspring.ui.model.ServiceTime;


public interface Organization
{
    Address getAddress();

    int getYearFounded();

    Set<ServiceTime> getServiceTimes();

    Set<Language> getLanguages();

    Set<Image> getImages();

    Set<Leader> getLeadershipTeam();

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
    
    boolean isParkingLotAvailable();
    
    Set<Programs> getProgramsOffered();
    
    Set<AccessabilitySupport> getAccessabilitySupport();
    
    DressAttire getDressAttire();
    
    ServiceStyle getServiceStyle();
}
