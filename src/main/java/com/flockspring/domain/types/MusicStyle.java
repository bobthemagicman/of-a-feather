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
    GOSPEL("music.style.gospel"),
    JAZZ("music.style.jazz"),
    BIG_BAND("music.style.big.band"),
    TRADITIONAL("music.style.traditional"),
    NONE("music.style.none"),
    CHOIR("music.style.choir"),
    MODERN("music.style.modern");

    private String localizString;
    
    private MusicStyle(String localizString) {
        this.localizString = localizString;
    }

    @Override
    public String getLocalizedStringCode() 
    {
        return this.localizString;
    }

    @Override
    public String getName()
    {
        return this.name();
    }
    
    @Override
    public int getOrdinal()
    {
        return ordinal();
    }
}
