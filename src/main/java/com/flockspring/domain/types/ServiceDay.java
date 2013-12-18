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
    MONDAY("enum.monday"), 
    TUESDAY("enum.tuesday"),
    WEDNESDAY("enum.wednesday"),
    THURSDAY("enum.thursday"),
    FRIDAY("enum.friday"),
    SATURDAY("enum.saturday"),
    SUNDAY("enum.sunday");

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
