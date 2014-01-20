/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.mongodb;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flockspring.domain.types.impl.UpdateEmailImpl;

/**
 * UserRepository.java
 *
 * @author Justen L. Britain
 * @date Jan 18, 2014
 *
 */
public interface EmailUpdateRepository extends MongoRepository<UpdateEmailImpl, String>
{
    UpdateEmailImpl findOneByEmailAddress(String emailAddress);
    List<UpdateEmailImpl> findByUserSearchCity(String city);
    List<UpdateEmailImpl> findBySearchDateBetween(Date startDate, Date toDate);
}
