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

public class Permissions {
	public enum Permission {

		/* Administrative Permissions */
		CREATE_USER, CHANGE_USER, DELETE_USER, VIEW_USER,

		CREATE_DRIVER, CHANGE_DRIVER, DELETE_DRIVER, VIEW_DRIVER,

		CREATE_PTM, CHANGE_PTM, DELETE_PTM, VIEW_PTM,

		CREATE_ADMIN, CHANGE_ADMIN, DELETE_ADMIN, VIEW_ADMIN,

		/* Application Permissions */

		CREATE_BUS, CHANGE_BUS, DELETE_BUS, VIEW_BUS,

		CREATE_LINE, CHANGE_LINE, DELETE_LINE, VIEW_LINE,

		CREATE_STATION, CHANGE_STATION, DELETE_STATION, VIEW_STATION,

		CREATE_ROUTE, CHANGE_ROUTE, DELETE_ROUTE, VIEW_ROUTE,

		CREATE_MAP, CHANGE_MAP, DELETE_MAP, VIEW_MAP;
	}
}