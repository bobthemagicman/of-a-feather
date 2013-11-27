/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.webflow.core.FlowException;
import org.springframework.webflow.execution.FlowExecutionOutcome;
import org.springframework.webflow.mvc.servlet.AbstractFlowHandler;

import com.flockspring.domain.service.OrganizationDiscoveryService;

/**
 * AddAChurchFlowHandler.java
 *
 * @author Justen L. Britain
 * @date Nov 24, 2013
 *
 */
public class AddAChurchFlowHandler extends AbstractFlowHandler
{
    private static final String FLOW_ID = "/addAChurch";
    
    private final OrganizationDiscoveryService organizationDiscoveryService;

    @Autowired
    public AddAChurchFlowHandler(OrganizationDiscoveryService organizationDiscoveryService)
    {
        this.organizationDiscoveryService = organizationDiscoveryService;
    }
    
    @Override
    public String handleExecutionOutcome(FlowExecutionOutcome outcome, HttpServletRequest request, HttpServletResponse response)
    {
        // TODO Auto-generated method stub
        return super.handleExecutionOutcome(outcome, request, response);
    }
    
    @Override
    public String handleException(FlowException e, HttpServletRequest request, HttpServletResponse response)
    {
        // TODO Auto-generated method stub
        return super.handleException(e, request, response);
    }
    
    @Override
    public String getFlowId()
    {
        
        return FLOW_ID;
    }
}
