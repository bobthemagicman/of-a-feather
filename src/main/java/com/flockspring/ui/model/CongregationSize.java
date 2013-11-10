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
public enum CongregationSize
{
    SMALL(0, 300),
    MEDIUM(301, 800),
    LARGE(801, 1500),
    MEGA(1501, -1),
    UNKNOWN(0, 0);
    
    private int lowThreshold;
    private int highThreshold;
    
    private CongregationSize(int lowThreshold, int highThreshold)
    {
        this.lowThreshold = lowThreshold;
        this.highThreshold = highThreshold;
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
}
