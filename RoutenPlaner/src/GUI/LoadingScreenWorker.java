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
		//des Parsers übertragen werden
		
		//Bis dahin Testweise:
		//setting up a testing matrix (incidence list of a graph)
		Graph testGraph = new Graph();
		
		testGraph = new Graph();
		testGraph.addNode("1");
		testGraph.addNode("2");
		testGraph.addNode("3");
		testGraph.addNode("4");
		testGraph.addNode("5");
		testGraph.addNode("6");
		testGraph.addNode("7");
		testGraph.addNode("8");
		testGraph.addNode("9");
		
//		//adding edges:
		
		testGraph.addEdge("1", "3", 5);
		testGraph.addEdge("1", "2", 6);
		testGraph.addEdge("3", "4", 7);
		testGraph.addEdge("2", "4", 3);
		testGraph.addEdge("2", "8", 25);
		testGraph.addEdge("2", "5", 10);
		testGraph.addEdge("4", "7", 4);
		testGraph.addEdge("5", "9", 3);
		testGraph.addEdge("7", "8", 8);
		testGraph.addEdge("8", "9", 3);
		//Test endet hier 
			
		Thread.sleep(2000);
		//Übertrage geparsten Graph ins Modell
		modell.setHighWayGraph(testGraph);
		
		return null;
	}
	
}
