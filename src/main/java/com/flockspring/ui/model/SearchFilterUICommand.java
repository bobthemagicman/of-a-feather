/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import java.util.Set;

import com.flockspring.domain.types.Affiliation;
import com.flockspring.domain.types.Language;
import com.flockspring.domain.types.ServiceDay;

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
    private Set<CongregationSize> congregationSize;
    private Set<Programs> programsAndMinistries;
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
            Set<ServiceDay> serviceDays, Set<CongregationSize> congregationSize, Set<Programs> programsAndMinistries,
            Integer atmosphereServiceStyleFloor, Integer atmosphereServiceStyleCeiling, Integer atmosphereMusicStyleFloor,
            Integer atmosphereMusicStyleCeiling, Integer atmosphereDressAttireFloor, Integer atmosphereDressAttireCeiling, boolean gayAfirming,
            double[] location)
    {
        super();
        
        this.affiliations = affiliations;
        this.languages = languages;
        this.serviceTimes = serviceTimes;
        this.serviceDays = serviceDays;
        this.congregationSize = congregationSize;
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
    
    public Set<CongregationSize> getCongregationSize()
    {
        return congregationSize;
    }
    
    public Set<Programs> getProgramsAndMinistries()
    {
        return programsAndMinistries;
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
    
    public boolean isGayAfirming()
    {
        return gayAfirming;
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
    
    public void setCongregationSize(Set<CongregationSize> congregationSize)
    {
        this.congregationSize = congregationSize;
    }
    
    public void setProgramsAndMinistries(Set<Programs> programsAndMinistries)
    {
        this.programsAndMinistries = programsAndMinistries;
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

    public double[] getLocation()
    {
        return location;
    }
}