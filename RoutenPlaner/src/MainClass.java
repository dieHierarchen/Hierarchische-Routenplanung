import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import GUI.Presenter;
import Logic.DijkstraAlgorithm;

public class MainClass {
	public static void main(String[] args) throws InterruptedException {
//		JFrame mainFrame = new JFrame();
//		mainFrame.setTitle("Hierarchische RoutenPlanung");
//		mainFrame.setIconImage(new ImageIcon("C:\\\\Users\\\\User\\\\Downloads\\\\Taxi.jpg").getImage());
//		DrawCanvas canvas = new DrawCanvas();
//		canvas.setPreferredSize(new Dimension(400,400));
//		Container cp = mainFrame.getContentPane();
//		cp.add(canvas);
//		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		mainFrame.pack();
//		mainFrame.setVisible(true); 
		
		Presenter presenter = new Presenter();
		presenter.startApplication();
	}
}

