package GUI;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainWindow() {
		initializeWindow();
	}
	
	private void initializeWindow() {
		this.setTitle("Hierarchischer Routenplaner");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}