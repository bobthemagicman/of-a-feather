<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
		<form:form commandName="organizationCommandObject" method="POST">
			<%-- Church Info --%>
			<div class="form-group">
				<form:label path="name">
					<span><spring:message code="add.church.name" text="Name" /></span>
					<form:input path="name" cssClass="form-control" accesskey=""/>
				</form:label>
			</div>
			<div class="form-group">
				<form:label path="yearFounded">
					<span><spring:message code="add.church.year.founded" text="Year Founded" /></span>
					<form:input path="yearFounded" cssClass="form-control" placeholder="e.g. 1999" />
				</form:label>
			</div>

			<%-- Church Contact Info --%>
			<div class="form-group">
				<spring:nestedPath path="address">
				<form:label path="street1">
					<span><spring:message code="add.church.street" text="Street" /></span>
					<form:input path="street1" cssClass="form-control"/>
				</form:label>
			</div>
			<div class="form-group">
				<form:label path="street2">
					<span><spring:message code="add.church.street" text="Street" /></span>
					<form:input path="street2" cssClass="form-control"/>
				</form:label>
			</div>
			<div class="form-group">
				<form:label path="city">
					<span><spring:message code="add.church.city" text="City" /></span>
					<form:input path="city" cssClass="form-control"/>
				</form:label>
				<form:label path="state">
					<span><spring:message code="add.church.state" text="State" /></span>
					<form:input path="state" cssClass="form-control"/>
				</form:label>, <form:label path="postalCode">
					<span><spring:message code="add.church.city" text="Zip Code" /></span>
					<form:input path="postalCode" cssClass="form-control"/>
				</form:label>
			</div>
			<div class="form-group">
				<form:label path="country">
					<span><spring:message code="add.church.country" text="Country" /></span>
					<form:input path="country" disabled="disabled" placeholder="United States" cssClass="form-control" />
				</form:label>
				</spring:nestedPath>
			</div>
			<div class="form-group">
				<form:label path="websiteUrl">
					<span><spring:message code="add.church.website.url"	text="Website URL" /></span>
					<form:input path="websiteUrl" cssClass="form-control" />
				</form:label>
				</div>
			<div class="form-group">
				<form:label path="facebookUrl">
					<span><spring:message code="add.church.facebook.url" text="Facebook URL" /></span>
					<form:input path="facebookUrl" cssClass="form-control" />
				</form:label>
				</div>
			<div class="form-group">
				<form:label path="twitterUrl">
					<span><spring:message code="add.church.twitter.url" text="Twitter URL" /></span>
					<form:input path="twitterUrl" cssClass="form-control" />
				</form:label>
			</div>

			<%-- Church Mission Info --%>
			<div class="form-group">
				<form:label path="denomination">
					<span><spring:message code="add.church.denomination" text="Denomination" /></span>
					<form:select path="denomination" items="${denominations}" cssClass="form-control" >
					</form:select>
				</form:label>

				<form:label path="subDenomination">
					<span><spring:message code="add.church.subdenomination" text="Subdenomination"  /></span>
					<form:select path="subDenomination" cssClass="form-control">
					</form:select>
				</form:label>
			</div>
			<div class="form-group">
				<form:label path="missionStatement">
					<span><spring:message code="add.church.missionStatement" text="Mission Statement" /></span>
					<form:textarea path="missionStatement" cssClass="form-control"/>
				</form:label>
				</div>
			<div class="form-group">
				<form:label path="statementOfFaith">
					<span><spring:message code="add.church.statementOfFaith" text="Statement of Faith"  /></span>
					<form:textarea path="statementOfFaith" cssClass="form-control"/>
				</form:label>
			</div>

			<div class="form-group pull-right">				
				<input type="submit" name="_eventId_cancel" value="Cancel" class="btn btn-primary" />
				<input type="submit" name="_eventId_next" value="Next" class="btn btn-primary" />
			</div>
		</form:form>
	</div>

	<%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%>

</body>
</html>