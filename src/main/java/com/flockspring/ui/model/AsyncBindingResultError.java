package com.flockspring.ui.model;

import com.flockspring.ui.model.async.AsyncError;

public class AsyncBindingResultError extends AsyncError
{
	private final String fieldName;
	
	public AsyncBindingResultError(final String fieldName, final String message)
	{
		super(message);
		
		this.fieldName = fieldName;
	}

	public String getFieldName()
	{
		return this.fieldName;
	}
}
