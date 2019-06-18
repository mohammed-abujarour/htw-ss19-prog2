/**
 * 
 */
package de.htwberlin.ss19.prog2;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * @author abujaro
 *
 */
public class Journey {

	private ILocation from;
	private ILocation to;
	private String time;
	private Driver driver;
	private ArrayList<Passenger> passengerList = new ArrayList<>();
	
	
	public Journey(ILocation from, ILocation to, String time, Driver driver) {
		this.from = from;
		this.to = to;
		this.time = time;
		this.driver = driver;
	}
	
	/**
	 * This method enables passengers to book seats in journeys.
	 * @param passenger: the passenger to be added to the journey
	 * @return true if the passenger gets a spot and false otherwise
	 */
	public boolean addPassenger(Passenger passenger) {
		
		return passengerList.add(passenger);
	}
	
	public String toString () {
		return this.from.getLocation() + ", " + this.to.getLocation() + ", " + this.time + ", " + this.driver  + ", " + passengerList;
	}
	
	public Driver getDriver() {
		return this.driver;
	}
}
