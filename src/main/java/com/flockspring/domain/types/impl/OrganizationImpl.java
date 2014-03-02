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

import com.flockspring.domain.types.AccessibilitySupport;
import com.flockspring.domain.types.Address;
import com.flockspring.domain.types.Affiliation;
import com.flockspring.domain.types.Leader;
import com.flockspring.domain.types.MultimediaObject;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.Programs;

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
    private String extraServiceDetails;

    private AddressImpl address;
    private AtmosphereImpl atmosphere;
    private SocialMediaImpl socialMedia;
    private Affiliation denomination;
    private Affiliation subDenomination;
    private Affiliation primaryAffiliation;

    private Set<MultimediaObjectImpl> multimedia;
    private Set<LeaderImpl> leadershipTeam;
    private Set<Programs> programsOffered;
    private Set<AccessibilitySupport> accessibilitySupport;

    public OrganizationImpl(String id, Integer yearFounded, String name, String missionStatement, String statementOfFaith, String welcomeMessage,
            AddressImpl address, AtmosphereImpl atmosphere, SocialMediaImpl socialMedia, Affiliation denomination, Affiliation subDenomination,
            Affiliation primaryAffiliation, Set<MultimediaObjectImpl> multimedia, Set<LeaderImpl> leadershipTeam,
            Set<Programs> programsOffered, Set<AccessibilitySupport> accessibilitySupport, String extraServiceDetails)
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
        this.programsOffered = programsOffered;
        this.accessibilitySupport = accessibilitySupport;
        this.extraServiceDetails = extraServiceDetails;
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
        return yearFounded == null ? 0 : yearFounded;
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

    @Override
    public String getExtraServiceDetails()
    {
        return extraServiceDetails;
    }

    @Override
    public Set<AccessibilitySupport> getAccessibilitySupport()
    {
        return accessibilitySupport;
    }

    public void setId(String id)
    {
        this.id = id;
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

    public void setWelcomeMessage(String welcomeMessage)
    {
        this.welcomeMessage = welcomeMessage;
    }

    public void setExtraServiceDetails(String extraServiceDetails)
    {
        this.extraServiceDetails = extraServiceDetails;
    }

    public void setAddress(AddressImpl address)
    {
        this.address = address;
    }

    public void setAtmosphere(AtmosphereImpl atmosphere)
    {
        this.atmosphere = atmosphere;
    }

    public void setSocialMedia(SocialMediaImpl socialMedia)
    {
        this.socialMedia = socialMedia;
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

    public void setProgramsOffered(Set<Programs> programsOffered)
    {
        this.programsOffered = programsOffered;
    }

    public void setAccessibilitysupport(Set<AccessibilitySupport> accessibilitySupport)
    {
        this.accessibilitySupport = accessibilitySupport;
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