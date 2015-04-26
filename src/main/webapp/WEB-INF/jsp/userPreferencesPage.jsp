<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/init.jsp"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <%-- Common Metadata, scripts, and CSS --%>
        <%@ include file="/WEB-INF/jsp/partials/commonHead.jsp"%>

        <spring:url value="/static/js/preferences.js" var="preferencesJS" />
        <spring:url value="/static/js/jquery.form.min.js" var="jqueryForm"/>
        <spring:url value="/static/js/jquery.geocomplete.js" var="geoCompletePlugin" />
        <spring:url value="/static/js/bday-picker.js" var="bdayPickerJS" />
        
        <script type="text/javascript">
            $LAB.queueScript("${preferencesJS}")
                    .queueScript("${geoCompletePlugin}")
                    .queueScript("${jqueryForm}")
                    .queueScript("${bdayPickerJS}")
                    .runQueue();
            
        </script>
        
        <spring:url value="/user/async/savePreferences" var="actionUrl"/>
        <title>Of A Feather - Search Results</title>	
    </head>
    <body data-rn="${userKey}" >
        <div class="page-container user-preferences">
            <%-- Site Header --%>
            <c:set var="navSearchEnabled" value="true" />
            <%@ include file="/WEB-INF/jsp/partials/siteHeader.jsp"%>

            <div class="container main" data-search-latitude="${results.searchLatitude}" data-search-longitude="${results.searchLongitude}">
                <br /><br />
                <sec:authorize access="isAuthenticated()">
                
                
                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist">
                  <li class="active"><a href="#profile" role="tab" data-toggle="tab">Profile</a></li>
                  <li><a href="#settings" role="tab" data-toggle="tab"><spring:message code="user.preferences.search.settings" text="Search Settings" /></a></li>
                  <li><a href="#account" role="tab" data-toggle="tab"><spring:message code="user.preferences.account" text="Account" /></a></li>
                </ul>
                <!-- Tab panes -->
                <div class="tab-content">
                    <div class="tab-pane fade in active" id="profile">
                        <form:form action="${actionUrl}" commandName="profileCommand" method="POST" enctype="utf8" role="form" class="form-horizontal">
                            <input type="hidden" path="${_csrf.parameterName}" value="${_csrf.token}" >
                            <div class="form-group">
                                <label for="profilePic" class="col-sm-3 control-label"><spring:message code="user.preferences.profile.picture" text="Profile Picture" /></label>
                                <div class="col-sm-8">
                                    <c:if test="${not empty user.displayImageUrl}">
                                        <img class="img-rounded" src="${user.displayImageUrl}" /><br />
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="profileName" class="col-sm-3 control-label"><spring:message code="user.preferences.display.name" text="Display Name" /></label>
                                <div class="col-sm-4">
                                	<spring:message code="user.preferences.enter.name" text="Enter the name you want to identified by" var="enterName"/>
                                    <form:input path="displayName" cssClass="form-control" id="profileName" placeholder="${enterName}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="profileName" class="col-sm-3 control-label"><spring:message code="user.preferences.first.name" text="First Name" /></label>
                                <div class="col-sm-4">
                                	<spring:message code="user.preferences.first.name.placeholder" text="John" var="placeHolderFirstName" />
                                    <form:input path="firstName" cssClass="form-control" id="profileName" placeholder="${placeHolderFirstName}" />
                                </div>
                            </div>
                            <div class="form-group">
                                <form:label path="lastName" cssClass="col-sm-3 control-label"><spring:message code="user.preferences.last.name" text="Last Name" /></form:label>                                
                                <div class="col-sm-4">
                                	<spring:message code="user.preferences.last.name.placeholder" text="Doe" var="placeHolderLastName"/>
                                    <form:input path="lastName" type="text" name="lastName" cssClass="form-control" id="profileName" placeholder="${placeHolderLastName}" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="profileEmail" class="col-sm-3 control-label"><spring:message code="user.preferences.email.address" text="Email Address" /></label>
                                <div class="col-sm-8">
                                    <form:input path="email" type="email" name="email" cssClass="form-control" id="profileEmail" placeholder="${userCommand.email}" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="profileDOB" class="col-sm-3 control-label"><spring:message code="user.preferences.birth.date" text="Birth Date" /></label>
                                <div id="birthdateSelection" class="col-sm-8">
                                    <form:input path="birthDate" type="hidden" id="profileBirthDate" value="${userCommand.birthDate}" />
                                </div>
                            </div> 
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-8">
                                    <button type="submit" class="btn btn-primary disabled"><spring:message code="user.preferences.save.changes" text="Save Changes" /></button>
                                </div>
                            </div>
                        </form:form>
                                              
                    </div>
                                
                    <div class="tab-pane fade" id="settings">
                        <form:form action="${actionUrl}" commandName="searchCriteriaCommandObject" method="POST" enctype="utf8" role="form" class="form-horizontal">
                            
                            <div class="form-group">
                                <label for="settingsDenominations" class="col-sm-3 control-label"><spring:message code="denominations" text="Denomination(s)" /></label>
                                <div class="col-sm-8">
                                    <select id="settingsDenominations" multiple="multiple" class="form-control">
                                        <option>Baptist</option>
                                        <option>Methodist</option>
                                        <option>Presbyterian</option>
                                        <option>Catholic</option>
                                        <option>Anglican</option>
                                        <option>Mormon</option>
                                    </select>
                                </div>
                            </div>
                            <br />
                            <div class="form-group">
                                <label for="profileLanguages" class="col-sm-3 control-label"><spring:message code="preferred.languages" text="Preferred Languages" /></label>
                                <div class="col-sm-8">
                                    <select id="profileLanguages" multiple="multiple" class="form-control">
                                        <option>English</option>
                                        <option>Spanish</option>
                                        <option>French</option>
                                        <option>Mandarin</option>
                                    </select>
                                </div>
                            </div>
                            <br />
                            <div class="form-group">
                                <label for="settingsLocation" class="col-sm-3 control-label">Location</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="settingsLocation" placeholder="">
                                </div>
                            </div>
                            <br />
                            <div class="form-group">
                                <label for="settingsServiceStyle" class="col-sm-3 control-label"><spring:message code="service.style" text="Service Style" /></label>
                                <div class="col-sm-8 search-options-panel">
                                    <div class="slider-labels">
                                        <div class="slider-label-container"><span>CONSERVATIVE</span></div>
                                        <div class="slider-label-container"><span></span></div>
                                        <div class="slider-label-container"><span>HIGH ENERGY</span></div>
                                    </div>
                                    <div class="slider slider-filter" id="serviceStyleSlider" data-filter-type="atmosphereServiceStyle" data-min="${serviceStyleMin}" data-max="${serviceStyleMax}"></div>
                                    <div class="slider-tooltip" data-assoc-slider="serviceStyleSlider">&nbsp;</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="settingsDressAttire" class="col-sm-3 control-label"><spring:message code="dress.attire" text="Dress Attire" /></label>
                                <div class="col-sm-8 search-options-panel">
                                    <div class="slider-labels">
                                        <div class="slider-label-container"><span>FORMAL</span></div>
                                        <div class="slider-label-container"><span></span></div>
                                        <div class="slider-label-container"><span>CASUAL</span></div>
                                    </div>
                                    <div class="slider slider-filter" id="dressAttireSlider" data-filter-type="atmosphereDressAttire" data-min="${dressAttireeMin}" data-max="${dressAttireMax}"></div>   
                                    <div class="slider-tooltip" data-assoc-slider="dressAttireSlider">&nbsp;</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="settingsMusicStyle" class="col-sm-3 control-label"><spring:message code="music.style" text="Music Style" /></label>
                                <div class="col-sm-8 search-options-panel">
                                    <div class="slider-labels">
                                        <div class="slider-label-container"><span>TRADITIONAL</span></div>
                                        <div class="slider-label-container"><span></span></div>
                                        <div class="slider-label-container"><span>CONTEMPORARY</span></div>
                                    </div>
                                    <div class="slider slider-filter" id="musicSlider" data-filter-type="atmosphereMusicStyle" data-min="${musicStyleMin}" data-max="${musicStyleMax}"></div>
                                    <div class="slider-tooltip" data-assoc-slider="musicSlider">&nbsp;</div>
                                </div>
                            </div>
                            
                            <div class="form-group">
                            	<a href="#"><spring:message code="user.preferences.show.advanced.search.options" text="Show Advanced Search Options" /></a>
                            </div>
                            
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-8">
                                    <button type="submit" class="btn btn-primary"><spring:message code="user.preferences.save.changes" text="Save Changes" /></button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                                
                    <div class="tab-pane fade" id="account">
                    	<spring:url value="/user/async/updatePassword" var="actionUrl" />
                        <form:form action="${actionUrl}" commandName="passwordChangeCommandObject" method="POST" enctype="utf8" role="form" class="form-horizontal">
                            <input type="hidden" path="${_csrf.parameterName}" value="${_csrf.token}" >
                        	
                       		<div class="col-sm-offset-3 col-sm-9">
	                        	<h4><spring:message code="user.preferences.connect.account.to.social" text="Connect Account to Social Media" /></h4>
	                       	</div>
	                       
	                       	<div class="col-sm-offset-3 col-sm-4">
	                        	<c:choose>
	                           		<c:when test="${passwordChangeCommandObject.facebookSignInEnabled}">
	                           			<button class="btn btn-xlarge btn-block btn-facebook disabled"><i class="fa fa-facebook"></i> | <spring:message code="user.preferences.connected" text="Connected" /></button>
	                           		</c:when>
	                           		<c:otherwise>
	                           			<button class="btn btn-xlarge btn-block btn-facebook"><i class="fa fa-facebook"></i> | <spring:message code="user.preferences.connect.facebook" text="Connect with Facebook" /></button>
	                           		</c:otherwise>
	                           	</c:choose>
	                       </div>
                        
                        	<div class="col-sm-offset-3 col-sm-9">
                        		<h4>Change Password</h4>
                            </div>
                            <div class="form-group">
                                <label for="accountOldPassword" class="col-sm-3 control-label"><spring:message code="user.preferences.current.passwor" text="Current Password" /></label>
                                <div class="col-sm-8">
                                    <form:password path="originalPassword" class="form-control" />
                                </div>
                            </div>
                            <div class="form-group">
                                <form:label path="password" class="col-sm-3 control-label"><spring:message code="user.preferences.new.passwords" text="New Password" /></form:label>
                                <div class="col-sm-8">
                                	<form:password path="password" class="form-control" />
                                </div>
                            </div>
                            <div class="form-group">
                                <form:label path="passwordVerification" class="col-sm-3 control-label"><spring:message code="user.preferences.repeat.password" text="Repeat New Password" /></form:label>
                                <div class="col-sm-8">
                                	<form:password path="passwordVerification" class="form-control" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-8">
                                    <button type="submit" class="btn btn-primary"><spring:message code="user.preferences.update.password" text="Update Password" /></button>
                                </div>
                            </div>
                        </form:form>                        
                        
                        <br />
                        
                    </div>
                 </div>
                </sec:authorize>
            </div><!-- /.container .main -->

            <%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%> 
            <%@ include file="/WEB-INF/jsp/partials/outOfRegionModal.jsp"%>
        </div>
        
    </body>
</html>