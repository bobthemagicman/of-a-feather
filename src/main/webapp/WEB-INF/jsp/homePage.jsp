
<%@ include file="/WEB-INF/jsp/partials/commonHeader.jsp"%>





<spring:url value="/static/images/hero/01-church-of-the-cross-in-B.jpg" var="heroImage1"/>
<spring:url value="/static/images/hero/Church_of_The_Holy_Cross_shadow.jpg" var="heroImage2" />
<spring:url value="/static/images/hero/Cathedral_of_St_John_shadow.jpg" var="heroImage3" /> 
<spring:url value="/static/images/site/blur.png" var="blurImage" /> 

<div class="header">
    <div class="header-image-container">
        <img class="active-image" src="${heroImage1}" data-church-name="Church of the Cross" data-church-location="Bluffton, SC" data-church-denomination="Episcopalian" data-photographer-credit="Photo Credit: Steven Hyatt<br />www.thechurchesofamerica.com" />
        <img src="${heroImage2}" data-church-name="Church of the Holy Cross" data-church-location="Stateburg, SC" data-church-denomination="Episcopalian" data-photographer-credit="Photo Credit: Steven Hyatt<br />www.thechurchesofamerica.com" />
        <img src="${heroImage3}" data-church-name="Cathedral of St. John the Baptist" data-church-location="Savannah, GA" data-church-denomination="Catholic" data-photographer-credit="Photo Credit: Steven Hyatt<br />www.thechurchesofamerica.com" />
    </div>

    <spring:url value="/search" var="formAction" />

    <form action="${formAction}" method="POST">
        <div class="input-group header-search">
            <h1>Find the Church for You.<br />Personalized church search.</h1>
            <div class="blur"><img src="${blurImage}" /></div>
            <input id="search-bar" type="text" class="form-control button-on-right" autofocus="autofocus" placeholder="FIND CHURCHES NEAR: (city, state, zipcode, address)">
            <span id="search-button" class="input-group-btn">
                <button type="submit" id="searchButton" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span></button>
            </span>
        </div>
    </form> 

    <div class="header-label">
        <p class="church-name"></p>
        <p class="church-info"></p>
        <p class="photographer-credit"></p>
    </div>

</div>

