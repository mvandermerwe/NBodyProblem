
/**
 * 
 */
package stars;

import java.awt.geom.Point2D;

/**
 * @author germain
 *
 */
public class Geometry_Vector extends Point2D.Double
{

  /**
   *
   * Constructor
   *
   * @param x - the X 
   * @param y - and Y values
   */
  public  Geometry_Vector(double xx, double yy)
  {
	  
  }

  /**
   *
   * A "Copy" constructor.  Creat ourself based on the given vector
   * @param the_copy 
   */
   public  Geometry_Vector(Geometry_Vector the_copy)
   {
	   
   }

  /**
   * Add the components of the given vector to me.
   *
   * @param vector
   */
  public void add_to_me(Geometry_Vector vector)
  {
	  
  }

  /**
   * Subtract the components of the given vector from me.
   * @param vector
   */
  public void subtract_from_me(Geometry_Vector vector)
  {
	  
  }

  /**
   * Divide my components by the scalar
   * @param scalar
   */
  public void divide_by( double scalar )
  {
	  
  }

  /**
   * Multiply my components by the scalar
   * @param scalar
   */
  public  void   multiply_me_by(double scalar)
  {
	  
  }

  /**
   * @return my magnitude (the distance from the origin to my X,Y)
   * Think Pythagoras
   */
  public  double  magnitude()
  {
	  return 0; // "FIXME";
  }

  /**
   * @return an informative (but concise) description of this object
   */
  public  String toString()
  {
	  return "FIXME";
  }

  /**
   * Take this vector and turn it into a vector of length 1.  This is done by
   * dividing each component (i.e., x,y)  by the magnitude.
   */
  public   void   normalize()
  {
	  
  }
  
}
