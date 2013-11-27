var org1 = {
	address : {
		street1 : '9900 Willows RD NE',
		city : 'Redmond',
		postalCode : '98028',
		state : 'WA',
		country : 'USA',
		longitude : '-122.14927',
		latitude : '47.68908',
		location : [ -122.14927, 47.68908 ] //long, lat
	},
	primaryLeader : {
		name : 'Lead Pastor\'s Name Goes Here',
		title : 'Lead Pastor',
		bio : 'Lead pastor bio information goes here',
		image : {
			name : 'imageName',
			path : '/path/to/file/imageName.jpg', 
			altText : 'Short text blurb that describes the image'
		},
		primaryContact : false, //is this the person to contact with questions about this organization?
		primaryLeader : true //is this the person who is the primary person in charge at this organization?
	},
	images : [ {
		name : 'Image of organization 1', //Each picture should have a short name like: Church of Christ Exterrior, Church of Christ Interrior, etc...
		path : '/path/to/image/imageName.jpg', 
		altText : 'Short text blurb that describes the image'
	}, {
		name : 'Image of organization 1', //Each picture should have a short name like: Church of Christ Exterrior, Church of Christ Interrior, etc...
		path : '/path/to/image/imageName.jpg', 
		altText : 'Short text blurb that describes the image'
	}, {
		name : 'Image of organization 1', //Each picture should have a short name like: Church of Christ Exterrior, Church of Christ Interrior, etc...
		path : '/path/to/image/imageName.jpg', 
		altText : 'Short text blurb that describes the image'
	} ],
	musicStyle : 'CONTEMPORARY_3', // Available values are: TRADITIONAL_5, TRADITIONAL_4, TRADITIONAL_3, TRADITIONAL_2, TRADITIONAL_1, CONTEMPORARY_1, CONTEMPORARY_2, CONTEMPORARY_3, CONTEMPORARY_4, CONTEMPORARY_5
	dressAttire : 'CASUAL_3', //Available values are: FORMAL_5, FORMAL_4, FORMAL_3, FORMAL_2, FORMAL_1, CASUAL_1, CASUAL_2, CASUAL_3, CASUAL_4, CASUAL_5
	serviceStyle : 'HIGH_ENERGY_3', //Available values are: CONSERVATIVE_5, CONSERVATIVE_4, CONSERVATIVE_3, CONSERVATIVE_2, CONSERVATIVE_1, HIGH_ENERGY_1, HIGH_ENERGY_2, HIGH_ENERGY_3, HIGH_ENERGY_4, HIGH_ENERGY_5
	yearFounded : '2000',
	serviceTimes : [ 'EARLY_MORNING', 'MID_MORNING'], //Available values are: EARLY_MORNING, MID_MORNING, LATE_MORNING, AFTERNOON', EVENING
	serviceDays : [ 'SUNDAY' ], //Available values are: SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	denomination : 'NONDENOMINATIONAL', //Available values are show below 
	subDenomination : 'NONE', //Avaible values are the same as denomination field
	name : 'Organization Name Goes Here',
	programs : [ 'INFANT_CARE', 'TODDLER_CARE', 'SUNDAY_SCHOOL', 'BIBLE_STUDY', //Available values are shown below
			'ADULT_EDUCATION', 'SPIRITUAL_CLASSES', 'PRE_SCHOOL',
			'PRIMARY_SCHOOL', 'SECONDARY_SCHOOL', 'GRADUATE_STUDIES',
			'CHILDRENS_GROUPS', 'MIDDLE_SCHOOL_GROUP', 'HIGH_SCHOOL_GROUP',
			'YOUNG_ADULT_GROUP', 'ADULT_GROUP', 'MENS_GROUP', 'WOMENS_GROUP' ],
	accessabilityNeeds : [ 'WHEEL_CHAIR_ACCESS, DEAF_TRANSLATOR, PARKING_LOG' ],
	missionStatement: '',
	statementOfFaith: '',
	websiteUrl : 'http://www.occ.org', //Url of church website if available, if not leave as empty string ""
	facebookUrl : 'https://www.facebook.com/OverlakeChristianChurch', //Url to church facebook page if available, if not leave as empty string ""
	congregationSize : 'LARGE', //Size of the church, values are: SMALL, MEDIUM, LARGE, MEGA, UNKNOWN
	parkingLot : true, //Is there a parking lot on site, values: true, false
	gayAffirming : false //Is the organization supportive of homosexuality, values: true, false 
}



