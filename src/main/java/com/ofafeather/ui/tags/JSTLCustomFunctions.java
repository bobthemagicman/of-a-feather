/**
 *
 *  Copyright 2015 Justen L. Britain
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
package com.ofafeather.ui.tags;

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
