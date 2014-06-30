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
 * AsyncUserFavoriteResponse.java
 *
 * @author Justen L. Britain
 * @date Oct 20, 2013
 *
 */
public class AsyncUserFavoriteResponse extends BaseAsyncResponse
{
    public AsyncUserFavoriteResponse(String successMessage)
    {
        super(Collections.<AsyncError>emptyList(), AsyncStatus.SUCCESS, successMessage);
    }
    
    public AsyncUserFavoriteResponse()
    {
        super(Collections.<AsyncError>emptyList(), AsyncStatus.NO_RESULT, "No Results Found for Query");
    }
    
    public AsyncUserFavoriteResponse(AsyncError error, String errorMessage)
    {
        super(Arrays.asList(error), AsyncStatus.NO_RESULT, errorMessage);
    }
}
