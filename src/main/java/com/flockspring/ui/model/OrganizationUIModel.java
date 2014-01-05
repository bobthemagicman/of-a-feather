/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.flockspring.domain.types.Category;
import com.flockspring.domain.types.Programs;
import com.google.common.collect.ComparisonChain;

/**
 * OrganizationUIModel.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public class OrganizationUIModel implements Comparable<OrganizationUIModel> 
{

    private final String id;
    private final OrganizationOverviewUIModel overview;
    private final Set<MultimediaUIModel> multimedia;
    
    private final Set<LeaderUIModel> leadershipTeam;
    private final OrganizationStatementUIModel statements;
    private final ServiceOverviewUIModel servicesOverview;
    private final Set<ServiceDetailUIModel> serviceDetails;
    private final Map<Category<Programs>, Set<Programs>> programsOffered;
        
    public OrganizationUIModel(String id, OrganizationOverviewUIModel overview, Set<MultimediaUIModel> multimedia, 
            Set<LeaderUIModel> leadershipTeam, OrganizationStatementUIModel statements, ServiceOverviewUIModel servicesOverviews,
            Set<ServiceDetailUIModel> serviceDetails, Map<Category<Programs>, Set<Programs>> programsOffered2)
    {
        super();

        this.id = id;
        this.overview = overview;
        this.multimedia = multimedia;
        this.leadershipTeam = leadershipTeam;
        this.statements = statements;
        this.servicesOverview = servicesOverviews;
        this.serviceDetails = serviceDetails;
        this.programsOffered = programsOffered2;
    }

    public String getId()
    {
        return id;
    }
    
    public OrganizationOverviewUIModel getOverview()
    {
        return overview;
    }

    public Set<MultimediaUIModel> getMultimedia()
    {
        return multimedia;
    }

    public Set<LeaderUIModel> getLeadershipTeam()
    {
        return leadershipTeam;
    }

    public OrganizationStatementUIModel getStatements()
    {
        return statements;
    }

    public ServiceOverviewUIModel getServicesOverview()
    {
        return servicesOverview;
    }

    public Set<ServiceDetailUIModel> getServiceDetails()
    {
        return serviceDetails;
    }

    public Map<Category<Programs>, Set<Programs>> getProgramsOffered()
    {
        return programsOffered;
    }

    public AddressUIModel getAddress()
    {
        return this.overview.getAddress();
    }
    
    public SocialMediaUIModel getSocialMedia()
    {
        return this.overview.getSocialMedia();
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
    public boolean equals(Object obj)
    {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int compareTo(OrganizationUIModel right)
    {
        OrganizationUIModel left = this;
        return ComparisonChain.start()
                .compare(left.getId(), right.getId())
                .result();
    }
}