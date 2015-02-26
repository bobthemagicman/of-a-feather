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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.webflow.core.FlowException;
import org.springframework.webflow.execution.FlowExecutionOutcome;
import org.springframework.webflow.mvc.servlet.AbstractFlowHandler;

import com.ofafeather.domain.service.OrganizationDiscoveryService;

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
