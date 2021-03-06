/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var resultsPerPage = 2;

var map;

var marker = new Array();

$(document).ready(function() {

    initializeSearchPage();

    $(".map-buttons img").click(function(event) {
        event.stopPropagation();
        expandCollapseMap();
    });


    if(showOutsideRegionModal) {
        $(".outside-beta-region-modal").modal("show");
        
        var options = {url : 'search/async/out-of-region-search', success: betaRegionEmailUpdateCallback}; 
        $("#email-submit-form").ajaxForm(options);
    }
    
});

function betaRegionEmailUpdateCallback()
{
    var successMessage = "<div id=\"outside-beta-region-modal-body\" class=\"modal-body\">" +
                            "<p>Thank you. Your email address has been securley stored in our database and you will be updated when we expand to your region</p>" +
                            "<button type=\"button\" class=\"btn btn-primary\">Return to Homepage</button>" +
                         "</div> ";
                         
    $("#outside-beta-region-modal-text").replaceWith(successMessage);
}

function initializeSearchPage() {

    initializeUserSliders();
    initializeInfoSliders();
    initializeSearchElements();
    initializeTooltips();
    initializeFavorites();
    initializeFilterFunctions();
}

function initializeFilterFunctions() {

    $(".filter input").change(function() {
        filterRequest();
    });

    $(".slider-filter").on("slidechange", function(event, ui) {
        filterRequest();
    });

}

var sliderTips = new Array;

sliderTips[0] = new Array;
sliderTips[1] = new Array;
sliderTips[2] = new Array;

sliderTips[0][0] = 'Traditional/Reverant';
sliderTips[0][1] = 'Traditional/Reverant';
sliderTips[0][2] = ' ';
sliderTips[0][3] = ' ';
sliderTips[0][4] = ' ';
sliderTips[0][5] = 'Blend of Both';
sliderTips[0][6] = ' ';
sliderTips[0][7] = ' ';
sliderTips[0][8] = ' ';
sliderTips[0][9] = 'Lively';
sliderTips[0][10] = 'Very Lively &amp; Spirited';

sliderTips[1][0] = 'Classic Songs &amp; Sound';
sliderTips[1][1] = 'Classic Songs &amp; Sound';
sliderTips[1][2] = ' ';
sliderTips[1][3] = 'Upbeat Classics/Gospel';
sliderTips[1][4] = ' ';
sliderTips[1][5] = 'Blend of Both';
sliderTips[1][6] = ' ';
sliderTips[1][7] = 'Contemporary Sound';
sliderTips[1][8] = ' ';
sliderTips[1][9] = 'Modern Songs';
sliderTips[1][10] = 'Radically Modern';

sliderTips[2][0] = 'Sunday Best';
sliderTips[2][1] = 'Sunday Best';
sliderTips[2][2] = ' ';
sliderTips[2][3] = 'Business Casual';
sliderTips[2][4] = ' ';
sliderTips[2][5] = 'Blend of Both';
sliderTips[2][6] = ' ';
sliderTips[2][7] = 'Smart Casual';
sliderTips[2][8] = ' ';
sliderTips[2][9] = ' ';
sliderTips[2][10] = 'Day at the Beach';

