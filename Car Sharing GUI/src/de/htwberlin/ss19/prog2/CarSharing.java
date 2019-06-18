package de.htwberlin.ss19.prog2;

import javax.swing.JFrame;

import de.htwberlin.ss19.prog2.gui.CarSharingFrame;

public class CarSharing {

	public static void main(String[] args) {
		Car blueAudi= new Car("B-AB123", "Blue");
		
		ILocation berlin = new POILocation("Berlin");
		//ILocation potsdam = new POILocation("Potsdam");
		ILocation potsdam = new GeoLocation(20, 30);
		User jana = null;
		
		try {
			jana = new Passenger("Jana", Gender.Female, "+4915475525", 0);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		Driver max = null;
		try {
			max = new Driver("Max", Gender.Male, "+493545584", blueAudi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Journey berlinPotsdam = new Journey(berlin, potsdam, "08:00", max);
	
		boolean isJanaPassenger = jana instanceof Passenger;
		boolean isJanaDriver = jana instanceof Driver;
		boolean isJanaUser = jana instanceof User;


		CarSharingApp app = new CarSharingApp();
		System.out.println(app.getStats());
		app.addJourney(berlinPotsdam);
		System.out.println(app.getStats());
		app.addJourney(berlinPotsdam);
		System.out.println(app.getStats());
		
		JFrame carSharingFrame = new CarSharingFrame();
		carSharingFrame.setVisible(true);
		
		
	}
}
