//Seattle Organizations

db.organizations
		.insert({
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
					musicStyle : 'CONTEMPORARY_8',
					serviceStyle : 'HIGH_ENERGY_7',
					dressAttire : 'CASUAL_7',
					ageDemographics : 'NEUTRAL_4',
					instruments : [],
					durationInMinutes : 90,
					serviceName : '9:20 Service',
					languages : [ 'AMERICAN_SIGN_LANGUAGE', 'SPANISH' ],
					timeAndDay : {
						startTime : ISODate("0000-12-30T09:20:00Z"),
						serviceDay : 'SUNDAY',
						serviceTimeRange : 'MID_MORNING'
					}
				}, {
					musicStyle : 'CONTEMPORARY_8',
					serviceStyle : 'HIGH_ENERGY_7',
					dressAttire : 'CASUAL_7',
					ageDemographics : 'NEUTRAL_4',
					instruments : [],
					durationInMinutes : 90,
					serviceName : '11am Service',
					languages : [ 'AMERICAN_SIGN_LANGUAGE', 'SPANISH' ],
					timeAndDay : {
						startTime : ISODate("0000-12-30T11:00:00Z"),
						serviceDay : 'SUNDAY',
						serviceTimeRange : 'LATE_MORNING'
					}
				}, {
					musicStyle : 'CONTEMPORARY_8',
					serviceStyle : 'HIGH_ENERGY_7',
					dressAttire : 'CASUAL_7',
					ageDemographics : 'NEUTRAL_4',
					instruments : [],
					durationInMinutes : 90,

					serviceName : 'Sunday Evening Service',
					languages : [ 'AMERICAN_SIGN_LANGUAGE', 'SPANISH' ],
					timeAndDay : {
						startTime : ISODate("0000-12-30T18:00:00Z"),
						serviceDay : 'SUNDAY',
						serviceTimeRange : 'EVENING'
					}
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
				name : 'Church View',
				path : '1.jpg',
				altText : 'Church and sign',
				primary : true,
				video : false
			} ],
			leadershipTeam : [ {
				name : 'Dave and Debbie Fakelastname',
				title : 'Lead Pastor',
				bio : 'Lead pastor bio information goes here',
				leaderRole : 'PASTOR',
				image : {
					name : 'Pastor Mike Howerton',
					path : '3.jpg',
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
					'CHILDRENS_GROUPS', 'MIDDLE_SCHOOL_GROUP',
					'HIGH_SCHOOL_GROUP', 'YOUNG_ADULT_GROUP', 'ADULT_GROUP',
					'MENS_GROUP', 'WOMENS_GROUP' ],
			accessibilitysupport : [ 'WHEELCHAIR_ACCESS', 'DEAF_TRANSLATOR',
					'PARKING_LOT' ],
		});

