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
		<h2>
			<spring:message code="add.a.church.leadership.team"
				text="Leadership Team" />
		</h2>
		<form:form commandName="organizationCommandObject" method="POST" enctype="multipart/form-data">
			<div class="form-group">
				<form:label path="leadershipTeam[0].name">
					<span><spring:message code="add.a.church." text="" /></span>
					<form:input path="leadershipTeam[0].name" />
				</form:label>
			</div>
			<div class="form-group">
				<form:label path="leadershipTeam[0].bio">
					<span><spring:message code="add.a.church." text="" /></span>
					<form:textarea path="leadershipTeam[0].bio" />
				</form:label>
			</div>
			<div class="form-group">
				<form:label path="leadershipTeam[0].title">
					<span><spring:message code="add.a.church." text="" /></span>
					<form:input path="leadershipTeam[0].title" />
				</form:label>
			</div>
			<div class="form-group">
				<form:label path="leadershipTeam[0].primaryContact">
					<span><spring:message code="add.a.church." text="" /></span>
					<form:checkbox path="leadershipTeam[0].primaryContact" />
				</form:label>
				<form:label path="leadershipTeam[0].primaryLeader">
					<span><spring:message code="add.a.church." text="" /></span>
					<form:checkbox path="leadershipTeam[0].primaryLeader" />
				</form:label>
			</div>

			
			<input type="file" name="imageFile" id="imageFile" />
			
		</form:form>

	</div>

	<%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%>

</body>
</html>