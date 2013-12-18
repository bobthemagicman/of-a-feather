/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import java.util.Set;

import com.flockspring.domain.types.ServiceDetails;
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

    boolean isGayAffirming();

    boolean isHomeChurch();

    Set<ServiceDetails> getServiceDetails();
}
