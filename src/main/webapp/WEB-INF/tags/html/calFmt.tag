<%@ tag dynamic-attributes="attributes" isELIgnored="false" body-content="empty" %>
<%@ include file="init.jsp" %>
<%@ attribute name="cal" required="true" type="java.util.Calendar"%>
<%@ attribute name="fmt" required="true" %>


<c:set var="time" value="${cal.time}"/>
<fmt:formatDate var="fmtDate" value="${time}" pattern="${fmt}"/>
${fmtDate}				
