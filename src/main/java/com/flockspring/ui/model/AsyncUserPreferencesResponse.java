/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import java.util.Collections;
import java.util.List;

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
public class AsyncUserPreferencesResponse extends BaseAsyncResponse
{
    public AsyncUserPreferencesResponse(String successMessage)
    {
        super(Collections.<AsyncError>emptyList(), AsyncStatus.SUCCESS, successMessage);
    }
    
    public AsyncUserPreferencesResponse()
    {
        super(Collections.<AsyncError>emptyList(), AsyncStatus.NO_RESULT, "No Results Found for Query");
    }

	public AsyncUserPreferencesResponse(List<AsyncBindingResultError> errors, AsyncStatus status,
			String message)
	{
		super(errors, status, message);
	}
}
