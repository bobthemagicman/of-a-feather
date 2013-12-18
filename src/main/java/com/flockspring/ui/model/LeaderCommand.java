/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import com.flockspring.domain.types.impl.LeaderRole;

/**
 * LeaderCommand.java
 *
 * @author Justen L. Britain
 * @date Dec 15, 2013
 *
 */
public class LeaderCommand
{

    private String name;
    private String bio;
    private String title;
    private LeaderRole role;
    private ImageCommand image;
    private boolean primaryContact;
    private boolean primaryLeader;
    private String emailAddress;
    private String phoneNumber;
    private int yearStarted;

    public String getName()
    {
        
        return this.name;
    }

    public String getBio()
    {
        
        return this.bio;
    }

    public String getTitle()
    {
        
        return this.title;
    }

    public LeaderRole getRole()
    {
        
        return this.role;
    }

    public ImageCommand getImage()
    {
        
        return this.image;
    }

    public boolean isPrimaryContact()
    {
        
        return this.primaryContact;
    }

    public boolean isPrimaryLeader()
    {
        
        return this.primaryLeader;
    }

    public String getEmailAddress()
    {
        
        return this.emailAddress;
    }

    public String getPhoneNumber()
    {
        
        return this.phoneNumber;
    }

    public int getYearStarted()
    {
        
        return this.yearStarted;
    }
}
