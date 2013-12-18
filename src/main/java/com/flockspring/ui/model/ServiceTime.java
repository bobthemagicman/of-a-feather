/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

/**
 * ServiceTime.java
 * 
 * @author Justen L. Britain
 * @date Oct 27, 2013
 * 
 */
public enum ServiceTime implements LocalizedEnum
{
    EARLY_MORNING("enum.early.morning"),
    MID_MORNING("enum.mid.morning"),
    LATE_MORNING("enum.late.morning"),
    AFTERNOON("enum.afternoon"), 
    EVENING("enum.evening"); 
    
    private String localizationStringCode;

    private ServiceTime(String localizationStringCode)
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
