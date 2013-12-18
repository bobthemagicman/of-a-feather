/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import java.util.Set;
import java.util.TreeSet;

import com.flockspring.domain.types.ServiceDetails;
import com.flockspring.domain.types.ServiceDetailsImpl;
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
    private Set<ServiceDetailsImpl> serviceDetails;
    private boolean gayAffirming;
    private boolean homeChurch;
   
    public AtmosphereImpl()
    {
        super();
    }
            
    public AtmosphereImpl(CongregationSize congregationSize, Set<ServiceDetailsImpl> services, 
            boolean gayAffirming, boolean homeChurch, int durationInMinutes)
    {
        super();
        
        this.congregationSize = congregationSize;
        this.gayAffirming = gayAffirming;
        this.homeChurch = homeChurch;
        this.serviceDetails = services;
    }

    @Override
    public CongregationSize getCongregationSize()
    {
        return congregationSize;
    }
    
    @Override
    public Set<ServiceDetails> getServiceDetails()
    {
        Set<ServiceDetails> serviceDetailsSet = new TreeSet<>();
        if (serviceDetails != null)
        {
            serviceDetailsSet.addAll(serviceDetails);
        }

        return serviceDetailsSet;
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
    
    public void setGayAffirming(boolean gayAffirming)
    {
        this.gayAffirming = gayAffirming;
    }

    public void setHomeChurch(boolean homeChurch)
    {
        this.homeChurch = homeChurch;
    }
}
