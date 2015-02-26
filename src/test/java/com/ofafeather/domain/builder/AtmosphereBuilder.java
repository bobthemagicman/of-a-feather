/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.ofafeather.domain.builder;

import java.util.Arrays;
import java.util.Set;

import com.google.common.collect.Sets;
import com.ofafeather.domain.types.ServiceDetailsImpl;
import com.ofafeather.domain.types.impl.AtmosphereImpl;
import com.ofafeather.ui.model.CongregationSize;

/**
 * AtmosphereBuilder.java
 *
 * @author Justen L. Britain
 * @date Jul 6, 2014
 *
 */
public class AtmosphereBuilder
{

    private CongregationSize congregationSize;
    private Set<ServiceDetailsImpl> services;
    private boolean gayAffirming;
    private boolean homeChurch;

    private boolean serviceSetReset = false;
    
    public AtmosphereBuilder()
    {
        congregationSize = CongregationSize.LARGE;
        services = Sets.newTreeSet(Arrays.asList(new ServiceDetailsBuilder().build()));
        gayAffirming = false;
        homeChurch = false;
    }
    
    public AtmosphereBuilder withCongregationSize(CongregationSize congregationSize)
    {
        this.congregationSize = congregationSize;
        return this;
    }
    
    public AtmosphereBuilder withServices(Set<ServiceDetailsImpl> services)
    {
        this.services = services;
        return this;
    }
    
    public AtmosphereBuilder asGayAffirming()
    {
        this.gayAffirming = true;
        return this;
    }
    
    public AtmosphereBuilder asHomeChurch()
    {
        this.homeChurch = true;
        return this;
    }
    
    public AtmosphereBuilder addService(ServiceDetailsImpl service)
    {
        if(!this.serviceSetReset || this.services == null)
        {
            this.services = Sets.newTreeSet(Arrays.asList(service));
            this.serviceSetReset = true;
        }
        else
        {
            this.services.add(service);
        }
        
        return this;
    }
    
    public AtmosphereImpl build()
    {
        return new AtmosphereImpl(congregationSize, services, gayAffirming, homeChurch);
    }
}
