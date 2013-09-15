/*
 *  Copyright (c) 2013, Lehman Technolog Group
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
package com.flockspring.domain.types.impl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.flockspring.domain.types.Image;

/**
 * JpaImageImpl.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
@Entity
@Table(name="IMAGE")
public class JpaImageImpl implements Image, Serializable {
    
    private static final long serialVersionUID = -579184122076964290L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="PATH")
    private String path;
    
    @Column(name="ALT_TEXT")
    private String altText;
    
    @Column(name="TITLE_TEXT")
    private String titleText;
    
    @Column(name="EXTENSION")
    private String extension;
    
    @Column(name="WIDTH")
    private int width;
    
    @Column(name="HEIGHT")
    private int height;
    
    @Column(name="PRIMARY_IMAGE")
    private boolean primary;

    @Override
    public long getId()
    {
        return id;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String getPath()
    {
        return path;
    }

    @Override
    public String getAltText()
    {
        return altText;
    }

    @Override
    public String getTitleText()
    {
        return titleText;
    }

    @Override
    public String getExtension()
    {
        return extension;
    }

    @Override
    public int getWidth()
    {
        return width;
    }

    @Override
    public int getHeight()
    {
        return height;
    }

    @Override
    public boolean isPrimary()
    {
        return primary;
    }
    
    public void setId(long id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public void setAltText(String altText)
    {
        this.altText = altText;
    }

    public void setTitleText(String titleText)
    {
        this.titleText = titleText;
    }

    public void setExtension(String extension)
    {
        this.extension = extension;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }
    
    public void setPrimary(boolean primary)
    {
        this.primary = primary;
    }

    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object that)
    {
        return EqualsBuilder.reflectionEquals(this, that);
    }
}
