<spring:url value="/addYourChurch" var="addYourChurchLink" />
<spring:url value="/about" var="aboutUsLink" />
<spring:url value="/" var="homeLink" />
<spring:url value="/search" var="searchAction" />
<spring:url value="/privacyPolicy" var="privacyPolicy" />
<spring:url value="/contact" var="contactUsLink" />

<div class="page-container">

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
                <c:if test="${navSearchEnabled}">
                <div class="col-sm-4 navbar-form-wrapper">
                    <form class="navbar-form navbar-left" action="${searchAction}" method="GET" role="search">
                        <div class="input-group">
                            <input type="text" name="search-bar" id="search-bar" class="form-control button-on-right" placeholder="Start a new search...">
                            <span class="input-group-btn">
                                <button class="btn icon-btn" type="submit" id="searchButton"><span class="glyphicon glyphicon-search"></span></button>
                            </span>
                        </div>
                    </form>
                </div>
                </c:if>
                <ul class="nav navbar-nav navbar-right">

                    <li><a href="${aboutUsLink}">ABOUT US</a></li>
                    <li><a href="${addYourChurchLink}">ADD YOUR CHURCH</a></li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
    </nav>