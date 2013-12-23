/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import java.util.Set;

import com.flockspring.domain.types.impl.Atmosphere;
import com.flockspring.domain.types.impl.SocialMedia;
import com.flockspring.ui.model.Programs;
import com.flockspring.ui.model.ServiceTimeRange;


public interface Organization
{
    
    Integer getYearFounded();

    Set<Language> getLanguages();

    Set<MultimediaObject> getMultimedia();

    Set<Leader> getLeadershipTeam();

    Set<Programs> getProgramsOffered();
    
    Set<AccessabilitySupport> getAccessabilitySupport();
    
    Affiliation getPrimaryAffiliation();

    Affiliation getDenomination();

    Affiliation getSubDenomination();

    String getName();

    String getId();

    String getStatementOfFaith();

    String getMissionStatement();

    String getWelcomeMessage();

    SocialMedia getSocialMedia();
    
    Address getAddress();

    Atmosphere getAtmosphere();
}
