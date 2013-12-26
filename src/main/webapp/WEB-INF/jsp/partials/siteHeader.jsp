<spring:url value="/addAChurch" var="addYourChurchLink" />
<spring:url value="/about" var="aboutUsLink" />
<spring:url value="/" var="homeLink" />

<div class="page-container">

    <nav class="navbar navbar-default" role="navigation">
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
                    <ul class="nav navbar-nav navbar-right">

                            <li><a href="${aboutUsLink}">ABOUT US</a></li>
                            <li><a href="${addYourChurchLink}">ADD YOUR CHURCH</a></li>
                    </ul>
            </div>
            <!-- /.navbar-collapse -->
    </nav>