/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import java.util.Set;

import com.flockspring.domain.types.impl.AgeDemographics;
import com.flockspring.domain.types.impl.MusicalInstruments;

/**
 * ChurchService.java
 * 
 * @author Justen L. Britain
 * @date Dec 16, 2013
 * 
 */
public interface ServiceDetails
{

    MusicStyle getMusicStyle();

    DressAttire getDressAttire();

    Set<MusicalInstruments> getInstruments();

    AgeDemographics getAgeDemongraphics();

    ServiceStyle getServiceStyle();

    int getDurationInMinutes();
    
    TimeAndDay getTimeAndDay();

    String getServiceName();

    /**
     * @return
     */
    Set<Language> getLanguages();
}
