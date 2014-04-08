package com.flockspring.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */

/**
 * LoginController.java
 *
 * @author Justen L. Britain
 * @date Apr 5, 2014
 *
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "loginPage";
    }
}