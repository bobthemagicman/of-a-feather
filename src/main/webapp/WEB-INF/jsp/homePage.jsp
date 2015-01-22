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
	
	        <spring:url value="/static/images/hero/01-church-of-the-cross-in-B.jpg" var="heroImage1"/>
	        <spring:url value="/static/images/site/blur.png" var="blurImage" />
	
	        <spring:url value="/static/images/features/Calvary_Baptist_Church_Hayward_ca_southern_baptist_logo.jpg" var="featuredChurchImage1"/>
	        <spring:url value="/static/images/features/Community_Church_of_Hayward_hayward_ca_american_baptist_promo.jpg" var="featuredChurchImage2"/>
	        <spring:url value="/static/images/features/crosswalk_church_sunnyvale_ca_non_denominational_3.jpg" var="featuredChurchImage3"/>
	        <spring:url value="/static/images/features/Hillcrest_Baptist_Church_Richmond_ca_southern_baptist_promo.jpg" var="featuredChurchImage4"/>
	        <spring:url value="/static/images/features/Hillside_Church_antioch_ca_nondenominational_3.jpg" var="featuredChurchImage5"/>
	        <spring:url value="/static/images/features/Shiloh_Church_oakland_ca_nondenominational_3.jpg" var="featuredChurchImage6"/>
	        <spring:url value="/static/images/features/valley_baptist_church_castro_valley_ca_southern_baptist_promo.jpg" var="featuredChurchImage7"/>
	
	        <spring:url value="/static/images/features/testimonial_photo_gering.jpg" var="testimonialPhoto1"/>
	        <spring:url value="/static/images/features/testimonial_photo_hines.jpg" var="testimonialPhoto2"/>
	        <spring:url value="/static/images/features/testimonial_photo_paddock.jpg" var="testimonialPhoto3"/>
	
	        <spring:url value="/search" var="searchAction" />
	        
	        <div class="main">    
	
	            <div class="header">
	                <div class="header-image-container">
	                    <img class="active-image" src="${heroImage1}" data-church-name="Church of the Cross" data-church-location="Bluffton, SC" data-church-denomination="Episcopalian" data-photographer-credit="Photo Credit: Steven Hyatt<br />www.thechurchesofamerica.com" />
	                    <img src="${heroImage2}" data-photographer-credit="Photo Credit: Steven Hyatt<br />www.thechurchesofamerica.com" />
	                    <img src="${heroImage3}" data-photographer-credit="Photo Credit: Steven Hyatt<br />www.thechurchesofamerica.com" />
	                </div>
	
	                <div class="header-search">
	                    <div class="header-text">
	                        <h1>Find the Church for You</h1>
	                        <h4>Personalized church search</h4>
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
	                    <p class="church-name"></p>
	                    <p class="church-info"></p>
	                    <p class="photographer-credit"></p>
	                </div>
	
	            </div>
    	
                <div class="features">
                    <div class="container">
                        <div class="row section white" id="featuredChurches">
                            <div class="col-md-12">
                                <h1>Find churches wherever you are.</h1>
                                <h2>Worship where you live or where you are visiting</h2>                           
                            
                                <div class="row masonry">
                                    <div class="col-md-8 col-sm-9 big-rectangle">
                                        
                                    </div>
                                    <div class="col-md-4 col-sm-3 small-rectangle">
                                        
                                    </div>
                                    <div class="col-md-4 col-sm-3 small-rectangle">
                                        
                                    </div>
                                </div>
                                <div class="row masonry">
                                    <div class="col-sm-6 medium-rectangle">
                                        
                                    </div>
                                    <div class="col-sm-6 medium-rectangle">
                                        
                                    </div>
                                </div>
                                <div class="row masonry">
                                    <div class="col-md-4 col-sm-3 small-rectangle">
                                        
                                    </div>
                                    <div class="col-md-4 col-sm-3 small-rectangle">
                                        
                                    </div>
                                    <div class="col-md-8 col-sm-9 big-rectangle">
                                        
                                    </div>
                                </div>
                            </div>

                            <div class="item active">

                                <div class="featured-church">
                                    <a href="#">
                                        <div class="featured-church-image-wrapper">
                                            <div class="featured-church-image">
                                                <img class="img-responsive" src="${featuredChurchImage1}" />
                                            </div>
                                        </div>
                                        <div class="featured-church-info">
                                            <span class="featured-church-name">Calvary Baptist Church</span>
                                            <span class="featured-church-denomination">Southern Baptist</span>
                                            <span class="featured-church-location">Hayward, CA</span>
                                        </div>
                                    </a>
                                </div>

                                <div class="featured-church">
                                    <a href="#">
                                        <div class="featured-church-image-wrapper">
                                            <div class="featured-church-image">
                                                <img class="img-responsive" src="${featuredChurchImage2}" />
                                            </div>
                                        </div>
                                        <div class="featured-church-info">
                                            <span class="featured-church-name">Community Church of Hayward</span>
                                            <span class="featured-church-denomination">American Baptist</span>
                                            <span class="featured-church-location">Hayward, CA</span>
                                        </div>
                                    </a>
                                </div>

                                <div class="featured-church">
                                    <a href="#">
                                        <div class="featured-church-image-wrapper">
                                            <div class="featured-church-image">
                                                <img class="img-responsive" src="${featuredChurchImage3}" />
                                            </div>
                                        </div>
                                        <div class="featured-church-info">
                                            <span class="featured-church-name">Crosswalk Church</span>
                                            <span class="featured-church-denomination">Non-denominational</span>
                                            <span class="featured-church-location">Sunnyvale, CA</span>
                                        </div>
                                    </a>
                                </div>

                            </div>

                            <div class="item">

                                <div class="featured-church">
                                    <a href="#">
                                        <div class="featured-church-image-wrapper">
                                            <div class="featured-church-image">
                                                <img class="img-responsive" src="${featuredChurchImage4}" />
                                            </div>
                                        </div>
                                        <div class="featured-church-info">
                                            <span class="featured-church-name">Hillcrest Baptist Church</span>
                                            <span class="featured-church-denomination">Southern Baptist</span>
                                            <span class="featured-church-location">Richmond, CA</span>
                                        </div>
                                    </a>
                                </div>

                                <div class="featured-church">
                                    <a href="#">
                                        <div class="featured-church-image-wrapper">
                                            <div class="featured-church-image">
                                                <img class="img-responsive" src="${featuredChurchImage5}" />
                                            </div>
                                        </div>
                                        <div class="featured-church-info">
                                            <span class="featured-church-name">Hillside Church</span>
                                            <span class="featured-church-denomination">Non-denominational</span>
                                            <span class="featured-church-location">Antioch, CA</span>
                                        </div>
                                    </a>
                                </div>

                                <div class="featured-church">
                                    <a href="#">
                                        <div class="featured-church-image-wrapper">
                                            <div class="featured-church-image">
                                                <img class="img-responsive" src="${featuredChurchImage6}" />
                                            </div>
                                        </div>
                                        <div class="featured-church-info">
                                            <span class="featured-church-name">Shiloh Church</span>
                                            <span class="featured-church-denomination">Non-denominational</span>
                                            <span class="featured-church-location">Oakland, CA</span>
                                        </div>
                                    </a>
                                </div>



                            </div>
                            <div class="item">

                                <div class="featured-church">
                                    <a href="#">
                                        <div class="featured-church-image-wrapper">
                                            <div class="featured-church-image">
                                                <img class="img-responsive" src="${featuredChurchImage7}" />
                                            </div>
                                        </div>
                                        <div class="featured-church-info">
                                            <span class="featured-church-name">Valley Baptist Church</span>
                                            <span class="featured-church-denomination">Southern Baptist</span>
                                            <span class="featured-church-location">Castro Valley, CA</span>
                                        </div>
                                    </a>
                                </div>

                            </div>

                        </div><!-- end featured churches content -->
                        
                        <div class="row section purple">
                            <div class="col-md-12 video-embed">
                                <h1>Find your faithful.</h1>
                                <h2>
                                    <a href="${addYourChurchLink}">Add a church</a>
                                    &nbsp;and help people find your parish.
                                </h2>

                                <div class="player">
                                    <!-- youtube embedding code here -->
                                </div>

                                <div class="col-md-2 col-md-offset-5 col-sm-4 col-sm-offset-4">
                                    <button class="btn btn-success add-church">
                                        Add a Church
                                    </button>
                                </div>
                            </div>


                        </div><!-- end featured events content -->

                        <div class="row section gray-blue">
                            <div class="col-md-12 testimonials">
                                <h1>Find fellowship.</h1>
                                <h2>Read what others are saying about Of a Feather</h2>

                                <!-- This could be turned into a dynamic piece with a for loop of some sort -->
                                <ul>
                                    <li class="testimonial">
                                        
                                        <div class="image col-sm-3">
                                            <img src="${stetimonialPhoto1}" alt="" class="img-responsive">
                                        </div>

                                        <div class="testimony">
                                            <div class="col-sm-1 text-right">
                                                <span class="icon icon-quote-left"></span>
                                            </div>
                                            <div class="col-sm-7 text-left">
                                                <div class="h4">
                                                    This is a great tool to connect searching people to your church.
                                                </div>
                                                <div class="user-info">
                                                    <span class="name">
                                                        Pastor Brian Gering
                                                    </span>
                                                    <span class="church">
                                                        Church of the Cross
                                                    </span>
                                                    <span class="location">
                                                        Hayward, CA
                                                    </span>
                                                </div>
                                            </div>
                                            <div class="col-sm-1">
                                                <div class="icon icon-quote-right text-left"></div>
                                            </div>
                                        </div>
                                    </li>


                                    <li class="testimonial">
                                        <div class="image col-sm-3">
                                            <img class="img-responsive" src="${testimonialPhoto2}" />
                                        </div>

                                        <div class="testimony">
                                            <div class="col-sm-1 text-right">
                                                <span class="icon icon-quote-left"></span>
                                            </div>
                                            <div class="col-sm-7 text-left">
                                                <div class="h4">
                                                    I encourage every pastor to check out this inventive way for churches to get their names out on the internet. I believe this will enhance your ministry and those who are looking to join your church. Who knows, a new member may be one click away!
                                                </div>
                                                <div class="user-info">
                                                    <span class="name">
                                                        Pastor Tim Hines, Phd<
                                                    </span>
                                                    <span class="church">
                                                        First Southern Baptist Church
                                                    </span>
                                                    <span class="location">
                                                        San Lorenzo, CA
                                                    </span>
                                                </div>
                                            </div>
                                            <div class="col-sm-1">
                                                <div class="icon icon-quote-right text-left"></div>
                                            </div>
                                        </div>
                                    </li>    
                                
                
                                <li class="testimonial">
                
                                    <p class="testimonial-text"><br />
                                        &quot;I was thrilled to find Of A Feather when searching for a new church! It&apos;s your one-stop shop for finding a church that will meet all of your needs.&quot;
                                    </p>
                
                                    <div class="testimonial-content">
                
                                        <p class="testimonial-info">
                                            <span class="testimonial-name">Laurie Paddock</span>
                
                                            <span class="testimonial-church-location">Fremont CA</span>
                                        </p>
                
                                        <div class="testimonial-image">
                                            <img class="img-responsive" src="${testimonialPhoto3}" />
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
