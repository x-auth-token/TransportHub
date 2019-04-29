package com.pl.transporthub.util.db;

import java.sql.*;

import java.io.*;

abstract class DataBase {
	
	public String url = "";
	private String driverName = "";
	private Connection connection = null;
	private Statement statement = null;
	private int timeout = 30;
	
	
	public DataBase() {
		
	}
	
	public DataBase(String driverName, String url) throws Exception {
		initialize(driverName, url);
	}


	public void initialize(String driverName, String url) throws Exception {
		setDriverName(driverName);
		setUrl(url);
		setStatement();
		setConnection();
	}
	
	
	//public SQLiteJDBC
	/*
	 * public static void createNewDatabase(String folderName, String filename) {
	 * 
	 * File folder = new File(folderName);
	 * 
	 * if (!folder.exists()) folder.mkdirs();
	 * 
	 * String url = "jdbc:sqlite:" + folder.getAbsolutePath() + File.separator +
	 * filename;
	 * 
	 * try (Connection conn = DriverManager.getConnection(url)){ if (conn != null) {
	 * DatabaseMetaData meta = conn.getMetaData();
	 * System.out.println("Opened database successfully"); } } catch (SQLException
	 * e) { System.out.println(e.getMessage()); } }
	 */
	
	public static void connect(String url) {
		
		//try
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}


	public Connection getConnection() {
		return connection;
	}

	public void setConnection() throws Exception {
		Class.forName(driverName);
		this.connection = DriverManager.getConnection(this.url);
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement() throws Exception {
		if (this.connection == null)
			setConnection();
		this.statement = connection.createStatement();
		this.statement.setQueryTimeout(timeout);
	}

	public void executeStatement(String sql) throws Exception {
		statement.executeUpdate(sql);
	}
	
}
