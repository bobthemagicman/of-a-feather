/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import java.util.Set;

import org.springframework.util.AutoPopulatingList;

import com.flockspring.domain.types.AccessabilitySupport;
import com.flockspring.domain.types.Affiliation;
import com.flockspring.domain.types.DressAttire;
import com.flockspring.domain.types.Language;
import com.flockspring.domain.types.MusicStyle;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.Region;
import com.flockspring.domain.types.ServiceDay;
import com.flockspring.domain.types.ServiceStyle;
import com.flockspring.domain.types.impl.AddressImpl;
import com.flockspring.domain.types.impl.ImageImpl;
import com.flockspring.domain.types.impl.LeaderImpl;
import com.flockspring.domain.types.impl.OrganizationImpl;

/**
 * OrganizationCommand.java
 *
 * @author Justen L. Britain
 * @date Dec 8, 2013
 *
 */
public class OrganizationCommand
{
    private double distanceFromSearchPoint;
    private Set<AccessabilitySupport> accessibilitySupport;
    private Integer yearFounded;
    private boolean gayAffirming;
    private String name;
    private String missionStatement;
    private String statementOfFaith;
    private String websiteUrl;
    private String facebookUrl;
    private String twitterUrl;
    private CongregationSize congregationSize;
    private AddressImpl address;
    private MusicStyle musicStyle;
    private ServiceStyle serviceStyle;
    private DressAttire dressAttire;
    private Affiliation denomination;
    private Affiliation subDenomination;
    private Set<ImageImpl> images;
    private AutoPopulatingList<LeaderImpl> leadershipTeam;
    private Set<ServiceTime> serviceTimes;
    private Set<ServiceDay> serviceDays;
    private Set<Language> languages;
    private Set<Programs> programmsOffered;

    public Organization getOrganization()
    {
        
        return new OrganizationImpl(null, yearFounded, gayAffirming, name, missionStatement, statementOfFaith, 
                websiteUrl, facebookUrl, twitterUrl, congregationSize, address, null, musicStyle, serviceStyle, 
                dressAttire, denomination, subDenomination, null, images, leadershipTeam, serviceTimes, 
                serviceDays, languages, programmsOffered, accessibilitySupport, distanceFromSearchPoint);
    }
}
