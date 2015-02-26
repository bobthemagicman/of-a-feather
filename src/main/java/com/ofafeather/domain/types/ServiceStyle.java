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
package com.ofafeather.domain.types;

import com.ofafeather.ui.model.LocalizedEnum;


/**
 * MusicStyle.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public enum ServiceStyle implements LocalizedEnum
{
    CONSERVATIVE_1("service.style.traditional.reverent"),
    CONSERVATIVE_2("service.style.traditional.reverent"),
    CONSERVATIVE_3("service.style.traditional"),
    CONSERVATIVE_4("service.style.traditional"),
    NEUTRAL_5("service.style.blend.of.both"),
    NEUTRAL_6("service.style.blend.of.both"),
    HIGH_ENERGY_7("service.style.lively"),
    HIGH_ENERGY_8("service.style.lively"),
    HIGH_ENERGY_9("service.style.very.lively.spirited"),
    HIGH_ENERGY_10("service.style.very.lively.spirited");
    
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
