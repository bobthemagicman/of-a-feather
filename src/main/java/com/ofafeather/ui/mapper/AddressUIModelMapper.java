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
package com.ofafeather.ui.mapper;

import org.springframework.stereotype.Component;

import com.ofafeather.domain.types.Address;
import com.ofafeather.ui.model.AddressUIModel;

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
