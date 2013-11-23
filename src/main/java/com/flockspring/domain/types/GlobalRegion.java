/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.domain.types;

import java.util.Locale;


/**
 * IGlobalRegion.java
 *
 * @author Justen L. Britain
 * @date May 27, 2013
 *
 */
public interface GlobalRegion<T> {

    /**
     * @return the id
     */
    long getId();

    /**
     * @return The ISO-3166-alpha3 Country Code if applicable 
     */
    String getIsoAlpha3Code();

    /**
     * @return The ISO-3166-alpha2 Country Code if applicable
     */
    String getIsoAlpha2Code();

    /**
     * @return The name of the region localized to the regions native language
     */
    String getNativeLocalizedName();
    
    /**
     * @return The name of the region localized to the locale represented by the parameter, if unable to match locale will return the enlish version
     */
    String getLocalizedName(Locale locale);

    /**
     * @return The name of the region in english
     */
    String getEnglishName();

    /**
     * @return The GlobalRegion that is the parent region, null if no parent
     */
    T getParentRegion();
    
    GlobalRegionType getRegionType();
}
