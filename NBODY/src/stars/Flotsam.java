package stars;

import java.awt.Dimension;

public class Flotsam extends Satellite {

	public Flotsam(int _x, int _y, int _xVelocity, int _yVelocity) {
		super(_x, _y, _xVelocity, _yVelocity);
	}

	@Override
	protected void update_display_size(double radius_of_system) {
		this.setSize(new Dimension((int) (radius_of_system*2),(int) (radius_of_system*2)));
	}

}
