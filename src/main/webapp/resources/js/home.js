/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function cycleImage() {
    
    var currentImage, nextImage;
    currentImage = $(".active-image");

    if ($(".active-image").next("img").length > 0) {
        nextImage = $(".active-image").next("img");
    }
    else {
        nextImage = $(".header-image-container img:first-child");
    }

    $(".header-label").fadeTo(1000, 0, function() {

        currentImage.fadeTo(2500, .01);
        nextImage.css("z-index", -1);
        currentImage.css("z-index", -2);
        nextImage.fadeTo(2000, 1, function() {
            currentImage.removeClass("active-image");
            nextImage.addClass("active-image");

            loadImageInfo();

            setTimeout(function() {cycleImage();}, 10000);
        });
    });
}

function loadImageInfo() {

    var churchName = $(".active-image").attr("data-church-name");

    var churchInfo = $(".active-image").attr("data-church-location") + "&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;" + $(".active-image").attr("data-church-denomination");

    var photographerCredit = $(".active-image").attr("data-photographer-credit");

    $(".church-name").html(churchName.toUpperCase());

    $(".church-info").html(churchInfo);

    $(".photographer-credit").html(photographerCredit);

    $(".header-label").fadeTo(2000, 1);

}

function fixTabPanes() {
 
    var curHeight, maxHeight = 0;
 
    $(".tab-pane").each(function() {
        curHeight = parseInt($(this).height());
        if(curHeight > maxHeight) {
            maxHeight = curHeight;
        }
    });
    
    maxHeight += 'px';
    
    $(".tab-pane .item").css("height",maxHeight);
    
}

function initializeFeaturedLocations() {
    
    $(".featured-location").mouseenter(function() {
        $(this).toggleClass("featured-location-hover");
        $(this).children(".featured-location-info").stop().fadeTo(600, 1);
    });

    $(".featured-location").mouseleave(function() {
        $(this).toggleClass("featured-location-hover");
        $(this).children(".featured-location-info").stop().fadeTo(200, 0.02);
    });
    
}

$(document).ready(function() {
    
    loadImageInfo();

    setTimeout(function() {cycleImage();}, 10000);
    
    $('.carousel').carousel({
        interval: false
    });

    $(".featured-church-programs ul li").prepend('<span class="glyphicon glyphicon-ok"></span>');

    initializeFeaturedLocations();
    
    fixTabPanes();

    //initializeSearchBar();

});

var enterPressCount = 0;

function initializeSearchBar() {
    
    $(function() {
        $(".search-bar").keypress(function (e) {
            if ((e.which && e.which == 13) || (e.keyCode && e.keyCode == 13)) {
                enterPressCount++;
                if(enterPressCount > 1) {
                    $('#searchButton').click();
                }
                return false;
            } else {
                return true;
            }
        });
    });
    
    $('#searchButton').click(function() {
        if($(".search-bar").val() != "") {
            $("#searchForm").submit();
        }
    });
}


