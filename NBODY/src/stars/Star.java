package stars;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Star extends Satellite implements MouseListener {

	private boolean isSupernova = false;

	public Star(double _x, double _y, double velocity_x, double velocity_y, double my_mass, double my_radius,
			String name) {
		super(_x, _y, velocity_x, velocity_y, my_mass, my_radius, name);
		this.addMouseListener(this);
	}

	/**
	 * Divide the radius of the star by the radius of the system and multiply by
	 * our constant multiplier which we decided by analysis to be such that with
	 * the default size, our sun has a size of 50.
	 */
	@Override
	protected void update_display_size(double radius_of_system) {
		this.GUIRadius = (int) ((this.radius / radius_of_system) * 35506);
		// System.out.println(radius);
		this.setSize(new Dimension(2 * this.GUIRadius, 2 * this.GUIRadius));
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.fillOval(0, 0, this.getWidth(), this.getHeight());
		g2.setColor(Color.WHITE);
		g2.drawOval(0, 0, this.getWidth() - 1, this.getHeight() - 1);

	}

	public void supernova() {
		System.out.println("Trigger supernova explosion!!");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.supernova();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
