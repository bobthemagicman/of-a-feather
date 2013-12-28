/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import com.flockspring.ui.model.LocalizedEnum;

/**
 * AccessibilitySupport.java
 *
 * @author Justen L. Britain
 * @date Nov 9, 2013
 *
 */
public enum AccessibilitySupport implements LocalizedEnum
{
    WHEELCHAIR_ACCESS("accessability.support.wheelchair.access"),
    DEAF_TRANSLATOR("accessability.support.deaf.translator"),
    PARKING_LOT("accessability.support.parking.lot"),
    STREET_PARKING("accessability.support.street.parking"),
    PARKING_GARAGE("accessability.support.parking.garage"),
    CARPOOL("accessability.support.carpool");
    
    private String localizationStringCode;
    
    private AccessibilitySupport(String localizationStringCode)
    {
        this.localizationStringCode = localizationStringCode;
    }
    
    @Override
    public String getLocalizedStringCode()
    {
        return this.localizationStringCode;
    }

    @Override
    public String getName()
    {
        return this.name();
    }

    @Override
    public int getOrdinal()
    {
        return this.ordinal();
    }
}
