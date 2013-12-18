/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

/**
 * ImageCommand.java
 *
 * @author Justen L. Britain
 * @date Dec 15, 2013
 *
 */
public class ImageCommand
{

    private String name;
    private String path;
    private String altText;
    private String titleText;
    private boolean primary;

    public String getName()
    {
        
        return this.name;
    }

    public String getPath()
    {
        
        return this.path;
    }

    public String getAltText()
    {
        
        return this.altText;
    }

    public String getTitleText()
    {
        
        return this.titleText;
    }

    public boolean isPrimary()
    {
        
        return this.primary;
    }

}
