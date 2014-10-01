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
                  <li><a href="#settings" role="tab" data-toggle="tab">Search Settings</a></li>
                  <li><a href="#account" role="tab" data-toggle="tab">Account</a></li>
                </ul>
                <!-- Tab panes -->
                <div class="tab-content">
                    <div class="tab-pane fade in active" id="profile">
                        <form:form action="${actionUrl}" commandName="profileCommand" method="POST" enctype="utf8" role="form" class="form-horizontal">
                            <input type="hidden" path="${_csrf.parameterName}" value="${_csrf.token}" >
                            <div class="form-group">
                                <label for="profilePic" class="col-sm-3 control-label">Profile Picture</label>
                                <div class="col-sm-8">
                                    <c:if test="${not empty user.displayImageUrl}">
                                        <img class="img-rounded" src="${user.displayImageUrl}" /><br />
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="profileName" class="col-sm-3 control-label">Display Name</label>
                                <div class="col-sm-4">
                                    <form:input path="displayName" cssClass="form-control" id="profileName" placeholder="Enter the name you want to identified by"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="profileName" class="col-sm-3 control-label">First Name</label>
                                <div class="col-sm-4">
                                    <form:input path="firstName" cssClass="form-control" id="profileName" placeholder="John" />
                                </div>
                            </div>
                            <div class="form-group">
                                <form:label path="lastName" cssClass="col-sm-3 control-label">Last Name</form:label>                                
                                <div class="col-sm-4">
                                    <form:input path="lastName" type="text" name="lastName" cssClass="form-control" id="profileName" placeholder="Doe" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="profileEmail" class="col-sm-3 control-label">Email Address</label>
                                <div class="col-sm-8">
                                    <form:input path="email" type="email" name="email" cssClass="form-control" id="profileEmail" placeholder="${userCommand.email}" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="profileDOB" class="col-sm-3 control-label">Birth Date</label>
                                <div id="birthdateSelection" class="col-sm-8">
                                    <form:input path="birthDate" type="hidden" id="profileBirthDate" value="${userCommand.birthDate}" />
                                </div>
                            </div> 
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-8">
                                    <button type="submit" class="btn btn-primary disabled">Save Changes</button>
                                </div>
                            </div>
                        </form:form>
                                              
                    </div>
                                
                    <div class="tab-pane fade" id="settings">
                        <form:form action="${actionUrl}" commandName="searchCriteriaCommandObject" method="POST" enctype="utf8" role="form" class="form-horizontal">
                            
                            <div class="form-group">
                                <label for="settingsDenominations" class="col-sm-3 control-label">Denomination(s)</label>
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
                                <label for="profileLanguages" class="col-sm-3 control-label">Preferred Languages</label>
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
                                <label for="settingsServiceStyle" class="col-sm-3 control-label">Service Style</label>
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
                                <label for="settingsDressAttire" class="col-sm-3 control-label">Dress Attire</label>
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
                                <label for="settingsMusicStyle" class="col-sm-3 control-label">Music Style</label>
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
                                <div class="col-sm-offset-3 col-sm-8">
                                    <button type="submit" class="btn btn-primary">Save Changes</button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                                
                    <div class="tab-pane fade" id="account">
                        <form:form action="${actionUrl}" commandName="passwordChangeCommandObject" method="POST" enctype="utf8" role="form" class="form-horizontal">
                            <input type="hidden" path="${_csrf.parameterName}" value="${_csrf.token}" >
                        	<div class="col-sm-offset-3 col-sm-9">
                                <h4>Change Password</h4>
                            </div>
                            <div class="form-group">
                                <label for="accountOldPassword" class="col-sm-3 control-label">Old Password</label>
                                <div class="col-sm-8">
                                    <input type="password" class="form-control" id="accountOldPassword">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="accountNewPassword" class="col-sm-3 control-label">New Password</label>
                                <div class="col-sm-8">
                                    <input type="password" class="form-control" id="accountNewPassword">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="accountNewPasswordRepeat" class="col-sm-3 control-label">Repeat New Password</label>
                                <div class="col-sm-8">
                                    <input type="password" class="form-control" id="accountNewPasswordRepeat">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-8">
                                    <button type="submit" class="btn btn-primary">Update Password</button>
                                </div>
                            </div>
                        </form:form>                        
                        
                        <br />
                        
                        <div class="col-sm-offset-3 col-sm-9">
                            <h4>Connect Account to Social Media</h4>
                        </div>
                        
                        <div class="col-sm-offset-3 col-sm-4">
                            
                            <button class="btn btn-xlarge btn-block btn-facebook"><i class="fa fa-facebook"></i> | Connect with Facebook</button>
                            
                            <button class="btn btn-xlarge btn-block btn-twitter"><i class="fa fa-twitter"></i> | Connect with Twitter</button>

                            <br /><br />
                        </div>
                    </div>
                 </div>
                </sec:authorize>
            </div><!-- /.container .main -->

            <%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%> 
            <%@ include file="/WEB-INF/jsp/partials/outOfRegionModal.jsp"%>
        </div>
        
    </body>
</html>