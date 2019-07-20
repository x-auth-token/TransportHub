/*******************************************************************************
 * Copyright (C) 2019 Pavel Mayzenberg, Leon Peper, Oded Levin
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package com.pl.transporthub.util.db;

import java.sql.*;


import java.io.*;

public abstract class DataBase {

	public static String url = "";
	private static String driverName = "";
	private static Connection connection = null;
	private static Statement statement = null;
	private static int timeout = 30;

	public DataBase() {

	}

	public DataBase(String driverName, String url) throws Exception {
		initialize(driverName, url);
	}

	protected static void initialize(String driverName, String url) throws Exception {
		setDriverName(driverName);
		setUrl(url);
		createStatement();
		connect();
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String u) {
		url = u;
	}

	public static String getDriverName() {
		return driverName;
	}

	public static void setDriverName(String dName) {
		driverName = dName;
	}

	public static Connection getConnection() {
		return connection;
	}

	private static void connect() throws ClassNotFoundException, SQLException {
		//Class.forName(driverName);
		connection = DriverManager.getConnection(url);
	}

	public Statement getStatement() {
		return statement;
	}
	
	
	
	/**
	 * @return the timeout
	 */
	public static int getTimeout() {
		return timeout;
	}

	/**
	 * @param timeout the timeout to set
	 */
	public static void setTimeout(int timeout) {
		DataBase.timeout = timeout;
	}

	/**
	 * @param connection the connection to set
	 */
	public static void setConnection(Connection connection) {
		DataBase.connection = connection;
	}

	/**
	 * @param statement the statement to set
	 */
	public static void setStatement(Statement statement) {
		DataBase.statement = statement;
	}

	private static void createStatement() throws Exception {
		if (connection == null)
			connect();
		statement = connection.createStatement();
		statement.setQueryTimeout(timeout);
	}

	public void executeStatement(String sql) throws SQLException {
		try {
			createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		statement.executeUpdate(sql);
		statement.close();
	}

	public void executeStatement(File file) throws SQLException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String sql = reader.readLine();
		while (sql != null) {
			executeStatement(sql);
		}
		reader.close();
	}

	public ResultSet executeQuery(String query) throws SQLException {
		try {
			createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statement.executeQuery(query);
	}
	
	//public void insert(String)
}




