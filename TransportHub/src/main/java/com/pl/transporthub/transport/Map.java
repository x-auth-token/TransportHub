package com.pl.transporthub.transport;

import java.util.ArrayList;
import java.util.Iterator;


public class Map {
	
Station state = null;
Route rt = null;
ArrayList<Route> routes = null;
	
	Map(){
		
		createMap();
		generateRouts();
		printMap();
		printSpecificRoute(3);
	}
	
	
	
	
	public Station getState() {
		return state;
	}




	public void setState(Station state) {
		this.state = state;
	}




	public Route getRt() {
		return rt;
	}




	public void setRt(Route rt) {
		this.rt = rt;
	}




	public ArrayList<Route> getRoutes() {
		return routes;
	}




	public void setRoutes(ArrayList<Route> routes) {
		this.routes = routes;
	}




	void createMap() {
		
		this.routes = new ArrayList<Route>();
		
	}
	
	void generateRouts() {
		
		route1();
		route2();
		route3();
	}
	
	
	     void route3() {
		 // TODO Auto-generated method stub
	    	 
	    	 this.rt = new Route();
			 this.rt.createRoute();
			 this.getRt().setIndex(3);
			 
			 this.state = new Station();
			 this.state.setNum_of_station(2);
			 this.state.setName("rrr");
		     this.rt.getRoute().add(state);
		        
		     this.state = new Station();
			 this.state.setNum_of_station(3);
			 this.state.setName("ppp");
		     this.rt.getRoute().add(state);
		     
		     this.state = new Station();
			 this.state.setNum_of_station(5);
			 this.state.setName("ddd");
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
			 this.state.setNum_of_station(14);
			 this.state.setName("yyy");
		     this.rt.getRoute().add(state);
		     
		     this.getRoutes().add(getRt());
		
	     }



	     void route2() {
		 // TODO Auto-generated method stub
		 
		 this.rt = new Route();
		 this.rt.createRoute();
		 this.getRt().setIndex(2);
		 
		 this.state = new Station();
		 this.state.setNum_of_station(1);
		 this.state.setName("ccc");
	     this.rt.getRoute().add(state);
	        
	     this.state = new Station();
		 this.state.setNum_of_station(3);
		 this.state.setName("ppp");
	     this.rt.getRoute().add(state);
	     
	     this.state = new Station();
		 this.state.setNum_of_station(10);
		 this.state.setName("qqq");
	     this.rt.getRoute().add(state);
	        
	     this.state = new Station();
		 this.state.setNum_of_station(11);
		 this.state.setName("hhh");
	     this.rt.getRoute().add(state);
	        
	     this.state = new Station();
		 this.state.setNum_of_station(16);
		 this.state.setName("vvv");
	     this.rt.getRoute().add(state);
		
	     this.getRoutes().add(getRt());
		
	}


	  

	//initialize for example
	void route1() {
		
		 this.rt = new Route();
		 this.rt.createRoute();
		 this.getRt().setIndex(1);
		
	    this.state = new Station();
	    this.state.setNum_of_station(0);
	    this.state.setName("aaa");
	    this.state.setPrice(0);
        this.rt.getRoute().add(state);
	    
		this.state = new Station();
	    this.state.setNum_of_station(4);
	    this.state.setName("xxx");
	    this.state.setPrice(5);
		this.rt.getRoute().add(state);
		
		this.state = new Station();
	    this.state.setNum_of_station(6);
	    this.state.setName("kkk");
	    this.state.setPrice(7);
		this.rt.getRoute().add(state);
		
		this.state = new Station();
	    this.state.setNum_of_station(7);
	    this.state.setName("bbb");
	    this.state.setPrice(5);
		this.rt.getRoute().add(state);
		
		this.state = new Station();
	    this.state.setNum_of_station(12);
	    this.state.setName("zzz");
	    this.state.setPrice(3);
		this.rt.getRoute().add(state);
		
		this.state = new Station();
	    this.state.setNum_of_station(13);
	    this.state.setName("fff");
	    this.state.setPrice(10);
		this.rt.getRoute().add(state);
		
		this.getRoutes().add(getRt());
		
	}
	
	
	
	void printSpecificRoute(int key) {
		
		Iterator<Route> iterRoutes = this.getRoutes().iterator();
		
		while (iterRoutes.hasNext()) {
			if(iterRoutes.next().getIndex() == key) {
					
		
			}
		}
	}
	
	void printMap() {
		
		for(int i=0 ; i<this.getRoutes().size() ; i++) {
			
			for(int j=0; j<this.getRoutes().get(i).getRoute().size(); j++) {
				
				System.out.println(this.getRoutes().get(i).getRoute().get(j).getNum_of_station());
			}
			
		}
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map m = new Map();
		

	}

}