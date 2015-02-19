/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.flockspring.ui.IdentifiedPage;

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
