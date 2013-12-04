/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AutoPopulatingList;
import org.springframework.webflow.execution.RequestContext;
import org.springframework.webflow.execution.RequestContextHolder;

import com.flockspring.domain.types.AccessabilitySupport;
import com.flockspring.domain.types.Affiliation;
import com.flockspring.domain.types.DressAttire;
import com.flockspring.domain.types.Language;
import com.flockspring.domain.types.MusicStyle;
import com.flockspring.domain.types.Region;
import com.flockspring.domain.types.ServiceDay;
import com.flockspring.domain.types.ServiceStyle;
import com.flockspring.domain.types.impl.AddressImpl;
import com.flockspring.domain.types.impl.ImageImpl;
import com.flockspring.domain.types.impl.LeaderImpl;
import com.flockspring.domain.types.impl.OrganizationImpl;
import com.flockspring.ui.model.CongregationSize;
import com.flockspring.ui.model.Programs;
import com.flockspring.ui.model.ServiceTime;
import com.google.common.collect.Sets;

/**
 * CommonFormReferenceDataProvider.java
 * 
 * @author Justen L. Britain
 * @date Nov 27, 2013
 * 
 */
@Component
public class CommonFormReferenceDataProvider
{
    private final OrganizationDiscoveryService organizationDiscoveryService;

    @Autowired
    public CommonFormReferenceDataProvider(final OrganizationDiscoveryService organizationDiscoveryService)
    {
        this.organizationDiscoveryService = organizationDiscoveryService;
    }

    public void save()
    {
        
        
//        ImageImpl image1 = new ImageImpl("Image 1", "/test-church/1.jpg", "", "", "", 0, 0, true);
//        ImageImpl image2 = new ImageImpl("Image 2", "/test-church/2.jpg", "", "", "", 0, 0, false);
//        ImageImpl image3 = new ImageImpl("Image 3", "/test-church/3.jpg", "", "", "", 0, 0, false);
//        Set<ImageImpl> images = Sets.newTreeSet(Arrays.asList(image1, image2, image3));
//        
//        LeaderImpl leader1 = new LeaderImpl();
//        LeaderImpl leader2 = new LeaderImpl();
//        AutoPopulatingList<LeaderImpl> leadershipTeam = Arrays.asList(leader1, leader2);
//        
//        AddressImpl address = new AddressImpl("1234 faith St W", "", "98036", "Wa", "Kenmore", "United States", null);
//        Set<ServiceTime> serviceTimes = Sets.newTreeSet(Arrays.asList(ServiceTime.EARLY_MORNING, ServiceTime.MID_MORNING));
//        Set<ServiceDay> serviceDays = Sets.newTreeSet(Arrays.asList(ServiceDay.SUNDAY));
//        Set<Language> languages = Sets.newTreeSet(Arrays.asList(Language.SPANISH, Language.ENGLISH));
//        Set<Programs> programmsOffered = Sets.newTreeSet(Arrays.asList(Programs.ADDICTION_RECOVERY_COUNSELING, Programs.BIBLE_STUDY, Programs.TODDLER_CARE, Programs.INFANT_CARE, Programs.YOUNG_ADULT_GROUP));
//        Set<AccessabilitySupport> accessibilitySupport = Sets.newTreeSet(Arrays.asList(AccessabilitySupport.PARKING_LOT, AccessabilitySupport.WHEEL_CHAIR_ACCESS));
//        
//        OrganizationImpl organization = new OrganizationImpl(null, 1999, false, "Test Church 1", "Thsi is the mission test statement", 
//                "This is the statement of faith", "", "http://www.test.org", "http://www.facebook.com/test", "http://www.twitter.com/test", 
//                CongregationSize.LARGE, address, null, MusicStyle.CONTEMPORARY_3, ServiceStyle.CONSERVATIVE_3, DressAttire.CASUAL_1, 
//                Affiliation.NONDENOMINATIONAL, null, null, images, leadershipTeam, serviceTimes, serviceDays, languages, programmsOffered, 
//                accessibilitySupport, 0);
//        organizationDiscoveryService.saveOrganization(organization);
    }

    public List<Region> getStatesForLocale()
    {
        RequestContext context = RequestContextHolder.getRequestContext();
        Locale locale = context.getExternalContext().getLocale();

        return null;
    }

    public List<Affiliation> getDenominations()
    {
        return Arrays.asList(Affiliation.values());
    }

    public List<ServiceTime> getServiceTimes()
    {
        return Arrays.asList(ServiceTime.values());
    }

    public List<ServiceDay> getServiceDays()
    {
        return Arrays.asList(ServiceDay.values());
    }
}
