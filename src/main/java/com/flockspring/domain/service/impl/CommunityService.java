package com.flockspring.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flockspring.dataaccess.CommunityRepository;
import com.flockspring.domain.service.ICommunityService;

@Service
public class CommunityService extends ICommunityService {

    private final CommunityRepository communityRepository;

    @Autowired
    public CommunityService(final CommunityRepository communityRepository) {
        super();
        
        this.communityRepository = communityRepository;
    }
}
