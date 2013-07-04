/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.service;

import com.flockspring.domain.types.Organization;
import com.lehman.technology.group.common.domain.types.GlobalRegion;

/**
 * IOrganizationService.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public interface OrganizationDiscoveryService {

    Organization getOrganizationByNameAndRegion(String name, Long regionId);

    GlobalRegion getRegionForOrganization(Long OrganizationId);
    
    Organization getOrganizationById(Long OrganizationId);
    
    Organization getOrganizationByRegionAndOrganizationNames(String organizationName, String stateRegionName, String cityRegionName, String neighborhoodRegionName);
    
    Organization getOrganizationByRegionAndOrganizationNames(String organizationName, String stateRegionName, String cityRegionName);
}
