/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

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
