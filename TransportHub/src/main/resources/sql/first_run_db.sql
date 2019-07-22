CREATE TABLE IF NOT EXISTS users(userID integer NOT NULL PRIMARY KEY ON CONFLICT IGNORE, username text(15) NOT NULL, password text(1158) NOT NULL, role text(15)  NOT NULL, expirationDate text, enabled integer  NOT NULL, firstName text NOT NULL, lastName text NOT NULL, passportID text(9), address text NOT NULL, email text(50) NOT NULL, mobileNumber text(15) NOT NULL) WITHOUT ROWID;
CREATE TABLE IF NOT EXISTS buses(busID integer PRIMARY KEY ON CONFLICT IGNORE, busRegPlate text(15), assignedLine integer, assignedDriverID integer, busCondition int) WITHOUT ROWID;
CREATE TABLE IF NOT EXISTS stations(stationID integer PRIMARY KEY ON CONFLICT IGNORE, stationName text, stationAddress text, stationCoordinateX float, stationCoordinateY float, lineIDs text, stationState integer) WITHOUT ROWID;
CREATE TABLE IF NOT EXISTS lines(lineID integer PRIMARY KEY ON CONFLICT IGNORE, lineStatus integer, stationIDs text, busIDs text) WITHOUT ROWID;


INSERT INTO users(userID, username, password, expirationDate, enabled, firstName, lastName, passportID, address, email, mobileNumber, role) VALUES (0, 'admin', '1000:dd470c9ec6a110f75e1707753d1fcca2cef9e8aa07a53033e663978aa564a6cc3970b4a325bed66a77a8493d3bcfb72a8c264dfc109069bd73b704c6f72868789ee484c8877dd0fc4f91ae2b5ab43f7d2b2137f6ecd636a2e1727dd0909d2f58fc369d53d675063973ab7b2d46fa585b0ee84966fbde78028c3f73713e1a6443dfe79d44db9ad2111facfa2e1c9396eb74e000a315cf39bcbcf68b50da5721c3f46168518ab6ef5574e7df00a0b42c0a1a5d21e57fd765187d3258bdcb59bbdc52e3fb7aea9988b5a7435d3ecc33acf4ea47e32c8e43a3f9fb7e03d1bb5399be7a47bd70b24161493144f6c4e09ba4769ccce0ae2a3cbb0669e169d37c6155584371da661dfa518013e47962ee346d3f07195672922df981946ad847bbc1ae884554e78eb19dcb50b93c0e1e1b46b188a45a0a8375300bab78b0cfa9a7eb27157f0d1063e9651a6026c5a590c5941dbc56c40d51e40cfe2c8b9d31189b65655e79ab7873d90b4e0b548979429ea3c90039565159c08ebfe3ed7d7aab99e25b4795cb435dc4cc8bd77bc6d373db408cf5b155f2fd835c236ca702450f01010a282d4fd57ce7014de438f1232c553f6e0731f6bed38a5f40769d627cf8080d41d7d7101c949090a162e8acf05d8c5f06e2e536883338be5b83441c29a10acfe1d1bf8fed01249548b592ee6488b12e1886aa8d823ee36230253bee675208d2064e:9ccf40499995a0650ad609d46962cd61cd85a1730ebde0f2ae38d1ee3652976fbd2008e3911225dc74ff7bc814fbdcf293c61e66401b3dff1206f38c5108047e
', '2019-12-31', 1, 'Israel', 'Israeli', '123456789', 'My Street 11, City, Country', 'admin@transporthub.com', '0540000000', 'ADMIN');
INSERT INTO buses(busID , busRegPlate, assignedLine, assignedDriverID, busCondition) VALUES (1, '12345678', 1, 100, 0);
INSERT INTO buses(busID , busRegPlate, assignedLine, assignedDriverID, busCondition) VALUES (2, '12345619', 2, 101, 0);
INSERT INTO buses(busID , busRegPlate, assignedLine, assignedDriverID, busCondition) VALUES (3, '10025678', 2, 102, 0);
INSERT INTO buses(busID , busRegPlate, assignedLine, assignedDriverID, busCondition) VALUES (4, '12345098', 3, 103, 1);
INSERT INTO buses(busID , busRegPlate, assignedLine, assignedDriverID, busCondition) VALUES (5, '78645678', 3, 104, 0);
INSERT INTO buses(busID , busRegPlate, assignedLine, assignedDriverID, busCondition) VALUES (6, '12907878', 4, 105, 2);
INSERT INTO buses(busID , busRegPlate, assignedLine, assignedDriverID, busCondition) VALUES (7, '11345678', 5, 106, 2);
INSERT INTO buses(busID , busRegPlate, assignedLine, assignedDriverID, busCondition) VALUES (8, '12045078', 8, 107, 0);
INSERT INTO buses(busID , busRegPlate, assignedLine, assignedDriverID, busCondition) VALUES (9, '16785678', 9, 108, 1);
INSERT INTO buses(busID , busRegPlate, assignedLine, assignedDriverID, busCondition) VALUES (10, '14345678', 10, 109, 0);
INSERT INTO buses(busID , busRegPlate, assignedLine, assignedDriverID, busCondition) VALUES (11, '67845678', 11, 110, 0);
INSERT INTO stations(stationID, stationName, stationAddress, stationCoordinateX, stationCoordinateY, lineIDs, stationState) VALUES (1, 'Ibn Sina', '22 Ibn Sina Street', 32.013618, 34.771135, '1,3,5', 2);
INSERT INTO stations(stationID, stationName, stationAddress, stationCoordinateX, stationCoordinateY, lineIDs, stationState) VALUES (2, 'Salah Ad-Din', '14 Salah Ad-Din Street', 32.013304, 34.766597, '1,5,8,9,10', 0);
INSERT INTO stations(stationID, stationName, stationAddress, stationCoordinateX, stationCoordinateY, lineIDs, stationState) VALUES (3, 'Ben Gurion', '19 Ben Gurion street', 32.011728, 34.765816, '1,11,2,4,5', 1);
INSERT INTO stations(stationID, stationName, stationAddress, stationCoordinateX, stationCoordinateY, lineIDs, stationState) VALUES (4, 'Kevin Mitnik', '78 K.Mitnik Street', 32.009183, 34.764858, '2,3,5,11', 0);
INSERT INTO stations(stationID, stationName, stationAddress, stationCoordinateX, stationCoordinateY, lineIDs, stationState) VALUES (5, 'Brian Krebs', '101 Krebs on Security Street', 32.010290, 34.763437, '1,3,5,8,9,10,11', 0);
INSERT INTO lines(lineID, lineStatus, stationIDs, busIDs) VALUES (1, 0, '1,2,3,4', '1');
INSERT INTO lines(lineID, lineStatus, stationIDs, busIDs) VALUES (2, 0, '3,4', '2,3');
INSERT INTO lines(lineID, lineStatus, stationIDs, busIDs) VALUES (3, 0, '1,4,5', '4,5');
INSERT INTO lines(lineID, lineStatus, stationIDs, busIDs) VALUES (4, 1, '3', '6');
INSERT INTO lines(lineID, lineStatus, stationIDs, busIDs) VALUES (5, 2, '1,2,3,4,5', '7');
INSERT INTO lines(lineID, lineStatus, stationIDs, busIDs) VALUES (8, 0, '2,5', '8');
INSERT INTO lines(lineID, lineStatus, stationIDs, busIDs) VALUES (9, 0, '2,5', '9');
INSERT INTO lines(lineID, lineStatus, stationIDs, busIDs) VALUES (10, 0, '2,5', '10');
INSERT INTO lines(lineID, lineStatus, stationIDs, busIDs) VALUES (11, 0, '3,4,5', '11');