package stars;

import java.awt.Dimension;

public class Planet extends Satellite {

	public Planet(double _x, double _y, double velocity_x, double velocity_y, double my_mass, double my_radius,
			String name) {
		super(_x, _y, velocity_x, velocity_y, my_mass, my_radius, name);
	}

	@Override
	protected void update_display_size(double radius_of_system) {
		this.setSize(new Dimension(30,30));
	}

}
