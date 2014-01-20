/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flockspring.domain.service.impl.UserImpl;

/**
 * UserRepository.java
 *
 * @author Justen L. Britain
 * @date Jan 18, 2014
 *
 */
public interface UserRepository extends MongoRepository<UserImpl, String>
{

}
