/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.flockspring.domain.service.OrganizationDiscoveryService;

/**
 * AddChurchWizardController.java
 * 
 * @author Justen L. Britain
 * @date Nov 24, 2013
 * 
 */
@Controller
public class AddChurchWizardController
{
    private static final int finalPageNum = 4;

    private final OrganizationDiscoveryService organizationDiscoveryService;

    @Autowired
    public AddChurchWizardController(OrganizationDiscoveryService organizationDiscoveryService)
    {
        this.organizationDiscoveryService = organizationDiscoveryService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {

        // binder.registerCustomEditor(Date.class, new
        // CustomDateEditor(dateFormat, false));
    }

    @RequestMapping("/addYourChurch")
    public ModelAndView addYourChurchPrimary()
    {
        Map<String, Object> model = new HashMap<String, Object>();
        
        //denomination
        //subdenomination
        //states
        //"organizationCommandObject", new OrganizationImpl()
        return new ModelAndView("addAChurch", model);
    }

    
}
