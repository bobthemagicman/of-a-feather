//Seattle Organizations
var org1 = {
	yearFounded : 2000,
	name : "Overlake Christian Church",
	missionStatement : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vulputate at justo quis molestie. Cras suscipit sagittis rutrum. In id libero quis urna consequat bibendum. Duis sed eros et ligula vestibulum congue. Praesent volutpat nibh eget ipsum tempor varius.',
	statementOfFaith : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vulputate at justo quis molestie. Cras suscipit sagittis rutrum. In id libero quis urna consequat bibendum. Duis sed eros et ligula vestibulum congue. Praesent volutpat nibh eget ipsum tempor varius.',
	welcomeMessage : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vulputate at justo quis molestie. Cras suscipit sagittis rutrum. In id libero quis urna consequat bibendum. Duis sed eros et ligula vestibulum congue. Praesent volutpat nibh eget ipsum tempor varius.',
	address : {
		street1 : '9900 Willows RD NE',
		city : 'Redmond',
		postalCode : '98028',
		state : 'WA',
		country : 'USA',
		longitude : -122.14927,
		latitude : 47.68908,
		location : [ -122.14927, 47.68908 ]
	},
	atmosphere : {
		congregationSize : "MEGA",
		serviceDetails : [ {
			musicStyle : 'CONTEMPORARY_3',
			serviceStyle : 'HIGH_ENERGY_3',
			dressAttire : 'CASUAL_3',
			ageDemographics : '',
			instruments : [],
			durationInMinutes : 90,
			startTime : '9:20am'
		}, {
			musicStyle : 'CONTEMPORARY_3',
			serviceStyle : 'HIGH_ENERGY_3',
			dressAttire : 'CASUAL_3',
			ageDemographics : '',
			instruments : [],
			durationInMinutes : 90,
			startTime : '11:00am'
		}, {
			musicStyle : 'CONTEMPORARY_3',
			serviceStyle : 'HIGH_ENERGY_3',
			dressAttire : 'CASUAL_3',
			ageDemographics : '',
			instruments : [],
			durationInMinutes : 90,
			startTime : '6:00pm'
		} ],
		gayAffirming : false,
		homeChurch : false
	},
	socialMedia : {
		websiteUrl : 'http://www.occ.org',
		facebookUrl : 'https://www.facebook.com/OverlakeChristianChurch',
		blogUrl : '',
		googlePlusUrl : '',
		youtubeUrl : '',
		podcastUrl : '',
		twitterUrl : '',
		otherUrl : '',
		instagramUrl : ''
	},
	denomination : 'NONDENOMINATIONAL',
	subDenomination : 'NONE',
	multimedia : [ {
		name : 'Pastor Mike Howerton',
		path : '/image/1234.jpg',
		altText : 'Pastor Mike Howerton',
		primary : true,
		video : false
	}, {
		name : 'Pastor Mike Howerton',
		path : '/image/1234.jpg',
		altText : 'Pastor Mike Howerton',
		primary : false,
		video : false
	}, {
		name : 'Pastor Mike Howerton',
		path : '/image/1234.jpg',
		altText : 'Pastor Mike Howerton',
		primary : false,
		video : false
	} ],
	leadershipTeam : [ {
		name : 'Mike Howerton',
		title : 'Lead Pastor',
		bio : 'Lead pastor bio information goes here',
		leaderRole : 'PASTOR',
		image : {
			name : 'Pastor Mike Howerton',
			path : '/image/1234.jpg',
			altText : 'Pastor Mike Howerton',
			primary : false,
			video : false
		},
		primaryContact : false,
		primaryLeader : true,
		phoneNumber : '(510) 261-2052 ext 2323',
		emailAddress : '',
		yearStarted : ''
	}, {
		name : 'Gary Gonzalez',
		title : 'Community Pastor',
		bio : 'Community pastor bio information goes here',
		leaderRole : 'PASTOR',
		image : {
			name : 'Pastor Mike Howerton',
			path : '/image/1234.jpg',
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

	serviceTimes : [ 'EARLY_MORNING', 'MID_MORNING', 'EVENING' ],
	serviceDays : [ 'SUNDAY' ],
	languages : ['ENGLISH', 'AMERICAN_SIGN_LANGUAGE', 'SPANISH'],
	programsOffered : [ 'INFANT_CARE', 'TODDLER_CARE', 'SUNDAY_SCHOOL',
			'BIBLE_STUDY', 'ADULT_EDUCATION', 'SPIRITUAL_CLASSES',
			'PRE_SCHOOL', 'PRIMARY_SCHOOL', 'SECONDARY_SCHOOL',
			'GRADUATE_STUDIES', 'CHILDRENS_GROUPS', 'MIDDLE_SCHOOL_GROUP',
			'HIGH_SCHOOL_GROUP', 'YOUNG_ADULT_GROUP', 'ADULT_GROUP',
			'MENS_GROUP', 'WOMENS_GROUP' ],
	accessabilitysupport : [ 'WHEEL_CHAIR_ACCESS', 'DEAF_TRANSLATOR', 'PARKING_LOG' ],
	gayAffirming : false
};

db.organizations.insert(org1);
db.organizations.ensureIndex({
	"address.location" : "2d"
});

//db.addUser({
//	user : "flockSpring",
//	pwd : "fl0ckSpr!ng",
//	roles : [ "readWrite" ]
//});