/*
 * Copyright 013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.collect.ComparisonChain;


/**
 * LeaderUIModel.java
 *
 * @author Justen L. Britain
 * @date May 7, 013
 *
 */
public class LeaderUIModel implements Comparable<LeaderUIModel> {

    private final String name;
    private final String title;
    private final String bio;
    private final MultimediaUIModel image;
    
    private final boolean primaryContact;
    private final boolean primaryLeader;
    
    public LeaderUIModel(String name, String title, String bio, MultimediaUIModel image, boolean primaryContact, boolean primaryLeader)
    {
        super();
        
        this.name = name;
        this.title = title;
        this.bio = bio;
        this.image = image;
        this.primaryContact = primaryContact;
        this.primaryLeader = primaryLeader;
    }

    public String getName()
    {
        return name;
    }

    public String getTitle()
    {
        return title;
    }

    public String getBio()
    {
        return bio;
    }

    public MultimediaUIModel getImage()
    {
        return image;
    }

    public boolean isPrimaryContact()
    {
        return primaryContact;
    }

    public boolean isPrimaryLeader()
    {
        return primaryLeader;
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
    public int compareTo(LeaderUIModel right)
    {
        LeaderUIModel left = this;
        return ComparisonChain.start()
                .compare(left.getName(), right.getName())
                .compare(left.getTitle(), right.getTitle())
                .result();
    }
}
