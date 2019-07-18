package com.pl.transporthub.util.db;

public class Test {
	
	public static void main(String[] args) {
		
		String fName = "Test_DB_Folder";
		String dbName = "Test_DB.sqlite";
		
		DatabaseController dbc = new DatabaseController(fName, dbName);
		dbc.start();
	
	}
}
