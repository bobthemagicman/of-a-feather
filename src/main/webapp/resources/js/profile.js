
$(document).ready(function() {
   
    initializeCarousels();
   
    initializeSliders();
   
    initializeVideoThumbnails();
    
});

function initializeSliders() {
    
    $(".slider").each(function() {
        var sliderValue = $(this).attr("data-slider-value");
        $(this).slider({ 
           disabled: true,
           min: 0.8,
           max: 10.4,
           step: 0.1,
           value: sliderValue
        });
        var sliderDescription = $(this).attr("data-slider-description");
        $(this).children(".slider-description").html(sliderDescription);
    });
    
}

function initializeCarousels() {
    
    $(".carousel").carousel({'interval': false});
   
   $("[data-slide='next']").click(function() {
      $(this).parent(".carousel").carousel('next'); 
   });
   
   $("[data-slide='prev']").click(function() {
      $(this).parent(".carousel").carousel('prev'); 
   });
   
   $(".thumbnails-carousel .thumbnail-container:not(.video) img").click(function() {
       
       $(".media-carousel-container").show();
    
        $(".video-player-container").css('display','none');
    
        $("#videoPlayer").remove();
        
       var slideNumber = parseInt($(this).attr("data-slide-link"));
       $(".media-carousel").carousel(slideNumber);
   });
   
   $(".thumbnail-container.video img").click(function() {
       var videoCode = $(this).attr("data-video-code");
       var videoType = $(this).attr("data-video-type");
       initializeVideo(videoType, videoCode);
   });
   
}

var map;

var marker;

function initializeMap() {
    
  var lat, long;
  
  lat = $(".profile").attr("data-latitude");
  long = $(".profile").attr("data-longitude");
    
  var mapOptions = {
    zoom: 11,
    center: new google.maps.LatLng(lat, long),
    mapTypeId: google.maps.MapTypeId.ROADMAP
  };
  map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);
      
  placeMarker();
  
}

function placeMarker() {

    var lat, long, churchName, markerLatLong;

    lat = $(".profile").attr("data-latitude");

    long = $(".profile").attr("data-longitude");

    churchName = $(".profile").attr("data-church-name");

    markerLatLong = new google.maps.LatLng(lat, long);

    createMarker(markerLatLong, churchName, google.maps.Animation.DROP, 'http://ofafeather-testing.appwebmasters.com/images/base_marker_small.png');
 
}

function createMarker(latitudeLongitude, markerTitle, markerAnimation, markerIcon) {
    
    marker = new google.maps.Marker({
        position: latitudeLongitude,
        map: map,
        title: markerTitle,
        animation: markerAnimation,
        icon: markerIcon
     });    
}

function initializeVideo(VT, VC) {
    
    $(".media-carousel-container").hide();
    
    $(".video-player-container").show();
    
     var player;
     
     $("#videoPlayer").remove();
     
     $(".video-player-container").append('<div id="videoPlayer"></div>');
     
      if(VT === 'YT') {
        player = new YT.Player('videoPlayer', {
          height: $(".video-player-container").height(),
          width: $(".video-player-container").width(),
          videoId: VC
        });
      }
}

function initializeVideoThumbnails() {
    
    $(".thumbnail-container.video img").each(function() {
        
        var thumbnailImageURL = 'http://img.youtube.com/vi/' + $(this).attr('data-video-code') + '/sddefault.jpg';
        
        $(this).attr('src', thumbnailImageURL);
        
    });
}