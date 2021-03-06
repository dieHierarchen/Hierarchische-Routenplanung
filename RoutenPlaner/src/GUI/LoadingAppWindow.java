/**
 * @author Robin Schneider
 * 
 */

package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.Random;

import javax.swing.*;

public class LoadingAppWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoadingAppWindow() {
		initializeWindow();
		initializeComponents();
	}
	
	private void initializeWindow() {
		this.setTitle("Hierarchischer Routenplaner");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(450, 350);
		this.setResizable(false);
	}
	
	private void initializeComponents() {
		Container pane = this.getContentPane();
		pane.setLayout(new BorderLayout());
		
		//Center:
		PictureFrame pictureFrame = new PictureFrame(getRandomScreenPicture());
		pane.add(BorderLayout.CENTER, pictureFrame);
		
		//South:			
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.ORANGE);
		progressBar.setIndeterminate(true);
		progressBar.setStringPainted(true);
		progressBar.setString("Initialiting Components...");
		pane.add(BorderLayout.SOUTH, progressBar);		
					
	}
	
	private String getRandomScreenPicture() {
		Random random = new Random();
		int randomNumb = random.nextInt(3);
		String path = "";
		
		switch(randomNumb) {
		case 0: 
			path = "image/roadtrip.jpg";
			break;
		case 1:
			path = "image/Taxi.jpg";
			break;
		case 2:
			path = "image/route66.jpg";
			break;
		}
		System.out.println("random num is " + randomNumb);
		return path;
	}
	
}
