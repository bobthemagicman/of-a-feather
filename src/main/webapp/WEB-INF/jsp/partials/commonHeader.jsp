<%@ page import="com.flockspring.domain.types.MusicStyle"%>
<%@ page import="com.flockspring.domain.types.Affiliation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/init.jsp"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Of A Feather - Find your new church home today</title>

        <spring:url value="/static/css/ofafeather.css" var="customStyleCSS"/>
        <spring:url value="/static/images/icon.ico" var="ofAFeatherIcon"/>

        <link href="${customStyleCSS}" rel="stylesheet" type="text/css" />
        <link href="${ofAFeatherIcon}" rel="icon"  />

        <spring:url value="/static/js/iepngfix_tilebg.js" var="iePngFx_tileBg"/>
        <spring:url value="/static/js/iepngfix.js" var="iePngFx"/>
        <script type="text/javascript" src="${iePngFx }"></script>
        <script type="text/javascript" src="${iePngFx_tileBg }"></script>
        
    </head>

    <body>
        <spring:url value="/static/images/site/ofafeather_logo.png" var="ofafeatherLogo"/>
        
        <nav class="navbar navbar-default" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${homePage}"><img src="${ofafeatherLogo}" /></a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse">

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">ABOUT US</a></li>
                    <li><a href="#">ADD YOUR CHURCH</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>