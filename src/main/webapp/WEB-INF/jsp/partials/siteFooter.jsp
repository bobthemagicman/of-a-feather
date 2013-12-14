<spring:url value="/static/images/site/facebook_128.png" var="facebookIcon"/>
<spring:url value="/static/images/site/instagram_64.png" var="instagramIcon"/>
<spring:url value="/static/images/site/twitter_128.png" var="twitterIcon"/>

<spring:url value="/static/js/LAB-debug.min.js" var="labJS" />

<spring:url value="/static/js/bootstrap.min.js" var="bootstrapJS" />
<spring:url value="/static/js/bootstrap-paginator.min.js" var="bootstrapPaginatorJS" />
<spring:url value="/static/js/front.js" var="frontJS" />
<spring:url value="/static/js/search.js" var="searchJS" />
<spring:url value="/static/js/profile.js" var="profileJS" />

<div class="footer">

    <div class="footer-content">
        <div class="links"><a href="#">ABOUT US</a> | <a href="#">ADD YOUR CHURCH</a>  | <a href="#">CONTACT</a></div>
        <div class="copyright">&copy; 2013 FlockSpring, Inc.</div>
        <div class="social-media"><a href="https://www.facebook.com/ofafeather.org"><img src="${facebookIcon}" /></a> <a href="https://twitter.com/OfAFeatherOrg"><img src="${twitterIcon}" /></a> <a href="http://instagram.com/ofafeatherorg"><img src="${instagramIcon}" /></a></div>
    </div>

</div>


<!-- Scripts placed at the end of the document so the pages load faster -->
<script src="${labJS}"></script>
<script type="text/javascript">
    $LAB
   .script("http://code.jquery.com/jquery-latest.js").wait()
   .script("${bootstrapJS}").wait()
   .script("${bootstrapPaginatorJS}").wait()
   .script("https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&callback=initializeMap").wait()
   .script("http://code.jquery.com/ui/1.10.3/jquery-ui.js").wait()
   .script("${frontJS}")
   .script("${searchJS}")
   .script("${profileJS}");
   
</script>


