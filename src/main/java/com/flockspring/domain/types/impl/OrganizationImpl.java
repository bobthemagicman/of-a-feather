/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import com.flockspring.domain.types.AccessabilitySupport;
import com.flockspring.domain.types.Address;
import com.flockspring.domain.types.Affiliation;
import com.flockspring.domain.types.Language;
import com.flockspring.domain.types.Leader;
import com.flockspring.domain.types.MultimediaObject;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.ServiceDay;
import com.flockspring.ui.model.Programs;
import com.flockspring.ui.model.ServiceTime;

/**
 * OrganizationImpl.java
 * 
 * @author Justen L. Britain
 * @date May 18, 2013
 * 
 */
@Document(collection = "organizations")
public class OrganizationImpl implements Organization, Serializable
{
    private static final long serialVersionUID = -3602244882007924589L;

    private String id;
    private Integer yearFounded;
    private String name;
    private String missionStatement;
    private String statementOfFaith;
    private String welcomeMessage;

    private AddressImpl address;
    private AtmosphereImpl atmosphere;
    private SocialMediaImpl socialMedia;
    private Affiliation denomination;
    private Affiliation subDenomination;
    private Affiliation primaryAffiliation;

    private Set<MultimediaObjectImpl> multimedia;
    private Set<LeaderImpl> leadershipTeam;
    private Set<ServiceTime> serviceTimes;
    private Set<ServiceDay> serviceDays;
    private Set<Language> languages;
    private Set<Programs> programsOffered;
    private Set<AccessabilitySupport> accessabilitysupport;

    public OrganizationImpl(String id, Integer yearFounded, String name, String missionStatement, String statementOfFaith, String welcomeMessage,
            AddressImpl address, AtmosphereImpl atmosphere, SocialMediaImpl socialMedia, Affiliation denomination, Affiliation subDenomination,
            Affiliation primaryAffiliation, Set<MultimediaObjectImpl> multimedia, Set<LeaderImpl> leadershipTeam, Set<ServiceTime> serviceTimes,
            Set<ServiceDay> serviceDays, Set<Language> languages, Set<Programs> programsOffered, Set<AccessabilitySupport> accessabilitysupport)
    {
        super();
        
        this.id = id;
        this.yearFounded = yearFounded;
        this.name = name;
        this.missionStatement = missionStatement;
        this.statementOfFaith = statementOfFaith;
        this.welcomeMessage = welcomeMessage;
        this.address = address;
        this.atmosphere = atmosphere;
        this.socialMedia = socialMedia;
        this.denomination = denomination;
        this.subDenomination = subDenomination;
        this.primaryAffiliation = primaryAffiliation;
        this.multimedia = multimedia;
        this.leadershipTeam = leadershipTeam;
        this.serviceTimes = serviceTimes;
        this.serviceDays = serviceDays;
        this.languages = languages;
        this.programsOffered = programsOffered;
        this.accessabilitysupport = accessabilitysupport;
    }

    public OrganizationImpl()
    {
        super();
    }

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
    public Integer getYearFounded()
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
    public Set<MultimediaObject> getMultimedia()
    {
        Set<MultimediaObject> imageSet = new TreeSet<>();
        if (multimedia != null)
        {
            imageSet.addAll(multimedia);
        }

        return imageSet;
    }

    @Override
    public Set<Leader> getLeadershipTeam()
    {

        Set<Leader> leaderSet = new TreeSet<>();
        if (leadershipTeam != null)
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
    public String getMissionStatement()
    {
        return missionStatement;
    }

    @Override
    public String getStatementOfFaith()
    {
        return statementOfFaith;
    }

    @Override
    public Set<Programs> getProgramsOffered()
    {
        return programsOffered;
    }

    @Override
    public String getWelcomeMessage()
    {
        return welcomeMessage;
    }

    @Override
    public SocialMedia getSocialMedia()
    {
        return socialMedia;
    }

    @Override
    public Atmosphere getAtmosphere()
    {
        return this.atmosphere;
    }

    public void setYearFounded(Integer yearFounded)
    {
        this.yearFounded = yearFounded;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setMissionStatement(String missionStatement)
    {
        this.missionStatement = missionStatement;
    }

    public void setStatementOfFaith(String statementOfFaith)
    {
        this.statementOfFaith = statementOfFaith;
    }

    public void setAddress(AddressImpl address)
    {
        this.address = address;
    }

    public void setDenomination(Affiliation denomination)
    {
        this.denomination = denomination;
    }

    public void setSubDenomination(Affiliation subDenomination)
    {
        this.subDenomination = subDenomination;
    }

    public void setPrimaryAffiliation(Affiliation primaryAffiliation)
    {
        this.primaryAffiliation = primaryAffiliation;
    }

    public void setMultimedia(Set<MultimediaObjectImpl> multimedia)
    {
        this.multimedia = multimedia;
    }

    public void setLeadershipTeam(Set<LeaderImpl> leadershipTeam)
    {
        this.leadershipTeam = leadershipTeam;
    }

    public void setServiceTimes(Set<ServiceTime> serviceTimes)
    {
        this.serviceTimes = serviceTimes;
    }

    public void setServiceDays(Set<ServiceDay> serviceDays)
    {
        this.serviceDays = serviceDays;
    }

    public void setLanguages(Set<Language> languages)
    {
        this.languages = languages;
    }

    public void setProgramsOffered(Set<Programs> programmsOffered)
    {
        this.programsOffered = programmsOffered;
    }

    public void setAccessabilitysupport(Set<AccessabilitySupport> accessabilitysupport)
    {
        this.accessabilitysupport = accessabilitysupport;
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
    public Set<AccessabilitySupport> getAccessabilitySupport()
    {
        return accessabilitysupport;
    }
}