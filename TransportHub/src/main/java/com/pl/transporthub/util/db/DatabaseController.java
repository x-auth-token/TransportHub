package com.pl.transporthub.util.db;

import java.sql.SQLException;

public class DatabaseController {
	private final String dbFolderName = "DB";
	private final String dbName = "TransportHub";
	
	private SQLiteJDBC sqliteConnection;
	
	public DatabaseController() {}
	
	/*
	 * public DatabaseController(String dbFolderName, String dbName) {
	 * this.dbFolderName = dbFolderName; this.dbName = dbName;
	 * 
	 * }
	 */

	public void start() {
		try {
			sqliteConnection = new SQLiteJDBC(dbFolderName, dbName);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @return the dbFolderName
	 */
	public String getDbFolderName() {
		return dbFolderName;
	}

	/**
	 * @param dbFolderName the dbFolderName to set
	 */
	/*
	 * public void setDbFolderName(String dbFolderName) { this.dbFolderName =
	 * dbFolderName; }
	 */

	/**
	 * @return the dbName
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * @param dbName the dbName to set
	 */
	/*
	 * public void setDbName(String dbName) { this.dbName = dbName; }
	 */

	/**
	 * @return the sqliteConnection
	 */
	public SQLiteJDBC getSqliteConnection() {
		return sqliteConnection;
	}

	/**
	 * @param sqliteConnection the sqliteConnection to set
	 */
	public void setSqliteConnection(SQLiteJDBC sqliteConnection) {
		this.sqliteConnection = sqliteConnection;
	}
	
	public void first_run() {
		try {
			SQLiteJDBC.parseSqlFromScript();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
