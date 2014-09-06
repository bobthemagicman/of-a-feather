/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.mapper;

import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.flockspring.domain.OrganizationFilter;
import com.flockspring.domain.types.DressAttire;
import com.flockspring.domain.types.MusicStyle;
import com.flockspring.domain.types.ServiceStyle;
import com.flockspring.ui.model.SearchFilterUICommand;

/**
 * SearchFilterUIModelMapper.java
 * 
 * @author Justen L. Britain
 * @date Dec 26, 2013
 * 
 */
@Component
public class SearchFilterUIModelMapper
{

    public SearchFilterUICommand map(OrganizationFilter organizationFilter)
    {

        return new SearchFilterUICommand(organizationFilter.getFilteredDenominations(), organizationFilter.getFilteredLanguages(),
                organizationFilter.getFilteredServiceTimes(), organizationFilter.getFilteredServiceDays(),
                organizationFilter.getFilteredCongregationSize(), organizationFilter.getFilteredPrograms(),
                getAtmosphereServiceStyleFloor(organizationFilter.getFilteredServiceStyle()),
                getAtmosphereServiceStyleCeiling(organizationFilter.getFilteredServiceStyle()),
                getAtmosphereMusicSyleFloor(organizationFilter.getFilteredMusicStyle()),
                getAtmosphereMusicSyleCeiling(organizationFilter.getFilteredMusicStyle()),
                getAtmosphereDressAttireFloor(organizationFilter.getFilteredDressAttire()),
                getAtmosphereDressAttireCeiling(organizationFilter.getFilteredDressAttire()), organizationFilter.isGayAfirming(), 
                organizationFilter.getSearchPoint().asArray(), organizationFilter.getFilteredAccessibilitySupport());
    }

    private Integer getAtmosphereMusicSyleFloor(Set<MusicStyle> filteredMusicStyle)
    {
        return null;
    }
    
    private Integer getAtmosphereMusicSyleCeiling(Set<MusicStyle> filteredMusicStyle)
    {
        for (Iterator<MusicStyle> i = filteredMusicStyle.iterator(); i.hasNext();)
        {
            MusicStyle m = i.next();
            if (!i.hasNext())
            {
                return m.ordinal() + 1;
            }
        }

        return MusicStyle.CONTEMPORARY_8.ordinal() + 1;
    }
    
    private Integer getAtmosphereDressAttireFloor(Set<DressAttire> filteredDressAttire)
    {
        return filteredDressAttire.iterator().hasNext() ? filteredDressAttire.iterator().next().ordinal() + 1 : 1;
    }

    private Integer getAtmosphereDressAttireCeiling(Set<DressAttire> filteredDressAttire)
    {
        for (Iterator<DressAttire> i = filteredDressAttire.iterator(); i.hasNext();)
        {
            DressAttire d = i.next();
            if (!i.hasNext())
            {
                return d.ordinal() + 1;
            }
        }

        return DressAttire.CASUAL_10.ordinal() + 1;
    }

    private Integer getAtmosphereServiceStyleFloor(Set<ServiceStyle> filteredServiceStyle)
    {
        return filteredServiceStyle.iterator().hasNext() ? filteredServiceStyle.iterator().next().ordinal() + 1 : 1;
    }
    
    private Integer getAtmosphereServiceStyleCeiling(Set<ServiceStyle> filteredServiceStyle)
    {
        for (Iterator<ServiceStyle> i = filteredServiceStyle.iterator(); i.hasNext();)
        {
            ServiceStyle s = i.next();
            if (!i.hasNext())
            {
                return s.ordinal() + 1;
            }
        }

        return ServiceStyle.HIGH_ENERGY_10.ordinal() + 1;
    }
}
