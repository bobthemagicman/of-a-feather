/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.flockspring.domain.types.Address;
import com.flockspring.domain.types.impl.AddressImpl;
import com.mindfreez.shipping.usps.AddressService;

/**
 * USPSClient.java
 * 
 * @author Justen L. Britain
 * @date Aug 3, 2013
 * 
 */
@Service
public class USPSAddressAPIService
{

    private final AddressService USPSAddressVerificationService;

    @Autowired
    public USPSAddressAPIService(final @Value("${usps.api.username}") String userId)
    {
        super();

        this.USPSAddressVerificationService = new AddressService(userId);
    }

    public Address lookupCityState(Address address)
    {
        com.mindfreez.shipping.Address apiAddress = convertAddressForAPI(address);
        apiAddress = USPSAddressVerificationService.lookupCityState(apiAddress);
        
        return convertAddressFromAPI(apiAddress);
    }
    

    public Address lookupZip(Address address)
    {
        com.mindfreez.shipping.Address apiAddress = convertAddressForAPI(address);
        apiAddress = USPSAddressVerificationService.lookupZipCode(apiAddress);
       
        return convertAddressFromAPI(apiAddress);
    }
    
    public Address verifyAddress(Address address)
    {
        com.mindfreez.shipping.Address apiAddress = convertAddressForAPI(address);
        apiAddress = USPSAddressVerificationService.verifyAddress(apiAddress);
       
        return convertAddressFromAPI(apiAddress);
    }

    private com.mindfreez.shipping.Address convertAddressForAPI(Address address)
    {
        com.mindfreez.shipping.Address apiAddress = new com.mindfreez.shipping.Address();
        apiAddress.setCity(address.getCity());
        apiAddress.setState(address.getState());
        apiAddress.setPostalCode(address.getPostalCode());
        
        return apiAddress;
    }
    
    private Address convertAddressFromAPI(com.mindfreez.shipping.Address address)
    {
        return new AddressImpl(address.getStreet() == null ? "" : address.getStreet(), address.getStreet2() == null ? "" : address.getStreet2(),
                address.getPostalCode() == null ? "" : address.getPostalCode(), address.getState() == null ? "" : address.getState(),
                address.getCity() == null ? "" : address.getCity(), "USA", new double[]{0, 0});
        
    }
}
    