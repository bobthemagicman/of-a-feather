/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.mapper;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.flockspring.domain.types.Leader;
import com.flockspring.ui.model.LeaderUIModel;
import com.flockspring.ui.model.MultimediaUIModel;

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

    private MultimediaUIModelMapper imageUIModelMapper;

    @Autowired
    public LeaderUIModelMapper(MultimediaUIModelMapper imageUIModelMapper)
    {
        this.imageUIModelMapper = imageUIModelMapper;
    }
    
    public Set<LeaderUIModel> map(Set<Leader> list)
    {
        Set<LeaderUIModel> modelSet = new TreeSet<LeaderUIModel>();
        for(Leader l : list)
        {
            modelSet.add(map(l));
        }
        
        return modelSet;
    }
    
    public LeaderUIModel map(Leader leader)
    {
        String bio = leader.getBio();
        MultimediaUIModel image = imageUIModelMapper.map(leader.getImage());
        String name = leader.getName();
        String title = leader.getTitle();
        boolean primaryContact = leader.isPrimaryContact();
        boolean primaryLeader = leader.isPrimaryLeader();
        
        LeaderUIModel model = new LeaderUIModel(name, title, bio, image, primaryContact, primaryLeader);
        
        return model;
    }

}
