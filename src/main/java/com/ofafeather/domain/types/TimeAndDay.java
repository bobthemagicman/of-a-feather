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
package com.ofafeather.domain.types;

import org.joda.time.LocalDateTime;

import com.google.common.collect.ComparisonChain;

/**
 * SmallTimeImpl.java
 *
 * @author Justen L. Britain
 * @date Dec 22, 2013
 *
 */
public class TimeAndDay implements Comparable<TimeAndDay>
{

    private LocalDateTime startTime;
    private ServiceDay serviceDay;
   
    public TimeAndDay(LocalDateTime startTime, ServiceDay serviceDay)
    {
        super();
        this.startTime = startTime;
        this.serviceDay = serviceDay;
    }
    
    public LocalDateTime getStartTime()
    {
        return startTime;
    }
    
    public ServiceDay getServiceDay()
    {
        return serviceDay;
    }
    
    public void setStartTime(LocalDateTime startTime)
    {
        this.startTime = startTime;
    }
    
    public void setServiceDay(ServiceDay serviceDay)
    {
        this.serviceDay = serviceDay;
    }

    @Override
    public int compareTo(TimeAndDay right)
    {
        TimeAndDay left = this;
        return ComparisonChain.start()
                .compare(left.getServiceDay(), right.getServiceDay())
                .compare(left.getStartTime(), right.getStartTime())
                .result();
    }    
}
