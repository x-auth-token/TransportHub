package com.pl.transporthub.util.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryDB {
	public static final String SQL_STATMENT = "select * from line";
	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int columnCount = resultSetMetaData.getColumnCount();
		for (int i = 1; i<= columnCount; i++) System.out.format("%20s",resultSetMetaData.getColumnName(i)+" | ");
		while (resultSet.next()) {
			System.out.println("");
			for (int i = 1; i <= columnCount; i++) System.out.format("%20s",resultSet.getString(i)+" | ");
		}
		if (statement != null) statement.close();
		if (connection != null) connection.close();
	}

}
