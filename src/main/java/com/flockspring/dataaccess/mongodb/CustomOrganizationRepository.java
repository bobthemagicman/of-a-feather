/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.mongodb;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoPage;
import org.springframework.data.mongodb.core.geo.Point;

import com.flockspring.domain.OrganizationFilter;

/**
 * CustomOrganizationRepository.java
 *
 * @author Justen L. Britain
 * @date Nov 9, 2013
 *
 */
public interface CustomOrganizationRepository<T, ID> 
{
    public GeoPage<T> findOrganizationsByFilteredCriteria(Point p, Distance d, OrganizationFilter o, PageRequest pageRequest);    
}
