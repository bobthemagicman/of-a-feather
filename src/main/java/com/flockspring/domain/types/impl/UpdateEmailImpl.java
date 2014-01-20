/*

 * 
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types.impl;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * UpdateEmailImpl.java
 *
 * @author Justen L. Britain
 * @date Jan 18, 2014
 *
 */
@Document(collection = "updateEmailSearches")
public class UpdateEmailImpl
{
    private String emailAddress;
    private String userSearchCity;
    private DateTime searchDate;
    private int visitCount;
    
    public UpdateEmailImpl(String email, String userSearchCity, DateTime searchDate)
    {
       this.emailAddress = email;
       this.searchDate = searchDate;
       this.userSearchCity = userSearchCity;       
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public String getUserSearchCity()
    {
        return userSearchCity;
    }

    public DateTime getSearchDate()
    {
        return searchDate;
    }

    public int getVisitCount()
    {
        return visitCount;
    }

    public void setEmailAddress(String email)
    {
        this.emailAddress = email;
    }

    public void setUserSearchCity(String userSearchCity)
    {
        this.userSearchCity = userSearchCity;
    }

    public void setSearchDate(DateTime searchDate)
    {
        this.searchDate = searchDate;
    }

    public void setVisitCount(int visitCount)
    {
        this.visitCount = visitCount;
    }
}
