/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.user;

import java.util.Set;

/**
 * User.java
 *
 * @author Justen L. Britain
 * @date Mar 8, 2014
 *
 */
public interface User
{

    UserRole getUserRole();

    String getLastName();

    String getFirstName();

    String getEmail();

    String getId();

    Set<SocialMediaProvider> getSignInProviders();

}
