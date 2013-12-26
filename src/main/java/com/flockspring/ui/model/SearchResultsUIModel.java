/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

import java.util.NavigableSet;

/**
 * SearchItemsUIModel.java
 *
 * @author Justen L. Britain
 * @date Dec 19, 2013
 *
 */
public class SearchResultsUIModel
{

    private final NavigableSet<SearchResultUIModel> items;
    private final int currentPage;
    private final long totalNumberOfResults;
    private final int pageStartIndex;
    private final int pageEndIndex;
    private final double searchLatitude;
    private final double searchLongitude;

    public SearchResultsUIModel(NavigableSet<SearchResultUIModel> items, int currentPage, long totalNumberOfResults, 
            int pageStartIndex, int pageEndIndex, double searchLatitude, double searchLongitude)
    {
        this.items = items;
        this.currentPage = currentPage;
        this.totalNumberOfResults = totalNumberOfResults;
        this.pageStartIndex = pageStartIndex;
        this.pageEndIndex = pageEndIndex;
        this.searchLatitude = searchLatitude;
        this.searchLongitude = searchLongitude;
    }

    public NavigableSet<SearchResultUIModel> getItems()
    {
        return items;
    }

    public int getCurrentPage()
    {
        return currentPage;
    }

    public long getTotalNumberOfResults()
    {
        return totalNumberOfResults;
    }

    public int getPageStartIndex()
    {
        return pageStartIndex;
    }

    public int getPageEndIndex()
    {
        return pageEndIndex;
    }

    public double getSearchLatitude()
    {
        return searchLatitude;
    }

    public double getSearchLongitude()
    {
        return searchLongitude;
    }
}
