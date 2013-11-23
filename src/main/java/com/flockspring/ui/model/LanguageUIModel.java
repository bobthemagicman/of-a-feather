/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * UILanguage.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public class LanguageUIModel 
{
    private String englishName;
    private String localizedName;
   
    public LanguageUIModel(String englishName, String localizedName)
    {
        super();
        this.englishName = englishName;
        this.localizedName = localizedName;
    }
    
    public String getEnglishName()
    {
        return englishName;
    }
    
    public String getLocalizedName()
    {
        return localizedName;
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
