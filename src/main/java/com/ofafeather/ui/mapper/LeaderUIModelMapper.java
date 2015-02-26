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
package com.ofafeather.ui.mapper;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ofafeather.domain.types.Leader;
import com.ofafeather.ui.model.LeaderUIModel;
import com.ofafeather.ui.model.MultimediaUIModel;

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
