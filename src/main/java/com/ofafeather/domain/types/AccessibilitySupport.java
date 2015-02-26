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
 * AccessibilitySupport.java
 *
 * @author Justen L. Britain
 * @date Nov 9, 2013
 *
 */
public enum AccessibilitySupport implements LocalizedEnum, Category<AccessibilitySupport>
{
    SPECIAL_NEEDS(null, "accessibility.support.special.needs"),
    TRANSPORTATION(null,"accessibility.support.transportation"),
    
    WHEELCHAIR_ACCESS(SPECIAL_NEEDS, "accessibility.support.wheelchair.access"),
    DEAF_TRANSLATOR(SPECIAL_NEEDS, "accessibility.support.deaf.translator"),
    HEARING_LOOP(SPECIAL_NEEDS, "accessibility.support.hearing.loop"),
    PARKING_LOT(TRANSPORTATION, "accessibility.support.parking.lot"),
    STREET_PARKING(TRANSPORTATION, "accessibility.support.street.parking"),
    PARKING_GARAGE(TRANSPORTATION, "accessibility.support.parking.garage"),
    CARPOOL(TRANSPORTATION, "accessibility.support.carpool");
    
    private String localizationStringCode;
    private AccessibilitySupport category;
    
    private AccessibilitySupport(AccessibilitySupport category, String localizationStringCode)
    {
        this.localizationStringCode = localizationStringCode;
        this.category = category;
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
    
    public AccessibilitySupport getCategory()
    {
        return category;
    }
}
