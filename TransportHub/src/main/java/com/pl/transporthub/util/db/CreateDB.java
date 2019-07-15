package com.pl.transporthub.util.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:myDatabase;create=true";
	public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(JDBC_URL);
		try {
			connection.createStatement().execute("create table bus(id int, lineID int,DriverID int)");
		}
		catch(Exception e) {
			connection.createStatement().execute("delete from bus");
			System.out.println("table bus alrady exists");
			}
		connection.createStatement().execute("insert into bus values " +
						 					"(1,100,1), "+
											"(2,201,2), " +
											"(3,154,3)");
		try {
			connection.createStatement().execute("create table busStations(id int, lat float,lon float)");
		}
		catch(Exception e) {
			connection.createStatement().execute("delete from busStations");
			System.out.println("table busStations alrady exists");
			}
		connection.createStatement().execute("insert into busStations values " +
						 					"(1, 32.013618, 34.771135), "+
											"(2, 32.014405, 34.766924), " +
											"(3, 32.014764, 34.764177), "+
											"(4, 32.015323, 34.762042), " +
											"(5, 32.015960, 34.758646)");

		try {
			//connection.createStatement().execute("drop table users");

			connection.createStatement().execute("create table users(id int, firstName varchar(20),"
					+ "lastName varchar(20),username varchar(20),password varchar(20),expirationDate varchar(20),"
					+ "enabled BOOLEAN,  isadmin BOOLEAN,phone varchar(20),email varchar(20),driverID int)");

		}
		catch(Exception e) {
			System.out.println(e);

			connection.createStatement().execute("delete from users");
			System.out.println("table users alrady exists");
			}

		connection.createStatement().execute("insert into users values" +
						 					"(1, 'moshe', 'ben moshe','moshe','moshe','1.1.2020',TRUE,FALSE,'1111111','moshe@test.email',0), "+
											"(2, 'Israel', 'Israely','Israel','Israel','1.1.2020',TRUE,TRUE,'1111112','israel@test.email',0), " +
											"(3, 'Dan', 'D','Dan','Dan', '1.1.2020',FALSE,FALSE,'1111113','dan@test.email', 1), " +
											"(4, 'Geri', 'G','Geri','Geri', '1.1.2020',FALSE,FALSE,'111114','geri@test.email', 2)");
		try {
			connection.createStatement().execute("create table line(id int, lineNumber int, numberOfStation int,stationsID varchar(20))");
		}
		catch(Exception e) {
			connection.createStatement().execute("delete from line");
			System.out.println("table line alrady exists");

			}
		connection.createStatement().execute("insert into line values " +
						 					"(1, 100,3, '1,2,3'), "+
											"(2, 201, 4, '1,3,4,5'), " +
											"(3, 154, 3, '5,3,1')");
		System.out.println("table created and records successfully inserted...");
		
		
	}
}
