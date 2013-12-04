/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.types;


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
}
