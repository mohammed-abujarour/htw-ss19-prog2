/**
 * 
 */
package de.htwberlin.ss19.prog2;

/**
 * @author abujaro
 *
 */
public class Car {

	private String licensePlatNumber;
	private String color;
	
	public Car(String licensePlateNumber, String color) {
		this.licensePlatNumber = licensePlateNumber;
		this.color = color;
	}
	
	
	public String toString() {
		return licensePlatNumber + " - " + color;
	}
}
