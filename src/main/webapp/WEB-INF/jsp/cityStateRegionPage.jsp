<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/init.jsp"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <%-- Common Metadata, scripts, and CSS --%>
        <%@ include file="/WEB-INF/jsp/partials/commonHead.jsp"%>

        <spring:url value="/static/js/jquery.geocomplete.js" var="geoCompletePlugin" />
        <spring:url value="/static/css/elastislide.css" var="elastislideCSS" />
        <link rel="stylesheet" type="text/css" href="${elastislideCSS}" />
        
        <spring:url value="/static/js/profile.js" var="profileJS" />
        <spring:url value="/static/js/jquery.elastislide.js" var="elastislideJS" />
        <spring:url value="/static/js/modernizr.custom.17475.js" var="modernizrJS" />
        
        <script type="text/javascript">
            $LAB.queueScript("${profileJS}")
                    .queueScript("https://maps.googleapis.com/maps/api/js?libraries=places&sensor=false&callback=initializeMap")
                    .queueScript("${geoCompletePlugin}")
                    .queueScript("${modernizrJS}")
                    .queueScript("${elastislideJS}")
                    .runQueue();
        </script>

        <title>Of A Feather - Find your new church home today</title>   
    </head>
    <body>

        <%-- Site Header --%>
        <c:set var="navSearchEnabled" value="true" />
        <%@ include file="/WEB-INF/jsp/partials/siteHeader.jsp"%>
        
        <%-- Stuff goes here  --%>
        
        <%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%> 
    </body>
</html>