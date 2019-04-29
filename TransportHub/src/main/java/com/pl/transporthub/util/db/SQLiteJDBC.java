package com.pl.transporthub.util.db;

import java.io.File;

public class SQLiteJDBC extends DataBase {

	private String driverName = "jdbc:sqlite:";
	
	public SQLiteJDBC() {
		
		
	}
	
	public SQLiteJDBC(String url) throws Exception {
		initialize(this.driverName, url);
	}
	
	public SQLiteJDBC(String folderName, String databaseFileName) throws Exception {
		
		String url = "";
	
		
		File folder = new File(folderName);
		
		if (!folder.exists())
			folder.mkdirs();
		
		url = getDriverName() + folder.getAbsolutePath() + File.separator + databaseFileName;
		
		initialize(driverName, url);
		
	}
	
	
}
