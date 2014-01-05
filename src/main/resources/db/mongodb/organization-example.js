var org1 = {
	yearFounded : 2000,
	name : "Overlake Christian Church",
	missionStatement : 'Mission statement goes here',
	statementOfFaith : 'Statement of faith goes here',
	welcomeMessage : 'Welcome message goes here',
	address : {
		street1 : '9900 Willows RD NE',
		street2 : 'ste 123', // if there is nothing here you don't need it
		city : 'Redmond',
		postalCode : '98028',
		state : 'WA',
		country : 'USA',
		longitude : -122.14927, //no quotes
		latitude : 47.68908, //no quotes
		location : [ -122.14927, 47.68908 ] //Longitude first, Latitude second
	},
	atmosphere : {
		congregationSize : "MEGA", //Options are SMALL, MEDIUM, LARGE, MEGA, UNKNOWN
		serviceSchedule : "",
		serviceDetails : [ { //brackets mean that the following is a comma separated list of same things
			musicStyle : 'CONTEMPORARY_3', // See available values below
			serviceStyle : 'HIGH_ENERGY_3', //See available values below
			dressAttire : 'CASUAL_3',	//See available values below
			ageDemographics :[], //See available values below
			instruments : [], //See available values below
			durationInMinutes : 90, //no quotes, must be a whole number
			serviceName: '9:20 Service', //Name of the service, will be displayed under Church Atmosphere on the profile page
			timeAndDay : {
				startTime : 'ISODate("0000-12-30T09:20:00Z")',
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'MID_MORNING' //See available values below
			},
			languages : ['ENGLISH', 'AMERICAN_SIGN_LANGUAGE', 'SPANISH']
		}, {
			musicStyle : 'CONTEMPORARY_3',
			serviceStyle : 'HIGH_ENERGY_3',
			dressAttire : 'CASUAL_3',
			ageDemographics : [],
			instruments : [],
			durationInMinutes : 90,
			serviceName : '11am Service',
			timeAndDay : {
				startTime : 'ISODate("0000-12-30T11:00:00Z")?',
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'LATE_MORNING'
			},
			languages : ['ENGLISH', 'AMERICAN_SIGN_LANGUAGE', 'SPANISH']
		}, {
			musicStyle : 'CONTEMPORARY_3',
			serviceStyle : 'HIGH_ENERGY_3',
			dressAttire : 'CASUAL_3',
			ageDemographics : [],
			instruments : [],
			durationInMinutes : 90,
			serviceName : 'Sunday Evening Service',
			timeAndDay : {
				startTime : 'ISODate("0000-12-30T18:00:00Z")',
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'EVENING'
			},
			languages : ['ENGLISH', 'AMERICAN_SIGN_LANGUAGE', 'SPANISH']
		} ],
		gayAffirming : false,
		homeChurch : false
	},
	socialMedia : {
		websiteUrl : 'http://www.occ.org',
		facebookUrl : 'https://www.facebook.com/OverlakeChristianChurch',
		blogUrl : 'https://occ.wordpress.com',
		googlePlusUrl : 'https://plus.google.com/occ',
		youtubeUrl : 'https://www.youtube.com/occ',
		podcastUrl : '',
		twitterUrl : 'https://www.twiter.com/occ',
		otherUrl : '',
		instagramUrl : ''
	},
	denomination : 'NONDENOMINATIONAL', //See available values below
	subDenomination : 'NONE', //See available values below
	multimedia : [ {
		name : 'Outside view of Chruch 1',
		path : '1.jpg',//name of the file
		title: '',
		altText : 'Church exterrior and sign viewed from the north', //If the browser can't show the image this will be shown, this field isn't that important but is used for blind assistance browsers
		primary : true, //Is this the main image to be displayed on the profile, this is important
		video : false //Is this a video? These can/should not both be true!!!
	},
	//Repeat for each image or video
	{
		name : 'Church View',
		path : '2.jpg',
		title : '',
		altText : 'Church exterrior from the South',
		primary : false,
		video : false
	}
	,
	{
		name : 'Welcome Message from Dave and Debbie Smith',
		path : '1.flv',
		primary : false,
		video : true
	} ],
	leadershipTeam : [ {
		name : 'Dave and Debbie Smith',
		title : 'Lead Pastors',
		bio : 'Lead pastor bio information goes here',
		leaderRole : 'PASTOR', //See available values below
		image : {
			name : 'Pastors Dave and Debbie Smith',
			path : '3.jpg', //name of the file
			altText : 'Pastor Dave and Debbie Smith together on white background', //If the browser can't show the image this will be shown, this field isn't that important but is used for blind assistance browsers
			primary : false, //Always false for leaders
			video : false //Always false for leaders
		},
		primaryContact : false, //Is this the person who gets contacted with questions about the church?
		primaryLeader : true, //Is this the person in charge at the church
		phoneNumber : '(510) 261-2052 ext 2323', //Leaders phone number if applicable, must be for primary contact
		emailAddress : '', //Leaders email address, must be here for primary contact
		yearStarted : 1999 //not important, no quotes
	}, 
	//repeat format for each leader, use a comma to separate and no comma after the last on in the list
	{
		name : 'Gary Gonzalez',
		title : 'Community Pastor',
		bio : 'Community pastor bio information goes here',
		leaderRole : 'PASTOR',
		image : {
			name : 'Pastor Dave Someone',
			path : '3.jpg',
			altText : 'Pastor Mike Howerton',
			primary : false,
			video : false
		},
		primaryContact : true,
		primaryLeader : false,
		phoneNumber : '(510) 261-2052 ext 2323',
		emailAddress : '',
		yearStarted : ''
	} ],
	programsOffered : [ 'INFANT_CARE', 'TODDLER_CARE', 'SUNDAY_SCHOOL',
                    	'BIBLE_STUDY', 'ADULT_EDUCATION', 'SPIRITUAL_CLASSES',
                    	'PRE_SCHOOL', 'PRIMARY_SCHOOL', 'SECONDARY_SCHOOL',
                    	'GRADUATE_STUDIES', 'CHILDRENS_GROUPS', 'MIDDLE_SCHOOL_GROUP',
                		'HIGH_SCHOOL_GROUP', 'YOUNG_ADULT_GROUP', 'ADULT_GROUP',
                		'MENS_GROUP', 'WOMENS_GROUP' ],						//See available values below
	accessibilitySupport : [ 'WHEELCHAIR_ACCESS', 'DEAF_TRANSLATOR', 
	                         'PARKING_LOT' ], 								//See available values below	
};



