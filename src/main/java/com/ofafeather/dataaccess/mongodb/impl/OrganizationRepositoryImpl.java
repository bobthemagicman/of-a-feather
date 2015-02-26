/**
 *
 *   Copyright 2015 Justen L. Britain
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 **/
package com.ofafeather.dataaccess.mongodb.impl;

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

import com.ofafeather.dataaccess.mongodb.CustomOrganizationRepository;
import com.ofafeather.domain.OrganizationFilter;
import com.ofafeather.domain.types.impl.OrganizationImpl;

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
            query.addCriteria(Criteria.where("atmosphere.serviceDetails.timeAndDay.serviceTimeRange").in(convertEnumsToStrings(o.getFilteredServiceTimes())));
        }
        
        if(o.hasFilteredServiceDays())
        {
            query.addCriteria(Criteria.where("atmosphere.serviceDetails.timeAndDay.serviceDay").in(convertEnumsToStrings(o.getFilteredServiceDays())));
        }
        
        if(o.hasFilteredCongregationSize())
        {
            query.addCriteria(Criteria.where("atmosphere.congregationSize").in(convertEnumsToStrings(o.getFilteredCongregationSize())));
        }
        
        if(o.hasFilteredDressAttire())
        {
            query.addCriteria(Criteria.where("atmosphere.serviceDetails.dressAttire").in(convertEnumsToStrings(o.getFilteredDressAttire())));
        }
        
        if(o.hasFilteredServiceStyle())
        {
            query.addCriteria(Criteria.where("atmosphere.serviceDetails.serviceStyle").in(convertEnumsToStrings(o.getFilteredServiceStyle())));
        }
        
        if(o.hasFilteredMusicStyle())
        {
            query.addCriteria(Criteria.where("atmosphere.serviceDetails.musicStyle").in(convertEnumsToStrings(o.getFilteredMusicStyle())));
        }
        
        if(o.isGayAfirming())
        {
            query.addCriteria(Criteria.where("atmosphere.gayAfirming").is(true));
        }
        
        if(o.hasFilteredPrograms())
        {
            query.addCriteria(Criteria.where("programsOffered").in(convertEnumsToStrings(o.getFilteredPrograms())));
        }

        if(o.hasFilteredLanguages())
        {
            query.addCriteria(Criteria.where("atmosphere.serviceDetails.languages").in(convertEnumsToStrings(o.getFilteredLanguages())));
        }
        
        if(o.hasFilteredAccessibilityNeeds())
        {
            query.addCriteria(Criteria.where("accessibilitySupport").in(convertEnumsToStrings(o.getFilteredAccessibilitySupport())));
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
