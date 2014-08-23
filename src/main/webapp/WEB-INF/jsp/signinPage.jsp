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
             .queueScript("${registerJS}")
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
    </c:if>
    <sec:authorize access="isAnonymous()">
    <c:if test="${not isModalRequest}">
    <div class="modal-dialog" id="signinModal">
        <div class="modal-content">
    </c:if>         
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Log in</h4>
            </div>
            <div id="log-in-modal-body" class="modal-body">
                <div class="social-container">
                    <a href="<c:url value="/auth/facebook"/>"><button class="btn btn-xlarge btn-block btn-facebook"><i class="fa fa-facebook"></i> | Connect with Facebook</button></a>
                    <a href="<c:url value="/auth/twitter"/>"><button class="btn btn-xlarge btn-block btn-twitter"><i class="fa fa-twitter"></i> | Connect with Twitter</button></a>
                </div>

                <div class="or-separator">
                    <h6 class="separator-text">or</h6>
                    <hr>
                </div>

                <form accept-charset="UTF-8" action="${pageContext.request.contextPath}/signin/authenticate" class="signin-form login-form" data-action="Signin" method="post" role="form">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="form-group">
                        <input class="form-control" id="user-email" name="username" placeholder="Email Address" type="email">
                    </div>
                    
                    <div class="form-group">
                        <input class="form-control" id="signin_password" name="password" placeholder="Password" type="password">
                    </div>
                    <div class="col-sm-6 col-xs-12">
                        <div class="checkbox remember-me">
                            <label>
                                <input type="checkbox" name="remember_me" id="remember_me" value="true"> Remember me
                            </label>
                        </div>
                    </div>
                    <div class="col-sm-6 col-xs-12">
                        <a href="/forgot_password" class="forgot-password">Forgot password?</a>
                    </div>
                    
                    <button type="submit" class="btn btn-primary btn-block">Log In</button>
                </form>
            </div>
            <div class="modal-footer">
                Don&apos;t have an account? <a href="#" class="switch-to-sign-up-modal">Sign up</a>
            </div>
      <c:if test="${not isModalRequest}">              
        </div>
    </div>
      </c:if>
	</sec:authorize>
	   
    <sec:authorize access="isAuthenticated()">
       <a href="<spring:url value="/signout" />"><button type="submit" class="btn btn-primary btn-block">Sign Out</button></a> 
    </sec:authorize>
    
    <c:if test="${not isModalRequest}">
        <%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%>
    </div>
    </c:if>
</body>
</html>