<div class="container">

    <spring:url value="/static/images/features/Calvary_Baptist_Church_Hayward_ca_southern_baptist_logo.jpg" var="featuredChurchImage1"/>
    <spring:url value="/static/images/features/Community_Church_of_Hayward_hayward_ca_american_baptist_promo.jpg" var="featuredChurchImage2"/>
    <spring:url value="/static/images/features/crosswalk_church_sunnyvale_ca_non_denominational_3.jpg" var="featuredChurchImage3"/>
    <spring:url value="/static/images/features/Hillcrest_Baptist_Church_Richmond_ca_southern_baptist_promo.jpg" var="featuredChurchImage4"/>
    <spring:url value="/static/images/features/Hillside_Church_antioch_ca_nondenominational_3.jpg" var="featuredChurchImage5"/>
    <spring:url value="/static/images/features/Shiloh_Church_oakland_ca_nondenominational_3.jpg" var="featuredChurchImage6"/>
    <spring:url value="/static/images/features/valley_baptist_church_castro_valley_ca_southern_baptist_promo.jpg" var="featuredChurchImage7"/>

    <ul class="nav nav-tabs features-nav">
        <li class="active"><a href="#featuredChurchesTab" data-toggle="tab">Featured Churches</a></li>
        <li><a href="#testimonialsTab" data-toggle="tab">Testimonials</a></li>
        <li><a href="#featuredEventsTab" data-toggle="tab">Featured Events</a></li>
    </ul>

    <div class="tab-content">
        <div class="tab-pane active fade in" id="featuredChurchesTab">

            <div id="featuredChurchesCarousel" class="carousel slide">

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
                                <span class="featured-church-name">Calvary Baptist Church</span>
                                <hr />
                                <span class="featured-church-denomination">Southern Baptist</span>
                                <span class="featured-church-location">Hayward, CA</span>
                                <hr />
                                <div class="featured-church-programs">
                                    <ul>
                                        <li>Couples Counseling</li>
                                        <li>Homeless Ministry</li>
                                        <li>Choir Team</li>
                                    </ul>
                                    <span class="see-more-link">See more. . .</span>
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
                                <span class="featured-church-name">Community Church of Hayward</span>
                                <hr />
                                <span class="featured-church-denomination">American Baptist</span>
                                <span class="featured-church-location">Hayward, CA</span>
                                <hr />
                                <div class="featured-church-programs">
                                    <ul>
                                        <li>Couples Counseling</li>
                                        <li>Homeless Ministry</li>
                                        <li>Choir Team</li>
                                    </ul>
                                    <span class="see-more-link">See more. . .</span>
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
                                <span class="featured-church-name">Crosswalk Church</span>
                                <hr />
                                <span class="featured-church-denomination">Non-denominational</span>
                                <span class="featured-church-location">Sunnyvale, CA</span>
                                <hr />
                                <div class="featured-church-programs">
                                    <ul>
                                        <li>Couples Counseling</li>
                                        <li>Homeless Ministry</li>
                                        <li>Choir Team</li>
                                    </ul>
                                    <span class="see-more-link">See more. . .</span>
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
                                <span class="featured-church-name">Hillcrest Baptist Church</span>
                                <hr />
                                <span class="featured-church-denomination">Southern Baptist</span>
                                <span class="featured-church-location">Richmond, CA</span>
                                <hr />
                                <div class="featured-church-programs">
                                    <ul>
                                        <li>Couples Counseling</li>
                                        <li>Homeless Ministry</li>
                                        <li>Choir Team</li>
                                    </ul>
                                    <span class="see-more-link">See more. . .</span>
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
                                <span class="featured-church-name">Hillside Church</span>
                                <hr />
                                <span class="featured-church-denomination">Non-denominational</span>
                                <span class="featured-church-location">Antioch, CA</span>
                                <hr />
                                <div class="featured-church-programs">
                                    <ul>
                                        <li>Couples Counseling</li>
                                        <li>Homeless Ministry</li>
                                        <li>Choir Team</li>
                                    </ul>
                                    <span class="see-more-link">See more. . .</span>
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
                                <span class="featured-church-name">Shiloh Church</span>
                                <hr />
                                <span class="featured-church-denomination">Non-denominational</span>
                                <span class="featured-church-location">Oakland, CA</span>
                                <hr />
                                <div class="featured-church-programs">
                                    <ul>
                                        <li>Couples Counseling</li>
                                        <li>Homeless Ministry</li>
                                        <li>Choir Team</li>
                                    </ul>
                                    <span class="see-more-link">See more. . .</span>
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
                                <span class="featured-church-name">Valley Baptist Church</span>
                                <hr />
                                <span class="featured-church-denomination">Southern Baptist</span>
                                <span class="featured-church-location">Castro Valley, CA</span>
                                <hr />
                                <div class="featured-church-programs">
                                    <ul>
                                        <li>Couples Counseling</li>
                                        <li>Homeless Ministry</li>
                                        <li>Choir Team</li>
                                    </ul>
                                    <span class="see-more-link">See more. . .</span>
                                </div>
                            </a>
                        </div>

                    </div>

                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#featuredChurchesCarousel" data-slide="prev">
                    <span class="icon-prev"></span>
                </a>
                <a class="right carousel-control" href="#featuredChurchesCarousel" data-slide="next">
                    <span class="icon-next"></span>
                </a>
            </div>

        </div><!-- end featured churches tab content -->
        <div class="tab-pane fade" id="featuredEventsTab">

            <div id="featuredEventsCarousel" class="carousel slide">

                <!-- Wrapper for slides -->
                <div class="carousel-inner">
                    <div class="item active">

                        <div class="carousel-caption large-caption">
                            Coming Soon!
                        </div>
                    </div>
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#featuredEventsCarousel" data-slide="prev">
                    <span class="icon-prev"></span>
                </a>
                <a class="right carousel-control" href="#featuredEventsCarousel" data-slide="next">
                    <span class="icon-next"></span>
                </a>
            </div>

        </div><!-- end featured events tab content -->

        <spring:url value="/static/images/features/testimonial_photo_gering.jpg" var="testimonialPhoto1"/>
        <spring:url value="/static/images/features/testimonial_photo_hines.jpg" var="testimonialPhoto2"/>
        <spring:url value="/static/images/features/testimonial_photo_paddock.jpg" var="testimonialPhoto3"/>

        <div class="tab-pane fade" id="testimonialsTab">

            <div id="testimonialsCarousel" class="carousel slide">

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

                <!-- Controls -->
                <a class="left carousel-control" href="#testimonialsCarousel" data-slide="prev">
                    <span class="icon-prev"></span>
                </a>
                <a class="right carousel-control" href="#testimonialsCarousel" data-slide="next">
                    <span class="icon-next"></span>
                </a>
            </div>

        </div><!-- end testimonials tab content -->
    </div>

</div> <!-- /container -->

<%@ include file="/WEB-INF/jsp/partials/commonFooter.jsp"%>
</body>
</html>