/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var resultsPerPage = 2;

$(document).ready(function() {

    initializeSearchPage();

    $(".map-buttons img").click(function(event) {
        event.stopPropagation();
        expandCollapseMap();
    });


});


function initializeSearchPage() {

    initializeUserSliders();

    initializeInfoSliders();

    initializeSearchElements();

    initializeTooltips();

    initializeFavorites();

    initializeFilterFunctions();

    paginate(resultsPerPage);

}

function initializeFilterFunctions() {

    $(".filter input").change(function() {
        filterRequest();
    });

    $(".slider-filter").on("slidechange", function(event, ui) {
        filterRequest();
    });

}

function initializeUserSliders() {

    $(".slider-tooltip").fadeTo('slow',.01);

    $(".slider").slider({range: true, min: -500, max: 500, values: [-500,500]});

    $( ".slider" ).on( "slide", function( event, ui ) {

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
    var tooltipElement = $(".adult-education");

    tooltipElement.attr("data-toggle","tooltip");
    tooltipElement.attr("title","non-spiritual, life skills, financial, etc.");
    tooltipElement.tooltip({'placement': 'right'});
}

function initializeFavorites() {
    $(".favorite-icon").click(function() {
       $(this).toggleClass("favorited");
    });
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
    
    placeMarkers();

}

function fixTabPanes() {

    $("#moreProgramsModal .tab-pane").css('height','260px');
    $("#languagesModal .tab-pane").css('height','425px');
}


var map;

var marker = new Array();

function initializeMap() {

  $("#map-canvas").height($(".left-column").width());

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

    marker = new Array();
    
}

function placeMarkers() {

    $(".search-result-entry.show-result").each(function(i) {
        //cycle through visible search result entries, creating map markers as necessary
        
        if(typeof marker[$(this).attr("data-result-id")] == 'undefined') { 

            var lat, long, churchName, markerLatLong, markerId, delay = 100;

            lat = $(this).attr("data-latitude");

            long = $(this).attr("data-longitude");

            churchName = $(this).attr("data-church-name");

            markerId = $(this).attr("data-result-id");

            markerLatLong = new google.maps.LatLng(lat, long);

            setTimeout(function() {

                createMarker(markerId, markerLatLong, churchName, google.maps.Animation.DROP, resourceBaseURL + 'images/site/base_marker_small.png');

            }, i * delay);
            
        }
        
    });

    for(var index in marker) {
        //cycle through markers, delete the ones that should be removed
        
        if(!$(".search-result-entry.show-result[data-result-id='" + index + "']").length) {
            
            marker[index].setMap(null);
            
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

    var searchResultTemplate = '<div class="search-result-entry show-result" data-result-id="{{id}}" data-current-result="true" data-church-name="{{organizationName}}" data-latitude="{{latitude}}" data-longitude="{{longitude}}"> <div class="search-result-image-container"> <img src="' + resourceBaseURL + 'church-images/{{id}}/{{displayImage.path}}" alt="{{displayImage.alt}}" title="{{displayImage.title}}" /> </div> <div class="search-result-info"> <div class="church-basic-info"> <a href="/church-profile/{{id}}?dist={{distanceFromSearchPoint}}"><span class="church-name">{{organizationName}}</span></a> <span class="church-denomination">{{denomination}}</span> <span class="church-location">{{city}}, {{state}} {{postalCode}} <img src="' + resourceBaseURL + 'images/site/right_arrow.png" /> <span class="distance">{{distanceFromSearchPoint}}</span> miles away </span> </div> <div class="church-sliders"> <div class="slider-container"> <div class="slider-label">Service Style</div> <div class="info-slider" data-slider-value="{{serviceStyleSliderValue}}"></div> </div> <div class="slider-container"> <div class="slider-label">Music</div> <div class="info-slider" data-slider-value="{{musicStyleSliderValue}}"></div> </div> <div class="slider-container"> <div class="slider-label">Dress Attire</div> <div class="info-slider" data-slider-value="{{dressAttireSliderValue}}"></div> </div> </div> </div> <div class="favorite-icon"> <img src="' + resourceBaseURL + 'images/site/heart_icon.png" /> </div> </div>';

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
        
        for(i = 0; i < filterResult.organizations.items.length; i++) {

            var existingResult = $(".search-result-entry[data-result-id='" + filterResult.organizations.items[i].id + "']");

            if(!existingResult.length) {

                var nodeForInsertion = $(".search-result-entry").filter(function() {
                   return $(this).find(".distance").html() < filterResult.organizations.items[i].distanceFromSearchPoint; 
                });

                //$(".search-results").append(generateSearchResultEntry(filterResult.organizations.items[i]));

                nodeForInsertion = nodeForInsertion.last();

                if(nodeForInsertion.length === 0) {
                    $(".search-results").prepend(generateSearchResultEntry(filterResult.organizations.items[i]));
                }
                else {
                    nodeForInsertion.after(generateSearchResultEntry(filterResult.organizations.items[i]));
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
}

function noResults() {
    $(".search-result-entry").remove();
    $(".results-message").html("Sorry!<br />We were unable to find any results matching your criteria.<br />Please try broadening your search.");
    $(".results-message").show();
    $(".pagination").hide();
    $(".showing-results").hide();
}

function filterRequest() {

    $.ajaxSetup({ scriptCharset: "utf-8" , contentType: "application/json; charset=utf-8"});

    var searchFilterRequest = "search/ajax/filter-results";

    var json = constructJSON();

    $.ajax({
        url: searchFilterRequest,
        data: JSON.stringify(json),
        type: "POST",

        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
        },
        success: function(data) {
            console.log(JSON.stringify(data));
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

Number.prototype.round = function(places) {
  return +(Math.round(this + "e+" + places)  + "e-" + places);
};