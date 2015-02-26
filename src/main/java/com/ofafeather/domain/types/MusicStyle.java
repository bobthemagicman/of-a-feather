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
