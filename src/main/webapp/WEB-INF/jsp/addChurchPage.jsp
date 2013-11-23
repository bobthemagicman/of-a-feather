<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/init.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<%-- Common Metadata, scripts, and CSS --%>
	<%@ include file="/WEB-INF/jsp/partials/commonHead.jsp"%>
	
	<title>Of A Feather - Find your new church home today</title>	
</head>
<body>

<%-- Site Header --%>
<%@ include file="/WEB-INF/jsp/partials/siteHeader.jsp"%>

<div class="container addyourchurch-page">
    <div class="row">
        <div class="col-sm-12">
            <h1>Add Your Church</h1>
            <hr />

            <h2>Thank you for your interest in OfAFeather.org.</h2>

            <h3>We invite you to add your church to our database today!</h3>
            <br /><br />
            <div class="row">
                <div class="col-sm-4">
                    <p class="panel">
                        <span class="glyphicon glyphicon-file"></span> To preview the questions in .pdf format, <a target="_blank" href="preview_ofafeather_questions.pdf">click here.</a>
                    </p>
                </div> 
                <div class="col-sm-8 centered-text">
                    <h4>
                        Thank you for adding your church! Click the button below to begin.
                    </h4>
                    <a class="btn btn-primary" target="_blank" href="https://docs.google.com/forms/d/107Jgvj0C4HoEYql9fvVfr1WYcvkcafNyVYItg14rHME/viewform">Free Church Listing</a>
                </div>
            </div>

        </div>
    </div>

    <div class="filler">&nbsp;</div>

</div>

<%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%>

</body>