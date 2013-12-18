/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types;

/**
 * Image.java
 * 
 * @author Justen L. Britain
 * @date Jun 12, 2013
 * 
 */
public interface MultimediaObject
{

    String getAltText();

    String getTitleText();

    String getPath();

    String getName();

    boolean isPrimary();
    
    boolean isVideo();
}