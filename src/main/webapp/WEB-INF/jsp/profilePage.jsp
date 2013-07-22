<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/init.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${organization.name}</title>
</head>
<body>
<h2>Address Info:</h2>
Street 1: ${organization.address.street1}<br />
Street 2: ${organization.address.street2}<br />
Postal Code: ${organization.address.postalCode}<br />
State: ${organization.address.state}<br />
City: ${organization.address.city}<br />
Country: ${organization.address.country}<br />
Longitude: ${organization.address.longitude}<br />
Latitude: ${organization.address.latitude}<br />

<br />
<br />
<h2>Music Style</h2>
Music Style: ${organization.musicStyle}<br />

<h2>Language Info:</h2>
<h2>Images:</h2>
<h2>Leader Info:</h2>
<h2>Organization Info:</h2>
Service Times: ${organization.serviceTimes}<br />
Service Days: ${organization.serviceDays}<br />
Religion: ${organization.communityCategory}<br />
Denomination: ${organization.denomination}<br />
SubDenomination: ${organization.subDenomination}<br />
Name: ${organization.name}<br />
Programs Offered: ${organization.programsOffered}<br />
Age Demographic: ${organization.ageDemographics}<br />
Ethnic Demographics: ${organization.ethnicDemographics}<br />
Lead Pastor Bio: ${organization.srLdrBiography}<br />
Blurb: ${organization.description}<br />
Website: ${organization.websiteUrl}<br />
Facebook: ${organization.facebookUrl}<br />
Year Founded: ${organization.yearFounded}<br />
Avg. Congregation Size: ${organization.averageServiceCongregationSize}<br />
Env. Friendly: ${organization.envFriendly}<br />
Has Parkinglot: ${organization.parkingLot}<br />
Is Gay Affirming${organization.gayAffirming}<br />
</body>
</html>