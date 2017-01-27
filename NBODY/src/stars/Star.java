package stars;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Random;

public class Star extends Satellite {

	private boolean isSupernova = false;
	Random sizeChange = new Random();
	private Star_Field stars;// to reference the starfield which stores all the
								// planets

	public Star(double _x, double _y, double velocity_x, double velocity_y, double my_mass, double my_radius,
			String name, Star_Field stars) {
		super(_x, _y, velocity_x, velocity_y, my_mass, my_radius, name);
		this.stars = stars; // so we can call the supernova metod effectively
	}

	/**
	 * Divide the radius of the star by the radius of the system and multiply by
	 * our constant multiplier which we decided by analysis to be such that with
	 * the default size it is an acceptable size.
	 */
	@Override
	protected void update_display_size(double radius_of_system) {
		if (!isSupernova) {
			// guiradius is the conversion factor between the gui and real life
			// size based on the size of the solar system we are in
			this.GUIRadius = (int) ((this.radius / radius_of_system) * 35506 + sizeChange.nextInt(2));// this
			// makes
			// the
			// sun
			// its
			// "normal"
			// size
		} else {
			this.GUIRadius = (int) ((this.radius / radius_of_system) * 25506 + sizeChange.nextInt(5));// after
			// a
			// supernova
			// occurs,
			// the
			// sun
			// is
			// slightly
			// downsized
		}

		this.setSize(new Dimension(2 * this.GUIRadius, 2 * this.GUIRadius));
		// for setting the size according to GUIRadius. without this our sun
		// wouldn't scale up and down in size with scrolling
	}

	public void supernova() {
		isSupernova = true;// if supernova is triggered, the supernova will be
							// downsized
		this.setForeground(Color.ORANGE);
		// this tries to check for any components present in the star field, and
		// if they are of type planet, then they explode and create flotsam
		try {
			for (Component planet : stars.getComponents()) {
				if (planet instanceof Satellite) {
					if (!(planet instanceof Star) && !(planet instanceof Flotsam)) {
						stars.remove(planet);// removes such a component
						stars.create_flotsam(10, (Planet) planet);
					}
				}
			}
		}
		// after all planets have been changed the loop will catch a null
		// pointer exception. to beat this we simply acknowledge the possibility
		// of the exception happening
		catch (NullPointerException e) {
		}
	}
}
