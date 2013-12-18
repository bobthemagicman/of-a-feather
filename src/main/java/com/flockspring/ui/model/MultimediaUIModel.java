/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.collect.ComparisonChain;

/**
 * UIImage.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public class MultimediaUIModel implements Comparable<MultimediaUIModel>{
    
    private final String name;
    private final String path;
    private final String alt;
    private final String title;
    private final boolean primary;
    private final boolean video;

    public MultimediaUIModel(String alt, String name, String path, String title, boolean primary, boolean video)
    {
        super();
        
        this.name = name;
        this.path = path;
        this.alt = alt;
        this.title = title;
        this.primary = primary;      
        this.video = video;
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

    public boolean isPrimary()
    {
        return primary;
    }
    
    public boolean isVideo()
    {
        return video;
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
    public int compareTo(MultimediaUIModel right)
    {
        MultimediaUIModel left = this;
        return ComparisonChain.start()
                .compare(left.getName(), right.getName())
                .compare(left.getPath(), right.getPath())
                .compare(left.isPrimary(), right.isPrimary())
                .result();
    }
}
