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

import com.flockspring.domain.types.impl.AddressImpl;

/**
 * MapQuestAddressHttpMessageConverter.java
 *
 * @author Justen L. Britain
 * @date Aug 3, 2013
 *
 */
@Component("mapQuestAddressHttpMessageConverter")
public class MapQuestAddressHttpMessageConverter implements HttpMessageConverter<AddressImpl>
{

    private final XPathOperations xpathTemplate;
    
    @Autowired
    public MapQuestAddressHttpMessageConverter(final XPathOperations xpathTemplate)
    {
        this.xpathTemplate = xpathTemplate;
    }
    
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType)
    {
        return AddressImpl.class == clazz && mediaType.equals(MediaType.TEXT_XML);
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType)
    {
        return AddressImpl.class == clazz && mediaType.equals(MediaType.TEXT_XML);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes()
    {
        return Collections.singletonList(MediaType.TEXT_XML);
    }

    @Override
    public AddressImpl read(Class<? extends AddressImpl> clazz, HttpInputMessage message) throws IOException,
            HttpMessageNotReadableException
    {
        Source messageXml = new SourceHttpMessageConverter<Source>().read(Source.class, message);

        return xpathTemplate.evaluateAsObject("//displayLatLng", messageXml, new NodeMapper<AddressImpl>() {
            @Override
            public AddressImpl mapNode(Node node, int nodeNum) throws DOMException
            {
                Element element = (Element) node;
                
                double latitiude = 0;
                double longitude = 0;
                
                switch(node.getNodeName().toLowerCase())
                {
                    case "lat" : latitiude = Double.valueOf(element.getNodeValue());
                        break;
                        
                    case "lng" : longitude = Double.valueOf(element.getNodeValue());
                        break;
                        
                    default:
                        //ignore                        
                }
                
                return new AddressImpl(new Long(nodeNum), "", "", "", "", "", "", longitude, latitiude);
            }
        });
    }

    @Override
    public void write(AddressImpl arg0, MediaType arg1, HttpOutputMessage arg2) throws IOException, HttpMessageNotWritableException
    {
        // TODO Auto-generated method stub
        
    }

}
