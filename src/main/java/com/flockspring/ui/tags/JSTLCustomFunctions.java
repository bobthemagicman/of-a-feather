/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.tags;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * JSTLCustomFunctions.java
 *
 * @author Justen L. Britain
 * @date Dec 28, 2013
 *
 */
public class JSTLCustomFunctions
{

    public static boolean collectionContains(Collection<?> collection, Object o)
    {
        return collection != null ? collection.contains(o) : false;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List createList(Object...o)
    {
        List l = new ArrayList(o.length);
        l.addAll(Arrays.asList(o));
        
        return l;
    }
}
