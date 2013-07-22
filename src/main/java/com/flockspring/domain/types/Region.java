/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import java.util.List;

import com.lehman.technology.group.common.domain.types.GlobalRegion;

/**
 * Region.java
 *
 * @author Justen L. Britain
 * @date Jun 16, 2013
 *
 */
public interface Region extends GlobalRegion
{
    List<Organization> getOrganizations();
    
    Region getParentRegion();
}
