/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

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
    
    @SafeVarargs
    protected final void addBreadcrumbHeiarchyToModel(ModelAndView mav, ImmutablePair<String, Boolean>...breadCrumbs)
    {
		NavigableSet<ImmutablePair<String, Boolean>> breadCrumbHeiarchy = new TreeSet<ImmutablePair<String,Boolean>>();
		breadCrumbHeiarchy.add(getPair("breadcrumb.home", true));
		breadCrumbHeiarchy.addAll(Arrays.asList(breadCrumbs));
    }
    
    protected ImmutablePair<String, Boolean> getPair(final String param, final boolean isLocCode)
    {
	   return new ImmutablePair<String, Boolean>(param, isLocCode);
    }
}
