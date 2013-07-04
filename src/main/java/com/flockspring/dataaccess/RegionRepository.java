/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flockspring.domain.types.Region;
import com.flockspring.domain.types.impl.OrganizationImpl;
import com.flockspring.domain.types.impl.RegionImpl;

public interface RegionRepository extends JpaRepository<RegionImpl, Long>
{

    @Query("SELECT region FROM RegionImpl region WHERE :organization MEMBER OF region.organizations") 
    Region findByOrganizationInRegionOrganizations(@Param("organization") OrganizationImpl organizationId);
}
