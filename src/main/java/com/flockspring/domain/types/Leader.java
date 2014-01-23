/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import java.util.NavigableSet;

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

    MultimediaObject getImage();

    boolean isPrimaryLeader();

    boolean isPrimaryContact();

    NavigableSet<LeaderRole> getLeaderRoles();

    int getYearStarted();

    String getPhoneNumber();

    String getEmailAddress();
}
