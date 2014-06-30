/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model.async;

import java.util.List;

/**
 * BaseAJAXResponse.java
 *
 * @author Justen L. Britain
 * @date Jun 22, 2014
 *
 */
public abstract class BaseAsyncResponse
{
    private final List<AsyncError> errors;
    private final AsyncStatus asyncStatus;
    private final String statusMessage;
    
    public BaseAsyncResponse(final List<AsyncError> errors, final AsyncStatus asyncStatus,
            final String statusMessage)
    {
        super();
    
        this.errors = errors;
        this.asyncStatus = asyncStatus;
        this.statusMessage = statusMessage;
    }

    public List<AsyncError> getErrors()
    {
        return errors;
    }
    
    public AsyncStatus getAsyncStatus()
    {
        return asyncStatus;
    }
    
    public String getStatusMessage()
    {
        return statusMessage;
    }    
}
