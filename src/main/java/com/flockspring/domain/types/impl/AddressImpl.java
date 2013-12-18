/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.flockspring.domain.types.Address;


public class AddressImpl implements Address, Serializable
{
    private static final long serialVersionUID = -6084322307496407210L;

    private String street1;
    private String street2;
    private String postalCode;
    private String state;
    private String city;
    private String country;
    private double [] location; 

    public AddressImpl()
    {
        
    }
    
    public AddressImpl(String street1, String street2, String postalCode, String state, 
            String city, String country, double [] location)
    {
        this.street1 = street1;
        this.street2 = street2;
        this.postalCode = postalCode;
        this.state = state;
        this.country = country;
        this.city = city;
        this.location = location;
    }

    public String getStreet1()
    {
        return street1;
    }

    public String getStreet2()
    {
        return street2;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public String getState()
    {
        return state;
    }

    public String getCity()
    {
        return city;
    }

    public String getCountry()
    {
        return country;
    }

    @Override
    public double[] getLocation()
    {
        return location;
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

    @Override
    public double getLongitude()
    {
        return location != null && location.length != 0 ? location[0] : 0.0;
    }

    @Override
    public double getLatitude()
    {
        return location != null && location.length != 0 ? location[1] : 0.0;
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

    public void setLocation(double[] location)
    {
        this.location = location;
    }
}