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
    SPECTRUM_MIN("service.style.conservative"),//Not a slider value
    CONSERVATIVE_4("service.style.traditional.reverent"),
    CONSERVATIVE_3("service.style.traditional.reverent"),
    CONSERVATIVE_2("service.style.traditional"),
    CONSERVATIVE_1("service.style.traditional"),
    NEUTRAL("service.style.blend.of.both"),
    HIGH_ENERGY_1("service.style.lively"),
    HIGH_ENERGY_2("service.style.lively"),
    HIGH_ENERGY_3("service.style.very.lively.spirited"),
    HIGH_ENERGY_4("service.style.very.lively.spirited"),
    SPECTRUM_MAX("service.style.high.energy");//Not a slider value
    
    
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
