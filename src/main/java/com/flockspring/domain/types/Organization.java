/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import java.util.Set;

import com.flockspring.domain.types.impl.Atmosphere;
import com.flockspring.domain.types.impl.SocialMedia;
import com.flockspring.ui.model.Programs;


public interface Organization
{
    
    Integer getYearFounded();

    Set<MultimediaObject> getMultimedia();

    Set<Leader> getLeadershipTeam();

    Set<Programs> getProgramsOffered();
    
    Set<AccessibilitySupport> getAccessibilitySupport();
    
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
