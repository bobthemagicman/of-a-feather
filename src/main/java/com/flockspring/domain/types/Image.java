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
public interface Image
{

    /**
     * @return
     */
    String getAltText();

    /**
     * @return
     */
    String getTitleText();

    /**
     * @return
     */
    String getExtension();

    /**
     * @return
     */
    int getWidth();

    /**
     * @return
     */
    int getHeight();

    /**
     * @return
     */
    String getPath();

    /**
     * @return
     */
    String getName();

    /**
     * @return
     */
    boolean isPrimary();
}