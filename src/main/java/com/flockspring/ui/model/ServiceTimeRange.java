/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import org.joda.time.LocalTime;

/**
 * ServiceTime.java
 * 
 * @author Justen L. Britain
 * @date Oct 27, 2013
 * 
 */
public enum ServiceTimeRange implements LocalizedEnum
{
    EARLY_MORNING("service.time.early.morning", new LocalTime(0, 0, 0), new LocalTime(9, 0, 1)),
    MID_MORNING("service.time.mid.morning", new LocalTime(9, 0, 2), new LocalTime(11, 0, 1)),
    LATE_MORNING("service.time.late.morning", new LocalTime(11, 0, 2), new LocalTime(12, 0, 1)),
    AFTERNOON("service.time.afternoon", new LocalTime(12, 0, 2), new LocalTime(16, 0, 0)),
    EVENING("service.time.evening", new LocalTime(16, 0, 1), new LocalTime(23, 59, 59));
    
    private final String localizationStringCode;
    private final LocalTime rangeStart;
    private final LocalTime rangeEnd;

    private ServiceTimeRange(String localizationStringCode, LocalTime rangeStart,
            LocalTime rangeEnd)
    {
        
        this.localizationStringCode = localizationStringCode;
        this.rangeStart = rangeEnd;
        this.rangeEnd = rangeEnd;
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

    public String getLocalizationStringCode()
    {
        return localizationStringCode;
    }

    public LocalTime getRangeStart()
    {
        return rangeStart;
    }

    public LocalTime getRangeEnd()
    {
        return rangeEnd;
    }
}
