package com.flockspring.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.solr.core.geo.Distance;
import org.springframework.data.solr.core.geo.Distance.Unit;
import org.springframework.data.solr.core.geo.GeoLocation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flockspring.dataaccess.jpa.OrganizationJpaRepository;
import com.flockspring.dataaccess.jpa.RegionJpaRepository;
import com.flockspring.dataaccess.service.client.MapQuestServiceClient;
import com.flockspring.dataaccess.service.client.USPSAddressAPIService;
import com.flockspring.dataaccess.solr.OrganizationSolrRepository;
import com.flockspring.domain.service.OrganizationDiscoveryService;
import com.flockspring.domain.types.Address;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.Region;
import com.flockspring.domain.types.impl.AddressImpl;
import com.flockspring.domain.types.impl.OrganizationImpl;

@Service
public class OrganizationDiscoveryServiceImpl implements OrganizationDiscoveryService
{

    private final OrganizationJpaRepository organizationJpaRepository;
    private final RegionJpaRepository regionJpaRepository;
    private final OrganizationSolrRepository organizationSolrRepository;
    private final MapQuestServiceClient mapQuestServiceClient;
    private final USPSAddressAPIService uspsAddressAPIService;
    private final int defaultDistance;

    @Autowired
    public OrganizationDiscoveryServiceImpl(final OrganizationJpaRepository organizationRepository, final RegionJpaRepository regionRepository,
            final OrganizationSolrRepository organizationSolrRepository, final USPSAddressAPIService uspsAddressAPIService,
            @Value("${com.flickspring.domain.service.organization.default.distance}") final int defaultDistance,
            final MapQuestServiceClient mapQuestServiceClient)
    {
        super();

        this.uspsAddressAPIService = uspsAddressAPIService;
        this.organizationSolrRepository = organizationSolrRepository;
        this.organizationJpaRepository = organizationRepository;
        this.regionJpaRepository = regionRepository;
        this.defaultDistance = defaultDistance;
        this.mapQuestServiceClient = mapQuestServiceClient;
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
        return regionJpaRepository.findByOrganizationInRegionOrganizations(organization);
    }

    @Override
    public Organization getOrganizationById(Long organizationId)
    {
        return findOrganizationById(organizationId);
    }

    private OrganizationImpl findOrganizationById(Long organizationId)
    {
        return organizationJpaRepository.findOne(organizationId);
    }

    @Override
    @Transactional(readOnly = true)
    public Organization getOrganizationByRegionAndOrganizationNames(String organizationName, String stateRegionName, String cityRegionName,
            String neighborhoodRegionName)
    {
        String parentRegion = neighborhoodRegionName == null ? cityRegionName : neighborhoodRegionName;
        organizationName = organizationName.replaceAll("-", "%");

        OrganizationImpl organization = organizationJpaRepository.findByNameAndParentRegion(organizationName, parentRegion);

        return organization;
    }

    @Override
    public Organization getOrganizationByRegionAndOrganizationNames(String organizationName, String stateRegionName, String cityRegionName)
    {
        return getOrganizationByRegionAndOrganizationNames(organizationName, stateRegionName, cityRegionName, null);
    }

    @Override
    public List<Organization> searchForOrganizations(String query)
    {

        Address address = verifyQuery(query.trim());

        // Check Store/Cache for matching query(non-mvp)
        // Geolocate query via mapquest api
        if (address != null)
        {
            address = mapQuestServiceClient.getAddressGeoCode(address);
            // store in cache
            GeoLocation geoLoc = new GeoLocation(address.getLatitude(), address.getLongitude());
            Distance dist = new Distance(defaultDistance, Unit.MILES);

            return new ArrayList<Organization>(organizationSolrRepository.findByAddressWithin(geoLoc, dist));
        }

        return new ArrayList<Organization>(0);
    }

    private Address verifyQuery(String query)
    {
        
        if(query.matches("\\d{5}"))
        {
            Address address = new AddressImpl(0, "", "", query, "", "", "", 0, 0);
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
           
            Address address = new AddressImpl(0, address1, address2, "", state, city, "USA", 0, 0);
            return uspsAddressAPIService.lookupZip(address);
        }
        
        return null;
    }
}
