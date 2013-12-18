/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.controller;

import java.util.NavigableSet;

import com.flockspring.domain.types.Organization;

/**
 * SearchResults.java
 *
 * @author Justen L. Britain
 * @date Dec 16, 2013
 *
 */
public class SearchResults
{
    NavigableSet<Organization> organizations;
    int totalNumberOfResults;
    int currentPage;
    int currentStartResultNum;
}
