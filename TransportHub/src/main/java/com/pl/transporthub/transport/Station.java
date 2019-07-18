
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
