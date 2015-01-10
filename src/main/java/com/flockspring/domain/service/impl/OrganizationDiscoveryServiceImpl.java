/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoPage;
import org.springframework.data.mongodb.core.geo.Metrics;
import org.springframework.stereotype.Service;

import com.flockspring.dataaccess.mongodb.OrganizationRepository;
import com.flockspring.domain.OrganizationFilter;
import com.flockspring.domain.service.OrganizationDiscoveryService;
import com.flockspring.domain.types.Address;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.impl.OrganizationImpl;
import com.google.common.collect.Lists;

@Service
public class OrganizationDiscoveryServiceImpl implements OrganizationDiscoveryService
{

    private final OrganizationRepository organizationRepository;
    
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
    }

    @Override
    public Organization getOrganization(String organizationId)
    {
        return findOrganizationById(organizationId);
    }

    private OrganizationImpl findOrganizationById(String organizationId)
    {
        return organizationRepository.findOne(organizationId);
    }

    @Override
    public GeoPage<OrganizationImpl> getFilteredOrganizations(OrganizationFilter filter, int pageNum)
    {
        return this.getFilteredOrganizations(filter, pageNum, this.defaultDistance);
        
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

    @Override
    public List<OrganizationImpl> getOrganizationsByIds(Iterable<String> organizationIds)
    {
        return Lists.newArrayList(organizationRepository.findAll(organizationIds));        
    }

    @Override
    public GeoPage<OrganizationImpl> getFilteredOrganizations(OrganizationFilter filter, int pageNum, int dist)
    {
    	//TODO:needs fixed for internationalization
        Distance d = new Distance(dist, Metrics.MILES);
        
        PageRequest page = new PageRequest(pageNum, defaultPageSize);
        return organizationRepository.findOrganizationsByFilteredCriteria(filter.getSearchPoint(), d, filter, page);
    }

	@Override
    public List<Organization> getOrganizationsForRegion(Address address)
    {
	    String city = address.getCity();
	    String state = address.getState();
	    String country = address.getCountry();
	    
	    return organizationRepository.findByAddressCityAndAddressStateAndAddressCountry(city, state, country);
    }

	@Override
    public Organization getOrganization(Address address, String organizationName)
    {
		String city = address.getCity();
		String state = address.getState();
		String country = address.getCountry();
		
	    return organizationRepository.findByAddressCityAndAddressStateAndAddressCountryAndName(city, state, country, organizationName);
    }
}
