/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.builder;

import java.util.Arrays;
import java.util.List;

import com.flockspring.domain.types.impl.LeaderImpl;
import com.flockspring.domain.types.impl.LeaderRole;
import com.flockspring.domain.types.impl.MultimediaObjectImpl;

/**
 * LeadershipTeamBuilder.java
 *
 * @author Justen L. Britain
 * @date Jul 6, 2014
 *
 */
public class LeadershipTeamBuilder
{

    private String name;
    private String bio;
    private String title;
    private List<LeaderRole> leaderRoles;
    private MultimediaObjectImpl image;
    private boolean primaryContact;
    private boolean primaryLeader;
    private String emailAddress;
    private String phoneNumber;
    private int yearStarted;

    private boolean leaderRoleListReset = false;
    
    public LeadershipTeamBuilder()
    {
        name = "Unit Test Leader";
        bio = "Bio: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum in pellentesque nunc, vitae posuere ante. Fusce ac velit libero. Etiam tristique porta neque sit amet rutrum.";
        title = "Title: Lorum Ipsum";
        leaderRoles = Arrays.asList(LeaderRole.PASTOR);
        image = new MultimediaBuilder().build();
        primaryContact = false;
        primaryLeader = false;
        emailAddress = "testleader@ofafeather.org";
        phoneNumber = "(555) 555-1212";
    }
    

    
    public LeadershipTeamBuilder withName(String name)
    {
        this.name = name;
        return this;
    }
    
    public LeadershipTeamBuilder withBio(String bio)
    {
        this.bio = bio;
        return this;
    }
    
    public LeadershipTeamBuilder withTitle(String title)
    {
        this.title = title;
        return this;
    }
    
    public LeadershipTeamBuilder withLeaderRoles(List<LeaderRole> leaderRoles)
    {
        this.leaderRoles = leaderRoles;
        return this;
    }
    
    public LeadershipTeamBuilder withImage(MultimediaObjectImpl image)
    {
        this.image = image;
        return this;
    }
    
    public LeadershipTeamBuilder asPrimaryContact()
    {
        this.primaryContact = true;
        return this;
    }
    
    public LeadershipTeamBuilder asPrimaryLeader()
    {
        this.primaryLeader = true;
        return this;
    }
    
    public LeadershipTeamBuilder withEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
        return this;
    }
    
    public LeadershipTeamBuilder withPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
        return this;
    }
    
    public LeadershipTeamBuilder addLeaderRole(LeaderRole leaderRole)
    {
        if(!this.leaderRoleListReset || this.leaderRoles == null)
        {
            this.leaderRoles = Arrays.asList(leaderRole);
            this.leaderRoleListReset = true;
        }
        else
        {
            this.leaderRoles.add(leaderRole);
        }
        
        return this;
    }
    
    public LeaderImpl build()
    {
        return new LeaderImpl(name, bio, title, leaderRoles, image, primaryContact, primaryLeader, emailAddress, phoneNumber, yearStarted);
    }
}
