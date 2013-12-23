/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain;

import java.util.Set;
import java.util.TreeSet;

import com.flockspring.domain.types.AccessabilitySupport;
import com.flockspring.domain.types.Affiliation;
import com.flockspring.domain.types.DressAttire;
import com.flockspring.domain.types.Language;
import com.flockspring.domain.types.MusicStyle;
import com.flockspring.domain.types.ServiceDay;
import com.flockspring.domain.types.ServiceStyle;
import com.flockspring.ui.model.CongregationSize;
import com.flockspring.ui.model.Programs;
import com.flockspring.ui.model.ServiceTimeRange;

/**
 * OrganizationFilter.java
 *
 * @author Justen L. Britain
 * @date Nov 9, 2013
 *
 */
public class OrganizationFilter
{

    private Set<ServiceDay> serviceDays = new TreeSet<>();
    private Set<ServiceTimeRange> serviceTimes = new TreeSet<>();
    private Set<Affiliation> denominations = new TreeSet<>();
    private Set<Language> languages = new TreeSet<>();
    private Set<Programs> programs = new TreeSet<>();
    private Set<CongregationSize> congregationSizes = new TreeSet<>();
    private Set<AccessabilitySupport> accessabilitySupports = new TreeSet<>();
    private Set<DressAttire> dressAttires = new TreeSet<>();
    private Set<MusicStyle> musicStyles = new TreeSet<>();
    private Set<ServiceStyle> serviceStyles = new TreeSet<>();
    private boolean gayAfirming = false;

    public OrganizationFilter(Set<ServiceDay> serviceDays, Set<ServiceTimeRange> serviceTimes, Set<Affiliation> denominations, Set<Language> languages,
            Set<Programs> programs, Set<CongregationSize> congregationSizes, Set<AccessabilitySupport> accessabilitySupports,
            Set<DressAttire> dressAttires, Set<MusicStyle> musicStyles, Set<ServiceStyle> serviceStyles, boolean gayAfirming)
    {
        super();
        
        this.serviceDays = serviceDays;
        this.serviceTimes = serviceTimes;
        this.denominations = denominations;
        this.languages = languages;
        this.programs = programs;
        this.congregationSizes = congregationSizes;
        this.accessabilitySupports = accessabilitySupports;
        this.dressAttires = dressAttires;
        this.musicStyles = musicStyles;
        this.serviceStyles = serviceStyles;
        this.gayAfirming = gayAfirming;
    }

    public boolean hasFilteredServiceDays()
    {
        return !serviceDays.isEmpty();
    }

    public boolean hasFilteredServiceTimes()
    {
        return !serviceTimes.isEmpty();
    }

    public boolean hasFilteredDenominations()
    {
        return !denominations.isEmpty();
    }

    public boolean hasFilteredCongregationSize()
    {
        return !congregationSizes.isEmpty();
    }

    public boolean hasFilteredServiceStyle()
    {
        return !serviceStyles.isEmpty();
    }

    public boolean hasFilteredMusicStyle()
    {
        return !musicStyles.isEmpty();
    }

    public boolean hasFilteredDressAttire()
    {
        return !dressAttires.isEmpty();
    }

    public boolean hasFilteredPrograms()
    {
        return !programs.isEmpty();
    }

    public boolean hasFilteredLanguages()
    {
        return !languages.isEmpty();
    }

    public boolean hasFilteredAccessibilityNeeds()
    {
        return !accessabilitySupports.isEmpty();
    }

    public Set<Affiliation> getFilteredDenominations()
    {
        
        return denominations;
    }

    public Set<ServiceTimeRange> getFilteredServiceTimes()
    {
        return serviceTimes;
    }
    
    public Set<Language> getFilteredLanguages()
    {
        return languages;
    }

    public Set<Programs> getFilteredPrograms()
    {
        return programs;
    }

    public Set<CongregationSize> getFilteredCongregationSize()
    {
        return congregationSizes;
    }

    public Set<AccessabilitySupport> getFilteredAccessabilitySupport()
    {
        return accessabilitySupports;
    }

    public Set<DressAttire> getFilteredDressAttire()
    {
        return dressAttires;
    }

    public Set<MusicStyle> getFilteredMusicStyle()
    {
        return musicStyles;
    }

    public Set<ServiceStyle> getFilteredServiceStyle()
    {
        return serviceStyles;
    }

    public Set<ServiceDay> getFilteredServiceDays()
    {
        return serviceDays;
    }
    
    public boolean isGayAfirming()
    {
        return gayAfirming;
    }
}
