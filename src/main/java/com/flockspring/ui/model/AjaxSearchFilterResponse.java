/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * DenoiminationFilterResponse.java
 *
 * @author Justen L. Britain
 * @date Oct 20, 2013
 *
 */
public class AjaxSearchFilterResponse
{
    private final String SUCCESS = "";
    private final String ERROR = "";
    private final String NO_RESULTS = "";
    
    private final NavigableSet<String> organizationIds;
    private final NavigableSet<SearchResultUIModel> organizations;
    private final String statusMessage;
    private final String errorMessage;
    
    public AjaxSearchFilterResponse(NavigableSet<String> organizationIds, NavigableSet<SearchResultUIModel> organizations)
    {
        super();
        
        this.organizationIds = organizationIds;
        this.organizations = organizations;
        this.statusMessage = SUCCESS;
        this.errorMessage = "";
    }
    
    public AjaxSearchFilterResponse()
    {
        this.organizationIds = new TreeSet<>();
        this.organizations = new TreeSet<>();
        this.statusMessage = NO_RESULTS;
        this.errorMessage = "";
    }
    
    public AjaxSearchFilterResponse(String errorMessage)
    {
        this.organizationIds = new TreeSet<>();
        this.organizations = new TreeSet<>();
        this.statusMessage = ERROR;
        this.errorMessage = errorMessage;
    }

    public NavigableSet<String> getOrganizationIds()
    {
        return organizationIds;
    }
    
    public NavigableSet<SearchResultUIModel> getOrganizations()
    {
        return organizations;
    }

    public String getStatusMessage()
    {
        return statusMessage;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }
}
