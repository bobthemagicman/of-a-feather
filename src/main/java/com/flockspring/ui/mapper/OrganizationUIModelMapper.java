/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.flockspring.domain.types.AccessibilitySupport;
import com.flockspring.domain.types.Affiliation;
import com.flockspring.domain.types.Category;
import com.flockspring.domain.types.Leader;
import com.flockspring.domain.types.Organization;
import com.flockspring.domain.types.Programs;
import com.flockspring.domain.types.ServiceDay;
import com.flockspring.domain.types.ServiceDetails;
import com.flockspring.domain.types.TimeAndDay;
import com.flockspring.domain.types.impl.ApplicationUserImpl;
import com.flockspring.domain.types.impl.Atmosphere;
import com.flockspring.ui.model.AddressUIModel;
import com.flockspring.ui.model.LanguageUIModel;
import com.flockspring.ui.model.LeaderUIModel;
import com.flockspring.ui.model.MultimediaUIModel;
import com.flockspring.ui.model.OrganizationOverviewUIModel;
import com.flockspring.ui.model.OrganizationStatementUIModel;
import com.flockspring.ui.model.OrganizationUIModel;
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
    private static final String SPECIFIC_TIME_FORMAT = "h:mm a";
    private static final String HOUR_TIME_FORMAT = "h a";
    private final AddressUIModelMapper addressUIModelMapper;
    private final MultimediaUIModelMapper multimediaUIModelMapper;
    private final LeaderUIModelMapper leaderUIModelMapper;
    private final SocialMediaUIModelMapper socialMediaUIModelMapper;
    private final MessageSource messageSource;

    @Autowired
    public OrganizationUIModelMapper(AddressUIModelMapper addressUIModelMapper, MultimediaUIModelMapper multimediaUIModelMapper,
            LeaderUIModelMapper leaderUIModelMapper, SocialMediaUIModelMapper socialMediaUIModelMapper, MessageSource messageSource)
    {
        this.addressUIModelMapper = addressUIModelMapper;
        this.multimediaUIModelMapper = multimediaUIModelMapper;
        this.leaderUIModelMapper = leaderUIModelMapper;
        this.socialMediaUIModelMapper = socialMediaUIModelMapper;
        this.messageSource = messageSource;
    }

   public OrganizationUIModel map(Organization organization, double distance, Locale locale, ApplicationUserImpl user)
    {
        if (organization == null)
        {
            return null;
        }
        
        boolean userFavorited = false;
        if(user != null)
        {
            userFavorited = user.getFavoriteChurches() != null && user.getFavoriteChurches().contains(organization.getId());
        }

        Set<LeaderUIModel> leadershipTeam = leaderUIModelMapper.map(organization.getLeadershipTeam());
        Set<MultimediaUIModel> multimedia = multimediaUIModelMapper.map(organization.getMultimedia());
        Set<LanguageUIModel> languages = getLanguages(); 
        OrganizationOverviewUIModel overview = getOrganizationOverviewUIModel(organization, distance, locale, userFavorited);

        OrganizationStatementUIModel statements = new OrganizationStatementUIModel(organization.getMissionStatement(),
                organization.getStatementOfFaith(), organization.getWelcomeMessage());

        ServiceOverviewUIModel servicesOverview = new ServiceOverviewUIModel(getServiceDuration(organization.getAtmosphere()), languages,
                organization.getExtraServiceDetails());

        Set<ServiceDetailUIModel> serviceDetails = getServiceDetails(organization, locale);
        CategoryUIMapConverter<Programs> programConverter = new CategoryUIMapConverter<>();
        Map<Category<Programs>, Set<Programs>> programsOffered = programConverter.convertCategoryToMap(organization.getProgramsOffered());

        Map<String, List<String>> serviceTimeDays = getServiceTimeDays(organization);
        
        OrganizationUIModel model = new OrganizationUIModel(organization.getId(), overview, multimedia, leadershipTeam, statements, servicesOverview,
                serviceDetails, programsOffered, serviceTimeDays );

        return model;
    }

    private Map<String, List<String>> getServiceTimeDays(Organization organization)
    {
        Set<ServiceDetails> serviceDetails = organization.getAtmosphere().getServiceDetails();
        Map<String, List<String>> serviceDaysAndTimes = new HashMap<>(); 
        for(ServiceDetails sd : serviceDetails)
        {
            TimeAndDay td = sd.getTimeAndDay();
            if(td != null && td.getServiceDay() != null)
            {
                LocalDateTime time = td.getStartTime();
                
                String format = SPECIFIC_TIME_FORMAT;
                if(time.getMinuteOfHour() == 0)
                {
                    format = HOUR_TIME_FORMAT;
                }
                
                DateTimeFormatter fmt = DateTimeFormat.forPattern(format);
                String formattedServiceTime = time.toString(fmt);                
                
                if(!serviceDaysAndTimes.containsKey(td.getServiceDay().getLocalizedStringCode()))
                {
                    List<String> times = new ArrayList<>(5);
                    times.add(formattedServiceTime);
                    serviceDaysAndTimes.put(td.getServiceDay().getLocalizedStringCode(), times);
                }
                else
                {
                    serviceDaysAndTimes.get(td.getServiceDay().getLocalizedStringCode()).add(formattedServiceTime);
                }
            }
        }
        
        return serviceDaysAndTimes;
    }

    private Set<LanguageUIModel> getLanguages()
    {
        
        return null;
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

    private Set<ServiceDetailUIModel> getServiceDetails(Organization organization, Locale locale)
    {
        Set<ServiceDetailUIModel> serviceDetails = new TreeSet<>();
        int x = 1;
        for (ServiceDetails sd : organization.getAtmosphere().getServiceDetails())
        {
            String serviceName = sd.getServiceName();
            TimeAndDay timeAndDay = sd.getTimeAndDay();
            
            if(!StringUtils.hasText(serviceName))
            {
                StringBuilder sb = new StringBuilder();
                
                
                if(timeAndDay != null)
                {
                    if(timeAndDay.getServiceDay() != null)
                    {
                        String code = sd.getTimeAndDay().getServiceDay().getLocalizedStringCode();
                        sb.append(messageSource.getMessage(code, null, locale)).append(" "); 
                    }
                    
                    if(timeAndDay.getStartTime() != null)
                    {
                        
                        LocalDateTime startTime = timeAndDay.getStartTime();
                        int startMinute = startTime.getMinuteOfHour();
                        
                        String format = SPECIFIC_TIME_FORMAT;
                        if(startMinute == 0)
                        {
                            format = HOUR_TIME_FORMAT;
                        }
                        
                        DateTimeFormatter fmt = DateTimeFormat.forPattern(format);
                        sb.append(startTime.toString(fmt));
                    }
                }
                else
                {
                    sb.append(x);
                    switch(x)
                    {
                        case 1: sb.append("<sup>st</sup>");
                            break;
                        
                        case 2: sb.append("<sup>nd</sup>");
                            break;
                        
                        case 3: sb.append("<sup>rd</sup>");
                            break;
                        
                        default: sb.append("<sup>th</sup>");
                    }
                }
                
                sb.append(" Service");
                serviceName = sb.toString();
                
                x++;
            }
            
            
            ServiceDetailUIModel sdUIM = new ServiceDetailUIModel(serviceName, sd.getInstruments(), sd.getMusicStyle(), 
                    sd.getServiceStyle(), sd.getAgeDemongraphics(), sd.getDressAttire(), timeAndDay.getServiceDay(), 
                    timeAndDay.getStartTime());
            
            serviceDetails.add(sdUIM);            
        }
        
        return serviceDetails;
    }

    private OrganizationOverviewUIModel getOrganizationOverviewUIModel(Organization organization, double distance, Locale locale, boolean isFavorite)
    {
        Atmosphere atmosphere = organization.getAtmosphere();
        AddressUIModel address = addressUIModelMapper.map(organization.getAddress());
        SocialMediaUIModel socialMedia = socialMediaUIModelMapper.map(organization.getSocialMedia());
        Set<Leader> leaders = organization.getLeadershipTeam();

        Leader leadPastor = getLeadPastor(organization.getLeadershipTeam());

        // TODO: jbritain we want to display twillio number here, not the church number.
        String phoneNumber = getPhoneNumber(leaders, locale);
        List<String> serviceTimeShortStrings = getServiceTimeShortStringCodes(atmosphere, locale);
        String subDenominationLocalizationCode = "";
        
        if (organization.getSubDenomination() != Affiliation.NONE && organization.getSubDenomination() != null)
        {
            subDenominationLocalizationCode = organization.getSubDenomination().getLocalizedStringCode();
        }        

        String pastorName = leadPastor.getName();
                
        return new OrganizationOverviewUIModel(organization.getName(), organization.getDenomination().getLocalizedStringCode(),
                subDenominationLocalizationCode, organization.getYearFounded(), pastorName, atmosphere.getCongregationSize(), phoneNumber,
                organization.getSocialMedia().getWebsiteUrl(), serviceTimeShortStrings.get(0), serviceTimeShortStrings.get(1), isFavorite, 
                socialMedia, address, distance, getParkingLotInfo(organization.getAccessibilitySupport()));
    }

    private String getPhoneNumber(Set<Leader> leaders, Locale locale)
    {
        for(Leader l : leaders)
        {
            if(l.isPrimaryContact())
            {
                return l.getPhoneNumber(); 
            }
        }
        
        return messageSource.getMessage("phone.number.not.provided", null, locale);
    }

    private List<String> getServiceTimeShortStringCodes(Atmosphere atmosphere, Locale locale)
    {
        NavigableSet<ServiceDay> serviceDays = new TreeSet<>();
        List<LocalDateTime> times = new ArrayList<>();
        
        for(ServiceDetails sd : atmosphere.getServiceDetails())
        {
            TimeAndDay td = sd.getTimeAndDay();
            
            if(td != null)
            {
                serviceDays.add(td.getServiceDay());
                times.add(td.getStartTime());
            }
        }
        
        String daysString = "";
        if(serviceDays.size() == 1)
        {
            ServiceDay sd = serviceDays.first();
            daysString = messageSource.getMessage(sd.getLocalizedStringCode(), null, locale);            
        }
        else
        {
            StringBuilder sb = new StringBuilder();
            for(Iterator<ServiceDay> i = serviceDays.iterator(); i.hasNext(); )
            {
                
                ServiceDay sd = i.next();
                if(!sd.equals(serviceDays.first()))
                {
                    if(i.hasNext())
                    {
                        sb.append(", ");
                    }
                    else
                    {
                        sb.append(" ");
                        sb.append(messageSource.getMessage("service.time.short.and", null, locale));
                        sb.append(" ");
                    }
                }

                sb.append(messageSource.getMessage(sd.getLocalizedStringCode(), null, locale));
            }
            
            daysString = sb.toString();
        }
        
        StringBuilder shortTimeDayString = new StringBuilder();
        if(times.size() == 1)
        {
            shortTimeDayString.append(messageSource.getMessage("service.time.short", new String[]{daysString}, locale));                
        }
        else
        {
            shortTimeDayString.append(messageSource.getMessage("service.times.short", new String[]{daysString}, locale));
        }
        
        List<String> shortTimeStrings = new ArrayList<>(2);
        shortTimeStrings.add(shortTimeDayString.toString());
        
        StringBuilder shortTimeTimeString = new StringBuilder();
        if(times.size() < 3 && serviceDays.size() == 1)
        {
            for(Iterator<LocalDateTime> t = times.iterator(); t.hasNext(); )
            {
                LocalDateTime dt = t.next();
                String format = HOUR_TIME_FORMAT;
                if(dt.getMinuteOfHour() != 0)
                {
                    format = SPECIFIC_TIME_FORMAT;
                }
                
                DateTimeFormatter fmt = DateTimeFormat.forPattern(format);
                shortTimeTimeString.append(dt.toString(fmt));   
                
                if(t.hasNext())
                {
                    shortTimeTimeString.append(",");
                }
            }
        }
        else
        {
            shortTimeTimeString.append(messageSource.getMessage("service.time.see.below.for.details", null, locale));
        }
        
        shortTimeStrings.add(shortTimeTimeString.toString());
        
        return shortTimeStrings; 
    }

    private boolean getParkingLotInfo(Set<AccessibilitySupport> accessibilitySupports)
    {
        return accessibilitySupports != null && (accessibilitySupports.contains(AccessibilitySupport.PARKING_GARAGE)
                || accessibilitySupports.contains(AccessibilitySupport.PARKING_LOT));
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
