<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<spring:url value="/static/images/site/ofafeather_logo.png" var="ofafeatherLogo" />
<spring:url value="/static/css/ofafeather.css" var="customStyleCSS" />
<spring:url value="/static/images/ofAFeatherIcon.ico" var="ofAFeatherIcon" />


<link href="${customStyleCSS}" rel="stylesheet" type="text/css" />
<link href="${ofAFeatherIcon}" rel="icon" />

<spring:url value="/static/js/iepngfix_tilebg.js" var="iePngFx_tileBg" />
<spring:url value="/static/js/iepngfix.js" var="iePngFx" />
<script type="text/javascript" src="${iePngFx }"></script>
<script type="text/javascript" src="${iePngFx_tileBg }"></script>

<%-- Google Analytics Snippit --%>
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-43100670-1', 'ofafeather.org');
  ga('send', 'pageview');

</script>