function initializeUserSliders() {

    $(".slider-tooltip").fadeTo('slow',.01);

    $(".slider").each(function() {
       var initMinValue = $(this).attr("data-min");
       var initMaxValue = $(this).attr("data-max");
       
       if(initMinValue >= 1 && initMinValue <= 10) {
           initMinValue = unscaleSliderValue(initMinValue);
       }
       else {
           initMinValue = -500;
       }
       if(initMaxValue >= 1 && initMaxValue <= 10) {
           initMaxValue = unscaleSliderValue(initMaxValue);
       }
       else {
           initMaxValue = 500;
       }
       
       $(this).slider({range: true, min: -500, max: 500, values: [initMinValue, initMaxValue]});
    });

    $( ".slider" ).on( "slide", function( event, ui ) {

        var sliderValues = $(this).slider("values");

        var values = new Array;

        values[0] = Math.round(sliderValues[0] * (9/1000) + 5.5);

        values[1] = Math.round(sliderValues[1] * (9/1000) + 5.5);

        var assocSlider = $(this).attr('id');
        var sliderNumber;

        if(assocSlider === 'serviceStyleSlider') {
            sliderNumber = 0;
        }
        else if(assocSlider === 'musicSlider') {
            sliderNumber = 1;
        }
        else if(assocSlider === 'dressAttireSlider') {
            sliderNumber = 2;
        }

        var sliderInMotion;

        if($(this).children(".ui-slider-handle:first").hasClass('ui-state-active')) {
            sliderInMotion = 0;
        }
        else {
            sliderInMotion = 1;
        }

        toolTip = sliderTips[sliderNumber][values[sliderInMotion]];

        if(toolTip !== ' ') {

            $(".slider-tooltip[data-assoc-slider='" + assocSlider + "']").show().fadeIn().html(toolTip);

        }

    } );

    $( ".slider" ).on( "slidestop", function( event, ui ) {

        $(".slider-tooltip[data-assoc-slider='" + $(this).attr('id') + "']").fadeTo('slow',.01);

    } );

    $( ".slider" ).on( "slidestart", function( event, ui ) {

        $(".slider-tooltip[data-assoc-slider='" + $(this).attr('id') + "']").fadeTo('slow',1);

    } );

}

function initializeInfoSliders() {

    $(".info-slider").each(function() {

       var sliderValue = $(this).attr("data-slider-value");

        $(this).slider({
           disabled: true,
           range: false,
           min: 0.5,
           max: 10.45,
           step: 0.1,
           value: sliderValue
        });

    });

}

function initializeSearchElements() {

    $(".day-buttons").buttonset();

    $(".gay-affirming input").button();

    $(".checkbox-group label input[type=checkbox]").change(function() {
       $(this).parent().toggleClass("checked");
    });

    $(".panel-group .panel-heading .accordion-toggle").click(function (){
        $(".panel-group .panel-heading .accordion-toggle").removeClass("active");

        if($(this).parents(".panel-heading").siblings(".panel-collapse").hasClass("in")) {

            $(this).removeClass("active");
        }
        else {
            $(this).addClass("active");
        }

    });

    $(".panel-heading .accordion-toggle.map-toggle").click(function (){
        $(".panel-heading .accordion-toggle.map-toggle").toggleClass("active");
    });

    $(".checkbox-group input[type='checkbox']").change(function() {

        var elementId = $(this).attr("data-linked-checkbox");

        $("#" + elementId).prop('checked',$(this).prop('checked'));
        $("label[for='" + elementId + "']").toggleClass('checked');

    });

    fixTabPanes();

}

function initializeTooltips() {
    var tooltipElement = $(".adult-education-tooltip");

    tooltipElement.attr("data-toggle","tooltip");
    tooltipElement.attr("title","non-spiritual, life skills, financial, etc.");
    tooltipElement.tooltip({'placement': 'right'});
}

function initializeFavorites() {
	if(!($(".favorite").parent().is("a"))) {
        $(".favorite").click(function(e) {
    		var ele = $(this);
    		var churchId = ele.parents(".search-result-entry").data("result-id");
    		var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
            var offImgSrc = ele.parent().data("icon-off-src");
            var onImgSrc = ele.parent().data("icon-on-src");
            
    		$.ajax({
    		    beforeSend: function(xhr) {
                    xhr.setRequestHeader(header, token);
                },
    		    url: requestBaseUrl + 'user/async/favorite/' + churchId,
                type: data.currentStatusFavorite ? "DELETE" : "PUT",
                success: function(data) {
                    var self = self;
                    if(data.hasOwnProperty("asyncStatus") && data.asyncStatus == "SUCCESS" && data.hasOwnProperty("errors") && data.errors.length == 0) {
                        if(data.currentStatusFavorite) {
                            ele.attr( "src", onImgSrc);        
                        }else {
                            ele.attr( "src", offImgSrc);                        
                        }
                    }
                    
                }
            });
            
            e.preventDefault();        
        });
    }
}

