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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.flockspring.domain.types.Address;


@Entity
@Table(name="ADDRESS")
public class JpaAddressImpl implements Address, Serializable{

    private static final long serialVersionUID = 8616976763580832651L;

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id = 0;
	
	@Column(name="STREET1")
	private String street1 = "";
	
	@Column(name="STREET2")
    private String street2 = "";
		
	@Column(name="POSTAL_CODE")
	private String postalCode = "";
	
	@Column(name="STATE")
	private String state = "";
	
	@Column(name="CITY")
	private String city = "";
	
	@Column(name="COUNTRY")
	private String country = "";
	
	@Column(name="LONGITUDE")
	private double longitude;
	
	@Column(name="LATITUDE")
	private double latitude;

    public long getId()
    {
        return id;
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

    public double getLongitude()
    {
        return longitude;
    }

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