<spring:url value="/addYourChurch" var="addYourChurchLink" />
<spring:url value="/about" var="aboutUsLink" />
<spring:url value="/" var="homeLink" />
<spring:url value="/search" var="searchAction" />
<spring:url value="/privacyPolicy" var="privacyPolicy" />
<spring:url value="/contact" var="contactUsLink" />


<nav class="navbar navbar-default <c:if test='${navSearchEnabled}'>navbar-search-enabled</c:if>" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
                        <span class="icon-bar"></span> <span class="icon-bar"></span>
                </button>

                <a class="navbar-brand" href="${homeLink}"><img	src="${ofafeatherLogo}" /></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse">
            <c:if test="${showHeaderSearch}">
            <div class="col-sm-4 navbar-form-wrapper">
                <form class="navbar-form navbar-left" action="${searchAction}" method="GET" role="search">
                    <div class="input-group">
                        <input type="text" name="search-bar" id="search-bar" class="form-control button-on-right" placeholder="Look Near (City and State, Zip, or Neighborhood)">
                        <span class="input-group-btn">
                            <button class="btn icon-btn" type="submit" id="searchButton"><span class="glyphicon glyphicon-search"></span></button>
                        </span>
                    </div>
                </form>
            </div>
            </c:if>
            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="isAuthenticated()">
                <c:if test="${not empty user.displayName}">
			    <li><c:if test="${not empty user.displayImageUrl}"><img src="${user.displayImageUrl}" /></c:if>${user.displayName}</li> 
			    </c:if>
			    <li><a href="<c:url value="/signout" />" > SIGN OUT</a></li>
                </sec:authorize>
                <sec:authorize access="isAnonymous()">
                <li><a href="<spring:url value='/signup'/>" class="sign-up">SIGN UP</a></li>
                <li><a href="<spring:url value='/signin'/>" class="sign-in">SIGN IN</a></li>
                </sec:authorize>
                <li><a href="https://docs.google.com/forms/d/1z7UPHqIvfdLTmiy_U9HFsd9Pud6mXWjd-uWrUQwwFZo/viewform" target="_blank">LOCAL EVENTS</a></li>
                <li><a href="http://blog.ofafeather.org">BLOG</a></li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
</nav>

<%@ include file="/WEB-INF/jsp/partials/loginModal.jsp"%>
