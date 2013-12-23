/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import java.util.Set;

import com.flockspring.domain.OrganizationFilter;
import com.flockspring.domain.types.AccessabilitySupport;
import com.flockspring.domain.types.Affiliation;
import com.flockspring.domain.types.DressAttire;
import com.flockspring.domain.types.Language;
import com.flockspring.domain.types.MusicStyle;
import com.flockspring.domain.types.ServiceDay;
import com.flockspring.domain.types.ServiceStyle;

/**
 * OrganizationFilterMapper.java
 *
 * @author Justen L. Britain
 * @date Dec 23, 2013
 *
 */
public class OrganizationFilterMapper
{

    public OrganizationFilter map(AjaxSearchFilterRequest filterRequest)
    {
        
        Set<ServiceTimeRange> serviceTimes;
        Set<Affiliation> denominations;
        Set<Language> languages;
        Set<Programs> programs;
        Set<CongregationSize> congregationSizes;
        Set<AccessabilitySupport> accessabilitySupports;
        Set<DressAttire> dressAttires;
        Set<MusicStyle> musicStyles;
        Set<ServiceStyle> serviceStyles;
        OrganizationFilter organizationFilter = new OrganizationFilter(filterRequest.getServiceDays(), serviceTimes, 
                filterRequest.getAffiliations(), filterRequest.getLanguages(), filterRequest.getProgramsAndMinistries(), 
                filterRequest.getCongregationSize(), accessabilitySupports, dressAttires, musicStyles, serviceStyles, 
                filterRequest.isGayAfirming());
        return organizationFilter;
    }
    
}
