package stars;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Black_Hole extends Satellite {

	public Black_Hole(double _x, double _y, double my_mass, String name) {
		super(_x, _y, my_mass, name);
	}

	@Override
	protected void update_display_size(double radius_of_system) {
		this.setSize(new Dimension(10,10));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.fillOval(0, 0, this.getWidth(), this.getHeight());
		g2.setColor(Color.WHITE);
		g2.drawOval(0, 0, this.getWidth() - 1, this.getHeight() - 1);

	}

}
