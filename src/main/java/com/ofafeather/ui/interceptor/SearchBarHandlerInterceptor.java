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
package com.ofafeather.ui.interceptor;

import static com.ofafeather.ui.IdentifiedPage.PAGE_ID_MAP_KEY;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * HeaderHandlerInterceptor.java
 *
 * @author Justen L. Britain
 * @date May 10, 2014
 *
 */
public class SearchBarHandlerInterceptor extends HandlerInterceptorAdapter implements HandlerInterceptor
{
    private List<String> pageIdsOfPagesNotToShowSearchInHeader;
    
    public SearchBarHandlerInterceptor(List<String> pageIdsOfPagesNotToShowSearchInHeader)
    {
        super();

        this.pageIdsOfPagesNotToShowSearchInHeader = pageIdsOfPagesNotToShowSearchInHeader;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception
    {
        if(mv != null && mv.getModel() != null && !mv.getModel().isEmpty())
        {
            String pageId = (mv.getModel().containsKey(PAGE_ID_MAP_KEY) ? (String) mv.getModel().get(PAGE_ID_MAP_KEY) : "");
            mv.addObject("showHeaderSearch", !pageIdsOfPagesNotToShowSearchInHeader.contains(pageId));
        }
    }
}