db.organizations
		.insert({
			yearFounded : 2000,
			name : "Church of the Living Dinosaur",
			missionStatement : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vulputate at justo quis molestie. Cras suscipit sagittis rutrum. In id libero quis urna consequat bibendum. Duis sed eros et ligula vestibulum congue. Praesent volutpat nibh eget ipsum tempor varius.',
			statementOfFaith : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vulputate at justo quis molestie. Cras suscipit sagittis rutrum. In id libero quis urna consequat bibendum. Duis sed eros et ligula vestibulum congue. Praesent volutpat nibh eget ipsum tempor varius.',
			welcomeMessage : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vulputate at justo quis molestie. Cras suscipit sagittis rutrum. In id libero quis urna consequat bibendum. Duis sed eros et ligula vestibulum congue. Praesent volutpat nibh eget ipsum tempor varius.',
			address : {
				street1 : '9900 Willows RD NE',
				city : 'Redmond',
				postalCode : '98028',
				state : 'WA',
				country : 'USA',
				longitude : -122.13445,
				latitude : 47.66884,
				location : [ -122.13445, 47.66884 ]
			},
			atmosphere : {
				congregationSize : "MEGA",
				serviceDetails : [ {
					musicStyle : 'CONTEMPORARY_8',
					serviceStyle : 'HIGH_ENERGY_7',
					dressAttire : 'CASUAL_7',
					ageDemographics : 'NEUTRAL_4',
					instruments : [],
					durationInMinutes : 90,

					serviceName : 'Sunday Evening Service',
					timeAndDay : {
						startTime : ISODate("0000-12-30T18:00:00Z"),
						serviceDay : 'SUNDAY',
						serviceTimeRange : 'EVENING'
					}
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
				name : 'Church View',
				path : '1.jpg',
				altText : 'Church and sign',
				primary : true,
				video : false
			} ],
			leadershipTeam : [ {
				name : 'Dave and Debbie Fakelastname',
				title : 'Lead Pastor',
				bio : 'Lead pastor bio information goes here',
				leaderRole : 'PASTOR',
				image : {
					name : 'Pastor Mike Howerton',
					path : '3.jpg',
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
			serviceTimes : [ 'EARLY_MORNING', 'MID_MORNING', 'EVENING' ],
			serviceDays : [ 'SUNDAY' ],
			languages : [ 'AMERICAN_SIGN_LANGUAGE', 'SPANISH' ],
			programsOffered : [ 'INFANT_CARE', 'TODDLER_CARE', 'SUNDAY_SCHOOL',
					'BIBLE_STUDY', 'ADULT_EDUCATION', 'SPIRITUAL_CLASSES',
					'CHILDRENS_GROUPS', 'MIDDLE_SCHOOL_GROUP',
					'HIGH_SCHOOL_GROUP', 'YOUNG_ADULT_GROUP', 'ADULT_GROUP',
					'MENS_GROUP', 'WOMENS_GROUP' ],
			accessibilitysupport : [ 'WHEELCHAIR_ACCESS', 'DEAF_TRANSLATOR',
					'PARKING_LOT' ],
		});

db.organizations.insert({
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
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '9:20 Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T09:20:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'MID_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '11am Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T11:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'LATE_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,

			serviceName : 'Sunday Evening Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T18:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'EVENING'
			}
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
	denomination : 'LUTHERAN',
	subDenomination : 'NONE',
	multimedia : [ {
		name : 'Church View',
		path : '1.jpg',
		altText : 'Church and sign',
		primary : true,
		video : false
	} ],
	leadershipTeam : [ {
		name : 'Dave and Debbie Fakelastname',
		title : 'Lead Pastor',
		bio : 'Lead pastor bio information goes here',
		leaderRole : 'PASTOR',
		image : {
			name : 'Pastor Mike Howerton',
			path : '3.jpg',
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
	serviceTimes : [ 'EARLY_MORNING', 'MID_MORNING', 'EVENING' ],
	serviceDays : [ 'SUNDAY' ],
	languages : [ 'AMERICAN_SIGN_LANGUAGE', 'SPANISH' ],
	programsOffered : [ 'INFANT_CARE', 'TODDLER_CARE', 'SUNDAY_SCHOOL',
			'BIBLE_STUDY', 'ADULT_EDUCATION', 'SPIRITUAL_CLASSES',
			'CHILDRENS_GROUPS', 'MIDDLE_SCHOOL_GROUP', 'HIGH_SCHOOL_GROUP',
			'YOUNG_ADULT_GROUP', 'ADULT_GROUP', 'MENS_GROUP', 'WOMENS_GROUP' ],
	accessibilitysupport : [ 'WHEELCHAIR_ACCESS', 'DEAF_TRANSLATOR',
			'PARKING_LOT' ],
});

db.organizations.insert({
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
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '9:20 Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T09:20:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'MID_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '11am Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T11:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'LATE_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,

			serviceName : 'Sunday Evening Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T18:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'EVENING'
			}
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
	denomination : 'BAPTIST',
	subDenomination : 'NONE',
	multimedia : [ {
		name : 'Church View',
		path : '1.jpg',
		altText : 'Church and sign',
		primary : true,
		video : false
	} ],
	leadershipTeam : [ {
		name : 'Dave and Debbie Fakelastname',
		title : 'Lead Pastor',
		bio : 'Lead pastor bio information goes here',
		leaderRole : 'PASTOR',
		image : {
			name : 'Pastor Mike Howerton',
			path : '3.jpg',
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
	serviceTimes : [ 'EARLY_MORNING', 'MID_MORNING', 'EVENING' ],
	serviceDays : [ 'SUNDAY' ],
	languages : [ 'AMERICAN_SIGN_LANGUAGE', 'SPANISH' ],
	programsOffered : [ 'INFANT_CARE', 'TODDLER_CARE', 'SUNDAY_SCHOOL',
			'BIBLE_STUDY', 'ADULT_EDUCATION', 'SPIRITUAL_CLASSES',
			'CHILDRENS_GROUPS', 'MIDDLE_SCHOOL_GROUP', 'HIGH_SCHOOL_GROUP',
			'YOUNG_ADULT_GROUP', 'ADULT_GROUP', 'MENS_GROUP', 'WOMENS_GROUP' ],
	accessibilitysupport : [ 'WHEELCHAIR_ACCESS', 'DEAF_TRANSLATOR',
			'PARKING_LOT' ],
});

//New
db.organizations.insert({
	yearFounded : 2005,
	name : "Northwest Church of the brontosaurus",
	missionStatement : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vulputate at justo quis molestie. Cras suscipit sagittis rutrum. In id libero quis urna consequat bibendum. Duis sed eros et ligula vestibulum congue. Praesent volutpat nibh eget ipsum tempor varius.',
	statementOfFaith : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vulputate at justo quis molestie. Cras suscipit sagittis rutrum. In id libero quis urna consequat bibendum. Duis sed eros et ligula vestibulum congue. Praesent volutpat nibh eget ipsum tempor varius.',
	welcomeMessage : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vulputate at justo quis molestie. Cras suscipit sagittis rutrum. In id libero quis urna consequat bibendum. Duis sed eros et ligula vestibulum congue. Praesent volutpat nibh eget ipsum tempor varius.',
	address : {
		street1 : '4141 81st Ave SE0',
		city : ', Mercer Island4',
		postalCode : '98040',
		state : 'WA',
		country : 'USA',
		longitude : -122.13822,
		latitude : 47.34393,
		location : [ -122.13822, 47.34393 ]
	},
	atmosphere : {
		congregationSize : "MEDIUM",
		serviceDetails : [ {
			musicStyle : 'TRADITIONAL_3',
			serviceStyle : 'CONSERVATIVE_2',
			dressAttire : 'NEUTRAL_5',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '9:20 Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T09:20:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'MID_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '11am Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T11:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'LATE_MORNING'
			}
		}],
		gayAffirming : false,
		homeChurch : false
	},
	socialMedia : {
		websiteUrl : 'http://www.google.org',
		facebookUrl : 'https://www.facebook.com/justen.britain',
		blogUrl : '',
		googlePlusUrl : '',
		youtubeUrl : '',
		podcastUrl : '',
		twitterUrl : '',
		otherUrl : '',
		instagramUrl : ''
	},
	denomination : 'BAPTIST',
	subDenomination : 'NONE',
	multimedia : [ {
		name : 'Church View',
		path : '1.jpg',
		altText : 'Church and sign',
		primary : true,
		video : false
	} ],
	leadershipTeam : [ {
		name : 'Dave and Debbie Fakelastname',
		title : 'Lead Pastor',
		bio : 'Lead pastor bio information goes here',
		leaderRole : 'PASTOR',
		image : {
			name : 'Pastor Mike Howerton',
			path : '3.jpg',
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
	serviceTimes : [ 'EARLY_MORNING', 'MID_MORNING', 'EVENING' ],
	serviceDays : [ 'SUNDAY' ],
	languages : [ 'AMERICAN_SIGN_LANGUAGE', 'SPANISH' ],
	programsOffered : [ 'INFANT_CARE', 'TODDLER_CARE', 'SUNDAY_SCHOOL'],
	accessibilitysupport : [ 'WHEELCHAIR_ACCESS', 'DEAF_TRANSLATOR'],
});

db.organizations.insert({
	yearFounded : 1996,
	name : "A Church called The Church",
	missionStatement : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vulputate at justo quis molestie. Cras suscipit sagittis rutrum. In id libero quis urna consequat bibendum. Duis sed eros et ligula vestibulum congue. Praesent volutpat nibh eget ipsum tempor varius.',
	statementOfFaith : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vulputate at justo quis molestie. Cras suscipit sagittis rutrum. In id libero quis urna consequat bibendum. Duis sed eros et ligula vestibulum congue. Praesent volutpat nibh eget ipsum tempor varius.',
	welcomeMessage : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vulputate at justo quis molestie. Cras suscipit sagittis rutrum. In id libero quis urna consequat bibendum. Duis sed eros et ligula vestibulum congue. Praesent volutpat nibh eget ipsum tempor varius.',
	address : {
		street1 : '330 101st Ave SE',
		city : 'Bellevue',
		postalCode : '98004',
		state : 'WA',
		country : 'USA',
		longitude : -122.12289,
		latitude : 47.36433,
		location : [ -122.12289, 47.36433 ]
	},
	atmosphere : {
		congregationSize : "LARGE",
		serviceDetails : [ {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '9:20 Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T09:20:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'MID_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '11am Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T11:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'LATE_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,

			serviceName : 'Sunday Evening Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T18:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'EVENING'
			}
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
	denomination : 'CATHOLIC',
	subDenomination : 'NONE',
	multimedia : [ {
		name : 'Church View',
		path : '1.jpg',
		altText : 'Church and sign',
		primary : true,
		video : false
	} ],
	leadershipTeam : [ {
		name : 'Fred and Laura Smith',
		title : 'Lead Pastor',
		bio : 'Lead pastor bio information goes here',
		leaderRole : 'PASTOR',
		image : {
			name : 'Pastor Mike Howerton',
			path : '3.jpg',
			altText : 'Pastor Mike Howerton',
			primary : false,
			video : false
		},
		primaryContact : false,
		primaryLeader : true,
		phoneNumber : '(510) 261-2052 ext 2323',
		emailAddress : '',
		yearStarted : ''
	}],
	serviceTimes : [ 'EARLY_MORNING', 'MID_MORNING', 'EVENING' ],
	serviceDays : [ 'SUNDAY' ],
	languages : [ 'AMERICAN_SIGN_LANGUAGE', 'SPANISH' ],
	programsOffered : [ 'INFANT_CARE', 'TODDLER_CARE', 'SUNDAY_SCHOOL',
			'BIBLE_STUDY', 'ADULT_EDUCATION', 'SPIRITUAL_CLASSES',
			'CHILDRENS_GROUPS', 'MIDDLE_SCHOOL_GROUP', 'HIGH_SCHOOL_GROUP',
			'YOUNG_ADULT_GROUP', 'ADULT_GROUP', 'MENS_GROUP', 'WOMENS_GROUP' ],
	accessibilitysupport : [ 'WHEELCHAIR_ACCESS', 'DEAF_TRANSLATOR',
			'PARKING_LOT' ],
});

db.organizations.insert({
	yearFounded : 1954,
	name : "Very Old Church",
	missionStatement : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vulputate at justo quis molestie. Cras suscipit sagittis rutrum. In id libero quis urna consequat bibendum. Duis sed eros et ligula vestibulum congue. Praesent volutpat nibh eget ipsum tempor varius.',
	statementOfFaith : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vulputate at justo quis molestie. Cras suscipit sagittis rutrum. In id libero quis urna consequat bibendum. Duis sed eros et ligula vestibulum congue. Praesent volutpat nibh eget ipsum tempor varius.',
	welcomeMessage : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vulputate at justo quis molestie. Cras suscipit sagittis rutrum. In id libero quis urna consequat bibendum. Duis sed eros et ligula vestibulum congue. Praesent volutpat nibh eget ipsum tempor varius.',
	address : {
		street1 : '9900 Willows RD NE',
		city : 'Redmond',
		postalCode : '98028',
		state : 'WA',
		country : 'USA',
		longitude : -122.1176,
		latitude : 47.37030,
		location : [ -122.1176, 47.37030 ]
	},
	atmosphere : {
		congregationSize : "SMALL",
		serviceDetails : [ {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '9:20 Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T09:20:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'MID_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '11am Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T11:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'LATE_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,

			serviceName : 'Sunday Evening Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T18:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'EVENING'
			}
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
	denomination : 'BAPTIST',
	subDenomination : 'NONE',
	multimedia : [ {
		name : 'Church View',
		path : '1.jpg',
		altText : 'Church and sign',
		primary : true,
		video : false
	} ],
	leadershipTeam : [ {
		name : 'Dave and Debbie Fakelastname',
		title : 'Lead Pastor',
		bio : 'Lead pastor bio information goes here',
		leaderRole : 'PASTOR',
		image : {
			name : 'Pastor Mike Howerton',
			path : '3.jpg',
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
	serviceTimes : [ 'EARLY_MORNING', 'MID_MORNING', 'EVENING' ],
	serviceDays : [ 'SUNDAY' ],
	languages : [ 'AMERICAN_SIGN_LANGUAGE', 'SPANISH' ],
	programsOffered : [ 'INFANT_CARE', 'TODDLER_CARE', 'SUNDAY_SCHOOL',
			'BIBLE_STUDY', 'ADULT_EDUCATION', 'SPIRITUAL_CLASSES',
			'CHILDRENS_GROUPS', 'MIDDLE_SCHOOL_GROUP', 'HIGH_SCHOOL_GROUP',
			'YOUNG_ADULT_GROUP', 'ADULT_GROUP', 'MENS_GROUP', 'WOMENS_GROUP' ],
	accessibilitysupport : [ 'WHEELCHAIR_ACCESS', 'DEAF_TRANSLATOR',
			'PARKING_LOT' ],
});

db.organizations.insert({
	yearFounded : 2000,
	name : "An other Dinosaur Church",
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
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '9:20 Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T09:20:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'MID_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '11am Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T11:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'LATE_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,

			serviceName : 'Sunday Evening Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T18:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'EVENING'
			}
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
	denomination : 'BAPTIST',
	subDenomination : 'NONE',
	multimedia : [ {
		name : 'Church View',
		path : '1.jpg',
		altText : 'Church and sign',
		primary : true,
		video : false
	} ],
	leadershipTeam : [ {
		name : 'Dave and Debbie Fakelastname',
		title : 'Lead Pastor',
		bio : 'Lead pastor bio information goes here',
		leaderRole : 'PASTOR',
		image : {
			name : 'Pastor Mike Howerton',
			path : '3.jpg',
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
	serviceTimes : [ 'EARLY_MORNING', 'MID_MORNING', 'EVENING' ],
	serviceDays : [ 'SUNDAY' ],
	languages : [ 'AMERICAN_SIGN_LANGUAGE', 'SPANISH' ],
	programsOffered : [ 'INFANT_CARE', 'TODDLER_CARE', 'SUNDAY_SCHOOL',
			'BIBLE_STUDY', 'ADULT_EDUCATION', 'SPIRITUAL_CLASSES',
			'CHILDRENS_GROUPS', 'MIDDLE_SCHOOL_GROUP', 'HIGH_SCHOOL_GROUP',
			'YOUNG_ADULT_GROUP', 'ADULT_GROUP', 'MENS_GROUP', 'WOMENS_GROUP' ],
	accessibilitysupport : [ 'WHEELCHAIR_ACCESS', 'DEAF_TRANSLATOR',
			'PARKING_LOT' ],
});

db.organizations.insert({
	yearFounded : 2000,
	name : "Southern Baptist Church",
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
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '9:20 Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T09:20:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'MID_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '11am Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T11:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'LATE_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,

			serviceName : 'Sunday Evening Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T18:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'EVENING'
			}
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
	denomination : 'BAPTIST',
	subDenomination : 'NONE',
	multimedia : [ {
		name : 'Church View',
		path : '1.jpg',
		altText : 'Church and sign',
		primary : true,
		video : false
	} ],
	leadershipTeam : [ {
		name : 'Dave and Debbie Fakelastname',
		title : 'Lead Pastor',
		bio : 'Lead pastor bio information goes here',
		leaderRole : 'PASTOR',
		image : {
			name : 'Pastor Mike Howerton',
			path : '3.jpg',
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
	serviceTimes : [ 'EARLY_MORNING', 'MID_MORNING', 'EVENING' ],
	serviceDays : [ 'SUNDAY' ],
	languages : [ 'AMERICAN_SIGN_LANGUAGE', 'SPANISH' ],
	programsOffered : [ 'INFANT_CARE', 'TODDLER_CARE', 'SUNDAY_SCHOOL',
			'BIBLE_STUDY', 'ADULT_EDUCATION', 'SPIRITUAL_CLASSES',
			'CHILDRENS_GROUPS', 'MIDDLE_SCHOOL_GROUP', 'HIGH_SCHOOL_GROUP',
			'YOUNG_ADULT_GROUP', 'ADULT_GROUP', 'MENS_GROUP', 'WOMENS_GROUP' ],
	accessibilitysupport : [ 'WHEELCHAIR_ACCESS', 'DEAF_TRANSLATOR',
			'PARKING_LOT' ],
});

db.organizations.insert({
	yearFounded : 2000,
	name : "Non-denominatinoal Gay Affirming Church",
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
		congregationSize : "LARGE",
		serviceDetails : [ {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '9:20 Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T09:20:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'MID_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '11am Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T11:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'LATE_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,

			serviceName : 'Sunday Evening Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T18:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'EVENING'
			}
		} ],
		gayAffirming : true,
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
	denomination : 'BAPTIST',
	subDenomination : 'NONE',
	multimedia : [ {
		name : 'Church View',
		path : '1.jpg',
		altText : 'Church and sign',
		primary : true,
		video : false
	} ],
	leadershipTeam : [ {
		name : 'Dave and Debbie Fakelastname',
		title : 'Lead Pastor',
		bio : 'Lead pastor bio information goes here',
		leaderRole : 'PASTOR',
		image : {
			name : 'Pastor Mike Howerton',
			path : '3.jpg',
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
	serviceTimes : [ 'EARLY_MORNING', 'MID_MORNING', 'EVENING' ],
	serviceDays : [ 'SUNDAY' ],
	languages : [ 'AMERICAN_SIGN_LANGUAGE', 'SPANISH' ],
	programsOffered : [ 'INFANT_CARE', 'TODDLER_CARE', 'SUNDAY_SCHOOL',
			'BIBLE_STUDY', 'ADULT_EDUCATION', 'SPIRITUAL_CLASSES',
			'CHILDRENS_GROUPS', 'MIDDLE_SCHOOL_GROUP', 'HIGH_SCHOOL_GROUP',
			'YOUNG_ADULT_GROUP', 'ADULT_GROUP', 'MENS_GROUP', 'WOMENS_GROUP' ],
	accessibilitysupport : [ 'WHEELCHAIR_ACCESS', 'DEAF_TRANSLATOR',
			'PARKING_LOT' ],
});

db.organizations.insert({
	yearFounded : 2000,
	name : "Finding Nemo Church",
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
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '9:20 Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T09:20:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'MID_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '11am Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T11:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'LATE_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,

			serviceName : 'Sunday Evening Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T18:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'EVENING'
			}
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
	denomination : 'BAPTIST',
	subDenomination : 'NONE',
	multimedia : [ {
		name : 'Church View',
		path : '1.jpg',
		altText : 'Church and sign',
		primary : true,
		video : false
	} ],
	leadershipTeam : [ {
		name : 'Dave and Debbie Fakelastname',
		title : 'Lead Pastor',
		bio : 'Lead pastor bio information goes here',
		leaderRole : 'PASTOR',
		image : {
			name : 'Pastor Mike Howerton',
			path : '3.jpg',
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
	serviceTimes : [ 'EARLY_MORNING', 'MID_MORNING', 'EVENING' ],
	serviceDays : [ 'SUNDAY' ],
	languages : [ 'AMERICAN_SIGN_LANGUAGE', 'SPANISH' ],
	programsOffered : [ 'INFANT_CARE', 'TODDLER_CARE', 'SUNDAY_SCHOOL',
			'BIBLE_STUDY', 'ADULT_EDUCATION', 'SPIRITUAL_CLASSES',
			'CHILDRENS_GROUPS', 'MIDDLE_SCHOOL_GROUP', 'HIGH_SCHOOL_GROUP',
			'YOUNG_ADULT_GROUP', 'ADULT_GROUP', 'MENS_GROUP', 'WOMENS_GROUP' ],
	accessibilitysupport : [ 'WHEELCHAIR_ACCESS', 'DEAF_TRANSLATOR',
			'PARKING_LOT' ],
});

db.organizations.insert({
	yearFounded : 2000,
	name : "Tron Church",
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
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '9:20 Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T09:20:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'MID_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '11am Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T11:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'LATE_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,

			serviceName : 'Sunday Evening Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T18:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'EVENING'
			}
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
	denomination : 'BAPTIST',
	subDenomination : 'NONE',
	multimedia : [ {
		name : 'Church View',
		path : '1.jpg',
		altText : 'Church and sign',
		primary : true,
		video : false
	} ],
	leadershipTeam : [ {
		name : 'Dave and Debbie Fakelastname',
		title : 'Lead Pastor',
		bio : 'Lead pastor bio information goes here',
		leaderRole : 'PASTOR',
		image : {
			name : 'Pastor Mike Howerton',
			path : '3.jpg',
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
	serviceTimes : [ 'EARLY_MORNING', 'MID_MORNING', 'EVENING' ],
	serviceDays : [ 'SUNDAY' ],
	languages : [ 'AMERICAN_SIGN_LANGUAGE', 'SPANISH' ],
	programsOffered : [ 'INFANT_CARE', 'TODDLER_CARE', 'SUNDAY_SCHOOL',
			'BIBLE_STUDY', 'ADULT_EDUCATION', 'SPIRITUAL_CLASSES',
			'CHILDRENS_GROUPS', 'MIDDLE_SCHOOL_GROUP', 'HIGH_SCHOOL_GROUP',
			'YOUNG_ADULT_GROUP', 'ADULT_GROUP', 'MENS_GROUP', 'WOMENS_GROUP' ],
	accessibilitysupport : [ 'WHEELCHAIR_ACCESS', 'DEAF_TRANSLATOR',
			'PARKING_LOT' ],
});

db.organizations.insert({
	yearFounded : 2000,
	name : "Wreck it Ralph Church",
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
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '9:20 Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T09:20:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'MID_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '11am Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T11:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'LATE_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,

			serviceName : 'Sunday Evening Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T18:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'EVENING'
			}
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
	denomination : 'BAPTIST',
	subDenomination : 'NONE',
	multimedia : [ {
		name : 'Church View',
		path : '1.jpg',
		altText : 'Church and sign',
		primary : true,
		video : false
	} ],
	leadershipTeam : [ {
		name : 'Dave and Debbie Fakelastname',
		title : 'Lead Pastor',
		bio : 'Lead pastor bio information goes here',
		leaderRole : 'PASTOR',
		image : {
			name : 'Pastor Mike Howerton',
			path : '3.jpg',
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
	serviceTimes : [ 'EARLY_MORNING', 'MID_MORNING', 'EVENING' ],
	serviceDays : [ 'SUNDAY' ],
	languages : [ 'AMERICAN_SIGN_LANGUAGE', 'SPANISH' ],
	programsOffered : [ 'INFANT_CARE', 'TODDLER_CARE', 'SUNDAY_SCHOOL',
			'BIBLE_STUDY', 'ADULT_EDUCATION', 'SPIRITUAL_CLASSES',
			'CHILDRENS_GROUPS', 'MIDDLE_SCHOOL_GROUP', 'HIGH_SCHOOL_GROUP',
			'YOUNG_ADULT_GROUP', 'ADULT_GROUP', 'MENS_GROUP', 'WOMENS_GROUP' ],
	accessibilitysupport : [ 'WHEELCHAIR_ACCESS', 'DEAF_TRANSLATOR',
			'PARKING_LOT' ],
});

db.organizations.insert({
	yearFounded : 2000,
	name : "Little Mermaid Church",
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
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '9:20 Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T09:20:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'MID_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,
			serviceName : '11am Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T11:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'LATE_MORNING'
			}
		}, {
			musicStyle : 'CONTEMPORARY_8',
			serviceStyle : 'HIGH_ENERGY_7',
			dressAttire : 'CASUAL_7',
			ageDemographics : 'NEUTRAL_4',
			instruments : [],
			durationInMinutes : 90,

			serviceName : 'Sunday Evening Service',
			timeAndDay : {
				startTime : ISODate("0000-12-30T18:00:00Z"),
				serviceDay : 'SUNDAY',
				serviceTimeRange : 'EVENING'
			}
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
	denomination : 'BAPTIST',
	subDenomination : 'NONE',
	multimedia : [ {
		name : 'Church View',
		path : '1.jpg',
		altText : 'Church and sign',
		primary : true,
		video : false
	} ],
	leadershipTeam : [ {
		name : 'Dave and Debbie Fakelastname',
		title : 'Lead Pastor',
		bio : 'Lead pastor bio information goes here',
		leaderRole : 'PASTOR',
		image : {
			name : 'Pastor Mike Howerton',
			path : '3.jpg',
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
	serviceTimes : [ 'EARLY_MORNING', 'MID_MORNING', 'EVENING' ],
	serviceDays : [ 'SUNDAY' ],
	languages : [ 'AMERICAN_SIGN_LANGUAGE', 'SPANISH' ],
	programsOffered : [ 'INFANT_CARE', 'TODDLER_CARE', 'SUNDAY_SCHOOL',
			'BIBLE_STUDY', 'ADULT_EDUCATION', 'SPIRITUAL_CLASSES',
			'CHILDRENS_GROUPS', 'MIDDLE_SCHOOL_GROUP', 'HIGH_SCHOOL_GROUP',
			'YOUNG_ADULT_GROUP', 'ADULT_GROUP', 'MENS_GROUP', 'WOMENS_GROUP' ],
	accessibilitysupport : [ 'WHEELCHAIR_ACCESS', 'DEAF_TRANSLATOR',
			'PARKING_LOT' ],
});

db.organizations.ensureIndex({
	"address.location" : "2d"
});

// db.addUser({
// user : "flockSpring",
// pwd : "fl0ckSpr!ng",
// roles : [ "readWrite" ]
// });
