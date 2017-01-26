package stars;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

public class Flotsam extends Satellite {
	Random sizeScale = new Random();
	int xScale, yScale;

	public Flotsam(int _x, int _y, int _xVelocity, int _yVelocity) {
		super(_x, _y, _xVelocity, _yVelocity);
		this.setForeground(Color.GRAY);
		this.mass = 1000000000;
		xScale = sizeScale.nextInt(5) + 5;
		yScale = sizeScale.nextInt(5) + 5;
	}

	@Override
	protected void update_display_size(double radius_of_system) {
		this.setSize(new Dimension(xScale, yScale));
	}

}
