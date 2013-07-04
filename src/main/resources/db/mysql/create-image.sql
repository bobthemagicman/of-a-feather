DROP TABLE IF EXISTS IMAGE;
CREATE TABLE IMAGE(
	ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(127),
	PATH VARCHAR(127),
	ALT VARCHAR(127),
	WIDTH INT,
	HEIGH INT,
	EXTENSION VARCHAR(7)	
) engine InnoDB;
