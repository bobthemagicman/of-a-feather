/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui;

import com.flockspring.ui.model.async.AsyncError;

/**
 * AsyncUserError.java
 *
 * @author Justen L. Britain
 * @date Jun 22, 2014
 *
 */
public class AsyncUserError extends AsyncError
{

    private static final String  ERROR_MESSAGE = "User was null, unable to complete operation";

    public AsyncUserError()
    {
        super(ERROR_MESSAGE);
    }
    
}
