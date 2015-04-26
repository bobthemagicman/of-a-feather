/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import java.util.Arrays;
import java.util.Collections;

import com.flockspring.ui.model.async.AsyncError;
import com.flockspring.ui.model.async.AsyncStatus;
import com.flockspring.ui.model.async.BaseAsyncResponse;


/**
 * AsyncSearchFilterResponse.java
 *
 * @author Justen L. Britain
 * @date Oct 20, 2013
 *
 */
public class AsyncSearchFilterResponse extends BaseAsyncResponse
{
    private final SearchResultsUIModel searchResultUIModel;
    
    public AsyncSearchFilterResponse(SearchResultsUIModel searchResultUIModel, String successMessage)
    {
        super(Collections.<AsyncError>emptyList(), AsyncStatus.SUCCESS, successMessage);
        
        this.searchResultUIModel = searchResultUIModel;
    }
    
    public AsyncSearchFilterResponse()
    {
        super(Collections.<AsyncError>emptyList(), AsyncStatus.NO_RESULT, "No Results Found for Query");
        
        this.searchResultUIModel = null;
    }
    
    public AsyncSearchFilterResponse(AsyncError error, String errorMessage)
    {
        super(Arrays.asList(error), AsyncStatus.NO_RESULT, errorMessage);
        
        this.searchResultUIModel = null;        
    }

    public SearchResultsUIModel getOrganizations()
    {
        return searchResultUIModel;
    }
}
