/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flockspring.domain.types.impl.OrganizationImpl;

public interface OrganizationRepository extends JpaRepository<OrganizationImpl, Long>
{

    
}
