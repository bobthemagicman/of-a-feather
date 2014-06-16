/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui;

import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * IdentifiedPage.java
 *
 * @author Justen L. Britain
 * @date Jun 7, 2014
 *
 */
public abstract class IdentifiedPage
{
    public static final String PAGE_ID_MAP_KEY = "pageId";
    
    @ModelAttribute(PAGE_ID_MAP_KEY)
    protected abstract String getPageId();
}
