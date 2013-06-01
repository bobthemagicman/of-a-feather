/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

/**
 * ReligionUIModel.java
 *
 * @author Justen L. Britain
 * @date May 18, 2013
 *
 */
public class ReligionUIModel {

    private final int id;
    private final String name;
    
    //List<Denomination> denominations;

    public ReligionUIModel(final int id, final String name) {
        super();
    
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
