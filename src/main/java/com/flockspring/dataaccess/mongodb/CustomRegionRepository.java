/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.mongodb;

import java.util.List;

import com.flockspring.domain.types.Region;
import com.flockspring.domain.types.impl.OrganizationImpl;

/**
 * CustomRegionRepository.java
 *
 * @author Justen L. Britain
 * @date Dec 8, 2013
 *
 */
public interface CustomRegionRepository<T, ID>
{
    List<Region> findStatesForISO3CountryCode(String iso3CountryCode);

    Region findByOrganizationInRegionOrganizations(OrganizationImpl organizationId);
}
