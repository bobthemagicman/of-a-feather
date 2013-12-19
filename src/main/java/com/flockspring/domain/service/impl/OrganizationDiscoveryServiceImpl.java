/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.service.impl;

import java.util.NavigableSet;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoPage;
import org.springframework.data.mongodb.core.geo.GeoResult;
import org.springframework.data.mongodb.core.geo.Metrics;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flockspring.dataaccess.mongodb.OrganizationRepository;
import com.flockspring.dataaccess.service.client.MapQuestServiceClient;
import com.flockspring.dataaccess.service.client.USPSAddressAPIService;
import com.flockspring.domain.service.OrganizationDiscoveryService;
import com.flockspring.domain.types.Address;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.Region;
import com.flockspring.domain.types.impl.AddressImpl;
import com.flockspring.domain.types.impl.OrganizationImpl;
import com.flockspring.ui.model.AjaxSearchFilterRequest;

@Service
public class OrganizationDiscoveryServiceImpl implements OrganizationDiscoveryService
{

    private final OrganizationRepository organizationRepository;
//    private final RegionRepository regionRepository;
    private final MapQuestServiceClient mapQuestServiceClient;
    private final USPSAddressAPIService uspsAddressAPIService;
    private final int defaultDistance;
    private final int defaultPageSize;

    @Autowired
    public OrganizationDiscoveryServiceImpl(final OrganizationRepository organizationRepository, final USPSAddressAPIService uspsAddressAPIService,
            @Value("${com.flockspring.domain.service.organization.default.distance}") final int defaultDistance,
            @Value("${com.flockspring.domain.service.organization.default.pageSize}") final int defaultPageSize,
            final MapQuestServiceClient mapQuestServiceClient)
    {
        super();

        this.uspsAddressAPIService = uspsAddressAPIService;
        this.organizationRepository = organizationRepository;
        this.defaultDistance = defaultDistance;
        this.mapQuestServiceClient = mapQuestServiceClient;
        this.defaultPageSize = defaultPageSize;
//        this.regionRepository = regionRepository;
    }

    @Override
    public Organization getOrganizationByNameAndRegion(String name, Long regionId)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Region getRegionForOrganization(String organizationId)
    {
        OrganizationImpl organization = findOrganizationById(organizationId);
        return null;//regionRepository.findByOrganizationInRegionOrganizations(organization);
    }

    @Override
    public Organization getOrganizationById(String organizationId)
    {
        return findOrganizationById(organizationId);
    }

    private OrganizationImpl findOrganizationById(String organizationId)
    {
        return organizationRepository.findOne(organizationId);
    }

    @Override
    @Transactional(readOnly = true)
    public Organization getOrganizationByRegionAndOrganizationNames(String organizationName, String stateRegionName, String cityRegionName,
            String neighborhoodRegionName)
    {
        String parentRegion = neighborhoodRegionName == null ? cityRegionName : neighborhoodRegionName;
        organizationName = organizationName.replaceAll("-", "%");

//        OrganizationImpl organization = organizationRepository.findByNameAndRegion(organizationName, parentRegion);

        return null;
    }

    @Override
    public Organization getOrganizationByRegionAndOrganizationNames(String organizationName, String stateRegionName, String cityRegionName)
    {
        return getOrganizationByRegionAndOrganizationNames(organizationName, stateRegionName, cityRegionName, null);
    }

    @Override
    public GeoPage<OrganizationImpl> searchForOrganizations(String query, int page)
    {

       // Address address = verifyQuery(query.trim());
        Address address = new AddressImpl("", "", "98052", "WA", "REDMOND", "USA", new double[]{0.0, 0.0});

        // Check Store/Cache for matching query(non-mvp)
        // Geolocate query via mapquest api
        if (address != null)
        {
            address = mapQuestServiceClient.getAddressGeoCode(address);
            // store in cache
            
            Point point = new Point(address.getLongitude(), address.getLatitude()); 
            Distance dist = new Distance(defaultDistance, Metrics.MILES);

            Pageable pageRequest = new PageRequest(page, defaultPageSize);
            GeoPage<OrganizationImpl> results = organizationRepository.findByAddressLocationNear(point, dist, pageRequest);
            
            //TODO:jbritain figure out how to not pass the Impl class up to the UI layer!
            return results;
        }

        return null;
    }

    private Address verifyQuery(String query)
    {
        
        if(query.matches("\\d{5}"))
        {
            Address address = new AddressImpl("", "", query, "", "", "", new double[]{0, 0});
            return uspsAddressAPIService.lookupCityState(address);
        }
        else if(query.matches(".?\\s"))
        {
            String city = "";
            String state = "";
            String address1 = "";
            String address2 = "";
            
            //Just city and state <--if there is a comment you need to break up the code
            if(query.matches("\\w{2}")){
                
                String[] parts = query.split("(\\w)(\\s+)([\\.,])");                
                if(parts.length > 0)
                {
                    city = parts[0];
                }
                
                if(parts.length > 1)
                {
                    state = parts[1];
                }
            }
           
            Address address = new AddressImpl(address1, address2, "", state, city, "USA", new double[]{0, 0});
            return uspsAddressAPIService.lookupZip(address);
        }
        
        return null;
    }

    @Override
    public NavigableSet<Organization> getFilteredOrganizations(AjaxSearchFilterRequest filterRequest)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveOrganization(OrganizationImpl organization)
    {
        processImages(organization);
        organizationRepository.save(organization);        
    }

    private void processImages(OrganizationImpl organization)
    {
        // TODO Auto-generated method stub
        
    }
}
