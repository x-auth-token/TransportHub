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
import java.util.Set;

import com.pl.transporthub.aaa.Permission;

public class AuthenticatedUser extends User {
	
	protected Set<Permission> permissions;

	/*
	 * public AuthenticatedUser() { super(); }
	 * 
	 * public AuthenticatedUser(String un, char[] pass, boolean adminValue) {
	 * super(un, pass, adminValue);
	 * 
	 * }
	 */

	public AuthenticatedUser(String un, char[] pass, Date expirationDate, boolean adminValue) {
		super(un, pass, expirationDate, adminValue);

	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void addPermissions(Permission permissions) {
		this.permissions.add(permissions);
	}
	
	public boolean hasPermission(Permission permission) {
		return this.permissions.contains(permission);
	}
	
	public void removePermission(Permission permission) {
		this.permissions.remove(permission);
	}
	
}
