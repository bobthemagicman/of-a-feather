/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.flockspring.domain.service.ICommunityService;
import com.flockspring.domain.types.impl.CommunityImpl;
import com.lehman.technology.group.common.domain.types.GlobalRegion;

/**
 * ProfilePageController.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
@Controller
@RequestMapping("/communities")
public class ProfilePageController 
{

	private final ICommunityService communityService;
	
	@Autowired
	public ProfilePageController(final ICommunityService communityService) {
		super();
	
		this.communityService = communityService;
	}
	
	@RequestMapping("/{regionName}/{communityName}")
	public ModelAndView renderCommunityProfileByName(@PathVariable String communityName, @PathVariable String regionName)
	{
		CommunityImpl community = communityService.getCommunityByNameAndRegion();
		return buildModelAndView(community);
	}

	@RequestMapping("/{communityId}")
    public String renderCommunityProfileById(@PathVariable String communityId)
    {
	    //TODO: sanitize communityId
	    //String cleanCommuinityId = ...
	    GlobalRegion region = communityService.getRegionForCommunity(communityId);
        CommunityImpl community = communityService.getCommunityById(communityId);
        
        return buildRedirectUrl(region, community);
    }

	private String buildRedirectUrl(GlobalRegion region, CommunityImpl community)
	{
	    StringBuilder seoUrl = new StringBuilder("redirect:").append(region.getEnglishName())
	            .append(community.getCommunityName);
	    
	    return seoUrl.toString();
	}
}
