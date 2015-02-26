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
package com.ofafeather.domain.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ofafeather.domain.types.Affiliation;
import com.ofafeather.domain.types.ServiceDay;
import com.ofafeather.domain.types.impl.OrganizationImpl;
import com.ofafeather.ui.model.ServiceTimeRange;

/**
 * CommonFormReferenceDataProvider.java
 * 
 * @author Justen L. Britain
 * @date Nov 27, 2013
 * 
 */
@Component
public class CommonFormReferenceDataProvider
{
    private final OrganizationDiscoveryService organizationDiscoveryService;

    @Autowired
    public CommonFormReferenceDataProvider(final OrganizationDiscoveryService organizationDiscoveryService)
    {
        this.organizationDiscoveryService = organizationDiscoveryService;
    }

    public void save(OrganizationImpl organization)
    {
        organizationDiscoveryService.saveOrganization(organization);
    }

    public List<Affiliation> getDenominations()
    {
        return Arrays.asList(Affiliation.values());
    }

    public List<ServiceTimeRange> getServiceTimes()
    {
        return Arrays.asList(ServiceTimeRange.values());
    }

    public List<ServiceDay> getServiceDays()
    {
        return Arrays.asList(ServiceDay.values());
    }
}
