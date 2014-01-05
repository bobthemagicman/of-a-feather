/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.service;

import org.springframework.data.mongodb.core.geo.GeoPage;

import com.flockspring.domain.OrganizationFilter;
import com.flockspring.domain.types.Address;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.Region;
import com.flockspring.domain.types.impl.OrganizationImpl;

/**
 * IOrganizationService.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public interface OrganizationDiscoveryService {

    Organization getOrganizationByNameAndRegion(String name, Long regionId);

    Region getRegionForOrganization(String OrganizationId);
    
    Organization getOrganizationById(String OrganizationId);
    
    Organization getOrganizationByRegionAndOrganizationNames(String organizationName, String stateRegionName, String cityRegionName, String neighborhoodRegionName);
    
    Organization getOrganizationByRegionAndOrganizationNames(String organizationName, String stateRegionName, String cityRegionName);

    GeoPage<OrganizationImpl> searchForOrganizations(Address address, int page);

    GeoPage<OrganizationImpl> getFilteredOrganizations(OrganizationFilter filterRequest);

    void saveOrganization(OrganizationImpl organization);
        
}
