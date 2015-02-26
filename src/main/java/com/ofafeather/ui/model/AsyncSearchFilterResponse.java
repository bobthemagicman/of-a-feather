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

import java.util.Arrays;
import java.util.Collections;

import com.ofafeather.ui.model.async.AsyncError;
import com.ofafeather.ui.model.async.AsyncStatus;
import com.ofafeather.ui.model.async.BaseAsyncResponse;


/**
 * AsyncSearchFilterResponse.java
 *
 * @author Justen L. Britain
 * @date Oct 20, 2013
 *
 */
public class AsyncSearchFilterResponse extends BaseAsyncResponse
{
    private final SearchResultsUIModel searchResultUIModel;
    
    public AsyncSearchFilterResponse(SearchResultsUIModel searchResultUIModel, String successMessage)
    {
        super(Collections.<AsyncError>emptyList(), AsyncStatus.SUCCESS, successMessage);
        
        this.searchResultUIModel = searchResultUIModel;
    }
    
    public AsyncSearchFilterResponse()
    {
        super(Collections.<AsyncError>emptyList(), AsyncStatus.NO_RESULT, "No Results Found for Query");
        
        this.searchResultUIModel = null;
    }
    
    public AsyncSearchFilterResponse(AsyncError error, String errorMessage)
    {
        super(Arrays.asList(error), AsyncStatus.NO_RESULT, errorMessage);
        
        this.searchResultUIModel = null;        
    }

    public SearchResultsUIModel getOrganizations()
    {
        return searchResultUIModel;
    }
}
