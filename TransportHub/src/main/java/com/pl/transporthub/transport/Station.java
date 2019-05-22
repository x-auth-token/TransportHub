package com.pl.transporthub.transport;

public class Station {

	int num_of_station = 0;
	String name = null;
	int price = 0;
	
	
	Station(){
		
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getNum_of_station() {
		return num_of_station;
	}


	public void setNum_of_station(int num_of_station) {
		this.num_of_station = num_of_station;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
