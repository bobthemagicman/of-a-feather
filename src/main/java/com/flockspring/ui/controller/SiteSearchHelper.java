/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import javax.servlet.http.HttpSession;

import com.flockspring.domain.OrganizationFilter;

/**
 * SiteSearchHelper.java
 * 
 * @author Justen L. Britain
 * @date Jan 10, 2014
 * 
 */
public final class SiteSearchHelper
{

    private static final String ORG_FILTER = "com.flockspring.organization.filters";
    private static final String SEARCH_PARAM_NAME = "search-bar";

    private final HttpSession session;

    public SiteSearchHelper(HttpSession session)
    {
        this.session = session;
    }

    public OrganizationFilter getOrganizationFilterFromSession()
    {
        OrganizationFilter filter = (OrganizationFilter) session.getAttribute(ORG_FILTER);
        
        return filter == null ? new OrganizationFilter() : filter;
    }

    public void setOrganizationFilter(OrganizationFilter organizationFilter)
    {
        session.setAttribute(ORG_FILTER, organizationFilter);
    }

    public Object hasPreviousSearch()
    {
        return getOrganizationFilterFromSession() != null;
    }

    public String getSearchQuery()
    {
        OrganizationFilter filter = getOrganizationFilterFromSession();
        StringBuilder query = new StringBuilder("?").append(SEARCH_PARAM_NAME).append("=").append(filter.getUserQuery());

        return query.toString();
    }

}
