package GUI;

import java.util.ArrayList;

import javax.swing.SwingWorker;

import Logic.DijkstraAlgorithm;

public class AlgorithmWorker extends SwingWorker<Integer, Integer> {

	private Modell modell;
	private String algorithm;
	//private node startNode;
	//private node destinationNode;
	
	public AlgorithmWorker(Modell modell, String Algorithm) {			//add node startNode und destinationNode to constructor
		this.modell = modell;
		this.algorithm = Algorithm;
		//this.startNode = startNode;
		//this.destinationNode = destinationNode;
	}
	
	@Override
	protected Integer doInBackground() throws Exception {
		long startTime = System.currentTimeMillis();
		
		System.out.println("Before Switch");
		switch(algorithm) {
		case "Dijkstra" :
			DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(1, 8, modell.getHighWayGraph());			//must get startNode and destinationNode
			dijkstra.startAlgorithm();
			
			//test:
			System.out.println("Dijkstra in work");
			ArrayList<Integer > resultTest = dijkstra.getResultList();
			System.out.println("Min Distance is: " + dijkstra.getMinDistance());
			System.out.print("Reihenfolge der Knoten ist: ");
			for (int t : resultTest) {
				System.out.print(t + "; ");
			}
			System.out.println("After Switch");
			Thread.sleep(2000);
			//test ends here
			
			long endTime = System.currentTimeMillis();
			double diff = (endTime - startTime) / 1000;
			modell.setResults(dijkstra.getMinDistance(), dijkstra.getResultList(), diff);	
				
			break;
			
		case "A* Algorithmus":
			break;
		};
		
		return null;
	}

}