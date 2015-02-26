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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.google.common.collect.ComparisonChain;
import com.ofafeather.domain.types.MultimediaObject;

/**
 * ImageImpl.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public class MultimediaObjectImpl implements MultimediaObject, Comparable<MultimediaObjectImpl> 
{
    private String name;
    private String path;
    private String altText;
    private String titleText;
    private boolean primary;
    private boolean video;

    public MultimediaObjectImpl()
    {
        super();
    }
    
    public MultimediaObjectImpl(String name, String path, String altText, String titleText, boolean primary, 
            boolean video)
    {
        super();
        this.name = name;
        this.path = path;
        this.altText = altText;
        this.titleText = titleText;
        this.primary = primary;
        this.video = video;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String getPath()
    {
        return path;
    }

    @Override
    public String getAltText()
    {
        return altText;
    }

    @Override
    public String getTitleText()
    {
        return titleText;
    }

    @Override
    public boolean isPrimary()
    {
        return primary;
    }

    @Override
    public boolean isVideo()
    {
        
        return video;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public void setAltText(String altText)
    {
        this.altText = altText;
    }

    public void setTitleText(String titleText)
    {
        this.titleText = titleText;
    }

    public void setPrimary(boolean primary)
    {
        this.primary = primary;
    }

    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object that)
    {
        return EqualsBuilder.reflectionEquals(this, that);
    }

    @Override
    public int compareTo(MultimediaObjectImpl other)
    {
        return ComparisonChain.start()
                .compare(this.path, other.path)
                .compare(this.name, other.getName())
                .result();
                
    }
}
