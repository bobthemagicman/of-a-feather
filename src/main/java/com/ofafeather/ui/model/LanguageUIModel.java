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
package com.ofafeather.ui.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.collect.ComparisonChain;

/**
 * UILanguage.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public class LanguageUIModel implements Comparable<LanguageUIModel> 
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

    @Override
    public int compareTo(LanguageUIModel right)
    {
        LanguageUIModel left = this;
        return ComparisonChain.start()
                .compare(left.getEnglishName(), right.getEnglishName())
                .result();
    }
}
