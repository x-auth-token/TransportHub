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
import java.util.UUID;


public abstract class User {

	private UUID userID;
	

	private String username;
	private char[] password;
	
	private Date expirationDate;
	private boolean enabled;

	public User() {
		generateUserID();
		setUsername(null);
		setPassword(null);
		setExpirationDate(null);
	}

	public User(String un, char[] pass) {
		
		generateUserID();
		setUsername(un);
		setPassword(pass);
	}
	
	
	public User(String un, char[] pass, Date expirationDate ) {
		
		generateUserID();
		setUsername(un);
		setPassword(pass);
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
	
	public boolean isEnabled() {
		return this.enabled;
	}
	
	public void setEnabled() {
		this.enabled = true;
	}
	
	public void setDisabled() {
		this.enabled = false;
	}
}
