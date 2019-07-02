/**
 * 
 */
package de.htwberlin.ss19.prog2;

/**
 * @author abujaro
 *
 */
public class GeoLocation implements ILocation {

	private double latitude;
	private double longitude;
	
	public GeoLocation(double latitude, double longitude) {

		this.latitude = latitude;
		this.longitude = longitude;
	}


	@Override
	public String getLocation() {
		return "(" + latitude + ", " + longitude + ")";
	}

}
