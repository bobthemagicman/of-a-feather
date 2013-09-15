/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.mapper;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flockspring.domain.types.Leader;
import com.flockspring.domain.types.MusicStyle;
import com.flockspring.domain.types.Organization;
import com.flockspring.ui.model.AddressUIModel;
import com.flockspring.ui.model.ImageUIModel;
import com.flockspring.ui.model.LanguageUIModel;
import com.flockspring.ui.model.LeaderUIModel;
import com.flockspring.ui.model.OrganizationUIModel;

/**
 * OrganizationUIModelMapper.java
 *
 * @author Justen L. Britain
 * @date Jul 20, 2013
 *
 */
@Component
public class OrganizationUIModelMapper
{
    private final AddressUIModelMapper addressUIModelMapper;
    private final ImageUIModelMapper imageUIModelMapper;
    private final LeaderUIModelMapper leaderUIModelMapper;
    private final LanguageUIModelMapper languageUIModelMapper;

    @Autowired
    public OrganizationUIModelMapper(AddressUIModelMapper addressUIModelMapper, ImageUIModelMapper imageUIModelMapper,
            LeaderUIModelMapper leaderUIModelMapper, LanguageUIModelMapper languageUIModelMapper)
    {
        this.addressUIModelMapper = addressUIModelMapper;
        this.imageUIModelMapper = imageUIModelMapper;
        this.leaderUIModelMapper = leaderUIModelMapper;
        this.languageUIModelMapper = languageUIModelMapper;
    }

    public OrganizationUIModel map(Organization organization)
    {
        if(organization == null)
        {
            return null;
        }
        
        AddressUIModel address =  addressUIModelMapper.map(organization.getAddress());
        MusicStyle musicStyle = organization.getMusicStyle();
        Set<LeaderUIModel> leadershipTeam = leaderUIModelMapper.map(organization.getLeadershipTeam());
        String srLdrBiography = getSeniorLeadersBiography(organization.getLeadershipTeam());
        Set<ImageUIModel> images = imageUIModelMapper.map(organization.getImages());
        boolean gayAffirming = organization.isGayAffirming();
        String serviceDays = organization.getServiceDays();
        String ethnicDemographics = organization.getEthnicDemographics();
        Set<LanguageUIModel> languages = languageUIModelMapper.map(organization.getLanguages());
        boolean parkingLot = organization.isParkingLot();
        String ageDemographics = organization.getAgeDemographics();
        boolean envFriendly = organization.isEnvFriendly();
        int averageServiceCongregationSize = organization.getAverageServiceCongregationSize();
        String programsOffered = organization.getProgramsOffered();
        String name = organization.getName();
        String subDenomination = organization.getSubAffiliationDenomination() == null ? null : organization.getSubAffiliationDenomination().getLocalizedStringCode();
        String facebookUrl = organization.getFacebookUrl();
        String websiteUrl = organization.getWebsiteUrl();
        String communityCategory = organization.getPrimaryAffiliation().getLocalizedStringCode();
        String description = organization.getDescription();
        String denomination = organization.getAffilationDenomination().getLocalizedStringCode();
        int distanceFromSearchPoint = organization.getDistanceFromSearchPoint();
        
        String serviceTimes = organization.getServiceTimes();
        int yearFounded = organization.getYearFounded();
        
        OrganizationUIModel model = new OrganizationUIModel(address, musicStyle, yearFounded, serviceTimes, languages, serviceDays, images,
                communityCategory, denomination, subDenomination, name, programsOffered, ageDemographics, ethnicDemographics, srLdrBiography, 
                description, websiteUrl, facebookUrl, averageServiceCongregationSize, envFriendly, parkingLot, gayAffirming, leadershipTeam, distanceFromSearchPoint);
        
        return model;
    }

    private String getSeniorLeadersBiography(Set<Leader> leadershipTeam)
    {
        Leader leader = null;
        
        for(Leader l : leadershipTeam)
        {
            if(l.isPrimaryLeader())
            {
                leader = l;
            }            
        }
        
        return leader == null ? "" : leader.getBio();
    }
}
