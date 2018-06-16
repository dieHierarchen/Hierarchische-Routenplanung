import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import Logic.DijkstraAlgorithm;

public class MainClass {
	public static void main(String[] args) {
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
		
		
		//setting up a testing matrix (incidence list of a graph)
				int[][] testGraph = new int[10][10];
				for (int i = 0; i < testGraph.length; i++) {
					for (int k = 0; k < testGraph.length; k++) {			//initial =0
						testGraph[i][k] = 0;
					}
				}
				
				//adding edges/values:
				testGraph[1][3] = 5;
				testGraph[1][2] = 6;
				
				testGraph[2][1] = 6;
				testGraph[2][4] = 3;
				testGraph[2][8] = 25;
				testGraph[2][5] = 10;
				
				testGraph[3][1] = 5;
				testGraph[3][4] = 7;
				
				testGraph[4][2] = 3;
				testGraph[4][7] = 4;
				
				testGraph[5][2] = 10;
				testGraph[5][9] = 3;
				
				testGraph[7][4] = 4;
				testGraph[7][8] = 8;
				
				testGraph[8][7] = 8;
				testGraph[8][2] = 25;
				testGraph[8][9] = 3;
				
				testGraph[9][5] = 3;
				testGraph[9][8] = 3;
				
		 
		 
		DijkstraAlgorithm testAlgo = new DijkstraAlgorithm(1,8, testGraph);
		testAlgo.startAlgorithm();
		
		ArrayList<Integer > resultTest = testAlgo.getResultList();
		System.out.println("Min Distance is: " + testAlgo.getMinDistance());
		System.out.print("Reihenfolge der Knoten ist: ");
		for (int t : resultTest) {
			System.out.print(t + "; ");
		}
	}
}
