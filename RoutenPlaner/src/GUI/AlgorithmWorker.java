/**
 * @author Robin.Schneider
 */

package GUI;

import java.util.ArrayList;

import javax.swing.SwingWorker;

import Graph.Node;
import Logic.AStarAlgorithm;
import Logic.DijkstraAlgorithm;
import Logic.ShortestPathAlgorithm;

public class AlgorithmWorker extends SwingWorker<Integer, Integer> {

	private Modell modell;
	private String algorithm;
	
	public AlgorithmWorker(Modell modell, String Algorithm) {			//add node startNode und destinationNode to constructor
		this.modell = modell;
		this.algorithm = Algorithm;
	}
	
	@Override
	protected Integer doInBackground() throws Exception {
		
		long startTime = System.currentTimeMillis();
		
		System.out.println("Before Switch");
		
		
		ShortestPathAlgorithm shortestPathAlg = null;
		switch(algorithm) {
		case "Dijkstra" :
			shortestPathAlg = new DijkstraAlgorithm(modell.getStartNode(), modell.getDestiNode(), modell.getHighWayGraph());			//must get startNode and destinationNode
			break;
			
		case "A* Algorithmus":
			shortestPathAlg = new AStarAlgorithm(modell.getStartNode(), modell.getDestiNode(), modell.getHighWayGraph());
			break;
		};
		
		shortestPathAlg.startAlgorithm();
		//test:
		System.out.println("Dijkstra in work");
		ArrayList<Node > resultTest = shortestPathAlg.getResultList();
		System.out.println("Min Distance is: " + shortestPathAlg.getMinDistance());
		System.out.print("Reihenfolge der Knoten ist: ");
		for (Node t : resultTest) {
			System.out.print(t.getLabel() + "; ");
		}
		System.out.println("After Switch");
		Thread.sleep(2000);
		//test ends here
		
		long endTime = System.currentTimeMillis();
		double diff = (endTime - startTime) / 1000;
		modell.setResults(shortestPathAlg.getMinDistance(), shortestPathAlg.getResultList(), diff);	
			
		
		return null;
	}

}
