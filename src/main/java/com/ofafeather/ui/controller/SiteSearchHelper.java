/**
 *
 *   Copyright 2015 Justen L. Britain
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 **/
package com.ofafeather.ui.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;

import com.google.common.base.Strings;
import com.ofafeather.domain.OrganizationFilter;

/**
 * SiteSearchHelper.java
 * 
 * @author Justen L. Britain
 * @date Jan 10, 2014
 * 
 */
public final class SiteSearchHelper
{

    private static final String ORG_FILTER = "com.ofafeather.organization.filters";
    private static final String USER_KEY = "com.ofafeather.ui.session.user.key";
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
