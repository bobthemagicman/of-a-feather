/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import com.lehman.technology.group.common.web.ui.model.LocalizedEnum;

/**
 * UIMusicStyle.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public enum UIMusicStyle implements LocalizedEnum
{
    GOSPEL("music.gospel"),
    JAZZ("music.jazz"),
    BIG_BAND("music.big.band"),
    TRADITIONAL("music.traditional"),
    CHANTING("music.chanting"),
    NONE("music.none"),
    CHOIR("music.choir"),
    MODERN("music.modern");

    private String localizString;
    
    private UIMusicStyle(String localizString) {
        this.localizString = localizString;
    }

    @Override
    public String getLocalizedStringCode() 
    {
        return this.localizString;
    }
}
