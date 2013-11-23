/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.flockspring.domain.types.GlobalRegion;
import com.flockspring.domain.types.GlobalRegionType;

/**
 * GlobalRegion.java
 * 
 * @author Justen L. Britain
 * @date May 27, 2013
 * 
 */
public class GlobalRegionImpl implements GlobalRegion<GlobalRegionImpl>
{
    private long id;
    private String englishName = "";
    private String localizedName = "";
    private String regionCode = "";
    private String isoAlphaCode = "";
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

    @Override
    public GlobalRegionImpl getParentRegion()
    {
        // TODO Auto-generated method stub
        return null;
    }
}