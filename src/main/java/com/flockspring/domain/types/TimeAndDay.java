/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types;

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
