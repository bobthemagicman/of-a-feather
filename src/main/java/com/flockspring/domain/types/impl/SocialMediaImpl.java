/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

/**
 * SocialMediaImpl.java
 *
 * @author Justen L. Britain
 * @date Dec 8, 2013
 *
 */
public class SocialMediaImpl implements SocialMedia
{

    private String websiteUrl;
    private String blogUrl;
    private String googlePlusUrl;
    private String youtubeUrl;
    private String podcastUrl;
    private String facebookUrl;
    private String twitterUrl;
    private String otherUrl;
   
    @Override
    public String getWebsiteUrl()
    {
        return websiteUrl;
    }
    
    @Override
    public String getBlogUrl()
    {
        return blogUrl;
    }
    
    @Override
    public String getGooglePlusUrl()
    {
        return googlePlusUrl;
    }
    
    @Override
    public String getYoutubeUrl()
    {
        return youtubeUrl;
    }
    
    @Override
    public String getPodcastUrl()
    {
        return podcastUrl;
    }
    
    @Override
    public String getFacebookUrl()
    {
        return facebookUrl;
    }
    
    @Override
    public String getTwitterUrl()
    {
        return twitterUrl;
    }
    
    @Override
    public String getOtherUrl()
    {
        return otherUrl;
    }
    
    public void setWebsiteUrl(String websiteUrl)
    {
        this.websiteUrl = websiteUrl;
    }
    
    public void setBlogUrl(String blogUrl)
    {
        this.blogUrl = blogUrl;
    }
    
    public void setGooglePlusUrl(String googlePlusUrl)
    {
        this.googlePlusUrl = googlePlusUrl;
    }
    
    public void setYoutubeUrl(String youtubeUrl)
    {
        this.youtubeUrl = youtubeUrl;
    }
    
    public void setPodcastUrl(String podcastUrl)
    {
        this.podcastUrl = podcastUrl;
    }
    
    public void setFacebookUrl(String facebookUrl)
    {
        this.facebookUrl = facebookUrl;
    }
    
    public void setTwitterUrl(String twitterUrl)
    {
        this.twitterUrl = twitterUrl;
    }
    
    public void setOtherUrl(String otherUrl)
    {
        this.otherUrl = otherUrl;
    }
}
