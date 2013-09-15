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
package com.flockspring.domain.types.impl;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.flockspring.domain.types.Address;

public class AddressImpl implements Address, Serializable{

    private static final long serialVersionUID = 8616976763580832651L;

    private long id = 0;

    private String street1 = "";
    private String street2 = "";
    private String postalCode = "";
    private String state = "";
    private String city = "";
    private String country = "";
    private double longitude;
    private double latitude;
        
    public AddressImpl(long id, String street1, String street2, String postalCode, String state, String city, String country, 
            double longitude, double latitude)
    {
        super();
        
        this.id = id;
        this.street1 = street1;
        this.street2 = street2;
        this.postalCode = postalCode;
        this.state = state;
        this.city = city;
        this.country = country;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public long getId()
    {
        return id;
    }

    @Override
    public String getStreet1()
    {
        return street1;
    }

    @Override
    public String getStreet2()
    {
        return street2;
    }

    @Override
    public String getPostalCode()
    {
        return postalCode;
    }

    @Override
    public String getState()
    {
        return state;
    }

    @Override
    public String getCity()
    {
        return city;
    }

    @Override
    public String getCountry()
    {
        return country;
    }

    @Override
    public double getLongitude()
    {
        return longitude;
    }

    @Override
    public double getLatitude()
    {
        return latitude;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public void setStreet1(String street1)
    {
        this.street1 = street1;
    }

    public void setStreet2(String street2)
    {
        this.street2 = street2;
    }

    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    @Override
    public int hashCode()
    {
        
       return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj)
    {
        
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString()
    {
        
        return ToStringBuilder.reflectionToString(this);
    }
}