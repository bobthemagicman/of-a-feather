/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.mapper;

import org.springframework.stereotype.Component;

import com.flockspring.domain.types.Address;
import com.flockspring.ui.model.AddressUIModel;

/**
 * AddressUIModelMapper.java
 *
 * @author Justen L. Britain
 * @date Jul 20, 2013
 *
 */
@Component
public class AddressUIModelMapper
{

    public AddressUIModel map(Address address)
    {
        if(address != null)
        {
            String street1 = address.getStreet1();
            String street2 = address.getStreet2();
            String city = address.getCity();
            String postalCode = address.getPostalCode();
            String state = address.getState();
            double longitude = address.getLongitude();
            double latitude = address.getLatitude();
            String country = address.getCountry();
            
            AddressUIModel model = new AddressUIModel(street1, street2, city, state, postalCode, country, latitude, longitude);
           
            return model;
        }
        
        return null;
    }
}
