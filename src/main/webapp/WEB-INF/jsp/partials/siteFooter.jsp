<spring:url value="/static/images/site/facebook_128.png" var="facebookIcon"/>
<spring:url value="/static/images/site/instagram_64.png" var="instagramIcon"/>
<spring:url value="/static/images/site/twitter_128.png" var="twitterIcon"/>

<spring:url value="/privacyPolicy" var="privacyPolicy" />
<spring:url value="/termsConditions" var="termsConditions" />
    <div class="footer">

        <div class="footer-content">
            <div class="links"><a href="${aboutUsLink}">ABOUT US</a> | <a href="${addYourChurchLink}">ADD YOUR CHURCH</a> | <a href="#">CONTACT</a> | <a href="${termsConditions}">TERMS AND CONDITIONS</a> | <a href="${privacyPolicy}">PRIVACY POLICY</a></div>
            <div class="copyright">&copy; 2013 FlockSpring, Inc.</div>
            <div class="social-media"><a href="https://www.facebook.com/ofafeather.org"><img src="${facebookIcon}" /></a> <a href="https://twitter.com/OfAFeatherOrg"><img src="${twitterIcon}" /></a> <a href="http://instagram.com/ofafeatherorg"><img src="${instagramIcon}" /></a></div>
        </div>

    </div>

</div> <!-- close page-container -->
