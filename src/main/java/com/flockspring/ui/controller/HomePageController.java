/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * HomePageController.java
 * 
 * @author Justen L. Britain
 * @date May 16, 2013
 * 
 */

@Controller
public class HomePageController {

	@RequestMapping("/")
	public ModelAndView renderDefaultHomePage() {

	    ModelAndView mav = new ModelAndView("homePage");
	  
	
		return mav;
	}
}