function paginate(resultsPerPage) {

    var numPages = assignPages(resultsPerPage);

    if(numPages > 0) {

        var options = {
            currentPage: 1,
            totalPages: numPages,
            alignment: 'center',
            onPageClicked: function(e, originalEvent, type, page) {

                e.stopImmediatePropagation();

                var currentTarget = $(e.currentTarget);

                var pages = currentTarget.bootstrapPaginator("getPages");

                currentTarget.bootstrapPaginator("show", page);

                var pages = currentTarget.bootstrapPaginator("getPages");

                displayPage(pages.current, numPages);

            }
        };

        $('.pagination').bootstrapPaginator(options);

        displayPage(1);
        
        if(numPages === 1) {
            $(".pagination").hide();
        }
        else {
            $(".pagination").show();
        }
    }
    else {
        noResults();
    }
}



function getMaxZindex() {
    var currentZIndex = 0, maxZIndex = 0;

    $("*").each(function() {
        currentZIndex = $(this).zIndex();
        if (currentZIndex > maxZIndex) {
            maxZIndex = currentZIndex;
        }
    });
    return(maxZIndex);
}

function loadingScreenToggle() {

    var searchResultsPane = $(".search-results");

    var leftPosition = parseInt(searchResultsPane.position().left) + parseInt(searchResultsPane.width() / 2) - 64;

    var topPosition = parseInt($(window).height() / 2) - 32;

    if ($(".ajax-loader").length > 0) {
        searchResultsPane.fadeTo(1000, 1);
        $(".pagination").fadeTo(1000,1);
        $(".ajax-loader").remove();
        assignPages(10);
    }
    else {
        searchResultsPane.fadeTo(1000, 0.05);
        $(".pagination").fadeTo(1000,0.05);
        searchResultsPane.parent().append('<img class="ajax-loader" src="' + resourceBaseURL + 'images/ajax-loader.gif" style="left: ' + leftPosition + 'px; top: ' + topPosition + 'px" />');
        $(".ajax-loader").fadeTo(1000, 1);
    }

    paginate(resultsPerPage);

}

function assignPages(resultsPerPage) {

    var searchResults = $(".search-result-entry");

    var numResults = searchResults.length;

    var numPages = Math.ceil(numResults / resultsPerPage);

    var currentPage = 1, spotsRemaining = resultsPerPage;

    $(".search-result-entry").removeClass("first-entry");
    $(".search-result-entry").removeClass("last-entry");

    searchResults.each(function() {
        if(spotsRemaining === resultsPerPage) {
            $(this).addClass("first-entry");
        }
        else if(spotsRemaining === 1) {
            $(this).addClass("last-entry");
        }
        else if(spotsRemaining === 0) {
            currentPage++;
            spotsRemaining = resultsPerPage;
             $(this).addClass("first-entry");
        }

        $(this).attr("data-page-number",currentPage);


        spotsRemaining--;


    });

    return numPages;

}

function displayPage(pageToShow) {

    if(pageToShow !== $(".search-results").attr("data-current-page")) {

        $(".search-result-entry").removeClass('show-result');

        $(".search-result-entry[data-page-number=" + pageToShow + "]").addClass('show-result');

        $(".search-results").attr("data-current-page", pageToShow);

        placeMarkers();

        var firstEntry = $(".search-results .search-result-entry.show-result").first().index() + 1;
        
        var lastEntry = $(".search-results .search-result-entry.show-result").last().index() + 1;
        
        $(".now-showing").html(firstEntry + " - " + lastEntry);
        
        $(".total-results").html($(".search-result-entry").length);

        //$(window).scrollTo('.first-entry');

    }
}


