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
import com.pl.transporthub.shared.classes.Coordinate;

public class Station {

	private enum  sState{
		OPEN,
		TEMPORARELY_CLOSED,
		PERMANENTLY_CLOSED;
	} 
	
	private String stationName;
	private int stationID;
	private String stationAddress;
	private Coordinate stationCoordinates;
	private ArrayList<Line> lines;
	
	private sState stationState;
	
	
	public sState getStationState() {
		return stationState;
	}

	public void setStationState(sState stationState) {
		this.stationState = stationState;
	}

	public Station() {
		
	}
	
	public Station(String sName, int sNumber, String sAddr, Coordinate sCoordinates) {
		setStationName(sName);
		setStationAddress(sAddr);
		setStationID(stationID);

	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public int getStationID() {
		return stationID;
	}
	public void setStationID(int stationID) {
		this.stationID = stationID;
	}
	public String getStationAddress() {
		return stationAddress;
	}
	public void setStationAddress(String stationAddress) {
		this.stationAddress = stationAddress;
	}
	public Coordinate getStationCoordinates() {
		return stationCoordinates;
	}
	public void setStationCoordinates(Coordinate stationCoordinates) {
		this.stationCoordinates = stationCoordinates;
	}
	public ArrayList<Line> getLines() {
		return lines;
	}
	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	}
	
	public String lineIDsToSQL() {
		String str = "";
		for(Line line:getLines()) {
			
			str += line.getLineID() + ",";
			
		}
		return str;	
	}
	
}
