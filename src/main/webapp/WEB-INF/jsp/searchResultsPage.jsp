<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/init.jsp"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <%-- Common Metadata, scripts, and CSS --%>
        <%@ include file="/WEB-INF/jsp/partials/commonHead.jsp"%>
        
        <spring:url value="/static/js/search.js" var="searchJS" />
        <script type="text/javascript">
            $LAB.queueScript("${searchJS}")
                .queueScript("https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&callback=initializeMap")
                .runQueue();
        </script>
        
        <title>Of A Feather - Search Results</title>	
    </head>
    <body>

        <%-- Site Header --%>
        <%@ include file="/WEB-INF/jsp/partials/siteHeader.jsp"%>

        <div class="container main" data-search-latitude="${results.searchLatitude}" data-search-longitude="${results.searchLongitude}">

            <spring:url value="/static/images/site/expand_map_icon.png" var="expandMapIcon" />    
            
            <div class="col-sm-4 left-column">
                <div class="map-container-outer">
                    <div class="map-buttons">
                        <img src="${expandMapIcon}" />
                    </div>
                    <div class="map-container">
                        <div id="map-canvas"></div>
                    </div><!-- end map-container -->
                </div>
                
                <div class="search-options-panel">
                    <div class="panel-group" id="accordion">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="accordion-toggle active" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                        Denomination
                                        <span class="chevron-icon"></span>
                                    </a>
                                </h4>
                            </div><!-- /.panel-heading -->
                            <div id="collapseOne" class="panel-collapse collapse in">
                                <div id="denominationOptions" class="panel-body filter" data-filter-type="affiliations">
                                    <div class="modal fade" id="denominationsModal">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h4 class="modal-title">Denomination</h4>
                                                    <span class="modal-instructions">Select all that apply.</span>
                                                </div><!-- /.modal-header -->
                                                <div class="modal-body">
                                                    <div class="row checkbox-group">
                                                        <div class="col-sm-6">
                                                            <c:set var="principleDenoms" value="${cfn:createList(fn:split('BAPTIST,CATHOLIC,ANGLICAN,LUTHERAN', ','))}"/>
                                                            
                                                            <c:forEach items="${denominationValues}" var="denomination" varStatus="p_tracker" >
                                                                <c:if test="${denomination.name ne 'NONE'}" >
                                                                <c:set var="checked" value=""/>
					                                            <c:if test="${not empty filters and cfn:collectionContains(filters.affiliations, denomination)}">
					                                                <c:set var="checked" value=" checked"/>
					                                            </c:if>
                                                                <label class="checkbox${checked}" for="denomList-${fn:toLowerCase(denomination.name)}">
                                                                    <input id="denomList-${fn:toLowerCase(denomination.name)}" type="checkbox" data-filter-option="${denomination.name}" <c:if test="${cfn:collectionContains(principleDenoms, denomination.name) }"> data-linked-checkbox="denom-${fn:toLowerCase(denomination.name)}"</c:if> />
                                                                    <spring:message code="${denomination.localizedStringCode}" />
                                                                </label>
                                                                <c:if test="${((fn:length(denominationValues) % 2 ne 0) and (p_tracker.index +1) eq ((fn:length(denominationValues) + 1) /2)) or (fn:length(denominationValues) % 2 eq 0 and (fn:length(denominationValues) / 2 eq (p_tracker.index + 1)))}">
                                                        </div>
                                                        <div class="col-sm-6">
                                                                </c:if>
                                                                </c:if>
                                                            </c:forEach>
                                                        </div>
                                                    </div>
                                                    <div class="modal-button-container"><button class="btn btn-default" data-dismiss="modal">Apply</button></div>
                                                </div><!-- /.modal-body -->
                                            </div><!-- /.modal-content -->
                                        </div><!-- /.modal-dialog -->
                                    </div><!-- /.modal -->
                                    <div class="checkbox-group">
                                    
                                    <c:set var="denomListTracker" value="1" />
                                    <c:forEach items="${denominationValues}" var="denomination" varStatus="p_tracker" >
                                        <c:if test="${cfn:collectionContains(principleDenoms, denomination.name)}">
	                                        <c:set var="checked" value=""/>
	                                        <c:if test="${not empty filters and cfn:collectionContains(filters.affiliations, denomination)}">
	                                            <c:set var="checked" value=" checked"/>
	                                        </c:if>
                                        <label class="checkbox${checked}" for="denom-${fn:toLowerCase(denomination.name)}">
                                            <input id="denom-${fn:toLowerCase(denomination.name)}" type="checkbox" data-linked-checkbox="denomList-${fn:toLowerCase(denomination.name)}" data-filter-option="${denomination.name}" />
                                            <spring:message code="${denomination.localizedStringCode}" /><span class="badge"><%--number --%></span>
                                        </label>
                                        
                                        <c:set var="denomListTracker" value="${denomListTracker + 1}" />
                                        </c:if>
                                    </c:forEach>
                                        
                                        <a data-toggle="modal" href="#denominationsModal" role="button" class="see-more-link">See more...</a>
                                    </div><!-- /.checkbox-group -->                                    
                                </div><!-- /.panel-body -->
                            </div><!-- /#collapseOne -->
                        </div><!-- /.panel -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                                        Day &amp; Time of Services
                                        <span class="chevron-icon"></span>
                                    </a>
                                </h4>
                            </div><!-- /.panel-heading -->
                            <div id="collapseTwo" class="panel-collapse collapse">
                                <div id="timedayOptions" class="panel-body">
                                    <div class="checkbox-group filter" data-filter-type="serviceTimes">
                                        <c:forEach items="${serviceTimeRangeValues}" var="serviceTime" varStatus="p_tracker">
                                            <c:set var="checked" value=""/>
                                            <c:if test="${not empty filters and cfn:collectionContains(filters.serviceTimes, serviceTime)}">
                                                <c:set var="checked" value=" checked"/>
                                            </c:if>
                                            <label class="checkbox${checked}" for="time${p_tracker.index + 1}">
                                                <input id="time${p_tracker.index + 1}" type="checkbox" data-filter-option="${serviceTime.name}" />
                                                
                                                <fmt:formatDate value="${serviceTime.rangeStartAsDate}" type="time" timeStyle="short" var="startTime"/>
                                                <fmt:formatDate value="${serviceTime.rangeEndAsDate}" type="time" timeStyle="short" var="endTime"/>
                                                <spring:message code="${serviceTime.localizationStringCode}" />
                                                
                                                <c:choose>
                                                    <c:when test="${p_tracker.first}">
                                                        <span class="time-description">before ${endTime}</span>
                                                    </c:when>
                                                    <c:when test="${p_tracker.last}">
                                                        <span class="time-description">after ${startTime}</span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="time-description">${startTime} - ${endTime}</span>
                                                    </c:otherwise>
                                                 </c:choose>
                                            </label>
                                        
                                        </c:forEach>
                                    </div><!-- /.checkbox-group -->
                                    <div class="day-buttons filter" data-filter-type="serviceDays">
                                        <c:forEach items="${serviceDayValues}" var="serviceDay" varStatus="p_tracker">
                                            <c:choose>
                                                <c:when test="${not empty filters and cfn:collectionContains(filters.serviceDays, serviceDay) and serviceDay.name ne 'WEDNESDAY'}">
	                                               <c:set var="activeClassInfo" value=' class="ui-state-active" aria-pressed="true"' />
	                                            </c:when>
	                                            <c:when test="${not empty filters and cfn:collectionContains(filters.serviceDays, serviceDay) and serviceDay.name eq 'WEDNESDAY'}">
	                                               <c:set var="activeClassInfo" value=' class="ui-state-active wednesday" aria-pressed="true"' />
	                                            </c:when>
	                                            <c:otherwise>
	                                               <c:set var="activeClassInfo" value="" />
	                                            </c:otherwise>
	                                        </c:choose>
                                            
                                            <input type="checkbox" id="${fn:toLowerCase(serviceDay.name)}" data-filter-option="${serviceDay.name}" />
                                            <spring:message code="${serviceDay.localizedStringCode}" var="day"/>
                                            <label for="${fn:toLowerCase(serviceDay.name)}" ${activeClassInfo}>${fn:substring(day, 0, 3)}</label>
                                        </c:forEach>
                                    </div><!-- /.day-buttons -->
                                </div><!-- /.panel-body -->
                            </div><!-- /#collapseTwo -->
                        </div><!-- /.panel -->
                        <div class="panel panel-default">
                            <div class="panel-heading" >
                                <h4 class="panel-title">
                                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                                        Congregation Size
                                        <span class="chevron-icon"></span>
                                    </a>
                                </h4>
                            </div><!-- /.panel-heading -->
                            <div id="collapseThree" class="panel-collapse collapse">
                                <div id="congsizeOptions" class="panel-body checkbox-group filter" data-filter-type="congregationSize">
                                    <c:forEach items="${congregationSizeValues}" var="congregationSize" varStatus="p_tracker">
                                        <c:set var="checked" value=""/>
                                        <c:if test="${not empty filters and cfn:collectionContains(filters.congregationSize, congregationSize)}">
                                            <c:set var="checked" value=" checked"/>
                                        </c:if>
                                            
                                    <label class="checkbox${checked}" for="size${p_tracker.index}"><input id="size${p_tracker.index}" type="checkbox" data-filter-option="${congregationSize.name}" />
                                        <spring:message code="${congregationSize.localizedStringCode}" />
                                        <c:choose>
                                            <c:when test="${p_tracker.first and congregationSize.name ne 'UNKNOWN'}">
                                                <span class="time-description">&lt; ${congregationSize.highThreshold}</span>
                                            </c:when>
                                            <c:when test="${congregationSize.highThreshold eq -1 and congregationSize.name ne 'UNKNOWN'}">
                                                <span class="time-description">${congregationSize.lowThreshold}+</span>
                                            </c:when>
                                            <c:otherwise>
                                                <c:if test="${congregationSize.name ne 'UNKNOWN'}">
                                                <span class="time-description">${congregationSize.lowThreshold} - ${congregationSize.highThreshold}</span>
                                                </c:if>
                                            </c:otherwise>
                                        </c:choose>
                                    </label>
                                    </c:forEach>
                                </div><!-- /#congsizeOptions -->
                            </div><!-- /#collapseThree -->
                        </div><!-- /.panel -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseFour">
                                        Atmosphere
                                        <span class="chevron-icon"></span>
                                    </a>
                                </h4>
                            </div><!-- /.panel-heading -->
                            <div id="collapseFour" class="panel-collapse collapse">
                                <div id="atmosphereOptions" class="panel-body">
                                    
                                    
                                    <c:set var="serviceStyleMin" value="" />
                                    <c:set var="serviceStyleMax" value="" />
                                    <c:if test="${not empty filters}">
                                        <c:set var="serviceStyleMin" value="${filters.serviceStyleFloor}" />
                                        <c:set var="serviceStyleMax" value="${filters.serviceStyleCeiling}" />
                                    </c:if>
                                    
                                    <h5 class="slider-heading">SERVICE STYLE</h5>
                                    <div class="slider-labels">
                                        <div class="slider-label-container"><span>CONSERVATIVE</span></div>
                                        <div class="slider-label-container"><span></span></div>
                                        <div class="slider-label-container"><span>HIGH ENERGY</span></div>
                                    </div>
                                    <div class="slider slider-filter" id="serviceStyleSlider" data-filter-type="atmosphereServiceStyle" data-min="${serviceStyleMin}" data-max="${serviceStyleMax}"></div>
                                    <div class="slider-tooltip" data-assoc-slider="serviceStyleSlider">&nbsp;</div>

                                    <c:set var="musicStyleMin" value="" />
                                    <c:set var="musicStyleMax" value="" />
                                    <c:if test="${not empty filters}">
                                        <c:set var="musicStyleMin" value="${filters.musicStyleFloor}" />
                                        <c:set var="musicStyleMax" value="${filters.musicStyleCeiling}" />
                                    </c:if>
                                    
                                    <h5 class="slider-heading">MUSIC</h5>
                                    <div class="slider-labels">
                                        <div class="slider-label-container"><span>TRADITIONAL</span></div>
                                        <div class="slider-label-container"><span></span></div>
                                        <div class="slider-label-container"><span>CONTEMPORARY</span></div>
                                    </div>
                                    <div class="slider slider-filter" id="musicSlider" data-filter-type="atmosphereMusicStyle" data-min="${musicStyleMin}" data-max="${musicStyleMax}"></div>
                                    <div class="slider-tooltip" data-assoc-slider="musicSlider">&nbsp;</div>


                                    <c:set var="dressAttireeMin" value="" />
                                    <c:set var="dressAttireMax" value="" />
                                    <c:if test="${not empty filters}">
                                        <c:set var="dressAttireeMin" value="${filters.dressAttireFloor}" />
                                        <c:set var="dressAttireMax" value="${filters.dressAttireCeiling}" />
                                    </c:if>
                                    
                                    <h5 class="slider-heading">DRESS ATTIRE</h5>
                                    <div class="slider-labels">
                                        <div class="slider-label-container"><span>FORMAL</span></div>
                                        <div class="slider-label-container"><span></span></div>
                                        <div class="slider-label-container"><span>CASUAL</span></div>
                                    </div>
                                    <div class="slider slider-filter" id="dressAttireSlider" data-filter-type="atmosphereDressAttire" data-min="${dressAttireeMin}" data-max="${dressAttireMax}"></div>   
                                    <div class="slider-tooltip" data-assoc-slider="dressAttireSlider">&nbsp;</div>
                                    
                                    <br />
                                    
                                    <div class="gay-affirming">
                                        <c:set var="activeClassInfo" value="" />
                                        <c:if test="${not empty filters and filters.gayAffirming}">
                                            <c:set var="activeClassInfo" value=' class="ui-state-active" aria-pressed="true"' />
                                        </c:if>
                                        <input type="checkbox" id="gayAffirming" /><label for="gayAffirming"${activeAttributes}>Gay Affirming</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseFive">
                                        Ministries &amp; Programs
                                        <span class="chevron-icon"></span>
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseFive" class="panel-collapse collapse">
                                <div id="programsOptions" class="panel-body checkbox-group filter" data-filter-type="programsAndMinistries">
                                    <div class="row">
                                        <div class="col-sm-5">
                                            <h5>Nursery Care</h5>
                                            
                                            <c:set var="checked" value=""/><c:if test=""><c:set var="checked" value=" checked"/></c:if>
                                            <label class="checkbox${checked}" for="childCare1"><input id="childCare1" type="checkbox" data-linked-checkbox="childCareModal1" data-filter-option="INFANT_CARE" />Infant Care</label>
                                            
                                            
                                            <label class="checkbox${checked}" for="childCare2"><input id="childCare2" type="checkbox" data-linked-checkbox="childCareModal2" data-filter-option="TODDLER_CARE" />Toddler Care</label>
                                        </div>
                                        <div class="col-sm-7">
                                            <h5>Educational</h5>
                                            
                                            
                                            <label class="checkbox${checked}" for="education1"><input id="education1" type="checkbox" data-linked-checkbox="educationModal1" data-filter-option="SUNDAY_SCHOOL" />Sunday School</label>
                                            
                                            
                                            <label class="checkbox${checked}" for="education2"><input id="education2" type="checkbox" data-linked-checkbox="educationModal2" data-filter-option="BIBLE_STUDY" />Bible Studies</label>
                                            
                                            
                                            <label class="checkbox${checked}" for="education3"><input id="education3" type="checkbox" data-linked-checkbox="educationModal3" data-filter-option="SPIRITUAL_CLASSES" />Spiritual Classes</label>
                                            
                                            
                                            <label class="checkbox adult-education" for="education4"><input id="education4" type="checkbox" data-linked-checkbox="educationModal4" data-filter-option="ADULT_EDUCATION" />Adult Education <span class="glyphicon glyphicon-info-sign"></span></label>
                                        </div>
                                    </div>
                                    <br />
                                    <a data-toggle="modal" href="#moreProgramsModal" role="button" class="see-more-link">See more...</a>
                                    <div class="modal fade" id="moreProgramsModal">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h4 class="modal-title">More Programs</h4>
                                                    <span class="modal-instructions">Select all that apply.</span>
                                                </div><!-- /.modal-header -->
                                                <div class="modal-body">
                                                    <ul class="nav nav-tabs nav-justified">
                                                        <li class="active"><a href="#careEducationTab" data-toggle="tab">NURSERY CARE &amp;<br />EDUCATIONAL</a></li>
                                                        <li><a href="#ageGenderTab" data-toggle="tab">AGE GROUPS &amp;<br />CREATIVE ARTS</a></li>
                                                        <li><a href="#socialSpiritualTab" data-toggle="tab">SOCIAL &amp;<br />SPIRITUAL</a></li>
                                                        <li><a href="#supportOutreachTab" data-toggle="tab">SUPPORT &amp;<br />OUTREACH</a></li>
                                                    </ul> 
                                                    <div class="tab-content">
                                                        <div class="tab-pane fade active in" id="careEducationTab">
                                                            <div class="row">
                                                                <div class="col-sm-5 col-sm-offset-1">
                                                                    <h5>Nursery Care</h5>
                                                                    
