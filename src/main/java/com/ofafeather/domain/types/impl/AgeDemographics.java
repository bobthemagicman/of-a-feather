/**
 *
 *   Copyright 2015 Justen L. Britain
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 **/
package com.ofafeather.domain.types.impl;

import com.ofafeather.ui.model.LocalizedEnum;

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
