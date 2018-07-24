package GUI;

import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PictureFrame imageFrame;
	public void updatePictureFrame(PictureFrame updatedFrame){
		this.imageFrame = updatedFrame;
	}
	
	public MainWindow() {
		imageFrame = new PictureFrame("C:\\Users\\User\\Downloads\\deutschlandkarte.png");
		initializeWindow();
		initializeComponents();
	}
	
	private void initializeWindow() {
		this.setTitle("Hierarchischer Routenplaner");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	private void initializeComponents() {
		Container pane = this.getContentPane();
		pane.setLayout(new BorderLayout());
		
		pane.add(BorderLayout.CENTER, imageFrame);
		
		JPanel North = new JPanel();
		North.setLayout(new FlowLayout());
		pane.add(BorderLayout.NORTH, North);
		
		JComboBox<String> cbStartPoint = new JComboBox<String>();
		//Test:
		cbStartPoint.addItem("Hallo");
		cbStartPoint.addItem("2");
		cbStartPoint.addItem("3");
		//
		North.add(cbStartPoint);
		
		JComboBox<String> cbDestination = new JComboBox<String>();
		North.add(cbDestination);
		
	}


}
