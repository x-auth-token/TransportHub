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

	public Connection getConnection() {
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




