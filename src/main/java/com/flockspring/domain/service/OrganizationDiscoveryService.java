/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.service;

import java.util.List;

import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.Region;

/**
 * IOrganizationService.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public interface OrganizationDiscoveryService {

    Organization getOrganizationByNameAndRegion(String name, Long regionId);

    Region getRegionForOrganization(Long OrganizationId);
    
    Organization getOrganizationById(Long OrganizationId);
    
    Organization getOrganizationByRegionAndOrganizationNames(String organizationName, String stateRegionName, String cityRegionName, String neighborhoodRegionName);
    
    Organization getOrganizationByRegionAndOrganizationNames(String organizationName, String stateRegionName, String cityRegionName);

    List<Organization> searchForOrganizations(String query);
}
