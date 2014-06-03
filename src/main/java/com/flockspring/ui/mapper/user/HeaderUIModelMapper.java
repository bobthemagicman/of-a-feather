/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.mapper.user;

import java.net.URI;

import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.google.api.userinfo.GoogleUserInfo;
import org.springframework.social.support.URIBuilder;
import org.springframework.social.twitter.api.TwitterProfile;

import com.flockspring.domain.types.impl.ApplicationUserImpl;
import com.flockspring.ui.model.user.HeaderUIModel;

/**
 * UserUIModelMapper.java
 *
 * @author Justen L. Britain
 * @date May 10, 2014
 *
 */
public class HeaderUIModelMapper
{

    private static final String GRAPH_API_URL = "//graph.facebook.com/";

    public HeaderUIModel map(FacebookProfile profile)
    {
        URI imageURI = URIBuilder.fromUri(GRAPH_API_URL + profile.getId() + "/picture?type=square&redirect=false").build();
        HeaderUIModel model = new HeaderUIModel(profile.getFirstName(), imageURI.toString());
        
        return model;
    }
    
    public HeaderUIModel map(TwitterProfile profile)
    {
        return null;
    }
    
    public HeaderUIModel map(GoogleUserInfo profile)
    {
        return null;
    }
    
    public HeaderUIModel map(ApplicationUserImpl user)
    {
        return null;
    }

}
