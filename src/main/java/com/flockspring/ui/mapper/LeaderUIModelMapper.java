/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.mapper;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flockspring.domain.types.Leader;
import com.flockspring.ui.model.ImageUIModel;
import com.flockspring.ui.model.LeaderUIModel;

/**
 * leaderUIModelMapper.java
 *
 * @author Justen L. Britain
 * @date Jul 20, 2013
 *
 */
@Component
public class LeaderUIModelMapper
{

    private ImageUIModelMapper imageUIModelMapper;

    @Autowired
    public LeaderUIModelMapper(ImageUIModelMapper imageUIModelMapper)
    {
        this.imageUIModelMapper = imageUIModelMapper;
    }
    
    public Set<LeaderUIModel> map(Set<Leader> leadershipTeam)
    {
        Set<LeaderUIModel> modelSet = new TreeSet<LeaderUIModel>();
        for(Leader l : leadershipTeam)
        {
            modelSet.add(map(l));
        }
        
        return modelSet;
    }
    
    public LeaderUIModel map(Leader leader)
    {
        String bio = leader.getBio();
        ImageUIModel image = imageUIModelMapper.map(leader.getImage());
        String name = leader.getName();
        String title = leader.getTitle();
        boolean primaryContact = leader.isPrimaryContact();
        boolean primaryLeader = leader.isPrimaryLeader();
        
        LeaderUIModel model = new LeaderUIModel(name, title, bio, image, primaryContact, primaryLeader);
        
        return model;
    }

}
