/**
 * 
 */
package de.htwberlin.ss19.prog2;

/**
 * @author abujaro
 *
 */
public class Driver extends User{
	
	private Car car;
	
	public Driver(String name, Gender gender, String mobileNumber, Car car) throws Exception{
		super(name, gender, mobileNumber);
		this.car = car;
	}
	
	public Car getCar() {
		return this.car;
	}
	
	public String toString() {
		
		String userRepresentation = super.toString();
		return userRepresentation + ", " + this.car;
	}
}
