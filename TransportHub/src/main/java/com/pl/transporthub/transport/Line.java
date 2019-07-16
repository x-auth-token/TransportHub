package com.pl.transporthub.transport;

import java.util.ArrayList;

public class Line {
	
	private enum lStatus{
		
		OPEN,
		TEMPORARELY_CLOSED,
		PERMANENTLY_CLOSED;
	}
	
	private int lineNumber;
	
	private lStatus lineStatus;
	
	private ArrayList<Station> stationIDs;
	
	private ArrayList<Bus> busIDs;

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public lStatus getLineStatus() {
		return lineStatus;
	}

	public void setLineStatus(lStatus lineStatus) {
		this.lineStatus = lineStatus;
	}

	public ArrayList<Station> getStationIDs() {
		return stationIDs;
	}

	public void setStationIDs(ArrayList<Station> stationIDs) {
		this.stationIDs = stationIDs;
	}

	public ArrayList<Bus> getBusIDs() {
		return busIDs;
	}

	public void setBusIDs(ArrayList<Bus> busIDs) {
		this.busIDs = busIDs;
	}
	
	
}
