/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.service.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import com.flockspring.domain.types.Address;
import com.flockspring.domain.types.impl.AddressImpl;

/**
 * MapQuestClient.java
 *
 * @author Justen L. Britain
 * @date Aug 24, 2013
 *
 */
@Service
public class MapQuestServiceClient
{
    private final static String MAX_RESULTS = "maxResults";
    private final static String THUMB_MAPS = "thumbMaps";
    private final static String OUT_FORMAT = "outFormat";
    private final static String ADDRESS_QUERY = "location";
        
    private final RestOperations restTemplate;
    private final int defaultMaxResults;
    
    private String webServiceUrl;
    private String webServiceKey;
    
    /**
     * /geocoding/v1/address?key={key}&outFormat={outFormat}&inFormat={inFormat}&{inFormat}=
     * &lt;address&gt;
     *   &lt;location&gt;
     *     &lt;street&gt;Lancaster,PA&lt;/street&gt;
     *   &lt;/location&gt;
     *   &lt;options&gt;
     *     &lt;thumbMaps&gt;false&lt;/thumbMaps&gt;
     *     &lt;maxResults&gt;1&lt;/maxResults&gt;
     *   &lt;/options&gt;
     * &lt;/address&gt; 
     */    
    private String geocodingPathRequestXmlQueryString = new StringBuilder("&outFormat={").append(OUT_FORMAT).append("}&inFormat=xml&xml=<address><location><street>{")
            .append(ADDRESS_QUERY).append("}</street></location><options><thumbMaps>{").append(THUMB_MAPS)
            .append("}</thumbMaps><maxResults>{").append(MAX_RESULTS).append("}</maxResults></options></address>").toString();
    
        
    private enum OutFormatType
    {
        JSON, XML, CSV;
    }
    
    @Autowired
    public MapQuestServiceClient(@Qualifier("mapQuestRestTemplate") final RestOperations restTemplate, 
            @Value("${mapquest.api.url}") final String webServiceUrl, @Value("${mapquest.api.app.key}") final String webServiceKey, 
            @Value("${mapquest.api.maxResults}") final int defaultMaxResults)
    {
        super();
        
        this.restTemplate = restTemplate;
        this.webServiceUrl = webServiceUrl;
        this.webServiceKey = webServiceKey;
        
        this.defaultMaxResults = defaultMaxResults;
    }

    public Address getAddressGeoCode(Address address)
    {

        return getAddressGeoCode(address, defaultMaxResults);
    }
    
    public Address getAddressGeoCode(final Address address, final int maxResults)
    {
        AddressImpl addressWithLatLng = callMapQuestGeoCodingAPI(verifyMaxResultsValueAndConvertToString(maxResults), String.valueOf(true), 
                formatAddressQuery(address));
        
        return new AddressImpl(address.getId(), address.getStreet1(), address.getStreet2(), address.getPostalCode(), address.getState(), 
                address.getCity(), address.getCountry(), addressWithLatLng.getLongitude(), addressWithLatLng.getLatitude());
    }

    private String formatAddressQuery(Address address)
    {
        StringBuilder addressQuery = new StringBuilder(address.getStreet1()).append(" ").append(address.getStreet2())
                .append(address.getCity()).append(", ").append(address.getState()).append(" ").append(address.getPostalCode());
        
        return addressQuery.toString();
    }

    private String verifyMaxResultsValueAndConvertToString(int maxResults)
    {
        if(maxResults <= 0)
        {
            return String.valueOf(defaultMaxResults);
        }
        
        return String.valueOf(maxResults);
    }
    
    private AddressImpl callMapQuestGeoCodingAPI(String maxResults, String thumbMaps, String addressQuery)
    {

        StringBuilder sb = new StringBuilder(webServiceUrl);
        sb.append(geocodingPathRequestXmlQueryString);

        List<NameValuePair> params = getGeoCodingRequestParameters(maxResults, String.valueOf(false), 
                OutFormatType.XML.name().toLowerCase(), addressQuery);
                
        try
        {
            String query = new StringBuilder("key=Fmjtd%7Cluub250rnq%2C85%3Do5-9u8wq0&").append(URLEncodedUtils.format(params, "UTF-8")).toString();
            URI uri = URIUtils.createURI("http", webServiceUrl, -1, "geocoding/v1/address", query, null);
            return restTemplate.getForObject(uri, AddressImpl.class);
        } catch (URISyntaxException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
    }

    private List<NameValuePair> getGeoCodingRequestParameters(String maxResults, String thumbMaps, String outFormat, String addressQuery)
    {
        List<NameValuePair> paramsList = new ArrayList<NameValuePair>(4);
        paramsList.add(new BasicNameValuePair(MAX_RESULTS, maxResults));
        paramsList.add(new BasicNameValuePair(THUMB_MAPS, thumbMaps));
        paramsList.add(new BasicNameValuePair(OUT_FORMAT, outFormat));
        paramsList.add(new BasicNameValuePair(ADDRESS_QUERY, addressQuery));

        return paramsList;
    }
}
