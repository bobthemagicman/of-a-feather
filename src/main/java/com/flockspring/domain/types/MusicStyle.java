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
    TRADITIONAL_1("music.style.classic.hymns"),
    TRADITIONAL_2("music.style.classic.songs.sound"),
    TRADITIONAL_3("music.style.upbeat.classic.gospel"),
    TRADITIONAL_4("music.style.upbeat.classic.gospel"),
    NEUTRAL_5("music.style.blend.of.both"),
    NEUTRAL_6("music.style.blend.of.both"),
    CONTEMPORARY_7("music.style.contemporary.sound"),
    CONTEMPORARY_8("music.style.contemporary.sound"),
    CONTEMPORARY_9("music.style.modern"),
    CONTEMPORARY_10("music.style.radically.modern");
    
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
