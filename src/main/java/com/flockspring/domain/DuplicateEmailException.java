/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain;

/**
 * DuplicateEmailException.java
 *
 * @author Justen L. Britain
 * @date Apr 5, 2014
 *
 */
public class DuplicateEmailException extends Exception
{

    private static final long serialVersionUID = 6984983773037134594L;

    public DuplicateEmailException()
    {
        super();
    }

    public DuplicateEmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DuplicateEmailException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public DuplicateEmailException(String message)
    {
        super(message);
    }

    public DuplicateEmailException(Throwable cause)
    {
        super(cause);
    }
}
