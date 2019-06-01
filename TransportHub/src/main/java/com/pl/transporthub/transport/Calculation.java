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

import java.util.ArrayList;


public class Calculation {

final int MAX=50;
int min=0;
int numOfRoute=0;



public int getMin() {
	return min;
}



public void setMin(int min) {
	this.min = min;
}



public int getNumOfRoute() {
	return numOfRoute;
}



public void setNumOfRoute(int numOfRoute) {
	this.numOfRoute = numOfRoute;
}



public int getMAX() {
	return MAX;
}



void bestRoutePrice(int source, int target, ArrayList<Route> routes) {
		
		int totalPrice=0;
		this.setMin(getMAX());
		
		for(int i=0 ; i<routes.size() ; i++) {
			
			for(int j=0; j<routes.get(i).getRoute().size(); j++) {
				
				if(routes.get(i).getRoute().get(j).getNum_of_station() == source) 
				{
					
					while(routes.get(i).getRoute().get(j).getNum_of_station() != target) 
					{
						totalPrice += routes.get(i).getRoute().get(j).getPrice();
						j++;
					}
					
					//adding price to the last station
					totalPrice += routes.get(i).getRoute().get(j).getPrice();
				}
				
				if(totalPrice < this.getMin())
				{
					this.setMin(totalPrice);
				}
			}
		}
		
		
	}

}
