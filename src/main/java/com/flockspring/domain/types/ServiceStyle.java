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
    SPECTRUM_MIN("serviceStyle.conservative"),//Not a slider value
    CONSERVATIVE_4("serviceStyle.traditional.reverent"),
    CONSERVATIVE_3("serviceStyle.traditional.reverent"),
    CONSERVATIVE_2("serviceStyle.traditional"),
    CONSERVATIVE_1("serviceStyle.traditional"),
    NEUTRAL("serviceStyle.blend.of.both"),
    HIGH_ENERGY_1("serviceStyle.lively"),
    HIGH_ENERGY_2("serviceStyle.lively"),
    HIGH_ENERGY_3("serviceStyle.very.lively.spirited"),
    HIGH_ENERGY_4("serviceStyle.very.lively.spirited"),
    SPECTRUM_MAX("serviceStyle.high.energy");//Not a slider value
    
    
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
