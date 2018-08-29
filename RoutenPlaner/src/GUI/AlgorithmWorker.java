/**
 * @author Robin.Schneider
 */

package GUI;

import javax.swing.SwingWorker;
import Logic.*;

public class AlgorithmWorker extends SwingWorker<Integer, Integer> {

	private Modell modell;
	private String algorithm;
	
	public AlgorithmWorker(Modell modell, String Algorithm) {			//add node startNode und destinationNode to constructor
		this.modell = modell;
		this.algorithm = Algorithm;
	}
	
	@Override
	protected Integer doInBackground() throws Exception {		

		ShortestPathAlgorithm shortestPathAlg = null;
		
		switch(algorithm) {	
		case "Dijkstra" :
			shortestPathAlg = new DijkstraAlgorithm(modell.getStartNode(), modell.getDestiNode(), modell.getHighWayGraph());			//must get startNode and destinationNode
			break;
		case "Ford" :
			shortestPathAlg = new FordAlgorithm(modell.getHighWayGraph(), modell.getStartNode(), modell.getDestiNode());
			break;
		case "A* Algorithmus":
			shortestPathAlg = new AStarAlgorithm(modell.getStartNode(), modell.getDestiNode(), modell.getHighWayGraph());
			break;
		};
		
		long startTime = System.currentTimeMillis();	
		shortestPathAlg.startAlgorithm();
				
		long endTime = System.currentTimeMillis();
		double diff = (endTime - startTime) / 1000;
		modell.setResults(shortestPathAlg.getMinDistance(), shortestPathAlg.getResultList(), diff);		
		
		return null;
	}

}
