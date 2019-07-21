package com.pl.transporthub.util.db;

import com.pl.transporthub.user.Admin;
import com.pl.transporthub.user.UserRepository;

public class Test {
	
	public static void main(String[] args) {
		
		String fName = "db";
		String dbName = "Users";
		
		UserRepository rp = new UserRepository();
		Admin adm = new Admin();
		
		
		DatabaseController dbc = new DatabaseController(fName, dbName);
		dbc.start();
		
		adm.setUsername("admin");
		rp.getUserRole("admin");
		rp.getUserPassword("admin");
	
	
	}
}
