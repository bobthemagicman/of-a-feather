<%@ include file="/WEB-INF/jsp/partials/commonHeader.jsp"%>

<spring:url value="/static/images/site/area_map.jpg" var="areaMap"/>

<div class="container contact-page">
    <div class="row">
        <div class="col-sm-12">
            <h1>Contact Us</h1>
            <hr />
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6">

            <dl>
                <dt>Phone:</dt>
                <dd>415-504-2914</dd>
                <dt>Email:</dt>
                <dd>hello@ofafeather.org</dd>
                <dt>Location:</dt>
                <dd>We are headquartered in the San Francisco Bay Area.</dd> 
            </dl>
        </div>
        <div class="col-sm-6">
            <img class="area-map" src="${areaMap}" />
        </div>
    </div>

    <div class="filler">&nbsp;</div>

</div>

<%@ include file="/WEB-INF/jsp/partials/commonFooter.jsp"%>