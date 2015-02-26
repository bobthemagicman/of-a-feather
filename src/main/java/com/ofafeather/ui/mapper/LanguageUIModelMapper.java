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
package com.ofafeather.ui.mapper;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

import com.ofafeather.domain.types.Language;
import com.ofafeather.ui.model.LanguageUIModel;

/**
 * languageUIModelMapper.java
 * 
 * @author Justen L. Britain
 * @date Jul 20, 2013
 * 
 */
@Component
public class LanguageUIModelMapper
{

    public Set<LanguageUIModel> map(Set<Language> languages)
    {
        if (languages == null)
        {
            return null;
        }

        Set<LanguageUIModel> modelSet = new TreeSet<LanguageUIModel>();
        for (Language l : languages)
        {
            modelSet.add(map(l));
        }

        return modelSet;
    }

    public LanguageUIModel map(Language language)
    {
        String englishName = language.getNames()[0];
        String localizedName = language.getUTF8Localizations()[0];

        LanguageUIModel model = new LanguageUIModel(englishName, localizedName);

        return model;
    }
}
