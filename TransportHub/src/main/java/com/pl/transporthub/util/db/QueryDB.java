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
		ResultSet resultSet = getUsername(1);
		while (resultSet.next()) {
			System.out.println("");
			for (int i = 1; i <= 1; i++) System.out.format("%20s",resultSet.getString(i)+" | ");
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
	
	
	//////////////users query//////////////
	
	public static void generateUser(int id) throws SQLException {
		String SQL_STATMENT = "insert into users values ("+id+", , , , , , TRUE, FALSE, , ,0)";
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	}
	
	public static void setUsername(int id, String username) throws SQLException {
		String SQL_STATMENT = "update users set username='"+username+"' where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	}
	
	public static void setPassword(int id, String password) throws SQLException {
		String SQL_STATMENT = "update users set password='"+password+"' where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	}
	
	public static void setExpirationDate(int id, String date) throws SQLException {
		String SQL_STATMENT = "update users set expirationDate='"+date+"' where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	}
	
	public static void setAdmin(int id,boolean value) throws SQLException {
		String SQL_STATMENT = "update users set isadmin="+value+" where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	}
	
	public static void disableuser(int id) throws SQLException {
		String SQL_STATMENT = "update users set enabled=FALSE where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	}
	
	public static void anableuser(int id) throws SQLException {
		String SQL_STATMENT = "update users set enabled=TRUE where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	}
	
	public static void setEmail(int id, String email) throws SQLException {
		String SQL_STATMENT = "update users set email='"+email+"' where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	}
	
	public static void setPhone(int id, String phone) throws SQLException {
		String SQL_STATMENT = "update users set email='"+phone+"' where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	}
	
	public static ResultSet getUsername(int id) throws SQLException {
		String SQL_STATMENT = "select username from users where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	
	public static ResultSet getEmail(int id) throws SQLException {
		String SQL_STATMENT = "select email from users where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	
	public static ResultSet getPhone(int id) throws SQLException {
		String SQL_STATMENT = "select phone from users where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	
	public static ResultSet getPassword(int id) throws SQLException {
		String SQL_STATMENT = "select password from users where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	
	public static ResultSet getExpirationDate(int id) throws SQLException {
		String SQL_STATMENT = "select expirationDate from users where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	
	public static ResultSet getEnabled(int id) throws SQLException {
		String SQL_STATMENT = "select isEnabled from users where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	
	
	//////////////bus query//////////////
	
	
	public static void setBusID(int oldid, int newid) throws SQLException {
		String SQL_STATMENT = "update bus set id="+newid+" where id="+oldid;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	}
	
	public static void setBusRegPlate(int id, String regPlate) throws SQLException {
		String SQL_STATMENT = "update bus set busRegPlate='"+regPlate+"' where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	}
	
	public static ResultSet getBusRegPlate(int id) throws SQLException {
		String SQL_STATMENT = "select busRegPlate from bus where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	
	public static void setline(int id, int line) throws SQLException {
		String SQL_STATMENT = "update bus set lineID="+line+" where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	}
	
	public static ResultSet getline(int id) throws SQLException {
		String SQL_STATMENT = "select lineID from bus where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	public static void setDriver(int id, int driverID) throws SQLException {
		String SQL_STATMENT = "update bus set DriverID="+driverID+" where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	}
	
	public static ResultSet getDriver(int id) throws SQLException {
		String SQL_STATMENT = "select DriverID from bus where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	
	//////////////line query//////////////
	
	//////////////stations query//////////////
	public static void setStationName(int id, String name) throws SQLException {
		String SQL_STATMENT = "update busStations set stationName='"+name+"' where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	}
	
	public static ResultSet getStationName(int id) throws SQLException {
		String SQL_STATMENT = "select stationName from busStations where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	
	public static void setStationNumber(int oldid, int newid) throws SQLException {
		String SQL_STATMENT = "update busStations set id="+newid+" where id="+oldid;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	}
	
	public static void getStationAddress(int id, String addr) throws SQLException {
		String SQL_STATMENT = "update busStations set stationAddress='"+addr+"' where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	}
	
	public static ResultSet setStationAddress(int id) throws SQLException {
		String SQL_STATMENT = "select stationAddress from busStations where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	
	public static void setStationCoordinates(int id, float lat, float lon) throws SQLException {
		String SQL_STATMENT = "update busStations set lat="+lat+" and lon="+lon+" where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	}
	
	public static ResultSet getStationCoordinates(int id) throws SQLException {
		String SQL_STATMENT = "select lat,lon from busStations where id="+id;
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	
	
	////////////////old//////////////////////
	

	
//	public static ResultSet getStationsFromLine(int line) throws SQLException {
//		String SQL_STATMENT = "select stationsID from line where lineNumber="+line;
//		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
//		Statement statement = connection.createStatement();
//		ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
//		resultSet.next();
//		int[] stationsID = StringToIntegerArray(resultSet.getString(1).split("\\,")); 
//		int size = stationsID.length;
//		SQL_STATMENT = "select * from busStations where ";
//		for(int i=0; i<size; i++) {
//			if (i != 0){
//				SQL_STATMENT = SQL_STATMENT+"or ";
//			}
//			SQL_STATMENT=SQL_STATMENT+"id="+stationsID[i]+" ";
//		}
//		statement = connection.createStatement();
//		resultSet = statement.executeQuery(SQL_STATMENT);
//		//ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//		return resultSet;
//	}

	
}
