


<%@ include file="/WEB-INF/jsp/partials/commonHeader.jsp"%>

<spring:url value="/static/images/hero/01-church-of-the-cross-in-B.jpg" var="heroImage1"/>
<spring:url value="/static/images/hero/Church_of_The_Holy_Cross_shadow.jpg" var="heroImage2" />
<spring:url value="/static/images/hero/Cathedral_of_St_John_shadow.jpg" var="heroImage3" /> 
<spring:url value="/static/images/site/blur.png" var="blurImage" />
<spring:url value="/static/images/site/coming_soon.png" var="comingSoonImage" />

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

<div class="header">
    <img src="${comingSoonImage}" id="comingSoonImage" />
    <div class="header-image-container">
        <img class="active-image" src="${heroImage1}" data-church-name="Church of the Cross" data-church-location="Bluffton, SC" data-church-denomination="Episcopalian" data-photographer-credit="Photo Credit: Steven Hyatt<br />www.thechurchesofamerica.com" />
        <img src="${heroImage2}" data-church-name="Church of the Holy Cross" data-church-location="Stateburg, SC" data-church-denomination="Episcopalian" data-photographer-credit="Photo Credit: Steven Hyatt<br />www.thechurchesofamerica.com" />
        <img src="${heroImage3}" data-church-name="Cathedral of St. John the Baptist" data-church-location="Savannah, GA" data-church-denomination="Catholic" data-photographer-credit="Photo Credit: Steven Hyatt<br />www.thechurchesofamerica.com" />
    </div>

    <div class="header-search">
        <div class="header-text">
            <h1>Find the Church for You.</h1>
            <h4>Personalized church search</h4>
        </div>
        <div class="blur"><img src="${blurImage}" /></div>
        <div class="input-group" data-toggle="popover" data-content="Our search capability is still under development! Please check back soon!" data-trigger="hover" data-placement="bottom">
            <input id="search-bar" disabled="disabled" type="text" class="form-control button-on-right" autofocus="autofocus" placeholder="Find Churches Near (City, State Zip)">
            <span id="search-button" class="input-group-btn">
                <button type="button" id="searchButton" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span></button>
            </span>
        </div>
        <a href="#" class="btn btn-primary">Add Your Church!</a>
    </div>

    <div class="header-label">
        <p class="church-name"></p>
        <p class="church-info"></p>
        <p class="photographer-credit"></p>
    </div>

</div>

<div class="container front-page-temp">
    <div class="row">
        <div class="col-sm-12">
            <h1><span class="glyphicon glyphicon-wrench"></span> Under Development!</h1>
        </div>
        <div class="col-sm-4">
            <p class="panel">
                Thanks for visiting OfAFeather.org!<br /><br />
                Our team is currently hard at work preparing for our beta launch during winter 2013.
            </p>
        </div>
        <div class="col-sm-8">
            <h5>In the meantime, we invite you to learn more <a href="about.html">about our organization</a>.</h5>
            <h5>Better yet, <a href="addyourchurch.html">add your church</a> to our database before we launch!</h5>
        </div>
    </div>
</div>

<div class="container features-nav-container">
    <ul class="nav nav-tabs features-nav">
        <li class="active"><a href="#featuredChurchesTab" data-toggle="tab">Featured Churches</a><br /><div class="arrow-up"></div></li>
        <li><a href="#testimonialsTab" data-toggle="tab">Testimonials</a><br /><div class="arrow-up"></div></li>
        <li><a href="#featuredEventsTab" data-toggle="tab">Featured Events</a><br /><div class="arrow-up"></div></li>
    </ul>
</div>
<div class="features">
    <div class="container">
        <div class="tab-content">
            <div class="tab-pane active fade in" id="featuredChurchesTab">

                <div id="featuredChurchesCarousel" class="carousel carousel-front-page slide">
                    <a class="left carousel-control" href="#featuredChurchesCarousel" data-slide="prev">
                        <span class="icon-prev"></span>
                    </a>
                    <!-- Wrapper for slides -->
                    <div class="carousel-inner">
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
                    </div>

                    <!-- Controls -->

                    <a class="right carousel-control" href="#featuredChurchesCarousel" data-slide="next">
                        <span class="icon-next"></span>
                    </a>
                </div>

            </div><!-- end featured churches tab content -->
            <div class="tab-pane fade" id="featuredEventsTab">

                <div id="featuredEventsCarousel" class="carousel carousel-front-page slide">

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner-no-nav">
                        <div class="item active">
                            <div class="carousel-caption large-caption">
                                Coming Soon!
                            </div>
                        </div>
                    </div>

                </div>

            </div><!-- end featured events tab content -->
            <div class="tab-pane fade" id="testimonialsTab">

                <div id="testimonialsCarousel" class="carousel carousel-front-page slide">
                    <a class="left carousel-control" href="#testimonialsCarousel" data-slide="prev">
                        <span class="icon-prev"></span>
                    </a>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner">

                        <div class="item active">

                            <div class="testimonial">

                                <p class="testimonial-text"><br />
                                    &quot;This is a great tool to connect searching people to your church&quot;
                                </p>

                                <div class="testimonial-content">


                                    <p class="testimonial-info">
                                        <span class="testimonial-name">Pastor Brian Gering</span>
                                        <span class="testimonial-church">Church of the Cross</span>
                                        <span class="testimonial-church-location">Hayward, CA</span>

                                    </p>

                                    <div class="testimonial-image">
                                        <img class="img-responsive" src="${testimonialPhoto1}" />
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="testimonial">

                                <p class="testimonial-text">
                                    &quot;I encourage every pastor to check out this inventive way for churches to get their names out on the internet. I believe this will enhance your ministry and those who are looking to join your church. Who knows, a new member may be one click away!&quot;
                                </p>

                                <div class="testimonial-content">
                                    <p class="testimonial-info">
                                        <span class="testimonial-name">Pastor Tim Hines, Phd</span>
                                        <span class="testimonial-church">First Southern Baptist Church</span>
                                        <span class="testimonial-church-location">San Lorenzo, CA</span>
                                    </p>

                                    <div class="testimonial-image">
                                        <img class="img-responsive" src="${testimonialPhoto2}" />
                                    </div>
                                </div>

                            </div>    
                        </div>
                        <div class="item">

                            <div class="testimonial">

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

                            </div>
                        </div>
                    </div>

                    <!-- Right Control -->

                    <a class="right carousel-control" href="#testimonialsCarousel" data-slide="next">
                        <span class="icon-next"></span>
                    </a>
                </div>

            </div><!-- end testimonials tab content -->
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/partials/commonFooter.jsp"%>