/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

/**
 * PageNotFoundException.java
 *
 * @author Justen L. Britain
 * @date Jun 29, 2013
 *
 */
public class PageNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = 4161161107167311722L;
    
    public PageNotFoundException(String string)
    {
        super(string);
    }
}
