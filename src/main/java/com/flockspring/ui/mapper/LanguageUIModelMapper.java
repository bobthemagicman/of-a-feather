/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.mapper;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.flockspring.domain.types.Language;
import com.flockspring.ui.model.LanguageUIModel;

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