/* 
 * Below are the list of values for Denomination and Programs, if the value you aren't looking for isn't in there
 * please create a new value by using all capital letters and communicating the new value along with completed work 
 * so the necessary changes can be made in the code to reflect the new values.
 * 
 * Full List of Denominations:
 * 		NONDENOMINATIONAL
 * 		CATHOLICISM
 * 		EASTERN_ORTHODOX
 * 		ORIENTAL_ORTHODOX
 * 		PROTESTANTISM
 * 		LUTHERANISM
 * 		ANGLICANISM
 * 		CALVINISM
 * 		PRESBYTERIANISM
 * 		CONGREGATIONALIST
 * 		ANABAPTISTS
 * 		BRETHREN
 * 		METHODISTS
 * 		PRIESTS_AND_HOLINESS
 * 		BAPTISTS
 * 		APISTOLIC
 * 		PENTECOSTALISM
 * 		CHARISMATICS
 * 		AFRICAN_INITIATED
 * 		MESSIANIC_JUDAISM
 * 		UNITED_AND_UNITING
 * 		QUAKER
 * 		STONE_CAMPBELL_RESTORATION
 * 		SOUTHCOTTITES
 * 		MILLERITES
 * 		LATTER_DAY_SAINTS
 * 		ONENESS_PENTACOSTALISM
 * 		UNITARIAN
 * 		BIBLE_STUDENT_GROUPS
 * 		CHRISTIAN_SCIENCE
 * 		NEW_THOUGHT
 * 		ESOTERICISM
 * 		NONE
 * 
 * 
 * Full List of Programs:
 *	 	INFANT_CARE,
 * 		TODDLER_CARE,
 * 		SUNDAY_SCHOOL,
 * 		BIBLE_STUDY,
 * 		ADULT_EDUCATION,
 * 		SPIRITUAL_CLASSES,
 * 		PRE_SCHOOL,
 * 		PRIMARY_SCHOOL,
 * 		SECONDARY_SCHOOL,
 * 		GRADUATE_STUDIES,
 * 		CHILDRENS_GROUPS,
 * 		MIDDLE_SCHOOL_GROUP,
 * 		HIGH_SCHOOL_GROUP,
 * 		YOUNG_ADULT_GROUP,
 * 		ADULT_GROUP,
 * 		SENIOR_GROUP,
 * 		MENS_GROUP,
 * 		WOMENS_GROUP,
 * 		CHIOR,
 * 		DANCE,
 * 		MUSIC_MINISTRY,
 * 		DRAMA,
 * 		CREATIVE_ARTS,
 * 		MENTORSHIPT,
 * 		SPROTS,
 * 		SOCAIL_EVENTS,
 * 		SMALL_GROUPS,
 * 		SINGLES_GROUPS,
 * 		PRAYER_GROUPS,
 * 		HEALING_MINISTRY,
 * 		PROPHETIC_MINISTRY,
 * 		WORSHIP_MINISTRY,
 * 		MEDITATION,
 * 		PRE_MARITIAL_COUNSELING,
 * 		COUPLES_COUNSELING,
 * 		GENERAL_COUNSELING,
 * 		DIVORCE_GRIEF_COUNSELING,
 * 		ADDICTION_RECOVERY_COUNSELING,
 * 		COMMUNITY_OUTREACH,
 * 		FOOD_PANTRY_OUTREACH,
 * 		FAMILY_OUTREACH,
 * 		HOMELESS_OUTREACH,
 * 		SOCIAL_JUSTICE_OUTREACH,
 * 		EVANGELISM_OUTREACH,
 * 		MISSION_OUTREACH;
 * 
 */

