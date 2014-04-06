/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flockspring.dataaccess.mongodb.model.UserModel;

/**
 * UserRepository.java
 *
 * @author Justen L. Britain
 * @date Jan 18, 2014
 *
 */
public interface UserRepository extends MongoRepository<UserModel, String>
{
    UserModel findByEmail(String email);
    
    UserModel findById(String id);
}
