/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import java.util.ArrayList;
import java.util.List;

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
	    
		List<ReligionUIModel> religions = new ArrayList<ReligionUIModel>();
		
		religions.add(new ReligionUIModel(1, "Christian"));
		religions.add(new ReligionUIModel(2, "Buddhist"));
		religions.add(new ReligionUIModel(3, "Catholic"));
		religions.add(new ReligionUIModel(4, "Hindu"));
		religions.add(new ReligionUIModel(5, "Jewish"));
		religions.add(new ReligionUIModel(6, "Muslim"));
		religions.add(new ReligionUIModel(7, "Morman")); 
		religions.add(new ReligionUIModel(8, "New age"));
		religions.add(new ReligionUIModel(9, "Quaker"));
		religions.add(new ReligionUIModel(10, "Sikh"));
		religions.add(new ReligionUIModel(11, "Unitarian"));
		
		mav.addObject("religions", religions);

		return mav;
	}
}
