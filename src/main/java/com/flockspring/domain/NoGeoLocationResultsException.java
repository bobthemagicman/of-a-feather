package com.flockspring.domain;

public class NoGeoLocationResultsException extends RuntimeException
{

    private static final long serialVersionUID = 4102636169205450930L;

	public NoGeoLocationResultsException(String message)
    {
	    super(message);
    }

}
