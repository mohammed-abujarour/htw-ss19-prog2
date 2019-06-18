/**
 * 
 */
package de.htwberlin.ss19.prog2;

/**
 * @author abujaro
 *
 */
public class POILocation implements ILocation {
	private String label;
	
	public POILocation(String label) {
		this.label = label;
	}
	
	
	public String toString() {
		return this.label;
	}


	@Override
	public String getLocation() {
		return this.label;
	}
}
