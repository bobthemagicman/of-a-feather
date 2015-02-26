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
package com.ofafeather.domain.types;

import java.util.Set;

import com.google.common.collect.ComparisonChain;
import com.ofafeather.domain.types.impl.AgeDemographics;
import com.ofafeather.domain.types.impl.MusicalInstruments;

/**
 * ChurchServiceImpl.java
 *
 * @author Justen L. Britain
 * @date Dec 16, 2013
 *
 */
public class ServiceDetailsImpl implements ServiceDetails, Comparable<ServiceDetails>
{

    private MusicStyle musicStyle;
    private ServiceStyle serviceStyle;
    private DressAttire dressAttire;
    private AgeDemographics ageDemongraphics;
    private Set<MusicalInstruments> instruments;
    private Integer durationInMinutes;
    private TimeAndDay timeAndDay;
    private String serviceName;
    private Set<Language> languages;
    
    public ServiceDetailsImpl(MusicStyle musicStyle, ServiceStyle serviceStyle, DressAttire dressAttire, AgeDemographics ageDemongraphics,
            Set<MusicalInstruments> instruments, int durationInMinutes, TimeAndDay timeAndDay, String serviceName, Set<Language> languages)
    {
        super();
        this.musicStyle = musicStyle;
        this.serviceStyle = serviceStyle;
        this.dressAttire = dressAttire;
        this.ageDemongraphics = ageDemongraphics;
        this.instruments = instruments;
        this.durationInMinutes = durationInMinutes;
        this.timeAndDay = timeAndDay;
        this.serviceName = serviceName;
        this.languages = languages;
    }

    @Override
    public MusicStyle getMusicStyle()
    {
        return musicStyle;
    }

    @Override
    public ServiceStyle getServiceStyle()
    {
        return serviceStyle;
    }

    @Override
    public DressAttire getDressAttire()
    {
        return dressAttire;
    }

    @Override
    public AgeDemographics getAgeDemongraphics()
    {
        return ageDemongraphics;
    }

    @Override
    public Set<MusicalInstruments> getInstruments()
    {
        return instruments;
    }

    @Override
    public int getDurationInMinutes()
    {
        return durationInMinutes;
    }

    @Override
    public TimeAndDay getTimeAndDay()
    {
        return timeAndDay;
    }
    
    @Override
    public String getServiceName()
    {
        return serviceName;
    }

    @Override
    public Set<Language> getLanguages()
    {
        return languages;
    }

    public void setMusicStyle(MusicStyle musicStyle)
    {
        this.musicStyle = musicStyle;
    }

    public void setServiceStyle(ServiceStyle serviceStyle)
    {
        this.serviceStyle = serviceStyle;
    }

    public void setDressAttire(DressAttire dressAttire)
    {
        this.dressAttire = dressAttire;
    }

    public void setAgeDemongraphics(AgeDemographics ageDemongraphics)
    {
        this.ageDemongraphics = ageDemongraphics;
    }

    public void setInstruments(Set<MusicalInstruments> instruments)
    {
        this.instruments = instruments;
    }

    public void setDurationInMinutes(int durationInMinutes)
    {
        this.durationInMinutes = durationInMinutes;
    }
    
    public void setTimeDay(TimeAndDay timeAndDay)
    {
        this.timeAndDay = timeAndDay;
    }

    public void setDurationInMinutes(Integer durationInMinutes)
    {
        this.durationInMinutes = durationInMinutes;
    }

    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }
    
    public void setTimeAndDay(TimeAndDay timeAndDay)
    {
        this.timeAndDay = timeAndDay;
    }

    public void setLanguages(Set<Language> languages)
    {
        this.languages = languages;
    }

    @Override
    public int compareTo(ServiceDetails right)
    {
        ServiceDetails left = this;
        return ComparisonChain.start()
                .compare(left.getTimeAndDay(), right.getTimeAndDay())
                .compare(left.getDurationInMinutes(), right.getDurationInMinutes())
                .result();
    }

    
}
