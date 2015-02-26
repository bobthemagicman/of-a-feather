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

import java.util.Locale;


/**
 * IGlobalRegion.java
 *
 * @author Justen L. Britain
 * @date May 27, 2013
 *
 */
public interface GlobalRegion<T> {

    /**
     * @return the id
     */
    long getId();

    /**
     * @return The ISO-3166-alpha3 Country Code if applicable 
     */
    String getIsoAlpha3Code();

    /**
     * @return The ISO-3166-alpha2 Country Code if applicable
     */
    String getIsoAlpha2Code();

    /**
     * @return The name of the region localized to the regions native language
     */
    String getNativeLocalizedName();
    
    /**
     * @return The name of the region localized to the locale represented by the parameter, if unable to match locale will return the enlish version
     */
    String getLocalizedName(Locale locale);

    /**
     * @return The name of the region in english
     */
    String getEnglishName();

    /**
     * @return The GlobalRegion that is the parent region, null if no parent
     */
    T getParentRegion();
    
    GlobalRegionType getRegionType();
}
