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

import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

import com.ofafeather.domain.OrganizationFilter;
import com.ofafeather.domain.types.AccessibilitySupport;
import com.ofafeather.domain.types.DressAttire;
import com.ofafeather.domain.types.MusicStyle;
import com.ofafeather.domain.types.ServiceStyle;
import com.ofafeather.ui.model.SearchFilterUICommand;

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

    public OrganizationFilter map(SearchFilterUICommand filterRequest, String query)
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
                filterRequest.getCongregationSizes(), accessibilitySupports, dressAttires, musicStyles, serviceStyles, filterRequest.isGayAffirming(),
                filterRequest.getPoint(), query);

        return organizationFilter;
    }

    private Set<DressAttire> getDressAttireValues(Integer atmosphereDressAttireFloor, Integer atmosphereDressAttireCeiling)
    {

        Set<DressAttire> dressAttireSet = new TreeSet<>();

        // if you remove SPECTRUM_MIN and MAX add ordinal math here as the UI is not zero based
        if (atmosphereDressAttireCeiling != null && atmosphereDressAttireFloor != null &&
            atmosphereDressAttireFloor != DressAttire.FORMAL_1.ordinal() + 1 && atmosphereDressAttireCeiling != DressAttire.CASUAL_10.ordinal() + 1)
        {
            int x = atmosphereDressAttireFloor - 1;
            while (x < atmosphereDressAttireCeiling)
            {
                dressAttireSet.add(DressAttire.values()[(x++)]);
            }
        }
        
        return dressAttireSet;
    }

    private Set<MusicStyle> getMusicStyleValues(Integer atmosphereMusicStyleFloor, Integer atmosphereMusicStyleCeiling)
    {

        Set<MusicStyle> musicStyleSet = new TreeSet<>();

        // if you remove SPECTRUM_MIN and MAX add ordinal math here as the UI is not zero based
        if(atmosphereMusicStyleFloor != null && atmosphereMusicStyleCeiling != null && 
           atmosphereMusicStyleFloor != MusicStyle.TRADITIONAL_1.ordinal() + 1 && atmosphereMusicStyleCeiling != MusicStyle.CONTEMPORARY_8.ordinal() + 1)
        {
            int x = atmosphereMusicStyleFloor - 1;
            while (x < atmosphereMusicStyleCeiling)
            {
                musicStyleSet.add(MusicStyle.values()[(x++)]);
            }
        }
        
        return musicStyleSet;
    }

    private Set<ServiceStyle> getServiceStyleValues(Integer atmosphereServiceStyleFloor, Integer atmosphereServiceStyleCeiling)
    {

        Set<ServiceStyle> serviceStyleSet = new TreeSet<>();

        if(atmosphereServiceStyleFloor != null && atmosphereServiceStyleCeiling != null &&
           atmosphereServiceStyleFloor != ServiceStyle.CONSERVATIVE_1.ordinal() && atmosphereServiceStyleCeiling != ServiceStyle.HIGH_ENERGY_10.ordinal())
        {
            int x = atmosphereServiceStyleFloor - 1;
            while (x < atmosphereServiceStyleCeiling)
            {
                serviceStyleSet.add(ServiceStyle.values()[(x++)]);
            }

        }
        
        return serviceStyleSet;
    }

}
