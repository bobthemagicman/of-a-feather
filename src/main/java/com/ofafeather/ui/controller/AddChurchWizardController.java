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

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.ModelAndView;

import com.ofafeather.domain.service.OrganizationDiscoveryService;

/**
 * AddChurchWizardController.java
 * 
 * @author Justen L. Britain
 * @date Nov 24, 2013
 * 
 */
//@Controller
public class AddChurchWizardController
{
    private static final int finalPageNum = 4;

    private final OrganizationDiscoveryService organizationDiscoveryService;

    @Autowired
    public AddChurchWizardController(OrganizationDiscoveryService organizationDiscoveryService)
    {
        this.organizationDiscoveryService = organizationDiscoveryService;
    }

    //@InitBinder
    public void initBinder(WebDataBinder binder)
    {

        // binder.registerCustomEditor(Date.class, new
        // CustomDateEditor(dateFormat, false));
    }

   // @RequestMapping("/addYourChurch")
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
