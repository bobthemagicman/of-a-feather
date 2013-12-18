/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import com.flockspring.ui.model.LocalizedEnum;

/**
 * AccessabilitySupport.java
 *
 * @author Justen L. Britain
 * @date Nov 9, 2013
 *
 */
public enum AccessabilitySupport implements LocalizedEnum
{
    WHEELCHAIR_ACCESS("enum.wheelchair.access"),
    DEAF_TRANSLATOR("enum.deaf.translator"),
    HEARING_LOOP("enum.hearing.loop"),
    PARKING_LOT("enum.parking.lot"),
    STREET_PARKING("enum.street.parking"),
    PARKING_GARAGE("enum.parking.garage"),
    CARPOOL("enum.carpool"); 
    private String localizationStringCode;
    
    private AccessabilitySupport(String localizationStringCode)
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
