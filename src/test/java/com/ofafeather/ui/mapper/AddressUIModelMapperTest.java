/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.ofafeather.ui.mapper;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ofafeather.config.TestSocialConfig;
import com.ofafeather.config.TestWebConfig;
import com.ofafeather.domain.types.Address;
import com.ofafeather.domain.types.impl.AddressImpl.AddressBuilder;
import com.ofafeather.ui.config.SecurityConfig;
import com.ofafeather.ui.config.WebappConfig;
import com.ofafeather.ui.model.AddressUIModel;

/**
 * AddressUIModelMapperTest.java
 *
 * @author Justen L. Britain
 * @date Jul 5, 2014
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestWebConfig.class, TestSocialConfig.class, SecurityConfig.class, WebappConfig.class})
@WebAppConfiguration
@ActiveProfiles("test")
public class AddressUIModelMapperTest
{


    private static final String CITY = "";
    private static final String STATE = "";
    private static final String POSTAL = "";
    private static final String COUNTRY = "";
    private static final String STREET1 = "";
    private static final String STREET2 = "";
    
    private static final double LONGITUDE = 41.12354;
    private static final double LATITUDE = 49.01565;
    private static final double[] LOCATION = new double[] {LATITUDE, LONGITUDE};
    
    private Address address;
    private AddressUIModelMapper mapper;
    
    @Before
    public void setup()
    {
        address = new AddressBuilder()
                .withCity(CITY)
                .withCountry(COUNTRY)
                .withLocation(LOCATION)
                .withPostalCode(POSTAL)
                .withState(STATE)
                .withStreet1(STREET1)
                .withStreet2(STREET2)
                .build();
        
        mapper = new AddressUIModelMapper();
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void testAllValuesOfAddressAreCorrectlyConverted()
    {
        AddressUIModel mappedAddress = mapper.map(address);
        
        assertThat(mappedAddress, allOf(
                hasProperty("city", equalTo(CITY)),
                hasProperty("state", equalTo(STATE)),
                hasProperty("postalCode", equalTo(POSTAL)),
                hasProperty("country", equalTo(COUNTRY)),
                hasProperty("street1", equalTo(STREET1)),
                hasProperty("street2", equalTo(STREET2)),
                hasProperty("latitude", equalTo(LATITUDE)),
                hasProperty("longitude", equalTo(LONGITUDE))
                ));
    }

    @Test
    public void testMapperHandlesNullParameter()
    {
        AddressUIModel mappedAddress = mapper.map(null);
        
        assertThat(mappedAddress, is(nullValue()));
    }
}
