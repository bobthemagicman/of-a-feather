/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.mongodb;

import org.springframework.data.mongodb.core.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoResults;
import org.springframework.data.mongodb.core.geo.Point;

import com.flockspring.domain.OrganizationFilter;
import com.flockspring.domain.types.impl.OrganizationImpl;

/**
 * CustomOrganizationRepository.java
 *
 * @author Justen L. Britain
 * @date Nov 9, 2013
 *
 */
public interface CustomOrganizationRepository<T, ID>
{
    public GeoResults<OrganizationImpl> findOrganizationsByFilteredCriteria(Point p, Distance d, OrganizationFilter o, int pageSize);    
}
