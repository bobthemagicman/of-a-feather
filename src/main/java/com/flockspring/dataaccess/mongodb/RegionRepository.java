/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.dataaccess.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flockspring.domain.types.impl.GlobalRegionImpl;

public interface RegionRepository extends MongoRepository<GlobalRegionImpl, String>, CustomRegionRepository<GlobalRegionImpl, String>
{
    
    
}
