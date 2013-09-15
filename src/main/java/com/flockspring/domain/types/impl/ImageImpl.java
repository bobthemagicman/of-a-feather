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

import com.flockspring.domain.types.Image;

/**
 * ImageImpl.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public class ImageImpl implements Image, Serializable 
{
    
    private static final long serialVersionUID = 4341636298330964999L;

    private String name;
    private String path;
    private String alt;
    private String title;
    private String extension;
    
    private int id;
    private int width;
    private int height;
    
    @Override
    public String getAltText()
    {

        return alt;
    }

    @Override
    public String getTitleText()
    {
       
        return title;
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
    public String getPath()
    {
       
        return path;
    }

    @Override
    public String getName()
    {
       
        return name;
    }

    @Override
    public long getId()
    {
       
        return id;
    }

    @Override
    public boolean isPrimary()
    {
        // TODO Auto-generated method stub
        return false;
    }
}
