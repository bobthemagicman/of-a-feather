/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flockspring.domain.types.impl.OrganizationImpl;

public interface OrganizationRepository extends JpaRepository<OrganizationImpl, Long>
{
    @Query("SELECT o FROM OrganizationImpl o WHERE o.name LIKE :organizationName AND o.region.englishName = :regionName")
    OrganizationImpl findByNameAndParentRegion(@Param("organizationName") String organizationName, @Param("regionName") String parentRegion);

    
}
