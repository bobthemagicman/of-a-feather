/**
 *
 *   Copyright 2015 Justen L. Britain
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 **/
package com.ofafeather.domain.types.impl;

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
    private String instagramUrl;
   
    public SocialMediaImpl()
    {
        super();
    }
            
    public SocialMediaImpl(String websiteUrl, String blogUrl, String googlePlusUrl, String youtubeUrl, String podcastUrl, String facebookUrl,
            String twitterUrl, String otherUrl, String instagramUrl)
    {
        super();
        
        this.websiteUrl = websiteUrl;
        this.blogUrl = blogUrl;
        this.googlePlusUrl = googlePlusUrl;
        this.youtubeUrl = youtubeUrl;
        this.podcastUrl = podcastUrl;
        this.facebookUrl = facebookUrl;
        this.twitterUrl = twitterUrl;
        this.otherUrl = otherUrl;
        this.instagramUrl = instagramUrl;
    }

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
    
    @Override
    public String getInstagramUrl()
    {
        return instagramUrl;
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

    public void setInstagramUrl(String instagramUrl)
    {
        this.instagramUrl = instagramUrl;
    }
}
