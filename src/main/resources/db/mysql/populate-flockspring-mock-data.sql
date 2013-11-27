var org1 = {address: {street1: '9900 Willows RD NE', city: 'Redmond', postalCode: '98028', state: 'WA', country: 'USA', longitude: '-122.14927',latitude: '47.68908', location:[-122.14927, 47.68908]},
 primaryLeader: {name: 'Mike Howerton', title: 'Lead Pastor', bio: 'Lead pastor bio information goes here', image: {name: 'Pastor Mike Howerton', path: '/image/1234.jpg', altText: 'Pastor Mike Howerton'}, primaryContact: false, primaryLeader: true},
 images: [{name: 'Pastor Mike Howerton', path: '/image/1234.jpg', altText: 'Pastor Mike Howerton'}, {name: 'Pastor Mike Howerton', path: '/image/1234.jpg', altText: 'Pastor Mike Howerton'}, {name: 'Pastor Mike Howerton', path: '/image/1234.jpg', altText: 'Pastor Mike Howerton'}],
 musicStyle: 'CONTEMPORARY_3',
 dressAttire: 'CASUAL_3',
 serviceStyle: 'HIGH_ENERGY_3',
 yearFounded: '2000',
 serviceTimes: ['EARLY_MORNING', 'MID_MORNING', 'LATE_MORNING', 'AFTERNOON', 'EVENING'],
 serviceDays: ['SUNDAY'],
 denomination: 'NONDENOMINATIONAL',
 subDenomination: 'NONE',
 name: 'Overlake Christian Church',
 programs: ['INFANT_CARE', 'TODDLER_CARE', 'SUNDAY_SCHOOL', 'BIBLE_STUDY', 'ADULT_EDUCATION', 'SPIRITUAL_CLASSES', 'PRE_SCHOOL', 'PRIMARY_SCHOOL', 'SECONDARY_SCHOOL', 'GRADUATE_STUDIES', 'CHILDRENS_GROUPS', 'MIDDLE_SCHOOL_GROUP', 'HIGH_SCHOOL_GROUP', 'YOUNG_ADULT_GROUP', 'ADULT_GROUP', 'MENS_GROUP', 'WOMENS_GROUP'],
 accessabilityNeeds: ['WHEEL_CHAIR_ACCESS, DEAF_TRANSLATOR, PARKING_LOG'],
 description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vulputate at justo quis molestie. Cras suscipit sagittis rutrum. In id libero quis urna consequat bibendum. Duis sed eros et ligula vestibulum congue. Praesent volutpat nibh eget ipsum tempor varius.',
 websiteUrl: 'http://www.occ.org',
 facebookUrl: 'https://www.facebook.com/OverlakeChristianChurch',
 congregationSize: 'LARGE',
 parkingLot: true,
 gayAffirming: false
} 


db.organizations.insert(org1);
db.organizations.ensureIndex( {"address.location": "2d"})
db.addUser( { user: "flockSpring", pwd: "fl0ckSpr!ng", roles: ["readWrite"] } );