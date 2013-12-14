/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import java.util.Set;

import com.flockspring.domain.types.DressAttire;
import com.flockspring.domain.types.MusicStyle;
import com.flockspring.domain.types.ServiceStyle;
import com.flockspring.ui.model.CongregationSize;

/**
 * AtmosphereImpl.java
 *
 * @author Justen L. Britain
 * @date Dec 8, 2013
 *
 */
public class AtmosphereImpl implements Atmosphere
{

    private CongregationSize congregationSize;
    private MusicStyle musicStyle;
    private ServiceStyle serviceStyle;
    private DressAttire dressAttire;
    private AgeDemographics ageDemongraphics;
    private Set<MusicalInstruments> instruments;
    private boolean gayAffirming;
    private boolean homeChurch;
   
    @Override
    public CongregationSize getCongregationSize()
    {
        return congregationSize;
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
    public boolean isGayAffirming()
    {
        return gayAffirming;
    }
    
    @Override
    public boolean isHomeChurch()
    {
        return homeChurch;
    }
    
    public void setCongregationSize(CongregationSize congregationSize)
    {
        this.congregationSize = congregationSize;
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

    public void setGayAffirming(boolean gayAffirming)
    {
        this.gayAffirming = gayAffirming;
    }

    public void setHomeChurch(boolean homeChurch)
    {
        this.homeChurch = homeChurch;
    }
}
