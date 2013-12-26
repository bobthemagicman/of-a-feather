/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;


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
    
    private final SearchResultsUIModel searchResultUIModel;
    private final String statusMessage;
    private final String errorMessage;
    
    public AjaxSearchFilterResponse(SearchResultsUIModel searchResultUIModel)
    {
        super();
        
        this.searchResultUIModel = searchResultUIModel;
        this.statusMessage = SUCCESS;
        this.errorMessage = "";
    }
    
    public AjaxSearchFilterResponse()
    {
        this.searchResultUIModel = null;
        this.statusMessage = NO_RESULTS;
        this.errorMessage = "";
    }
    
    public AjaxSearchFilterResponse(String errorMessage)
    {
        this.searchResultUIModel = null;
        this.statusMessage = ERROR;
        this.errorMessage = errorMessage;
    }

    public SearchResultsUIModel getOrganizations()
    {
        return searchResultUIModel;
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
