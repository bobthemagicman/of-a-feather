/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.mongodb;

import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * UserSocialConnectionRepository.java
 *
 * @author Justen L. Britain
 * @date Mar 8, 2014
 *
 */
public interface UserSocialConnectionRepository extends MongoRepository<UserSocialConnection, String>
{
    List<UserSocialConnection> findByUserId(String userId);

    List<UserSocialConnection> findByUserIdAndProviderId(String userId, String providerId);

    List<UserSocialConnection> findByProviderIdAndProviderUserId(String providerId, String providerUserId);

    UserSocialConnection findByUserIdAndProviderIdAndProviderUserId(String userId, String providerId, String providerUserId);

    List<UserSocialConnection> findByProviderIdAndProviderUserIdIn(String providerId, Collection<String> providerUserIds);
}