/* 
 * Below are the list of values for Denomination and Programs, if the value you aren't looking for isn't in there
 * please create a new value by using all capital letters and communicating the new value along with completed work 
 * so the necessary changes can be made in the code to reflect the new values.
 * 
 * Full List of Denominations:
 * 
 * AMERICAN_BAPTIST
 *  	BAPTIST
 *  	SOUTHERN_BAPTIST
 *  	PRESBYTERIAN
 *  	PRESBYTERIAN_PCUSA
 *  	PRESBYTERIAN_PCA
 *  	APOSTOLIC
 *  	ASSEMBLIES_OF_GOD
 *  	CATHOLIC
 *  	CHRISTIAN_SCIENCE
 *  	CHURCH_OF_GOD
 *  	CHURCH_OF_THE_BRETHREN
 *  	DISCIPLES_OF_CHRIST
 *  	EPISCOPAL_ANGLICAN
 *  	EVANGELICAL
 *  	FOURSQUARE
 *  	JEHOVAH_WITNESS
 *  	LUTHERAN
 *  	MENNONITE
 *  	MESSIANIC
 *  	METHODIST
 *  	LATTER_DAY_SAINTS_MORMON
 *  	NAZARENE
 *  	NON_DENOMINATIONAL
 *  	OPEN_BIBLE
 *  	ORTHODOX
 *  	PENTECOSTAL
 *  	QUAKER_FRIENDS
 *  	REFORMED
 *  	SEVENTH_DAY_ADVENTIST
 *  	UNITARIAN_UNIVERSALIST
 *  	UNITED_CHURCH_OF_CHRIST
 *  	OTHER
 * 
 * 
 * Full List of ProgramsOffered values:
 *	 	INFANT_CARE    
 *	 	TODDLER_CARE    
 *	 	SUNDAY_SCHOOL   
 * 		BIBLE_STUDY    
 * 		ADULT_EDUCATION   
 *  	SPIRITUAL_CLASSES    
 *	  	PRE_SCHOOL   
 *   	PRIMARY_SCHOOL    
 *   	SECONDARY_SCHOOL   
 *   	GRADUATE_STUDIES    
 *    	CHILDRENS_GROUP   
 *     	MIDDLE_SCHOOL_GROUP   
 *      HIGH_SCHOOL_GROUP    
 *      COLLEGE_AGE_GROUP 
 *      POST_COLLEGE_GROUP    
 *      ADULT_GROUP    
 *      SENIOR_GROUP    
 *      MENS_GROUP    
 *      WOMENS_GROUP    
 *      CHOIR    
 *      DANCE    
 *      MUSIC_MINISTRY   
 *      DRAMA    
 *      CREATIVE_ARTS    
 *      SPORTS   
 *      SOCIAL_EVENTS    
 *      SMALL_GROUPS    
 *      SINGLES_GROUPS    
 *      PRAYER_GROUPS    
 *      HEALING_MINISTRY    
 *      PROPHETIC_MINISTRY   
 *      WORSHIP_MINISTRY   
 *      PRE_MARITIAL_COUNSELING   
 *      GENERAL_COUNSELING    
 *      DIVORCE_GRIEF_COUNSELING
 *      ADDICTION_RECOVERY_COUNSELING 
 *      COMMUNITY_OUTREACH    
 *      FOOD_PANTRY_OUTREACH 
 *      FAMILY_OUTREACH   
 *      HOMELESS_OUTREACH 
 *      SOCIAL_JUSTICE_OUTREACH    
 *      EVANGELISM_OUTREACH    
 *      MISSION_OUTREACH
 *        
 * 
 * Full List of ServiceStyle values:
 * 		CONSERVATIVE_1
 *     	CONSERVATIVE_2    
 *     	CONSERVATIVE_3    
 *     	CONSERVATIVE_4   
 *	    NEUTRAL_5  
 *	    NEUTRAL_6  
 *		HIGH_ENERGY_7    
 *  	HIGH_ENERGY_8    
 *  	HIGH_ENERGY_9   
 *  	HIGH_ENERGY_10	
 *
 *     
 * Full List of MusicStyle values:
 * 		TRADITIONAL_1    
 * 		TRADITIONAL_2   
 * 		TRADITIONAL_3 
 *      TRADITIONAL_4 
 *    	NEUTRAL_5  
 *    	NEUTRAL_6  
 *     	CONTEMPORARY_7    
 *     	CONTEMPORARY_8    
 *     	CONTEMPORARY_9
 *     	CONTEMPORARY_10
 *     
 *     
 * Full List of DressAttire values:
 * 		FORMAL_1    
 * 		FORMAL_2 
 *    	FORMAL_3  
 *      FORMAL_4    
 *      NEUTRAL_5  
 *      NEUTRAL_6   
 *      CASUAL_7  
 *      CASUAL_8    
 * 		CASUAL_9
 *     	CASUAL_10
 *     
 *
 * Full List of AgeDemographics values:
 *  	YOUTH_1
 *      YOUTH_2
 *      YOUTH_3
 *      YOUTH_4
 *      NEUTRAL_5
 *      NEUTRAL_6
 *      MATURE_7
 *      MATURE_8
 *      MATURE_9
 *      MATURE_10   
 *      
 * Full List of ServiceTimes
 * 		EARLY_MORNING  
 *   	MID_MORNING   
 *    	LATE_MORNING    
 *    	AFTERNOON   
 *     	EVENING
 *     
 *      
 * Full List of ServiceDays
 * 		MONDAY   
 *  	TUESDAY  
 *    	WEDNESDAY    
 *    	THURSDAY   
 *     	FRIDAY   
 *      SATURDAY   
 *      SUNDAY
 *      
 *      
 * Full List of Accessibility Support      
 * 		WHEELCHAIR_ACCESS   
 *  	DEAF_TRANSLATOR   
 *   	PARKING_LOT   
 *   	STREET_PARKING   
 *    	PARKING_GARAGE   
 *     	CARPOOL
 *     
 */	
	
