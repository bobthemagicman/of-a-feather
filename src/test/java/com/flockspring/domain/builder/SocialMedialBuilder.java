/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.builder;

import com.flockspring.domain.types.impl.SocialMediaImpl;

/**
 * SocialMedialBuilder.java
 *
 * @author Justen L. Britain
 * @date Jul 6, 2014
 *
 */
public class SocialMedialBuilder
{

    private String websiteUrl;
    private String blogUrl;
    private String googlePlusUrl;
    private String youtubeUrl;
    private String podcastUrl;
    private String facebookUrl;
    private String twitterUrl;
    private String otherUrl;
    private String instagramUrl;

    public SocialMedialBuilder()
    {
        websiteUrl = "http://localhost/websiteUrl";
        blogUrl = "http://localhost/blogUrl";
        googlePlusUrl = "http://localhost/googlePlusUrl";
        youtubeUrl = "http://localhost/youtubeUrl";
        podcastUrl = "http://localhost/podcastUrl";
        facebookUrl = "http://localhost/facebookUrl";
        twitterUrl = "http://localhost/twitterUrl";
        otherUrl = "http://localhost/otherUrl";
        instagramUrl = "http://localhost/instagramUrl";
    }
    
    public SocialMedialBuilder withWebsiteUrl(String websiteUrl)
    {
        this.websiteUrl = websiteUrl;
        return this;
    }
    
    public SocialMedialBuilder withBlogUrl(String blogUrl)
    {
        this.blogUrl = blogUrl;
        return this;
    }
    
    public SocialMedialBuilder withGooglePlusUrl(String googlePlusUrl)
    {
        this.googlePlusUrl = googlePlusUrl;
        return this;
    }
    
    public SocialMedialBuilder withYoutubeUrl(String youtubeUrl)
    {
        this.youtubeUrl = youtubeUrl;
        return this;
    }
    
    public SocialMedialBuilder withPodcastUrl(String podcastUrl)
    {
        this.podcastUrl = podcastUrl;
        return this;
    }
    
    public SocialMedialBuilder withFacebookUrl(String facebookUrl)
    {
        this.facebookUrl = facebookUrl;
        return this;
    }
    
    public SocialMedialBuilder withTwitterUrl(String twitterUrl)
    {
        this.twitterUrl = twitterUrl;
        return this;
    }
    
    public SocialMedialBuilder withOtherUrl(String instagramUrl)
    {
        this.instagramUrl = instagramUrl;
        return this;
    }
    
    public SocialMedialBuilder withInstagramUrl(String websiteUrl)
    {
        this.websiteUrl = websiteUrl;
        return this;
    }
    
    public SocialMediaImpl build()
    {
        return new SocialMediaImpl(websiteUrl, blogUrl, googlePlusUrl, youtubeUrl, podcastUrl, facebookUrl, twitterUrl, otherUrl, instagramUrl);
    }
}
