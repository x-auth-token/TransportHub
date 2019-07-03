
package com.pl.transporthub.transport;

import java.util.ArrayList;
import java.util.Vector;

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
	private ArrayList<int []> lines;
	
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
		setStationNumber(stationID);

	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public int getStationNumber() {
		return stationID;
	}
	public void setStationNumber(int stationNumber) {
		this.stationID = stationNumber;
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
	public ArrayList<int []> getLines() {
		return lines;
	}
	public void setLines(ArrayList<int []> lines) {
		this.lines = lines;
	}
	
	
	
}
