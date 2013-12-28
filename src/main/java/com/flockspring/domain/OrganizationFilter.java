/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.data.mongodb.core.geo.Point;

import com.flockspring.domain.types.AccessibilitySupport;
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
    private Set<Affiliation> denominations = new TreeSet<>();
    private Set<Language> languages = new TreeSet<>();
    private Set<Programs> programs = new TreeSet<>();
    private Set<CongregationSize> congregationSizes = new TreeSet<>();
    private Set<AccessibilitySupport> accessibilitySupports = new TreeSet<>();
    private Set<DressAttire> dressAttires = new TreeSet<>();
    private Set<MusicStyle> musicStyles = new TreeSet<>();
    private Set<ServiceStyle> serviceStyles = new TreeSet<>();
    private boolean gayAfirming = false;
    private Point searchPoint = null;
    private Set<ServiceTimeRange> serviceTimes;

    public OrganizationFilter(Set<ServiceDay> serviceDays, Set<ServiceTimeRange> serviceTimes, Set<Affiliation> denominations, Set<Language> languages,
            Set<Programs> programs, Set<CongregationSize> congregationSizes, Set<AccessibilitySupport> accessibilitySupports,
            Set<DressAttire> dressAttires, Set<MusicStyle> musicStyles, Set<ServiceStyle> serviceStyles, boolean gayAfirming, double[] location)
    {
        super();
        
        this.serviceDays = serviceDays;
        this.denominations = denominations;
        this.languages = languages;
        this.programs = programs;
        this.congregationSizes = congregationSizes;
        this.accessibilitySupports = accessibilitySupports;
        this.dressAttires = dressAttires;
        this.musicStyles = musicStyles;
        this.serviceStyles = serviceStyles;
        this.gayAfirming = gayAfirming;
        this.serviceTimes = serviceTimes;
        
        if(location != null && location.length == 2)
        {
            this.searchPoint = new Point(location[0], location[1]);
        }
    }

    public boolean hasFilteredServiceDays()
    {
        return serviceDays != null && !serviceDays.isEmpty();
    }

    public boolean hasFilteredDenominations()
    {
        return denominations != null && !denominations.isEmpty();
    }

    public boolean hasFilteredCongregationSize()
    {
        return congregationSizes != null && !congregationSizes.isEmpty();
    }

    public boolean hasFilteredServiceStyle()
    {
        return serviceStyles != null && !serviceStyles.isEmpty();
    }

    public boolean hasFilteredMusicStyle()
    {
        return musicStyles != null && !musicStyles.isEmpty();
    }

    public boolean hasFilteredDressAttire()
    {
        return dressAttires != null && !dressAttires.isEmpty();
    }

    public boolean hasFilteredPrograms()
    {
        return programs != null && !programs.isEmpty();
    }

    public boolean hasFilteredLanguages()
    {
        return languages != null && !languages.isEmpty();
    }

    public boolean hasFilteredAccessibilityNeeds()
    {
        return accessibilitySupports != null && !accessibilitySupports.isEmpty();
    }
    
    public boolean hasFilteredServiceTimeRange()
    {
        return serviceTimes != null && !serviceTimes.isEmpty();
    }
    
    public Set<Affiliation> getFilteredDenominations()
    {
        
        return denominations;
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

    public Set<AccessibilitySupport> getFilteredAccessibilitySupport()
    {
        return accessibilitySupports;
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
    
    public Point getSearchPoint()
    {
        return searchPoint;
    }

    public Set<ServiceTimeRange> getFilteredServiceTimes()
    {
        return serviceTimes;
    }
}
