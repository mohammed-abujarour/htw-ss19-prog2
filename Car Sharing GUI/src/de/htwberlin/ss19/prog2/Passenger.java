/**
 * 
 */
package de.htwberlin.ss19.prog2;

/**
 * @author abujaro
 *
 */
public class Passenger extends User {
	
	private long points;
	
	public Passenger(String name, Gender gender, String mobileNumber, long points) throws Exception {
		super(name, gender, mobileNumber);
		this.points = points;
	}
	
	public long getPoints() {
		return this.points;
	}
	
	public String toString() {
		String userRep = super.toString();
		
		return userRep + ", " + this.points;
				
	}
	

}
