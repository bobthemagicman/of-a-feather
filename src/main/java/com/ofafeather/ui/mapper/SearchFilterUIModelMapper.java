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
package com.ofafeather.ui.mapper;

import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ofafeather.domain.OrganizationFilter;
import com.ofafeather.domain.types.DressAttire;
import com.ofafeather.domain.types.MusicStyle;
import com.ofafeather.domain.types.ServiceStyle;
import com.ofafeather.ui.model.SearchFilterUICommand;

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
