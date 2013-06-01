<%@ page import="com.flockspring.ui.model.UIMusicStyle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/init.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<spring:url value="/resources/css/bootstrap-responsive.css" var="bootStrapRespCss"/>
<link href="${bootStrapRespCss}" rel="stylesheet">
<spring:url value="/resources/css/flockspring.css" var="flockspringCss"/>
<link href="${flockspringCss}" rel="stylesheet">

<title>FlockSpring.com - Home</title>
</head>
<body>
	<header id="fs_header"></header>
	<section id="fs_banner" class="row banner">
		<div class="offset2 span10">
			<h1 class="hero-unit"><spring:message code="home.discover.your.new.community" text="Discover Your New Community" /></h1></div>
			<form action="" id="fs_communitySerachForm" class="form-inline">
				
				<select id="fs_location">
					<option>Select Region</option>
					<option value="1">San Francisco</option>
					<option value="2">Seattle</option>
				</select>
				
				<select id="fs_musicType">
					<option>Select Music Style</option>
					<c:forEach items="<%= UIMusicStyle.values() %>" var="type">
						<option value="${type}">${type}</option>
					</c:forEach>
				</select>
				
				<select id="fs_religion">
					<option>Select Religion Group</option>
					<c:forEach items="${religions}" var="religion">
						<option value="${religion.id}">${religion.name}</option>
					</c:forEach>
				</select>
			</form>
	</section>
</body>
</html>