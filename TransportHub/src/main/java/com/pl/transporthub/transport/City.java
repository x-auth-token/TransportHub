/*******************************************************************************
 * Copyright (C) 2019 Pavel Mayzenberg, Leon Peper, Oded Levin
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
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
