/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


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
   
    initializeResults();

    initializeFavorites();

    paginate(10);
    
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
           min: 1,
           max: 10,
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
        searchResultsPane.parent().append('<img class="ajax-loader" src="images/ajax-loader.gif" style="left: ' + leftPosition + 'px; top: ' + topPosition + 'px" />');
        $(".ajax-loader").fadeTo(1000, 1);
    }
    
    paginate(10);

}

function initializeResults() {

    var i, e;

    var count = 2;

    for (i = 0; i < 20; i++) {
        e = $(".search-result-entry.first-entry").clone();

        e.attr("data-result-id", count);

        e.attr("data-latitude", parseFloat(e.attr("data-latitude")) + (-0.5 + Math.random()) * 0.1);

        e.attr("data-longitude", parseFloat(e.attr("data-longitude")) + (-0.5 + Math.random()) * 0.1);

        e.appendTo(".search-results");

        e.removeClass("first-entry");

        count++;

    }
    
    $(".search-result-entry").each(function() {
        $(this).attr("calc-distance", calculateDistance($(this).attr("data-latitude"), $(this).attr("data-longitude")));
    });

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

        initializeMap();

        //$(window).scrollTo('.first-entry');
        
        fixFooter();

    }
}


function calculateDistance(lat, long) {
    
    return 1.25;
    
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
   
    updateMap();
    
    fixFooter();
    
}

function fixTabPanes() {
 
    $("#moreProgramsModal .tab-pane").css('height','260px');
    $("#languagesModal .tab-pane").css('height','425px');
}


var map;

var marker = new Array();

function initializeMap() {
    
  $("#map-canvas").height($(".left-column").width()); 
    
   
    
  updateMap();
  
}

function updateMap() {
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

        var lat, long, churchName, markerLatLong, markerId, delay = 100; 

        lat = $(this).attr("data-latitude");

        long = $(this).attr("data-longitude");

        churchName = $(this).attr("data-church-name");

        markerId = $(this).attr("data-result-id");

        markerLatLong = new google.maps.LatLng(lat, long);
              
        setTimeout(function() {
            
            createMarker(markerId, markerLatLong, churchName, google.maps.Animation.DROP, 'images/base_marker_small.png');
        
        }, i * delay);
        
    });
    

    $(".search-result-entry").mouseenter(function() {
         
        var markerNumber = parseInt($(this).attr("data-result-id"));
        marker[markerNumber].setIcon('images/green_marker_small.png');
        
    });

    $(".search-result-entry").mouseleave(function() {
        var markerNumber = parseInt($(this).attr("data-result-id"));
        marker[markerNumber].setIcon('images/base_marker_small.png');

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

function fixFooter() {
    
    var windowHeight = $(window).height();
    
    var mainContainerHeight = $(".main").height();
    
    var footerHeight = $(".footer").height();
    
    var newFillerHeight = windowHeight - mainContainerHeight + 150;
    
    if(newFillerHeight > 0) {
        newFillerHeight += "px";
        $(".filler").height(newFillerHeight);
    }
    
}