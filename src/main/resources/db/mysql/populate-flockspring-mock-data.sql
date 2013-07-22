USE flock_spring;

INSERT INTO ADDRESS (ID, STREET1, STREET2, CITY, POSTAL_CODE, STATE, COUNTRY, LONGITUDE, LATITUDE) VALUES (null, "9900 Willows RD NE", "", "Redmond", 98028, "WA", "USA", 1232545, 1234567);
SET @ADDRESS_ID = LAST_INSERT_ID();

INSERT INTO IMAGE (ID, NAME, PATH, ALT,	WIDTH, HEIGHT, EXTENSION) VALUES (NULL, "Pastor Mike Howerton", "/image/1234.jpg", "Pastor Mike Howerton", 500, 500, "JPG");
SET @IMAGE_ID = LAST_INSERT_ID();

INSERT INTO LEADER (ID,	NAME, TITLE, BIO, IMAGE_ID, PRIMARY_CONTACT, PRIMARY_LEADER) VALUES (null, "Mike Howerton", "Head Pastor", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vulputate at justo quis molestie. Nulla ut nisl ac lectus tristique commodo. Proin pulvinar, neque vel tempus euismod, erat magna gravida ante, id scelerisque ante metus non ante. Cras suscipit sagittis rutrum. In id libero quis urna consequat bibendum. Duis sed eros et ligula vestibulum congue. Praesent volutpat nibh eget ipsum tempor varius. Pellentesque fringilla lacus ac magna ultricies blandit.", @IMAGE_ID, false, true);

SET @REGION_ID = (SELECT ID FROM GLOBAL_REGION WHERE REGION_TYPE = 'City'AND ENGLISH_NAME = "Redmond");
 
SET @DESCRIPTION_FILLER = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vulputate at justo quis molestie. Cras suscipit sagittis rutrum. In id libero quis urna consequat bibendum. Duis sed eros et ligula vestibulum congue. Praesent volutpat nibh eget ipsum tempor varius. Pellentesque fringilla lacus ac magna ultricies blandit. Morbi ut sodales magna. Quisque vestibulum enim non lacus pretium commodo. Morbi accumsan tortor eu elit congue iaculis. Fusce adipiscing justo urna, ut varius tellus sagittis non. Morbi semper augue id ipsum tempor, non feugiat enim elementum. Sed venenatis felis vitae scelerisque consequat. Suspendisse potenti. Etiam mollis lectus in eros pellentesque rutrum. Etiam posuere tristique tortor, in tristique felis imperdiet eu. Proin accumsan nibh et faucibus congue. Donec interdum dignissim augue ac luctus. Donec eu odio turpis. Curabitur sagittis interdum magna, facilisis elementum libero posuere eu. Etiam eleifend neque non suscipit hendrerit. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nullam libero justo, vestibulum eu turpis quis, ultricies pellentesque sem. Cras placerat justo at erat dapibus mattis. Nulla scelerisque tristique elit, sit amet dictum sapien. Nunc dolor justo, tincidunt sit amet pretium in, commodo sit amet massa. Integer vulputate faucibus tortor, tempus tempus felis fringilla at. In hac habitasse platea dictumst.";
INSERT INTO ORGANIZATION (ID, ADDRESS_ID, MUSIC_STYLE, YEAR_FOUNDED, SERVICE_TIMES, SERVICE_DAYS, PRIMARY_AFFILIATION, AFFILIATION_DENOMINATION, AFFILIATION_SUBDENOMINATION, NAME, PROGRAMS_OFFERED, AGE_DEMOGRAPHICS, ETHNIC_DEMOGRAPHICS, DESCRIPTION, WEBSITE_URL, FACEBOOK_URL, AVERAGE_SERVICE_CONGREGATION_SIZE, 
ENVIRONMENTALLY_FRIENDLY, PARKING_LOT, GAY_AFIRMING, REGION_ID) 
			      VALUES (NULL, @ADDRESS_ID, 7, 2002, "9:20AM, 11:00AM, 6:00PM", "Sunday", 1, 1, NULL, "Overlake Christian Church", "Child Care, Divorce Care, Celebrate Recovery", "All ages", "Primarily Cacusain,", @DESCRIPTION_FILLER, "http://www.occ.org", 
			      "https://www.facebook.com/OverlakeChristianChurch", 1000, true, true, false, @REGION_ID);
			      