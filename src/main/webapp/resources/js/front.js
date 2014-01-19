/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {
   
   loadImageInfo(); 
    
   //Currently using only one hero image so no need to cycle
   /*
   setTimeout(function() {
       cycleImage();
   }, 10000);
   */
  
   $('.carousel').carousel({
     interval: false
    });
    
    
    fixTabPanes();
    
    $(".header-search .input-group").popover();
});

function initAutoComplete()
{
	$("#search-bar").geocomplete({country: 'us'});
}

function cycleImage() {
   var currentImage, nextImage;
   currentImage = $(".active-image");
   
    if($(".active-image").next("img").length > 0) {
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

            setTimeout(function() {
                cycleImage();
            }, 10000);
        });
    });
}

function loadImageInfo() {
    
    if($(".active-image").length) {
    
        var churchName = $(".active-image").attr("data-church-name");

        var churchInfo = $(".active-image").attr("data-church-location") + "&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;" + $(".active-image").attr("data-church-denomination");

        var photographerCredit = $(".active-image").attr("data-photographer-credit");

        $(".church-name").html(churchName.toUpperCase());

        $(".church-info").html(churchInfo);

        $(".photographer-credit").html(photographerCredit);

        $(".header-label").fadeTo(2000, 1);
    
    }
}

function fixTabPanes() {
 
    var curHeight, maxHeight = 0;
 
    $(".carousel-inner").each(function() {
        curHeight = parseInt($(this).height());
        console.log(curHeight);
        if(curHeight > maxHeight) {
            maxHeight = curHeight;
        }
    });
    
    maxHeight += 'px';
    
    $(".tab-pane .item").css("height",maxHeight);
    
}

