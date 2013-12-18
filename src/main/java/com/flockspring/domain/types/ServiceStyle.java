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
public enum ServiceStyle implements LocalizedEnum
{
    CONSERVATIVE_5("enum."),
    CONSERVATIVE_4("enum."),
    CONSERVATIVE_3("enum."),
    CONSERVATIVE_2("enum."),
    CONSERVATIVE_1("enum."),
    HIGH_ENERGY_1("enum."),
    HIGH_ENERGY_2("enum."),
    HIGH_ENERGY_3("enum."),
    HIGH_ENERGY_4("enum."),
    HIGH_ENERGY_5("enum.");
    
    private String localizationStringCode;
    
    private ServiceStyle(String localizationStringCode)
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
