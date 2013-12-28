/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AutoPopulatingList;
import org.springframework.webflow.execution.RequestContext;
import org.springframework.webflow.execution.RequestContextHolder;

import com.flockspring.dataaccess.mongodb.RegionRepository;
import com.flockspring.domain.types.AccessibilitySupport;
import com.flockspring.domain.types.Affiliation;
import com.flockspring.domain.types.DressAttire;
import com.flockspring.domain.types.Language;
import com.flockspring.domain.types.MusicStyle;
import com.flockspring.domain.types.Region;
import com.flockspring.domain.types.ServiceDay;
import com.flockspring.domain.types.ServiceStyle;
import com.flockspring.domain.types.impl.AddressImpl;
import com.flockspring.domain.types.impl.MultimediaObjectImpl;
import com.flockspring.domain.types.impl.LeaderImpl;
import com.flockspring.domain.types.impl.OrganizationImpl;
import com.flockspring.ui.model.CongregationSize;
import com.flockspring.ui.model.Programs;
import com.flockspring.ui.model.ServiceTimeRange;
import com.google.common.collect.Sets;

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
    private final RegionRepository regionRepository;

    @Autowired
    public CommonFormReferenceDataProvider(final OrganizationDiscoveryService organizationDiscoveryService, 
            final RegionRepository regionRepository)
    {
        this.organizationDiscoveryService = organizationDiscoveryService;
        this.regionRepository = regionRepository;
    }

    public void save(OrganizationImpl organization)
    {
        organizationDiscoveryService.saveOrganization(organization);
    }

    public List<Region> getStatesForLocale()
    {
        RequestContext context = RequestContextHolder.getRequestContext();
        Locale locale = context.getExternalContext().getLocale();
           
        return regionRepository.findStatesForISO3CountryCode(locale.getISO3Country());
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
