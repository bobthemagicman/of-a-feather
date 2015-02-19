/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.mapper;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.flockspring.domain.types.impl.SocialMedia;
import com.flockspring.ui.model.SocialMediaUIModel;

/**
 * SocialMediaUIModelMapper.java
 *
 * @author Justen L. Britain
 * @date Dec 16, 2013
 *
 */
@Component
public class SocialMediaUIModelMapper
{

    public SocialMediaUIModel map(SocialMedia socialMedia)
    {
        
        return new SocialMediaUIModel(socialMedia.getFacebookUrl(), socialMedia.getTwitterUrl(),
                socialMedia.getInstagramUrl(), socialMedia.getYoutubeUrl(), socialMedia.getGooglePlusUrl());
    }

}
