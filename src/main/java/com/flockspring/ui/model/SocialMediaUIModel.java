/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

/**
 * SocialMediaUIModel.java
 *
 * @author Justen L. Britain
 * @date Dec 15, 2013
 *
 */
public class SocialMediaUIModel implements Comparable<SocialMediaUIModel>
{
    public final String facebookUrl;
    public final String twitterUrl;
    public final String instagramUrl;
    public final String youtubeUrl;
    public final String googlePlusUrl;
    
    public SocialMediaUIModel(String facebookUrl, String twitterUrl, String instagramUrl, String youtubeUrl, String googlePlusUrl)
    {
        super();
        
        this.facebookUrl = facebookUrl;
        this.twitterUrl = twitterUrl;
        this.instagramUrl = instagramUrl;
        this.youtubeUrl = youtubeUrl;
        this.googlePlusUrl = googlePlusUrl;
    }

    public String getFacebookUrl()
    {
        return facebookUrl;
    }

    public String getTwitterUrl()
    {
        return twitterUrl;
    }

    public String getInstagramUrl()
    {
        return instagramUrl;
    }

    public String getYoutubeUrl()
    {
        return youtubeUrl;
    }

    public String getGooglePlusUrl()
    {
        return googlePlusUrl;
    }

    @Override
    public int compareTo(SocialMediaUIModel right)
    {
        SocialMediaUIModel left = this;
        return ComparisonChain.start()
                .compare(left.getFacebookUrl(), right.getFacebookUrl(), Ordering.natural().nullsLast())
                .compare(left.getTwitterUrl(), right.getTwitterUrl(), Ordering.natural().nullsLast())
                .compare(left.getInstagramUrl(), right.getInstagramUrl(), Ordering.natural().nullsLast())
                .compare(left.getYoutubeUrl(), right.getYoutubeUrl(), Ordering.natural().nullsLast())
                .compare(left.getGooglePlusUrl(), right.getGooglePlusUrl(), Ordering.natural().nullsLast())
                .result();
    }
}