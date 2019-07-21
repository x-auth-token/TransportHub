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

import java.time.LocalDate;


public class UserFactory {


	public static User getUser(String uType, String uName, String password,
			LocalDate expirationDate) {

		if ("Admin".equalsIgnoreCase(uType)) { return new
				Admin(uName, password, expirationDate, true); } else if
		("Passenger".equalsIgnoreCase(uType)) { return new Passenger(uName, password,
				expirationDate, false); } else if ("Driver".equalsIgnoreCase(uType) ) {
					return new Driver(uName, password, expirationDate, false); } else if
		("PTM".equalsIgnoreCase(uType)) { return new PublicTransportManager(uName,
				password, expirationDate, false); }

		return null; }


}
