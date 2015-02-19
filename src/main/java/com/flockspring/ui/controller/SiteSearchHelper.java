/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;

import com.flockspring.domain.OrganizationFilter;
import com.google.common.base.Strings;

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
    private static final String USER_KEY = "com.flockspring.ui.session.user.key";
    private static final String SEARCH_PARAM_NAME = "search-bar";

    private final HttpSession session;

    public SiteSearchHelper(HttpSession session)
    {
        this.session = session;
    }

    public OrganizationFilter getOrganizationFilterFromSession()
    {
        OrganizationFilter filter = null;
        Object filterObj = session.getAttribute(ORG_FILTER);
        if(filterObj != null && filterObj instanceof OrganizationFilter)
        {
             filter = (OrganizationFilter) filterObj;
        }
        
        return filter == null ? new OrganizationFilter() : filter;
    }

    public void setOrganizationFilter(OrganizationFilter organizationFilter)
    {
        session.setAttribute(ORG_FILTER, organizationFilter);
    }

    public boolean hasPreviousSearch()
    {
        return !StringUtils.isEmpty(getOrganizationFilterFromSession().getUserQuery());
    }

    public String getSearchQuery()
    {
        OrganizationFilter filter = getOrganizationFilterFromSession();
        String query = filter.getUserQuery();
        if(StringUtils.hasText(query))
        {
        	return new StringBuilder("?").append(SEARCH_PARAM_NAME).append("=").append(query).toString();
        }
        
        return "";
    }

    public String createAndSaveUUIDIfNoneExists()
    {
        String uuid = getUUID();
        if(!StringUtils.hasText(uuid))
        {
            uuid = UUID.randomUUID().toString();
        }
                
        session.setAttribute(USER_KEY, uuid);
        
        return uuid;
    }

    public String getUUID()
    {
        String uuid = null;
        Object uuidObj =  session.getAttribute(USER_KEY);
        if(uuidObj != null && uuidObj instanceof String)
        {
            uuid = (String)uuidObj;
        }
        
        return Strings.emptyToNull(uuid);
    }

}
