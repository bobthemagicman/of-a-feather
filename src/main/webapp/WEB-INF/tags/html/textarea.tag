<%@ tag dynamic-attributes="attributes" isELIgnored="false" %>
<%@ include file="init.jsp" %>
<%@ attribute name="path" required="true" %>
<%@ attribute name="clear" %>
<spring:bind path="${path}">
	<html:attributes var="attrString" attributeMap="${attributes}" name="${status.expression}">
		<c:if test="${clear != \"true\"}">
			<jsp:doBody var="value" />
			<c:if test="${empty value}">
				<c:set var="value" value="${status.value}" />
			</c:if>
		</c:if>
		<textarea ${attrString}>${value}</textarea>
	</html:attributes>
	<span style="color:#A00000">${status.errorMessage}</span>
</spring:bind>