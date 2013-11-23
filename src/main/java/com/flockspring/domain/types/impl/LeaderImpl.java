/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.flockspring.domain.types.Leader;

/**
 * LeaderImpl.java
 *
 * @author Justen L. Britain
 * @date Jun 12, 2013
 *
 */
public class LeaderImpl implements Leader
{
    
    private long id;
    private String name;
    private String bio;
    private String title;
    private ImageImpl image;
    private boolean primaryContact;
    private boolean primaryLeader;
    private OrganizationImpl organization;

    @Override
    public long getId()
    {
        return id;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String getBio()
    {
        return bio;
    }

    @Override
    public String getTitle()
    {
        return title;
    }

    @Override
    public ImageImpl getImage()
    {
        return image;
    }

    @Override
    public boolean isPrimaryContact()
    {
        return primaryContact;
    }

    @Override
    public boolean isPrimaryLeader()
    {
        return primaryLeader;
    }

    @Override
    public OrganizationImpl getOrganization()
    {
        return organization;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setBio(String bio)
    {
        this.bio = bio;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setImage(ImageImpl image)
    {
        this.image = image;
    }

    public void setPrimaryContact(boolean primaryContact)
    {
        this.primaryContact = primaryContact;
    }

    public void setPrimaryLeader(boolean primaryLeader)
    {
        this.primaryLeader = primaryLeader;
    }

    public void setOrganization(OrganizationImpl organization)
    {
        this.organization = organization;
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
}