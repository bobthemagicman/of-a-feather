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
    SPECTRUM_MIN("music.style.traditional"),//Not a slider value
    TRADITIONAL_4("music.style.classic.hymns"),
    TRADITIONAL_3("music.style.classic.songs.sound"),
    TRADITIONAL_2("music.style.upbeat.classic.gospel"),
    NEUTRAL("music.style.blend.of.both"),
    CONTEMPORARY_2("music.style.contemporary.sound"),
    CONTEMPORARY_3("music.style.modern"),
    CONTEMPORARY_4("music.style.radically.modern"),
    SPECTRUM_MAX("music.style.contemporary");//Not a slider value
    
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
