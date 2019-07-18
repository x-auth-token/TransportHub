CREATE TABLE IF NOT EXISTS users(userID integer PRIMARY KEY, username varchar(15) NOT NULL, password varchar(1158) NOT NULL, authenticated integer NOT NULL, expirationDate text, enabled integer  NOT NULL, isadmin integer  NOT NULL, email varchar(50), mobileNumber varchar(15), role varchar(15)  NOT NULL;
CREATE TABLE IF NOT EXISTS buses(busID integer PRIMARY KEY, busRegPlate varchar(15), assignedLine integer, assignedDriverID integer, busCondition int;
CREATE TABLE IF NOT EXISTS stations(stationID integer PRIMARY KEY, stationName text, stationAddress text, stationCoordinateX float, stationCoordinateY float, lineIDs text, stationState, integer;
CREATE TABLE IF NOT EXISTS lines(lineID integer PRIMARY KEY, lineStatus integer, stationIDs text, busIDs text;


INSERT INTO users(id, username, password, authenticated, exp_date, enabled, isadmin, email, mobileNumber, role) VALUES (0, 'admin', 'admin', 0, '2019-12-31', 1, null, null, 'ADMIN');
