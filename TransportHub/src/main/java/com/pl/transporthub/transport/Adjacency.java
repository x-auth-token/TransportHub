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

	private void setAdj(Integer x, Integer y) {
		this.adj[x][y] = 1;
	}
	
	
	
	
	void init_adjValues() {
		
		this.createAdj(17);
		
		this.setAdj(0, 4);
		this.setAdj(1, 3);
		this.setAdj(1, 4);
		this.setAdj(2, 3);
		this.setAdj(3, 5);
		this.setAdj(3, 10);
		this.setAdj(4, 6);
		this.setAdj(4, 5);
		this.setAdj(5, 8);
		this.setAdj(5, 7);
		this.setAdj(6, 7);
		this.setAdj(7, 12);
		this.setAdj(8, 9);
		this.setAdj(9, 15);
		this.setAdj(10, 11);
		this.setAdj(11, 9);
		this.setAdj(11, 16);
		this.setAdj(12, 13);
		this.setAdj(12, 14);
		
		
		
	}
	

}

