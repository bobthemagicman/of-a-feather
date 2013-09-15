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

import com.flockspring.domain.types.GlobalRegion;
import com.flockspring.domain.types.GlobalRegionType;

/**
 * GlobalRegion.java
 * 
 * @author Justen L. Britain
 * @date May 27, 2013
 * 
 */
public class GlobalRegionImpl implements GlobalRegion<GlobalRegionImpl>, Serializable
{
    private static final long serialVersionUID = -7469046068931630531L;
    
    private long id;
    private long parentRegionId = 0L;
    
    private GlobalRegionImpl parentRegion;
    private GlobalRegionType regionType;

    private String englishName = "";
    private String localizedName = "";
    private String regionCode = "";
    private String isoAlphaCode = "";

    private Map<String, String> localeBasedNameMap = new HashMap<String, String>();

    @Override
    public long getId()
    {
        return id;
    }

    @Override
    public GlobalRegionImpl getParentRegion()
    {
        return parentRegion;
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
    public GlobalRegionType getRegionType()
    {
    
        return regionType;
    }
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((englishName == null) ? 0 : englishName.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((isoAlphaCode == null) ? 0 : isoAlphaCode.hashCode());
        result = prime * result + ((localizedName == null) ? 0 : localizedName.hashCode());
        result = prime * result + ((parentRegion == null) ? 0 : parentRegion.hashCode());
        result = prime * result + (int) (parentRegionId ^ (parentRegionId >>> 32));
        result = prime * result + ((regionCode == null) ? 0 : regionCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GlobalRegionImpl other = (GlobalRegionImpl) obj;
        if (englishName == null)
        {
            if (other.englishName != null)
                return false;
        } else if (!englishName.equals(other.englishName))
            return false;
        if (id != other.id)
            return false;
        if (isoAlphaCode == null)
        {
            if (other.isoAlphaCode != null)
                return false;
        } else if (!isoAlphaCode.equals(other.isoAlphaCode))
            return false;
        if (localizedName == null)
        {
            if (other.localizedName != null)
                return false;
        } else if (!localizedName.equals(other.localizedName))
            return false;
        if (parentRegion == null)
        {
            if (other.parentRegion != null)
                return false;
        } else if (!parentRegion.equals(other.parentRegion))
            return false;
        if (parentRegionId != other.parentRegionId)
            return false;
        if (regionCode == null)
        {
            if (other.regionCode != null)
                return false;
        } else if (!regionCode.equals(other.regionCode))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "GlobalRegionImpl [id=" + id + ", parentRegionId=" + parentRegionId + ", "
                + (parentRegion != null ? "parentRegion=" + parentRegion + ", " : "")
                + (englishName != null ? "englishName=" + englishName + ", " : "")
                + (localizedName != null ? "localizedName=" + localizedName + ", " : "")
                + (regionCode != null ? "regionCode=" + regionCode + ", " : "") + (isoAlphaCode != null ? "isoAlphaCode=" + isoAlphaCode : "") + "]";
    }
}