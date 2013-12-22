/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.mongodb.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoPage;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;

import com.flockspring.dataaccess.mongodb.CustomOrganizationRepository;
import com.flockspring.domain.OrganizationFilter;
import com.flockspring.domain.types.impl.OrganizationImpl;

/**
 * OrganizationRepositoryImpl.java
 *
 * @author Justen L. Britain
 * @date Nov 9, 2013
 *
 */
public class OrganizationRepositoryImpl implements CustomOrganizationRepository<OrganizationImpl, String>
{

    private final MongoTemplate mongoTemplate;
        
    @Autowired
    public OrganizationRepositoryImpl(MongoTemplate mongoTemplate)
    {
        this.mongoTemplate = mongoTemplate;
    }
    
    @Override
    public GeoPage<OrganizationImpl> findOrganizationsByFilteredCriteria(Point p, Distance d, OrganizationFilter o, 
            PageRequest page)
    {
        
        Query query = new Query();
        if(o.hasFilteredDenominations())
        {
            query.addCriteria(Criteria.where("denomination").in(o.getFilteredDenominations()));
        }
        
        if(o.hasFilteredServiceTimes())
        {
            query.addCriteria(Criteria.where("serviceTime").all(o.getFilteredServiceTimes()));
        }
        
        if(o.hasFilteredServiceDays())
        {
            query.addCriteria(Criteria.where("serviceDays").all(o.getFilteredServiceTimes()));
        }
        
        if(o.hasFilteredCongregationSize())
        {
            query.addCriteria(Criteria.where("congregationSize").in(o.getFilteredCongregationSize()));
        }
        
        if(o.hasFilteredServiceStyle())
        {
            query.addCriteria(Criteria.where("serviceStyle").in(o.getFilteredServiceStyleRange()));
        }
        
        if(o.hasFilteredMusicStyle())
        {
            query.addCriteria(Criteria.where("musicStyle").in(o.getFilteredMusicStyleRange()));
        }
        
        if(o.hasFilteredDressAttire())
        {
            query.addCriteria(Criteria.where("dressAttire").in(o.getFilteredDressAttire()));
        }
        
        if(o.hasFilteredGayAfirming())
        {
            query.addCriteria(Criteria.where("gayAffirming").is(true));
        }
        
        if(o.hasFilteredPrograms())
        {
            query.addCriteria(Criteria.where("programs").all(o.getFilteredPrograms()));
        }
        
        if(o.hasFilteredLanguages())
        {
            query.addCriteria(Criteria.where("languages").in(o.getFilteredLanguages()));
        }
        
        if(o.hasFilteredAccessibilityNeeds())
        {
            query.addCriteria(Criteria.where("accessibilityNeeds").all(o.getFilteredAccessibilityNeeds()));
        }
        
        NearQuery nearQuery = NearQuery.near(p).maxDistance(d).num(page.getPageSize())//.skip(skip)
                .query(query);

        return null; //mongoTemplate.geoNear(nearQuery, OrganizationImpl.class);
    }
}
