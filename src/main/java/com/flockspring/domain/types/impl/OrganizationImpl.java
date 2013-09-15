/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.flockspring.domain.types.Address;
import com.flockspring.domain.types.Affiliation;
import com.flockspring.domain.types.Image;
import com.flockspring.domain.types.Language;
import com.flockspring.domain.types.Leader;
import com.flockspring.domain.types.MusicStyle;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.Region;

@Entity
@Table(name="ORGANIZATION")
public class OrganizationImpl implements Organization
{

    private static final long serialVersionUID = -4255110271709019510L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @OneToOne
    @JoinColumn(name="ADDRESS_ID")
    private JpaAddressImpl address;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="REGION_ID")
    private RegionImpl region;
    
    @Column(name="MUSIC_STYLE")
    private MusicStyle musicStyle;
    
    @Column(name="YEAR_FOUNDED")
    private int yearFounded;
    
    @Column(name="SERVICE_TIMES")
    private String serviceTimes;
    
    @Column(name="SERVICE_DAYS")
    private String serviceDays;

    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="ORGANIZATION_LANGUAGES", joinColumns=@JoinColumn(name="ORGANIZATION_ID", referencedColumnName="ID"))
    private Set<Language> languages;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinTable(name="ORGANIZATION_IMAGES", joinColumns=@JoinColumn(name = "ORGANIZATION_ID"), inverseJoinColumns=@JoinColumn(name = "IMAGE_ID"))
    private Set<JpaImageImpl> images;

    @OneToMany(mappedBy="organization", fetch=FetchType.EAGER)
    private Set<LeaderImpl> leadershipTeam;
    
    @Column(name="PRIMARY_AFFILIATION")
    private Affiliation primaryAffiliation;
    
    @Column(name="AFFILIATION_DENOMINATION")
    private Affiliation affilationDenomination;
    
    @Column(name="AFFILIATION_SUBDENOMINATION")
    private Affiliation affiliationSubdenomination;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="PROGRAMS_OFFERED")
    private String programsOffered;
    
    @Column(name="AGE_DEMOGRAPHICS")
    private String ageDemographics;
    
    @Column(name="ETHNIC_DEMOGRAPHICS")
    private String ethnicDemographics;
            
    @Column(name="DESCRIPTION")
    private String description;
    
    @Column(name="WEBSITE_URL")
    private String websiteUrl;
    
    @Column(name="FACEBOOK_URL")
    private String facebookUrl;

    @Column(name="AVERAGE_SERVICE_CONGREGATION_SIZE")
    private int averageServiceCongregationSize;

    @Column(name="ENVIRONMENTALLY_FRIENDLY")
    private boolean envFriendly;
    
    @Column(name="PARKING_LOT")
    private boolean parkingLot;
    
    @Column(name="GAY_AFIRMING")
    private boolean gayAffirming;

    @Transient
    private int distanceFromSearchPoint;
    
    @Override
    public long getId()
    {
        return id;
    }

    @Override
    public Address getAddress()
    {
        return address;
    }

    @Override
    public MusicStyle getMusicStyle()
    {
        return musicStyle;
    }

    @Override
    public int getYearFounded()
    {
        return yearFounded;
    }

    @Override
    public String getServiceTimes()
    {
        return serviceTimes;
    }

    @Override
    public String getServiceDays()
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
        imageSet.addAll(images);
        
        return imageSet;
    }

    @Override
    public Set<Leader> getLeadershipTeam()
    {
        Set<Leader> leaderSet = new TreeSet<Leader>();
        leaderSet.addAll(leadershipTeam);
        
        return leaderSet;
    }

    @Override
    public Affiliation getPrimaryAffiliation()
    {
        return primaryAffiliation;
    }

    @Override
    public Affiliation getAffilationDenomination()
    {
        return affilationDenomination;
    }

    @Override
    public Affiliation getSubAffiliationDenomination()
    {
        return affiliationSubdenomination;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String getProgramsOffered()
    {
        return programsOffered;
    }

    @Override
    public String getAgeDemographics()
    {
        return ageDemographics;
    }

    @Override
    public String getEthnicDemographics()
    {
        return ethnicDemographics;
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
    public int getAverageServiceCongregationSize()
    {
        return averageServiceCongregationSize;
    }

    @Override
    public boolean isEnvFriendly()
    {
        return envFriendly;
    }

    @Override
    public boolean isParkingLot()
    {
        return parkingLot;
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
    public int getDistanceFromSearchPoint() 
    {
        return this.distanceFromSearchPoint;
    }

    public void setAddress(JpaAddressImpl address)
    {
        this.address = address;
    }

    public void setMusicStyle(MusicStyle musicStyle)
    {
        this.musicStyle = musicStyle;
    }

    public void setYearFounded(int yearFounded)
    {
        this.yearFounded = yearFounded;
    }

    public void setServiceTimes(String serviceTimes)
    {
        this.serviceTimes = serviceTimes;
    }

    public void setServiceDays(String serviceDays)
    {
        this.serviceDays = serviceDays;
    }

    public void setLanguages(Set<Language> languages)
    {
        this.languages = languages;
    }

    public void setImages(Set<JpaImageImpl> images)
    {
        this.images = images;
    }

    public void setLeadershipTeam(Set<LeaderImpl> leadershipTeam)
    {
        this.leadershipTeam = leadershipTeam;
    }

    public void setPrimaryAffiliation(Affiliation primaryAffiliation)
    {
        this.primaryAffiliation = primaryAffiliation;
    }

    public void setAffilationDenomination(Affiliation affilationDenomination)
    {
        this.affilationDenomination = affilationDenomination;
    }

    public void setSubAffiliationDenomination(Affiliation subAffiliationDenomination)
    {
        this.affiliationSubdenomination = subAffiliationDenomination;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setProgramsOffered(String programsOffered)
    {
        this.programsOffered = programsOffered;
    }

    public void setAgeDemographics(String ageDemographics)
    {
        this.ageDemographics = ageDemographics;
    }

    public void setEthnicDemographics(String ethnicDemographics)
    {
        this.ethnicDemographics = ethnicDemographics;
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

    public void setAverageServiceCongregationSize(int averageServiceCongregationSize)
    {
        this.averageServiceCongregationSize = averageServiceCongregationSize;
    }

    public void setEnvFriendly(boolean envFriendly)
    {
        this.envFriendly = envFriendly;
    }

    public void setParkingLot(boolean parkingLot)
    {
        this.parkingLot = parkingLot;
    }

    public void setGayAffirming(boolean gayAffirming)
    {
        this.gayAffirming = gayAffirming;
    }
    
    public void setDistanceFromSearchPoint(int distanceFromSearchPoint)
    {
        this.distanceFromSearchPoint = distanceFromSearchPoint;
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
}