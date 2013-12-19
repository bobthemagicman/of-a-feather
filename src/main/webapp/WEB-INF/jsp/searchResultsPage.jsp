<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/init.jsp"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <%-- Common Metadata, scripts, and CSS --%>
        <%@ include file="/WEB-INF/jsp/partials/commonHead.jsp"%>

        <title>Of A Feather - Search Results</title>	
    </head>
    <body>

        <%-- Site Header --%>
        <%@ include file="/WEB-INF/jsp/partials/siteHeader.jsp"%>

        <div class="container main" data-search-latitude="37.7833" data-search-longitude="-122.4167">

            <div class="col-sm-4 left-column">
                <div class="map-container-outer">
                    <div class="map-buttons"><span class="plus-icon"></span></div>
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
                                <div id="denominationOptions" class="panel-body">
                                    <div class="checkbox-group">
                                        <label class="checkbox" for="denom1"><input id="denom1" type="checkbox" data-toggle="checkbox" data-linked-checkbox="denomList4" />Baptist<span class="badge">999+</span></label>
                                        <label class="checkbox" for="denom2"><input id="denom2" type="checkbox" data-linked-checkbox="denomList5" />Catholic<span class="badge">103</span></label>
                                        <label class="checkbox" for="denom3"><input id="denom3" type="checkbox" data-linked-checkbox="denomList15"/>Episcopalian<span class="badge">35</span></label>
                                        <label class="checkbox" for="denom4"><input id="denom4" type="checkbox" data-linked-checkbox="denomList24"/>Lutheran<span class="badge">8</span></label>
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
                                                    <div class="col-sm-6 checkbox-group">
                                                        <label class="checkbox" for="denomList1"><input id="denomList1" type="checkbox" />Anglican</label>
                                                        <label class="checkbox" for="denomList2"><input id="denomList2" type="checkbox" />Apostolic</label>
                                                        <label class="checkbox" for="denomList3"><input id="denomList3" type="checkbox" />Assembly of God</label>
                                                        <label class="checkbox" for="denomList4"><input id="denomList4" type="checkbox" data-linked-checkbox="denom1" />Baptist</label>
                                                        <label class="checkbox" for="denomList5"><input id="denomList5" type="checkbox" data-linked-checkbox="denom2" />Catholic</label>
                                                        <label class="checkbox" for="denomList6"><input id="denomList6" type="checkbox" />Christian Reform</label>
                                                        <label class="checkbox" for="denomList7"><input id="denomList7" type="checkbox" />Christian Science</label>
                                                        <label class="checkbox" for="denomList8"><input id="denomList8" type="checkbox" />Church of God</label>
                                                        <label class="checkbox" for="denomList9"><input id="denomList9" type="checkbox" />Church of the Brethren</label>
                                                        <label class="checkbox" for="denomList10"><input id="denomList10" type="checkbox" />Church of the Nazarene</label>
                                                        <label class="checkbox" for="denomList11"><input id="denomList11" type="checkbox" />Church of Christ</label>
                                                        <label class="checkbox" for="denomList12"><input id="denomList12" type="checkbox" />Congregational/UCC</label>
                                                        <label class="checkbox" for="denomList13"><input id="denomList13" type="checkbox" />Disciples of Christ</label>
                                                        <label class="checkbox" for="denomList14"><input id="denomList14" type="checkbox" />Eastern Orthodox</label>
                                                        <label class="checkbox" for="denomList15"><input id="denomList15" type="checkbox" data-linked-checkbox="denom3" />Episcopalian</label>
                                                        <label class="checkbox" for="denomList16"><input id="denomList16" type="checkbox" />Evangelical</label>
                                                        <label class="checkbox" for="denomList17"><input id="denomList17" type="checkbox" />Foursquare</label>
                                                        <label class="checkbox" for="denomList18"><input id="denomList18" type="checkbox" />Full Gospel</label>
                                                        <label class="checkbox" for="denomList19"><input id="denomList19" type="checkbox" />Fundamentalist</label>
                                                        <label class="checkbox" for="denomList20"><input id="denomList20" type="checkbox" />Holiness/Holy</label>
                                                        <label class="checkbox" for="denomList21"><input id="denomList21" type="checkbox" />Independent Christian Church</label>
                                                    </div><!-- /.checkbox-group -->
                                                    <div class="col-sm-6 checkbox-group">
                                                        <label class="checkbox" for="denomList22"><input id="denomList22" type="checkbox" />Independent Fundamentalist</label>
                                                        <label class="checkbox" for="denomList23"><input id="denomList23" type="checkbox" />Jehovah&apos;s Witness</label>
                                                        <label class="checkbox" for="denomList24"><input id="denomList24" type="checkbox" data-linked-checkbox="denom4" />Lutheran</label>
                                                        <label class="checkbox" for="denomList25"><input id="denomList25" type="checkbox" />Mennonite</label>
                                                        <label class="checkbox" for="denomList26"><input id="denomList26" type="checkbox" />Messianic</label>
                                                        <label class="checkbox" for="denomList27"><input id="denomList27" type="checkbox" data-linked-checkbox="denom5" />Methodist</label>
                                                        <label class="checkbox" for="denomList28"><input id="denomList28" type="checkbox" />Mormon/Latter-Day Saints</label>
                                                        <label class="checkbox" for="denomList29"><input id="denomList29" type="checkbox" />Nazarene</label>
                                                        <label class="checkbox" for="denomList30"><input id="denomList30" type="checkbox" data-linked-checkbox="denom6" />Non-Denominational</label>
                                                        <label class="checkbox" for="denomList31"><input id="denomList31" type="checkbox" />Orthodox</label>
                                                        <label class="checkbox" for="denomList32"><input id="denomList32" type="checkbox" />Pentecostal</label>
                                                        <label class="checkbox" for="denomList33"><input id="denomList33" type="checkbox" data-linked-checkbox="denom7" />Presbyterian</label>
                                                        <label class="checkbox" for="denomList34"><input id="denomList34" type="checkbox" data-linked-checkbox="denom8" />Protestant</label>
                                                        <label class="checkbox" for="denomList35"><input id="denomList35" type="checkbox" />Quaker Reformed/Dutch Reform</label>
                                                        <label class="checkbox" for="denomList36"><input id="denomList36" type="checkbox" />Salvation Army</label>
                                                        <label class="checkbox" for="denomList37"><input id="denomList37" type="checkbox" />Seventh Day Adventist</label>
                                                        <label class="checkbox" for="denomList38"><input id="denomList38" type="checkbox" />Southern Baptist</label>
                                                        <label class="checkbox" for="denomList39"><input id="denomList39" type="checkbox" />Unitarian</label>
                                                        <label class="checkbox" for="denomList40"><input id="denomList40" type="checkbox" />United Church of Christ</label>
                                                        <label class="checkbox" for="denomList41"><input id="denomList41" type="checkbox" />Universal Christian Church</label>
                                                        <label class="checkbox" for="denomList42"><input id="denomList42" type="checkbox" />Vinyard</label>
                                                    </div><!-- /.checkbox-group -->
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
                                    <div class="checkbox-group">
                                        <label class="checkbox" for="time1"><input id="time1" type="checkbox" />Early Morning<span class="time-description">before 9am</span></label>
                                        <label class="checkbox" for="time2"><input id="time2" type="checkbox" />Mid-Morning<span class="time-description">9am - 10:45am</span></label>
                                        <label class="checkbox" for="time3"><input id="time3" type="checkbox" />Late Morning<span class="time-description">11am - 12:45pm</span></label>
                                        <label class="checkbox" for="time4"><input id="time4" type="checkbox" />Afternoon<span class="time-description">1pm - 4pm</span></label>
                                        <label class="checkbox" for="time5"><input id="time5" type="checkbox" />Evening<span class="time-description">after 4pm</span></label>
                                    </div><!-- /.checkbox-group -->
                                    <div class="day-buttons">
                                        <input type="checkbox" id="sunday" /><label for="sunday">Sun</label>
                                        <input type="checkbox" id="monday" /><label for="monday">Mon</label>
                                        <input type="checkbox" id="tuesday" /><label for="tuesday">Tue</label>
                                        <input type="checkbox" id="wednesday" /><label for="wednesday" class="wednesday">Wed</label>
                                        <input type="checkbox" id="thursday" /><label for="thursday">Thu</label>
                                        <input type="checkbox" id="friday" /><label for="friday">Fri</label>
                                        <input type="checkbox" id="saturday" /><label for="saturday">Sat</label>
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
                                <div id="congsizeOptions" class="panel-body checkbox-group">
                                    <label class="checkbox" for="size1"><input id="size1" type="checkbox" />Small<span class="time-description">&lt; 100</span></label>
                                    <label class="checkbox" for="size2"><input id="size2" type="checkbox" />Medium<span class="time-description">101 - 400</span></label>
                                    <label class="checkbox" for="size3"><input id="size3" type="checkbox" />Large<span class="time-description">401 - 2000</span></label>
                                    <label class="checkbox" for="size4"><input id="size4" type="checkbox" />Mega<span class="time-description">2001+</span></label>
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
                                    <div class="slider" id="serviceStyleSlider"></div>
                                    <div class="slider-tooltip" data-assoc-slider="serviceStyleSlider">&nbsp;</div>
                                    <h5 class="slider-heading">MUSIC</h5>
                                    <div class="slider-labels">
                                        <div class="slider-label-container"><span>TRADITIONAL</span></div>
                                        <div class="slider-label-container"><span></span></div>
                                        <div class="slider-label-container"><span>CONTEMPORARY</span></div>
                                    </div>
                                    <div class="slider" id="musicSlider"></div>
                                    <div class="slider-tooltip" data-assoc-slider="musicSlider">&nbsp;</div>
                                    <h5 class="slider-heading">DRESS ATTIRE</h5>
                                    <div class="slider-labels">
                                        <div class="slider-label-container"><span>FORMAL</span></div>
                                        <div class="slider-label-container"><span></span></div>
                                        <div class="slider-label-container"><span>CASUAL</span></div>
                                    </div>
                                    <div class="slider" id="dressAttireSlider"></div>   
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
                                <div id="programsOptions" class="panel-body checkbox-group">
                                    <div class="row">
                                        <div class="col-sm-5">
                                            <h5>Nursery Care</h5>
                                            <label class="checkbox" for="childCare1"><input id="childCare1" type="checkbox" data-linked-checkbox="childCareModal1" />Infant Care</label>
                                            <label class="checkbox" for="childCare2"><input id="childCare2" type="checkbox" data-linked-checkbox="childCareModal2" />Toddler Care</label>
                                        </div>
                                        <div class="col-sm-7">
                                            <h5>Educational</h5>
                                            <label class="checkbox" for="education1"><input id="education1" type="checkbox" data-linked-checkbox="educationModal1" />Sunday School</label>
                                            <label class="checkbox" for="education2"><input id="education2" type="checkbox" data-linked-checkbox="educationModal2" />Bible Studies</label>
                                            <label class="checkbox" for="education3"><input id="education3" type="checkbox" data-linked-checkbox="educationModal3" />Spiritual Classes</label>
                                            <label class="checkbox adult-education" for="education4"><input id="education4" type="checkbox" data-linked-checkbox="educationModal4" />Adult Education <span class="glyphicon glyphicon-info-sign"></span></label>
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
                                                                    <label class="checkbox" for="childCareModal1"><input id="childCareModal1" type="checkbox" data-linked-checkbox="childCare1" />Infant Care</label>
                                                                    <label class="checkbox" for="childCareModal2"><input id="childCareModal2" type="checkbox" data-linked-checkbox="childCare2" />Toddler Care</label>
                                                                </div>
                                                                <div class="col-sm-5 col-sm-offset-1">
                                                                    <h5>Education</h5>
                                                                    <label class="checkbox" for="educationModal1"><input id="educationModal1" type="checkbox" data-linked-checkbox="education1" />Sunday School</label>
                                                                    <label class="checkbox" for="educationModal2"><input id="educationModal2" type="checkbox" data-linked-checkbox="education2" />Bible Studies</label>
                                                                    <label class="checkbox" for="educationModal3"><input id="educationModal3" type="checkbox" data-linked-checkbox="education3" />Spiritual Classes</label>
                                                                    <label class="checkbox adult-education" for="educationModal4"><input id="educationModal4" type="checkbox" data-linked-checkbox="education4" />Adult Education <span class="glyphicon glyphicon-info-sign"></span></label>
                                                                </div>
                                                            </div>
                                                        </div><!-- /.tab-pane -->
                                                        <div class="tab-pane fade" id="ageGenderTab">
                                                            <div class="row">
                                                                <div class="col-sm-5">
                                                                    <h5>Age Groups</h5>
                                                                    <label class="checkbox" for="ageGender1"><input id="ageGender1" type="checkbox" />Children&apos;s</label>
                                                                    <label class="checkbox" for="ageGender2"><input id="ageGender2" type="checkbox" />Middle School/Junior High</label>
                                                                    <label class="checkbox" for="ageGender3"><input id="ageGender3" type="checkbox" />High School</label>
                                                                    <label class="checkbox" for="ageGender4"><input id="ageGender4" type="checkbox" />College</label>
                                                                    <label class="checkbox" for="ageGender10"><input id="ageGender10" type="checkbox" />Post College/Young Professionals</label>
                                                                    <label class="checkbox" for="ageGender5"><input id="ageGender5" type="checkbox" />Adult</label>
                                                                    <label class="checkbox" for="ageGender6"><input id="ageGender6" type="checkbox" />Senior Citizens</label>
                                                                </div>
                                                                <div class="col-sm-3">
                                                                    <h5>Gender Groups</h5>
                                                                    <label class="checkbox" for="ageGender8"><input id="ageGender8" type="checkbox" />Men&apos;s</label>
                                                                    <label class="checkbox" for="ageGender9"><input id="ageGender9" type="checkbox" />Women&apos;s</label>
                                                                </div>

                                                                <div class="col-sm-4">
                                                                    <h5>Music &amp; Arts</h5>
                                                                    <label class="checkbox" for="musicArts1"><input id="musicArts1" type="checkbox" />Choir Group</label>
                                                                    <label class="checkbox" for="musicArts2"><input id="musicArts2" type="checkbox" />Dance Team</label>
                                                                    <label class="checkbox" for="musicArts3"><input id="musicArts3" type="checkbox" />Music Ministry</label>
                                                                    <label class="checkbox" for="musicArts4"><input id="musicArts4" type="checkbox" />Drama Team</label>
                                                                    <label class="checkbox" for="musicArts5"><input id="musicArts5" type="checkbox" />Creative Arts Ministry</label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="tab-pane fade" id="socialSpiritualTab">
                                                            <div class="row">
                                                                <div class="col-sm-5 col-sm-offset-1">
                                                                    <h5>Social</h5>
                                                                    <label class="checkbox" for="socialSpiritual2"><input id="socialSpiritual2" type="checkbox" />Sports Activities</label>
                                                                    <label class="checkbox" for="socialSpiritual3"><input id="socialSpiritual3" type="checkbox" />Member Social Events</label>
                                                                    <label class="checkbox" for="socialSpiritual4"><input id="socialSpiritual4" type="checkbox" />Small Groups</label>
                                                                    <label class="checkbox" for="socialSpiritual5"><input id="socialSpiritual5" type="checkbox" />Singles Events</label>
                                                                </div>
                                                                <div class="col-sm-5 col-sm-offset-1">
                                                                    <h5>Spiritual</h5>
                                                                    <label class="checkbox" for="socialSpiritual9"><input id="socialSpiritual9" type="checkbox" />Prayer Groups</label>
                                                                    <label class="checkbox" for="socialSpiritual6"><input id="socialSpiritual6" type="checkbox" />Healing Ministry</label>
                                                                    <label class="checkbox" for="socialSpiritual7"><input id="socialSpiritual7" type="checkbox" />Prophetic Ministry</label>
                                                                    <label class="checkbox" for="socialSpiritual8"><input id="socialSpiritual8" type="checkbox" />Worship Ministry</label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="tab-pane fade" id="supportOutreachTab">
                                                            <div class="row">
                                                                <div class="col-sm-5 col-sm-offset-1">
                                                                    <h5>Support &amp; Counseling</h5>
                                                                    <label class="checkbox" for="supportOutreach6"><input id="supportOutreach6" type="checkbox" />Pre-marital Services</label>
                                                                    <label class="checkbox" for="supportOutreach7"><input id="supportOutreach7" type="checkbox" />Couples Counseling</label>
                                                                    <label class="checkbox" for="supportOutreach8"><input id="supportOutreach8" type="checkbox" />General Counseling</label>
                                                                    <label class="checkbox" for="supportOutreach9"><input id="supportOutreach9" type="checkbox" />Divorce/Grief</label>
                                                                    <label class="checkbox" for="supportOutreach10"><input id="supportOutreach10" type="checkbox" />Addiction/Recovery</label>
                                                                </div>
                                                                <div class="col-sm-5 col-sm-offset-1">
                                                                    <h5>Outreach</h5>
                                                                    <label class="checkbox" for="supportOutreach1"><input id="supportOutreach1" type="checkbox" />Community Service</label>
                                                                    <label class="checkbox" for="supportOutreach2"><input id="supportOutreach2" type="checkbox" />Evangelism Outreach</label>
                                                                    <label class="checkbox" for="supportOutreach3"><input id="supportOutreach3" type="checkbox" />Family Services</label>
                                                                    <label class="checkbox" for="supportOutreach4"><input id="supportOutreach4" type="checkbox" />Food Pantry</label>
                                                                    <label class="checkbox" for="supportOutreach5"><input id="supportOutreach5" type="checkbox" />Homeless Ministry</label>
                                                                    <label class="checkbox" for="supportOutreach6"><input id="supportOutreach6" type="checkbox" />Mission Trips</label>
                                                                    <label class="checkbox" for="supportOutreach7"><input id="supportOutreach7" type="checkbox" />Social Justice/Activism</label>
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
                                            <label class="checkbox" for="lang1"><input id="lang1" type="checkbox" data-linked-checkbox="langList22" />Spanish</label>
                                            <label class="checkbox" for="lang2"><input id="lang2" type="checkbox" data-linked-checkbox="langList2" />Chinese (Cantonese)</label>
                                            <label class="checkbox" for="lang3"><input id="lang3" type="checkbox" data-linked-checkbox="langList3" />Chinese (Mandarin)</label>
                                            <label class="checkbox" for="lang4"><input id="lang4" type="checkbox" data-linked-checkbox="langList5" />French</label>
                                            <label class="checkbox" for="lang5"><input id="lang5" type="checkbox" data-linked-checkbox="langList0" />Sign Language (ASL)</label>
                                            <h5 class="ellipsis">&hellip;</h5>
                                        </div>
                                        <div class="col-sm-6 col-xs-12">
                                            <h5>Special Needs</h5>
                                            <label class="checkbox" for="moreOptions4"><input id="moreOptions4" type="checkbox" />Wheelchair Access</label>
                                            <label class="checkbox" for="moreOptions5"><input id="moreOptions5" type="checkbox" />Deaf Translation</label>
                                            <br />
                                            <h5>Transportation</h5>
                                            <label class="checkbox" for="moreOptions1"><input id="moreOptions1" type="checkbox" />Parking Lot</label>
                                            <label class="checkbox" for="moreOptions2"><input id="moreOptions3" type="checkbox" />Carpool Available</label>
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
                                                                <label class="checkbox" for="langList0"><input id="langList0" type="checkbox" data-linked-checkbox="lang5" />American Sign Language</label>
                                                                <label class="checkbox" for="langList1"><input id="langList1" type="checkbox" />Armenian</label>
                                                                <label class="checkbox" for="langList2"><input id="langList2" type="checkbox" data-linked-checkbox="lang2" />Chinese (Cantonese)</label>
                                                                <label class="checkbox" for="langList3"><input id="langList3" type="checkbox" data-linked-checkbox="lang3" />Chinese (Mandarin)</label>
                                                                <label class="checkbox" for="langList4"><input id="langList4" type="checkbox" />English</label>
                                                                <label class="checkbox" for="langList5"><input id="langList5" type="checkbox" data-linked-checkbox="lang4" />French</label>
                                                                <label class="checkbox" for="langList6"><input id="langList6" type="checkbox" />French Creole</label>
                                                                <label class="checkbox" for="langList7"><input id="langList7" type="checkbox" />German</label>
                                                                <label class="checkbox" for="langList8"><input id="langList8" type="checkbox" />Greek</label>
                                                                <label class="checkbox" for="langList9"><input id="langList9" type="checkbox" />Gujarati</label>
                                                                <label class="checkbox" for="langList10"><input id="langList10" type="checkbox" />Hindi</label>
                                                                <label class="checkbox" for="langList11"><input id="langList11" type="checkbox" />Hmong</label>
                                                                <label class="checkbox" for="langList12"><input id="langList12" type="checkbox" />Italian</label>
                                                                <label class="checkbox" for="langList13"><input id="langList13" type="checkbox" />Japanese</label>
                                                            </div>
                                                            <div class="col-sm-6 checkbox-group">
                                                                <label class="checkbox" for="langList14"><input id="langList14" type="checkbox" />Korean</label>
                                                                <label class="checkbox" for="langList15"><input id="langList15" type="checkbox" />Laotian</label>
                                                                <label class="checkbox" for="langList16"><input id="langList16" type="checkbox" />Mon-Khmer, Cambodian</label>
                                                                <label class="checkbox" for="langList17"><input id="langList17" type="checkbox" />Persian</label>
                                                                <label class="checkbox" for="langList18"><input id="langList18" type="checkbox" />Polish</label>
                                                                <label class="checkbox" for="langList19"><input id="langList19" type="checkbox" />Portuguese</label>
                                                                <label class="checkbox" for="langList20"><input id="langList20" type="checkbox" />Russian</label>
                                                                <label class="checkbox" for="langList21"><input id="langList21" type="checkbox" />Serbo-Croatian</label>
                                                                <label class="checkbox" for="langList22"><input id="langList22" type="checkbox" data-linked-checkbox="lang1" />Spanish</label>
                                                                <label class="checkbox" for="langList23"><input id="langList23" type="checkbox" />Thai</label>
                                                                <label class="checkbox" for="langList24"><input id="langList24" type="checkbox" />Urdu</label>
                                                                <label class="checkbox" for="langList25"><input id="langList25" type="checkbox" />Vietnamese</label>
                                                                <label class="checkbox" for="langList26"><input id="langList26" type="checkbox" />Yiddish</label>
                                                            </div>
                                                        </div><!-- /.tab-pane -->                    
                                                        <div class="tab-pane fade" id="moreTab">
                                                            <div class="row">
                                                                <div class="col-sm-6 col-xs-12">
                                                                    <h5>Special Needs</h5>
                                                                    <label class="checkbox" for="moreOptions1"><input id="moreOptions1" type="checkbox" />Wheelchair Access</label>
                                                                    <label class="checkbox" for="moreOptions2"><input id="moreOptions2" type="checkbox" />Deaf Translator</label>
                                                                    <label class="checkbox" for="moreOptions3"><input id="moreOptions3" type="checkbox" />Hearing Loop</label>
                                                                </div>
                                                                <div class="col-sm-6 col-xs-12">
                                                                    <h5>Transportation</h5>
                                                                    <label class="checkbox" for="moreOptions4"><input id="moreOptions4" type="checkbox" />Parking Lot</label>
                                                                    <label class="checkbox" for="moreOptions5"><input id="moreOptions5" type="checkbox" />Carpool Available</label>
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

                    
                    <c:forEach items="${results.items}" var="result" varStatus="p_tracker">
                        <spring:url value="/static/church-images/${result.id}/${result.displayImage.path}" var="imagePath"/>
                        
                        <div class="search-result-entry show-result <c:if test='${p_tracker.index == 0}'>first-entry</c:if>" data-result-id="${p_tracker.index + 1}" data-church-name="${result.organizationName}" data-latitude="37.785084" data-longitude="-122.434146">
                            <div class="col-sm-3">
                                <div class="search-result-image-container">
                                    <img class="profile-image img-responsive" src="${imagePath}" alt="${result.displayImage.alt}" title="${result.displayImage.title}" />
                                </div>
                            </div>
                            <div class="col-sm-9 search-result-text">
                                <div class="row">
                                    <div class="col-sm-8">
                                        <span class="church-name">${result.organizationName}</span>
                                        <span class="church-location">${result.city}, ${result.state} ${result.postalCode}</span>
                                        <span class="church-denomination"><spring:message code="${result.denomination}" /></span>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="search-result-distance">
                                            <span class="distance"><fmt:formatNumber maxFractionDigits="2">${result.distanceFromSearchPoint}</fmt:formatNumber></span> miles away
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="favorite-icon"></div>
                        </div>
                        
                    </c:forEach>

                </div><!-- end search-results -->
                <div class="pagination pagination-centered"></div>
                
            </div><!-- /.right-column -->
            
        </div><!-- /.main -->
        <script>
        	testJSON();
        </script>

        <%@ include file="/WEB-INF/jsp/partials/siteFooter.jsp"%> 
    </body>
</html>