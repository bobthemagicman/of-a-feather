<%@ tag language="java" isELIgnored="false" body-content="empty" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/init.jsp"%>

<%@ attribute name="items" required="true" type="java.lang.Iterable" %>
<%@ attribute name="showFavLink" required="false" type="java.lang.Boolean" %>

<spring:url value="/static/images/site/heart_icon.png" var="heartIcon" />
<spring:url value="/static/images/site/right_arrow.png" var="rightArrow" />

<c:forEach items="${items}" var="item" varStatus="p_tracker">
    <spring:url value="/static/images/church-images/${item.id}/sr-${item.displayImage.path}" var="imagePath"/>
    <c:if test="${empty item.displayImage.path}">
        <c:set var="imagePath" value="http://maps.googleapis.com/maps/api/streetview?size=200x200&location=${item.latitude},${item.longitude}&fov=120&pitch=10&sensor=false" />   
    </c:if>
    
    <c:if test="${item.usersFavorite}">
        <spring:url value="/static/images/site/heart_favorited_icon.png" var="heartIcon" />
    </c:if>

    <div class="search-result-entry show-result" data-result-id="${item.id}" data-church-name="${item.organizationName}" data-latitude="${item.latitude}" data-longitude="${item.longitude}">

        <div class="search-result-image-container">
            <img src="${imagePath}" alt="${item.displayImage.alt}" title="${item.displayImage.title}" />
        </div>

        <div class="search-result-info">
            <div class="church-basic-info">
                <spring:url value="/churches/${item.id}?dist=${item.distanceFromSearchPoint}" var="churchUrl" />
                <a href="${churchUrl}"><span class="church-name">${item.organizationName}</span></a>
                <span class="church-denomination">${item.denomination}</span>
                <span class="church-location">${item.city}, ${item.state} ${item.postalCode}<img src="${rightArrow}" /> <span class="distance"><fmt:formatNumber maxFractionDigits="2" value="${item.distanceFromSearchPoint}" /></span> miles away</span>
            </div>
            <div class="church-sliders">
                <div class="slider-container">
                    <div class="slider-label">Service Style</div><div class="info-slider" data-slider-value="${item.serviceStyleSliderValue}"></div>
                </div>
                <div class="slider-container">
                    <div class="slider-label">Music</div><div class="info-slider" data-slider-value="${item.musicStyleSliderValue }"></div>
                </div>
                <div class="slider-container">
                    <div class="slider-label">Dress Attire</div><div class="info-slider" data-slider-value="${item.dressAttireSliderValue }"></div>
                </div>
            </div>
        </div>
        <c:if test="${showFavLink}">
        <sec:authorize access="isAuthenticated()">
        <div class="favorite-icon">
            <a href="#"><img src="${heartIcon}" /></a>
        </div>
        </sec:authorize>
        </c:if>
    </div>                        
</c:forEach>