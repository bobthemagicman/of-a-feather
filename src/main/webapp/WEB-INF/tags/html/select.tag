<%@ tag dynamic-attributes="attributes" isELIgnored="false" body-content="empty" %>
<%@ include file="init.jsp" %>
<%@ attribute name="path" required="true" %>
<%@ attribute name="selectType" required="true" %>
<%@ attribute name="list" required="true" type="java.util.List"%>
<spring:bind path="${path}">
	<c:if test="${selectType}">
		<c:set var="isMultiple" value="multiple"/>
	</c:if>
	<html:attributes var="attrString" attributeMap="${attributes}" name="${status.expression}">
		<select ${attrString} ${isMultiple}>
			<!-- Add status.value check for auto selecting the correct value -->
			<c:if test="${!selectType}">
			<option selected value="">None Selected</option>
			</c:if>
			<c:forEach items="${list}" var="element">
				<c:choose>
					<c:when test="${status.value.id eq element.id}">
						<option selected value="${element.id}">${element.name}</option>
					</c:when>
					<c:otherwise>
							<option value="${element.id}">${element.name}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
		</select>
	</html:attributes>
	<span style="color:#A00000">${status.errorMessage}</span>
</spring:bind>