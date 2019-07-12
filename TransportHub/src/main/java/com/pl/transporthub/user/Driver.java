package com.pl.transporthub.user;

import java.util.Date;
import java.util.List;

import com.pl.transporthub.aaa.Permission;

public class Driver extends AuthenticatedUser {

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Driver(String un, char[] pass, List<Permission> permissions, Date expirationDate) {
		super(un, pass, permissions, expirationDate);
		// TODO Auto-generated constructor stub
	}

	public Driver(String un, char[] pass, List<Permission> permissions) {
		super(un, pass, permissions);
		// TODO Auto-generated constructor stub
	}

	
	
}
