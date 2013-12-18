/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import java.util.Set;

import com.flockspring.domain.types.impl.Atmosphere;
import com.flockspring.domain.types.impl.SocialMedia;
import com.flockspring.ui.model.Programs;
import com.flockspring.ui.model.ServiceTime;


public interface Organization
{
    
    Integer getYearFounded();

    Set<ServiceTime> getServiceTimes();

    Set<Language> getLanguages();

    Set<MultimediaObject> getMultimedia();

    Set<Leader> getLeadershipTeam();

    Set<ServiceDay> getServiceDays();
    
    Set<Programs> getProgramsOffered();
    
    Set<AccessabilitySupport> getAccessabilitySupport();
    
    Set<Programs> getProgrammsOffered();
    
    Affiliation getPrimaryAffiliation();

    Affiliation getDenomination();

    Affiliation getSubDenomination();

    String getName();

    String getId();

    double getDistanceFromSearchPoint();
    
    String getStatementOfFaith();

    String getMissionStatement();

    String getWelcomeMessage();

    SocialMedia getSocialMedia();
    
    Address getAddress();

    Atmosphere getAtmosphere();
}
