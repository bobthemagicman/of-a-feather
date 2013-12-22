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
		serviceDetails : [ { //brackets mean that the following is a comma separated list of same things
			musicStyle : 'CONTEMPORARY_3', // See available values below
			serviceStyle : 'HIGH_ENERGY_3', //See available values below
			dressAttire : 'CASUAL_3',	//See available values below
			ageDemographics :[], //See available values below
			instruments : [], //See available values below
			durationInMinutes : 90, //no quotes, must be a whole number
			startTime : '9:20am', //Service start time, will be used on the profile page in multiple places
			serviceName: '9:20 Service' //Name of the service, will be displayed under Church Atmosphere on the profile page
		}, {
			musicStyle : 'CONTEMPORARY_3',
			serviceStyle : 'HIGH_ENERGY_3',
			dressAttire : 'CASUAL_3',
			ageDemographics : [],
			instruments : [],
			durationInMinutes : 90,
			startTime : '11:00am',
			serviceName : '11am Service'			
		}, {
			musicStyle : 'CONTEMPORARY_3',
			serviceStyle : 'HIGH_ENERGY_3',
			dressAttire : 'CASUAL_3',
			ageDemographics : [],
			instruments : [],
			durationInMinutes : 90,
			startTime : '6:00pm',
			serviceName : 'Sunday Evening Service'
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

	serviceTimes : [ 'EARLY_MORNING', 'MID_MORNING', 'EVENING' ],			//See available values below
	serviceDays : [ 'SUNDAY' ],												//See available values below
	languages : ['ENGLISH', 'AMERICAN_SIGN_LANGUAGE', 'SPANISH'],
	programsOffered : [ 'INFANT_CARE', 'TODDLER_CARE', 'SUNDAY_SCHOOL',
                    	'BIBLE_STUDY', 'ADULT_EDUCATION', 'SPIRITUAL_CLASSES',
                    	'PRE_SCHOOL', 'PRIMARY_SCHOOL', 'SECONDARY_SCHOOL',
                    	'GRADUATE_STUDIES', 'CHILDRENS_GROUPS', 'MIDDLE_SCHOOL_GROUP',
                		'HIGH_SCHOOL_GROUP', 'YOUNG_ADULT_GROUP', 'ADULT_GROUP',
                		'MENS_GROUP', 'WOMENS_GROUP' ],						//See available values below
	accessabilitysupport : [ 'WHEELCHAIR_ACCESS', 'DEAF_TRANSLATOR', 
	                         'PARKING_LOT' ], 								//See available values below	
};



/* 
 * Below are the list of values for Denomination and Programs, if the value you aren't looking for isn't in there
 * please create a new value by using all capital letters and communicating the new value along with completed work 
 * so the necessary changes can be made in the code to reflect the new values.
 * 
 * Full List of Denominations:
 * 		
 * 		NONDENOMINATIONAL
 * 	    CATHOLICISM
 *     	EASTERN_ORTHODOX
 *     	ORIENTAL_ORTHODOX
 *     	PROTESTANTISM
 *     	LUTHERANISM
 *     	ANGLICANISM
 *     	CALVINISM
 *     	PRESBYTERIANISM
 *     	CONGREGATIONALIST
 *     	ANABAPTISTS
 *     	BRETHREN
 *     	METHODISTS
 *     	PRIESTS_AND_HOLINESS
 *     	BAPTISTS
 *     	APISTOLIC
 *     	PENTECOSTALISM
 *     	CHARISMATICS    
 *     	AFRICAN_INITIATED  
 *     	MESSIANIC_JUDAISM    
 *      UNITED_AND_UNITING   
 *      QUAKER    
 *      STONE_CAMPBELL_RESTORATION    
 *      SOUTHCOTTITES   
 *      LATTER_DAY_SAINTS    
 *      ONENESS_PENTACOSTALISM    
 *      UNITARIAN   
 *      BIBLE_STUDENT_GROUPS    
 *      CHRISTIAN_SCIENCE    
 *      NEW_THOUGHT    
 *      ESOTERICISM    
 *      ASSEMBLIES_OF_GOD   
 *      CHURCH_OF_GOD    
 *      DISCIPLES_OF_CHRIST    
 *      FOURSQUARE   
 *      JEHOVAS_WITNESS   
 *      MENNONITE    
 *      NAZARENE    
 *      OPEN_BIBLE  
 *      REFORMED_CHURCHES    
 *      SEVENTH_DAY_ADVENTIST    
 *      UNITED_CHURCH_OF_CHRIST   
 *      NONE
 * 
 * 
 * Full List of ProgramsOffered values:
 *	 	INFANT_CARE    
 *		TODDLER_CARE    
 *		SUNDAY_SCHOOL   
 * 		BIBLE_STUDY    
 * 		ADULT_EDUCATION   
 *  	SPIRITUAL_CLASSES    
 *  	PRE_SCHOOL   
 *   	PRIMARY_SCHOOL    
 *   	SECONDARY_SCHOOL   
 *    	GRADUATE_STUDIES    
 *    	CHILDRENS_GROUP   
 *     	MIDDLE_SCHOOL_GROUP   
 *      HIGH_SCHOOL_GROUP    
 *      YOUNG_ADULT_GROUP    
 *      ADULT_GROUP    
 *      SENIOR_GROUP    
 *      MENS_GROUP    
 *      WOMENS_GROUP    
 *      CHIOR    
 *      DANCE    
 *      MUSIC_MINISTRY   
 *      DRAMA    
 *      CREATIVE_ARTS    
 *      SPROTS   
 *      SOCAIL_EVENTS    
 *      SMALL_GROUPS    
 *      SINGLES_GROUPS    
 *      PRAYER_GROUPS    
 *      HEALING_MINISTRY    
 *      PROPHETIC_MINISTRY   
 *      WORSHIP_MINISTRY   
 *      PRE_MARITIAL_COUNSELING   
 *      COUPLES_COUNSELING   
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
 * 		CONSERVATIVE_4
 *     	CONSERVATIVE_3    
 *     	CONSERVATIVE_2    
 *     	CONSERVATIVE_1    
 *     	NEUTRAL    
 *     	HIGH_ENERGY_1    
 *     	HIGH_ENERGY_2    
 *     	HIGH_ENERGY_3    
 *     	HIGH_ENERGY_4
 *
 *     
 * Full List of MusicStyle values:
 * 		TRADITIONAL_4    
 * 		TRADITIONAL_3   
 * 		TRADITIONAL_2  
 *    	NEUTRAL   
 *     	CONTEMPORARY_2    
 *     	CONTEMPORARY_3    
 *     	CONTEMPORARY_4
 *     
 *     
 * Full List of DressAttire values:
 * 		FORMAL_4    
 * 		FORMAL_3 
 *    	FORMAL_2  
 *      FORMAL_1    
 *      NEUTRAL    
 *      CASUAL_1   
 *      CASUAL_2    
 * 		CASUAL_3
 *     	CASUAL_4
 *     
 *
 * Full List of AgeDemographics values:
 *  	YOUTH_3
 *      YOUTH_2
 *      YOUTH_1
 *      NEUTRAL
 *      MATURE_1
 *      MATURE_2
 *      MATURE_3  
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
 * Full List of AccessabilitySupport     
 * 		WHEELCHAIR_ACCESS   
 *  	DEAF_TRANSLATOR   
 *   	PARKING_LOT   
 *   	STREET_PARKING   
 *    	PARKING_GARAGE   
 *     	CARPOOL
 *     
 */

