<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css"/>
<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"/>
<link rel="stylesheet" type="text/css" href="<spring:url value="/static/css/ofafeather.css"/>"  />
<link rel="stylesheet" type="text/css" href="<spring:url value="/static/css/social-buttons.css"/>"  />
<link rel="stylesheet" type="text/css" href="<spring:url value="/static/css/elastislide.css"/>"  />

<link rel="icon" href="<spring:url value="/static/images/ofAFeatherIcon.ico" />" />

<!--[if IE 6]>
<script type="text/javascript" src="<spring:url value="/static/js/iepngfix_tilebg.js" />"></script>
<script type="text/javascript" src="<spring:url value="/static/js/iepngfix.js" />"></script>
<![endif]-->

<%-- Google Analytics Snippit --%>
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-43100670-1', 'ofafeather.org');
  ga('send', 'pageview');

</script>

<script type="text/javascript" src="<spring:url value="/static/js/LAB-debug.min.js" />"></script>

<spring:url value="/static/js/uservoice.js" var="userVoiceJS" />
<script type="text/javascript">
    $LAB.setOptions({AlwaysPreserveOrder:true});
    $LAB.queueScript("https://code.jquery.com/jquery-2.1.1.min.js")
        //.queueScript("//netdna.bootstrapcdn.com/bootstrap/2.3.2/js/bootstrap.min.js")
        .queueScript("//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js")
        .queueScript("http://code.jquery.com/ui/1.10.3/jquery-ui.js")
        .queueScript("${userVoiceJS}");
</script>


<script type="text/javascript">
    var resourceBaseURL = '<spring:url value="/static/" />';
    var requestBaseUrl = '<spring:url value="/" />';
</script>

<c:set var="navSearchEnabled" value="false" /> 
<spring:url value="/static/images/site/ofafeather_logo.png" var="ofafeatherLogo" />