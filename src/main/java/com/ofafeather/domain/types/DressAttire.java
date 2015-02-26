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
