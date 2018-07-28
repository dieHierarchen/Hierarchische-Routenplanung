/**
 * 
 * @author Robin Schneider
 */

package GUI;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

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
		
		ImageIcon img = new ImageIcon(imagePath);
		Image image = img.getImage();
		graphics.drawImage(image, 0, 0, this.getSize().width, this.getSize().height, null);						
	}
	
	public String DrawResultRoute(ArrayList<Integer> resultList, int minDistance) {					//sp�ter gegen Knoten Klasse tauschen.
		//clean imageFrame first:
		paintComponent(this.getGraphics());
		
		//hier muss Knoten gezeichnet werden:
		//erstelle gleichzeitig einen String der die Route beschreibt:
		//zeichne ersten Knoten in Bild per Koordinaten
		//schreibe in den Stringa.add("Start in {0} \n drive ", node.getName)
		//setzte die variable node precessor auf den startknoten
		//remove vs from resultList and Start:
		//for every node in resultList
		//draw node in image per Coordinates
		//String.add("over {0} \n", node.name)
		//DrawLine from precessor.coordinates to node.coordinates
		//set pressecor to node
		
		//�bergangsweise folgender placeholder:
		Graphics2D graphics = (Graphics2D) this.getGraphics();
		graphics.fill(new Ellipse2D.Double(100, 100, 10, 10));
		graphics.fill(new Ellipse2D.Double(300, 300, 10, 10));
		graphics.draw(new Line2D.Double(105,105,305,305));			//calculate +5 which is the radius of the Ellipse
																	//so that the Line will intersects the ellipse in its center
		graphics.fill(new Ellipse2D.Double(350, 50, 10, 10));
		graphics.fill(new Ellipse2D.Double(162, 0, 10, 10));
		graphics.draw(new Line2D.Double(105,105,355,55));
		
		return "Distance to destination is " + minDistance + " km \n"
				+ "\n"
				+ "The result String will stand right here";
	}
	
	private int CalcCoords(int Coordinate) {
		//rechne coordinaten von realem Ma�stab auf Deutschlandkarte um
		return 0;
	}
}
