package com.flockspring.domain.service;

public class GeoLocationException extends RuntimeException
{

    private static final long serialVersionUID = 4181644546569594974L;
    
	public GeoLocationException(String message)
    {
		super(message);
    }
}
