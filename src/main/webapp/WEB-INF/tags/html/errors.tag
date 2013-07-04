<%@ page language="java" import="javax.servlet.jsp.PageContext" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>

<%@ tag dynamic-attributes="attributes" isELIgnored="false" body-content="empty" %>
<%@ include file="init.jsp" %>
<%@ attribute name="path" required="true" %>
<%@ attribute name="fields" required="false"%>
<spring:hasBindErrors name="${path}">
	<div style="color:#A00000">
		<p>Please correct the following errors:</p>
		<ul class="errors">
			<spring:bind path="${path}">
				<c:forEach items="${status.errorMessages}" var="error">
					<li><c:out value="${error}"/></li>
				</c:forEach>
			</spring:bind>
			<c:if test="${fields}">
				<spring:bind path="${path}.*">
					<c:forEach items="${status.errorMessages}" var="error">
						<li><c:out value="${error}"/></li>
					</c:forEach>
				</spring:bind>
			</c:if>
		</ul>
	</div>
</spring:hasBindErrors>