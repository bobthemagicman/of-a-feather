<%@ tag dynamic-attributes="attributes" isELIgnored="false" body-content="empty" %>
<%@ include file="init.jsp" %>
<%@ attribute name="path" required="true" %>
<spring:bind path="${path}">
	<html:attributes var="attrString" attributeMap="${attributes}" type="text" name="${status.expression}" value="${status.value}">
		<input ${attrString} />
	</html:attributes>
	<span style="color:#A00000">${status.errorMessage}</span>
</spring:bind>