/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types;

/**
 * Address.java
 *
 * @author Justen L. Britain
 * @date Jun 9, 2013
 *
 */
public interface Address
{

    /**
     * @return
     */
    String getStreet1();
    
    /**
     * @return
     */
    String getStreet2();

    /**
     * @return
     */
    String getPostalCode();

    /**
     * @return
     */
    String getState();

    /**
     * @return
     */
    String getCity();

    /**
     * @return
     */
    String getCountry();

    /**
     * @return
     */
    double getLongitude();

    /**
     * @return
     */
    double getLatitude();

    double [] getLocation();
}
