/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import com.flockspring.ui.model.LocalizedEnum;

/**
 * MusicalInstruments.java
 *
 * @author Justen L. Britain
 * @date Dec 8, 2013
 *
 */
public enum MusicalInstruments implements LocalizedEnum
{
    CHOIR("musical.instruments.chior"),
    PIANO("musical.instruments.piano"),
    KEYBOARD("musical.instruments.keyboard"),
    ORGAN("musical.instruments.organ"),
    VIOLIN("musical.instruments.violin"),
    ELECTRIC_GUITAR("musical.instruments.electric.guitar"),
    ACOUSTIC_GUITAR("musical.instruments.acoustic.guitar"),
    DRUMS("musical.instruments.drums"),
    HORNS("musical.instruments.horns"),
    NO_MUSIC("musical.instruments.no.music"),
    OTHER("musical.instruments.other");
    
    private String localizationStringCode;
    
    private MusicalInstruments(String localizationStringCode)
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
