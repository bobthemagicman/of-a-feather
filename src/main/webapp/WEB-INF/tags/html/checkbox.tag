<%@ tag dynamic-attributes="attributes" isELIgnored="false" body-content="empty" %>
<%@ include file="init.jsp" %>
<%@ attribute name="path" required="true" %>

<spring:bind path="${path}">
	<c:if test="${status.value}">
		<c:set var="isChecked" value="checked"/>
	</c:if>
	<html:attributes var="attrString" attributeMap="${attributes}" type="checkbox" name="${status.expression}" value="true">
		<input ${attrString} ${isChecked}/>
	</html:attributes>
	<span style="color:#A00000">${status.errorMessage}</span>
</spring:bind>