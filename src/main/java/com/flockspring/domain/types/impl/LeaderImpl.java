/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.flockspring.domain.types.Leader;
import com.google.common.collect.ComparisonChain;

/**
 * LeaderImpl.java
 *
 * @author Justen L. Britain
 * @date Jun 12, 2013
 *
 */
public class LeaderImpl implements Leader, Comparable<Leader>, Serializable
{
    
    private static final long serialVersionUID = -5951998764576044180L;

    private String name;
    private String bio;
    private String title;
    private List<LeaderRole> leaderRoles;
    private MultimediaObjectImpl image;
    private boolean primaryContact;
    private boolean primaryLeader;
    private String emailAddress;
    private String phoneNumber;
    private Integer yearStarted;
    
    public LeaderImpl()
    {
        super();
    }
    
    public LeaderImpl(String name, String bio, String title, List<LeaderRole> leaderRoles, MultimediaObjectImpl image, boolean primaryContact,
            boolean primaryLeader, String emailAddress, String phoneNumber, int yearStarted)
    {
        super();
       
        this.name = name;
        this.bio = bio;
        this.title = title;
        this.leaderRoles = leaderRoles;
        this.image = image;
        this.primaryContact = primaryContact;
        this.primaryLeader = primaryLeader;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.yearStarted = yearStarted;
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
    public MultimediaObjectImpl getImage()
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
    public List<LeaderRole> getLeaderRoles()
    {
        return leaderRoles;
    }

    @Override
    public String getEmailAddress()
    {
        return emailAddress;
    }

    @Override
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    @Override
    public int getYearStarted()
    {
        return yearStarted;
    }

    public void setLeaderRole(List<LeaderRole> leaderRole)
    {
        this.leaderRoles = leaderRole;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setYearStarted(int yearStarted)
    {
        this.yearStarted = yearStarted;
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

    public void setImage(MultimediaObjectImpl image)
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

    @Override
    public int compareTo(Leader right)
    {
        LeaderImpl left = this;
        return ComparisonChain.start()
                .compare(left.getName(), right.getName())
                .compare(left.getTitle(), right.getTitle())
                .compare(left.isPrimaryContact(), right.isPrimaryContact())
                .compare(left.isPrimaryLeader(), right.isPrimaryLeader())
                .result();
    }
}