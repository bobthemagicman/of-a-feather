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
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.flockspring.domain.types.GlobalRegion;
import com.flockspring.domain.types.GlobalRegionType;

/**
 * JpaGlobalRegionImpl.java
 * 
 * @author Justen L. Britain
 * @date May 27, 2013
 * 
 */
@MappedSuperclass
public abstract class JpaGlobalRegionImpl<T> implements GlobalRegion<T>, Serializable
{
    private static final long serialVersionUID = -9076062507126067380L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "ENGLISH_NAME")
    private String englishName = "";

    @Column(name = "LOCALIZED_NAME")
    private String localizedName = "";

    @Column(name = "ISO_ALPHA_2_CODE")
    private String regionCode = "";

    @Column(name = "ISO_ALPHA_3_CODE")
    private String isoAlphaCode = "";
    
    @Enumerated(EnumType.STRING)
    @Column(name = "REGION_TYPE")
    private GlobalRegionType regionType;
    
    @Transient
    private Map<String, String> localeBasedNameMap = new HashMap<String, String>();

    @Override
    public long getId()
    {
        return id;
    }
    
    @Override
    public String getEnglishName()
    {
        return englishName;
    }

    @Override
    public String getNativeLocalizedName()
    {
        return localizedName;
    }

    @Override
    public String getIsoAlpha3Code()
    {
        return regionCode;
    }

    @Override
    public String getIsoAlpha2Code()
    {
        return isoAlphaCode;
    }

    @Override
    public String getLocalizedName(Locale locale)
    {
        String key = locale.getISO3Language();
        if (localeBasedNameMap.containsKey(key))
        {
            return localeBasedNameMap.get(key);
        }
        
       return getEnglishName();
    }
    
    @Override
    public GlobalRegionType getRegionType() {
        return regionType;
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