function expandCollapseMap() {

    marker = [];

    var mapContainer = $(".map-container-outer, .map-container, #map-canvas");

    if($(".map-container-outer").hasClass('map-expanded')) {
        //collapse
        mapContainer.fadeOut('fast');
        $(".map-container-outer").css("position","relative").css("top",'auto').css("left",'auto');
        $(".map-container-outer").toggleClass('map-expanded');
        var newMapWidth = $(".left-column").width();
        mapContainer.css("width", newMapWidth).css("height", newMapWidth);
        mapContainer.fadeIn('fast');
        $(".search-options-panel").fadeIn('slow');
    }
    else {
        //expand
        mapContainer.fadeOut('fast');
        $(".search-options-panel").fadeOut('slow');
        var leftColumnOffset = $(".left-column").offset();
        var leftColumnWidth = $(".left-column").width();
        var newMapWidth = parseInt(leftColumnOffset.left) + parseInt(leftColumnWidth);
        newMapWidth += 'px';
        var newMapHeight = parseInt($(window).height()) - parseInt($(".navbar").height());
        mapContainer.css("width", newMapWidth).css("height", newMapHeight);
        $(".map-container-outer").css("position","fixed").css("top",$(".navbar").height()).css("left",'0px');
        $(".map-container-outer").toggleClass('map-expanded');

        mapContainer.fadeIn('fast');

    }

    createMap();
   

}

function fixTabPanes() {

    $("#moreProgramsModal .tab-pane").css('height','260px');
    $("#languagesModal .tab-pane").css('height','425px');
}




function initializeMap() {

  $("#map-canvas").height($(".left-column").width());
  $("#search-bar").geocomplete({country: 'us'});

  createMap();

}

function createMap() {
    
    var lat = $(".main").attr("data-search-latitude");
    var long = $(".main").attr("data-search-longitude");

    var mapOptions = {
        zoom: 11,
        center: new google.maps.LatLng(lat, long),
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById('map-canvas'),
            mapOptions);

    google.maps.visualRefresh = true;

    
    
    placeMarkers();
    
}

function placeMarkers() {

    $(".search-result-entry.show-result").each(function(i) {
        //cycle through visible search result entries, creating map markers as necessary
        
        if(marker.length == 0 || typeof marker[$(this).attr("data-result-id")] == 'undefined') { 

            var lat, long, churchName, markerLatLong, markerId, delay = 100;

            lat = $(this).attr("data-latitude");

            long = $(this).attr("data-longitude");

            churchName = $(this).attr("data-church-name");

            markerId = $(this).attr("data-result-id");

            markerLatLong = new google.maps.LatLng(lat, long);

            setTimeout(function() {

                if(!(markerId in marker)) {
                   
                   createMarker(markerId, markerLatLong, churchName, google.maps.Animation.DROP, resourceBaseURL + 'images/site/base_marker_small.png');

                }
                   
            }, i * delay);
            
        }
        
    });

    for(var index in marker) {
        //cycle through markers, delete the ones that should be removed
        
        if(!$(".search-result-entry.show-result[data-result-id='" + index + "']").length) {
            
            marker[index].setMap(null);
            
            marker[index] = null;
            
            delete marker[index];
        
        }
        
    }

    $(".search-result-entry.show-result").mouseenter(function() {

        var markerId = $(this).attr("data-result-id");
        marker[markerId].setIcon(resourceBaseURL + '/images/site/green_marker_small.png');

    });

    $(".search-result-entry.show-result").mouseleave(function() {
        var markerId = $(this).attr("data-result-id");
        marker[markerId].setIcon(resourceBaseURL + 'images/site/base_marker_small.png');

    });
}

function createMarker(markerId, latitudeLongitude, markerTitle, markerAnimation, markerIcon) {

    marker[markerId] = new google.maps.Marker({
        position: latitudeLongitude,
        map: map,
        title: markerTitle,
        animation: markerAnimation,
        icon: markerIcon
     });
}

