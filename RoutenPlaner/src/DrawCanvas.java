import java.awt.*;
import java.awt.geom.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DrawCanvas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D graphics = (Graphics2D) g;
		//graphics.setBackground(Color.WHITE);
		
		String imagePath = "C:\\Users\\User\\Downloads\\Taxi.jpg";
		ImageIcon img = new ImageIcon(imagePath);
		Image imageTaxi = img.getImage();
		graphics.drawImage(imageTaxi, 0, 0, 400, 400, null);
		
		graphics.setPaint(Color.MAGENTA);
		graphics.fill(new Ellipse2D.Double(100, 100, 10, 10));
		graphics.fill(new Ellipse2D.Double(300, 300, 10, 10));
		graphics.draw(new Line2D.Double(105,105,305,305));			//calculate +5 which is the radius of the Ellipse
																	//so that the Line will intersects the ellipse in its center
		graphics.fill(new Ellipse2D.Double(350, 50, 10, 10));
		graphics.draw(new Line2D.Double(105,105,355,55));
	}

}