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
package com.ofafeather.ui;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

/**
 * IdentifiedPage.java
 *
 * @author Justen L. Britain
 * @date Jun 7, 2014
 *
 */
public abstract class IdentifiedPage
{
    public static final String PAGE_ID_MAP_KEY = "pageId";
    
    @ModelAttribute(PAGE_ID_MAP_KEY)
    protected abstract String getPageId();
    
    @SafeVarargs
    protected final void addBreadcrumbHeiarchyToModel(ModelAndView mav, ImmutablePair<String, Boolean>...breadCrumbs)
    {
		NavigableSet<ImmutablePair<String, Boolean>> breadCrumbHeiarchy = new TreeSet<ImmutablePair<String,Boolean>>();
		breadCrumbHeiarchy.add(getPair("breadcrumb.home", true));
		breadCrumbHeiarchy.addAll(Arrays.asList(breadCrumbs));
    }
    
    protected ImmutablePair<String, Boolean> getPair(final String param, final boolean isLocCode)
    {
	   return new ImmutablePair<String, Boolean>(param, isLocCode);
    }
}
