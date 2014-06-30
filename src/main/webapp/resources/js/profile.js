
var thumbnailsCarousel;

$(document).ready(function() {
   
    initializeCarousels();
    initializeSliders();
    initializeVideoThumbnails();
    initializeTooltips();
    initializeEventHandlers();
    
});

function initializeEventHandlers()
{
	$(".favorite").click(function(e){
		var self = this;
		var churchId = $(this).data("church-id");
		var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
    
		$.ajax({
		    beforeSend: function(xhr) {
                xhr.setRequestHeader(header, token);
            },
		    url: requestBaseUrl + 'user/ajax/favorite/' + churchId,
            type: "PUT",
            success: function(data) {
                var self = this;
                alert(this);
            }
        });
		
		e.preventDefault();
	});
}

function initializeTooltips() {
    $(".has-tooltip").tooltip({'placement': 'top'});
}

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
   
   thumbnailsCarousel = $(".elastislide-list").elastislide();
   
   $("[data-slide='next']").click(function() {
      $(this).parent(".carousel").carousel('next'); 
   });
   
   $("[data-slide='prev']").click(function() {
      $(this).parent(".carousel").carousel('prev'); 
   });
   
   $(".media-carousel").on('slid.bs.carousel', function () {
       var currentImage = $(this).find(".item.active").index();
       
       thumbnailsCarousel.setCurrent(currentImage);
       
       //$(".media-icons-container").carousel(thumbnailPage);
       
       //$("#videoPlayer").remove();
       //$(".video-placeholder").show();
       
   });
   
   $(".elastislide-list li.photo").click(function() {
       
       var slideNumber = parseInt($(this).attr("data-slide-link"));
       
       $(".media-carousel").carousel(slideNumber);
       
   });
   
   
   $(".video-placeholder").click(function() {
       initializeVideo();
   });
   
   $(".video-thumb").click(function() {
       var slideNumber = parseInt($(this).attr("data-slide-link"));
       $(".media-carousel").carousel(slideNumber);
       setTimeout(function() {
           initializeVideo();
       }, 1000);
   });
   
}

var map;

var marker;

function initializeMap() {
   
  $("#search-bar").geocomplete({country: 'us'});  
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

    createMarker(markerLatLong, churchName, google.maps.Animation.DROP, resourceBaseURL + 'images/site/base_marker_small.png');
 
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

function initializeVideo() {
    
    if($("#youTubeCode").length === 0) {
        var script   = document.createElement("script");
        script.type  = "text/javascript";
        script.src   = "https://www.youtube.com/iframe_api";
        script.id    = "youTubeCode";
        document.body.appendChild(script);
    }
    else {
        playVideo();
    }
    
}

function onYouTubeIframeAPIReady() {
    playVideo();
}

function playVideo() {
    $("#videoPlayer").remove();
    
    var VC = $(".media-carousel .item.active .video-placeholder").attr("data-video-code");
    var width = parseInt($(".media-carousel").width());
    var height = parseInt($(".media-carousel").height());
    $(".media-carousel .item.active .video-placeholder").hide();
    $(".media-carousel .item.active").append('<iframe id="videoPlayer" type="text/html" width="'+width+'" height="'+height+'" src="http://www.youtube.com/embed/'+VC+'?enablejsapi=1&wmode=transparent" frameborder="0"></iframe>');
    
    /*
    player = new YT.Player('videoPlayer', {
          height: $(".media-carousel").height(),
          width: $(".media-carousel").width(),
          wmode: 'transparent',
          videoId: VC
    });
    */
    
}

function initializeVideoThumbnails() {
    
    $(".video-thumb, .video-placeholder").each(function() {
        
        var thumbnailImageURL = 'http://img.youtube.com/vi/' + $(this).attr('data-video-code') + '/sddefault.jpg';
        
        $(this).append('<img src="' + thumbnailImageURL + '" /><div class="play-button"></div>');      
    });
    
}