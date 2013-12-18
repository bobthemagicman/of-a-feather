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

    private Set<Affiliation> affiliations;
    private Set<Language> languages;
    private Set<ServiceTime> serviceTimes;
    private Set<ServiceDay> serviceDays;
    private Set<CongregationSize> congregationSize;
    private Set<SpecialNeedsSupport> specialNeedsSupport;
    private Set<Programs> childCarePrograms;
    private Pair<Integer, Integer> atmosphereServiceStyle;
    private Pair<Integer, Integer> atmosphereMusicStyle;
    private Pair<Integer, Integer> atmosphereDressAttire;
   
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
