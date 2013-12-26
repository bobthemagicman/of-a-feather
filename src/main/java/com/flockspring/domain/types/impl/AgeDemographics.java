/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import com.flockspring.ui.model.LocalizedEnum;

/**
 * AgeDemographics.java
 *
 * @author Justen L. Britain
 * @date Dec 8, 2013
 *
 */
public enum AgeDemographics implements LocalizedEnum
{
    SPECTRUM_MIN("age.demographics.youth"),//not a slider value
    YOUTH_1("age.demographics.college.and.high.school"),
    YOUTH_2("age.demographics.post.college"),
    YOUTH_3("age.demographics.families.with.young.children"),
    NEUTRAL_4("age.demographics.all.ages"),
    MATURE_5("age.demographics.families.with.older.children"),
    MATURE_6("age.demographics.mature"),
    MATURE_7("age.demographics.senior"),
    SPECTRUM_MAX("age.demographics.mature");//not a slider value
        
    private String localizationStringCode;
    
    private AgeDemographics(String localizationStringCode)
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
