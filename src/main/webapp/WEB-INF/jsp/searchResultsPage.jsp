<%@ page import="com.flockspring.domain.types.MusicStyle"%>
<%@ page import="com.flockspring.domain.types.Affiliation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/init.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html} charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	span {font-weight: bold;}
</style>
</head>
<body>	
	<div><span>Total Number of Results: </span>${results.size()}</div>
	<c:forEach items="${results}" var="result" varStatus="p_tracker">
		<h2>Organization ${p_tracker.index + 1}</h2>
		
		<p><span>Image: </span></p>			
		<spring:url value="/static/images/${result.displayImage.path}" var="imagePath"/>
		<p><img src="${imagePath}" alt="${result.displayImage.alt}" title="${result.displayImage.title}" width="300" height="300"/></p>
	
	    <p><span>Name: </span>${result.organizationName}</p>
	    <p><span>Service Times: </span>${result.serviceTimes}</p>
	    <p><span>Denomination: </span><spring:message code="${result.denomination}" /></p>
	    <p><span>Distance from searched query: </span>${result.distanceFromSearchPoint}</p>
	    <p><span>Is organization featured: </span><c:out value="${result.featured}" /></p>
	    <p><span>Is organization user favorite: </span><c:out value="${result.usersFavorite}" /></p>
	</c:forEach>
	
</body>
</html>