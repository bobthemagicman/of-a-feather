<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/init.jsp"%>

<%@ attribute name="isFavorite" required="true" type="java.lang.Boolean" %>
<%@ attribute name="loginUrl" required="true" type="java.lang.String" %>

<spring:url value="/static/images/site/heart_icon_filled_gray.png" var="heartIconEmpty" />
<spring:url value="/static/images/site/heart_icon_green.png" var="heartIconFilled" />

<div class="favorite-icon" data-icon-off-src="${heartIconEmpty}" data-icon-on-src="${heartIconFilled}">
    <sec:authorize access="isAuthenticated()">
        <c:choose>
            <c:when test="${isFavorite}">
                <img src="${heartIconFilled}" class="favorite on" data-status="true"/>    
            </c:when>    
            <c:otherwise>
                <img src="${heartIconEmpty}" class="favorite off" data-status="false"/>
            </c:otherwise>
        </c:choose>                
    </sec:authorize>
    
    <sec:authorize access="isAnonymous()">
        <spring:url value="/signin" var="loginUrl"/><a href="${loginUrl}"><img src="${heartIconEmpty}" class="favorite off" data-status="false"/></a>
    </sec:authorize>
</div>