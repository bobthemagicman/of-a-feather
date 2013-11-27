<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/init.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<%-- Common Metadata, scripts, and CSS --%>
<%@ include file="/WEB-INF/jsp/partials/commonHead.jsp"%>

<title>Of A Feather - Add Your Church</title>
</head>
<body>

	<%-- Site Header --%>
	<%@ include file="/WEB-INF/jsp/partials/siteHeader.jsp"%>

	<div class="container front-page-temp">
		<spring:url value="/addYourChurch/form/page/1" var="formAction" />
		<form:form commandName="organizationCommandObject"
			action="${formAction}" method="POST">
			<%-- Church Demographic Info --%>
			<form:label path="congregationSize">
				<form:input path="congregationSize" />
			</form:label>
			<form:label path="congregationSize">
				<form:input path="musicStyle" />
			</form:label>
			<form:label path="congregationSize">
				<form:input path="dressAttire" />
			</form:label>
			<form:label path="congregationSize">
				<form:input path="congregationSize" />
			</form:label>

			<%-- Church Online Info --%>
			<form:label path="serviceTimes">
				<form:select path="serviceTimes" items="" />
			</form:label>

			<form:label path="serviceDays">
				<form:input path="serviceDays" />
			</form:label>

			<form:label path="languages">
				<form:input path="languages" />
			</form:label>

			<%-- Church Images --%>
			<%--Figure this out later --%>

			<input type="submit" name="_eventId_proceed" value="Proceed" />
			<input type="submit" name="_eventId_cancel" value="Cancel" />
		</form:form>

	</div>

	<%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%>

</body>
</html>