/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import com.flockspring.ui.model.LocalizedEnum;


/**
 * MusicStyle.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public enum MusicStyle implements LocalizedEnum
{
    TRADITIONAL_5("enum."),
    TRADITIONAL_4("enum."),
    TRADITIONAL_3("enum."),
    TRADITIONAL_2("enum."),
    TRADITIONAL_1("enum."),
    CONTEMPORARY_1("enum."),
    CONTEMPORARY_2("enum."),
    CONTEMPORARY_3("enum."),
    CONTEMPORARY_4("enum."),
    CONTEMPORARY_5("enum.");
    
    private String localizationStringCode;
    
    private MusicStyle(String localizationStringCode)
    {
        this.localizationStringCode = localizationStringCode;
    }
    
    @Override
    public String getLocalizedStringCode()
    {
        return this.localizationStringCode;
    }

    @Override
    public String getName()
    {
        return this.name();
    }

    @Override
    public int getOrdinal()
    {
        return this.ordinal();
    }
}
