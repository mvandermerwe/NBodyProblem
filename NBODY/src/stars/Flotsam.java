//Mark Van der Merwe and Tarun Sunkaraneni
package stars;

import java.awt.Color;
import java.awt.Dimension;

/**
 * Flotsam is a satellite that is small and doesn't weigh much.
 * 
 * @author markvandermerwe
 *
 */
public class Flotsam extends Satellite {

	/**
	 * See satellite for details.
	 */
	public Flotsam(int _x, int _y, int _xVelocity, int _yVelocity) {
		super(_x, _y, _xVelocity, _yVelocity);
		this.setForeground(Color.GRAY);
		this.mass = 1_000_000_000;// just set the mass to what we were advised
									// to set it to
		this.setName("Flotsam");
	}

	/**
	 * Because flotsam is so small (no defined radius) we played around with
	 * some constants to find something that would scale well so it was smaller
	 * than the planets but still visible (at least to start).
	 */
	@Override
	protected void update_display_size(double radius_of_system) {
		// make its scaling different so that it is big enough to see but also
		// is emphasized to be small
		this.GUIRadius = (int) (2_889_850_000.0 / radius_of_system);
		this.setSize(new Dimension(2 * this.GUIRadius, 2 * this.GUIRadius));
	}

}
