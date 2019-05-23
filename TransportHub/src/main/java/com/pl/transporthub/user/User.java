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

import java.util.List;

import com.pl.transporthub.aaa.Permissions;
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
