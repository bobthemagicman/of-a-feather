/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import com.flockspring.ui.model.LocalizedEnum;

/**
 * ServiceDay.java
 *
 * @author Justen L. Britain
 * @date Oct 27, 2013
 *
 */
public enum ServiceDay implements LocalizedEnum
{
    MONDAY("service.day.monday"), 
    TUESDAY("service.day.tuesday"),
    WEDNESDAY("service.day.wednesday"),
    THURSDAY("service.day.thursday"),
    FRIDAY("service.day.friday"),
    SATURDAY("service.day.saturday"),
    SUNDAY("service.day.sunday");

    private String localizationStringCode;
    
    private ServiceDay(String localizationStringCode)
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
