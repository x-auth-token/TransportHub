/*******************************************************************************
 * Copyright (C) 2019 Pavel Mayzenberg, Leon Peper, Oded Levin
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
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

	public bCondition intToEnum(int condition) {
		switch(condition) {
			case 0:
				return bCondition.FUNCTIONAL;
				
			case 1:
				return bCondition.DAMAGED;
				
			case 2:
				return bCondition.AT_DEPOT;
				
			default:
				return null;
		}
	}
	
	public String toString(bCondition condition) {
		switch(condition) {
		case FUNCTIONAL:
			return "FUNCTIONAL";
			
		case DAMAGED:
			return "DAMAGED";
			
		case AT_DEPOT:
			return "AT DEPOT";
			
		default:
			return null;
	}
	}
}
