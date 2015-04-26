/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui;

import org.junit.Test;

/**
 * IdentifiedPageTests.java
 *
 * @author Justen L. Britain
 * @date Jul 5, 2014
 *
 */
public abstract class IdentifiedPageTests
{
    public static final String PAGE_ID_MAP_KEY = IdentifiedPage.PAGE_ID_MAP_KEY;
    
    @Test
    public abstract void testPageIsIdentified() throws Exception;
}
