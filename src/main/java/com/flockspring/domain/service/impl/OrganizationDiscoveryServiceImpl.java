/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoPage;
import org.springframework.data.mongodb.core.geo.Metrics;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flockspring.dataaccess.mongodb.OrganizationRepository;
import com.flockspring.domain.OrganizationFilter;
import com.flockspring.domain.service.OrganizationDiscoveryService;
import com.flockspring.domain.types.Address;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.Region;
import com.flockspring.domain.types.impl.OrganizationImpl;

@Service
public class OrganizationDiscoveryServiceImpl implements OrganizationDiscoveryService
{

    private final OrganizationRepository organizationRepository;
//    private final RegionRepository regionRepository;
    
    private final int defaultDistance;
    private final int defaultPageSize;

    @Autowired
    public OrganizationDiscoveryServiceImpl(final OrganizationRepository organizationRepository,
            @Value("${com.flockspring.domain.service.organization.default.distance}") final int defaultDistance,
            @Value("${com.flockspring.domain.service.organization.default.pageSize}") final int defaultPageSize)
    {
        super();

        
        this.organizationRepository = organizationRepository;
        this.defaultDistance = defaultDistance;
        this.defaultPageSize = defaultPageSize;
//        this.regionRepository = regionRepository;
    }

    @Override
    public Organization getOrganizationByNameAndRegion(String name, Long regionId)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Region getRegionForOrganization(String organizationId)
    {
        OrganizationImpl organization = findOrganizationById(organizationId);
        return null;//regionRepository.findByOrganizationInRegionOrganizations(organization);
    }

    @Override
    public Organization getOrganizationById(String organizationId)
    {
        return findOrganizationById(organizationId);
    }

    private OrganizationImpl findOrganizationById(String organizationId)
    {
        return organizationRepository.findOne(organizationId);
    }

    @Override
    @Transactional(readOnly = true)
    public Organization getOrganizationByRegionAndOrganizationNames(String organizationName, String stateRegionName, String cityRegionName,
            String neighborhoodRegionName)
    {
        String parentRegion = neighborhoodRegionName == null ? cityRegionName : neighborhoodRegionName;
        organizationName = organizationName.replaceAll("-", "%");

//        OrganizationImpl organization = organizationRepository.findByNameAndRegion(organizationName, parentRegion);

        return null;
    }

    @Override
    public Organization getOrganizationByRegionAndOrganizationNames(String organizationName, String stateRegionName, String cityRegionName)
    {
        return getOrganizationByRegionAndOrganizationNames(organizationName, stateRegionName, cityRegionName, null);
    }

    @Override
    public GeoPage<OrganizationImpl> getFilteredOrganizations(OrganizationFilter filter, int pageNum)
    {
        
        Distance d = new Distance(this.defaultDistance, Metrics.MILES);
        
        PageRequest page = new PageRequest(pageNum, defaultPageSize);
        return organizationRepository.findOrganizationsByFilteredCriteria(filter.getSearchPoint(), d, filter, page);
    }

    @Override
    public void saveOrganization(OrganizationImpl organization)
    {
        processImages(organization);
        organizationRepository.save(organization);        
    }

    private void processImages(OrganizationImpl organization)
    {
        // TODO Auto-generated method stub
        
    }
}
