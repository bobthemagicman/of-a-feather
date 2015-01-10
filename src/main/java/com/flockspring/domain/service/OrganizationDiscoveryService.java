/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.service;

import java.util.List;

import org.springframework.data.mongodb.core.geo.GeoPage;

import com.flockspring.domain.OrganizationFilter;
import com.flockspring.domain.types.Address;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.impl.OrganizationImpl;

/**
 * IOrganizationService.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public interface OrganizationDiscoveryService {

    GeoPage<OrganizationImpl> getFilteredOrganizations(final OrganizationFilter filterRequest, final int page);
    
    GeoPage<OrganizationImpl> getFilteredOrganizations(final OrganizationFilter filterRequest, final int page, final int dist);

    void saveOrganization(final OrganizationImpl organization);
    
	Organization getOrganization(final String OrganizationId);

	List<Organization> getOrganizationsForRegion(final Address address);
	
	List<OrganizationImpl> getOrganizationsByIds(final Iterable<String> organizationIds);

	Organization getOrganization(Address address, String organizationName);
}
