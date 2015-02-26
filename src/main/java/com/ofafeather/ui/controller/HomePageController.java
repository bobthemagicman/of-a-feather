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
package com.ofafeather.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ofafeather.ui.IdentifiedPage;

/**
 * HomePageController.java
 * 
 * @author Justen L. Britain
 * @date May 16, 2013
 * 
 */

@Controller
public class HomePageController extends IdentifiedPage
{

	static final String PAGE_ID = "home";

    @RequestMapping("/")
	public ModelAndView renderDefaultHomePage() {
	    return new ModelAndView("homePage");
	}

    @Override
    protected String getPageId()
    {
        return PAGE_ID;
    }
}
