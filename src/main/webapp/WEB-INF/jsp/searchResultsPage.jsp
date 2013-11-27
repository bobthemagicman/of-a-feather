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

<div class="container front-page-temp">	
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
	
	<a href="javaScript:testFilterMessage();return false;" class="btn btn-primary">Test Filter Message</a>
</div>	
	<spring:url value="/search/ajax/filter-results" var="ajaxUrl" />
	<script>
		function testFilterMessage()
		{
			
			var affiliationArray = new Array('NONDENOMINATIONAL', 'METHODISTS', 'ANGLICANISM');
			var jsonData = JSON.stringify({ "affiliations" : affiliationArray });
			
			$.ajax({
				url: '${ajaxUrl}',
				type: 'POST', 
				data: jsonData,
				contentType: 'application/json',
				dataType: 'json',
				error: function() {
					alert("Failed");
				},
				success: function(xhr) {
					alert("Success:" + xhr)
				}				
			});
		}
	</script>
<%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%>

</body>
</html>