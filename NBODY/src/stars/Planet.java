//Mark Van der Merwe and Tarun Sunkaraneni
package stars;

import java.awt.Dimension;

/**
 * Planet class used to create the planets of our solar system and to scale them
 * correctly.
 * 
 * @author markvandermerwe
 *
 */
public class Planet extends Satellite {

	/**
	 * See Satellite for details.
	 */
	public Planet(double _x, double _y, double velocity_x, double velocity_y, double my_mass, double my_radius,
			String name) {
		// all the attribute setting is handled by satellite
		super(_x, _y, velocity_x, velocity_y, my_mass, my_radius, name);
	}

	/**
	 * Overridden display scaler uses the radius of the system to determine the
	 * size the planets should do. We have two cases so that jupiter isn't too
	 * big and mercury isn't too small (and all the other ones look good too).
	 */
	@Override
	protected void update_display_size(double radius_of_system) {
		// the radius of the planet is scaled differently accordingly to size.

		// Case 1: the planet is as big as the size of the earth or smaller
		if (this.radius > Solar_System_Facts.earth_radius) {
			this.GUIRadius = (int) ((this.radius / radius_of_system) * 280_000);
			this.setSize(new Dimension(2 * this.GUIRadius, 2 * this.GUIRadius));
		}
		// Case 2: the planet is anything bigger than the size of the earth.
		else {
			this.GUIRadius = (int) ((this.radius / radius_of_system) * 1_600_000);
			this.setSize(new Dimension(2 * this.GUIRadius, 2 * this.GUIRadius));
		}
	}
}
