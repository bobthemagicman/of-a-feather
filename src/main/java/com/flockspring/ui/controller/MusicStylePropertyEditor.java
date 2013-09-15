/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import java.beans.PropertyEditorSupport;

import com.flockspring.domain.types.MusicStyle;

/**
 * MusicStylePropertyEditor.java
 *
 * @author Justen L. Britain
 * @date Jul 31, 2013
 *
 */
public class MusicStylePropertyEditor extends PropertyEditorSupport
{
    @Override
    public void setAsText(String musicStyleAsText) throws IllegalArgumentException
    {
        setValue(MusicStyle.valueOf(musicStyleAsText.toUpperCase()));
    }
}
