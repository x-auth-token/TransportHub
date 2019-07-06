package com.pl.transporthub.user;

import java.util.Date;
import java.util.List;

import com.pl.transporthub.aaa.Permissions.Permission;

public class Driver extends User {

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Driver(String un, char[] pass, List<Permission> permissions, Date experationDate) {
		super(un, pass, permissions, experationDate);
		// TODO Auto-generated constructor stub
	}

	public Driver(String un, char[] pass, List<Permission> permissions) {
		super(un, pass, permissions);
		// TODO Auto-generated constructor stub
	}

	public Driver(String un, char[] pass) {
		super(un, pass);
		// TODO Auto-generated constructor stub
	}

	
	
}
