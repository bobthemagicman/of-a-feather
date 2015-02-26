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

import java.util.Set;

import org.springframework.data.mongodb.core.geo.Point;

import com.ofafeather.domain.types.AccessibilitySupport;
import com.ofafeather.domain.types.Affiliation;
import com.ofafeather.domain.types.Language;
import com.ofafeather.domain.types.Programs;
import com.ofafeather.domain.types.ServiceDay;

/**
 * DenominationFilterRequest.java
 *
 * @author Justen L. Britain
 * @date Oct 20, 2013
 *
 */
public class SearchFilterUICommand
{

    private Set<Affiliation> affiliations;
    private Set<Language> languages;
    private Set<ServiceTimeRange> serviceTimes;
    private Set<ServiceDay> serviceDays;
    private Set<CongregationSize> congregationSizes;
    private Set<Programs> programsAndMinistries;
    private Set<AccessibilitySupport> accessibilitySupports;
    private Integer atmosphereServiceStyleFloor;
    private Integer atmosphereServiceStyleCeiling;
    private Integer atmosphereMusicStyleFloor;
    private Integer atmosphereMusicStyleCeiling;
    private Integer atmosphereDressAttireFloor;
    private Integer atmosphereDressAttireCeiling;
    private boolean gayAfirming;
    private double[] location;
    
    public SearchFilterUICommand()
    {
        super();
    }
   
    public SearchFilterUICommand(Set<Affiliation> affiliations, Set<Language> languages, Set<ServiceTimeRange> serviceTimes,
            Set<ServiceDay> serviceDays, Set<CongregationSize> congregationSizes, Set<Programs> programsAndMinistries,
            Integer atmosphereServiceStyleFloor, Integer atmosphereServiceStyleCeiling, Integer atmosphereMusicStyleFloor,
            Integer atmosphereMusicStyleCeiling, Integer atmosphereDressAttireFloor, Integer atmosphereDressAttireCeiling, boolean gayAfirming,
            double[] location, Set<AccessibilitySupport> accessibilitySupports)
    {
        super();
        
        this.affiliations = affiliations;
        this.languages = languages;
        this.serviceTimes = serviceTimes;
        this.serviceDays = serviceDays;
        this.congregationSizes = congregationSizes;
        this.accessibilitySupports = accessibilitySupports;
        this.programsAndMinistries = programsAndMinistries;
        this.atmosphereServiceStyleFloor = atmosphereServiceStyleFloor;
        this.atmosphereServiceStyleCeiling = atmosphereServiceStyleCeiling;
        this.atmosphereMusicStyleFloor = atmosphereMusicStyleFloor;
        this.atmosphereMusicStyleCeiling = atmosphereMusicStyleCeiling;
        this.atmosphereDressAttireFloor = atmosphereDressAttireFloor;
        this.atmosphereDressAttireCeiling = atmosphereDressAttireCeiling;
        this.gayAfirming = gayAfirming;
        this.location = location;
    }

    public Set<Affiliation> getAffiliations()
    {
        return affiliations;
    }
    
    public Set<Language> getLanguages()
    {
        return languages;
    }
    
    public Set<ServiceTimeRange> getServiceTimes()
    {
        return serviceTimes;
    }
    
    public Set<ServiceDay> getServiceDays()
    {
        return serviceDays;
    }
    
    public Set<CongregationSize> getCongregationSizes()
    {
        return congregationSizes;
    }
    
    public Set<Programs> getProgramsAndMinistries()
    {
        return programsAndMinistries;
    }
    
    public Set<AccessibilitySupport> getAccessibilitySupports()
    {
        return accessibilitySupports;
    }
    
    public Integer getAtmosphereServiceStyleFloor()
    {
        return atmosphereServiceStyleFloor;
    }
    
    public Integer getAtmosphereServiceStyleCeiling()
    {
        return atmosphereServiceStyleCeiling;
    }
    
    public Integer getAtmosphereMusicStyleFloor()
    {
        return atmosphereMusicStyleFloor;
    }
    
    public Integer getAtmosphereMusicStyleCeiling()
    {
        return atmosphereMusicStyleCeiling;
    }
    
    public Integer getAtmosphereDressAttireFloor()
    {
        return atmosphereDressAttireFloor;
    }
    
    public Integer getAtmosphereDressAttireCeiling()
    {
        return atmosphereDressAttireCeiling;
    }
    
    public boolean isGayAffirming()
    {
        return gayAfirming;
    }

    public double[] getLocation()
    {
        return location;
    }
    
    public void setGayAfirming(boolean gayAfirming)
    {
        this.gayAfirming = gayAfirming;
    }

    public void setAffiliations(Set<Affiliation> affiliations)
    {
        this.affiliations = affiliations;
    }
    
    public void setLanguages(Set<Language> languages)
    {
        this.languages = languages;
    }
    
    public void setServiceTimes(Set<ServiceTimeRange> serviceTimes)
    {
        this.serviceTimes = serviceTimes;
    }
    
    public void setServiceDays(Set<ServiceDay> serviceDays)
    {
        this.serviceDays = serviceDays;
    }
    
    public void setCongregationSizes(Set<CongregationSize> congregationSizes)
    {
        this.congregationSizes = congregationSizes;
    }
    
    public void setProgramsAndMinistries(Set<Programs> programsAndMinistries)
    {
        this.programsAndMinistries = programsAndMinistries;
    }
    
    public void setAccessabilitAccessibilitySupports(Set<AccessibilitySupport> accessibilitySupports)
    {
        this.accessibilitySupports = accessibilitySupports;
    }
    
    public void setAtmosphereServiceStyleFloor(Integer atmosphereServiceStyleFloor)
    {
        this.atmosphereServiceStyleFloor = atmosphereServiceStyleFloor;
    }
    
    public void setAtmosphereServiceStyleCeiling(Integer atmosphereServiceStyleCeiling)
    {
        this.atmosphereServiceStyleCeiling = atmosphereServiceStyleCeiling;
    }
    
    public void setAtmosphereMusicStyleFloor(Integer atmosphereMusicStyleFloor)
    {
        this.atmosphereMusicStyleFloor = atmosphereMusicStyleFloor;
    }
    
    public void setAtmosphereMusicStyleCeiling(Integer atmosphereMusicStyleCeiling)
    {
        this.atmosphereMusicStyleCeiling = atmosphereMusicStyleCeiling;
    }
    
    public void setAtmosphereDressAttireFloor(Integer atmosphereDressAttireFloor)
    {
        this.atmosphereDressAttireFloor = atmosphereDressAttireFloor;
    }
    
    public void setAtmosphereDressAttireCeiling(Integer atmosphereDressAttireCeiling)
    {
        this.atmosphereDressAttireCeiling = atmosphereDressAttireCeiling;
    }
    
    public void setLocation(double[] location)
    {
        this.location = location;
    }

    public Point getPoint()
    {
        if(location != null && location.length == 2 && location[0] != 0 && location[1] != 0)
        {
            return new Point(location[0], location[1]);
        }
        
        return null;
    }
}