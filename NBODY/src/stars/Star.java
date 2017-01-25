package stars;

import java.awt.Dimension;

public class Star extends Satellite {

	public Star(double _x, double _y, double velocity_x, double velocity_y, double my_mass, double my_radius,
			String name) {
		super(_x, _y, velocity_x, velocity_y, my_mass, my_radius, name);
	}

	/**
	 * Divide the radius of the star by the radius of the system and multiply by
	 * our constant multiplier which we decided by analysis to be such that with
	 * the default size, our sun has a size of 50.
	 */
	@Override
	protected void update_display_size(double radius_of_system) {
		this.GUIRadius = (int) ((this.radius / radius_of_system) * 61506);
		// System.out.println(radius);
		this.setSize(new Dimension(2 * this.GUIRadius, 2 * this.GUIRadius));
	}

}
