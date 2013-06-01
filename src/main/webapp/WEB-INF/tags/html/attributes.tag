<%@ tag dynamic-attributes="attributes" isELIgnored="false" %>
<%@ include file="init.jsp" %>
<%@ attribute name="var" required="true" rtexprvalue="false" %>
<%@ attribute name="attributeMap" type="java.util.Map" %>
<%@ variable name-from-attribute="var" alias="attrString" declare="false" %>
<c:forEach var="attr" items="${attributeMap}">
	<c:set var="attrString">
	    <c:out escapeXml="false" value="${attrString} ${attr.key}=\""/><c:out value="${attr.value}"/><c:out escapeXml="false" value="\""/>
	</c:set>
</c:forEach>
<c:forEach var="attr" items="${attributes}">
	<c:if test="${empty attributeMap[attr.key]}">
		<c:set var="attrString">
	    	<c:out escapeXml="false" value="${attrString} ${attr.key}=\""/><c:out value="${attr.value}"/><c:out escapeXml="false" value="\""/>
		</c:set>
	</c:if>
</c:forEach>
<jsp:doBody />