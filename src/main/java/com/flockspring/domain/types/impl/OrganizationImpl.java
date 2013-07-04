/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.flockspring.domain.types.Affiliation;
import com.flockspring.domain.types.Leader;
import com.flockspring.domain.types.MusicStyle;
import com.flockspring.domain.types.Organization;
import com.lehman.technology.group.common.domain.types.Address;
import com.lehman.technology.group.common.domain.types.Image;
import com.lehman.technology.group.common.domain.types.Language;
import com.lehman.technology.group.common.domain.types.impl.JpaAddressImpl;
import com.lehman.technology.group.common.domain.types.impl.JpaImageImpl;

@Entity
@Table(name="ORGANIZATION")
public class OrganizationImpl implements Organization, Serializable
{

    private static final long serialVersionUID = -4255110271709019510L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @OneToOne
    @JoinColumn(name="ADDRESS_ID")
    private JpaAddressImpl address;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="MUSIC_STYLE")
    private MusicStyle musicStyle;
    
    @Column(name="YEAR_FOUNDED")
    private int yearFounded;
    
    @Column(name="SERVICE_TIMES")
    private String serviceTimes;
    
    @Column(name="SERVICE_DAYS")
    private String serviceDays;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="ORGANIZATION_LEADERS", joinColumns=@JoinColumn(name="COMMUNITY_ID", referencedColumnName="ID"))
    @Column(name="LANGUAGE")
    private List<Language> languages;

    @OneToMany
    @JoinTable(name="ORGANIZATION_IMAGES", joinColumns=@JoinColumn(name = "ORGANIZATION_ID"), inverseJoinColumns=@JoinColumn(name = "IMAGE_ID"))
    private List<JpaImageImpl> images;

    @OneToMany(mappedBy="organization")
    private List<LeaderImpl> leadershipTeam;

    @ManyToOne
    @JoinColumn(name="PRIMARY_AFFILIATION_ID")
    private AffiliationImpl primaryAffiliation;
    
    @ManyToOne
    @JoinColumn(name = "AFFILIATION_DENOMINATION_ID")
    private AffiliationImpl affilationDenomination;
    
    @ManyToOne
    @JoinColumn(name = "SUB_AFFILIATION_DENOMINATION_ID")
    private AffiliationImpl subAffiliationDenomination;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="PROGRAMS_OFFERED")
    private String programsOffered;
    
    @Column(name="AGE_DEMOGRAPHICS")
    private String ageDemographics;
    
    @Column(name="ETHNIC_DEMOGRAPHICS")
    private String ethnicDemographics;
    
    @Column(name="PRIMARY_LEADER_ID")
    private LeaderImpl primaryLeader;
    
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
    public List<Language> getLanguages()
    {
        return languages;
    }

    @Override
    public List<Image> getImages()
    {
        List<Image> imageList = new ArrayList<Image>(images.size());
        imageList.addAll(images);
        
        return imageList;
    }

    @Override
    public List<Leader> getLeadershipTeam()
    {
        List<Leader> leaderList = new ArrayList<Leader>(leadershipTeam.size());
        leaderList.addAll(leadershipTeam);
        
        return leaderList;
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
        return subAffiliationDenomination;
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
    public Leader getPrimaryLeader()
    {
        return primaryLeader;
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

    public void setId(long id)
    {
        this.id = id;
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

    public void setLanguages(List<Language> languages)
    {
        this.languages = languages;
    }

    public void setImages(List<JpaImageImpl> images)
    {
        this.images = images;
    }

    public void setLeadershipTeam(List<LeaderImpl> leadershipTeam)
    {
        this.leadershipTeam = leadershipTeam;
    }

    public void setPrimaryAffiliation(AffiliationImpl primaryAffiliation)
    {
        this.primaryAffiliation = primaryAffiliation;
    }

    public void setAffilationDenomination(AffiliationImpl affilationDenomination)
    {
        this.affilationDenomination = affilationDenomination;
    }

    public void setSubAffiliationDenomination(AffiliationImpl subAffiliationDenomination)
    {
        this.subAffiliationDenomination = subAffiliationDenomination;
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

    public void setPrimaryLeader(LeaderImpl primaryLeader)
    {
        this.primaryLeader = primaryLeader;
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

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((affilationDenomination == null) ? 0 : affilationDenomination.hashCode());
        result = prime * result + ((ageDemographics == null) ? 0 : ageDemographics.hashCode());
        result = prime * result + averageServiceCongregationSize;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + (envFriendly ? 1231 : 1237);
        result = prime * result + ((ethnicDemographics == null) ? 0 : ethnicDemographics.hashCode());
        result = prime * result + ((facebookUrl == null) ? 0 : facebookUrl.hashCode());
        result = prime * result + (gayAffirming ? 1231 : 1237);
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((images == null) ? 0 : images.hashCode());
        result = prime * result + ((languages == null) ? 0 : languages.hashCode());
        result = prime * result + ((leadershipTeam == null) ? 0 : leadershipTeam.hashCode());
        result = prime * result + ((musicStyle == null) ? 0 : musicStyle.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (parkingLot ? 1231 : 1237);
        result = prime * result + ((primaryAffiliation == null) ? 0 : primaryAffiliation.hashCode());
        result = prime * result + ((programsOffered == null) ? 0 : programsOffered.hashCode());
        result = prime * result + ((primaryLeader == null) ? 0 : primaryLeader.hashCode());
        result = prime * result + ((serviceDays == null) ? 0 : serviceDays.hashCode());
        result = prime * result + ((serviceTimes == null) ? 0 : serviceTimes.hashCode());
        result = prime * result + ((subAffiliationDenomination == null) ? 0 : subAffiliationDenomination.hashCode());
        result = prime * result + ((websiteUrl == null) ? 0 : websiteUrl.hashCode());
        result = prime * result + yearFounded;
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
        OrganizationImpl other = (OrganizationImpl) obj;
        if (address == null)
        {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (affilationDenomination == null)
        {
            if (other.affilationDenomination != null)
                return false;
        } else if (!affilationDenomination.equals(other.affilationDenomination))
            return false;
        if (ageDemographics == null)
        {
            if (other.ageDemographics != null)
                return false;
        } else if (!ageDemographics.equals(other.ageDemographics))
            return false;
        if (averageServiceCongregationSize != other.averageServiceCongregationSize)
            return false;
        if (description == null)
        {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (envFriendly != other.envFriendly)
            return false;
        if (ethnicDemographics == null)
        {
            if (other.ethnicDemographics != null)
                return false;
        } else if (!ethnicDemographics.equals(other.ethnicDemographics))
            return false;
        if (facebookUrl == null)
        {
            if (other.facebookUrl != null)
                return false;
        } else if (!facebookUrl.equals(other.facebookUrl))
            return false;
        if (gayAffirming != other.gayAffirming)
            return false;
        if (id != other.id)
            return false;
        if (images == null)
        {
            if (other.images != null)
                return false;
        } else if (!images.equals(other.images))
            return false;
        if (languages == null)
        {
            if (other.languages != null)
                return false;
        } else if (!languages.equals(other.languages))
            return false;
        if (leadershipTeam == null)
        {
            if (other.leadershipTeam != null)
                return false;
        } else if (!leadershipTeam.equals(other.leadershipTeam))
            return false;
        if (musicStyle != other.musicStyle)
            return false;
        if (name == null)
        {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (parkingLot != other.parkingLot)
            return false;
        if (primaryAffiliation == null)
        {
            if (other.primaryAffiliation != null)
                return false;
        } else if (!primaryAffiliation.equals(other.primaryAffiliation))
            return false;
        if (programsOffered == null)
        {
            if (other.programsOffered != null)
                return false;
        } else if (!programsOffered.equals(other.programsOffered))
            return false;
        if (primaryLeader == null)
        {
            if (other.primaryLeader != null)
                return false;
        } else if (!primaryLeader.equals(other.primaryLeader))
            return false;
        if (serviceDays == null)
        {
            if (other.serviceDays != null)
                return false;
        } else if (!serviceDays.equals(other.serviceDays))
            return false;
        if (serviceTimes == null)
        {
            if (other.serviceTimes != null)
                return false;
        } else if (!serviceTimes.equals(other.serviceTimes))
            return false;
        if (subAffiliationDenomination == null)
        {
            if (other.subAffiliationDenomination != null)
                return false;
        } else if (!subAffiliationDenomination.equals(other.subAffiliationDenomination))
            return false;
        if (websiteUrl == null)
        {
            if (other.websiteUrl != null)
                return false;
        } else if (!websiteUrl.equals(other.websiteUrl))
            return false;
        if (yearFounded != other.yearFounded)
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "OrganizationImpl [id=" + id + ", " + (address != null ? "address=" + address + ", " : "")
                + (musicStyle != null ? "musicStyle=" + musicStyle + ", " : "") + "yearFounded=" + yearFounded + ", "
                + (serviceTimes != null ? "serviceTimes=" + serviceTimes + ", " : "")
                + (serviceDays != null ? "serviceDays=" + serviceDays + ", " : "") + (languages != null ? "languages=" + languages + ", " : "")
                + (images != null ? "images=" + images + ", " : "") + (leadershipTeam != null ? "leadershipTeam=" + leadershipTeam + ", " : "")
                + (primaryAffiliation != null ? "primaryAffiliation=" + primaryAffiliation + ", " : "")
                + (affilationDenomination != null ? "affilationDenomination=" + affilationDenomination + ", " : "")
                + (subAffiliationDenomination != null ? "subAffiliationDenomination=" + subAffiliationDenomination + ", " : "")
                + (name != null ? "name=" + name + ", " : "") + (programsOffered != null ? "programsOffered=" + programsOffered + ", " : "")
                + (ageDemographics != null ? "ageDemographics=" + ageDemographics + ", " : "")
                + (ethnicDemographics != null ? "ethnicDemographics=" + ethnicDemographics + ", " : "")
                + (primaryLeader != null ? "seniorLeader=" + primaryLeader + ", " : "")
                + (description != null ? "description=" + description + ", " : "") + (websiteUrl != null ? "websiteUrl=" + websiteUrl + ", " : "")
                + (facebookUrl != null ? "facebookUrl=" + facebookUrl + ", " : "") + "averageServiceCongregationSize="
                + averageServiceCongregationSize + ", envFriendly=" + envFriendly + ", parkingLot=" + parkingLot + ", gayAffirming=" + gayAffirming
                + "]";
    }
}