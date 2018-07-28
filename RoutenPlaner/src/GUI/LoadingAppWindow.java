/**
 * @author Robin Schneider
 * 
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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
		this.setSize(350, 350);
		this.setResizable(false);
	}
	
	private void initializeComponents() {
		Container pane = this.getContentPane();
		pane.setLayout(new BorderLayout());
		
		//Center:
		PictureFrame pictureFrame = new PictureFrame("image/taxi.jpg");
		pane.add(BorderLayout.CENTER, pictureFrame);
		
		//South:			
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.ORANGE);
		progressBar.setIndeterminate(true);
		progressBar.setStringPainted(true);
		progressBar.setString("Initialiting Components...");
		pane.add(BorderLayout.SOUTH, progressBar);		
					
	}
	
}
