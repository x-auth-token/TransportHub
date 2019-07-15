package com.pl.transporthub.util.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class QueryDB {
	//public static final String SQL_STATMENT = "select * from person";
	public static void main(String[] args) throws SQLException {
		ResultSet resultSet = getDriverFromLine(201);
		while (resultSet.next()) {
			System.out.println("");
			for (int i = 1; i <= 3; i++) System.out.format("%20s",resultSet.getString(i)+" | ");
		}

	}
	
	
	public static int[] StringToIntegerArray(String[] str) {
	      int size = str.length;
	      int [] arr = new int [size];
	      for(int i=0; i<size; i++) {
	         arr[i] = Integer.parseInt(str[i]);
	      }
	      return arr;
	}
	
	public static ResultSet getUsers() throws SQLException {
		String SQL_STATMENT = "select * from person";
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	
	public static ResultSet getManagers() throws SQLException {
		String SQL_STATMENT = "select * from person where managerFlag=1";
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	
	public static ResultSet getPersonPass(String name) throws SQLException {
		String SQL_STATMENT = "select password from person where username='"+name+"'";
		System.out.format(SQL_STATMENT);
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	
	public static ResultSet getDrivers() throws SQLException {
		String SQL_STATMENT = "select * from person where driverID!=0";
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	
	public static ResultSet getStationsFromLine(int line) throws SQLException {
		String SQL_STATMENT = "select stationsID from line where lineNumber="+line;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
		resultSet.next();
		int[] stationsID = StringToIntegerArray(resultSet.getString(1).split("\\,")); 
		int size = stationsID.length;
		SQL_STATMENT = "select * from busStations where ";
		for(int i=0; i<size; i++) {
			if (i != 0){
				SQL_STATMENT = SQL_STATMENT+"or ";
			}
			SQL_STATMENT=SQL_STATMENT+"id="+stationsID[i]+" ";
		}
		statement = connection.createStatement();
		resultSet = statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	
	public static ResultSet getDriverFromLine(int line) throws SQLException {
		String SQL_STATMENT = "select DriverID from bus where lineID="+line;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
		resultSet.next();
		int driverId=resultSet.getInt(1);
		SQL_STATMENT = "select * from person where driverID="+driverId	;
		statement = connection.createStatement();
		resultSet = statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	
	public static void updateUserPassword(String username, String pass) throws SQLException {
		String SQL_STATMENT = "update person set password='"+pass+"' where username='"+username+"'";
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		statement.executeQuery(SQL_STATMENT);
	}
	public static void setUserAsDriver(String username, int driverID) throws SQLException {
		String SQL_STATMENT = "update person set driverID="+driverID+" where username='"+username+"'";
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		statement.executeQuery(SQL_STATMENT);
	}
	public static void setMngrName(String newname, String oldname) throws SQLException {
		String SQL_STATMENT = "update person set firstName="+newname+" where firstName='"+oldname+"'";
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		statement.executeQuery(SQL_STATMENT);
	}
	
	public static ResultSet getNameByID(int id) throws SQLException {
		String SQL_STATMENT = "select firstName from person where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
		return resultSet;
	}
	public static void setUserAsMang(String username, int mngFlag) throws SQLException {
		String SQL_STATMENT = "update person set managerFlag="+mngFlag+" where username='"+username+"'";
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		statement.executeQuery(SQL_STATMENT);
	}
	
	
}
