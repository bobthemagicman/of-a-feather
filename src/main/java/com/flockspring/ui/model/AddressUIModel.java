/*
 *  Copyright (c) 2013, Lehman Technolog Group
 *  All rights reserved.
 *  
 *  Redistribution and use in source and binary forms, with or without modification, are permitted provided that 
 *  the following conditions are met:
 *  
 *  Redistributions of source code must retain the above copyright notice, this list of conditions and the following 
 *  disclaimer.
 *  
 *  Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following 
 *  disclaimer in the documentation and/or other materials provided with the distribution.
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, 
 *  INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
 *  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 *  OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT 
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF 
 *  SUCH DAMAGE.
 *
 */
package com.flockspring.ui.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * AddressUIModel.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public class AddressUIModel {

    private final String street1;
    private final String street2;
    private final String city;
    private final String postalCode;
    private final String state;
    private final String country;
    private final double latitude;
    private final double longitude;
    
    public AddressUIModel(String street1, String street2, String city, String state, String postalCode, String country,
            double latitude, double longitude)
    {
        super();
        
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.postalCode = postalCode;
        this.state = state;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getStreet1()
    {
        return street1;
    }

    public String getStreet2()
    {
        return street2;
    }

    public String getCity()
    {
        return city;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public String getState()
    {
        return state;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }
    
    public String getCountry()
    {
        return country;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        return EqualsBuilder.reflectionEquals(this, obj);
    }
    
    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(this);
    }
    
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}
