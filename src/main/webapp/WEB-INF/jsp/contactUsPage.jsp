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

<spring:url value="/static/images/site/area_map.jpg" var="areaMap"/>

<div class="container contact-page">
    <div class="row">
        <div class="col-sm-12">
            <h1>Contact Us</h1>
            <hr />
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6">

            <dl>
                <dt>Phone:</dt>
                <dd>415-504-2914</dd>
                <dt>Email:</dt>
                <dd>hello@ofafeather.org</dd>
                <dt>Location:</dt>
                <dd>We are headquartered in the San Francisco Bay Area.</dd> 
            </dl>
        </div>
        <div class="col-sm-6">
            <img class="area-map" src="${areaMap}" />
        </div>
    </div>

    <div class="filler">&nbsp;</div>

</div>

<%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%>

</body>