<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/init.jsp"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <%-- Common Metadata, scripts, and CSS --%>
        <%@ include file="/WEB-INF/jsp/partials/commonHead.jsp"%>

        <spring:url value="/static/js/jquery.geocomplete.js" var="geoCompletePlugin" />
        <spring:url value="/static/css/elastislide.css" var="elastislideCSS" />
        <link rel="stylesheet" type="text/css" href="${elastislideCSS}" />
        
        <spring:url value="/static/js/profile.js" var="profileJS" />
        <spring:url value="/static/js/jquery.elastislide.js" var="elastislideJS" />
        <spring:url value="/static/js/modernizr.custom.17475.js" var="modernizrJS" />
        
        <script type="text/javascript">
            $LAB.queueScript("${profileJS}")
                    .queueScript("https://maps.googleapis.com/maps/api/js?libraries=places&sensor=false&callback=initializeMap")
                    .queueScript("${geoCompletePlugin}")
                    .queueScript("${modernizrJS}")
                    .queueScript("${elastislideJS}")
                    .runQueue();
        </script>

        <title>Of A Feather - Find your new church home today</title>   
    </head>
    <body>

        <%-- Site Header --%>
        <c:set var="navSearchEnabled" value="true" />
        <%@ include file="/WEB-INF/jsp/partials/siteHeader.jsp"%>

        <spring:url value="/static/images/site/calendar_icon.png" var="calendarIcon"/>
        <spring:url value="/static/images/site/check_icon.png" var="checkIcon"/>
        <spring:url value="/static/images/site/church_icon.png" var="churchIcon"/>
        <spring:url value="/static/images/site/clock_icon.png" var="clockIcon"/>
        <spring:url value="/static/images/site/document_icon.png" var="documentIcon"/>
        <spring:url value="/static/images/site/envelope_icon.png" var="envelopeIcon"/>
        <spring:url value="/static/images/site/facebook_icon.png" var="facebookIcon"/>
        <spring:url value="/static/images/site/youtube_icon.png" var="youtubeIcon"/>
        <spring:url value="/static/images/site/google_plus_icon.png" var="googlePlusIcon"/>
        <spring:url value="/static/images/site/heart_icon.png" var="heartIcon"/>
        <spring:url value="/static/images/site/heart_icon_filled_gray.png" var="heartIconFilled"/>
        <spring:url value="/static/images/site/info_icon.png" var="infoIcon"/>
        <spring:url value="/static/images/site/instagram_icon.png" var="instagramIcon"/>
        <spring:url value="/static/images/site/left_arrow.png" var="leftArrow"/>
        <spring:url value="/static/images/site/left_arrow_hover.png" var="leftArrowHover"/>
        <spring:url value="/static/images/site/left_arrow_large.png" var="leftArrowLarge"/>
        <spring:url value="/static/images/site/magnifying_glass_icon.png" var="magnifyingGlassIcon"/>
        <spring:url value="/static/images/site/person_icon.png" var="personIcon"/>
        <spring:url value="/static/images/site/right_arrow.png" var="rightArrow"/>
        <spring:url value="/static/images/site/right_arrow_hover.png" var="rightArrowHover"/>
        <spring:url value="/static/images/site/right_arrow_large.png" var="rightArrowLarge"/>
        <spring:url value="/static/images/site/small_checkmark.png" var="smallCheckmark"/>
        <spring:url value="/static/images/site/twitter_icon.png" var="twitterIcon"/>
        <spring:url value="/static/images/site/visiting_icon.png" var="visitingIcon"/>

        <div class="main">

            <div class="container profile" data-church-name="${organization.overview.name}" data-latitude="${organization.overview.address.latitude}" data-longitude="${organization.overview.address.longitude}">
            
                <div class="profile-top">
    
                    
                    <spring:url value="/search" var="searchAction" />
                    <div class="back-to-results-link">
                       <c:if test="${hasPreviousSearch}"><a class="btn btn-primary" href="${searchAction}${searchQuery}"><span class="glyphicon glyphicon-arrow-left"></span> Back to Search Results</a></c:if>
                    </div>
                   
                    
                    <div class="media-container">

                        <div class="media-carousel-container active-media">

                            <div class="media-carousel carousel slide">
                                <div class="media-left-arrow" data-slide="prev">
                                    <img src="${leftArrowLarge}" />
                                </div>
                                <div class="carousel-inner">
                                    <c:choose>
                                    <c:when test="${not empty organization.multimedia}">
                                    <c:forEach items="${organization.multimedia}" var="multimediaObject" varStatus="p_tracker">
                                        <c:set var="cssClass" value="item" />
                                        <c:if test="${p_tracker.first}">
                                            <c:set var="cssClass" value="item active" />
                                        </c:if>

                                        <c:if test="${multimediaObject.video ne true}">
                                            <spring:url value="/static/images/church-images/${organization.id}/${multimediaObject.path}" var="imgSrc"/>
                                            <div class="${cssClass}">
                                                <img src="${imgSrc}" title="${multimediaObject.title}" alt="${multimediaObject.alt}" data-thumbnail-page="0"/>
                                            </div>                                  
                                        </c:if>

                                        <c:if test="${multimediaObject.video}">
                                            <div class="item">
                                                <div class="video-placeholder" data-video-code="j73gbEFYHTs" data-video-type="YT" data-thumbnail-page="2"></div>
                                            </div>
                                        </c:if>
                                    </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                      <div class="item active">
                                          <img src="http://placehold.it/535x535&text=Church+Images+Not+Provided" title="${multimediaObject.title}" alt="${multimediaObject.alt}" data-thumbnail-page="0"/>
                                      </div>
                                    </c:otherwise>
                                    </c:choose>        
                                </div>
                                <div class="media-right-arrow" data-slide="next">
                                    <img src="${rightArrowLarge}" />
                                </div>
                            </div>

                        </div>

                        <ul class="elastislide-list">
                            <c:choose>
                                <c:when test="${not empty organization.multimedia}">
                            
	                            <c:forEach items="${organization.multimedia}" var="multimediaObject" varStatus="p_tracker">
	                               <spring:url value="/static/images/church-images/${organization.id}/${multimediaObject.path}" var="thumImgSrc"/>
                            <li class="photo" data-slide-link="${p_tracker.index}"><img src="${thumImgSrc}" /></li>
	                            </c:forEach>
	                            </c:when>
	                            <c:otherwise>
	                        <li class="photo" data-slide-link="0"><img src="http://placehold.it/100x100&text=Church+Images+Not+Provided" /></li>    
	                            </c:otherwise>
	                        </c:choose>
                        </ul>

                    </div>

                    <div class="vcard profile-top-info">

                        <div class="church-intro-container">

                            <div class="church-intro">

                                <h1 class="org">${organization.overview.name}</h1>

                                <h2><spring:message code="${organization.overview.denominationLocalizationCode}" /></h2>

                                <c:if test="${not empty organization.overview.subDenominationLocalizationCode}">
                                    <h2><spring:message code="${organization.overview.subDenominationLocalizationCode}" /></h2>
                                </c:if>

                                <div class="basic-info-container">

                                    <div class="profile-large-icon-container">
                                        <img src="${infoIcon}" />
                                    </div>

                                    
                                    
                                        
                                    <div class="basic-info">
                                        <c:if test="${organization.overview.yearFounded ne 0}">Founded in ${foundedYear}<br /></c:if>
                                        Pastor &gt; <span class="church-leader">${organization.overview.leadPastorName}</span><br />
                                        Size &gt; <spring:message code="${organization.overview.averageServiceCongregationSize.localizedStringCode}" />
                                    </div>

                                </div>

                                <div class="contact-info-container">

                                    <div class="profile-large-icon-container">
                                        <img src="${envelopeIcon}" />
                                    </div>

                                    <div class="contact-info">
                                        <span class="tel">${organization.overview.phoneNumber}</span><br />
                                        <a class="url fn n" href="${organization.overview.websiteUrl}">${organization.overview.websiteUrl}</a>
                                    </div>

                                </div>

                            </div>

                            <div class="profile-icons-container">
                                <img src="${heartIcon}" />
                                <c:if test="${not empty organization.socialMedia.facebookUrl}">
                                    <a href="${organization.socialMedia.facebookUrl}" target="_blank"><img src="${facebookIcon}" /></a>
                                    </c:if>

                                <c:if test="${not empty organization.socialMedia.twitterUrl}">
                                    <a href="${organization.socialMedia.twitterUrl}" target="_blank"><img src="${twitterIcon}" /></a>
                                    </c:if>

                                <c:if test="${not empty organization.socialMedia.instagramUrl}">
                                    <a href="${organization.socialMedia.instagramUrl}" target="_blank"><img src="${instagramIcon}" /></a>
                                    </c:if>

                                <c:if test="${not empty organization.socialMedia.youtubeUrl}">
                                    <a href="${organization.socialMedia.youtubeUrl}" target="_blank"><img src="${youtubeIcon}" /></a>
                                    </c:if>

                                <c:if test="${not empty organization.socialMedia.googlePlusUrl}">
                                    <a href="${organization.socialMedia.googlePlusUrl}" target="_blank"><img src="${googlePlusIcon}" /></a>
                                    </c:if>
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
                                    ${organization.overview.serviceTimeShortString1}<br />
                                    ${organization.overview.serviceTimeShortString2}
                                </p>
                            </div>

                        </div>

                        <div class="location-info">
                            <div class="adr location">
                                <span class="street-address">${organization.overview.address.street1}</span>
                                <span class="street-address">${organization.overview.address.street2}</span><br />
                                <span class="locality">${organization.overview.address.city}</span>, <span class="region">${organization.overview.address.state}</span> <span class="postal-code">${organization.overview.address.postalCode}</span> <span class="country-name">${organization.overview.address.country}</span><br />
                                <c:if test="${organization.overview.parkingLotAvailable}">
                                    <span class="transportation-info">Parking Lot Available</span>
                                </c:if>
                            </div>

                            <c:if test="${organization.overview.distanceFromSearchPoint ne -1}">
                                <div class="distance-info">
                                    <span class="distance"><fmt:formatNumber maxFractionDigits="2">${organization.overview.distanceFromSearchPoint}</fmt:formatNumber> miles away</span>
                                    </div>
                            </c:if>
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
                        <li class="active has-tooltip" title="Church Leadership"><a href="#tab1" data-toggle="tab"><img src="${personIcon}" /></a><br /><div class="arrow-up"></div></li>
                        <li class="has-tooltip" title="Statement of Faith"><a href="#tab2" data-toggle="tab"><img src="${documentIcon}" /></a><br /><div class="arrow-up"></div></li>
                        <li class="has-tooltip" title="Service Times"><a href="#tab3" data-toggle="tab"><img src="${clockIcon}" /></a><br /><div class="arrow-up"></div></li>
                        <li class="has-tooltip" title="Church Atmosphere"><a href="#tab4" data-toggle="tab"><img src="${churchIcon}" /></a><br /><div class="arrow-up"></div></li>
                        <li class="has-tooltip" title="Programs &amp; Ministries"><a href="#tab5" data-toggle="tab"><img src="${checkIcon}" /></a><br /><div class="arrow-up"></div></li>
                    </ul>
                </div>

                <div class="details">
                    <div class="container">
                        <div class="tab-content">
                        
                            <%-- Leader Details Pane--%>
                            <div class="tab-pane active fade in" id="tab1">
                                <c:forEach items="${organization.leadershipTeam}" var="leader" varStatus="p_tracker">
                                    <div class="pastor-info-container">
                                        <div class="pastor-photo">
                                            <spring:url value="/static/images/church-images/${organization.id}/${leader.image.path}" var="leaderImgSrc" />
                                            <c:if test="${empty leader.image.path}">
                                                <c:set var="leaderImgSrc" value="http://placehold.it/200x200&text=Pastor+Image+Not+Provided" />
                                            </c:if>
                                            <img src="${leaderImgSrc}" alt="${leader.image.alt}" title="${leader.image.title}"/>
                                        </div>
                                        <div class="pastor-info">
                                            <c:set var="leaderTitle" value="${leader.title}" />
                                            <c:if test="${empty leaderTitle and p_tracker.index eq 0}">
                                                <c:set var="leaderTitle" value="Lead Pastor" />
                                            </c:if>
                                            <c:if test="${empty leaderTitle and p_tracker.index ne 0}">
                                                <c:set var="leaderTitle" value="Pastor" />
                                            </c:if>
                                            <h2>${leaderTitle}</h2>
                                            <h3>${leader.name}</h3>
                                            <br />
                                            
                                            <c:choose>
                                            <c:when test="${empty leader.bio}">
                                                <p>We apologize but this organization has not provided us with a bio for this leader.</p>
                                            </c:when>
                                            <c:otherwise>
                                                <p>${leader.bio}</p>
                                            </c:otherwise>
                                            </c:choose>
                                            
                                        </div>
                                    </div>
                                    <br />
                                </c:forEach>
                            </div>
                            
                            <%-- Messages Pane--%>
                            <div class="tab-pane fade" id="tab2">
                            
                            <c:if test="${not empty organization.statements.welcomeMessage}">
                                <h2>Welcome Message</h2>
                                <hr />
                                <p>${organization.statements.welcomeMessage}</p>
                                <br />                                        
                            </c:if>
                                
                                <h2>Mission Statement</h2>
                                <hr />
                            <c:choose>
                                <c:when test="${not empty organization.statements.missionStatement}">
                                <p>${organization.statements.missionStatement}</p>
                                </c:when>
                                <c:otherwise>
                                <p class="not-provided">We apologize but this organization has not provided us with their Mission Statement</p>
                                </c:otherwise>
                            </c:choose>
                                <br />
                            
                                <h2>Statement of Faith</h2>
                                <hr />
                            <c:choose>
                                <c:when test="${not empty organization.statements.statementOfFaith}">
                                <p>${organization.statements.statementOfFaith}</p>
                                </c:when>
                                <c:otherwise>
                                <p class="not-provided">We apologize but this organization has not provided us with their Statement of Faith</p>
                                </c:otherwise>                                        
                            </c:choose>
                            </div>
                            
                            <%-- Service Times Pane--%>
                            <div class="tab-pane fade" id="tab3">
                                <h2>Service Times</h2>
                                <hr />
                                
                                <c:forEach items="${organization.serviceDayTimes}" var="entry">
                                <h3><spring:message code="${entry.key}" /></h3>
                                <ul>
                                    <c:forEach items="${entry.value}" var="time">
                                    <li>${time}</li>
                                    </c:forEach>
                                </ul>
                                </c:forEach>
                                
                                <c:if test="${not empty organization.servicesOverview.languages}">
                                <p><span class="label">Languages:</span>&nbsp; 
                                    <c:forEach items="${organization.servicesOverview.languages}" var="lang">
                                        <span class="service-lang">
                                            <c:choose>
                                                <c:when test="${not empty lang.localizedName and not empty lang.englishName and lang.localizedName ne lang.englishName}">
                                                    ${lang.localizedName}&nbsp;&#40;${lang.englishName}&#41;
                                                </c:when>
                                                <c:otherwise>
                                                    ${lang.englishName}
                                                </c:otherwise>
                                            </c:choose>
                                        </span>,&nbsp;
                                    </c:forEach>
                                </p>
                                </c:if>

                                <c:set var="minutes" value="${organization.servicesOverview.durationInMinutes % 60 }" />
                                <c:set var="hours" value="${(organization.servicesOverview.durationInMinutes - minutes) / 60}"/>
                                <c:set var="hrString" value="hr" />
                                <c:if test="${hours > 1}"><c:set var="hrString" value="hrs" /></c:if>
                                <p><span class="label">Duration:</span> <fmt:formatNumber pattern="#" value="${hours}" /> ${hrString} <c:if test="${minutes ne 0}">${minutes} min</c:if></p>
                                <br />
                                
                                <c:if test="${not empty organization.servicesOverview.serviceSchedule}">
                                <p><span class="label">Service Schedule:&nbsp;</span>${organization.servicesOverview.serviceSchedule}</p>
                                </c:if>
                            </div>
                            
                            <%-- Atmosphere Pane--%>
                            <div class="tab-pane fade" id="tab4">
                                <h2>Church Atmosphere</h2>
                                <c:forEach items="${organization.serviceDetails}" var="serviceDetail">
                                    <div class="service-atmosphere">

                                        <div class="general-atmosphere">
                                            <h1>${serviceDetail.serviceName}</h1>
                                            <%-- 
                                        <div class="general-atmosphere-container">
                                            <div class="slider-container">
                                                <h2>General Atmosphere</h2>
                                                <div class="slider" data-slider-value="2" data-slider-description="Modern Compassionate Contemporary">
                                                    <div class="slider-description"></div>
                                                </div>
                                            </div>
                                        </div>
                                            --%>
                                        </div>
                                        <div class="atmosphere-details-container">
                                            <div class="left-atmosphere-details-container">
                                                <c:if test="${not empty serviceDetail.serviceStyle}">
                                                    <div class="slider-container">
                                                        <h2>Service style</h2>

                                                        <spring:message code="${serviceDetail.serviceStyle.localizedStringCode}" var="serviceStyleSliderDesc" />
                                                        <div class="slider" data-slider-value="${serviceDetail.serviceStyle.ordinal + 1}" data-slider-description="${serviceStyleSliderDesc}">
                                                            <div class="slider-labels">
                                                                <div class="slider-label-container"><span>CONSERVATIVE</span></div>
                                                                <div class="slider-label-container"><span></span></div>
                                                                <div class="slider-label-container"><span>HIGH ENERGY</span></div>
                                                            </div>
                                                            <div class="slider-description"></div>
                                                        </div>
                                                    </div>
                                                </c:if>

                                                <c:if test="${not empty serviceDetail.ageDemographics}">
                                                    <spring:message code="${serviceDetail.ageDemographics.localizedStringCode}" var="ageDemographicsSliderDesc" />
                                                    <div class="slider-container">
                                                        <h2>Age demographics</h2>
                                                        <div class="slider" data-slider-value="${serviceDetail.ageDemographics.ordinal + 1}" data-slider-description="${ageDemographicsSliderDesc}">
                                                            <div class="slider-labels">
                                                                <div class="slider-label-container"><span>YOUTH</span></div>
                                                                <div class="slider-label-container"><span></span></div>
                                                                <div class="slider-label-container"><span>MATURE</span></div>
                                                            </div>
                                                            <div class="slider-description"></div>
                                                        </div>
                                                    </div>
                                                </c:if>

                                                <c:if test="${not empty serviceDetail.dressAttire}">
                                                    <spring:message code="${serviceDetail.dressAttire.localizedStringCode}" var="dressAttireSliderDesc" />
                                                    <div class="slider-container">
                                                        <h2>Dress attire</h2>

                                                        <div class="slider" data-slider-value="${serviceDetail.dressAttire.ordinal + 1}" data-slider-description="${dressAttireSliderDesc}">
                                                            <div class="slider-labels">
                                                                <div class="slider-label-container"><span>FORMAL</span></div>
                                                                <div class="slider-label-container"><span></span></div>
                                                                <div class="slider-label-container"><span>CASUAL</span></div>
                                                            </div>
                                                            <div class="slider-description"></div>
                                                        </div>
                                                    </div>
                                                </c:if>
                                            </div>

                                            <c:if test="${not empty serviceDetail.musicStyle}">
                                                <div class="right-atmosphere-details-container">
                                                    <div class="slider-container">
                                                        <h2>Music</h2>
                                                        <spring:message code="${serviceDetail.musicStyle.localizedStringCode}" var="musicStyleSliderDesc" />
                                                        <div class="slider" data-slider-value="${serviceDetail.musicStyle.ordinal + 1}" data-slider-description="${musicStyleSliderDesc}">
                                                            <div class="slider-labels">
                                                                <div class="slider-label-container"><span>TRADITIONAL</span></div>
                                                                <div class="slider-label-container"><span></span></div>
                                                                <div class="slider-label-container"><span>CONTEMPORARY</span></div>
                                                            </div>
                                                            <div class="slider-description"></div>
                                                        </div>

                                                        <c:if test="${not empty serviceDetail.musicalInstruments}">
                                                            <div class="musical-instruments-container">
                                                                <c:forEach items="${serviceDetail.musicalInstruments}" var="instrument">
                                                                    <div class="musical-instrument ${fn:toLowerCase(instrument)}"></div>
                                                                </c:forEach>
                                                            </div>
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </c:if>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            
                            <%-- Program Details Pane--%>
                            <div class="tab-pane fade" id="tab5">
                                <div class="programs-ministries">

                                    <h2>Programs &amp; Ministries</h2>    

                                    <div class="programs-left-column">

                                        <c:forEach items="${organization.programsOffered}" var="entry" varStatus="p_tracker">
                                            <div class="programs-category">

                                                <div class="program-heading">
                                                    <h1><spring:message code="${entry.key.localizedStringCode}" /></h1>
                                                </div>
                                                <div class="program-listing">
                                                    <ul>
                                                        <c:forEach items="${entry.value}" var="program">
                                                            <li><spring:message code="${program.localizedStringCode}" /></li>
                                                            </c:forEach>
                                                    </ul>
                                                </div>
                                            </div>

                                            <c:if test="${((fn:length(organization.programsOffered) % 2 ne 0) and (p_tracker.index +1) eq ((fn:length(organization.programsOffered) + 1) /2)) or (fn:length(organization.programsOffered) % 2 eq 0 and (fn:length(organization.programsOffered) / 2 eq (p_tracker.index + 1)))}">    
                                            </div>
                                            <div class="programs-right-column">
                                            </c:if>
                                        </c:forEach>
                                    </div>

                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
        </div>
        <%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%>

    </body>
</html>