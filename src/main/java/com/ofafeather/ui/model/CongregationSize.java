/**
 *
 *   Copyright 2015 Justen L. Britain
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

/**
 * CongregationSize.java
 *
 * @author Justen L. Britain
 * @date Oct 27, 2013
 *
 */
public enum CongregationSize implements LocalizedEnum
{
    SMALL(0, 100, "congregation.size.small"),
    MEDIUM(101, 400, "congregation.size.medium"),
    LARGE(401, 2000, "congregation.size.large"),
    MEGA(2001, -1, "congregation.size.mega"),
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
    
    public int getLowThreshold()
    {
        return lowThreshold;
    }
    
    public int getHighThreshold()
    {
        return highThreshold;
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
