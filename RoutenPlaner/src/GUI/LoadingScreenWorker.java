/**
 * @author Robin.Schneider
 */

package GUI;

import javax.swing.SwingWorker;
import Graph.Graph;

public class LoadingScreenWorker extends SwingWorker<Integer, Integer>{
	
	private Modell modell;
	
	public LoadingScreenWorker(Modell modell) {
		this.modell = modell;
	}
	
	@Override
	protected Integer doInBackground() throws Exception {
		//Hier soll XML Parser aufgerufen werden und Ergebnisse
		//des Parsers �bertragen werden
		
		//Bis dahin Testweise:

		//setting up a test graph
				Graph testGraph = new Graph();
						
				testGraph = new Graph();
				testGraph.addNode("1", 1, 8.415789, 55.057728);
				testGraph.addNode("2", 2, 8.415789, 54.456776);
				testGraph.addNode("3", 3, 8.415789, 51.456776);
				testGraph.addNode("6", 6, 8.415789, 50.6);
				testGraph.addNode("5", 5, 10.0, 50.6);
				
				testGraph.addNode("8", 8, 10.178306,47.270111);
				testGraph.addNode("10", 10, 13, 55.057728);
				testGraph.addNode("20", 20, 10.178306, 1);
						
//				//adding edges:
						
				testGraph.addEdge(1,2);
				testGraph.addEdge(2,3);
				testGraph.addEdge(3,6);
				testGraph.addEdge(6,5);
				testGraph.addEdge(1,8);
				testGraph.addEdge(8,5);
				
				testGraph.addEdge(1,10);
				testGraph.addEdge(3,20);
				
				
		Thread.sleep(2000);
		//�bertrage geparsten Graph ins Modell
		modell.setHighWayGraph(testGraph);
		
		return null;
	}
	
}
