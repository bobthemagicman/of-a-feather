<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/init.jsp"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <%-- Common Metadata, scripts, and CSS --%>
        <%@ include file="/WEB-INF/jsp/partials/commonHead.jsp"%>

        <title>Of A Feather - Find your new church home today</title>	
    </head>
    <body>

        <%-- Site Header --%>
        <%@ include file="/WEB-INF/jsp/partials/siteHeader.jsp"%>

        <spring:url value="/static/images/site/calendar_icon.png" var="calendarIcon"/>
        <spring:url value="/static/images/site/check_icon.png" var="checkIcon"/>
        <spring:url value="/static/images/site/choir_icon.png" var="choirIcon"/>
        <spring:url value="/static/images/site/church_icon.png" var="churchIcon"/>
        <spring:url value="/static/images/site/clock_icon.png" var="clockIcon"/>
        <spring:url value="/static/images/site/document_icon.png" var="documentIcon"/>
        <spring:url value="/static/images/site/drums_icon.png" var="drumsIcon"/>
        <spring:url value="/static/images/site/electric_guitar_icon.png" var="electricGuitarIcon"/>
        <spring:url value="/static/images/site/envelope_icon.png" var="envelopeIcon"/>
        <spring:url value="/static/images/site/facebook_icon.png" var="facebookIcon"/>
        <spring:url value="/static/images/site/guitar_icon.png" var="guitarIcon"/>
        <spring:url value="/static/images/site/heart_icon.png" var="heartIcon"/>
        <spring:url value="/static/images/site/heart_icon_filled_gray.png" var="heartIconFilled"/>
        <spring:url value="/static/images/site/info_icon.png" var="infoIcon"/>
        <spring:url value="/static/images/site/instagram_icon.png" var="instagramIcon"/>
        <spring:url value="/static/images/site/left_arrow.png" var="leftArrow"/>
        <spring:url value="/static/images/site/left_arrow_hover.png" var="leftArrowHover"/>
        <spring:url value="/static/images/site/left_arrow_large.png" var="leftArrowLarge"/>
        <spring:url value="/static/images/site/magnifying_glass_icon.png" var="magnifyingGlassIcon"/>
        <spring:url value="/static/images/site/person_icon.png" var="personIcon"/>
        <spring:url value="/static/images/site/piano_icon.png" var="pianoIcon"/>
        <spring:url value="/static/images/site/right_arrow.png" var="rightArrow"/>
        <spring:url value="/static/images/site/right_arrow_hover.png" var="rightArrowHover"/>
        <spring:url value="/static/images/site/right_arrow_large.png" var="rightArrowLarge"/>
        <spring:url value="/static/images/site/saxophone_icon.png" var="saxophoneIcon"/>
        <spring:url value="/static/images/site/small_checkmark.png" var="smallCheckmark"/>
        <spring:url value="/static/images/site/twitter_icon.png" var="twitterIcon"/>
        <spring:url value="/static/images/site/violin_icon.png" var="violinIcon"/>
        <spring:url value="/static/images/site/visiting_icon.png" var="visitingIcon"/>
        
        
        <div class="container profile" data-church-name="${organization.name}" data-latitude="${organization.address.latitude}" data-longitude="${organization.address.longitude}">

            <div class="profile-top">

                <div class="media-container">

                    <div class="media-carousel-container active-media">

                        <div class="media-carousel carousel slide">
                            <div class="media-left-arrow" data-slide="prev">
                                <img src="${leftArrowLarge}" />
                            </div>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img src="http://ofafeather-testing.appwebmasters.com/images/cal_designs/sample_images/image1.jpg" />
                                </div>
                                <div class="item">
                                    <img src="http://ofafeather-testing.appwebmasters.com/images/cal_designs/sample_images/image2.jpg" />
                                </div>
                                <div class="item">
                                    <img src="http://ofafeather-testing.appwebmasters.com/images/cal_designs/sample_images/image3.jpg" />
                                </div>
                                <div class="item">
                                    <img src="http://ofafeather-testing.appwebmasters.com/images/cal_designs/sample_images/image4.jpg" />
                                </div>
                                <div class="item">
                                    <img src="http://ofafeather-testing.appwebmasters.com/images/cal_designs/sample_images/image5.jpg" />
                                </div>
                            </div>
                            <div class="media-right-arrow" data-slide="next">
                                <img src="${rightArrowLarge}" />
                            </div>
                        </div>

                    </div>

                    <div class="video-player-container">
                        <div id="videoPlayer"></div>
                    </div>

                    <div class="media-icons-container">
                        <div class="media-thumbnails-container">
                            <div class="thumbnails-carousel-container">
                                <div class="thumbnails-carousel carousel slide">
                                    <div class="thumbnails-left-arrow" data-slide="prev">
                                        <img src="${leftArrow}" />
                                        <img class="arrow-hover" src="${leftArrowHover}" />
                                    </div>
                                    <div class="photos carousel-inner">
                                        <div class="thumbnails item active">
                                            <div class="thumbnail-container">
                                                <img src="http://ofafeather-testing.appwebmasters.com/images/cal_designs/sample_images/image1.jpg" data-slide-link="0" />
                                            </div>    
                                            <div class="thumbnail-container">
                                                <img src="http://ofafeather-testing.appwebmasters.com/images/cal_designs/sample_images/image2.jpg" data-slide-link="1" />
                                            </div>
                                            <div class="thumbnail-container">
                                                <img src="http://ofafeather-testing.appwebmasters.com/images/cal_designs/sample_images/image3.jpg" data-slide-link="2" />
                                            </div>
                                            <div class="thumbnail-container">
                                                <img src="http://ofafeather-testing.appwebmasters.com/images/cal_designs/sample_images/image4.jpg" data-slide-link="3" />
                                            </div>
                                            <div class="thumbnail-container">
                                                <img src="http://ofafeather-testing.appwebmasters.com/images/cal_designs/sample_images/image5.jpg" data-slide-link="4" />
                                            </div>                                           
                                        </div>
                                        <div class="thumbnails item">
                                            <div class="thumbnail-container">
                                                <img src="http://ofafeather-testing.appwebmasters.com/images/cal_designs/sample_images/image5.jpg" data-slide-link="4" />
                                            </div>    
                                            <div class="thumbnail-container">
                                                <img src="http://ofafeather-testing.appwebmasters.com/images/cal_designs/sample_images/image4.jpg" data-slide-link="3" />
                                            </div>
                                            <div class="thumbnail-container">
                                                <img src="http://ofafeather-testing.appwebmasters.com/images/cal_designs/sample_images/image3.jpg" data-slide-link="2" />
                                            </div>
                                            <div class="thumbnail-container">
                                                <img src="http://ofafeather-testing.appwebmasters.com/images/cal_designs/sample_images/image2.jpg" data-slide-link="1" />
                                            </div>
                                            <div class="thumbnail-container">
                                                <img src="http://ofafeather-testing.appwebmasters.com/images/cal_designs/sample_images/image3.jpg" data-slide-link="2" />
                                            </div>
                                        </div>
                                        <div class="thumbnails item">
                                            <div class="thumbnail-container video">
                                                <img src="http://ofafeather-testing.appwebmasters.com/images/cal_designs/sample_images/image3.jpg" data-video-code="EwwPwQ8Zt8I" data-video-type="YT" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="thumbnails-right-arrow" data-slide="next">
                                        <img src="${rightArrow}" />
                                        <img class="arrow-hover" src="${rightArrowHover}" />
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>

                <div class="vcard profile-top-info">

                    <div class="church-intro-container">

                        <div class="church-intro">

                            <h1 class="org">${organization.name}</h1>

                            <h2>${organization.denomination}</h2>
                            
                            <h2>${organization.subDenomination}</h2>

                            <div class="basic-info-container">

                                <div class="profile-large-icon-container">
                                    <img src="${infoIcon}" />
                                </div>

                                <div class="basic-info">
                                    Founded in ${organization.yearFounded}<br />
                                    Pastor &gt; <span class="church-leader">Patrick &amp; Marlena Kiteley</span><br />
                                    Size &gt; Large (1000)
                                </div>

                            </div>

                            <div class="contact-info-container">

                                <div class="profile-large-icon-container">
                                    <img src="${envelopeIcon}" />
                                </div>

                                <div class="contact-info">
                                    <span class="tel">(510) 261-2052 ext. 130</span><br />
                                    <a class="url fn n" href="${organization.websiteUrl}">${organization.websiteUrl}</a>
                                </div>

                            </div>

                        </div>

                        <div class="profile-icons-container">
                            <img src="${heartIcon}" />
                            <a href="${organization.facebookUrl}" target="_blank"><img src="${facebookIcon}" /></a>
                            <a href="#" target="_blank"><img src="${twitterIcon}" /></a>
                            <a href="#" target="_blank"><img src="${instagramIcon}" /></a>
                        </div>

                    </div>

                    <div class="visit-us-container">

                        <a class="visit-us-button btn btn-primary" href="#">
                            <div class="visit-us-icon">
                                <img src="${visitingIcon}" />
                            </div>
                            <div class="visit-us-text">
                                INTERESTED<br />IN VISITING?
                            </div>
                        </a>

                        <div class="visit-us-times">
                            <img src="${leftArrow}" />
                            <p>
                                Service Times on Sunday<br />
                                9am, 11am, and 1pm en Espa&ntilde;ol
                            </p>
                        </div>

                    </div>

                    <div class="location-info">
                        <div class="adr location">
                            <span class="street-address">${organization.address.street1}</span><br />
                            <span class="street-address">${organization.address.street2}</span><br />
                            <span class="locality">${organization.address.city}</span>, <span class="region">${organization.address.state}</span> <span class="postal-code">${organization.address.postalCode}</span> <span class="country-name">${organization.address.country}</span><br />
                            <span class="transportation-info">Parking Lot Available</span>
                        </div>
                        <div class="distance-info">
                            <span class="distance">??? miles away</span>
                        </div>
                    </div>

                    <div class="map-container">
                        <div id="map-canvas"></div>
                    </div>

                </div>

            </div>

        </div>

        <div class="profile-bottom">

            <div class="container details-nav-container">
                <ul class="nav nav-tabs details-nav">
                    <li class="active"><a href="#tab1" data-toggle="tab"><img src="${personIcon}" /></a><br /><div class="arrow-up"></div></li>
                    <li><a href="#tab2" data-toggle="tab"><img src="${documentIcon}" /></a><br /><div class="arrow-up"></div></li>
                    <li><a href="#tab3" data-toggle="tab"><img src="${clockIcon}" /></a><br /><div class="arrow-up"></div></li>
                    <li><a href="#tab4" data-toggle="tab"><img src="${churchIcon}" /></a><br /><div class="arrow-up"></div></li>
                    <li><a href="#tab5" data-toggle="tab"><img src="${checkIcon}" /></a><br /><div class="arrow-up"></div></li>
                </ul>
            </div>

            <div class="details">
                <div class="container">
                    <div class="tab-content">
                        <div class="tab-pane active fade in" id="tab1">
                            <div class="pastor-info-container">
                                <div class="pastor-photo">
                                    <img src="http://placehold.it/200x200" />
                                </div>
                                <div class="pastor-info">
                                    <h2>Lead Pastors</h2>
                                    <hr />
                                    <h3>Patrick &amp; Marlena Kiteley</h3>
                                    <hr />
                                    <p>
                                        Pastors Patrick and Marlena Kiteley are the Senior Pastors of Shiloh Church. They represent the 4th generation of the Kiteley family to lead Shiloh Church in its 48-year history. Patrick is a beloved speaker world-wide, bringing a prophetic message of restoration, hope and healing wherever he goes. They have been married 15 years and have three children.
                                    </p>
                                </div>
                            </div>
                            <br />
                            <div class="pastor-info-container">
                                <div class="pastor-photo">
                                    <img src="http://placehold.it/200x200" />
                                </div>
                                <div class="pastor-info">
                                    <h2>Care Center Pastors</h2>
                                    <hr />
                                    <h3>Derrick &amp; Heather Sheppard</h3>
                                    <hr />
                                    <p>
                                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="tab2">
                            <h2>Mission Statement</h2>
                            <hr />
                            <p>
                                Mission Statement/Motto/Purpose: Love God, Love People.
                            </p>
                            <p>
                                Welcome Message: We want to take a moment to extend a very warm invite to Shiloh Church. Whether you&apos;re just having a look, or are searching out for a new church home, we would be delighted to have you come and worship with us. Make sure to check out our website for upcoming events and service times! We hope to see you soon!
                            </p>
                            <br />
                            <h2>Statement of Faith</h2>
                            <hr />
                            <p>
                                The whole Bible is our sufficient rule for faith and practice. This Statement of Faith is intended as a basis of fellowship among us (i.e., that we all speak the same things. I Corinthians 1-10; Acts 2:42).
                            </p>                                
                        </div>
                        <div class="tab-pane fade" id="tab3">
                            <h2>Service Times</h2>
                            <hr />
                            <h3>Sunday</h3>
                            <ul>
                                <li>9am</li>
                                <li>11am (sign language translation available)</li>
                                <li>1pm (en Espa&ntilde;ol)
                            </ul>
                            <p><span class="label">Languages:</span> Sign Language, Spanish</p>
                            <p><span class="label">Duration:</span> 1 hr 30 min</p>
                            <br />
                            <p><span class="label">Service Schedule:</span> If you have children please arrive a few minutes before the start of service to get your kids all checked into Shiloh Kids Church/Nursery.</p>
                            <br />
                            <p>8:45am - Kids check in opens (infants to 5th grade)<br />
                                9:00am - 1st Service begins<br />
                                9:30am - Youth Sunday School begins (Jr &amp; Sr High Students)
                            </p>

                        </div>
                        <div class="tab-pane fade" id="tab4">
                            <h2>Church Atmosphere</h2>

                            <div class="service-atmosphere">

                                <div class="general-atmosphere">
                                    <h1>9am Service</h1>
                                    <div class="general-atmosphere-container">
                                        <div class="slider-container">
                                            <h2>General Atmosphere</h2>
                                            <div class="slider" data-slider-value="2" data-slider-description="Modern Compassionate Contemporary">
                                                <div class="slider-description"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="atmosphere-details-container">
                                    <div class="left-atmosphere-details-container">
                                        <div class="slider-container">
                                            <h2>Service style</h2>

                                            <div class="slider" data-slider-value="3" data-slider-description="Lively">
                                                <div class="slider-labels">
                                                    <div class="slider-label-container"><span>CONSERVATIVE</span></div>
                                                    <div class="slider-label-container"><span></span></div>
                                                    <div class="slider-label-container"><span>HIGH ENERGY</span></div>
                                                </div>
                                                <div class="slider-description"></div>
                                            </div>
                                        </div>
                                        <div class="slider-container">
                                            <h2>Age demographics</h2>
                                            <div class="slider" data-slider-value="${organization.ageDemographics}" data-slider-description="All Age Groups">
                                                <div class="slider-labels">
                                                    <div class="slider-label-container"><span>YOUTH</span></div>
                                                    <div class="slider-label-container"><span></span></div>
                                                    <div class="slider-label-container"><span>MATURE</span></div>
                                                </div>
                                                <div class="slider-description"></div>
                                            </div>
                                        </div>
                                        <div class="slider-container">
                                            <h2>Dress attire</h2>

                                            <div class="slider" data-slider-value="5" data-slider-description="Smart Casual">
                                                <div class="slider-labels">
                                                    <div class="slider-label-container"><span>FORMAL</span></div>
                                                    <div class="slider-label-container"><span></span></div>
                                                    <div class="slider-label-container"><span>CASUAL</span></div>
                                                </div>
                                                <div class="slider-description"></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="right-atmosphere-details-container">
                                        <div class="slider-container">
                                            <h2>Music</h2>

                                            <div class="slider" data-slider-value="${organization.musicStyle}" data-slider-description="Blend of both traditional and contemporary.">
                                                <div class="slider-labels">
                                                    <div class="slider-label-container"><span>TRADITIONAL</span></div>
                                                    <div class="slider-label-container"><span></span></div>
                                                    <div class="slider-label-container"><span>CONTEMPORARY</span></div>
                                                </div>
                                                <div class="slider-description"></div>
                                            </div>

                                            <div class="musical-instruments-container">
                                                <div class="musical-instrument">
                                                    <img src="${violinIcon}" />
                                                </div>
                                                <div class="musical-instrument">
                                                    <img src="${pianoIcon}" />
                                                </div>
                                                <div class="musical-instrument">
                                                    <img src="${choirIcon}" />
                                                </div>
                                                <div class="musical-instrument">
                                                    <img src="${guitarIcon}" />
                                                </div>
                                                <div class="musical-instrument">
                                                    <img src="${electricGuitarIcon}" />
                                                </div>
                                                <div class="musical-instrument">
                                                    <img src="${drumsIcon}" />
                                                </div>
                                                <div class="musical-instrument">
                                                    <img src="${saxophoneIcon}" />
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="tab5">
                            <div class="programs-ministries">

                                <h2>Programs &amp; Ministries</h2>    

                                <div class="programs-left-column">
                                    <div class="programs-category">
                                        <div class="program-heading">
                                            <h1>Nursery Care &amp; Educational</h1>
                                        </div>
                                        <div class="program-listing">
                                            <ul>
                                                <li>Infant child care during service</li>
                                                <li>For men (i.e., men&apos;s small group, etc.)</li>
                                                <li>For women (i.e., women&apos;s small group, etc.)</li>
                                                <li>Sunday school</li>
                                            </ul>
                                        </div>
                                    </div>

                                    <div class="programs-category">
                                        <div class="program-heading">
                                            <h1>Social &amp; Spiritual</h1>
                                            <div class="program-listing">
                                                <ul>
                                                    <li>small groups (i.e., life groups, cell groups, home groups, etc.)</li>
                                                    <li>weekly Bible study groups</li>
                                                    <li>choir</li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="programs-right-column">

                                    <div class="programs-category">
                                        <div class="program-heading">
                                            <h1>Support &amp; Outreach</h1>
                                        </div>
                                        <div class="program-listing">
                                            <ul>
                                                <li>social activities</li>
                                                <li>community service/volunteering</li>
                                                <li>mission trips/volunteering abroad</li>
                                                <li>outreach/evangelism</li>
                                                <li>homeless outreach &amp; care</li>
                                            </ul>
                                        </div>
                                    </div>

                                    <div class="programs-category">
                                        <div class="program-heading">
                                            <h1>Age Groups &amp; Creative Arts</h1>
                                        </div>
                                        <div class="program-listing">
                                            <ul>
                                                <li>children&apos;s ministry (K-6)</li>
                                            </ul>
                                        </div>
                                    </div>

                                </div>

                            </div>
                        </div>

                    </div>
                </div>
            </div>

        </div>

        <!--

        <h2>Address Info:</h2>
        Street 1: ${organization.address.street1}<br />
        Street 2: ${organization.address.street2}<br />
        Postal Code: ${organization.address.postalCode}<br />
        State: ${organization.address.state}<br />
        City: ${organization.address.city}<br />
        Country: ${organization.address.country}<br />
        Longitude: ${organization.address.longitude}<br />
        Latitude: ${organization.address.latitude}<br />

        <br />
        <br />
        <h2>Music Style</h2>
        Music Style: ${organization.musicStyle}<br />

        <h2>Language Info:</h2>
        <h2>Images:</h2>
        <h2>Leader Info:</h2>
        <h2>Organization Info:</h2>
        Service Times: ${organization.serviceTimes}<br />
        Service Days: ${organization.serviceDays}<br />
        Religion: ${organization.communityCategory}<br />
        Denomination: ${organization.denomination}<br />
        SubDenomination: ${organization.subDenomination}<br />
        Name: ${organization.name}<br />
        Programs Offered: ${organization.programsOffered}<br />
        Age Demographic: ${organization.ageDemographics}<br />
        Ethnic Demographics: ${organization.ethnicDemographics}<br />
        Lead Pastor Bio: ${organization.srLdrBiography}<br />
        Blurb: ${organization.description}<br />
        Website: ${organization.websiteUrl}<br />
        Facebook: ${organization.facebookUrl}<br />
        Year Founded: ${organization.yearFounded}<br />
        Avg. Congregation Size: ${organization.averageServiceCongregationSize}<br />
        Env. Friendly: ${organization.envFriendly}<br />
        Has Parkinglot: ${organization.parkingLot}<br />
        Is Gay Affirming${organization.gayAffirming}<br />

        -->

        <%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%>

    </body>
</html>