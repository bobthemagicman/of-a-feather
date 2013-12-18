/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.dataaccess.mongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flockspring.domain.types.Region;
import com.flockspring.domain.types.impl.GlobalRegionImpl;
import com.flockspring.domain.types.impl.OrganizationImpl;

public interface RegionRepository extends MongoRepository<GlobalRegionImpl, String>, CustomRegionRepository<GlobalRegionImpl, String>
{
    
    
}
