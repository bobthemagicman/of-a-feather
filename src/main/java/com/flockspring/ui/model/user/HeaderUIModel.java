/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model.user;

/**
 * UserUIModel.java
 *
 * @author Justen L. Britain
 * @date Apr 6, 2014
 *
 */
public class HeaderUIModel
{
    private final String displayName;
    private final String displayImageUrl;
    
    public HeaderUIModel(String displayName, String displayImageUrl)
    {
        super();
        this.displayName = displayName;
        this.displayImageUrl = displayImageUrl;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getDisplayImageUrl()
    {
        return displayImageUrl;
    }
}