/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import java.util.Set;

import com.flockspring.domain.types.impl.Atmosphere;
import com.flockspring.domain.types.impl.LeaderImpl;
import com.flockspring.domain.types.impl.SocialMediaImpl;
import com.flockspring.ui.model.Programs;
import com.flockspring.ui.model.ServiceTime;


public interface Organization
{
    
    Integer getYearFounded();

    Set<ServiceTime> getServiceTimes();

    Set<Language> getLanguages();

    Set<Image> getImages();

    Set<LeaderImpl> getLeadershipTeam();

    Set<ServiceDay> getServiceDays();
    
    Set<Programs> getProgramsOffered();
    
    Set<AccessabilitySupport> getAccessabilitySupport();
    
    Set<AccessabilitySupport> getAccessibilitySupport();

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

    SocialMediaImpl getSocialMedia();
    
    Address getAddress();

    Atmosphere getAtmosphere();
}
