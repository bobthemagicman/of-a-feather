/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flockspring.domain.types.impl.CommunityImpl;

/**
 * CommunityRepository.java
 *
 * @author Justen L. Britain
 * @date May 27, 2013
 *
 */
public interface CommunityRepository extends JpaRepository<CommunityImpl, Long>
{

    
}
