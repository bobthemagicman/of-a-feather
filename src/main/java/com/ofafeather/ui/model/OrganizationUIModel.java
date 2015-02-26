/**
 *
 *   Copyright 2015 Justen L. Britain
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 **/
package com.ofafeather.ui.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.collect.ComparisonChain;
import com.ofafeather.domain.types.Category;
import com.ofafeather.domain.types.Programs;

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
    private final Map<String, List<String>> serviceDayTimes;
    private final Map<Category<Programs>, Set<Programs>> programsOffered;
        
    public OrganizationUIModel(String id, OrganizationOverviewUIModel overview, Set<MultimediaUIModel> multimedia, 
            Set<LeaderUIModel> leadershipTeam, OrganizationStatementUIModel statements, ServiceOverviewUIModel servicesOverviews,
            Set<ServiceDetailUIModel> serviceDetails, Map<Category<Programs>, Set<Programs>> programsOffered, 
            Map<String, List<String>> serviceDayTimes)
    {
        super();

        this.id = id;
        this.overview = overview;
        this.multimedia = multimedia;
        this.leadershipTeam = leadershipTeam;
        this.statements = statements;
        this.servicesOverview = servicesOverviews;
        this.serviceDetails = serviceDetails;
        this.programsOffered = programsOffered;
        this.serviceDayTimes = serviceDayTimes;
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
    
    public Map<String, List<String>> getServiceDayTimes()
    {
        return serviceDayTimes;
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