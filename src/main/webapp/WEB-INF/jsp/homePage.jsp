<%@ page import="com.flockspring.domain.types.MusicStyle"%>
<%@ page import="com.flockspring.domain.types.Affiliation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/init.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Of A Feather - Find your new church home today</title>
	
	<spring:url value="/static/css/bootstrap-responsive.css" var="bootStrapCSS"/>
	<spring:url value="/static/css/styles.css" var="customStyleCSS"/>
	<spring:url value="/static/images/icon.ico" var="ofAFeatherIcon"/>
	
	<link href="${bootStrapCSS }" rel="stylesheet" type="text/css" />
	<link href="${customStyleCSS }" rel="stylesheet" type="text/css" />
	<link href="${ofAFeatherIcon }" rel="icon"  />
	
	<spring:url value="/static/js/iepngfix_tilebg.js" var="iePngFx_tileBg"/>
	<spring:url value="/static/js/iepngfix.js" var="iePngFx"/>
	<script type="text/javascript" src="${iePngFx }"></script>
	<script type="text/javascript" src="${iePngFx_tileBg }"></script>
</head>

<body>
	<div>
		<h1 class="hero-unit">
			<spring:message code="home.discover.your.new.community"	text="Discover Your New Community" />
		</h1>
					
		<spring:url value="/search" var="formAction" />
		<form action="${formAction}" method="GET">
			<input type="text" placeholder="City and State, Neighborhood or Zip" maxlength="30" name="query" />
			<button type="submit">
				<spring:message code="home.page.submit" text="Find a new Church home..."></spring:message>
			</button>
		</form>
	</div>
</body>
</html>