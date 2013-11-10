/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.flockspring.domain.types.Image;
import com.google.common.collect.ComparisonChain;

/**
 * ImageImpl.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public class ImageImpl implements Image, Comparable<ImageImpl> 
{
    private String name;
    private String path;
    private String altText;
    private String titleText;
    private String extension;
    private int width;
    private int height;
    private boolean primary;

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
    public String getExtension()
    {
        return extension;
    }

    @Override
    public int getWidth()
    {
        return width;
    }

    @Override
    public int getHeight()
    {
        return height;
    }

    @Override
    public boolean isPrimary()
    {
        return primary;
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

    public void setExtension(String extension)
    {
        this.extension = extension;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setHeight(int height)
    {
        this.height = height;
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
    public int compareTo(ImageImpl other)
    {
        return ComparisonChain.start()
                .compare(this.path, other.path)
                .compare(this.name, other.getName())
                .result();
                
    }
}
