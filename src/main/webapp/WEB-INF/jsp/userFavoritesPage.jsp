<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/init.jsp"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <%-- Common Metadata, scripts, and CSS --%>
        <%@ include file="/WEB-INF/jsp/partials/commonHead.jsp"%>

        <spring:url value="/static/js/search.js" var="searchJS" />
        <spring:url value="/static/js/bootstrap-paginator.min.js" var="bootstrapPaginatorJS" />
        <spring:url value="/static/js/mustache.js" var="mustacheJS" />
        <spring:url value="/static/js/jquery.form.min.js" var="jqueryForm"/>
        <spring:url value="/static/js/jquery.geocomplete.js" var="geoCompletePlugin" />
        
        <script type="text/javascript">
            $LAB.queueScript("${searchJS}")
                    .queueScript("https://maps.googleapis.com/maps/api/js?libraries=places&sensor=false&callback=initializeMap")
                    .queueScript("${geoCompletePlugin}")
                    .queueScript("${mustacheJS}")
                    .queueScript("${jqueryForm}")
                    .queueScript("${bootstrapPaginatorJS}")                            
                    .runQueue();

            var showOutsideRegionModal = ${not empty error and error eq 'user_search_out_of_region'};
            
            
        </script>

        <title>Of A Feather - Search Results</title>    
    </head>
    <body data-rn="${userKey}">

        <%-- Site Header --%>
        <c:set var="navSearchEnabled" value="true" />
        <%@ include file="/WEB-INF/jsp/partials/siteHeader.jsp"%>

        <div class="container main">

            <div class="search-results">
                <ctg:churchListing items="${favorites}" loginUrl="${loginUrl}"/>
            </div><!-- end search-results -->
            
            <!--  Pagination -->
            <spring:url value="/user/favorites?" var="baseUrl" />
            <ctg:pagination baseUrl="${baseUrl}" currentPage="${results.currentPage}" numberOfPagesToShow="${numberOfPagesToDisplay}" totalPages="${results.totalNumberOfPages}" queryString="${pageRequestQueryString}"/>
            
        </div><!-- /.container .main -->

        <%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%> 
        <%@ include file="/WEB-INF/jsp/partials/outOfRegionModal.jsp"%>
    </body>
</html>