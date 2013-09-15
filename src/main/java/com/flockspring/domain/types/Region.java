/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import java.util.List;


/**
 * Region.java
 *
 * @author Justen L. Britain
 * @date Jun 16, 2013
 *
 */
public interface Region extends GlobalRegion<Region>
{
    List<Organization> getOrganizations();
    
    Region getParentRegion();
}
