/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

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
public class AjaxSearchFilterRequest
{

    private final Set<Affiliation> affiliations;
    private final Set<Language> languages;
    private final Set<ServiceTime> serviceTimes;
    private final Set<ServiceDay> serviceDays;
    private final Set<CongregationSize> congregationSize;
    private final Set<SpecialNeedsSupport> specialNeedsSupport;
    private final Set<Programs> childCarePrograms;
    private final Pair<Integer, Integer> atmosphereServiceStyle;
    private final Pair<Integer, Integer> atmosphereMusicStyle;
    private final Pair<Integer, Integer> atmosphereDressAttire;
   
    public AjaxSearchFilterRequest(final Set<Affiliation> affiliations, final Set<Language> languages, 
            final Set<ServiceTime> serviceTimes, final Set<ServiceDay> serviceDays, final Set<CongregationSize> congregationSize, 
            final Set<SpecialNeedsSupport> specialNeedsSupport, final Set<Programs> childCarePrograms, 
            final Pair<Integer, Integer> atmosphereServiceStyle, final Pair<Integer, Integer> atmosphereMusicStyle,
            final Pair<Integer, Integer> atmosphereDressAttire)
    {
        super();
        
        this.affiliations = affiliations;
        this.languages = languages;
        this.serviceTimes = serviceTimes;
        this.serviceDays = serviceDays;
        this.congregationSize = congregationSize;
        this.specialNeedsSupport = specialNeedsSupport;
        this.childCarePrograms = childCarePrograms;
        this.atmosphereServiceStyle = atmosphereServiceStyle;
        this.atmosphereMusicStyle = atmosphereMusicStyle;
        this.atmosphereDressAttire = atmosphereDressAttire;
    }

    public Set<Affiliation> getAffiliations()
    {
        return affiliations;
    }

    public Set<Language> getLanguages()
    {
        return languages;
    }

    public Set<ServiceTime> getServiceTimes()
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

    public Set<SpecialNeedsSupport> getSpecialNeedsSupport()
    {
        return specialNeedsSupport;
    }

    public Set<Programs> getChildCarePrograms()
    {
        return childCarePrograms;
    }

    public Pair<Integer, Integer> getAtmosphereServiceStyle()
    {
        return atmosphereServiceStyle;
    }

    public Pair<Integer, Integer> getAtmosphereMusicStyle()
    {
        return atmosphereMusicStyle;
    }

    public Pair<Integer, Integer> getAtmosphereDressAttire()
    {
        return atmosphereDressAttire;
    }
}
