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
package com.ofafeather.domain.types.impl;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.common.collect.Sets;
import com.ofafeather.domain.types.AccessibilitySupport;
import com.ofafeather.domain.types.Address;
import com.ofafeather.domain.types.Affiliation;
import com.ofafeather.domain.types.Leader;
import com.ofafeather.domain.types.MultimediaObject;
import com.ofafeather.domain.types.Organization;
import com.ofafeather.domain.types.Programs;

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
    
    public static class OrganizationBuilder
    {

        protected String id;
        protected Integer yearFounded;
        protected String name;
        protected String missionStatement;
        protected String statementOfFaith;
        protected String welcomeMessage;
        protected AddressImpl address;
        protected AtmosphereImpl atmosphere;
        protected SocialMediaImpl socialMedia;
        protected Affiliation denomination;
        protected Affiliation subDenomination;
        protected Affiliation primaryAffiliation;
        protected Set<MultimediaObjectImpl> multimedia;
        protected Set<LeaderImpl> leadershipTeam;
        protected Set<Programs> programsOffered;
        protected Set<AccessibilitySupport> accessibilitySupport;
        protected String extraServiceDetails;
        
        private boolean leadershipTeamSetReset = false;
        private boolean multimediaObjectSetReset = false;
        private boolean programsSetReset = false;
        private boolean accessibilitySupportSetReset = false;

        public OrganizationBuilder withId(String id)
        {
            this.id = id;
            return this;
        }
        
        public OrganizationBuilder withYearFounded(Integer yearFounded)
        {
            this.yearFounded = yearFounded;
            return this;
        }
        
        public OrganizationBuilder withName(String name)
        {
            this.name = name;
            return this;
        }
        
        public OrganizationBuilder withMissionStatement(String missionStatement)
        {
            this.missionStatement = missionStatement;
            return this;
        }
        
        public OrganizationBuilder withStatementOfFaith(String statementOfFaith)
        {
            this.statementOfFaith = statementOfFaith;
            return this;
        }
        
        public OrganizationBuilder withWelcomeMessage(String welcomeMessage)
        {
            this.welcomeMessage = welcomeMessage;
            return this;
        }
        
        public OrganizationBuilder withAddress(AddressImpl address)
        {
            this.address = address;
            return this;
        }
        
        public OrganizationBuilder withAtmosphere(AtmosphereImpl atmosphere)
        {
            this.atmosphere = atmosphere;
            return this;
        }
        
        public OrganizationBuilder withSocialMedia(SocialMediaImpl socialMedia)
        {
            this.socialMedia = socialMedia;
            return this;
        }
        
        public OrganizationBuilder withDenomination(Affiliation denomination)
        {
            this.denomination = denomination;
            return this;
        }
        
        public OrganizationBuilder withSubDenomination(Affiliation subDenomination)
        {
            this.subDenomination = subDenomination;
            return this;
        }
        
        public OrganizationBuilder withMultimedia(Set<MultimediaObjectImpl> multimedia)
        {
            this.multimedia = multimedia;
            return this;
        }
        
        public OrganizationBuilder withLeadershipTeam(Set<LeaderImpl> leadershipTeam)
        {
            this.leadershipTeam = leadershipTeam;
            return this;
        }
        
        public OrganizationBuilder withProgramsOffered(Set<Programs> programsOffered)
        {
            this.programsOffered = programsOffered;
            return this;
        }
        
        public OrganizationBuilder withAccessabilitySupport(Set<AccessibilitySupport> accessibilitySupport)
        {
            this.accessibilitySupport = accessibilitySupport;
            return this;
        }
        
        public OrganizationBuilder withExtraServiceDetails(String extraServiceDetails)
        {
            this.extraServiceDetails = extraServiceDetails;
            return this;
        }
        
        public OrganizationBuilder addMultimediaObject(MultimediaObjectImpl multimediaObject)
        {
            if(!multimediaObjectSetReset || this.multimedia == null)
            {
                this.multimedia = Sets.newTreeSet(Arrays.asList(multimediaObject));
                this.multimediaObjectSetReset = true;
            }
            else
            {
                this.multimedia.add(multimediaObject);
            }
            
            return this;
        }
        
        public OrganizationBuilder addLeader(LeaderImpl leaderToAdd)
        {
            if(!leadershipTeamSetReset || this.leadershipTeam == null)
            {
                this.leadershipTeam = Sets.newTreeSet(Arrays.asList(leaderToAdd));
                this.leadershipTeamSetReset = true;
            }
            else
            {
                this.leadershipTeam.add(leaderToAdd);
            }
            
            return this;
        }

        public OrganizationBuilder addAccessibilitySupport(AccessibilitySupport accessibilitySupportToAdd)
        {
            if(!this.accessibilitySupportSetReset || this.accessibilitySupport == null)
            {
                this.accessibilitySupport = Sets.newTreeSet(Arrays.asList(accessibilitySupportToAdd));
                this.accessibilitySupportSetReset = true;
            }
            else
            {
                this.accessibilitySupport.add(accessibilitySupportToAdd);
            }
            
            return this;
        }
        
        public OrganizationBuilder addProgram(Programs programToAdd)
        {
            if(!this.programsSetReset || this.programsOffered == null)
            {
                this.programsOffered = Sets.newTreeSet(Arrays.asList(programToAdd));
                this.programsSetReset = true;
            }
            else
            {
                this.programsOffered.add(programToAdd);
            }
            
            return this;
        }
        
        public Organization build()
        {
            return new OrganizationImpl(id, yearFounded, name, missionStatement, statementOfFaith, welcomeMessage, 
                    address, atmosphere, socialMedia, denomination, subDenomination, primaryAffiliation, multimedia, 
                    leadershipTeam, programsOffered, accessibilitySupport, extraServiceDetails);
            
        }

    }
}