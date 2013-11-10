/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import com.flockspring.domain.types.AccessabilitySupport;
import com.flockspring.domain.types.Address;
import com.flockspring.domain.types.Affiliation;
import com.flockspring.domain.types.DressAttire;
import com.flockspring.domain.types.Image;
import com.flockspring.domain.types.Language;
import com.flockspring.domain.types.Leader;
import com.flockspring.domain.types.MusicStyle;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.Region;
import com.flockspring.domain.types.ServiceDay;
import com.flockspring.domain.types.ServiceStyle;
import com.flockspring.ui.model.CongregationSize;
import com.flockspring.ui.model.Programs;
import com.flockspring.ui.model.ServiceTime;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

/**
 * OrganizationImpl.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
@Document(collection="organizations")
public class OrganizationImpl implements Organization, Comparable<Organization>
{
    private String id;
    private int yearFounded;
    private boolean gayAffirming;
    private boolean parkingLotAvailable;
    private String name;
    private String description;
    private String websiteUrl;
    private String facebookUrl;
    private CongregationSize congregationSize;
    private AddressImpl address;
    private Region region;
    private MusicStyle musicStyle;
    private ServiceStyle serviceStyle;
    private DressAttire dressAttire;
    private Affiliation denomination;
    private Affiliation subDenomination;
    private Affiliation primaryAffiliation;
    private Set<ImageImpl> images;
    private Set<LeaderImpl> leadershipTeam;
    private Set<ServiceTime> serviceTimes;
    private Set<ServiceDay> serviceDays;
    private Set<Language> languages;
    private Set<Programs> programmsOffered;
    private Set<AccessabilitySupport> accessibilitySupport;
    private double distanceFromSearchPoint;
    
    
    @Override
    public String getId()
    {
        return id;
    }

    @Override
    public Address getAddress()
    {
        return address;
    }

    @Override
    public int getYearFounded()
    {
        return yearFounded;
    }

    @Override
    public Set<ServiceTime> getServiceTimes()
    {
        return serviceTimes;
    }

    @Override
    public Set<ServiceDay> getServiceDays()
    {
        return serviceDays;
    }

    @Override
    public Set<Language> getLanguages()
    {
        return languages;
    }

    @Override
    public Set<Image> getImages()
    {
        Set<Image> imageSet = new TreeSet<Image>();
        if(images != null)
        {
            imageSet.addAll(images);
        }
        
        return imageSet;
    }

    @Override
    public Set<Leader> getLeadershipTeam()
    {
        Set<Leader> leaderSet = new TreeSet<Leader>();
        if(leadershipTeam != null)
        {
            leaderSet.addAll(leadershipTeam);
        }
        
        return leaderSet;
    }

    @Override
    public Affiliation getPrimaryAffiliation()
    {
        return primaryAffiliation;
    }

    @Override
    public Affiliation getDenomination()
    {
        return denomination;
    }

    @Override
    public Affiliation getSubDenomination()
    {
        return subDenomination;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public String getWebsiteUrl()
    {
        return websiteUrl;
    }

    @Override
    public String getFacebookUrl()
    {
        return facebookUrl;
    }

    @Override
    public CongregationSize getCongregationSize()
    {
        return congregationSize;
    }

    @Override
    public boolean isGayAffirming()
    {
        return gayAffirming;
    }

    @Override
    public Region getRegion() 
    {
        return region;
    }

    @Override
    public double getDistanceFromSearchPoint() 
    {
        return this.distanceFromSearchPoint;
    }

    public void setAddress(AddressImpl address)
    {
        this.address = address;
    }

    public void setYearFounded(int yearFounded)
    {
        this.yearFounded = yearFounded;
    }

    public void setImages(Set<ImageImpl> images)
    {
        this.images = images;
    }

    public void setLeadershipTeam(Set<LeaderImpl> leadershipTeam)
    {
        this.leadershipTeam = leadershipTeam;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setWebsiteUrl(String websiteUrl)
    {
        this.websiteUrl = websiteUrl;
    }

    public void setFacebookUrl(String facebookUrl)
    {
        this.facebookUrl = facebookUrl;
    }
    
    public void setGayAffirming(boolean gayAffirming)
    {
        this.gayAffirming = gayAffirming;
    }
    
    public void setDistanceFromSearchPoint(double distance)
    {
        this.distanceFromSearchPoint = distance;
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
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public MusicStyle getMusicStyle()
    {
        return musicStyle;
    }
    
    @Override
    public boolean isParkingLotAvailable()
    {
        return parkingLotAvailable;
    }
    
    @Override
    public Set<Programs> getProgramsOffered()
    {
        return programmsOffered;
    }

    @Override
    public Set<AccessabilitySupport> getAccessabilitySupport()
    {
        return accessibilitySupport;
    }

    @Override
    public DressAttire getDressAttire()
    {
        return dressAttire;
    }

    @Override
    public ServiceStyle getServiceStyle()
    {
        return serviceStyle;
    }

    @Override
    public int compareTo(Organization o)
    {
        return ComparisonChain.start().compare(this.getDistanceFromSearchPoint(), o.getDistanceFromSearchPoint())
                .result();
    }
}