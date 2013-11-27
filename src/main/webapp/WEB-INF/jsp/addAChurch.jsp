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
		<spring:url value="/addAChurch" var="formAction" />
		<form:form commandName="organizationCommandObject" action="${formAction}" method="POST">
			<%-- Church Info --%>
			<div class="form-group">
				<form:label path="name">
					<span><spring:message code="add.church.name" text="Name" /></span>
					<form:input path="name" />
				</form:label>

				<form:label path="yearFounded">
					<span><spring:message code="add.church.year.founded"
							text="Year Founded" /></span>
					<form:input path="yearFounded" />
				</form:label>
			</div>

			<%-- Church Contact Info --%>
			<div class="form-group">
				<spring:nestedPath path="address">
					<form:label path="street1">
						<span><spring:message code="add.church.street"
								text="Street" /></span>
						<form:input path="street1" />
					</form:label>
					<form:label path="street2">
						<span><spring:message code="add.church.street"
								text="Street" /></span>
						<form:input path="street2" />
					</form:label>
					<form:label path="city">
						<span><spring:message code="add.church.city" text="City" /></span>
						<form:input path="city" />
					</form:label>
					<form:label path="state">
						<form:input path="state" />
					</form:label>, <form:label path="postalCode">
						<form:input path="postalCode" />
					</form:label>
					<form:label path="country">
						<span><spring:message code="add.church.country"
								text="Country" /></span>
						<form:input path="country" disabled="disabled"
							placeholder="United States" />
					</form:label>
				</spring:nestedPath>

				<form:label path="websiteUrl">
					<span><spring:message code="add.church.website.url"
							text="Website URL" /></span>
					<form:input path="websiteUrl" />
				</form:label>
				<form:label path="facebookUrl">
					<span><spring:message code="add.church.facebook.url"
							text="Facebook URL" /></span>
					<form:input path="facebookUrl" />
				</form:label>
				<form:label path="twitterUrl">
					<span><spring:message code="add.church.twitter.url"
							text="Twitter URL" /></span>
					<form:input path="twitterUrl" />
				</form:label>
			</div>

			<%-- Church Mission Info --%>
			<div class="form-group">
				<form:label path="denomination">
					<span><spring:message code="add.church.denomination"
							text="Denomination" /></span>
					<form:select path="denomination">
					</form:select>
				</form:label>

				<form:label path="subDenomination">
					<span><spring:message code="add.church.subdenomination"
							text="Subdenomination" /></span>
					<form:select path="subDenomination">
					</form:select>
				</form:label>

				<form:label path="missionStatement">
					<span><spring:message code="add.church.missionStatement"
							text="Mission Statement" /></span>
					<form:textarea path="missionStatement" />
				</form:label>
				<form:label path="statementOfFaith">
					<span><spring:message code="add.church.statementOfFaith"
							text="Statement of Faith" /></span>
					<form:textarea path="statementOfFaith" />
				</form:label>
			</div>

			<div class="form-group">
				<input type="submit" name="_eventId_next" value="Proceed" /> <input
					type="submit" name="_eventId_cancel" value="Cancel" />
			</div>
		</form:form>
	</div>

	<%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%>

</body>
</html>