package stars;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Black_Hole extends Satellite {

	public Black_Hole(double _x, double _y, double my_mass, String name) {
		super(_x, _y, my_mass, name);// the constructor of the blackhole is a
										// little different in that it doesn't
										// have/ need an initial velocity
	}

	@Override
	protected void update_display_size(double radius_of_system) {
		this.setSize(new Dimension(10, 10));// sets the size of the blackhole to
											// be this big, regardless the size
											// of system
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);// to
																								// make
																								// a
																								// circle
																								// draw
																								// better

		g2.fillOval(0, 0, this.getWidth(), this.getHeight());// fills the inside
																// of the hole
																// with black
		g2.setColor(Color.WHITE);
		g2.drawOval(0, 0, this.getWidth() - 1, this.getHeight() - 1);// this
																		// draws
																		// around
																		// the
																		// shape
																		// with
																		// a
																		// white
																		// line
																		// to
																		// differentiate
																		// it
	}

}
