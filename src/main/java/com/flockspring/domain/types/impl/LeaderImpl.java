/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.flockspring.domain.types.Leader;
import com.lehman.technology.group.common.domain.types.Image;
import com.lehman.technology.group.common.domain.types.impl.JpaImageImpl;

/**
 * LeaderImpl.java
 *
 * @author Justen L. Britain
 * @date Jun 12, 2013
 *
 */
@Entity
@Table(name="LEADER")
public class LeaderImpl implements Leader, Serializable
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
    @JoinColumn(name="ORGANIZATION_ID")
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
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bio == null) ? 0 : bio.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((image == null) ? 0 : image.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((organization == null) ? 0 : organization.hashCode());
        result = prime * result + (primaryContact ? 1231 : 1237);
        result = prime * result + (primaryLeader ? 1231 : 1237);
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LeaderImpl other = (LeaderImpl) obj;
        if (bio == null)
        {
            if (other.bio != null)
                return false;
        } else if (!bio.equals(other.bio))
            return false;
        if (id != other.id)
            return false;
        if (image == null)
        {
            if (other.image != null)
                return false;
        } else if (!image.equals(other.image))
            return false;
        if (name == null)
        {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (organization == null)
        {
            if (other.organization != null)
                return false;
        } else if (!organization.equals(other.organization))
            return false;
        if (primaryContact != other.primaryContact)
            return false;
        if (primaryLeader != other.primaryLeader)
            return false;
        if (title == null)
        {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }
}