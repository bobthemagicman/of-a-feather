/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import org.joda.time.LocalDateTime;

/**
 * ServiceTime.java
 * 
 * @author Justen L. Britain
 * @date Oct 27, 2013
 * 
 */
public enum ServiceTimeRange implements LocalizedEnum
{
    EARLY_MORNING("service.time.early.morning", new LocalDateTime(1970, 12, 30, 0, 0, 0), new LocalDateTime(1970, 12, 30, 9, 0, 1)),
    MID_MORNING("service.time.mid.morning", new LocalDateTime(1970, 12, 30, 9, 0, 2), new LocalDateTime(1970, 12, 30, 10, 45, 1)),
    LATE_MORNING("service.time.late.morning", new LocalDateTime(1970, 12, 30, 10, 45, 2), new LocalDateTime(1970, 12, 30, 12, 45, 1)),
    AFTERNOON("service.time.afternoon", new LocalDateTime(1970, 12, 30, 12, 45, 2), new LocalDateTime(1970, 12, 30, 16, 0, 0)),
    EVENING("service.time.evening", new LocalDateTime(1970, 12, 30, 16, 0, 1), new LocalDateTime(1970, 12, 30, 23, 59, 59));
    
    private final String localizationStringCode;
    private final LocalDateTime rangeStart;
    private final LocalDateTime rangeEnd;

    private ServiceTimeRange(String localizationStringCode, LocalDateTime rangeStart,
            LocalDateTime rangeEnd)
    {
        
        this.localizationStringCode = localizationStringCode;
        this.rangeStart = rangeStart;
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

    public LocalDateTime getRangeStart()
    {
        return rangeStart;
    }

    public LocalDateTime getRangeEnd()
    {
        return rangeEnd;
    }
}
