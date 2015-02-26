/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.ofafeather.domain.builder;

import java.util.Arrays;

import com.google.common.collect.Sets;
import com.ofafeather.domain.types.AccessibilitySupport;
import com.ofafeather.domain.types.Affiliation;
import com.ofafeather.domain.types.Programs;
import com.ofafeather.domain.types.impl.OrganizationImpl;


/**
 * OrganizationBuilder.java
 *
 * @author Justen L. Britain
 * @date Jul 6, 2014
 *
 */
public class TestOrganization extends OrganizationImpl.OrganizationBuilder
{
    public TestOrganization()
    {
        super.id = "123456";
        super.yearFounded = 1999;
        super.name = "Unit Test Church";
        super.missionStatement = "Mission Statement: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum in pellentesque nunc, vitae posuere ante. Fusce ac velit libero. Etiam tristique porta neque sit amet rutrum.";
        super.statementOfFaith = "Statement of Faith: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum in pellentesque nunc, vitae posuere ante. Fusce ac velit libero. Etiam tristique porta neque sit amet rutrum.";
        super.welcomeMessage = "Welcome Message: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum in pellentesque nunc, vitae posuere ante. Fusce ac velit libero. Etiam tristique porta neque sit amet rutrum.";
        super.address = new TestAddress().build();
        super.atmosphere = new AtmosphereBuilder().build();
        super.socialMedia = new SocialMedialBuilder().build();
        super.denomination = Affiliation.NONDENOMINATIONAL;
        super.subDenomination = Affiliation.NONE;
        super.primaryAffiliation = null;
        super.multimedia = Sets.newTreeSet(Arrays.asList(new MultimediaBuilder().build()));
        super.leadershipTeam = Sets.newTreeSet(Arrays.asList(new LeadershipTeamBuilder().build()));
        super.programsOffered = Sets.newTreeSet(Arrays.asList(Programs.SUNDAY_SCHOOL, Programs.MIDDLE_SCHOOL_GROUP, Programs.HIGH_SCHOOL_GROUP));
        super.accessibilitySupport = Sets.newTreeSet(Arrays.asList(AccessibilitySupport.WHEELCHAIR_ACCESS, AccessibilitySupport.DEAF_TRANSLATOR));
        super.extraServiceDetails = "Extra Service Details: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum in pellentesque nunc, vitae posuere ante. Fusce ac velit libero. Etiam tristique porta neque sit amet rutrum.";
    }
}