function generateSearchResultEntry(item) {

    item.distanceFromSearchPoint = parseFloat(item.distanceFromSearchPoint).round(2);

    //var searchResultTemplate = '<div class="search-result-entry show-result" data-result-id="{{id}}" data-current-result="true" data-church-name="{{organizationName}}" data-latitude="{{latitude}}" data-longitude="{{longitude}}"> <div class="search-result-image-container"> <img src="' + resourceBaseURL + 'church-images/{{id}}/{{displayImage.path}}" alt="{{displayImage.alt}}" title="{{displayImage.title}}" /> </div> <div class="search-result-info"> <div class="church-basic-info"> <a href="/church-profile/{{id}}?dist={{distanceFromSearchPoint}}"><span class="church-name">{{organizationName}}</span></a> <span class="church-denomination">{{denomination}}</span> <span class="church-location">{{city}}, {{state}} {{postalCode}} <img src="' + resourceBaseURL + 'images/site/right_arrow.png" /> <span class="distance">{{distanceFromSearchPoint}}</span> miles away </span> </div> <div class="church-sliders"> <div class="slider-container"> <div class="slider-label">Service Style</div> <div class="info-slider" data-slider-value="{{serviceStyleSliderValue}}"></div> </div> <div class="slider-container"> <div class="slider-label">Music</div> <div class="info-slider" data-slider-value="{{musicStyleSliderValue}}"></div> </div> <div class="slider-container"> <div class="slider-label">Dress Attire</div> <div class="info-slider" data-slider-value="{{dressAttireSliderValue}}"></div> </div> </div> </div> <div class="favorite-icon"> <img src="' + resourceBaseURL + 'images/site/heart_icon.png" /> </div> </div>';
    var searchResultTemplate = '<div class="search-result-entry show-result" data-result-id="{{id}}" data-current-result="true" data-church-name="{{organizationName}}" data-latitude="{{latitude}}" data-longitude="{{longitude}}"> <div class="search-result-image-container"> <img src="{{displayImage.path}}" alt="{{displayImage.alt}}" title="{{displayImage.title}}" /> </div> <div class="search-result-info"> <div class="church-basic-info"> <a href="/churches/{{id}}?dist={{distanceFromSearchPoint}}"><span class="church-name">{{organizationName}}</span></a> <span class="church-denomination">{{denomination}}</span> <span class="church-location">{{city}}, {{state}} {{postalCode}} <img src="' + resourceBaseURL + 'images/site/right_arrow.png" /> <span class="distance">{{distanceFromSearchPoint}}</span> miles away </span> </div> <div class="church-sliders"> <div class="slider-container"> <div class="slider-label">Service Style</div> <div class="info-slider" data-slider-value="{{serviceStyleSliderValue}}"></div> </div> <div class="slider-container"> <div class="slider-label">Music</div> <div class="info-slider" data-slider-value="{{musicStyleSliderValue}}"></div> </div> <div class="slider-container"> <div class="slider-label">Dress Attire</div> <div class="info-slider" data-slider-value="{{dressAttireSliderValue}}"></div> </div> </div> </div> <div class="favorite-icon"> <img src="' + resourceBaseURL + 'images/site/heart_icon.png" /> </div> </div>';

    var html = Mustache.to_html(searchResultTemplate, item);

    return html;
    
}

function updateResults(filterResult) {
    //console.log(JSON.stringify(filterResult));

    $(".search-results .search-result-entry").attr("data-current-result", "false");
    
    var i;

    if(filterResult.organizations !== null) {
        $(".results-message").hide();
        $(".showing-results").show();
        $(".pagination").show();
        
        for(i = 0; i < filterResult.organizations.churchListings.length; i++) {

            if(filterResult.organizations.churchListings[i].displayImage === null) {
                var di = { "path": "http://placehold.it/200x200", "alt": "No Image Available", "title": filterResult.organizations.churchListings[i].organizationName } ;
                
                filterResult.organizations.churchListings[i].displayImage = di;
            }
            else {
                filterResult.organizations.churchListings[i].displayImage.path = resourceBaseURL + 'images/church-images/' + filterResult.organizations.churchListings[i].id + '/' + filterResult.organizations.churchListings[i].displayImage.path;
            }

            var existingResult = $(".search-result-entry[data-result-id='" + filterResult.organizations.churchListings[i].id + "']");

            if(!existingResult.length) {

                var nodeForInsertion = $(".search-result-entry").filter(function() {
                   return $(this).find(".distance").html() < filterResult.organizations.churchListings[i].distanceFromSearchPoint; 
                });

                //$(".search-results").append(generateSearchResultEntry(filterResult.organizations.churchListings[i]));

                nodeForInsertion = nodeForInsertion.last();

                if(nodeForInsertion.length === 0) {
                    $(".search-results").prepend(generateSearchResultEntry(filterResult.organizations.churchListings[i]));
                }
                else {
                    nodeForInsertion.after(generateSearchResultEntry(filterResult.organizations.churchListings[i]));
                }
            }
            else {
                existingResult.attr("data-current-result", "true");
            }
        }

        $(".search-result-entry[data-current-result='false']").remove();

        $(".main").attr("data-latitude", filterResult.organizations.searchLatitude).attr("data-longitude", filterResult.organizations.searchLongitude);

        initializeInfoSliders();

        $(".now-showing").html('1 - ' + filterResult.organizations.totalNumberOfResults);

        $(".total-results").html(filterResult.organizations.totalNumberOfResults);

        paginate(resultsPerPage);
    }
    else {
        noResults();
    }
    
    //placeMarkers();
    
}

