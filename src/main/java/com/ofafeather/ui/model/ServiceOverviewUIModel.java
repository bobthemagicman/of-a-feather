/**
 *
 *  Copyright 2015 Justen L. Britain
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
package com.ofafeather.ui.model;

import java.util.Set;

/**
 * ServiceOverviewUIModel.java
 *
 * @author Justen L. Britain
 * @date Dec 15, 2013
 *
 */
public class ServiceOverviewUIModel
{

    private final int durationInMinutes;
    private final Set<LanguageUIModel> languages;
    private final String serviceSchedule;
   
    public ServiceOverviewUIModel(int durationInMinutes, Set<LanguageUIModel> languages, String serviceSchedule)
    {
        super();
        
        this.durationInMinutes = durationInMinutes;
        this.languages = languages;
        this.serviceSchedule = serviceSchedule;
    }

    public int getDurationInMinutes()
    {
        return durationInMinutes;
    }

    public Set<LanguageUIModel> getLanguages()
    {
        return languages;
    }

    public String getServiceSchedule()
    {
        return serviceSchedule;
    }
}
