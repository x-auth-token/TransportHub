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
package com.pl.transporthub.aaa;

public abstract class Permissions {

	private Permissions() {
	};

	public enum Permission {
		ANONYMOUS, AUTHPASSANGER, DRIVER, PTM, ADMIN
	}

	public static Permission toPermission(String permission) {

		switch (permission.toUpperCase()) {
		case "ANONYMOUS":
			return Permission.ANONYMOUS;
		case "AUTHPASSANGER":
			return Permission.AUTHPASSANGER;
		case "DRIVER":
			return Permission.DRIVER;
		case "PTM":
			return Permission.PTM;
		case "ADMIN":
			return Permission.ADMIN;
		default:
			return null;
		}

	}
}
