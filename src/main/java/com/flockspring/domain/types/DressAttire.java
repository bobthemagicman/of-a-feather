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
    FORMAL_1("dress.attire.sunday.best"),
    FORMAL_2("dress.attire.sunday.best"),
    FORMAL_3("dress.attire.business.casual"),
    FORMAL_4("dress.attire.business.casual"),
    NEUTRAL_5("dress.attire.blend.of.both"),
    NEUTRAL_6("dress.attire.blend.of.both"),
    CASUAL_7("dress.attire.smart.casual"),
    CASUAL_8("dress.attire.smart.casual"),
    CASUAL_9("dress.attire.day.at.the.beach"),
    CASUAL_10("dress.attire.day.at.the.beach");
    
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
