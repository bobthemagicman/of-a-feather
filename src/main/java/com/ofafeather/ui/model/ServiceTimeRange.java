/**
 *
 *  Copyright 2015 Justen L. Britain
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 **/
package com.ofafeather.ui.model;

import java.util.Date;

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
    
    public Date getRangeStartAsDate()
    {
        return rangeStart.toDate();
    }

    public LocalDateTime getRangeEnd()
    {
        return rangeEnd;
    }
    
    public Date getRangeEndAsDate()
    {
        return rangeEnd.toDate();
    }
}
