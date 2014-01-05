/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.mapper;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.flockspring.domain.types.Category;

/**
 * CategoryUIMapConverter.java
 * 
 * @author Justen L. Britain
 * @date Jan 1, 2014
 * 
 */
public class CategoryUIMapConverter<T extends Category<T>>
{

    public Map<Category<T>, Set<T>> convertCategoryToMap(Collection<T> convertables)
    {
        Map<Category<T>, Set<T>> convertedMap = new HashMap<>();
        for (T c : convertables)
        {
            if(c.getCategory() != null)
            {
                if (convertedMap.containsKey(c.getCategory()))
                {
                    convertedMap.get(c.getCategory()).add(c);
                } else
                {
                    Set<T> valueSet = new TreeSet<>();
                    valueSet.add(c);
                    convertedMap.put(c.getCategory(), valueSet);
                }
            }
        }

        return convertedMap;
    }

    public Map<Category<T>, Set<T>> convertCategoryToMap(T[] values)
    {
        Collection<T> convertables = Arrays.asList(values);
        return convertCategoryToMap(convertables);
    }
}
