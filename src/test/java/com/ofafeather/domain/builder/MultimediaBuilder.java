/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.ofafeather.domain.builder;

import com.ofafeather.domain.types.impl.MultimediaObjectImpl;

/**
 * MultimediaBuilder.java
 *
 * @author Justen L. Britain
 * @date Jul 6, 2014
 *
 */
public class MultimediaBuilder
{

    private String name;
    private String path;
    private String altText;
    private String titleText;
    private boolean primary;
    private boolean video;

    public MultimediaBuilder()
    {
        name = "Unit Test Multimedia Object";
        path = "/unit/test/multimedia/path.png";
        altText = "Alt Text: Lorum Ipsum";
        titleText = "Title Text: Lorum Ipsum";
        primary = false;
        video = false;
    }
    
    public MultimediaBuilder withName(String name)
    {
        this.name = name;
        return this;
    }
    
    public MultimediaBuilder withPath(String path)
    {
        this.path = path;
        return this;
    }
    
    public MultimediaBuilder withAltText(String altText)
    {
        this.altText = altText;
        return this;
    }
    
    public MultimediaBuilder withTitle(String title)
    {
        this.titleText = title;
        return this;
    }
    
    public MultimediaBuilder asPrimary()
    {
        this.primary = true;
        return this;
    }
    
    public MultimediaBuilder asVideo()
    {
        this.video = true;
        return this;
    }
    
    public MultimediaObjectImpl build()
    {
        return new MultimediaObjectImpl(name, path, altText, titleText, primary, video);
    }
}
