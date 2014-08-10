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
    
    AddressImpl(String street1, String street2, String postalCode, String state, 
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
        return location != null && location.length != 0 ? location[1] : 0.0;
    }

    @Override
    public double getLatitude()
    {
        return location != null && location.length != 0 ? location[0] : 0.0;
    }

    public static class AddressBuilder
    {

        protected String street1;
        protected String street2;
        protected String postalCode;
        protected String state;
        protected String city;
        protected String country;
        protected double[] location;

        public AddressBuilder withStreet1(String street1)
        {
            this.street1 = street1;
            return this;
        }
        
        public AddressBuilder withStreet2(String street2)
        {
            this.street2 = street2;
            return this;
        }
        
        public AddressBuilder withPostalCode(String postalCode)
        {
            this.postalCode = postalCode;
            return this;
        }
        
        public AddressBuilder withState(String state)
        {
            this.state = state;
            return this;
        }
        
        public AddressBuilder withCity(String city)
        {
            this.city = city;
            return this;
        }
        
        public AddressBuilder withCountry(String country)
        {
            this.country = country;
            return this;
        }
        
        public AddressBuilder withLocation(double[] location)
        {
            this.location = location;
            return this;
        }
        
        public AddressImpl build()
        {
            return new AddressImpl(street1, street2, postalCode, state, city, country, location);
        }
    }
}