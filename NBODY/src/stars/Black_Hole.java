package stars;

import java.awt.Dimension;

public class Black_Hole extends Satellite {

	public Black_Hole(double _x, double _y, double my_mass, String name) {
		super(_x, _y, my_mass, name);
	}

	@Override
	protected void update_display_size(double radius_of_system) {
		this.setSize(new Dimension(10,10));
	}

}
