/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import java.util.Set;

import org.joda.time.LocalDateTime;

import com.flockspring.domain.types.DressAttire;
import com.flockspring.domain.types.MusicStyle;
import com.flockspring.domain.types.ServiceDay;
import com.flockspring.domain.types.ServiceStyle;
import com.flockspring.domain.types.impl.AgeDemographics;
import com.flockspring.domain.types.impl.MusicalInstruments;
import com.google.common.collect.ComparisonChain;

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