<%--                                                                     <c:set var="checked" value=""/><c:if test=""><c:set var="checked" value=" checked"/></c:if> --%>
                                                                    <label class="checkbox${checked}" for="childCareModal1"><input id="childCareModal1" type="checkbox" data-linked-checkbox="childCare1" data-filter-option="INFANT_CARE" />Infant Care</label>
                                                                    
                                                                    <c:set var="checked" value=""/><c:if test=""><c:set var="checked" value=" checked"/></c:if>
                                                                    <label class="checkbox${checked}" for="childCareModal2"><input id="childCareModal2" type="checkbox" data-linked-checkbox="childCare2" data-filter-option="TODDLER_CARE" />Toddler Care</label>
                                                                </div>
                                                                <div class="col-sm-5 col-sm-offset-1">
                                                                    <h5>Education</h5>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="educationModal1"><input id="educationModal1" type="checkbox" data-linked-checkbox="education1" data-filter-option="SUNDAY_SCHOOL" />Sunday School</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="educationModal2"><input id="educationModal2" type="checkbox" data-linked-checkbox="education2" data-filter-option="BIBLE_STUDY" />Bible Studies</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="educationModal3"><input id="educationModal3" type="checkbox" data-linked-checkbox="education3" data-filter-option="SPIRITUAL_CLASSES" />Spiritual Classes</label>
                                                                    
                                                                    
                                                                    <label class="checkbox adult-education" for="educationModal4"><input id="educationModal4" type="checkbox" data-linked-checkbox="education4" data-filter-option="ADULT_EDUCATION" />Adult Education <span class="glyphicon glyphicon-info-sign"></span></label>
                                                                </div>
                                                            </div>
                                                        </div><!-- /.tab-pane -->
                                                        <div class="tab-pane fade" id="ageGenderTab">
                                                            <div class="row">
                                                                <div class="col-sm-5">
                                                                    <h5>Age Groups</h5>
                                                                    
                                                                    <label class="checkbox${checked}" for="ageGender1"><input id="ageGender1" type="checkbox" data-filter-option="CHILDRENS_GROUP" />Children&apos;s</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="ageGender2"><input id="ageGender2" type="checkbox" data-filter-option="MIDDLE_SCHOOL_GROUP" />Middle School/Junior High</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="ageGender3"><input id="ageGender3" type="checkbox" data-filter-option="HIGH_SCHOOL_GROUP" />High School</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="ageGender4"><input id="ageGender4" type="checkbox" data-filter-option="" />College</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="ageGender10"><input id="ageGender10" type="checkbox" data-filter-option="YOUNG_ADULT_GROUP" />Post College/Young Professionals</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="ageGender5"><input id="ageGender5" type="checkbox" data-filter-option="ADULT_GROUP" />Adult</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="ageGender6"><input id="ageGender6" type="checkbox" data-filter-option="SENIOR_GROUP" />Senior Citizens</label>
                                                                </div>
                                                                <div class="col-sm-3">
                                                                    <h5>Gender Groups</h5>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="ageGender8"><input id="ageGender8" type="checkbox" data-filter-option="MENS_GROUP" />Men&apos;s</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="ageGender9"><input id="ageGender9" type="checkbox" data-filter-option="WOMENS_GROUP" />Women&apos;s</label>
                                                                </div>

                                                                <div class="col-sm-4">
                                                                    <h5>Music &amp; Arts</h5>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="musicArts1"><input id="musicArts1" type="checkbox" data-filter-option="CHIOR" />Choir Group</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="musicArts2"><input id="musicArts2" type="checkbox" data-filter-option="DANCE" />Dance Team</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="musicArts3"><input id="musicArts3" type="checkbox" data-filter-option="MUSIC_MINISTRY" />Music Ministry</label>
                                                                    

                                                                    <label class="checkbox${checked}" for="musicArts4"><input id="musicArts4" type="checkbox" data-filter-option="DRAMA" />Drama Team</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="musicArts5"><input id="musicArts5" type="checkbox" data-filter-option="CREATIVE_ARTS" />Creative Arts Ministry</label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="tab-pane fade" id="socialSpiritualTab">
                                                            <div class="row">
                                                                <div class="col-sm-5 col-sm-offset-1">
                                                                    <h5>Social</h5>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="socialSpiritual2"><input id="socialSpiritual2" type="checkbox" data-filter-option="SPROTS" />Sports Activities</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="socialSpiritual3"><input id="socialSpiritual3" type="checkbox" data-filter-option="SOCAIL_EVENTS" />Member Social Events</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="socialSpiritual4"><input id="socialSpiritual4" type="checkbox" data-filter-option="SMALL_GROUPS" />Small Groups</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="socialSpiritual5"><input id="socialSpiritual5" type="checkbox" data-filter-option="SINGLES_GROUPS" />Singles Events</label>
                                                                </div>
                                                                <div class="col-sm-5 col-sm-offset-1">
                                                                    <h5>Spiritual</h5>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="socialSpiritual9"><input id="socialSpiritual9" type="checkbox" data-filter-option="PRAYER_GROUPS" />Prayer Groups</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="socialSpiritual6"><input id="socialSpiritual6" type="checkbox" data-filter-option="HEALING_MINISTRY" />Healing Ministry</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="socialSpiritual7"><input id="socialSpiritual7" type="checkbox" data-filter-option="PHOPHETIC_MINISTRY" />Prophetic Ministry</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="socialSpiritual8"><input id="socialSpiritual8" type="checkbox" data-filter-option="WORSHIP_MINISTRY" />Worship Ministry</label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="tab-pane fade" id="supportOutreachTab">
                                                            <div class="row">
                                                                <div class="col-sm-5 col-sm-offset-1">
                                                                    <h5>Support &amp; Counseling</h5>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="supportOutreach6"><input id="supportOutreach6" type="checkbox" data-filter-option="PRE_MARITAL_COUNSELING" />Pre-marital Services</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="supportOutreach7"><input id="supportOutreach7" type="checkbox" data-filter-option="COUPLES_COUNSELING" />Couples Counseling</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="supportOutreach8"><input id="supportOutreach8" type="checkbox" data-filter-option="GENERAL_COUNSELING" />General Counseling</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="supportOutreach9"><input id="supportOutreach9" type="checkbox" data-filter-option="DIVORCE_GRIEF_COUNSELING" />Divorce/Grief</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="supportOutreach10"><input id="supportOutreach10" type="checkbox" data-filter-option="ADDICTION_RECOVERY_COUNSELING" />Addiction/Recovery</label>
                                                                </div>
                                                                <div class="col-sm-5 col-sm-offset-1">
                                                                    <h5>Outreach</h5>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="supportOutreach1"><input id="supportOutreach1" type="checkbox" data-filter-option="COMMUNITY_OUTREACH" />Community Service</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="supportOutreach2"><input id="supportOutreach2" type="checkbox" data-filter-option="EVANGELISM_OUTREACH" />Evangelism Outreach</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="supportOutreach3"><input id="supportOutreach3" type="checkbox" data-filter-option="FAMILY_OUTREACH" />Family Services</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="supportOutreach4"><input id="supportOutreach4" type="checkbox" data-filter-option="FOOD_PANTRY_OUTREACH" />Food Pantry</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="supportOutreach5"><input id="supportOutreach5" type="checkbox" data-filter-option="HOMELESS_OUTREACH" />Homeless Ministry</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="supportOutreach6"><input id="supportOutreach6" type="checkbox" data-filter-option="MISSION_OUTREACH" />Mission Trips</label>
                                                                    
                                                                    
                                                                    <label class="checkbox${checked}" for="supportOutreach7"><input id="supportOutreach7" type="checkbox" data-filter-option="SOCIAL_JUSTICE_OUTREACH" />Social Justice/Activism</label>
                                                                </div>
                                                            </div>
                                                        </div><!-- /.tab-pane -->
                                                    </div><!-- /.tab-content -->
                                                    <div class="modal-button-container"><button class="btn btn-default" data-dismiss="modal">Apply</button></div>
                                                </div><!-- /.modal-body -->
                                            </div><!-- /.modal-content -->
                                        </div><!-- /.modal-dialog -->
                                    </div><!-- /.modal -->
                                </div><!-- /#programsOptions -->
                            </div><!-- /#collapseFive -->
                        </div><!-- /.panel -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseSix">
                                        Language &amp; More
                                        <span class="chevron-icon"></span>
                                    </a>
                                </h4>
                            </div><!-- /.panel-heading -->
                            <div id="collapseSix" class="panel-collapse collapse">
                                <div id="moreOptions" class="panel-body checkbox-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-xs-12">
                                            <h5>Language</h5>   
                                            <c:set var="primaryLanguages" value="${cfn:createList(fn:split('SPANISH,CANTONESE,MANDARIN,FRENCH', ',')) }"/>
                                            
                                            <c:forEach items="${languageValues}" var="language" varStatus="p_tracker">
                                                <c:if test="${cfn:collectionContains(primaryLanguages, language.name)}">
		                                            <c:set var="checked" value=""/><c:if test=""><c:set var="checked" value=" checked"/></c:if>   
		                                            <label class="checkbox${checked}" for="langList${p_tracker.index}">
		                                                <input id="langList${p_tracker.index}" type="checkbox" data-linked-checkbox="lang-${fn:toLowerCase(language.name)}" data-filter-option="${language.name}" />
		                                                    <spring:message code="${language.names[0]}" text="" />
		                                            </label>
		                                        </c:if>
                                            </c:forEach>
                                            
                                            <h5 class="ellipsis">&hellip;</h5>
                                        </div>
                                        <div class="col-sm-6 col-xs-12">
                                            
                                            <c:set var="primaryAccessibilitySupports" value="${cfn:createList(fn:split('WHEELCHAIR_ACCESS,DEAF_TRANSLATOR,PARKING_LOT,CARPOOL', ',')) }"/>
                                            <c:forEach items="${accessibilitySupportValues}" var="entry">
                                                <h5><spring:message code="${entry.key.localizedStringCode}" /></h5>
                                                
                                                <c:forEach items="${entry.value}" var="accessibilitySupport" varStatus="p_tracker">
                                                    <c:if test="${cfn:collectionContains(primaryAccessibilitySupports, accessibilitySupport.name) }">
                                                    <c:set var="checked" value=""/><c:if test=""><c:set var="checked" value=" checked"/></c:if>
                                                    <label class="checkbox${checked}" for="accessibility-support-list-${fn:toLowerCase(accessibilitySupport.name)}">
                                                        <input id="accessibility-support-list-${fn:toLowerCase(accessibilitySupport.name)}" type="checkbox" data-linked-checkbox="accessibility-support-${fn:toLowerCase(accessibilitySupport.name)}" data-filter-option="${accessibilitySupport.name}" />
                                                        <spring:message code="${accessibilitySupport.localizedStringCode}" />
                                                    </label>
                                                    </c:if>
                                                </c:forEach>
                                            <br />
                                            </c:forEach>
                                                                                        
                                        </div>
                                    </div>
                                    <br />
                                    <a data-toggle="modal" href="#languagesModal" role="button" class="see-more-link">See more...</a>
                                    <div class="modal fade" id="languagesModal">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h4 class="modal-title">Language and More</h4>
                                                    <span class="modal-instructions">Select all that apply.</span>
                                                </div><!-- /.modal-header -->
                                                <div class="modal-body">
                                                    <ul class="nav nav-tabs nav-justified">
                                                        <li class="active"><a href="#languageTab" data-toggle="tab">LANGUAGE</a></li>
                                                        <li><a href="#moreTab" data-toggle="tab">SPECIAL NEEDS &amp; TRANSPORTATION</a></li>
                                                    </ul> 
                                                    <div class="tab-content">
                                                        <div class="tab-pane fade active in" id="languageTab">
                                                            <div class="col-sm-6 checkbox-group">
                                                                <c:forEach items="${languageValues}" var="language" varStatus="p_tracker">
                                                                <c:set var="checked" value=""/><c:if test="${not empty filters and cfn:collectionContains(filters.languages, language) }">
                                                                    <c:set var="checked" value=" checked"/>
                                                                </c:if>
                                                                
                                                                <c:set var="dataLink" value="" />
                                                                <c:if test="${cfn:collectionContains(primaryLanguages, language.name) }">
                                                                    <c:set var="dataLink" value=' data-linked-checkbox="lang-${fn:toLowerCase(language.name)}"' />
                                                                </c:if>
                                                                
                                                                <label class="checkbox${checked}" for="lang${p_tracker.index}">
                                                                    <input id="lang${p_tracker.index}" type="checkbox" data-filter-option="${language.name}"${dataLink}/>
                                                                    <spring:message code="${language.names[0]}" />
                                                                </label>
                                                                
                                                                <c:if test="${((fn:length(languageValues) % 2 ne 0) and (p_tracker.index +1) eq ((fn:length(languageValues) + 1) /2)) or (fn:length(languageValues) % 2 eq 0 and (fn:length(languageValues) / 2 eq (p_tracker.index + 1)))}">
                                                            </div>
                                                            <div class="col-sm-6 checkbox-group">
                                                                </c:if>
                                                                </c:forEach>                                                               
                                                            </div>
                                                        </div><!-- /.tab-pane -->                    
                                                        <div class="tab-pane fade" id="moreTab">
                                                            <div class="row">
                                                                <div class="col-sm-6 col-xs-12">
                                                                    <c:forEach items="${accessibilitySupportValues}" var="entry">
                                                                        <h5><spring:message code="${entry.key.localizedStringCode}" /></h5>
                                                                        
                                                                        <c:forEach items="${entry.value}" var="accessibilitySupport" varStatus="p_tracker">
                                                                            <c:set var="checked" value=""/>
                                                                            <c:if test="${not empty filters and cfn:collectionContains(filters.accessibilitySupports, accessibilitySupport)}">
                                                                                <c:set var="checked" value=" checked"/>
                                                                            </c:if>
                                                                            
                                                                            <c:set var="dataLink" value="" />
                                                                            <c:if test="${cfn:collectionContains(primaryAccessibilitySupports, accessibilitySupport.name)}">
			                                                                    <c:set var="dataLink" value=' data-linked-checkbox="accessibility-support-${fn:toLowerCase(accessibilitySupport.name)}"' />
			                                                                </c:if>
		                                                                    
		                                                                    <label class="checkbox${checked}" for="accessibility-support-${fn:toLowerCase(accessibilitySupport.name)}">
		                                                                      <input id="accessibility-support-${fn:toLowerCase(accessibilitySupport.name)}" type="checkbox" data-filter-option="${accessibilitySupport.name}"${dataLink} />
	                                                                          <spring:message code="${accessibilitySupport.localizedStringCode}" />
                                                                            </label>
		                                                              </c:forEach>  
		                                                        </div>
		                                                        <div class="col-sm-6 col-xs-12">
		                                                                                                                              
                                                                    </c:forEach>                                                                    
                                                                </div>
                                                            </div>
                                                        </div><!-- /.tab-pane -->
                                                    </div><!-- ./tab-content -->
                                                    <div class="modal-button-container"><button class="btn btn-default" data-dismiss="modal">Apply</button></div>
                                                </div><!-- /.modal-body -->
                                            </div><!-- /.modal-content -->
                                        </div><!-- /.modal-dialog -->
                                    </div><!-- /.modal -->
                                </div><!-- /.panel-body -->
                            </div><!-- /#collapseSix -->
                        </div><!-- /.panel -->                  
                    </div><!-- /.panel-group -->
                </div><!-- /.search-options-panel -->
                
            </div><!-- /.left-column -->
            
            <div class="col-sm-8 right-column">
				
                <div class="search-results">

                    <div class="showing-results">Showing Results <span class="now-showing">${results.pageStartIndex} - ${results.pageEndIndex}</span> of <span class="total-results">${results.totalNumberOfResults}</span></div>
            
                    <spring:url value="/static/images/site/right_arrow.png" var="rightArrow" />
                    <spring:url value="/static/images/site/heart_icon.png" var="heartIcon" />
                    
                    <c:forEach items="${results.items}" var="result" varStatus="p_tracker">
                        <spring:url value="/static/church-images/${result.id}/${result.displayImage.path}" var="imagePath"/>
						<c:if test="${result.usersFavorite}">
                    		<spring:url value="/static/images/site/heart_favorited_icon.png" var="heartIcon" />
                    	</c:if>
                                            
                        <div class="search-result-entry show-result" data-result-id="${p_tracker.index + 1}" data-church-name="${result.organizationName}" data-latitude="${result.latitude}" data-longitude="${result.longitude}">

                            <div class="search-result-image-container">
                                <img src="${imagePath}" alt="${result.displayImage.alt}" title="${result.displayImage.title}" />
                            </div>

                            <div class="search-result-info">
                                <div class="church-basic-info">
                                	<spring:url value="/church-profile/${result.id}?dist=${result.distanceFromSearchPoint}" var="churchUrl" />
                                    <a href="${churchUrl}"><span class="church-name">${result.organizationName}</span></a>
                                    <span class="church-denomination">${result.denomination}</span>
                                    <span class="church-location">${result.city}, ${result.state} ${result.postalCode}<img src="${rightArrow}" /> <span class="distance"><fmt:formatNumber maxFractionDigits="2" value="${result.distanceFromSearchPoint}" /></span> miles away</span>
                                </div>
                                <div class="church-sliders">
                                    <div class="slider-container">
                                        <div class="slider-label">Service Style</div><div class="info-slider" data-slider-value="${result.serviceStyleSliderValue}"></div>
                                    </div>
                                    <div class="slider-container">
                                        <div class="slider-label">Music</div><div class="info-slider" data-slider-value="${result.musicStyleSliderValue }"></div>
                                    </div>
                                    <div class="slider-container">
                                        <div class="slider-label">Dress Attire</div><div class="info-slider" data-slider-value="${result.dressAttireSliderValue }"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="favorite-icon">
                                <img src="${heartIcon}" />
                            </div>
                        </div>                        
                    </c:forEach>

                </div><!-- end search-results -->
                <div class="pagination pagination-centered"></div>
                
            </div><!-- /.right-column -->
            
        </div><!-- /.main -->

        <%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%> 
    </body>
</html>