/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model.async;

/**
 * AsyncError.java
 *
 * @author Justen L. Britain
 * @date Jun 22, 2014
 *
 */
public abstract class AsyncError
{
    private final String errorMessage;
    private final Exception exception;
    
    public AsyncError(final String errorMessage, final Exception exception)
    {
        super();
    
        this.errorMessage = errorMessage;
        this.exception = exception;
    }
    
    public AsyncError(final String errorMessage)
    {
        super();
    
        this.errorMessage = errorMessage;
        this.exception = null;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public Exception getException()
    {
        return exception;
    }
}
