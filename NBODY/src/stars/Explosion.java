package stars;

import java.awt.Component;

import javax.swing.JComponent;

public class Explosion extends Satellite{
	
	Component[] satellites;
	
	public Explosion(Component[] satellites) {
		this.satellites = satellites;
	}

	@Override
	protected void update_display_size(double radius_of_system) {
		this.GUIRadius++;
		this.setSize(2 * this.GUIRadius, 2 * this.GUIRadius);
		collideWithSatellite();
	}
	
	public void collideWithSatellite() {
		for(int index = 0; index < satellites.length; index++) {
			if(this.getBounds().contains(satellites[index].getLocation()));
		}
	}

}
