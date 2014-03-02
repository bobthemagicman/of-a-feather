/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import java.util.HashMap;
import java.util.Map;

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
	    Map<String, Object> model = new HashMap<String, Object>();
	    model.put("navSearchEnabled", false);
	    
	    ModelAndView mav = new ModelAndView("homePage", model);
	  
	
		return mav;
	}
}
