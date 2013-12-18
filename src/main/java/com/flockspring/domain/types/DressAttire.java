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
public enum DressAttire implements LocalizedEnum
{
    FORMAL_5("enum."),
    FORMAL_4("enum."),
    FORMAL_3("enum."),
    FORMAL_2("enum."),
    FORMAL_1("enum."),
    CASUAL_1("enum."),
    CASUAL_2("enum."),
    CASUAL_3("enum."),
    CASUAL_4("enum."),
    CASUAL_5("enum.");
    
    private String localizationStringCode;
    
    private DressAttire(String localizationStringCode)
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
