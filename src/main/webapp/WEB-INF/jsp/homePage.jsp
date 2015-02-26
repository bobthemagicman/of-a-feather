<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/init.jsp"%>

<!DOCTYPE html>
<html xmlns:fb="http://ogp.me/ns/fb#">
    <head>
         <%-- Adding this to test server to prevent indexing by google --%>
     <meta name="robots" content="noindex">
    <%-- Common Metadata, scripts, and CSS --%>
        <%@ include file="/WEB-INF/jsp/partials/commonHead.jsp"%>
        
        <spring:url value="/static/js/front.js" var="frontJS" />
        <spring:url value="/static/js/jquery.geocomplete.js" var="geoCompletePlugin" />
        <script type="text/javascript">
            $LAB.queueScript("https://maps.googleapis.com/maps/api/js?libraries=places&sensor=false&callback=initAutoComplete")
                .queueScript("${geoCompletePlugin}")        
                .queueScript("${frontJS}")
                .runQueue();
        </script>

                <!--[if gte IE 9]>
                    <script>
                        .gradient-vertical-black, 
                        .gradient-horizontal-white {
                        filter: none !important;    
                        }
                    </script>
                <![endif]-->

        <title>Of A Feather - Find your new church home today</title>   
    </head>
    <body>
        <div class="page-container">
        
	        <%-- Site Header --%>
	        <%@ include file="/WEB-INF/jsp/partials/siteHeader.jsp"%>
	
	        <spring:url value="/static/images/hero/steven-hyatt-hero-1.jpg" var="heroImage1"/>
	        <spring:url value="/static/images/site/blur.png" var="blurImage" />
	
			<spring:url value="/San-Francisco-CA" var="sanFranciscoRegionLink"/>
            <spring:url value="/static/images/features/san-francisco.jpg" var="sanFrancisco"/>
            
            <spring:url value="Hayward" var="featuredChurch2_City" />
	        <spring:url value="/static/images/features/Calvary_Baptist_Church_Hayward_ca_southern_baptist_logo.jpg" var="featuredChurch2_Image"/>
            
            <spring:url value="Sunnyvale" var="featuredChurch3_City" />
            <spring:url value="/static/images/features/crosswalk_church_sunnyvale_ca_non_denominational_3.jpg" var="featuredChurch3_Image"/>
            
            <spring:url value="Richmond" var="featuredChurch4_City" />
            <spring:url value="/static/images/features/Hillcrest_Baptist_Church_Richmond_ca_southern_baptist_promo.jpg" var="featuredChurch4_Image"/>
            
            <spring:url value="Antioch" var="featuredChurch5_City" />
            <spring:url value="/static/images/features/Hillside_Church_antioch_ca_nondenominational_3.jpg" var="featuredChurch5_Image"/>
            
            <spring:url value="Oakland" var="featuredChurch6_City" />
            <spring:url value="/static/images/features/Shiloh_Church_oakland_ca_nondenominational_3.jpg" var="featuredChurch6_Image"/>

            <spring:url value="Castro Valley" var="featuredChurch7_City" />
            <spring:url value="/static/images/features/valley_baptist_church_castro_valley_ca_southern_baptist_promo.jpg" var="featuredChurch7_Image"/>
	
	        <spring:url value="/static/images/features/testimonial_photo_gering.jpg" var="testimonialPhoto1"/>
	        <spring:url value="/static/images/features/testimonial_photo_hines.jpg" var="testimonialPhoto2"/>
	        <spring:url value="/static/images/features/testimonial_photo_paddock.jpg" var="testimonialPhoto3"/>
	
	        <spring:url value="/search" var="searchAction" />
	        
	        <div class="main">    
	
	            <div class="header">
	                <div class="header-image-container">
	                    <img class="active-image" src="${heroImage1}" />
	                </div>
	
	                <div class="header-search">
	                    <div class="header-text">
	                        <h1>Find the church for you</h1>
	                    </div>
	                    <div class="blur"><img src="${blurImage}" /></div>
	                    <form action="${searchAction}" method="GET">
	                        <div class="input-group">
	                            <input id="search-bar" name="search-bar" type="text" class="form-control button-on-right" autofocus="autofocus" placeholder="Find Churches Near (City and State, Zip, or Neighborhood)">
	                            <span id="search-button" class="input-group-btn">
	                                <button type="submit" id="searchButton" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span></button>
	                            </span>
	                        </div>
	                    </form>
	                </div>
	
	                <div class="header-label">
	                    <p class="photographer-credit"><a href='//www.thechurchesofamerica.com'>Photo Credit: Steven Hyatt</a></p>
	                </div>
	                <div class="gradient-vertical-white next-section-label">
	                	<div class="transparent-white" style="background:rgba(255,255,255,0.5); height:100%; width:100%;">
	<!-- 	                    <h1>Find churches wherever you are</h1> -->
	<!-- 	                    <h4>Worship where you live or where you are visiting</h4>  -->
						</div>
	               	</div>
	            </div>
                        
                <div class="features">
                    <div class="container-fluid">
                        <div class="row section white" id="featuredChurches">
                            <div class="container">

                                <div class="row masonry">
                                    <div class="col-md-8 col-sm-9">
                                    <div class="big-tile">
                                        <a href="${sanFranciscoRegionLink}" alt="San Francisco - Golden Gate Bridge" name="San Francisco - Golden Gate Bridge">
                                        <img src="${sanFrancisco}" class="location-image"/>
                                        <h2>San Francisco</h2>

                                        <div class="church-info hidden">
                                            <span class="name">Community Church of Hayward</span>
                                            <span class="denomination">American Baptist</span>
                                            <span class="location">Hayward, CA</span>
                                        </div>
                                        </a>
                                       
                                    </div>
                                    </div>

                                    <div class="col-md-4 col-sm-3">
                                    <div class="small-tile">
                                        <a href="#" alt="${featuredChurch2_City}" name="${featuredChurch2_City}">
                                        <img src="${featuredChurch2_Image}" class="location-image"/>
                                        <h2>${featuredChurch2_City}</h2>

                                        <div class="church-info hidden">
                                            <span class="name">Calvary Baptist Church</span>
                                            <span class="denomination">Southern Baptist</span>
                                            <span class="location">Hayward, CA</span>
                                        </div>
                                        </a>
                                    </div>

                                    <div class="small-tile">
                                        <a href="#" alt="${featuredChurch6_City}" name="${featuredChurch6_City}">
                                        <img src="${featuredChurch6_Image}" class="location-image"/>
                                        <h2>${featuredChurch6_City}</h2>

                                        <div class="church-info hidden">
                                            <span class="name">Shiloh Church</span>
                                            <span class="denomination">Non-denominational</span>
                                            <span class="location">Oakland, CA</span>
                                        </div>
                                        </a>
                                    </div>
                                    </div>
                                </div>
                                <div class="row masonry">
                                    <div class="col-sm-6">
                                    <div class="medium-tile">
                                        <a href="#" alt="${featuredChurch3_City}" name="${featuredChurch3_City}">
                                        <img src="${featuredChurch3_Image}" class="location-image"/>
                                        <h2>${featuredChurch3_City}</h2>

                                        <div class="church-info hidden">
                                            <span class="name">Crosswalk Church</span>
                                            <span class="denomination">Non-denominational</span>
                                            <span class="location">Sunnyvale, CA</span>
                                        </div>
                                    </a>
                                    </div>
                                    </div>
                                    <div class="col-sm-6">
                                    <div class="medium-tile">
                                        <a href="./addYourChurch" class="add-church">
                                            <h2>Add your church</h2>
                                        </a>
                                    </div>
                                    </div>
                                </div>
                                <div class="row masonry">
                                    <div class="col-md-4 col-sm-3">
                                    <div class="small-tile">
                                         <a href="#" alt="${featuredChurch7_City}" name="${featuredChurch7_City}">
                                            <img src="${featuredChurch7_Image}" class="location-image"/>
                                            <h2>${featuredChurch7_City}</h2>
                                            <div class="church-info hidden">
                                                <span class="name">Valley Baptist Church</span>
                                                <span class="denomination">Southern Baptist</span>
                                                <span class="location">Castro Valley, CA</span>
                                            </div>
                                        </a>                                        
                                    </div>
                                    <div class="small-tile">
                                        <a href="#" alt="${featuredChurch5_City}" name="${featuredChurch5_City}">
                                        <img src="${featuredChurch5_Image}" class="location-image"/>
                                        <h2>${featuredChurch5_City}</h2>
                                            <div class="church-info hidden">
                                                <span class="name">Hillside Church</span>
                                                <span class="denomination">Non-denominational</span>
                                                <span class="location">Antioch, CA</span>
                                            </div>
                                        </a>
                                    </div>
                                    </div>

                                    <div class="col-md-8 col-sm-9">
                                    <div class="big-tile">
                                           <a href="#" alt="${featuredChurch4_City}" name="${featuredChurch4_City}">
                                        <img src="${featuredChurch4_Image}" class="location-image"/>
                                        <h2>${featuredChurch4_City}</h2>
                                            <div class="church-info hidden">
                                                <span class="name">Hillcrest Baptist Church</span>
                                                <span class="denomination">Southern Baptist</span>
                                                <span class="location">Richmond, CA</span>
                                            </div>
                                        </a>
                                    </div>
                                    </div>
                                </div>
                            </div>

                        </div><!-- end featured churches content -->
                        
                        <div class="row section purple">
                            <div class="container video-embed">
                                <h1>Find your faithful</h1>
                                <h4>
                                    <a href="${addYourChurchLink}" class="white-underline">Add a church</a>
                                    and help people find your parish.
                                </h4>

                                <div class="player">
                                    <iframe width="640" height="385" src="https://www.youtube.com/embed/d712Th-4y0Q" frameborder="0" allowfullscreen></iframe>
                                </div>

                                <div class="col-md-2 col-md-offset-5 col-sm-4 col-sm-offset-4">
                                    <button class="btn btn-success add-church">
                                        Add a Church
                                    </button>
                                </div>
                            </div>


                        </div><!-- end featured events content -->

                        <div class="row section gray-blue">
                            <div class="container testimonials">
                                <h1>Find fellowship</h1>
                                <h4>Read what others are saying about Of a Feather</h4>

                                <!-- This could be turned into a dynamic piece with a for loop of some sort -->
                                <ul>
                                <li class="testimonial">
                                    
                                    <div class="image col-sm-3">
                                        <img src="${testimonialPhoto1}" alt="" class="img-responsive">
                                    </div>

                                    <div class="testimony">
                                        <div class="col-sm-1 text-right">
                                            <h3 class="fa fa-quote-left"></h3>
                                        </div>
                                        <div class="col-sm-7 text-left">
                                            <div class="h5">
                                                This is a great tool to connect searching people to your church.
                                            </div>
                                            <div class="user-info">
                                                <div class="name">
                                                    Pastor Brian Gering
                                                </div>
                                                <div class="church">
                                                    <a href="${testimonialChurch1}">Church of the Cross</a>
                                                </div>
                                                <div class="location">
                                                    <a href="${testimonialLocation1}">Hayward, CA</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-1 text-left">
                                            <h3 class="fa fa-quote-right"></h3>
                                        </div>
                                    </div>
                                </li>
                                
                
                                <li class="testimonial">
                                    <div class="image col-sm-3">
                                        <img src="${testimonialPhoto3}" alt="Faithful user" class="img-responsive">
                                    </div>
                                    <div class="col-sm-1 text-right">
                                        <h3 class="fa fa-quote-left"></h3>
                                    </div>
                                    <div class="col-sm-7 text-left">
                                        <div class="h5">
                                            I was thrilled to find Of A Feather when searching for a new church! It&apos;s your one-stop shop for finding a church that will meet all of your needs.
                                        </div>
                                        <div class="user-info">
                                            <div class="name">
                                                Laurie Paddock
                                            </div>
                                            <div class="church">
                                            </div>
                                            <div class="location">
                                                <a href="${testimonialLocation3}">San Lorenzo, CA</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-1 text-left">
                                        <h3 class="fa fa-quote-right"></h3>
                                    </div>
                                </li>
                                
                                
                                <li class="testimonial">
                                    
                                    <div class="image col-sm-3">
                                        <img src="${testimonialPhoto2}" alt="" class="img-responsive">
                                    </div>

                                    <div class="testimony">
                                        <div class="col-sm-1 text-right">
                                            <h3 class="fa fa-quote-left"></h3>
                                        </div>
                                        <div class="col-sm-7 text-left">
                                            <div class="h5">
                                                I encourage every pastor to check out this inventive way for churches to get their names out on the internet. I believe this will enhance your ministry and those who are looking to join your church. Who knows, a new member may be one click away!
                                            </div>
                                            <div class="user-info">
                                                <div class="name">
                                                    Pastor Tim Hines, Phd
                                                </div>
                                                <div class="church">
                                                    <a href="${testimonialChurch3}">First Southern Baptist Church</a>
                                                </div>
                                                <div class="location">
                                                    <a href="${testimonialLocation3}">San Lorenzo, CA</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-1 text-left">
                                            <h3 class="fa fa-quote-right"></h3>
                                        </div>
                                    </div>
                                </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
	        <%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%>
        </div>
    </body>
</html>
