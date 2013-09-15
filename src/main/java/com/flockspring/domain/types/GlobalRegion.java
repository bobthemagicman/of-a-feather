/*  Copyright (c) 2013, Lehman Technolog Group
/*
 *  All rights reserved.
 *  
 *  Redistribution and use in source and binary forms, with or without modification, are permitted provided that 
 *  the following conditions are met:
 *  
 *  Redistributions of source code must retain the above copyright notice, this list of conditions and the following 
 *  disclaimer.
 *  
 *  Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following 
 *  disclaimer in the documentation and/or other materials provided with the distribution.
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, 
 *  INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
 *  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 *  OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT 
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF 
 *  SUCH DAMAGE.
 *
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
