/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.mapper;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.flockspring.domain.types.AccessibilitySupport;
import com.flockspring.domain.types.Category;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * AddressUIModelMapperTest.java
 *
 * @author Justen L. Britain
 * @date Jul 5, 2014
 *
 */
public class CategoryUIMapConverterTests
{

    @Test
    public void testCategoryIsConvertedWithCorrectKeysAndCorrectValuesInValueSet()
    {
        Map<Category<AccessibilitySupport>, Set<AccessibilitySupport>> result = 
                new CategoryUIMapConverter<AccessibilitySupport>().convertCategoryToMap(AccessibilitySupport.values());
        
        assertThat(result, hasKey((Category<AccessibilitySupport>)AccessibilitySupport.TRANSPORTATION));
        assertThat(result, hasKey((Category<AccessibilitySupport>)AccessibilitySupport.SPECIAL_NEEDS));
        
        assertThat(result, hasEntry(is((Category<AccessibilitySupport>)AccessibilitySupport.SPECIAL_NEEDS), everyItem(isOneOf(AccessibilitySupport.DEAF_TRANSLATOR, AccessibilitySupport.HEARING_LOOP, AccessibilitySupport.WHEELCHAIR_ACCESS))));
    }

    @Test
    public void testHandlesNullParameter()
    {
        Set<AccessibilitySupport> nullSet = null;
        Map<Category<AccessibilitySupport>, Set<AccessibilitySupport>> result = 
                new CategoryUIMapConverter<AccessibilitySupport>().convertCategoryToMap(nullSet);
        
        assertThat(result, equalTo(Collections.<Category<AccessibilitySupport>, Set<AccessibilitySupport>>emptyMap()));
    }
    
    @Test
    public void testHandlesEmptySet()
    {
        Map<Category<AccessibilitySupport>, Set<AccessibilitySupport>> result = 
                new CategoryUIMapConverter<AccessibilitySupport>().convertCategoryToMap(Collections.<AccessibilitySupport>emptySet());
        
        assertThat(result, equalTo(Collections.<Category<AccessibilitySupport>, Set<AccessibilitySupport>>emptyMap()));
    }
}
