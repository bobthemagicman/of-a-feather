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
package com.ofafeather.domain.types.impl;

import java.util.Set;
import java.util.TreeSet;

import com.ofafeather.domain.types.ServiceDetails;
import com.ofafeather.domain.types.ServiceDetailsImpl;
import com.ofafeather.ui.model.CongregationSize;

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
            boolean gayAffirming, boolean homeChurch)
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
