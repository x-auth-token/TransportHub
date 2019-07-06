/*******************************************************************************
 * Copyright (C) 2019 Pavel Mayzenberg, Leon Peper, Oded Levin
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package com.pl.transporthub.user;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.pl.transporthub.aaa.Permissions.Permission;

public abstract class User {

	private UUID userID;
	

	private String username;
	private char[] password;
	private List<Permission> permissions;
	private Date expirationDate;

	public User() {
		generateUserID();
		setUsername(null);
		setPassword(null);
		setPermissions(null);
		setExpirationDate(null);
	}

	public User(String un, char[] pass) {
		
		generateUserID();
		setUsername(un);
		setPassword(pass);
	}
	
	public User(String un, char[] pass, List<Permission> permissions ) {
		
		generateUserID();
		setUsername(un);
		setPassword(pass);
		setPermissions(permissions);		
	}
	
	public User(String un, char[] pass, List<Permission> permissions, Date experationDate ) {
		
		generateUserID();
		setUsername(un);
		setPassword(pass);
		setPermissions(permissions);
		setExpirationDate(expirationDate);
	}

	protected String getUsername() {
		return username;
	}

	protected void setUsername(String username) {
		this.username = username;
	}

	protected char[] getPassword() {
		return password;
	}

	protected void setPassword(char[] password) {
		this.password = password;
	}

	protected List<Permission> getPermissions() {
		return permissions;
	}

	protected void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public UUID getUserID() {
		return userID;
	}

	public void generateUserID() {
		this.userID = UUID.randomUUID();
	}
	
	/*
	 * private boolean resetPasswordSelf() {
	 * 
	 * if (vali) }
	 */

}
