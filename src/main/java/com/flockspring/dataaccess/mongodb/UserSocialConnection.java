/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.mongodb;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * UserSocialConnection.java
 *
 * @author Justen L. Britain
 * @date Mar 8, 2014
 *
 */

@Document(collection = "userSocialConnection")
public class UserSocialConnection {
    
    private String userId;
    private String providerId;
    private String providerUserId;
    private String displayName;
    private String profileUrl;
    private String imageUrl;
    private String accessToken;
    private String secret;
    private String refreshToken;
    private Long expireTime;

    public UserSocialConnection() {
        super();
    }

    public UserSocialConnection(String userId, String providerId, String providerUserId, int rank,
            String displayName, String profileUrl, String imageUrl, String accessToken, String secret,
            String refreshToken, Long expireTime) {
        
        super();
        
        this.userId = userId;
        this.providerId = providerId;
        this.providerUserId = providerUserId;
        this.displayName = displayName;
        this.profileUrl = profileUrl;
        this.imageUrl = imageUrl;
        this.accessToken = accessToken;
        this.secret = secret;
        this.refreshToken = refreshToken;
        this.expireTime = expireTime;
    }

    public String getUserId()
    {
        return userId;
    }

    public String getProviderId()
    {
        return providerId;
    }

    public String getProviderUserId()
    {
        return providerUserId;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getProfileUrl()
    {
        return profileUrl;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public String getAccessToken()
    {
        return accessToken;
    }

    public String getSecret()
    {
        return secret;
    }

    public String getRefreshToken()
    {
        return refreshToken;
    }

    public Long getExpireTime()
    {
        return expireTime;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public void setProviderId(String providerId)
    {
        this.providerId = providerId;
    }

    public void setProviderUserId(String providerUserId)
    {
        this.providerUserId = providerUserId;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    public void setProfileUrl(String profileUrl)
    {
        this.profileUrl = profileUrl;
    }

    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public void setAccessToken(String accessToken)
    {
        this.accessToken = accessToken;
    }

    public void setSecret(String secret)
    {
        this.secret = secret;
    }

    public void setRefreshToken(String refreshToken)
    {
        this.refreshToken = refreshToken;
    }

    public void setExpireTime(Long expireTime)
    {
        this.expireTime = expireTime;
    }
}

