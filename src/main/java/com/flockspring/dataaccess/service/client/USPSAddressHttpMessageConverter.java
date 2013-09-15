/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.service.client;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.xml.xpath.NodeMapper;
import org.springframework.xml.xpath.XPathOperations;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.flockspring.domain.types.Address;
import com.flockspring.domain.types.impl.AddressImpl;

/**
 * USPSCityStateResponseHttpMessageConverter.java
 *
 * @author Justen L. Britain
 * @date Aug 3, 2013
 *
 */
@Component("uspsAddressHttpMessageConverter")
public class USPSAddressHttpMessageConverter implements HttpMessageConverter<Address>
{

    private final XPathOperations xpathTemplate;
    
    @Autowired
    public USPSAddressHttpMessageConverter(final XPathOperations xpathTemplate)
    {
        this.xpathTemplate = xpathTemplate;
    }
    
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType)
    {
        return Address.class == clazz && mediaType != null && mediaType.equals(MediaType.TEXT_XML);
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType)
    {
        return Address.class == clazz && mediaType.equals(MediaType.TEXT_XML);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes()
    {
        return Collections.singletonList(MediaType.TEXT_XML);
    }

    @Override
    public Address read(Class<? extends Address> clazz, HttpInputMessage message) throws IOException,
            HttpMessageNotReadableException
    {
        Source messageXml = new SourceHttpMessageConverter<Source>().read(Source.class, message);

        return xpathTemplate.evaluateAsObject("/", messageXml, new NodeMapper<Address>() {
            @Override
            public Address mapNode(Node node, int nodeNum) throws DOMException
            {
                Element element = (Element) node;
                
                String city = "";
                String state = "";
                String zip4 = "";
                String zip5 = "";
                String address1 = "";
                String address2 = "";
                            
                switch(node.getNodeName().toLowerCase())
                {
                    case "address1": address1 = element.getNodeValue();
                            break;
                    
                    case "address2": address2 = element.getNodeValue();
                            break;
                            
                    case "city" : city = element.getNodeValue();
                            break;
                            
                    case "state": state = element.getNodeValue();
                            break;
                            
                    case "zip5": zip5 = element.getNodeValue();
                            break;
                    
                    case "zip4": zip4 = element.getNodeValue();
                            break;
                            
                    default: throw new DOMException((short) 0, "Unknown node: " + element.getNodeName());
                }
                                
                return new AddressImpl(new Long(nodeNum), address1, address2, new StringBuilder(zip5).append("-")
                        .append(zip4).toString(), state, city, "USA", 0.0, 0.0);
            }
        });
    }

    @Override
    public void write(Address arg0, MediaType arg1, HttpOutputMessage arg2) throws IOException, HttpMessageNotWritableException
    {
        // TODO Auto-generated method stub
        
    }

}
