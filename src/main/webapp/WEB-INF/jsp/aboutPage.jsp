<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/init.jsp"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <%-- Common Metadata, scripts, and CSS --%>
        <%@ include file="/WEB-INF/jsp/partials/commonHead.jsp"%>

        <title>Of A Feather - Find your new church home today</title>	
    </head>
    <body>

        <%-- Site Header --%>
        <%@ include file="/WEB-INF/jsp/partials/siteHeader.jsp"%>

        <spring:url value="/static/images/site/jenn_photo.jpg" var="jennPhoto"/>
        <spring:url value="/static/images/site/justen_photo.jpg" var="justenPhoto"/>
        
        <div class="main container about-page">
            <div class="row">
                <div class="col-xs-12 col-sm-10 col-sm-offset-1">
                    <h1>About Us</h1>
                    <div class="links">
                        <a href="#overview">Overview</a> | <a href="#whoWeAre">Who We Are</a> | <a href="#visionValues">Vision &amp; Values</a> | <a href="#FAQs">FAQ&apos;s</a>
                    </div>
                    <a id="overview"></a><h2>Overview</h2>
                    <h3>Find the church for you, find faith activities &amp; events,<br />and get plugged into community.</h3>
                    <p>
                        We know from experience it&apos;s hard to find the right church. Searching for a church community can feel like an arduous journey full of frustration, fragmented information and resources, especially if you&apos;re new in town.
                    </p>
                    <p>
                        Now finding church for you just got a lot easier. Of a Feather is the Christian&apos;s new best friend for finding a church and local faith-related events that you want to know about. We&apos;ve built an online platform that delivers a personalized church search to help people discover the church that fits them in a faster, easier, and more intuitive way. Some people have called us Yelp for churches. In some ways we&apos;re similar in that we give each church a profile so they can clearly communicate who they are and what they&apos;re about with images, video, ratings, and other helpful information. Our church profiles go deeper to showcase the full picture of a church community. The platform also provides useful search filters to refine your church search based on preferences of styles, languages, and more.
                    </p>
                    <p>
                        Now finding a church community is no longer is a frustrating and daunting task. And churches themselves now have a clear avenue to be found online. Whether you&apos;re new in town, or just want to find extra community activities to join, Of a Feather bridges the gap between people and churches to link the Christian community through technology.
                    </p>
                    <hr class="divider"/>

                    <a id="whoWeAre"></a><h2>Who We Are</h2>
                    <h3>Our Story</h3>
                    <p>
                        A transition from college to career left the founder seeking to a new hole to fill and the search for a new church community began. To her dismay the search for a new church was not easy and proved to be a very frustrating experience, full of fragmented information and lack of good resources. In another part of the country, a similar story of dissatisfaction with the process of finding a church was experienced by her future co-founder. Years later the two founders would cross paths and decide to partner-up with a shared vision that there must be a better way to find a new church and learn about faith-related activities. Of a Feather is the proud product of their dream of making church-finding a frustration-free experience. We do this by making church communities and their activities easily discoverable in a way that&apos;s meaningful for people looking to join or participate.
                        Join us in this worthwhile mission by <a href="${addYourChurchLink}">adding your church</a> to our site today. 
                    </p>
                    <div class="gray-block">
                        <h3 style="margin-bottom:15px;">The Team</h3> 
                        <div class="team-info-container">
                            <div class="team-member-photo">
                                <img src="${jennPhoto}" />
                            </div>
                            <div class="team-member-bio">
                                <h5>Jenn Seigal</h5>
                                <p>
                                    A native to the San Francisco Bay Area, Jenn has spent over 6 years honing her online marketing chops where she excelled in generating profitable click traffic to her client&apos;s websites and products with clients ranging from small businesses to top-tier Fortune 500 companies. Inspired from a frustrating church search herself, Jenn channeled her online talents toward her faith, helping simplify church discovery by creating a personalized church search experience. Jenn&apos;s favorite flavor of church are ones that love to dance and sing. She is a Founder Institute graduate, contributor to Femgineer.com, and is a 2014 Fellow in the Startup Leadership Program in the Silicon Valley.
                                </p>
                            </div>
                        </div>
                        <div class="team-info-container">
                            <div class="team-member-photo">
                                <img src="${justenPhoto}" />
                            </div>
                            <div class="team-member-bio">
                                <h5>Justen Britain</h5>
                                <p>
                                    Father of three boys and avid car racer, Justen knows how to juggle fun and responsibility. Justen is a Sr. Software Engineer and experienced entrepreneur. When he is not chasing his boys or the finish line, he is coding to make a difference and an impact in this world. Justen loves the Lord and is very involved with his church in Seattle, WA. 
                                </p>
                            </div>
                        </div>
                        <div class="team-info-container">
                            <div class="team-member-photo">
                                <img src="http://placehold.it/130x130" />
                            </div>
                            <div class="team-member-bio">
                                <h5>Steven Yarbrough</h5>
                                <p>
                                    A secondary mathematics teacher for seven years, Steven was honored as &quot;Teacher of the Year&quot; at East Rutherford High School in 2010. Ready for the next challenge, he returned to graduate school at Appalachian State as a Chancellor&apos;s Fellow, where he earned an M.A. in Mathematics. He is now beginning a new stage of his life and career with a web development company in beautiful Western North Carolina. Steven enjoys working with small businesses and non-profit organizations to help make a positive impact through technology. 
                                </p>
                            </div>
                        </div>    
                    </div>

                    <a id="visionValues"></a><h2>Vision &amp; Values</h2>
                    <h3>Our Vision</h3>
                    <p>
                        To empower the personal discovery of faith communities, churches, and their events. We serve as an online bridge, connecting people and church communities everywhere. Ultimately our work supports the greater human condition and Christian community by helping people find a sense of belonging, unity, and interconnectedness.
                    </p>
                    <h3>Our Values</h3>
                    <p>
                        Community Building - Community building is the heart and cornerstone of our organization. The body has many parts but is strongest and most complete when joined together. &quot;The body is a unit, though it is made up of many parts; and though all its parts are many, they form one body. So it is with Christ,&quot; 1 Corinthians 12:12.
                    </p>
                    <p>
                        Servant Leadership - We take a servants heart in the matter of how we run our company. Let us lead by serving with love, care and respect. We pledge to listen to our community and be there to serve as best as possible. 
                    </p>
                    <p>
                        Love - We come with a heart of love. We believe it is not our place to stand in judgment of any differences, groups, or persons. We choose love in place of fear. 
                    </p>
                    <p>
                        Gratitude - Thank you for being apart of this wonderful community. We are thankful for all the contributions from those who shared with the world about your church and provided your feedback. We would not be here without you. 
                    </p>

                    <div class="gray-block">
                        <a id="FAQs"></a><h2>FAQ's</h2>
                        <ul>
                            <li>
                                <p>Is OfaFeather open to all faiths?</p>
                                <p>OfaFeather is open to all Christian-based denominations</p>
                            </li>
                            <li>
                                <p>Who runs OfaFeather?</p>
                                <p>
                                    We are independent and not formally affiliated with any particular church or denomination. The people behind it are two founders who strongly believe in the mission to help connect people with church online.
                                </p>
                            </li>
                            <li>
                                <p>Is this a non-profit organization?</p>
                                <p>
                                    We are incorporated as a for-profit corporation with a strong social mission to help people find community by connecting people with churches online. We feel this is the best avenue to support our goal of serving as a valuable resource for the long-term. 
                                </p>
                            </li>
                            <li>
                                <p>What Does It Cost?</p>
                                <p>
                                    It is completely free to add your church and information. No surprises. It will always be free to be on OfaFeather.org.
                                </p>
                            </li>
                            <li>
                                <p>How will you make money?</p>
                                <p>
                                    Our vision is to be a support to help bridge the gap between seekers and churches online. In the future we are going to offer premium features, services, and advertising plans. The premium services will be charged for, but they will be completely optional. You will never be under any obligation to upgrade to a paid plan or service. We will let you know before we role out new changes. 
                                </p>
                            </li>
                            <li>
                                <p>I&apos;m interested in interning or volunteering. Are there opportunities?</p>
                                <p>Please contact Jenn[at]ofafeather.org</p>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="filler">&nbsp;</div>
        </div>

        <%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%>

    </body>