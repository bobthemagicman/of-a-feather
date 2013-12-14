/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.mongodb.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.flockspring.dataaccess.mongodb.CustomRegionRepository;
import com.flockspring.domain.types.Region;
import com.flockspring.domain.types.impl.GlobalRegionImpl;
import com.flockspring.domain.types.impl.OrganizationImpl;
import com.flockspring.domain.types.impl.RegionType;

/**
 * RegionRepositoryImpl.java
 *
 * @author Justen L. Britain
 * @date Dec 8, 2013
 *
 */
public class RegionRepositoryImpl implements CustomRegionRepository<GlobalRegionImpl, String>
{
    
    private final MongoTemplate mongoTemplate;
    
    @Autowired
    public RegionRepositoryImpl(MongoTemplate mongoTemplate)
    {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Region> findStatesForISO3CountryCode(String iso3CountryCode)
    {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("regionType").is(RegionType.COUNTRY).and(key)
//        GlobalRegionImpl region = mongoTemplate.findOne(query, GlobalRegionImpl.class);
        return null;
    }

    @Override
    public Region findByOrganizationInRegionOrganizations(OrganizationImpl organizationId)
    {
        
        return null;
    }

}
