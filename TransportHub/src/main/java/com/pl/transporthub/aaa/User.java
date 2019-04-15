package com.pl.transporthub.aaa;

import java.util.List;
import java.util.UUID;

import com.pl.transporthub.common.crypto.*;
import com.pl.transporthub.aaa.Permissions.Permission;



public abstract class User {
	
	private String username;
	private String password;
	private List<Permission> permissions;
	
	
	public User(String un) {
		setUsername(null);
		setPassword(null);
		setPermissions(null);
	}
	public User(String un, String pass) {
		
		setUsername(un);
		setPassword(pass);
		setPermissions(null);
	}
	
	protected String getUsername() {
		return username;
	}
	protected void setUsername(String username) {
		this.username = username;
	}
	protected String getPassword() {
		return password;
	}
	protected void setPassword(String password) {
		this.password = password;
	}
	protected List<Permission> getPermissions() {
		return permissions;
	}
	protected void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	

	
	
	
	
}
