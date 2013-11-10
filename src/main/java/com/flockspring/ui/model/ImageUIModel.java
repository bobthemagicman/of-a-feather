/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * UIImage.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public class ImageUIModel {
    
    private final String name;
    private final String path;
    private final String alt;
    private final String title;
        
    private final int width;
    private final int height;

    public ImageUIModel(String alt, String name, String path, String title, int height, int width)
    {
        super();
        
        this.name = name;
        this.path = path;
        this.alt = alt;
        this.title = title;
        this.width = width;
        this.height = height;       
    }

    public String getName()
    {
        return name;
    }

    public String getPath()
    {
        return path;
    }

    public String getAlt()
    {
        return alt;
    }

    public String getTitle()
    {
        return title;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
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
