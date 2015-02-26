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
package com.ofafeather.domain.types.impl;

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
