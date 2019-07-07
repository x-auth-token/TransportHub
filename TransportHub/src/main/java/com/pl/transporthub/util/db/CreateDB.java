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
			connection.createStatement().execute("create table person(id int, firstName varchar(20),lastName varchar(20), managerFlag int, driverID int)");

		}
		catch(Exception e) {
			connection.createStatement().execute("delete from person");
			System.out.println("table person alrady exists");
			}

		connection.createStatement().execute("insert into person values" +
						 					"(1, 'moshe', 'ben moshe',0,0), "+
											"(2, 'Israel', 'Israely', 1, 0), " +
											"(3, 'Dan', 'D', 0, 1), " +
											"(4, 'Geri', 'G', 0, 2)");
		try {
			connection.createStatement().execute("create table line(id int, lineNumber int, numberOfStation int,stationsID varchar(20))");
		}
		catch(Exception e) {
			connection.createStatement().execute("delete from line");
			System.out.println("table line alrady exists");

			}
		connection.createStatement().execute("insert into line values " +
						 					"(1, 3, 100, '1,2,3'), "+
											"(2, 4, 201, '1,3,4,5'), " +
											"(3, 3, 154, '5,3,1')");
		System.out.println("table created and records successfully inserted...");
		
		
	}
}
