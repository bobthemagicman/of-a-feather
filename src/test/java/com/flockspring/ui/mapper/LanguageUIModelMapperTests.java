/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.mapper;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.util.collections.Sets;

import com.flockspring.domain.types.Language;
import com.flockspring.ui.model.LanguageUIModel;

/**
 * AddressUIModelMapperTest.java
 *
 * @author Justen L. Britain
 * @date Jul 5, 2014
 *
 */
public class LanguageUIModelMapperTests
{

    private LanguageUIModelMapper mapper;
    
    @Before
    public void setup()
    {
        mapper = new LanguageUIModelMapper();
    }
    
    @Test
    public void testMapperMapsASetOfLanguagesCorrectly()
    {
        Set<Language> testSet = Sets.newSet(Language.AMERICAN_SIGN_LANGUAGE, Language.ENGLISH, Language.SPANISH);
        Set<LanguageUIModel> result = mapper.map(testSet);
        
        assertThat(result, matcher);
        
    }
}