function noResults() {
    $(".search-result-entry").remove();
    var msg = 'Sorry!<br />We were unable to find any results matching your criteria.<br />Please try broadening your search.';
    $(".results-message").html(msg);
    $(".results-message").show();
    $(".results-message").removeClass('hidden');
    $(".pagination").hide();
    $(".showing-results").hide();
    
    placeMarkers();
}

function filterRequest() {

    $.ajaxSetup({ scriptCharset: "utf-8" , contentType: "application/json; charset=utf-8"});
    var searchFilterRequest = "search/async/filter-results";
    var json = constructJSON();
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    
	$.ajax({
        url: searchFilterRequest,
        data: JSON.stringify(json),
        type: "POST",

        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.setRequestHeader(header, token);
        },
        success: function(data) {
            //console.log(JSON.stringify(data));
            updateResults(data);
        }
    });

}

function constructJSON() {

    var optionsCount, optionsString, filtersCount, firstFilter = true, jsonString = '{ ';

    var filtersArray = new Array();

    $(".filter").each(function(i) {

        var optionsArray = new Array();

        filtersArray[i] = '"' + $(this).attr("data-filter-type") + '"';

        $(this).find("label.checked input").each(function(j) {
            //read selected options from checkboxes
            optionsArray[j] = '"' + $(this).attr("data-filter-option") + '"';

        });

        $(this).find("input + label.ui-state-active").each(function(k) {
           //read selected options from JQueryUI buttons
           optionsArray[k] = '"' + $(this).prev("input").attr("data-filter-option") + '"';
        });

        var uniqueOptionsArray = new Array();
        $.each(optionsArray, function(k, el){
            if($.inArray(el, uniqueOptionsArray) === -1) uniqueOptionsArray.push(el);
        });

        optionsArray = uniqueOptionsArray;

        optionsString = '[ ';

        for(optionsCount = 0; optionsCount < optionsArray.length; optionsCount++) {
            if(optionsCount > 0) {
                optionsString += ', ';
            }
            optionsString += optionsArray[optionsCount];
        }

        optionsString += ' ]';

        if(optionsCount > 0) {
            filtersArray[i] += ': ' + optionsString;
        }
        else {
            filtersArray[i] = '';
        }

    });

    $(".slider-filter").each(function() {

        var sliderValues = $(this).slider("values");

        var sliderFloor = scaleSliderValue(sliderValues[0]);

        var sliderCeiling = scaleSliderValue(sliderValues[1]);

        filtersArray.push('"' + $(this).attr("data-filter-type") + 'Floor": ' + sliderFloor);

        filtersArray.push('"' + $(this).attr("data-filter-type") + 'Ceiling": ' + sliderCeiling);

    });

    for(filtersCount = 0; filtersCount < filtersArray.length; filtersCount++) {
        if(filtersArray[filtersCount].length > 0) {
            if(!firstFilter) {
                jsonString += ', ';
            }
            jsonString += filtersArray[filtersCount];
            firstFilter = false;
        }
    }

    jsonString += ', "location" :';
    jsonString += '[' + $(".container.main").data("search-longitude") + ',' + $(".container.main").data("search-latitude") + ']';
    jsonString += ' }';

    return JSON.parse(jsonString);

}

function scaleSliderValue(v) {
    return Math.round(v * (9/1000) + 5.5);
}

function unscaleSliderValue(v) {
    return Math.round((v - 5.5) * (1000/9));
}

Number.prototype.round = function(places) {
  return +(Math.round(this + "e+" + places)  + "e-" + places);
};