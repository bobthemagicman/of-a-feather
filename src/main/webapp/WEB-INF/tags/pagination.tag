<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/init.jsp"%>

<%@ attribute name="totalPages" required="true" type="java.lang.Integer" %>
<%@ attribute name="currentPage" required="true" type="java.lang.Integer" %>
<%@ attribute name="numberOfPagesToShow" required="true" type="java.lang.Integer" %>
<%@ attribute name="baseUrl" required="true" type="java.lang.String" %>
<%@ attribute name="queryString" required="false" type="java.lang.String" %>

 <c:set var="pageLoopEnd" value="totalPages" />
 <c:set var="pageLoopBegin" value="1" />
 <c:set var="leftElipsis" value="false" />
 <c:set var="rightElipsis" value="false" />
 
 <c:choose>
	 <c:when test="${currentPage - numberOfPagesToShow ge pageLoopBegin}">
	    <c:choose>
            <c:when test="${currentPage - numberOfPagesToShow eq pageLoopBegin}">
                <c:set var="leftElipsis" value="false" />
    	    </c:when>
    	    <c:when test="${currentPage + ((numberOfPagesToShow - 1)/2) gt totalPages}">
    	       <c:set var="pageLoopEnd" value="${currentPage + ((numberOfPagesToShow -1)/2)}"/>
               <c:set var="pageLoopBegin" value="${currentPage - ((numberOfPagesToShow -1)/2)}"/>
               <c:set var="leftElipsis" value="true" />
               <c:set var="rightElipsis" value="true" />
    	    </c:when>
            <c:otherwise>
		         <c:set var="pageLoopBegin" value="${totalPages - numberOfPagesToShow}"/>
		         <c:set var="rightElipsis" value="false"/>
            </c:otherwise>                
        </c:choose>
	 </c:when>    
	 <c:otherwise>
	     <c:set var="pageLoopEnd" value="${pageLoopBegin + numberOfPagesToShow - 1}" />
	 </c:otherwise>
</c:choose>
        
<c:if test="${totalPages gt 1}">
	<div class="pagination pagination-centered">
		<ul data-total-pages="${totalPages}">
			<c:if test="${(currentPage + 1) ne pageLoopBegin }">
				<li><a title="Go to first page"
					href="${baseUrl}${queryString}&page=1">&lt;&lt;</a></li>
				<li><a title="Go to previous page"
					href="${baseUrl}${queryString}&page=${currentPage}">&lt;</a></li>
			</c:if>
			<c:if test="${leftElipsis}">
				<li>...</li>
			</c:if>

			<c:forEach begin="${pageLoopBegin}" end="${pageLoopEnd}"
				varStatus="p_tracker">
				<c:set var="classInfo" value="" />
				<c:set var="titleInfo" value="" />

				<c:if test="${p_tracker.index -1 eq currentPage}">
					<c:set var="classInfo" value=" class=\"active\"" />
					<c:set var="titleInfo" value="Current page is ${p_tracker.index}" />
				</c:if>

				<li ${classInfo}><a title="${titleInfo}"
					<c:if test="${p_tracker.index -1 != currentPage}">href="${baseUrl}${queryString}&page=${p_tracker.index}"</c:if>>${p_tracker.index}</a></li>
			</c:forEach>

			<c:if test="${rightElipsis}">
				<li>...</li>
			</c:if>

			<c:if test="${currentPage + 1 ne pageLoopEnd}">
				<li><a title="Go to next page" href="${baseUrl}${queryString}&page=${currentPage + 2}">&gt;</a></li>
				<li><a title="Go to last page" href="${baseUrl}${queryString}&page=${totalPages}">&gt;&gt;</a></li>
			</c:if>
		</ul>
	</div>
</c:if>