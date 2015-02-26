/**
 *
 *   Copyright 2015 Justen L. Britain
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 **/
package com.ofafeather.ui.model;

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

    private final NavigableSet<ChurchListingUIModel> churchListings;
    private final int currentPage;
    private final long totalNumberOfResults;
    private final int pageStartIndex;
    private final int pageEndIndex;
    private final int totalNumberOfPages;
    private final double searchLatitude;
    private final double searchLongitude;
    private final String userInputQuery;

    public SearchResultsUIModel(NavigableSet<ChurchListingUIModel> items, int currentPage, long totalNumberOfResults, 
            int pageStartIndex, int pageEndIndex, double searchLatitude, double searchLongitude, String userInputQuery,
            int totalNumberOfPages)
    {
        this.churchListings = items;
        this.currentPage = currentPage;
        this.totalNumberOfResults = totalNumberOfResults;
        this.pageStartIndex = pageStartIndex;
        this.pageEndIndex = pageEndIndex;
        this.searchLatitude = searchLatitude;
        this.searchLongitude = searchLongitude;
        this.userInputQuery = userInputQuery;
        this.totalNumberOfPages = totalNumberOfPages;
    }

    public NavigableSet<ChurchListingUIModel> getChurchListings()
    {
        return churchListings;
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
    
    public String getUserInputQuery(){
        return userInputQuery;
    }
    
    public int getTotalNumberOfPages()
    {
        return totalNumberOfPages;
    }
}
