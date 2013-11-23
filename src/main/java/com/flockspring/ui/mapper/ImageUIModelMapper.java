/*
 * Copyright 2013 flockspring Inc. All rights reserved
 */
package com.flockspring.ui.mapper;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

import com.flockspring.domain.types.Image;
import com.flockspring.ui.model.ImageUIModel;

/**
 * ImageUIModelMapper.java
 *
 * @author Justen L. Britain
 * @date Jul 20, 2013
 *
 */
@Component
public class ImageUIModelMapper
{

    public Set<ImageUIModel> map(Set<Image> images)
    {
        if(images == null)
        {
            return null;
        }
        
        Set<ImageUIModel> modelSet = new TreeSet<ImageUIModel>();
        for(Image i : images)
        {
            modelSet.add(map(i));
        }
        
        return modelSet;

    }

    public ImageUIModel map(Image image)
    {
        if(image != null)
        {
            String altText = image.getAltText();
            int height = image.getHeight();
            String name = image.getName();
            String path = image.getPath();
            String title = image.getTitleText();
            int width = image.getWidth();
            
            ImageUIModel model = new ImageUIModel(altText, name, path, title, height, width);
                    
            return model;
        }
        
        return null;
    }
}
