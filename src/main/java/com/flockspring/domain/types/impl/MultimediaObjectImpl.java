/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.flockspring.domain.types.MultimediaObject;
import com.google.common.collect.ComparisonChain;

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
