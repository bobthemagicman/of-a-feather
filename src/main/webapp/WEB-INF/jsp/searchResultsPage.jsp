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
                    .runQueue();

            var showOutsideRegionModal = ${not empty error and error eq 'user_search_out_of_region'};
            
        	
        </script>

        

        <title>Of A Feather - Search Results</title>	
    </head>
    <body data-rn="${userKey}">
        <div class="page-container">
        <%-- Site Header --%>
        <c:set var="navSearchEnabled" value="true" />
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
                                            <label class="time-label checkbox${checked}" for="time${p_tracker.index + 1}">
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
                                        <c:if test="${not empty filters and cfn:collectionContains(filters.congregationSizes, congregationSize)}">
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
                                        <c:set var="serviceStyleMin" value="${filters.atmosphereServiceStyleFloor}" />
                                        <c:set var="serviceStyleMax" value="${filters.atmosphereServiceStyleCeiling}" />
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
                                        <c:set var="musicStyleMin" value="${filters.atmosphereMusicStyleFloor}" />
                                        <c:set var="musicStyleMax" value="${filters.atmosphereMusicStyleCeiling}" />
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
                                        <c:set var="dressAttireeMin" value="${filters.atmosphereDressAttireFloor}" />
                                        <c:set var="dressAttireMax" value="${filters.atmosphereDressAttireCeiling}" />
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
                                        <div class="col-xs-12 col-md-5">
                                            <h5>Nursery Care</h5>
                                            <c:forEach items="${nurseryValues}" var="n_program">
                                                <c:set var="checked" value=""/>
                                                <c:if test="${not empty filters and cfn:collectionContains(filters.programsAndMinistries, n_program) }">
                                                    <c:set var="checked" value=" checked"/>
                                                </c:if>
                                                <label class="checkbox${checked}" for="nursery-education-list-${fn:toLowerCase(n_program.name)}">
                                                    <input id="nursery-education-list-${fn:toLowerCase(n_program.name)}" type="checkbox" data-linked-checkbox="nursery-education-${fn:toLowerCase(n_program.name)}" data-filter-option="${n_program.name}" />
                                                    <spring:message code="${n_program.localizedStringCode}" />
                                                </label>
                                            </c:forEach>

                                        </div>
                                        <div class="col-xs-12 col-md-7">
                                            <h5>Educational</h5>
                                            <c:forEach items="${educationValues}" var="n_program">
                                                <c:set var="checked" value=""/>
                                                <c:if test="${not empty filters and cfn:collectionContains(filters.programsAndMinistries, n_program) }">
                                                    <c:set var="checked" value=" checked"/>
                                                </c:if>
                                                <label class="checkbox${checked}" for="nursery-education-list-${fn:toLowerCase(n_program.name)}">
                                                    <input id="nursery-education-list-${fn:toLowerCase(n_program.name)}" type="checkbox" data-linked-checkbox="nursery-education-${fn:toLowerCase(n_program.name)}" data-filter-option="${n_program.name}" />
                                                    <spring:message code="${n_program.localizedStringCode}" />
                                                    <c:if test="${n_program.name eq 'ADULT_EDUCATION'}">
                                                        <span class="glyphicon glyphicon-info-sign adult-education-tooltip"></span>
                                                    </c:if>
                                                </label>
                                            </c:forEach>
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
                                                                    <c:set var="nurseryAndEducation" value="${cfn:createList(fn:split('NURSERY_CARE,EDUCATION', ','))}" />
                                                                    <c:set var="category" value="" />
                                                                    <c:forEach items="${programsValues}" var="entry">
                                                                        <c:if test="${cfn:collectionContains(nurseryAndEducation, entry.key.name) }">
                                                                            <c:if test="${not empty category and category ne entry.key.name}">
                                                                            </div>
                                                                            <div class="col-sm-5 col-sm-offset-1">
                                                                            </c:if>
                                                                            <c:set var="category" value="${entry.key.name}" />
                                                                            <h5><spring:message code="${entry.key.localizedStringCode}" /></h5>
                                                                            <c:forEach items="${entry.value}" var="program">
                                                                                <c:set var="checked" value=""/>
                                                                                <c:if test="${not empty filters and cfn:collectionContains(filters.programsAndMinistries, program) }">
                                                                                    <c:set var="checked" value=" checked"/>
                                                                                </c:if>
                                                                                <label class="checkbox${checked}" for="nursery-education-${fn:toLowerCase(program.name)}">
                                                                                    <input id="nursery-education-${fn:toLowerCase(program.name)}" type="checkbox" data-linked-checkbox="nursery-education-list-${fn:toLowerCase(program.name)}" data-filter-option="${program.name}" />
                                                                                    <spring:message code="${program.localizedStringCode}" />
                                                                                    <c:if test="${program.name eq 'ADULT_EDUCATION'}">
                                                                                        <span class="glyphicon glyphicon-info-sign adult-education-tooltip"></span>
                                                                                    </c:if>
                                                                                </label>
                                                                            </c:forEach>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </div>
                                                            </div>
                                                        </div><!-- /.tab-pane -->
                                                        <div class="tab-pane fade" id="ageGenderTab">
                                                            <div class="row">
                                                                <div class="col-sm-5">
                                                                    <c:set var="ageGenderMusicArts" value="${cfn:createList(fn:split('AGE_GROUPS,GENDER_GROUPS,MUSIC_AND_ARTS', ','))}" />
                                                                    <c:set var="category" value="" />
                                                                    <c:forEach items="${programsValues}" var="entry">
                                                                        <c:if test="${cfn:collectionContains(ageGenderMusicArts, entry.key.name) }">
                                                                            <c:choose>
                                                                                <c:when test="${not empty category and category ne entry.key.name and category ne 'GENDER_GROUPS'}">
                                                                                </div>
                                                                                <div class="col-sm-3">
                                                                                </c:when>
                                                                                <c:when test="${not empty category and category ne entry.key.name and category eq 'GENDER_GROUPS'}">
                                                                                </div>
                                                                                <div class="col-sm-4">
                                                                                </c:when>
                                                                                <c:otherwise></c:otherwise>
                                                                            </c:choose>
                                                                            <c:set var="category" value="${entry.key.name}" />
                                                                            <h5><spring:message code="${entry.key.localizedStringCode}" /></h5>
                                                                            <c:forEach items="${entry.value}" var="program">
                                                                                <c:set var="checked" value=""/>
                                                                                <c:if test="${not empty filters and cfn:collectionContains(filters.programsAndMinistries, program) }">
                                                                                    <c:set var="checked" value=" checked"/>
                                                                                </c:if>
                                                                                <label class="checkbox${checked}" for="music-gender-arts-${fn:toLowerCase(program.name)}">
                                                                                    <input id="music-gender-arts-${fn:toLowerCase(program.name)}" type="checkbox" data-linked-checkbox="music-gender-arts-list-${fn:toLowerCase(program.name)}" data-filter-option="${program.name}" />
                                                                                    <spring:message code="${program.localizedStringCode}" />
                                                                                </label>
                                                                            </c:forEach>    

                                                                        </c:if>
                                                                    </c:forEach>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="tab-pane fade" id="socialSpiritualTab">
                                                            <div class="row">
                                                                <div class="col-sm-5 col-sm-offset-1">
                                                                    <c:set var="socialSpiritual" value="${cfn:createList(fn:split('SOCIAL,SPIRITUAL', ','))}" />
                                                                    <c:set var="category" value="" />
                                                                    <c:forEach items="${programsValues}" var="entry">
                                                                        <c:if test="${cfn:collectionContains(socialSpiritual, entry.key.name) }">
                                                                            <c:if test="${not empty category and category ne entry.key.name}">
                                                                            </div>
                                                                            <div class="col-sm-5 col-sm-offset-1">
                                                                            </c:if>
                                                                            <c:set var="category" value="${entry.key.name}" />
                                                                            <h5><spring:message code="${entry.key.localizedStringCode}" /></h5>
                                                                            <c:forEach items="${entry.value}" var="program">
                                                                                <c:set var="checked" value=""/>
                                                                                <c:if test="${not empty filters and cfn:collectionContains(filters.programsAndMinistries, program) }">
                                                                                    <c:set var="checked" value=" checked"/>
                                                                                </c:if>
                                                                                <label class="checkbox${checked}" for="social-spiritual-${fn:toLowerCase(program.name)}">
                                                                                    <input id="social-spiritual-${fn:toLowerCase(program.name)}" type="checkbox" data-linked-checkbox="social-spiritual-list-${fn:toLowerCase(program.name)}" data-filter-option="${program.name}" />
                                                                                    <spring:message code="${program.localizedStringCode}" />
                                                                                </label>
                                                                            </c:forEach>    

                                                                        </c:if>
                                                                    </c:forEach>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="tab-pane fade" id="supportOutreachTab">
                                                            <div class="row">
                                                                <div class="col-sm-5 col-sm-offset-1">
                                                                    <c:set var="supportCounselingOutreach" value="${cfn:createList(fn:split('SUPPORT_AND_COUNSELING,OUTREACH', ','))}" />
                                                                    <c:set var="col_tracker" value="false"/>
                                                                    <c:set var="category" value="" />
                                                                    <c:forEach items="${programsValues}" var="entry">
                                                                        <c:if test="${cfn:collectionContains(supportCounselingOutreach, entry.key.name) }">
                                                                            <c:if test="${not empty category and category ne entry.key.name}">
                                                                            </div>
                                                                            <div class="col-sm-5 col-sm-offset-1">
                                                                            </c:if>
                                                                            <c:set var="category" value="${entry.key.name}" />
                                                                            <h5><spring:message code="${entry.key.localizedStringCode}" /></h5>
                                                                            <c:forEach items="${entry.value}" var="program">
                                                                                <c:set var="checked" value=""/>
                                                                                <c:if test="${not empty filters and cfn:collectionContains(filters.programsAndMinistries, program) }">
                                                                                    <c:set var="checked" value=" checked"/>
                                                                                </c:if>
                                                                                <label class="checkbox${checked}" for="support-outreach-${fn:toLowerCase(program.name)}">
                                                                                    <input id="support-outreach-${fn:toLowerCase(program.name)}" type="checkbox" data-linked-checkbox="support-outreach-list-${fn:toLowerCase(program.name)}" data-filter-option="${program.name}" />
                                                                                    <spring:message code="${program.localizedStringCode}" />
                                                                                </label>
                                                                            </c:forEach>    

                                                                        </c:if>
                                                                    </c:forEach>
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
                                        <div class="col-xs-12 col-md-6">
                                            <h5>Language</h5>   
                                            <c:set var="primaryLanguages" value="${cfn:createList(fn:split('SPANISH,CANTONESE,MANDARIN,FRENCH', ',')) }"/>

                                            <c:forEach items="${languageValues}" var="language" varStatus="p_tracker">
                                                <c:if test="${cfn:collectionContains(primaryLanguages, language.name)}">
                                                    <c:set var="checked" value=""/><c:if test=""><c:set var="checked" value=" checked"/></c:if>   
                                                    <label class="checkbox${checked}" for="p-lang-list-${fn:toLowerCase(language.name)}">
                                                        <input id="p-lang-list-${fn:toLowerCase(language.name)}" type="checkbox" data-linked-checkbox="lang-${fn:toLowerCase(language.name)}" data-filter-option="${language.name}" />
                                                        <spring:message code="${language.names[0]}" text="" />
                                                    </label>
                                                </c:if>
                                            </c:forEach>

                                            <h5 class="ellipsis">&hellip;</h5>
                                        </div>
                                        <div class="col-xs-12 col-md-6">

                                            <c:set var="primaryAccessibilitySupports" value="${cfn:createList(fn:split('WHEELCHAIR_ACCESS,DEAF_TRANSLATOR,PARKING_LOT,CARPOOL', ',')) }"/>
                                            <c:forEach items="${accessibilitySupportValues}" var="entry">
                                                <h5><spring:message code="${entry.key.localizedStringCode}" /></h5>

                                                <c:forEach items="${entry.value}" var="accessibilitySupport" varStatus="p_tracker">
                                                    <c:if test="${cfn:collectionContains(primaryAccessibilitySupports, accessibilitySupport.name) }">
                                                        <c:set var="checked" value=""/><c:if test=""><c:set var="checked" value=" checked"/></c:if>
                                                        <label class="checkbox${checked}" for="p-accessibility-support-list-${fn:toLowerCase(accessibilitySupport.name)}">
                                                            <input id="p-accessibility-support-list-${fn:toLowerCase(accessibilitySupport.name)}" type="checkbox" data-linked-checkbox="accessibility-support-${fn:toLowerCase(accessibilitySupport.name)}" data-filter-option="${accessibilitySupport.name}" />
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
                                                                        <c:set var="dataLink" value=' data-linked-checkbox="p-lang-list-${fn:toLowerCase(language.name)}"' />
                                                                    </c:if>

                                                                    <label class="checkbox${checked}" for="lang-${fn:toLowerCase(language.name)}">
                                                                        <input id="lang-${fn:toLowerCase(language.name)}" type="checkbox" data-filter-option="${language.name}"${dataLink}/>
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
                                                                                <c:set var="dataLink" value=' data-linked-checkbox="p-accessibility-support-list-${fn:toLowerCase(accessibilitySupport.name)}"' />
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

                <c:set var="resultsMessageHidden" value="" />
                <c:set var="showingResultsHidden" value=" hidden" />
                <c:if test="${fn:length(results.churchListings) ne 0}">
                    <c:set var="resultsMessageHidden" value=" hidden" />
                    <c:set var="showingResultsHidden" value="" />
                </c:if>
                <div class="results-message${resultsMessageHidden}">Sorry!<br />We were unable to find any results matching your criteria.<br />Please try broadening your search.</div>
                <div class="showing-results${showingResultsHidden}">Showing Results <span class="now-showing">${results.pageStartIndex} - ${results.pageEndIndex}</span> of <span class="total-results">${results.totalNumberOfResults}</span> for <span class="user-search">&#34;${results.userInputQuery}&#34;</span></div>
                                
                <div class="search-results">
                    <ctg:churchListing items="${results.churchListings}" loginUrl="loginUrl"/>
                </div><!-- end search-results -->
                
                <!--  Pagination -->
                <spring:url value="/search?" var="baseUrl" />
                <ctg:pagination baseUrl="${baseUrl}" currentPage="${results.currentPage}" numberOfPagesToShow="${numberOfPagesToDisplay}" totalPages="${results.totalNumberOfPages}" queryString="${pageRequestQueryString}"/>
                
            </div><!-- /.right-column -->
        </div><!-- /.main -->

        <%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%> 
        <%@ include file="/WEB-INF/jsp/partials/outOfRegionModal.jsp"%>
        </div>
    </body>
</html>