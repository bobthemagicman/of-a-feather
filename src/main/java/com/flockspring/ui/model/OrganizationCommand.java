/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.util.AutoPopulatingList;

import com.flockspring.domain.types.AccessabilitySupport;
import com.flockspring.domain.types.Affiliation;
import com.flockspring.domain.types.DressAttire;
import com.flockspring.domain.types.Language;
import com.flockspring.domain.types.MusicStyle;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.ServiceDay;
import com.flockspring.domain.types.ServiceStyle;
import com.flockspring.domain.types.impl.AddressImpl;
import com.flockspring.domain.types.impl.AgeDemographics;
import com.flockspring.domain.types.impl.AtmosphereImpl;
import com.flockspring.domain.types.impl.MultimediaObjectImpl;
import com.flockspring.domain.types.impl.LeaderImpl;
import com.flockspring.domain.types.impl.MusicalInstruments;
import com.flockspring.domain.types.impl.OrganizationImpl;
import com.flockspring.domain.types.impl.SocialMediaImpl;
import com.google.common.collect.Sets;

/**
 * OrganizationCommand.java
 *
 * @author Justen L. Britain
 * @date Dec 8, 2013
 *
 */
public class OrganizationCommand
{
    private AutoPopulatingList<AccessabilitySupport> accessibilitySupport;
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
    private AutoPopulatingList<ImageCommand> images;
    private AutoPopulatingList<LeaderCommand> leadershipTeam;
    private AutoPopulatingList<ServiceTime> serviceTimes;
    private AutoPopulatingList<ServiceDay> serviceDays;
    private AutoPopulatingList<Language> languages;
    private AutoPopulatingList<Programs> programmsOffered;
    private AgeDemographics ageDemongraphics;
    private AutoPopulatingList<MusicalInstruments> instruments;
    private boolean homeChurch;
    private String blogUrl;
    private String googlePlusUrl;
    private String youtubeUrl;
    private String podcastUrl;
    private String otherUrl;
    private String welcomeMessage;
    private Affiliation primaryAffiliation;

    public Organization getOrganization()
    {
//        Set<MusicalInstruments> instrumentSet = Sets.newTreeSet(instruments);
//        
//        AtmosphereImpl atmosphere = new AtmosphereImpl(congregationSize, musicStyle, serviceStyle, dressAttire, 
//                ageDemongraphics, instrumentSet, gayAffirming, homeChurch, yearFounded);
//        
//        SocialMediaImpl socialMedia = new SocialMediaImpl(websiteUrl, blogUrl, googlePlusUrl, youtubeUrl, 
//                podcastUrl, facebookUrl, twitterUrl, otherUrl);
//        
//        Set<MultimediaObjectImpl> imageSet = Sets.newTreeSet(convertImageCommands(images));
//        Set<LeaderImpl> leaderSet = Sets.newTreeSet(convertLeaderCommands(leadershipTeam));
//        Set<Language> languageSet = Sets.newTreeSet(languages);
//        Set<ServiceTime> serviceTimeSet = Sets.newTreeSet(serviceTimes);
//        Set<ServiceDay> serviceDaySet = Sets.newTreeSet(serviceDays);
//        Set<Programs> programSet = Sets.newTreeSet(programmsOffered);
//        Set<AccessabilitySupport> accessabilitySupportSet = Sets.newTreeSet(accessibilitySupport);
//        
//        return new OrganizationImpl(yearFounded, name, missionStatement, statementOfFaith, welcomeMessage, 
//                address, atmosphere, socialMedia, denomination, subDenomination, primaryAffiliation, images, 
//                leadershipTeam, serviceTimes, serviceDays, languages, programmsOffered, accessibilitySupport, 
//                0.0);
        
        return null;
        
    }

//    private List<MultimediaObjectImpl> convertImageCommands(AutoPopulatingList<ImageCommand> imagesToBeConverted)
//    {
//        List<MultimediaObjectImpl> convertedImages = new ArrayList<>(imagesToBeConverted.size());
//        
//        for(ImageCommand im : imagesToBeConverted)
//        {
//            convertedImages.add(convertImageCommand(im));
//        }
//        
//        return convertedImages;
//    }
//    
//    private MultimediaObjectImpl convertImageCommand(ImageCommand im)
//    {
//        return new MultimediaObjectImpl(im.getName(), im.getPath(), im.getAltText(), 
//                im.getTitleText(), im.isPrimary());
//    }
//    
//    private List<LeaderImpl> convertLeaderCommands(AutoPopulatingList<LeaderCommand> leadersToBeConverted)
//    {
//        List<LeaderImpl> convertedLeaders = new ArrayList<>(leadersToBeConverted.size());
//        for(LeaderCommand leader : leadersToBeConverted)
//        {
//            convertedLeaders.add(new LeaderImpl(leader.getName(), leader.getBio(), leader.getTitle(), 
//                    leader.getRole(), convertImageCommand(leader.getImage()), leader.isPrimaryContact(), leader.isPrimaryLeader(),
//                    leader.getEmailAddress(), leader.getPhoneNumber(), leader.getYearStarted()));
//        }
//        
//        return convertedLeaders;
//    }
}
