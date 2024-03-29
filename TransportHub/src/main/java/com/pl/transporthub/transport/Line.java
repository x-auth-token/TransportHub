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

import java.util.ArrayList;



public class Line {
	
	private enum lStatus{
		
		OPEN,
		TEMPORARELY_CLOSED,
		PERMANENTLY_CLOSED;
	}
	
	
	private int lineID;
	
	private lStatus lineStatus;
	
	private ArrayList<Station> stations;
	
	private ArrayList<Bus> buses;
	
	public Line() {}
	
	public Line(int lineID) {
		this.lineID = lineID;
	}

	public int getLineID() {
		return lineID;
	}

	public void setLineNumber(int lineNumber) {
		this.lineID = lineNumber;
	}

	public lStatus getLineStatus() {
		return lineStatus;
	}

	public void setLineStatus(lStatus lineStatus) {
		this.lineStatus = lineStatus;
	}

	public ArrayList<Station> getStations() {
		return stations;
	}

	public void setStation(ArrayList<Station> stations) {
		this.stations = stations;
	}

	public ArrayList<Bus> getBuses() {
		return buses;
	}

	public void setBuses(ArrayList<Bus> buses) {
		this.buses = buses;
	}
	
	public String stationIDsToSQL() {
		String str = "";
		for(Station station:getStations()) {
			
			str += station.getStationID() + ",";
			
		}
		return str;	
	}
	
	public String busIDsToSQL() {
		String str = "";
		for(Bus bus:getBuses()) {
			
			str += bus.getBusID() + ",";
			
		}
		return str;	
	}
	
	public String statusToString(lStatus status) {
		switch(status) {
		case OPEN:
			return "OPEN";
			
		case TEMPORARELY_CLOSED:
			return "TEMPORARELY CLOSED";
			
		case PERMANENTLY_CLOSED:
			return "PERMANENTLY CLOSED";
			
		default:
			return null;
	}
	}
	
	
}
