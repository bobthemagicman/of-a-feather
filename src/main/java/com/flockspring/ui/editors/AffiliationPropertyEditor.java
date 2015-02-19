/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.editors;

import java.beans.PropertyEditorSupport;

import com.flockspring.domain.types.Affiliation;

/**
 * MusicStylePropertyEditor.java
 *
 * @author Justen L. Britain
 * @date Jul 31, 2013
 *
 */
public class AffiliationPropertyEditor extends PropertyEditorSupport
{
    @Override
    public void setAsText(String musicStyleAsText) throws IllegalArgumentException
    {
        setValue(Affiliation.valueOf(musicStyleAsText.toUpperCase()));
    }
    
    @Override
    public String getAsText()
    {
    	return ((Affiliation)getValue()).name();
    }
}
