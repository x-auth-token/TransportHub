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
	
	
}
