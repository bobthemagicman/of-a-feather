/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

/**
 * CongregationSize.java
 *
 * @author Justen L. Britain
 * @date Oct 27, 2013
 *
 */
public enum CongregationSize implements LocalizedEnum
{
    SMALL(0, 300, "congregation.size.small"),
    MEDIUM(301, 800, "congregation.size.medium"),
    LARGE(801, 1500, "congregation.size.large"),
    MEGA(1501, -1, "congregation.size.mega"),
    UNKNOWN(0, 0, "congregation.size.unknown");
    
    private int lowThreshold;
    private int highThreshold;
    private String localizedStringCode;
    
    private CongregationSize(int lowThreshold, int highThreshold, String localizedStringCode)
    {
        this.lowThreshold = lowThreshold;
        this.highThreshold = highThreshold;
        this.localizedStringCode = localizedStringCode;
    }
    
    public CongregationSize getCongregationTypeFromExactSize(int exactSize)
    {
        for(CongregationSize cs : CongregationSize.values())
        {
            if((cs.highThreshold == -1) || (exactSize >= cs.lowThreshold && exactSize <= cs.highThreshold))
            {
                return cs;
            }
        }
        
        //this should never happen
        return UNKNOWN;
    }
    
    @Override
    public String getLocalizedStringCode()
    {
        return this.localizedStringCode;
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
