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
package com.ofafeather.ui.model;

import java.util.Set;

import org.joda.time.LocalDateTime;

import com.google.common.collect.ComparisonChain;
import com.ofafeather.domain.types.DressAttire;
import com.ofafeather.domain.types.MusicStyle;
import com.ofafeather.domain.types.ServiceDay;
import com.ofafeather.domain.types.ServiceStyle;
import com.ofafeather.domain.types.impl.AgeDemographics;
import com.ofafeather.domain.types.impl.MusicalInstruments;

/**
 * ServiceDetailUIModel.java
 *
 * @author Justen L. Britain
 * @date Dec 15, 2013
 *
 */
public class ServiceDetailUIModel implements Comparable<ServiceDetailUIModel>
{
    private final String serviceName;
    private final Set<MusicalInstruments> musicalInstruments;
    private final MusicStyle musicStyle;
    private final ServiceStyle serviceStyle;
    private final AgeDemographics ageDemographics;
    private final DressAttire dressAttire;
    
    //these are for ordering only
    private final ServiceDay serviceDay;
    private final LocalDateTime serviceTime;
       
    public ServiceDetailUIModel(String serviceName, Set<MusicalInstruments> musicalInstruments, MusicStyle musicStyle, ServiceStyle serviceStyle,
            AgeDemographics ageDemographics, DressAttire dressAttire, ServiceDay serviceDay, LocalDateTime serviceTime)
    {
        super();
        this.serviceName = serviceName;
        this.musicalInstruments = musicalInstruments;
        this.musicStyle = musicStyle;
        this.serviceStyle = serviceStyle;
        this.ageDemographics = ageDemographics;
        this.dressAttire = dressAttire;
        this.serviceDay = serviceDay;
        this.serviceTime = serviceTime;
    }

    public String getServiceName()
    {
        return serviceName;
    }

    public Set<MusicalInstruments> getMusicalInstruments()
    {
        return musicalInstruments;
    }

    public MusicStyle getMusicStyle()
    {
        return musicStyle;
    }

    public ServiceStyle getServiceStyle()
    {
        return serviceStyle;
    }

    public AgeDemographics getAgeDemographics()
    {
        return ageDemographics;
    }

    public DressAttire getDressAttire()
    {
        return dressAttire;
    }

    @Override
    public int compareTo(ServiceDetailUIModel right)
    {
        ServiceDetailUIModel left = this;
        return ComparisonChain.start()
                .compare(left.serviceDay, right.serviceDay)
                .compare(left.serviceTime, right.serviceTime)
                .result();
    }
}
