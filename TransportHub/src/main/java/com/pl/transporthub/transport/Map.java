package com.pl.transporthub.transport;

import java.util.ArrayList;
import java.util.Vector;


public class Map {
	
Station state = null;
Route rt = null;	
	
	Map(){
		
	 parametisizeStations();
	 printMap();
	}
	
	
	
	//initialize for example
	void parametisizeStations() {
		
		this.rt = new Route();
		this.rt.createRoute();
		
	    this.state = new Station();
	    this.state.setNum_of_station(0);
	    this.state.setName("aaa");
        this.rt.getRoute().add(state);
	    
		this.state = new Station();
	    this.state.setNum_of_station(4);
	    this.state.setName("xxx");
		this.rt.getRoute().add(state);
		
		this.state = new Station();
	    this.state.setNum_of_station(6);
	    this.state.setName("kkk");
		this.rt.getRoute().add(state);
		
		this.state = new Station();
	    this.state.setNum_of_station(7);
	    this.state.setName("bbb");
		this.rt.getRoute().add(state);
		
		this.state = new Station();
	    this.state.setNum_of_station(12);
	    this.state.setName("zzz");
		this.rt.getRoute().add(state);
		
		this.state = new Station();
	    this.state.setNum_of_station(0);
	    this.state.setName("aaa");
		this.rt.getRoute().add(state);
		
	}
	
	
	
	void printMap() {
		
		for(int i=0 ; i<this.rt.getRoute().size() ; i++) {
			
			System.out.println(this.rt.getRoute().get(i).name);
		}
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map m = new Map();
		

	}

}
