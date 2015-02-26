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
package com.ofafeather.domain.types.impl;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ofafeather.domain.types.GlobalRegion;
import com.ofafeather.domain.types.GlobalRegionType;

/**
 * GlobalRegion.java
 * 
 * @author Justen L. Britain
 * @date May 27, 2013
 * 
 */
@Document
public class GlobalRegionImpl implements GlobalRegion<GlobalRegionImpl>
{
    private long id;
    private String englishName = "";
    private String localizedName = "";
    private String regionCode = "";
    private String isoAlphaCode = "";
    private GlobalRegionType regionType;

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