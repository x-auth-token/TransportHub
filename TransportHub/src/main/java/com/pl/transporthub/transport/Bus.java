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
package com.pl.transporthub.transport;

public class Bus {
	
	private int busID;
	private String busRegPlate;
	private Line assignedLine;
	
	private int assignedDriverID;
	
	private enum bCondition {
		FUNCTIONAL,
		DAMAGED,
		AT_DEPOT;
	}
	
	private bCondition busCondition;
	
	public Bus() {
		
	}
	
	public int getBusID() {
		return busID;
	}

	public void setBusID(int busID) {
		this.busID = busID;
	}

	public String getBusRegPlate() {
		return busRegPlate;
	}

	public void setBusRegPlate(String busRegPlate) {
		this.busRegPlate = busRegPlate;
	}

	public Line getAssignedLine() {
		return assignedLine;
	}

	public void setAssignedLine(Line assignedLine) {
		this.assignedLine = assignedLine;
	}

	public bCondition getBusCondition() {
		return busCondition;
	}

	public void setBusCondition(bCondition busCondition) {
		this.busCondition = busCondition;
	}

	/**
	 * @return the assignedDriverID
	 */
	public int getAssignedDriverID() {
		return assignedDriverID;
	}

	/**
	 * @param assignedDriverID the assignedDriverID to set
	 */
	public void setAssignedDriverID(int assignedDriverID) {
		this.assignedDriverID = assignedDriverID;
	}

	

}
