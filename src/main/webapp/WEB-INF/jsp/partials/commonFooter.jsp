<%@ include file="/WEB-INF/jsp/init.jsp" %>
<div class="footer">

    <spring:url value="https://www.facebook.com/ofafeather.org" var="facebookLink" />
    <spring:url value="/static/images/site/facebook_128.png" var="facebookIcon"/>

    <spring:url value="https://twitter.com/OfAFeatherOrg" var="twitterLink" />
    <spring:url value="/static/images/site/twitter_128.png" var="twitterIcon"/>

    <spring:url value="http://instagram.com/ofafeatherorg" var="instagramLink" />
    <spring:url value="/static/images/site/instagram_64.png" var="instagramIcon"/>
   
    
    <div class="footer-content">
        <div class="links"><a href="#">ABOUT</a> | <a href="#">CONTACT</a> | <a href="#">SIGN-UP</a> | <a href="#">SIGN-IN</a> | <a href="#">TERMS OF SERVICE</a> | <a href="#">CREDITS</a></div>
        <div class="copyright">&copy; 2013 FlockSpring, Inc.</div>
        <div class="social-media"><a href="${facebookLink}"><img src="${facebookIcon}" /></a> <a href="${twitterLink}"><img src="${twitterIcon}" /></a> <a href="${instagramLink}"><img src="${instagramIcon}" /></a></div>
    </div>

</div>

<spring:url value="http://code.jquery.com/jquery-latest.js" var="jqueryJS"/>
<spring:url value="/static/js/bootstrap.min.js" var="bootstrapMinJS"/>
<spring:url value="/static/js/home.js" var="homeJS"/>

<script type="text/javascript" src="${jqueryJS }"></script>
<script type="text/javascript" src="${bootstrapMinJS}"></script>
<script type="text/javascript" src="${homeJS }"></script>
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-43100670-1', 'ofafeather.org');
  ga('send', 'pageview');

</script>
