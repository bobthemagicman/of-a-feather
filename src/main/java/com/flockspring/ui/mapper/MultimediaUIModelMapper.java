/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.mapper;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

import com.flockspring.domain.types.MultimediaObject;
import com.flockspring.ui.model.MultimediaUIModel;
import com.google.common.base.Strings;

/**
 * MultimediaUIModelMapper.java
 *
 * @author Justen L. Britain
 * @date Jul 20, 2013
 *
 */
@Component
public class MultimediaUIModelMapper
{

    public Set<MultimediaUIModel> map(Set<MultimediaObject> multimedia)
    {
        if(multimedia == null)
        {
            return null;
        }
        
        Set<MultimediaUIModel> modelSet = new TreeSet<MultimediaUIModel>();
        for(MultimediaObject i : multimedia)
        {
            modelSet.add(map(i));
        }
        
        return modelSet;

    }

    public MultimediaUIModel map(MultimediaObject mmObj)
    {
        if(mmObj != null)
        {
            String altText = Strings.nullToEmpty(mmObj.getAltText());
            String name = Strings.nullToEmpty(mmObj.getName());
            String path = mmObj.getPath();
            String title = Strings.nullToEmpty(mmObj.getTitleText());
            boolean primary = mmObj.isPrimary();
            boolean video = mmObj.isVideo();
            
            MultimediaUIModel model = new MultimediaUIModel(altText, name, path, title, primary, video);
                    
            return model;
        }
        
        return null;
    }
}
