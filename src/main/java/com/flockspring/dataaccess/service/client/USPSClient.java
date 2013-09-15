/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.service.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;

import com.flockspring.domain.types.Address;

/**
 * USPSClient.java
 * 
 * @author Justen L. Britain
 * @date Aug 3, 2013
 * 
 */
@Service
public class USPSClient
{

    private static final String ZIP_CODE = "zipCode";
    private static final String CITY = "city";
    private static final String STATE = "state";
    private static final String USER_ID = "userId";
    private static final String ADDRESS1 = "address1";
    private static final String ADDRESS2 = "address2";

    /**
     * 
     * ?API=ZipCodeLookup&XML=
     *   &lt;ZipCodeLookupRequest%20USERID="xxxxxxxxxxxx"&gt;
     *    &lt;Address&gt;
     *      &lt;Address1&gt;&lt;/Address1&gt; 
     *         &lt;Address2&gt;6406 Ivy Lane&lt;/Address2&gt;
     *         &lt;City&gt;Greenbelt&lt;/City&gt;
     *         &lt;State&gt; MD&lt;/State&gt;
     *      &lt;/Address&gt;
     *    &lt;/ZipCodeLookupRequest&gt;
     */
    private static final String zipCodeLookupRequestXMLQueryString = new StringBuilder("?API=ZipCodeLookup&XML=<ZipCodeLookupRequest%20USERID=\"{")
            .append(USER_ID).append("}\"><Address><Address1>{").append(ADDRESS1).append("}</Address1><Address2>{").append(ADDRESS2)
            .append("}></Address2><City>{").append(CITY).append("}</City><State>{").append(STATE).append("}</State></Address></ZipCodeLookupRequest>")
            .toString();
    
    private static final String zipCodeLookupApiType = "?API=ZipCodeLookup&XML=";
    
    /**
     * 
     * ?API=CityStateLookup&XML=
     *   &lt;CityStateLookupRequest%20USERID="xxxxxxxxxxxx"&gt;
     *     &lt;ZipCode ID= "0"&gt;
     *       &lt;Zip5&gt;90210&lt;/Zip5&gt;
     *     &lt;/ZipCode&gt;
     *   &lt;/CityStateLookupRequest&gt;
     */
    private static final String cityStateLookupRequestXMLQueryString = new StringBuilder("<CityStateLookupRequest%20USERID=\"{")
        .append(USER_ID).append("}\"><ZipCode%20ID=\"0\"><Zip5>{").append(ZIP_CODE).append("}</Zip5></ZipCode></CityStateLookupRequest>").toString();

    private static final String cityStateLookupApiType = "?API=CityStateLookup&XML=";
    private final RestOperations restTemplate;

    private String webServiceUrl;
    private String webServiceUserName;
    private String webServicePassword;

    @Autowired
    public USPSClient(final @Qualifier("uspsRestTemplate") RestOperations restTemplate, final @Value("${usps.api.url}") String webServiceUrl,
            final @Value("${usps.api.username}") String webServiceUserName, final @Value("${usps.api.password}") String webServicePassword)
    {
        super();

        this.restTemplate = restTemplate;
        this.webServiceUrl = webServiceUrl;
        this.webServicePassword = webServicePassword;
        this.webServiceUserName = webServiceUserName;
    }

    public Address verifyAddressInformation(String zipCode)
    {
        
        return callUSPSAPI(zipCode, "", "", "", "", cityStateLookupRequestXMLQueryString);
    }
    
    public Address verifyAddressInformation(String city, String state, String address1, String address2)
    {
        return callUSPSAPI("", city, state, address1, address2, zipCodeLookupRequestXMLQueryString);
    }
    
    private Address callUSPSAPI(String zip, String city, String state, String address1, String address2, String requestXML) throws RestClientException
    {
        StringBuilder sb = new StringBuilder(webServiceUrl);
        sb.append(requestXML);
    
        Map<String, String> parameterMap = new HashMap<String, String>(3);
        parameterMap.put(USER_ID, webServiceUserName);
        
        if(StringUtils.hasText(zip))
        {
            populateCityStateLookupParameters(parameterMap, zip);
        }
        else
        {
            populateZipCodeLookupParameters(parameterMap, city, state, address1, address2);
        }
        
        try
        {
            StringEntity se = new StringEntity(zipCodeLookupRequestXMLQueryString, HTTP.UTF_8);
            se.setContentType("text/xml");
            HttpClient httpClient = new DefaultHttpClient(); 
            HttpPost httpPost = new HttpPost(webServiceUrl + zipCodeLookupApiType); 
            httpPost.setEntity(se); 
            
            HttpResponse response = httpClient.execute(httpPost);
            
            System.out.print(response);
        } catch (UnsupportedEncodingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClientProtocolException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return restTemplate.getForObject(sb.toString(), Address.class, parameterMap);
    }

    private void populateZipCodeLookupParameters(Map<String, String> parameterMap, String city, String state, String address1, String address2)
    {
        parameterMap.put(CITY, city);
        parameterMap.put(STATE, state);
        parameterMap.put(ADDRESS1, address1);
        parameterMap.put(ADDRESS2, address2);
        
    }

    private void populateCityStateLookupParameters(Map<String, String> parameterMap, String zip)
    {
        parameterMap.put(ZIP_CODE, zip);
        
    }    
}
    