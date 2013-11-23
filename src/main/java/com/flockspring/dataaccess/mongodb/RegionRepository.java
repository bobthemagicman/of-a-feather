/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.dataaccess.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flockspring.domain.types.Region;
import com.flockspring.domain.types.impl.GlobalRegionImpl;
import com.flockspring.domain.types.impl.OrganizationImpl;

public interface RegionRepository extends MongoRepository<GlobalRegionImpl, Long>
{

//    @Query("") 
//    Region findByOrganizationInRegionOrganizations(@Param("organization") OrganizationImpl organizationId);
}
