//Mark Van der Merwe and Tarun Sunkaraneni
package stars;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

/**
 * @author H. James de St. Germain
 * 
 *         Satellites are bodies that float around each other pulling at each
 *         other with gravity. The mass of an object determines how much
 *         gravitational force it applies to others.
 */
public abstract class Satellite extends JComponent {
	/**
	 * All these fields are parts of all types of Satellites, thus we keep them
	 * here - all satellites have position, velocity, mass, etc. Note, some are
	 * protected so they can be used in subclasses.
	 */
	private Geometry_Vector positionVector;
	private Geometry_Vector velocityVector;
	protected double mass;
	protected double radius;
	// GUIRadius is the radius of the satellite on the screen.
	protected int GUIRadius;

	/**
	 * This serialVersionUID is there to keep the compiler happy. We don't have
	 * plans for future versions... but perhaps we will
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Just return name. Used debugger more...
	 */
	public String toString() {
		return this.getName();
	}

	/**
	 * Basic constructor for satellite that sets up starting values.
	 * 
	 * @param x
	 *            - where (in 2D) we are in the solar system
	 * @param y
	 *            - where (in 2D) we are in the solar system
	 * @param velocity_x
	 *            - how fast in 2D we are moving in meters per second
	 * @param velocity_y
	 *            - how fast in 2D we are moving in meters per second
	 * @param mass
	 *            - how big we are (in kilograms)
	 * @param my_radius
	 *            - how wide we are (in km)
	 * @param name
	 *            - name of the satellite
	 */
	public Satellite(double _x, double _y, double velocity_x, double velocity_y, double my_mass, double my_radius,
			String name) {
		positionVector = new Geometry_Vector(_x, _y);
		mass = my_mass;
		radius = my_radius;
		velocityVector = new Geometry_Vector(velocity_x, velocity_y);
		this.setName(name);
	}

	/**
	 * Constructor specifically for the Black Hole.
	 * 
	 * @param x
	 *            - where (in 2D) we are in the solar system
	 * @param y
	 *            - where (in 2D) we are in the solar system
	 * @param mass
	 *            - how big we are (in kilograms)
	 * @param name
	 *            - name of satellite
	 */
	public Satellite(double _x, double _y, double my_mass, String name) {
		positionVector = new Geometry_Vector(_x, _y);
		mass = my_mass;
		this.setName(name);
		velocityVector = new Geometry_Vector(0, 0);
	}

	/**
	 * Constructor specifically for the Flotsam.
	 * 
	 * @param x
	 *            - where (in 2D) we are in the solar system
	 * @param y
	 *            - where (in 2D) we are in the solar system
	 * @param velocity_x
	 *            - how fast in 2D we are moving in meters per second
	 * @param velocity_y
	 *            - how fast in 2D we are moving in meters per second
	 */
	public Satellite(int _x, int _y, int _xVelocity, int _yVelocity) {
		positionVector = new Geometry_Vector(_x, _y);
		velocityVector = new Geometry_Vector(_xVelocity, _yVelocity);
	}

	/**
	 * Function Purpose:
	 * 
	 * Change position of this object by adding this object's velocity to this
	 * object's position.
	 * 
	 * Math Example: our position is 1,1. The move vector is 10,10. Our new
	 * position is 11,11
	 * 
	 * @param dt
	 *            a small number representing how much time has gone by
	 * 
	 *            Note: we are using discrete math work in a continuous system.
	 *            This means that in the real world time is constantly flowing.
	 *            In a simluation time is broken into a stream of continuous
	 *            tiny time blocks.
	 * 
	 *            To make the simulation work we must scale my a time factor.
	 *            What this means can be shown by looking at a car that is
	 *            moving at 50 miles per hour down the highway. If we took the
	 *            car's current position and velocity and drew a line 50 miles
	 *            forward, we could try and say that is where the car would be
	 *            in an hour. In reality, that would be wrong (no doubt the
	 *            highway would change directions (at least a little) long
	 *            before that)).
	 * 
	 *            What we can do is take the car that is moving at 50 miles per
	 *            hour and compute how far it will go in, say, 1 second. Move it
	 *            forward that much, then recompute. If we do this 60*60 times
	 *            we will have a better approximation of where the car would be
	 *            in reality.
	 *
	 *            Note: the parameter dt represents the fraction of the velocity
	 *            that will be applied at a given instant.
	 * 
	 *            Math Example: Our current position is 5,5. Our current
	 *            velocity is 100,100. The time step is 0.05; Our new position
	 *            would be 10,10 -> 5,5 + (100,100 * .05)
	 */
	public void update_position(double dt) {
		Geometry_Vector changeVector = new Geometry_Vector(this.velocityVector);
		changeVector.multiply_me_by(dt);
		this.positionVector.add_to_me(changeVector);
	}

