/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.ofafeather.domain.builder;

import com.ofafeather.domain.types.impl.AddressImpl;

/**
 * AddressBuilder.java
 *
 * @author Justen L. Britain
 * @date Jul 6, 2014
 *
 */
public class TestAddress extends AddressImpl.AddressBuilder
{
    public TestAddress()
    {
        super.street1 = "Street 1: 123456 3rd Street";
        super.street2 = "";
        super.postalCode = "98004";
        super.state = "WA";
        super.city = "Bellevue";
        super.country = "United States";
        super.location = new double[] {47.612726, -122.204054};
    }
}
