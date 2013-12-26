<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/init.jsp"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <%-- Common Metadata, scripts, and CSS --%>
        <%@ include file="/WEB-INF/jsp/partials/commonHead.jsp"%>
        
        <spring:url value="/static/js/search.js" var="searchJS" />
        <script type="text/javascript">
            $LAB.queueScript("${searchJS}")
                .queueScript("https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&callback=initializeMap")
                .runQueue();
        </script>
        
        <title>Of A Feather - Search Results</title>	
    </head>
    <body>

        <%-- Site Header --%>
        <%@ include file="/WEB-INF/jsp/partials/siteHeader.jsp"%>

        <div class="container main" data-search-latitude="${results.searchLatitude}" data-search-longitude="${results.searchLongitude}">

            <spring:url value="/static/images/site/expand_map_icon.png" var="expandMapIcon" />    
            
            <div class="col-sm-4 left-column">
                <div class="map-container-outer">
                    <div class="map-buttons">
                        <img src="${expandMapIcon}" />
                    </div>
                    <div class="map-container">
                        <div id="map-canvas"></div>
                    </div><!-- end map-container -->
                </div>
                
                <div class="search-options-panel">
                    <div class="panel-group" id="accordion">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="accordion-toggle active" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                        Denomination
                                        <span class="chevron-icon"></span>
                                    </a>
                                </h4>
                            </div><!-- /.panel-heading -->
                            <div id="collapseOne" class="panel-collapse collapse in">
                                <div id="denominationOptions" class="panel-body filter" data-filter-type="affiliations">
                                    <div class="checkbox-group">
                                        <label class="checkbox" for="denom1"><input id="denom1" type="checkbox" data-linked-checkbox="denomList3" data-filter-option="BAPTIST" />Baptist<span class="badge">999+</span></label>
                                        <label class="checkbox" for="denom2"><input id="denom2" type="checkbox" data-linked-checkbox="denomList4" data-filter-option="CATHOLIC" />Catholic<span class="badge">103</span></label>
                                        <label class="checkbox" for="denom3"><input id="denom3" type="checkbox" data-linked-checkbox="denomList9" data-filter-option="ANGLICAN" />Episcopal (Anglican)<span class="badge">35</span></label>
                                        <label class="checkbox" for="denom4"><input id="denom4" type="checkbox" data-linked-checkbox="denomList12" data-filter-option="LUTHERAN" />Lutheran<span class="badge">8</span></label>
                                        <a data-toggle="modal" href="#denominationsModal" role="button" class="see-more-link">See more...</a>
                                    </div><!-- /.checkbox-group -->
                                    <div class="modal fade" id="denominationsModal">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h4 class="modal-title">Denomination</h4>
                                                    <span class="modal-instructions">Select all that apply.</span>
                                                </div><!-- /.modal-header -->
                                                <div class="modal-body">
                                                    <div class="row checkbox-group">
                                                        <div class="col-sm-6">

                                                            <label class="checkbox" for="denomList1"><input id="denomList1" type="checkbox" data-filter-option="APISTOLIC" />Apostolic</label>
                                                            <label class="checkbox" for="denomList2"><input id="denomList2" type="checkbox" data-filter-option="ASSEMBLIES_OF_GOD" />Assemblies of God</label>
                                                            <label class="checkbox" for="denomList3"><input id="denomList3" type="checkbox" data-linked-checkbox="denom1" data-filter-option="BAPTIST" />Baptist</label>
                                                            <label class="checkbox" for="denomList4"><input id="denomList4" type="checkbox" data-linked-checkbox="denom2" data-filter-option="CATHOLIC" />Catholic</label>

                                                            <label class="checkbox" for="denomList5"><input id="denomList5" type="checkbox" data-filter-option="CHRISTIAN_SCIENCE" />Christian Science</label>
                                                            <label class="checkbox" for="denomList6"><input id="denomList6" type="checkbox" data-filter-option="CHURCH_OF_GOD" />Church of God</label>
                                                            <label class="checkbox" for="denomList7"><input id="denomList7" type="checkbox" data-filter-option="BRETHREN" />Church of the Brethren</label>



                                                            <label class="checkbox" for="denomList8"><input id="denomList8" type="checkbox" data-filter-option="DISCIPLES_OF_CHRIST" />Disciples of Christ</label>

                                                            <label class="checkbox" for="denomList9"><input id="denomList9" type="checkbox" data-linked-checkbox="denom3" data-filter-option="ANGLICAN" />Episcopal (Anglican)</label>

                                                            <label class="checkbox" for="denomList10"><input id="denomList10" type="checkbox" data-filter-option="FOURSQUARE" />Foursquare</label>

                                                            <label class="checkbox" for="denomList11"><input id="denomList11" type="checkbox" data-filter-option="JEHOVAS_WITNESS" />Jehovah&apos;s Witness</label>
                                                            <label class="checkbox" for="denomList12"><input id="denomList12" type="checkbox" data-linked-checkbox="denom4" data-filter-option="LUTHERAN" />Lutheran</label>
                                                            <label class="checkbox" for="denomList13"><input id="denomList13" type="checkbox" data-filter-option="MENNONITE" />Mennonite</label>
                                                            <label class="checkbox" for="denomList14"><input id="denomList14" type="checkbox" data-filter-option="MESSIANIC_JUDAISM" />Messianic</label>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label class="checkbox" for="denomList15"><input id="denomList15" type="checkbox" data-linked-checkbox="denom5" data-filter-option="METHODISTS" />Methodist</label>
                                                            <label class="checkbox" for="denomList16"><input id="denomList16" type="checkbox" data-filter-option="LATTER_DAY_SAINTS" />Latter-Day Saints/Mormon</label>
                                                            <label class="checkbox" for="denomList17"><input id="denomList17" type="checkbox" data-filter-option="NAZARENE" />Nazarene</label>
                                                            <label class="checkbox" for="denomList18"><input id="denomList18" type="checkbox" data-linked-checkbox="denom6" data-filter-option="NONDENOMINATIONAL" />Non-Denominational</label>

                                                            <label class="checkbox" for="denomList19"><input id="denomList19" type="checkbox" data-filter-option="OPEN_BIBLE" />Open Bible</label>

                                                            <label class="checkbox" for="denomList20"><input id="denomList20" type="checkbox" data-filter-option="ORTHODOX" />Orthodox</label>
                                                            <label class="checkbox" for="denomList21"><input id="denomList21" type="checkbox" data-filter-option="PENTECOSTAL" />Pentecostal</label>
                                                            <label class="checkbox" for="denomList22"><input id="denomList22" type="checkbox" data-linked-checkbox="denom7" data-filter-option="PRESBYTERIAN" />Presbyterian</label>

                                                            <label class="checkbox" for="denomList23"><input id="denomList23" type="checkbox" data-filter-option="QUAKER" />Quaker (Friends)</label>
                                                            <label class="checkbox" for="denomList24"><input id="denomList24" type="checkbox" data-filter-option="REFORMED_CHURCHES" />Reformed Churches</label>
                                                            <label class="checkbox" for="denomList25"><input id="denomList25" type="checkbox" data-filter-option="SEVENTH_DAY_ADVENTIST" />Seventh Day Adventist</label>

                                                            <label class="checkbox" for="denomList26"><input id="denomList26" type="checkbox" data-filter-option="UNITARIAN" />Unitarian Universalist</label>
                                                            <label class="checkbox" for="denomList27"><input id="denomList27" type="checkbox" data-filter-option="UNITED_CHURCH_OF_CHRIST" />United Church of Christ</label>

                                                        </div>
                                                    </div>
                                                    <div class="modal-button-container"><button class="btn btn-default" data-dismiss="modal">Apply</button></div>
                                                </div><!-- /.modal-body -->
                                            </div><!-- /.modal-content -->
                                        </div><!-- /.modal-dialog -->
                                    </div><!-- /.modal -->
                                </div><!-- /.panel-body -->
                            </div><!-- /#collapseOne -->
                        </div><!-- /.panel -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                                        Day &amp; Time of Services
                                        <span class="chevron-icon"></span>
                                    </a>
                                </h4>
                            </div><!-- /.panel-heading -->
                            <div id="collapseTwo" class="panel-collapse collapse">
                                <div id="timedayOptions" class="panel-body">
                                    <div class="checkbox-group filter" data-filter-type="serviceTimes">
                                        <label class="checkbox" for="time1"><input id="time1" type="checkbox" data-filter-option="EARLY_MORNING" />Early Morning<span class="time-description">before 9am</span></label>
                                        <label class="checkbox" for="time2"><input id="time2" type="checkbox" data-filter-option="MID_MORNING" />Mid-Morning<span class="time-description">9am - 10:45am</span></label>
                                        <label class="checkbox" for="time3"><input id="time3" type="checkbox" data-filter-option="LATE_MORNING" />Late Morning<span class="time-description">11am - 12:45pm</span></label>
                                        <label class="checkbox" for="time4"><input id="time4" type="checkbox" data-filter-option="AFTERNOON" />Afternoon<span class="time-description">1pm - 4pm</span></label>
                                        <label class="checkbox" for="time5"><input id="time5" type="checkbox" data-filter-option="EVENING" />Evening<span class="time-description">after 4pm</span></label>
                                    </div><!-- /.checkbox-group -->
                                    <div class="day-buttons filter" data-filter-type="serviceDays">
                                        <input type="checkbox" id="sunday" data-filter-option="SUNDAY" /><label for="sunday">Sun</label>
                                        <input type="checkbox" id="monday" data-filter-option="MONDAY" /><label for="monday">Mon</label>
                                        <input type="checkbox" id="tuesday" data-filter-option="TUESDAY" /><label for="tuesday">Tue</label>
                                        <input type="checkbox" id="wednesday" data-filter-option="WEDNESDAY" /><label for="wednesday" class="wednesday">Wed</label>
                                        <input type="checkbox" id="thursday" data-filter-option="THURSDAY" /><label for="thursday">Thu</label>
                                        <input type="checkbox" id="friday" data-filter-option="FRIDAY" /><label for="friday">Fri</label>
                                        <input type="checkbox" id="saturday" data-filter-option="SATURDAY" /><label for="saturday">Sat</label>
                                    </div><!-- /.day-buttons -->
                                </div><!-- /.panel-body -->
                            </div><!-- /#collapseTwo -->
                        </div><!-- /.panel -->
                        <div class="panel panel-default">
                            <div class="panel-heading" >
                                <h4 class="panel-title">
                                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                                        Congregation Size
                                        <span class="chevron-icon"></span>
                                    </a>
                                </h4>
                            </div><!-- /.panel-heading -->
                            <div id="collapseThree" class="panel-collapse collapse">
                                <div id="congsizeOptions" class="panel-body checkbox-group filter" data-filter-type="congregationSize">
                                    <label class="checkbox" for="size1"><input id="size1" type="checkbox" data-filter-option="SMALL" />Small<span class="time-description">&lt; 100</span></label>
                                    <label class="checkbox" for="size2"><input id="size2" type="checkbox" data-filter-option="MEDIUM" />Medium<span class="time-description">101 - 400</span></label>
                                    <label class="checkbox" for="size3"><input id="size3" type="checkbox" data-filter-option="LARGE" />Large<span class="time-description">401 - 2000</span></label>
                                    <label class="checkbox" for="size4"><input id="size4" type="checkbox" data-filter-option="MEGA" />Mega<span class="time-description">2001+</span></label>
                                </div><!-- /#congsizeOptions -->
                            </div><!-- /#collapseThree -->
                        </div><!-- /.panel -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseFour">
                                        Atmosphere
                                        <span class="chevron-icon"></span>
                                    </a>
                                </h4>
                            </div><!-- /.panel-heading -->
                            <div id="collapseFour" class="panel-collapse collapse">
                                <div id="atmosphereOptions" class="panel-body">
                                    <h5 class="slider-heading">SERVICE STYLE</h5>
                                    <div class="slider-labels">
                                        <div class="slider-label-container"><span>CONSERVATIVE</span></div>
                                        <div class="slider-label-container"><span></span></div>
                                        <div class="slider-label-container"><span>HIGH ENERGY</span></div>
                                    </div>
                                    <div class="slider slider-filter" id="serviceStyleSlider" data-filter-type="atmosphereServiceStyle"></div>
                                    <div class="slider-tooltip" data-assoc-slider="serviceStyleSlider">&nbsp;</div>
                                    <h5 class="slider-heading">MUSIC</h5>
                                    <div class="slider-labels">
                                        <div class="slider-label-container"><span>TRADITIONAL</span></div>
                                        <div class="slider-label-container"><span></span></div>
                                        <div class="slider-label-container"><span>CONTEMPORARY</span></div>
                                    </div>
                                    <div class="slider slider-filter" id="musicSlider" data-filter-type="atmosphereMusicStyle"></div>
                                    <div class="slider-tooltip" data-assoc-slider="musicSlider">&nbsp;</div>
                                    <h5 class="slider-heading">DRESS ATTIRE</h5>
                                    <div class="slider-labels">
                                        <div class="slider-label-container"><span>FORMAL</span></div>
                                        <div class="slider-label-container"><span></span></div>
                                        <div class="slider-label-container"><span>CASUAL</span></div>
                                    </div>
                                    <div class="slider slider-filter" id="dressAttireSlider" data-filter-type="atmosphereDressAttire"></div>   
                                    <div class="slider-tooltip" data-assoc-slider="dressAttireSlider">&nbsp;</div>
                                    <br />
                                    <div class="gay-affirming">
                                        <input type="checkbox" id="gayAffirming" /><label for="gayAffirming">Gay Affirming</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseFive">
                                        Ministries &amp; Programs
                                        <span class="chevron-icon"></span>
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseFive" class="panel-collapse collapse">
                                <div id="programsOptions" class="panel-body checkbox-group filter" data-filter-type="programsAndMinistries">
                                    <div class="row">
                                        <div class="col-sm-5">
                                            <h5>Nursery Care</h5>
                                            <label class="checkbox" for="childCare1"><input id="childCare1" type="checkbox" data-linked-checkbox="childCareModal1" data-filter-option="INFANT_CARE" />Infant Care</label>
                                            <label class="checkbox" for="childCare2"><input id="childCare2" type="checkbox" data-linked-checkbox="childCareModal2" data-filter-option="TODDLER_CARE" />Toddler Care</label>
                                        </div>
                                        <div class="col-sm-7">
                                            <h5>Educational</h5>
                                            <label class="checkbox" for="education1"><input id="education1" type="checkbox" data-linked-checkbox="educationModal1" data-filter-option="SUNDAY_SCHOOL" />Sunday School</label>
                                            <label class="checkbox" for="education2"><input id="education2" type="checkbox" data-linked-checkbox="educationModal2" data-filter-option="BIBLE_STUDY" />Bible Studies</label>
                                            <label class="checkbox" for="education3"><input id="education3" type="checkbox" data-linked-checkbox="educationModal3" data-filter-option="SPIRITUAL_CLASSES" />Spiritual Classes</label>
                                            <label class="checkbox adult-education" for="education4"><input id="education4" type="checkbox" data-linked-checkbox="educationModal4" data-filter-option="ADULT_EDUCATION" />Adult Education <span class="glyphicon glyphicon-info-sign"></span></label>
                                        </div>
                                    </div>
                                    <br />
                                    <a data-toggle="modal" href="#moreProgramsModal" role="button" class="see-more-link">See more...</a>
                                    <div class="modal fade" id="moreProgramsModal">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h4 class="modal-title">More Programs</h4>
                                                    <span class="modal-instructions">Select all that apply.</span>
                                                </div><!-- /.modal-header -->
                                                <div class="modal-body">
                                                    <ul class="nav nav-tabs nav-justified">
                                                        <li class="active"><a href="#careEducationTab" data-toggle="tab">NURSERY CARE &amp;<br />EDUCATIONAL</a></li>
                                                        <li><a href="#ageGenderTab" data-toggle="tab">AGE GROUPS &amp;<br />CREATIVE ARTS</a></li>
                                                        <li><a href="#socialSpiritualTab" data-toggle="tab">SOCIAL &amp;<br />SPIRITUAL</a></li>
                                                        <li><a href="#supportOutreachTab" data-toggle="tab">SUPPORT &amp;<br />OUTREACH</a></li>
                                                    </ul> 
                                                    <div class="tab-content">
                                                        <div class="tab-pane fade active in" id="careEducationTab">
                                                            <div class="row">
                                                                <div class="col-sm-5 col-sm-offset-1">
                                                                    <h5>Nursery Care</h5>
                                                                    <label class="checkbox" for="childCareModal1"><input id="childCareModal1" type="checkbox" data-linked-checkbox="childCare1" data-filter-option="INFANT_CARE" />Infant Care</label>
                                                                    <label class="checkbox" for="childCareModal2"><input id="childCareModal2" type="checkbox" data-linked-checkbox="childCare2" data-filter-option="TODDLER_CARE" />Toddler Care</label>
                                                                </div>
                                                                <div class="col-sm-5 col-sm-offset-1">
                                                                    <h5>Education</h5>
                                                                    <label class="checkbox" for="educationModal1"><input id="educationModal1" type="checkbox" data-linked-checkbox="education1" data-filter-option="SUNDAY_SCHOOL" />Sunday School</label>
                                                                    <label class="checkbox" for="educationModal2"><input id="educationModal2" type="checkbox" data-linked-checkbox="education2" data-filter-option="BIBLE_STUDY" />Bible Studies</label>
                                                                    <label class="checkbox" for="educationModal3"><input id="educationModal3" type="checkbox" data-linked-checkbox="education3" data-filter-option="SPIRITUAL_CLASSES" />Spiritual Classes</label>
                                                                    <label class="checkbox adult-education" for="educationModal4"><input id="educationModal4" type="checkbox" data-linked-checkbox="education4" data-filter-option="ADULT_EDUCATION" />Adult Education <span class="glyphicon glyphicon-info-sign"></span></label>
                                                                </div>
                                                            </div>
                                                        </div><!-- /.tab-pane -->
                                                        <div class="tab-pane fade" id="ageGenderTab">
                                                            <div class="row">
                                                                <div class="col-sm-5">
                                                                    <h5>Age Groups</h5>
                                                                    <label class="checkbox" for="ageGender1"><input id="ageGender1" type="checkbox" data-filter-option="CHILDRENS_GROUP" />Children&apos;s</label>
                                                                    <label class="checkbox" for="ageGender2"><input id="ageGender2" type="checkbox" data-filter-option="MIDDLE_SCHOOL_GROUP" />Middle School/Junior High</label>
                                                                    <label class="checkbox" for="ageGender3"><input id="ageGender3" type="checkbox" data-filter-option="HIGH_SCHOOL_GROUP" />High School</label>
                                                                    <label class="checkbox" for="ageGender4"><input id="ageGender4" type="checkbox" data-filter-option="" />College</label>
                                                                    <label class="checkbox" for="ageGender10"><input id="ageGender10" type="checkbox" data-filter-option="YOUNG_ADULT_GROUP" />Post College/Young Professionals</label>
                                                                    <label class="checkbox" for="ageGender5"><input id="ageGender5" type="checkbox" data-filter-option="ADULT_GROUP" />Adult</label>
                                                                    <label class="checkbox" for="ageGender6"><input id="ageGender6" type="checkbox" data-filter-option="SENIOR_GROUP" />Senior Citizens</label>
                                                                </div>
                                                                <div class="col-sm-3">
                                                                    <h5>Gender Groups</h5>
                                                                    <label class="checkbox" for="ageGender8"><input id="ageGender8" type="checkbox" data-filter-option="MENS_GROUP" />Men&apos;s</label>
                                                                    <label class="checkbox" for="ageGender9"><input id="ageGender9" type="checkbox" data-filter-option="WOMENS_GROUP" />Women&apos;s</label>
                                                                </div>

                                                                <div class="col-sm-4">
                                                                    <h5>Music &amp; Arts</h5>
                                                                    <label class="checkbox" for="musicArts1"><input id="musicArts1" type="checkbox" data-filter-option="CHIOR" />Choir Group</label>
                                                                    <label class="checkbox" for="musicArts2"><input id="musicArts2" type="checkbox" data-filter-option="DANCE" />Dance Team</label>
                                                                    <label class="checkbox" for="musicArts3"><input id="musicArts3" type="checkbox" data-filter-option="MUSIC_MINISTRY" />Music Ministry</label>
                                                                    <label class="checkbox" for="musicArts4"><input id="musicArts4" type="checkbox" data-filter-option="DRAMA" />Drama Team</label>
                                                                    <label class="checkbox" for="musicArts5"><input id="musicArts5" type="checkbox" data-filter-option="CREATIVE_ARTS" />Creative Arts Ministry</label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="tab-pane fade" id="socialSpiritualTab">
                                                            <div class="row">
                                                                <div class="col-sm-5 col-sm-offset-1">
                                                                    <h5>Social</h5>
                                                                    <label class="checkbox" for="socialSpiritual2"><input id="socialSpiritual2" type="checkbox" data-filter-option="SPROTS" />Sports Activities</label>
                                                                    <label class="checkbox" for="socialSpiritual3"><input id="socialSpiritual3" type="checkbox" data-filter-option="SOCAIL_EVENTS" />Member Social Events</label>
                                                                    <label class="checkbox" for="socialSpiritual4"><input id="socialSpiritual4" type="checkbox" data-filter-option="SMALL_GROUPS" />Small Groups</label>
                                                                    <label class="checkbox" for="socialSpiritual5"><input id="socialSpiritual5" type="checkbox" data-filter-option="SINGLES_GROUPS" />Singles Events</label>
                                                                </div>
                                                                <div class="col-sm-5 col-sm-offset-1">
                                                                    <h5>Spiritual</h5>
                                                                    <label class="checkbox" for="socialSpiritual9"><input id="socialSpiritual9" type="checkbox" data-filter-option="PRAYER_GROUPS" />Prayer Groups</label>
                                                                    <label class="checkbox" for="socialSpiritual6"><input id="socialSpiritual6" type="checkbox" data-filter-option="HEALING_MINISTRY" />Healing Ministry</label>
                                                                    <label class="checkbox" for="socialSpiritual7"><input id="socialSpiritual7" type="checkbox" data-filter-option="PHOPHETIC_MINISTRY" />Prophetic Ministry</label>
                                                                    <label class="checkbox" for="socialSpiritual8"><input id="socialSpiritual8" type="checkbox" data-filter-option="WORSHIP_MINISTRY" />Worship Ministry</label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="tab-pane fade" id="supportOutreachTab">
                                                            <div class="row">
                                                                <div class="col-sm-5 col-sm-offset-1">
                                                                    <h5>Support &amp; Counseling</h5>
                                                                    <label class="checkbox" for="supportOutreach6"><input id="supportOutreach6" type="checkbox" data-filter-option="PRE_MARITAL_COUNSELING" />Pre-marital Services</label>
                                                                    <label class="checkbox" for="supportOutreach7"><input id="supportOutreach7" type="checkbox" data-filter-option="COUPLES_COUNSELING" />Couples Counseling</label>
                                                                    <label class="checkbox" for="supportOutreach8"><input id="supportOutreach8" type="checkbox" data-filter-option="GENERAL_COUNSELING" />General Counseling</label>
                                                                    <label class="checkbox" for="supportOutreach9"><input id="supportOutreach9" type="checkbox" data-filter-option="DIVORCE_GRIEF_COUNSELING" />Divorce/Grief</label>
                                                                    <label class="checkbox" for="supportOutreach10"><input id="supportOutreach10" type="checkbox" data-filter-option="ADDICTION_RECOVERY_COUNSELING" />Addiction/Recovery</label>
                                                                </div>
                                                                <div class="col-sm-5 col-sm-offset-1">
                                                                    <h5>Outreach</h5>
                                                                    <label class="checkbox" for="supportOutreach1"><input id="supportOutreach1" type="checkbox" data-filter-option="COMMUNITY_OUTREACH" />Community Service</label>
                                                                    <label class="checkbox" for="supportOutreach2"><input id="supportOutreach2" type="checkbox" data-filter-option="EVANGELISM_OUTREACH" />Evangelism Outreach</label>
                                                                    <label class="checkbox" for="supportOutreach3"><input id="supportOutreach3" type="checkbox" data-filter-option="FAMILY_OUTREACH" />Family Services</label>
                                                                    <label class="checkbox" for="supportOutreach4"><input id="supportOutreach4" type="checkbox" data-filter-option="FOOD_PANTRY_OUTREACH" />Food Pantry</label>
                                                                    <label class="checkbox" for="supportOutreach5"><input id="supportOutreach5" type="checkbox" data-filter-option="HOMELESS_OUTREACH" />Homeless Ministry</label>
                                                                    <label class="checkbox" for="supportOutreach6"><input id="supportOutreach6" type="checkbox" data-filter-option="MISSION_OUTREACH" />Mission Trips</label>
                                                                    <label class="checkbox" for="supportOutreach7"><input id="supportOutreach7" type="checkbox" data-filter-option="SOCIAL_JUSTICE_OUTREACH" />Social Justice/Activism</label>
                                                                </div>
                                                            </div>
                                                        </div><!-- /.tab-pane -->
                                                    </div><!-- /.tab-content -->
                                                    <div class="modal-button-container"><button class="btn btn-default" data-dismiss="modal">Apply</button></div>
                                                </div><!-- /.modal-body -->
                                            </div><!-- /.modal-content -->
                                        </div><!-- /.modal-dialog -->
                                    </div><!-- /.modal -->
                                </div><!-- /#programsOptions -->
                            </div><!-- /#collapseFive -->
                        </div><!-- /.panel -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseSix">
                                        Language &amp; More
                                        <span class="chevron-icon"></span>
                                    </a>
                                </h4>
                            </div><!-- /.panel-heading -->
                            <div id="collapseSix" class="panel-collapse collapse">
                                <div id="moreOptions" class="panel-body checkbox-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-xs-12">
                                            <h5>Language</h5>      
                                            <label class="checkbox" for="lang1"><input id="lang1" type="checkbox" data-linked-checkbox="langList22" data-filter-option="SPANISH" />Spanish</label>
                                            <label class="checkbox" for="lang2"><input id="lang2" type="checkbox" data-linked-checkbox="langList3" data-filter-option="CANTONESE" />Chinese (Cantonese)</label>
                                            <label class="checkbox" for="lang3"><input id="lang3" type="checkbox" data-linked-checkbox="langList4" data-filter-option="MAINDARIN" />Chinese (Mandarin)</label>
                                            <label class="checkbox" for="lang4"><input id="lang4" type="checkbox" data-linked-checkbox="langList5" data-filter-option="FRENCH" />French</label>
                                            <label class="checkbox" for="lang5"><input id="lang5" type="checkbox" data-linked-checkbox="langList1" data-filter-option="AMERICAN_SIGN_LANGUAGE" />Sign Language (ASL)</label>
                                            <h5 class="ellipsis">&hellip;</h5>
                                        </div>
                                        <div class="col-sm-6 col-xs-12">
                                            <h5>Special Needs</h5>
                                            <label class="checkbox" for="moreOptions1"><input id="moreOptions1" type="checkbox" data-linked-checkbox="moreOptionsList1" data-filter-option="WHEELCHAIR_ACCESS" />Wheelchair Access</label>
                                            <label class="checkbox" for="moreOptions2"><input id="moreOptions2" type="checkbox" data-linked-checkbox="moreOptionsList2" data-filter-option="DEAF_TRANSLATION" />Deaf Translation</label>
                                            <br />
                                            <h5>Transportation</h5>
                                            <label class="checkbox" for="moreOptions3"><input id="moreOptions3" type="checkbox" data-linked-checkbox="moreOptionsList4" data-filter-option="" />Parking Lot</label>
                                            <label class="checkbox" for="moreOptions4"><input id="moreOptions4" type="checkbox" data-linked-checkbox="moreOptionsList5" data-filter-option="" />Carpool Available</label>
                                        </div>
                                    </div>
                                    <br />
                                    <a data-toggle="modal" href="#languagesModal" role="button" class="see-more-link">See more...</a>
                                    <div class="modal fade" id="languagesModal">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h4 class="modal-title">Language and More</h4>
                                                    <span class="modal-instructions">Select all that apply.</span>
                                                </div><!-- /.modal-header -->
                                                <div class="modal-body">
                                                    <ul class="nav nav-tabs nav-justified">
                                                        <li class="active"><a href="#languageTab" data-toggle="tab">LANGUAGE</a></li>
                                                        <li><a href="#moreTab" data-toggle="tab">SPECIAL NEEDS &amp; TRANSPORTATION</a></li>
                                                    </ul> 
                                                    <div class="tab-content">
                                                        <div class="tab-pane fade active in" id="languageTab">
                                                            <div class="col-sm-6 checkbox-group">
                                                                <label class="checkbox" for="langList1"><input id="langList1" type="checkbox" data-linked-checkbox="lang5" data-filter-option="AMERICAN_SIGN_LANGUAGE" />American Sign Language</label>
                                                                <label class="checkbox" for="langList2"><input id="langList2" type="checkbox" data-filter-option="" />Armenian</label>
                                                                <label class="checkbox" for="langList3"><input id="langList3" type="checkbox" data-linked-checkbox="lang2" data-filter-option="CANTONESE" />Chinese (Cantonese)</label>
                                                                <label class="checkbox" for="langList4"><input id="langList4" type="checkbox" data-linked-checkbox="lang3" data-filter-option="MAINDARIN" />Chinese (Mandarin)</label>
                                                                
                                                                <label class="checkbox" for="langList5"><input id="langList5" type="checkbox" data-linked-checkbox="lang4" />French</label>
                                                                <label class="checkbox" for="langList6"><input id="langList6" type="checkbox" data-filter-option="" />French Creole</label>
                                                                <label class="checkbox" for="langList7"><input id="langList7" type="checkbox" data-filter-option="GERMAN" />German</label>
                                                                <label class="checkbox" for="langList8"><input id="langList8" type="checkbox" data-filter-option="GREEK" />Greek</label>
                                                                <label class="checkbox" for="langList9"><input id="langList9" type="checkbox" data-filter-option="GUJARATI" />Gujarati</label>
                                                                <label class="checkbox" for="langList10"><input id="langList10" type="checkbox" data-filter-option="HINDI" />Hindi</label>
                                                                <label class="checkbox" for="langList11"><input id="langList11" type="checkbox" data-filter-option="HMONG" />Hmong</label>
                                                                <label class="checkbox" for="langList12"><input id="langList12" type="checkbox" data-filter-option="ITALIAN" />Italian</label>
                                                                <label class="checkbox" for="langList13"><input id="langList13" type="checkbox" data-filter-option="JAPANESE" />Japanese</label>
                                                            </div>
                                                            <div class="col-sm-6 checkbox-group">
                                                                <label class="checkbox" for="langList14"><input id="langList14" type="checkbox" data-filter-option="KOREAN" />Korean</label>
                                                                <label class="checkbox" for="langList15"><input id="langList15" type="checkbox" data-filter-option="" />Laotian</label>
                                                                <label class="checkbox" for="langList16"><input id="langList16" type="checkbox" data-filter-option="KHMER" />Mon-Khmer, Cambodian</label>
                                                                <label class="checkbox" for="langList17"><input id="langList17" type="checkbox" data-filter-option="PERSIAN" />Persian</label>
                                                                <label class="checkbox" for="langList18"><input id="langList18" type="checkbox" data-filter-option="POLISH" />Polish</label>
                                                                <label class="checkbox" for="langList19"><input id="langList19" type="checkbox" data-filter-option="PORTUGESE" />Portuguese</label>
                                                                <label class="checkbox" for="langList20"><input id="langList20" type="checkbox" data-filter-option="RUSSIAN" />Russian</label>
                                                                <label class="checkbox" for="langList21"><input id="langList21" type="checkbox" data-filter-option="SERBO_CROATION" />Serbo-Croatian</label>
                                                                <label class="checkbox" for="langList22"><input id="langList22" type="checkbox" data-linked-checkbox="lang1" data-filter-option="SPANISH" />Spanish</label>
                                                                <label class="checkbox" for="langList23"><input id="langList23" type="checkbox" data-filter-option="THAI" />Thai</label>
                                                                <label class="checkbox" for="langList24"><input id="langList24" type="checkbox" data-filter-option="URDU" />Urdu</label>
                                                                <label class="checkbox" for="langList25"><input id="langList25" type="checkbox" data-filter-option="VIETNAMESE" />Vietnamese</label>
                                                                <label class="checkbox" for="langList26"><input id="langList26" type="checkbox" data-filter-option="" />Yiddish</label>
                                                            </div>
                                                        </div><!-- /.tab-pane -->                    
                                                        <div class="tab-pane fade" id="moreTab">
                                                            <div class="row">
                                                                <div class="col-sm-6 col-xs-12">
                                                                    <h5>Special Needs</h5>
                                                                    <label class="checkbox" for="moreOptionsList1"><input id="moreOptionsList1" type="checkbox" data-linked-checkbox="moreOptions1" data-filter-option="" />Wheelchair Access</label>
                                                                    <label class="checkbox" for="moreOptionsList2"><input id="moreOptionsList2" type="checkbox" data-linked-checkbox="moreOptions2" data-filter-option="" />Deaf Translator</label>
                                                                    <label class="checkbox" for="moreOptionsList3"><input id="moreOptionsList3" type="checkbox" data-filter-option="" />Hearing Loop</label>
                                                                </div>
                                                                <div class="col-sm-6 col-xs-12">
                                                                    <h5>Transportation</h5>
                                                                    <label class="checkbox" for="moreOptionsList4"><input id="moreOptionsList4" type="checkbox" data-linked-checkbox="moreOptions3" data-filter-option="" />Parking Lot</label>
                                                                    <label class="checkbox" for="moreOptionsList5"><input id="moreOptionsList5" type="checkbox" data-linked-checkbox="moreOptions4" data-filter-option="" />Carpool Available</label>
                                                                </div>
                                                            </div>
                                                        </div><!-- /.tab-pane -->
                                                    </div><!-- ./tab-content -->
                                                    <div class="modal-button-container"><button class="btn btn-default" data-dismiss="modal">Apply</button></div>
                                                </div><!-- /.modal-body -->
                                            </div><!-- /.modal-content -->
                                        </div><!-- /.modal-dialog -->
                                    </div><!-- /.modal -->
                                </div><!-- /.panel-body -->
                            </div><!-- /#collapseSix -->
                        </div><!-- /.panel -->                  
                    </div><!-- /.panel-group -->
                </div><!-- /.search-options-panel -->
                
            </div><!-- /.left-column -->
            
            <div class="col-sm-8 right-column">
				
                <div class="search-results">

                    <div class="showing-results">Showing Results <span class="now-showing">${results.pageStartIndex} - ${results.pageEndIndex}</span> of <span class="total-results">${results.totalNumberOfResults}</span></div>
            
                    <spring:url value="/static/images/site/right_arrow.png" var="rightArrow" />
                    <spring:url value="/static/images/site/heart_icon.png" var="heartIcon" />
                    
                    <c:forEach items="${results.items}" var="result" varStatus="p_tracker">
                        <spring:url value="/static/church-images/${result.id}/${result.displayImage.path}" var="imagePath"/>
						<c:if test="${result.usersFavorite}">
                    		<spring:url value="/static/images/site/heart_favorited_icon.png" var="heartIcon" />
                    	</c:if>
                                            
                        <div class="search-result-entry show-result" data-result-id="${p_tracker.index + 1}" data-church-name="${result.organizationName}" data-latitude="${result.latitude}" data-longitude="${result.longitude}">

                            <div class="search-result-image-container">
                                <img src="${imagePath}" alt="${result.displayImage.alt}" title="${result.displayImage.title}" />
                            </div>

                            <div class="search-result-info">
                                <div class="church-basic-info">
                                	<spring:url value="/church-profile/${result.id}?dist=${result.distanceFromSearchPoint}" var="churchUrl" />
                                    <a href="${churchUrl}"><span class="church-name">${result.organizationName}</span></a>
                                    <span class="church-denomination"><spring:message code="${result.denomination}" /></span>
                                    <span class="church-location">${result.city}, ${result.state} ${result.postalCode}<img src="${rightArrow}" /> <span class="distance"><fmt:formatNumber maxFractionDigits="2" value="${result.distanceFromSearchPoint}" /></span> miles away</span>
                                </div>
                                <div class="church-sliders">
                                    <div class="slider-container">
                                        <div class="slider-label">Service Style</div><div class="info-slider" data-slider-value="${result.serviceStyleSliderValue}"></div>
                                    </div>
                                    <div class="slider-container">
                                        <div class="slider-label">Music</div><div class="info-slider" data-slider-value="${result.musicStyleSliderValue }"></div>
                                    </div>
                                    <div class="slider-container">
                                        <div class="slider-label">Dress Attire</div><div class="info-slider" data-slider-value="${result.dressAttireSliderValue }"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="favorite-icon">
                                <img src="${heartIcon}" />
                            </div>
                        </div>                        
                    </c:forEach>

                </div><!-- end search-results -->
                <div class="pagination pagination-centered"></div>
                
            </div><!-- /.right-column -->
            
        </div><!-- /.main -->

        <%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%> 
    </body>
</html>