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
	
	
}
