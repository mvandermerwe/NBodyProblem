
/**
 * 
 */
package stars;

import java.awt.geom.Point2D;

/**
 * @author germain
 *
 */
public class Geometry_Vector extends Point2D.Double {

	private static final long serialVersionUID = 1L;

	/**
	 *
	 * Constructor
	 *
	 * @param x
	 *            - the X
	 * @param y
	 *            - and Y values
	 */
	public Geometry_Vector(double xx, double yy) {
		this.x = xx;
		this.y = yy;
	}

	/**
	 *
	 * A "Copy" constructor. Create ourself based on the given vector
	 * 
	 * @param the_copy
	 */
	public Geometry_Vector(Geometry_Vector the_copy) {
		super(the_copy.getX(), the_copy.getY());
	}

	/**
	 * Add the components of the given vector to me.
	 *
	 * @param vector
	 */
	public void add_to_me(Geometry_Vector vector) {
		this.x = this.getX() + vector.getX();
		this.y = this.getY() + vector.getY();
	}

	/**
	 * Subtract the components of the given vector from me.
	 * 
	 * @param vector
	 */
	public void subtract_from_me(Geometry_Vector vector) {
		this.x = this.getX() - vector.getX();
		this.y = this.getY() - vector.getY();
	}

	/**
	 * Divide my components by the scalar
	 * 
	 * @param scalar
	 */
	public void divide_by(double scalar) {
		this.x = this.getX() / scalar;
		this.y = this.getY() / scalar;
	}

	/**
	 * Multiply my components by the scalar
	 * 
	 * @param scalar
	 */
	public void multiply_me_by(double scalar) {
		this.x = this.getX() * scalar;
		this.y = this.getY() * scalar;
	}

	/**
	 * @return my magnitude (the distance from the origin to my X,Y) Think
	 *         Pythagoras
	 */
	public double magnitude() {
		double absX = Math.abs(this.getX());
		double absY = Math.abs(this.getY());
		return Math.sqrt(Math.pow(absX, 2) + Math.pow(absY, 2));
	}

	/**
	 * @return an informative (but concise) description of this object
	 */
	public String toString() {
		return "Vector: x= " + this.getX() + " y= " + this.getY() + " magnitude= " + this.magnitude();
	}

	/**
	 * Take this vector and turn it into a vector of length 1. This is done by
	 * dividing each component (i.e., x,y) by the magnitude.
	 */
	public void normalize() {
		if (this.magnitude() > 0) {
			this.divide_by(this.magnitude());
		}
	}

}
