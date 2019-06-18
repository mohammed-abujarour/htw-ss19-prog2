package de.htwberlin.ss19.prog2;

import java.util.ArrayList;
import java.util.HashMap;


public class CarSharingApp {

	private ArrayList<Journey> journeys = new ArrayList<>();
	private HashMap<Driver, Integer> stats = new HashMap<>();
	private ArrayList<User> users = new ArrayList<>();
	
	public boolean addJourney(Journey journey) {
		int previousJourneys = 0;
		
		if(stats.containsKey(journey.getDriver()))
			previousJourneys = stats.get(journey.getDriver());
				
		stats.put(journey.getDriver(), previousJourneys + 1);
		
		return this.journeys.add(journey);
	}
	
	
	public int findNumberOfJourneys(Driver driver) {
		int count = 0;
		
		count = stats.get(driver);

		return count;
	}
	
	public boolean addUser (User user) {
		return this.users.add(user);
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public int getJourneysOfDriverFromList(Driver driver) {
		int count = 0;
		for(Journey journey: journeys) {
			if(journey.getDriver().equals(driver))
				count++;
		}
		return count;
	}
	
	public HashMap<Driver, Integer> getStats(){
		return stats;
	}
	

}
