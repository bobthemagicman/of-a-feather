<%@ tag dynamic-attributes="attributes" isELIgnored="false" body-content="empty" %>
<%@ include file="init.jsp" %>
<%@ attribute name="path" required="true" %>
<spring:bind path="${path}">
	<html:attributes var="attrString" attributeMap="${attributes}" type="radio" name="${status.expression}" value="${status.value}">
		<radio ${attrString} />
	</html:attributes>
	<span style="color:#A00000">${status.errorMessage}</span>
</spring:bind>