/**
 * 
 */
package de.htwberlin.ss19.prog2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import de.htwberlin.ss19.prog2.Car;
import de.htwberlin.ss19.prog2.CarSharingApp;
import de.htwberlin.ss19.prog2.Driver;
import de.htwberlin.ss19.prog2.Gender;
import de.htwberlin.ss19.prog2.ILocation;
import de.htwberlin.ss19.prog2.Journey;
import de.htwberlin.ss19.prog2.POILocation;

/**
 * @author s0568845
 *
 */
public class PerformanceManager {

	private static final int MAX_SIZE = 19999999;

	public static void main(String[] args) {

		HashMap <Car, Integer> carMap = new HashMap<>();
		Car blueAudi = new Car("B-A12", "Blue");
		carMap.put(blueAudi , 10);
		
		carMap.put(blueAudi , 20);

		carMap.get(blueAudi);
		System.out.println(carMap);
		
		if(true) return;
		measureCreatPerformance();
		System.out.println();
		try {
			measureSearchPerformance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void measureSearchPerformance() throws Exception {
		CarSharingApp app = new CarSharingApp();

		ILocation from = new POILocation("Location1");
		ILocation to = new POILocation("Location2");
		String time = System.currentTimeMillis() + "";
		Driver driver = new Driver("Max", Gender.Male, "000", new Car("B", "Black"));

		for (int i = 0; i < MAX_SIZE; i++)
			app.addJourney(new Journey(from, to, time, driver));

		long start = System.currentTimeMillis();
		
		int number = app.findNumberOfJourneys(driver);
		long middle = System.currentTimeMillis();
		
		int number2 = app.getJourneysOfDriverFromList(driver);

		long end = System.currentTimeMillis();

		System.out.println(end - middle + " Ms Abfrage über ArrayList");
		System.out.println(middle - start + " Ms Abfrage über HashMap");

	}

	private static void measureCreatPerformance() {
		ArrayList<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();

		long beforeList = System.currentTimeMillis();
		
		for (int i = 0; i < MAX_SIZE; i++) {
			list.add(i);
		}
		
		long afterList = System.currentTimeMillis();
		
		long durationList = afterList - beforeList;
		
		System.out.println(durationList + " MS for creating a List");

		long beforeMap = System.currentTimeMillis();
		for (int i = 0; i < MAX_SIZE; i++) {
			map.put(i, i + 1);
		}
		
		long afterMap = System.currentTimeMillis();
		long durationMap = afterMap - beforeMap;
		System.out.println(durationMap + " MS for creating a Map");

		LinkedList<Integer> linkedList = new LinkedList<>();
		for(int j=0; j < MAX_SIZE; j++)
			linkedList.add(j);
		
		long afterLinkedList = System.currentTimeMillis();
		long durationLinkedList = afterLinkedList - afterMap;
		System.out.println(durationLinkedList + " MS for creating a LinkedList");

		

	}

}
