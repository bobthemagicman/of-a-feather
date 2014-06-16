/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.util.StringUtils;

/**
 * PropertiesUtil.java
 *
 * @author Justen L. Britain
 * @date Jun 7, 2014
 *
 */
public class PropertiesUtil
{

    /**
     * Convenience method to turn properties into List
     * @param property
     * @return
     */
    public static List<String> getPropertyAsList(String property)
    {
        List<String> propertyList = Collections.emptyList();
        
        if(StringUtils.hasText(property))
        {
            //try comma
            propertyList = createList(property, ",");
            
            //try semi colon
            if(propertyList.isEmpty())
            {
                propertyList = createList(property, ";");
            }
            //try space
            else if(propertyList.isEmpty())
            {
                propertyList = createList(property, " ");
            }
                        //just add the property to the list
            propertyList = Arrays.asList(property);
        }
        
        return propertyList;
    }

    private static List<String> createList(String property, String delim)
    {
        if(property.indexOf(delim) != -1)
        {
            return Arrays.asList(org.apache.commons.lang3.StringUtils.split(delim));
        }
        
        return Collections.emptyList();
    }
}
