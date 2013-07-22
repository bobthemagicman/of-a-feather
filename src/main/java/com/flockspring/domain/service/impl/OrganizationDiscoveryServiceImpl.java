package com.flockspring.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flockspring.dataaccess.OrganizationRepository;
import com.flockspring.dataaccess.RegionRepository;
import com.flockspring.domain.service.OrganizationDiscoveryService;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.Region;
import com.flockspring.domain.types.impl.OrganizationImpl;

@Service
public class OrganizationDiscoveryServiceImpl implements OrganizationDiscoveryService {

    private final OrganizationRepository organizationRepository;
    private final RegionRepository regionRepository;

    @Autowired
    public OrganizationDiscoveryServiceImpl(final OrganizationRepository organizationRepository, final RegionRepository regionRepository) {
        super();
        
        this.organizationRepository = organizationRepository;
        this.regionRepository = regionRepository;
    }

    @Override
    public Organization getOrganizationByNameAndRegion(String name, Long regionId)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Region getRegionForOrganization(Long organizationId)
    {
        OrganizationImpl organization = findOrganizationById(organizationId);
        return regionRepository.findByOrganizationInRegionOrganizations(organization); 
    }

    @Override
    public Organization getOrganizationById(Long organizationId)
    {
        return findOrganizationById(organizationId);
    }
    
    private OrganizationImpl findOrganizationById(Long organizationId)
    {
        return organizationRepository.findOne(organizationId);
    }

    @Override 
    @Transactional(readOnly=true)
    public Organization getOrganizationByRegionAndOrganizationNames(String organizationName, String stateRegionName, String cityRegionName,
            String neighborhoodRegionName)
    {
        String parentRegion = neighborhoodRegionName == null ? cityRegionName : neighborhoodRegionName;
        organizationName = organizationName.replaceAll("-", "%");
        
        OrganizationImpl organization = organizationRepository.findByNameAndParentRegion(organizationName, parentRegion);
        
        return organization;
    }

    @Override
    public Organization getOrganizationByRegionAndOrganizationNames(String organizationName, String stateRegionName, String cityRegionName)
    {
        return getOrganizationByRegionAndOrganizationNames(organizationName, stateRegionName, cityRegionName, null);
    }

   
}
