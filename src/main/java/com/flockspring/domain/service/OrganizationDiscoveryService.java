/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.service;

import java.util.NavigableSet;

import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.Region;
import com.flockspring.domain.types.impl.OrganizationImpl;
import com.flockspring.ui.model.AjaxSearchFilterRequest;

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

    NavigableSet<Organization> searchForOrganizations(String query);

    NavigableSet<Organization> getFilteredOrganizations(AjaxSearchFilterRequest filterRequest);

    void saveOrganization(OrganizationImpl organization);
        
}
