package com.flockspring.ui.editors;

import java.beans.PropertyEditorSupport;

import org.joda.time.LocalDate;

public class LocalDateEditor extends PropertyEditorSupport
{
	@Override
	public void setAsText(String text) throws IllegalArgumentException
	{
		setValue(LocalDate.parse(text));
	}
	
	@Override
	public String getAsText()
	{
		return getValue().toString();
	}
}
