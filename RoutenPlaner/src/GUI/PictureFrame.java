/**
 * 
 * @author Robin Schneider
 */

package GUI;

import java.awt.*;
import javax.swing.*;

public class PictureFrame extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String imagePath;

	public PictureFrame (String imagePath) {
		this.imagePath = imagePath;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D graphics = (Graphics2D) g;
		
		//String imagePath = "C:\\Users\\User\\Downloads\\Taxi.jpg";
		ImageIcon img = new ImageIcon(imagePath);
		Image imageTaxi = img.getImage();
		graphics.drawImage(imageTaxi, 0, 0, this.getSize().width, this.getSize().height, null);
	}
}