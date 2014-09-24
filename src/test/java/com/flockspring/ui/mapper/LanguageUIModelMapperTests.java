/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.mapper;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.collections.Sets;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.flockspring.config.TestSocialConfig;
import com.flockspring.config.TestWebConfig;
import com.flockspring.domain.types.Language;
import com.flockspring.ui.config.SecurityConfig;
import com.flockspring.ui.config.WebappConfig;
import com.flockspring.ui.model.LanguageUIModel;

/**
 * AddressUIModelMapperTest.java
 *
 * @author Justen L. Britain
 * @date Jul 5, 2014
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestWebConfig.class, TestSocialConfig.class, SecurityConfig.class, WebappConfig.class})
@WebAppConfiguration
@ActiveProfiles("test")
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
        
        
        
    }
}
