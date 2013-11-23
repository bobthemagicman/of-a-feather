/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.mongodb;

import org.springframework.data.mongodb.core.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoResults;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.flockspring.domain.types.impl.OrganizationImpl;

/**
 * OrganizationRepository.java
 *
 * @author Justen L. Britain
 * @date Nov 5, 2013
 *
 */
public interface OrganizationRepository extends MongoRepository<OrganizationImpl, String>, CustomOrganizationRepository<OrganizationImpl, String>
{
    GeoResults<OrganizationImpl> findByAddressLocationNear(Point point, Distance distance);

    OrganizationImpl findByNameAndRegion(String organizationName, String parentRegion);
}
