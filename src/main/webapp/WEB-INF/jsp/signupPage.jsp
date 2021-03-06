<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="isModalRequest" value="false" />
<c:if test="${not empty param.modal and param.modal eq 'true'}">
    <c:set var="isModalRequest" value="true" />
</c:if>

<html>
<head>
    <c:if test="${not isModalRequest}">
     <%-- Common Metadata, scripts, and CSS --%>
     <%@ include file="/WEB-INF/jsp/partials/commonHead.jsp"%>

     <spring:url value="/static/js/register.js" var="registerJS" />
     <spring:url value="/static/js/jquery.geocomplete.js" var="geoCompletePlugin" />
     <script type="text/javascript">
         $LAB.queueScript("https://maps.googleapis.com/maps/api/js?libraries=places&sensor=false&callback=initAutoComplete")
             .queueScript("${geoCompletePlugin}")        
             .runQueue();
         
     </script>

     <title>Of A Feather - Sign Up</title>
     </c:if>   
</head>
<body>
    <c:if test="${not isModalRequest}">
    <div class="page-container">
        <%-- Site Header --%>
        <%@ include file="/WEB-INF/jsp/partials/siteHeader.jsp"%>
    
   
	    <div class="modal-dialog">            
	        <div class="modal-content">
    </c:if>
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title">Sign up</h4>
	            </div>
	            <div id="sign-up-modal-body" class="modal-body">
	                <div class="social-container">
	                   <c:if test="${not signUpCommand.socialSignIn}">
	                   <a href="<c:url value="/auth/facebook"/>" data-toggle="modal" data-target="#socialSignInModal"><button class="btn btn-block btn-xlarge btn-facebook register"><i class="fa fa-facebook"></i> | Connect with Facebook</button></a>
	                   
	                   </c:if>
	                   
	                   <spring:url value="/signup" var="actionURL"/>
	                   
	                   <c:if test="${signUpCommand.socialSignIn}">
	                   <div class="social-user-identification">
	                       <img src="${signUpCommand.displayImageUrl}"><h3>${signUpCommand.firstName} ${signUpCommand.lastName}</h3>
	                   </div>
                       <form:form action="${actionURL}" commandName="signUpCommand" method="POST" enctype="utf8" role="form" class="sign-up-form" data-action="Signup" >    
		                    <form:hidden path="signInProvider"/>
                            <input type="hidden" path="${_csrf.parameterName}" value="${_csrf.token}" >
	                        
	                        <div class="form-group">
                                <form:input id="user-email" path="email" cssClass="form-control" placeholder="Email Address"/>
                                <form:errors id="error-email" path="email" cssClass="help-block"/>
	                        </div>
	                        
	                        <div class="form-group">
	                            <form:password id="user-password" path="password" cssClass="form-control" placeholder="Password"/>
	                            <form:errors id="error-password" path="password" cssClass="help-block"/>
	                        </div>
	                        
	                        <div class="form-group">
	                            <form:password id="user-passwordVerification" path="passwordVerification" cssClass="form-control" placeholder="Confirm Password"/>
	                            <form:errors id="error-passwordVerification" path="passwordVerification" cssClass="help-block"/>
	                        </div>
                        
	                       <button type="submit" class="btn btn-primary btn-block">Finish ${signUpCommand.signInProvider.providerDisplayName} Signup</button>
	                    </form:form>
	                    </c:if>
	                </div>
	                
	                <c:if test="${not signUpCommand.socialSignIn}">
	                <div class="or-separator">
	                    <h6 class="separator-text">or</h6>
	                    <hr>
	                </div>
	                <c:if test="${isModalRequest}">
	                <button class="btn btn-block btn-xlarge email-sign-up">Sign up with Email</button>
                    </c:if>
                    
                   <form:form action="${actionURL}" commandName="signUpCommand" method="POST" enctype="utf8" role="form" class="sign-up-form" data-action="Signup" >
                    
	                    <input type="hidden" path="${_csrf.parameterName}" value="${_csrf.token}" >
	                    
	                    <div class="form-group">
	                        <form:input id="user-firstName" path="firstName" cssClass="form-control" placeholder="First Name"/>
	                        <form:errors id="error-firstName" path="firstName" cssClass="help-block"/>
	                    </div>
	                    <div class="form-group">
	                        <form:input id="user-lastName" path="lastName" cssClass="form-control" placeholder="Last Name"/>
	                        <form:errors id="error-lastName" path="lastName" cssClass="help-block"/>
	                    </div>
	                    <div class="form-group">
	                        <form:input id="user-email" path="email" cssClass="form-control" placeholder="Email Address"/>
	                        <form:errors id="error-email" path="email" cssClass="help-block"/>
	                    </div>
	                    <div class="form-group">
	                        <form:password id="user-password" path="password" cssClass="form-control" placeholder="Password"/>
	                        <form:errors id="error-password" path="password" cssClass="help-block"/>
	                    </div>
	                    <div class="form-group">
	                        <form:password id="user-passwordVerification" path="passwordVerification" cssClass="form-control" placeholder="Confirm Password"/>
	                        <form:errors id="error-passwordVerification" path="passwordVerification" cssClass="help-block"/>
	                    </div>
	                    
	                    <button type="submit" class="btn btn-primary btn-block">Sign Up</button>
	                </form:form>
		            </c:if>
		            <br />
	                <p class="agree-terms">By signing up, I agree to Of A Feather&apos;s <a href="#">Privacy Policy</a> and <a href="#">Terms &amp; Conditions</a>.</p>
	                    
	            </div>
	            <div class="modal-footer">
	                Already a member? <a href='<spring:url value="/signin" />' class="switch-to-log-in-modal">Log in</a>
	            </div>                  
                    
    <c:if test="${not isModalRequest}">            
	        </div>
	    </div>
    
        <%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%>
    </div>
    </c:if>        
</body>
</html>