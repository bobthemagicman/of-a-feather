/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.mapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flockspring.domain.types.AccessabilitySupport;
import com.flockspring.domain.types.Affiliation;
import com.flockspring.domain.types.Language;
import com.flockspring.domain.types.Leader;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.ServiceDetails;
import com.flockspring.domain.types.impl.Atmosphere;
import com.flockspring.ui.model.AddressUIModel;
import com.flockspring.ui.model.LanguageUIModel;
import com.flockspring.ui.model.LeaderUIModel;
import com.flockspring.ui.model.MultimediaUIModel;
import com.flockspring.ui.model.OrganizationOverviewUIModel;
import com.flockspring.ui.model.OrganizationStatementUIModel;
import com.flockspring.ui.model.OrganizationUIModel;
import com.flockspring.ui.model.Programs;
import com.flockspring.ui.model.ServiceDetailUIModel;
import com.flockspring.ui.model.ServiceOverviewUIModel;
import com.flockspring.ui.model.SocialMediaUIModel;

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
    private final MultimediaUIModelMapper multimediaUIModelMapper;
    private final LeaderUIModelMapper leaderUIModelMapper;
    private final LanguageUIModelMapper languageUIModelMapper;
    private final SocialMediaUIModelMapper socialMediaUIModelMapper;

    @Autowired
    public OrganizationUIModelMapper(AddressUIModelMapper addressUIModelMapper, MultimediaUIModelMapper multimediaUIModelMapper,
            LeaderUIModelMapper leaderUIModelMapper, LanguageUIModelMapper languageUIModelMapper, SocialMediaUIModelMapper socialMediaUIModelMapper)
    {
        this.addressUIModelMapper = addressUIModelMapper;
        this.multimediaUIModelMapper = multimediaUIModelMapper;
        this.leaderUIModelMapper = leaderUIModelMapper;
        this.languageUIModelMapper = languageUIModelMapper;
        this.socialMediaUIModelMapper = socialMediaUIModelMapper;
    }

    public OrganizationUIModel map(Organization organization)
    {
        return map(organization, -1);
    }

    public OrganizationUIModel map(Organization organization, double distance)
    {
        if (organization == null)
        {
            return null;
        }

        Set<LeaderUIModel> leadershipTeam = leaderUIModelMapper.map(organization.getLeadershipTeam());
        Set<MultimediaUIModel> multimedia = multimediaUIModelMapper.map(organization.getMultimedia());
        Set<LanguageUIModel> languages = getLanguages(); 
        OrganizationOverviewUIModel overview = getOrganizationOverviewUIModel(organization, distance);

        OrganizationStatementUIModel statements = new OrganizationStatementUIModel(organization.getMissionStatement(),
                organization.getStatementOfFaith(), organization.getWelcomeMessage());

        ServiceOverviewUIModel servicesOverview = new ServiceOverviewUIModel(getServiceDuration(organization.getAtmosphere()), languages,
                getServiceSchedule(organization));

        Set<ServiceDetailUIModel> serviceDetails = getServiceDetails(organization);
        Map<Programs, Set<Programs>> programsOffered = getProgramsOffered(organization);

        OrganizationUIModel model = new OrganizationUIModel(organization.getId(), overview, multimedia, leadershipTeam, statements, servicesOverview,
                serviceDetails, programsOffered);

        return model;
    }

    private Set<LanguageUIModel> getLanguages()
    {
        
        return null;
    }

    private Map<Programs, Set<Programs>> getProgramsOffered(Organization organization)
    {
        Map<Programs, Set<Programs>> programsMap = new HashMap<>();
        for (Programs p : organization.getProgramsOffered())
        {
            if (programsMap.containsKey(p.getCategory()))
            {
                programsMap.get(p.getCategory()).add(p);
            } else
            {
                Set<Programs> programSet = new TreeSet<Programs>();
                programsMap.put(p.getCategory(), programSet);
            }
        }

        return programsMap;
    }

    private int getServiceDuration(Atmosphere atmosphere)
    {
        int duration = 0;
        for (ServiceDetails s : atmosphere.getServiceDetails())
        {
            if (duration == 0 || s.getDurationInMinutes() > duration)
            {
                duration = s.getDurationInMinutes();
            }
        }

        return duration;
    }

    private String getServiceSchedule(Organization organization)
    {

        return null;
    }

    private Set<ServiceDetailUIModel> getServiceDetails(Organization organization)
    {
        Set<ServiceDetailUIModel> serviceDetails = new TreeSet<>();
        for (ServiceDetails sd : organization.getAtmosphere().getServiceDetails())
        {

            ServiceDetailUIModel sdUIM = new ServiceDetailUIModel(sd.getServiceName(), sd.getInstruments(), sd.getMusicStyle(), 
                    sd.getServiceStyle(), sd.getAgeDemongraphics(), sd.getDressAttire());
            
            serviceDetails.add(sdUIM);            
        }
        
        return serviceDetails;
    }

    private OrganizationOverviewUIModel getOrganizationOverviewUIModel(Organization organization, double distance)
    {
        Atmosphere atmosphere = organization.getAtmosphere();
        AddressUIModel address = addressUIModelMapper.map(organization.getAddress());
        SocialMediaUIModel socialMedia = socialMediaUIModelMapper.map(organization.getSocialMedia());

        Leader leadPastor = getLeadPastor(organization.getLeadershipTeam());

        // TODO: jbritain once we have a user infrastructure this will be
        // dynamic
        boolean isUserFavorite = false;

        // TODO: jbritain we want to display twillio number here, not the church
        // number.
        String phoneNumber = "(510) 261-2052 ext 2323";

        // TODO: jbritain format serviceTimesShort
        String serviceTimesShort = "";

        String subDenominationLocalizationCode = organization.getSubDenomination() == Affiliation.NONE ? "" : organization.getSubDenomination()
                .getLocalizedStringCode();

        return new OrganizationOverviewUIModel(organization.getName(), organization.getDenomination().getLocalizedStringCode(),
                subDenominationLocalizationCode, organization.getYearFounded(), leadPastor.getName(), atmosphere.getCongregationSize(), phoneNumber,
                organization.getSocialMedia().getWebsiteUrl(), serviceTimesShort, isUserFavorite, socialMedia, address, distance,
                getParkingLotInfo(organization.getAccessabilitySupport()));
    }

    private boolean getParkingLotInfo(Set<AccessabilitySupport> accessabilitySupports)
    {
        return accessabilitySupports.contains(AccessabilitySupport.PARKING_GARAGE)
                || accessabilitySupports.contains(AccessabilitySupport.PARKING_LOT);
    }

    private Leader getLeadPastor(Set<Leader> leadershipTeam)
    {
        for (Leader l : leadershipTeam)
        {
            if (l.isPrimaryLeader())
            {
                return l;
            }
        }

        return null;
    }
}
