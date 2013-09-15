/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.flockspring.domain.types.Leader;

/**
 * LeaderImpl.java
 *
 * @author Justen L. Britain
 * @date Jun 12, 2013
 *
 */
@Entity
@Table(name="LEADER")
public class LeaderImpl implements Leader
{
    
    private static final long serialVersionUID = -2486392800486198793L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="BIO")
    private String bio;
    
    @Column(name="TITLE")
    private String title;
    
    @ManyToOne
    @JoinColumn(name="IMAGE_ID")
    private JpaImageImpl image;
    
    @Column(name="PRIMARY_CONTACT")
    private boolean primaryContact;
    
    @Column(name="PRIMARY_LEADER")
    private boolean primaryLeader;

    @ManyToOne
    @JoinColumn(name="ORGANIZATION_ID", nullable=false)
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
    public JpaImageImpl getImage()
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

    public void setImage(JpaImageImpl image)
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