/**
 * 
 */
package de.htwberlin.ss19.prog2;

/**
 * @author abujaro
 *
 */
public abstract class User {

	private String name;
	private Gender gender;
	private String mobileNumber;
	
	
	public User(String name, Gender gender, String mobileNumber) throws Exception{
		if(name == null)
			throw new Exception("Name cannot be null");
		
		this.name = name;
		
		this.gender = gender;
		this.mobileNumber = mobileNumber;
	}
	
	
	public String toString() {
		return this.name + ", " + this.gender + ", " + this.mobileNumber;
	}
}
