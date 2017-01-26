package stars;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Star extends Satellite{

	private boolean isSupernova = false;
	private Star_Field stars;

	public Star(double _x, double _y, double velocity_x, double velocity_y, double my_mass, double my_radius,
			String name, Star_Field stars) {
		super(_x, _y, velocity_x, velocity_y, my_mass, my_radius, name);
		this.stars = stars;
	}

	/**
	 * Divide the radius of the star by the radius of the system and multiply by
	 * our constant multiplier which we decided by analysis to be such that with
	 * the default size it is an acceptable size.
	 */
	@Override
	protected void update_display_size(double radius_of_system) {
		if(!isSupernova){
			this.GUIRadius = (int) ((this.radius / radius_of_system) * 35506);
		}else{
			this.GUIRadius = (int) ((this.radius / radius_of_system) * 25506);
		}
		
		this.setSize(new Dimension(2 * this.GUIRadius, 2 * this.GUIRadius));
	}

	public void supernova() {
		isSupernova = true;
		for(Component planet: stars.getComponents()){
			if(planet instanceof Satellite){
				if(!(planet instanceof Star) && !(planet instanceof Flotsam)){
					stars.remove(planet);
					stars.create_flotsam(10, (Planet) planet);
				}
			}
		}
	}
}
