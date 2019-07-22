/*******************************************************************************
 * Copyright (C) 2019 Pavel Mayzenberg, Leon Peper, Oded Levin
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
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
			connection.createStatement().execute("create table bus(id int, lineID int,DriverID int, busRegPlate varchar(20))");
		}
		catch(Exception e) {
			connection.createStatement().execute("delete from bus");
			System.out.println("table bus alrady exists");
			}
		connection.createStatement().execute("insert into bus values " +
						 					"(1,100,1,'123'), "+
											"(2,201,2,'321'), " +
											"(3,154,3, '111')");
		try {
			//connection.createStatement().execute("drop table busStations");

			connection.createStatement().execute("create table busStations(id int,stationName varchar(20),stationAddress varchar(20), lat float,lon float,lines varchar(20))");
		}
		catch(Exception e) {
			connection.createStatement().execute("delete from busStations");
			System.out.println("table busStations alrady exists");
			}
		connection.createStatement().execute("insert into busStations values " +
						 					"(1, 'one', 'there 1', 32.013618, 34.771135, '100,201,154'), "+
											"(2, 'tow', 'no there 43', 32.014405, 34.766924, '201'), " +
											"(3, 'three', 'almost there 2', 32.014764, 34.764177, '100,201,154'), "+
											"(4, 'four', 'somewhere 465', 32.015323, 34.762042, '201'), " +
											"(5, 'five', 'gothem 48', 32.015960, 34.758646, '201,154')");

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
			//connection.createStatement().execute("drop table line");

			connection.createStatement().execute("create table line(id int, lineNumber int, numberOfStation int,stationsIDs varchar(20),busIDs varchar(20))");
		}
		catch(Exception e) {
			connection.createStatement().execute("delete from line");
			System.out.println("table line alrady exists");

			}
		connection.createStatement().execute("insert into line values " +
						 					"(1, 100,3, '1,2,3','1'), "+
											"(2, 201, 4, '1,3,4,5','2'), " +
											"(3, 154, 3, '5,3,1','3')");
		System.out.println("table created and records successfully inserted...");
		
		
	}
}
