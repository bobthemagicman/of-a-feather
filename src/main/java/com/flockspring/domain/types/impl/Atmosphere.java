/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import java.util.Set;

import com.flockspring.domain.types.DressAttire;
import com.flockspring.domain.types.MusicStyle;
import com.flockspring.domain.types.ServiceStyle;
import com.flockspring.ui.model.CongregationSize;

/**
 * Atmosphere.java
 *
 * @author Justen L. Britain
 * @date Dec 8, 2013
 *
 */
public interface Atmosphere
{

    CongregationSize getCongregationSize();

    MusicStyle getMusicStyle();

    DressAttire getDressAttire();

    Set<MusicalInstruments> getInstruments();

    AgeDemographics getAgeDemongraphics();

    ServiceStyle getServiceStyle();

    boolean isGayAffirming();

    boolean isHomeChurch();

}
