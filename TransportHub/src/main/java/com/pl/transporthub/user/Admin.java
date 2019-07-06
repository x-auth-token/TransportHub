package com.pl.transporthub.user;

import java.util.Date;
import java.util.List;

import com.pl.transporthub.aaa.Permissions.Permission;

public class Admin extends User {

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String un, char[] pass, List<Permission> permissions, Date experationDate) {
		super(un, pass, permissions, experationDate);
		// TODO Auto-generated constructor stub
	}

	public Admin(String un, char[] pass, List<Permission> permissions) {
		super(un, pass, permissions);
		// TODO Auto-generated constructor stub
	}

	public Admin(String un, char[] pass) {
		super(un, pass);
		// TODO Auto-generated constructor stub
	}


	
	
	
}
