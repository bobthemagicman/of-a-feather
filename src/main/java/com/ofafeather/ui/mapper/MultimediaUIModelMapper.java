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

import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.ofafeather.domain.types.MultimediaObject;
import com.ofafeather.ui.model.MultimediaUIModel;

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
