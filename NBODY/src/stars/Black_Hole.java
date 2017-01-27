//Mark Van der Merwe and Tarun Sunkaraneni
package stars;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Black Hole is an extra heavy satellite.
 * 
 * @author markvandermerwe
 *
 */
public class Black_Hole extends Satellite {

	/**
	 * See Satellite for more details.
	 */
	public Black_Hole(double _x, double _y, double my_mass, String name) {
		// the constructor of the blackhole is a
		// little different in that it doesn't
		// have/ need an initial velocity
		super(_x, _y, my_mass, name);
	}

	/**
	 * Because technically a black hole is infinitely small, we opted to keep it
	 * at a stable size.
	 */
	@Override
	protected void update_display_size(double radius_of_system) {
		// sets the size of the blackhole to
		// be this big, regardless the size
		// of system
		this.setSize(new Dimension(10, 10));
	}

	@Override
	public void paintComponent(Graphics g) {
		// Makes the circles prettier.
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// fills the inside of the hole with black
		g2.fillOval(0, 0, this.getWidth(), this.getHeight());
		g2.setColor(Color.WHITE);
		// this draws around the shape with a white line to differentiate it
		g2.drawOval(0, 0, this.getWidth() - 1, this.getHeight() - 1);
	}

}
