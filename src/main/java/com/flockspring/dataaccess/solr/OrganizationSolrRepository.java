/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.solr;

import java.util.List;

import org.springframework.data.solr.core.geo.Distance;
import org.springframework.data.solr.core.geo.GeoLocation;
import org.springframework.data.solr.repository.SolrRepository;

import com.flockspring.domain.types.impl.OrganizationImpl;

/**
 * OrganizationRepository.java
 *
 * @author Justen L. Britain
 * @date Aug 3, 2013
 *
 */
public interface OrganizationSolrRepository extends SolrRepository<OrganizationImpl, Long>
{
    List<OrganizationImpl> findByAddressWithin(GeoLocation geoLoc, Distance dist);
}
