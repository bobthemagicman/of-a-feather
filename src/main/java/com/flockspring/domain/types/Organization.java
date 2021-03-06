/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import java.util.Set;

import com.flockspring.domain.types.impl.Atmosphere;
import com.flockspring.domain.types.impl.SocialMedia;


public interface Organization
{
    
    Integer getYearFounded();

    Set<MultimediaObject> getMultimedia();

    Set<Leader> getLeadershipTeam();

    Set<Programs> getProgramsOffered();
    
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

    Set<AccessibilitySupport> getAccessibilitySupport();

    String getExtraServiceDetails();
}
