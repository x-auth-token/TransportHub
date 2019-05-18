package com.pl.transporthub.transport;

public class City {
	
	//Route[][] routs = null;
	Station[][] routs = null;
	Integer[] arr = null;

	void initRoutsCluster(Route rt) {
		
		this.routs = new Station[this.getArr().length][];
	    setArr();
		
		for(int i=0; i<this.getArr().length ; i++) {
			
			this.routs[i] = new Station[this.getArr()[i]];
			
			//for(int j=0; j<this.getArr()[i]; j++) {
				
				//this.routs[i][j].createStation();
			//}
		}
		
	}
	
	//Initialized a cluster that every element is number of stations
		// in specific route.
		void setArr() {
			
			this.arr = new Integer[] {5, 10, 8, 13, 7, 7, 11, 10, 15, 12};
		}
		
		Integer[] getArr() {
			
			return this.arr;
		}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
