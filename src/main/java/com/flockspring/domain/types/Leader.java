/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import java.io.Serializable;

import com.flockspring.domain.types.impl.OrganizationImpl;

/**
 * Leader.java
 * 
 * @author Justen L. Britain
 * @date Jun 12, 2013
 * 
 */
public interface Leader extends Serializable
{

    String getName();

    String getBio();

    String getTitle();

    Image getImage();

    boolean isPrimaryLeader();

    boolean isPrimaryContact();

    long getId();

    OrganizationImpl getOrganization();
}