	/**
	 *
	 * change our velocity based on acceleration vector (the force applied on
	 * us) multiplied by the delta (time step)
	 * 
	 * @param acceleration
	 *            - a vector of the force being exerted on us
	 *
	 *            Math Example:
	 * 
	 *            if my velocity is 100,100 (mph) and I have been told to
	 *            accelerate by 50,50 mph (in say dt = one second) then after
	 *            one second my new velocity would be 150,150 (mph).
	 * 
	 *            if my velocity is 100,0 and I am told to accelerate by 200,100
	 *            (in say one tenth of a second) we only apply one tenth of the
	 *            200,100, so the answer would be 100,0 + (200,100)/10 -->
	 *            120,10
	 * 
	 *            Thus the acceleration vector must be scaled by the time
	 *            duration (dt) before adding to the velocity vector
	 * 
	 */
	public void update_velocity(Geometry_Vector acceleration, double dt) {
		acceleration.multiply_me_by(dt);
		this.velocityVector.add_to_me(acceleration);
	}

	/**
	 *
	 *
	 * As previously stated, the location of the Satellite in the simulation is
	 * not the same as the pictures location in our GUI. For example, the earth
	 * might be at: x,y --> 149600000, 0 but on the GUI the earth is displayed
	 * at 300,300
	 * 
	 * In this method, transform the current objects position from WORLD
	 * coordinates into GUI coordinates x,y.
	 * 
	 * In order to do this we have to know our relation to the center of the
	 * solar system and how wide the solar system is. We also have to know how
	 * wide the GUI window is.
	 * 
	 * Note: The first thing to in an update_screen_coordinates method would be
	 * to update the display size of the object. the last thing you would do is
	 * set the location of the object.
	 * 
	 * The planets (assuming everything else is correct) will now rotate around
	 * the 0,0 location of the GUI (the upper left hand corner). By then adding
	 * half the width of the screen/height of the screen to this number (hard
	 * code to say 500,500) the planets will rotate around 500, 500.
	 */
	public void update_screen_coordinates(Geometry_Vector system_center, double system_radius, int window_width,
			int window_height) {
		this.update_display_size(system_radius);

		Geometry_Vector guiLocation = new Geometry_Vector(this.positionVector);
		guiLocation.divide_by(2 * system_radius);
		// Separate these two because we want to scale them differently.
		guiLocation.x = guiLocation.x * window_width;
		guiLocation.y = guiLocation.y * window_height;
		guiLocation.add_to_me(new Geometry_Vector(window_width / 2, window_height / 2));
		guiLocation.subtract_from_me(new Geometry_Vector(this.GUIRadius, this.GUIRadius));
		this.setLocation((int) guiLocation.x, (int) guiLocation.y);
	}

	/**
	 * Simple getter for mass of satellite.
	 *
	 * @return our mass
	 */
	public double get_mass() {
		return mass;
	}

	/**
	 * Simple getter for position of satellite.
	 *
	 * @return our position
	 */
	public Geometry_Vector get_position() {
		return this.positionVector;
	}

	/**
	 * Simple getter for velocity of satellite.
	 *
	 * @return our velocity
	 */
	public Geometry_Vector get_velocity() {
		return this.velocityVector;
	}

	/**
	 *
	 * based on our physical size, change the gui component to be large enough
	 * to show itself....
	 * 
	 * unfortunately, the scales of the solar system are so large that we
	 * wouldn't be able to see more than one planet at a time if we simply
	 * divided the radius of the object by the radius of the solar system, so we
	 * must scale the satellite by some arbitrary "looks good" factor. You will
	 * have to play with this to find an appropriate size such that we can see
	 * everything, but they don't overlap each other
	 * 
	 * @param radius_of_universe
	 *            - how far across the displayable universe (in our standard
	 *            case we set the orbit of saturn as this value)
	 */
	abstract protected void update_display_size(double radius_of_system);

	/**
	 * Paint component override to go in and draw our circles based on the
	 * settings setup elsewhere for the satellite.
	 */
	@Override
	public void paintComponent(Graphics g) {
		// 2D graphics makes our circles prettier...
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.fillOval(0, 0, this.getWidth(), this.getHeight());
	}
}
