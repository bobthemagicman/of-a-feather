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
    private String fullState;
    private String country;
    private double [] location; 

    public AddressImpl()
    {
        
    }
    
    AddressImpl(final String street1, final String street2, final String postalCode, final String state, 
            final String city, final String country, final double [] location, final String fullState)
    {
        this.street1 = street1;
        this.street2 = street2;
        this.postalCode = postalCode;
        this.state = state;
        this.country = country;
        this.city = city;
        this.location = location;
        this.fullState = fullState;
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
    
    public String getFullState()
	{
		return fullState;
	}

	public void setFullState(String fullState)
	{
		this.fullState = fullState;
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

    public static class AddressBuilder
    {

        protected String street1;
        protected String street2;
        protected String postalCode;
        protected String state;
        protected String city;
        protected String country;
        protected double[] location;
        protected String fullState;

        public AddressBuilder withStreet1(final String street1)
        {
            this.street1 = street1;
            return this;
        }
        
        public AddressBuilder withStreet2(final String street2)
        {
            this.street2 = street2;
            return this;
        }
        
        public AddressBuilder withPostalCode(final String postalCode)
        {
            this.postalCode = postalCode;
            return this;
        }
        
        public AddressBuilder withState(final String state)
        {
            this.state = state;
            return this;
        }
        
        public AddressBuilder withCity(final String city)
        {
            this.city = city;
            return this;
        }
        
        public AddressBuilder withCountry(final String country)
        {
            this.country = country;
            return this;
        }
        
        public AddressBuilder withLocation(final double[] location)
        {
            this.location = location;
            return this;
        }
        
        public AddressBuilder withFullState(final String fullState)
        {
        	this.fullState = fullState;
        	return this;
        }
        
        public AddressImpl build()
        {
            return new AddressImpl(street1, street2, postalCode, state, city, country, location, fullState);
        }
    }
}