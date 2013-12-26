/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.mongodb.impl;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoPage;
import org.springframework.data.mongodb.core.geo.GeoResults;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;

import com.flockspring.dataaccess.mongodb.CustomOrganizationRepository;
import com.flockspring.domain.OrganizationFilter;
import com.flockspring.domain.types.impl.OrganizationImpl;
import com.flockspring.ui.model.ServiceTimeRange;

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
            query.addCriteria(Criteria.where("denomination").in(convertEnumsToStrings(o.getFilteredDenominations())));
        }
        
        if(o.hasFilteredServiceTimeRange())
        {
            Criteria timeRangeCriteria = Criteria.where("atmosphere.serviceDetails.timeAndDay.startTime");
            
            boolean first = true;
            for(ServiceTimeRange str : o.getFilteredServiceTimes())
            {
                if(first)
                {
                    timeRangeCriteria.gte(str.getRangeStart()).lte(str.getRangeEnd());
                    first = false;
                }
                else
                {
                    timeRangeCriteria.orOperator(timeRangeCriteria.gte(str.getRangeStart().toDate()).lte(str.getRangeEnd().toDate()));                    
                }                
            }
            
            query.addCriteria(timeRangeCriteria);
        }
                           
        NearQuery nearQuery = NearQuery.near(p).maxDistance(d).query(query);

        GeoResults<OrganizationImpl> results = mongoTemplate.geoNear(nearQuery.with(page), OrganizationImpl.class);
        
        query.addCriteria(Criteria.where("address.location").nearSphere(p).maxDistance(d.getNormalizedValue()));
        long count = mongoTemplate.count(query, OrganizationImpl.class);
        
        return new GeoPage<OrganizationImpl>(results, page, count);
    }

    private Set<String> convertEnumsToStrings(Set<? extends Enum<?>> enumsToConvert)
    {
        Set<String> convertedEnums = new TreeSet<>();
        for(Enum<?> e : enumsToConvert)
        {
            convertedEnums.add(e.name());
        }
        
        return convertedEnums;
    }
}
