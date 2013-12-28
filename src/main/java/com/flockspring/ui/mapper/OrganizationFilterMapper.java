/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.mapper;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

import com.flockspring.domain.OrganizationFilter;
import com.flockspring.domain.types.AccessibilitySupport;
import com.flockspring.domain.types.DressAttire;
import com.flockspring.domain.types.MusicStyle;
import com.flockspring.domain.types.ServiceStyle;
import com.flockspring.ui.model.SearchFilterUICommand;

/**
 * OrganizationFilterMapper.java
 * 
 * @author Justen L. Britain
 * @date Dec 23, 2013
 * 
 */
@Component
public class OrganizationFilterMapper
{

    public OrganizationFilter map(SearchFilterUICommand filterRequest)
    {

        Set<AccessibilitySupport> accessibilitySupports = null;
        Set<DressAttire> dressAttires = getDressAttireValues(filterRequest.getAtmosphereDressAttireFloor(),
                filterRequest.getAtmosphereDressAttireCeiling());

        Set<MusicStyle> musicStyles = getMusicStyleValues(filterRequest.getAtmosphereMusicStyleFloor(),
                filterRequest.getAtmosphereMusicStyleCeiling());
        
        Set<ServiceStyle> serviceStyles = getServiceStyleValues(filterRequest.getAtmosphereServiceStyleFloor(), 
                filterRequest.getAtmosphereServiceStyleCeiling());

        OrganizationFilter organizationFilter = new OrganizationFilter(filterRequest.getServiceDays(), filterRequest.getServiceTimes(),
                filterRequest.getAffiliations(), filterRequest.getLanguages(), filterRequest.getProgramsAndMinistries(),
                filterRequest.getCongregationSize(), accessibilitySupports, dressAttires, musicStyles, serviceStyles, filterRequest.isGayAfirming(),
                filterRequest.getLocation());

        return organizationFilter;
    }

    private Set<DressAttire> getDressAttireValues(Integer atmosphereDressAttireFloor, Integer atmosphereDressAttireCeiling)
    {
        Set<DressAttire> dressAttireSet = new TreeSet<>();
        
        int x = atmosphereDressAttireFloor;
        while(x < atmosphereDressAttireCeiling)
        {
            dressAttireSet.add(DressAttire.values()[(x++)-1]);            
        }
        
        return dressAttireSet;
    }

    private Set<MusicStyle> getMusicStyleValues(Integer atmosphereMusicStyleFloor, Integer atmosphereMusicStyleCeiling)
    {

        Set<MusicStyle> musicStyleSet = new TreeSet<>();
        
        int x = atmosphereMusicStyleFloor;
        while(x < atmosphereMusicStyleCeiling)
        {
            musicStyleSet.add(MusicStyle.values()[(x++)-1]);            
        }
        
        return musicStyleSet;
    }

    private Set<ServiceStyle> getServiceStyleValues(Integer atmosphereServiceStyleFloor, Integer atmosphereServiceStyleCeiling)
    {

        Set<ServiceStyle> serviceStyleSet = new TreeSet<>();
        
        int x = atmosphereServiceStyleFloor;
        while(x < atmosphereServiceStyleCeiling)
        {
            serviceStyleSet.add(ServiceStyle.values()[(x++)-1]);            
        }
        
        return serviceStyleSet;
    }

}
