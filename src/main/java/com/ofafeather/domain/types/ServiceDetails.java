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

import java.util.Set;

import com.ofafeather.domain.types.impl.AgeDemographics;
import com.ofafeather.domain.types.impl.MusicalInstruments;

/**
 * ChurchService.java
 * 
 * @author Justen L. Britain
 * @date Dec 16, 2013
 * 
 */
public interface ServiceDetails
{

    MusicStyle getMusicStyle();

    DressAttire getDressAttire();

    Set<MusicalInstruments> getInstruments();

    AgeDemographics getAgeDemongraphics();

    ServiceStyle getServiceStyle();

    int getDurationInMinutes();
    
    TimeAndDay getTimeAndDay();

    String getServiceName();

    /**
     * @return
     */
    Set<Language> getLanguages();
}
