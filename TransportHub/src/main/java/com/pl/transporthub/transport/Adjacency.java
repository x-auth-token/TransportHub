package com.pl.transporthub.transport;

public class Adjacency {
	
	Integer[][] adj = null;
	
	Adjacency(){
		
	}
	
	void createAdj(int numOfStasions) {
		
		this.adj = new  Integer[numOfStasions][numOfStasions];
		
	}

	public Integer[][] getAdj() {
		return adj;
	}

	public void setAdj(Integer[][] adj) {
		this.adj = adj;
	}
	
	
	
	
	void init_adjValues() {
		
		for(int i=0; i<this.getAdj().length; i++) {
			
			for(int j=0; j<this.getAdj().length; j++) {
				
				
			}
		}
		
	}
	

}

