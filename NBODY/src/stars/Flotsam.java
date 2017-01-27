package stars;

import java.awt.Color;
import java.awt.Dimension;

public class Flotsam extends Satellite {

	public Flotsam(int _x, int _y, int _xVelocity, int _yVelocity) {
		super(_x, _y, _xVelocity, _yVelocity);
		this.setForeground(Color.GRAY);
		this.mass = 1_000_000_000;// just set the mass to what we were advised
									// to set it to
		this.setName("Flotsam");
	}

	@Override
	protected void update_display_size(double radius_of_system) {
		// make its scaling different so that it is big enough to see but also
		// is emphasized to be small
		this.GUIRadius = (int) (2889850000.0 / radius_of_system);
		this.setSize(new Dimension(2 * this.GUIRadius, 2 * this.GUIRadius));
	}

}
