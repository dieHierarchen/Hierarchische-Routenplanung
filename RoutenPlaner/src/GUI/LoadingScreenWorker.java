package GUI;

import java.util.ArrayList;
import javax.swing.SwingWorker;
import Logic.DijkstraAlgorithm;

public class LoadingScreenWorker extends SwingWorker<Integer, Integer>{
	
	private Modell modell;
	
	public LoadingScreenWorker(Modell modell) {
		this.modell = modell;
	}
	
	@Override
	protected Integer doInBackground() throws Exception {
		//Hier soll XML Parser aufgerufen werden und Ergebnisse
		//des Parsers übertragen werden
		//Bis dahin Testweise:
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
		

		Thread.sleep(2000);
		//Test endet hier 
			
		
		//Übertrage geparsten Graph ins Modell
		modell.setHighWayGraph(testGraph);
		
		return null;
	}
	
}
