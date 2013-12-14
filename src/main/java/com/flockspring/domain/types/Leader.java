/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import com.flockspring.domain.types.impl.LeaderRole;


/**
 * Leader.java
 * 
 * @author Justen L. Britain
 * @date Jun 12, 2013
 * 
 */
public interface Leader
{

    String getName();

    String getBio();

    String getTitle();

    Image getImage();

    boolean isPrimaryLeader();

    boolean isPrimaryContact();

    long getId();

    LeaderRole getLeaderRole();

    int getYearStarted();

    String getPhoneNumber();

    String getEmailAddress();
}
