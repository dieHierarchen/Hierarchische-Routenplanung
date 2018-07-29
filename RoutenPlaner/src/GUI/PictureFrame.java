/**
 * 
 * @author Robin Schneider
 */

package GUI;

import java.awt.*;
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
		
		
		
		//test
		//coord. southesPoint Germany:
		Graphics2D graphics = (Graphics2D) this.getGraphics();
		double latSouthest = 47.270111;
		double longSouthest = 10.178306;
		drawCenteredCircle(graphics, (int)CalcLongCoord(longSouthest), (int)CalcLatCoord(latSouthest), 15);
		
		//coord. northest Point Germany:
		double latNorthest = 55.057728;
		double longNorthest = 8.415789;
		drawCenteredCircle(graphics, (int)CalcLongCoord(longNorthest), (int)CalcLatCoord(latNorthest), 15);
		
		//coord. Stuttgart:
				double latStutt = 48.778051;
				double longStutt = 9.175093;
				drawCenteredCircle(graphics, (int)CalcLongCoord(longStutt), (int)CalcLatCoord(latStutt), 15);
				graphics.draw(new Line2D.Double((int)CalcLongCoord(longStutt), (int)CalcLatCoord(latStutt),
						(int)CalcLongCoord(longSouthest), (int)CalcLatCoord(latSouthest)));
				graphics.draw(new Line2D.Double((int)CalcLongCoord(longStutt), (int)CalcLatCoord(latStutt),
						(int)CalcLongCoord(longNorthest), (int)CalcLatCoord(latNorthest)));

		//test ends here

		
		return "Distance to destination is " + minDistance + " km \n"
				+ "\n"
				+ "The result String will stand right here";
	}
	
	private void drawCenteredCircle(Graphics2D g, int x, int y, int r) {
		  x = x-(r/2);
		  y = y-(r/2);
		  g.fillOval(x,y,r,r);
		}
	
	private long CalcLatCoord(double coordinateLat) {
		//rechne coordinaten von realem Ma�stab auf Deutschlandkarte um
		double diff = coordinateLat - 47.270111;
		double newCoord= 700 - (diff * 89.34452074);
		
		
		if (newCoord < 0) {
			return 0;
		}
		else if (newCoord > 700) {
			return 700;
		}
		else {
			return Math.round(newCoord);
		}
	}
	
	private long CalcLongCoord(double coordinateLong) {
		//rechne coordinaten von realem Ma�stab auf Deutschlandkarte um
		double diff = coordinateLong - 5.866867;
		double newCoord= (diff * 65.80148789);
		
		if (newCoord < 0) {
			return 0;
		}
		else if (newCoord > 585) {
			return 585;
		}
		else {
			return Math.round(newCoord);
		}
	}
}
