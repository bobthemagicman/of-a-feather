<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/init.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<%-- Common Metadata, scripts, and CSS --%>
<%@ include file="/WEB-INF/jsp/partials/commonHead.jsp"%>

<title>Of A Feather - Add Your Church</title>
</head>
<body>

	<%-- Site Header --%>
	<%@ include file="/WEB-INF/jsp/partials/siteHeader.jsp"%>

	<div class="container front-page-temp">
		<form:form commandName="organizationCommandObject" method="POST">
			<%-- Church Demographic Info --%>
			
			<div id="congsizeOptions" class="panel-body checkbox-group">
                <label class="checkbox" for="size1"><input id="size1" type="checkbox" />Small<span class="time-description">&lt; 100</span></label>
                <label class="checkbox" for="size2"><input id="size2" type="checkbox" />Medium<span class="time-description">101 - 400</span></label>
                <label class="checkbox" for="size3"><input id="size3" type="checkbox" />Large<span class="time-description">401 - 2000</span></label>
                <label class="checkbox" for="size4"><input id="size4" type="checkbox" />Mega<span class="time-description">2001+</span></label>
            </div><!-- /#congsizeOptions -->
            <form:hidden path="congregationSize" />
			
			<div id="atmosphereOptions" class="panel-body">
                <h5 class="slider-heading">SERVICE STYLE</h5>
                <div class="slider-labels">
                    <div class="slider-label-container"><span>CONSERVATIVE</span></div>
                    <div class="slider-label-container"><span></span></div>
                    <div class="slider-label-container"><span>HIGH ENERGY</span></div>
                </div>
                <form:hidden path="dressAttire" />
                <div class="slider" id="serviceStyleSlider"></div>
                <div class="slider-tooltip" data-assoc-slider="serviceStyleSlider">&nbsp;</div>
                
                <h5 class="slider-heading">MUSIC</h5>
                <div class="slider-labels">
                    <div class="slider-label-container"><span>TRADITIONAL</span></div>
                    <div class="slider-label-container"><span></span></div>
                    <div class="slider-label-container"><span>CONTEMPORARY</span></div>
                </div>
                <form:hidden path="musicStyle" />
                
                <div class="slider" id="musicSlider"></div>
                <div class="slider-tooltip" data-assoc-slider="musicSlider">&nbsp;</div>
                
                <h5 class="slider-heading">DRESS ATTIRE</h5>
                <div class="slider-labels">
                    <div class="slider-label-container"><span>FORMAL</span></div>
                    <div class="slider-label-container"><span></span></div>
                    <div class="slider-label-container"><span>CASUAL</span></div>
                </div>
                <form:hidden path="dressAttire" />
                <div class="slider" id="dressAttireSlider"></div>   
                <div class="slider-tooltip" data-assoc-slider="dressAttireSlider">&nbsp;</div>
                <br />
                <div class="gay-affirming">
                    <form:button type="checkbox" id="gayAffirming" /><label for="gayAffirming">Gay Affirming</label>
                </div>
            </div>
        
			<%-- Church Online Info --%>
			<div id="timedayOptions" class="panel-body">
                <div class="checkbox-group">
                    <label class="checkbox" for="time1"><input id="time1" type="checkbox" />Early Morning<span class="time-description">before 9am</span></label>
                    <label class="checkbox" for="time2"><input id="time2" type="checkbox" />Mid-Morning<span class="time-description">9am - 10:45am</span></label>
                    <label class="checkbox" for="time3"><input id="time3" type="checkbox" />Late Morning<span class="time-description">11am - 12:45pm</span></label>
                    <label class="checkbox" for="time4"><input id="time4" type="checkbox" />Afternoon<span class="time-description">1pm - 4pm</span></label>
                    <label class="checkbox" for="time5"><input id="time5" type="checkbox" />Evening<span class="time-description">after 4pm</span></label>
                    <form:hidden path="serviceTimes" />
                </div><!-- /.checkbox-group -->
                <div class="day-buttons">
                    <input type="checkbox" id="sunday" /><label for="sunday">Sun</label>
                    <input type="checkbox" id="monday" /><label for="monday">Mon</label>
                    <input type="checkbox" id="tuesday" /><label for="tuesday">Tue</label>
                    <input type="checkbox" id="wednesday" /><label for="wednesday" class="wednesday">Wed</label>
                    <input type="checkbox" id="thursday" /><label for="thursday">Thu</label>
                    <input type="checkbox" id="friday" /><label for="friday">Fri</label>
                    <input type="checkbox" id="saturday" /><label for="saturday">Sat</label>
                    <form:hidden path="serviceDays" />
                </div><!-- /.day-buttons -->
            </div><!-- /.panel-body -->
            
			<form:label path="languages">
				<form:input path="languages" />
			</form:label>
			
			<a href="" >Add Language</a>

			<%-- Church Images --%>
			<%--Figure this out later --%>
			<div class="form-group pull-right">
				<input type="submit" name="_eventId_previous" value="Previous" class="btn btn-primary" />
				<input type="submit" name="_eventId_next" value="Next" class="btn btn-primary" />
				<input type="submit" name="_eventId_cancel" value="Cancel" class="btn btn-primary" />
			</div>
			
		</form:form>
	</div>

	<%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%>

</body>
</html>