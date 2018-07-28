package GUI;

import java.util.ArrayList;
import java.util.Observable;

public class Modell extends Observable{
	private ArrayList<Integer> resultListNodes;		//Sp�ter m�ssen hier Knoten statt Int sein
	private int minDistance;
	
	private int[][] graph;							//muss noch gegen graph von Julius getauscht werden
	
	private String[] allNodeNames;
	
	private String[] Algorithms = {
			"Dijkstra"
	};
	
	private double timeLastedForCalc;
	
	public double getTimeLastetForCalc() {
		return this.timeLastedForCalc;
	}
	
	public void setResults(int minDistance, ArrayList<Integer> resultNodes, double timeLastedForCalc) {
		this.minDistance = minDistance;
		this.resultListNodes = resultNodes;
		this.timeLastedForCalc = timeLastedForCalc;
		setChanged();
		notifyObservers(2); 						//Event 2 wird gefeuert
	}
	
	public int getminDist() {
		return this.minDistance;
	}
	
	public ArrayList<Integer> getresultList(){
		return this.resultListNodes;
	}
	
								
	public void setHighWayGraph(int[][] graph) {
		this.graph = graph;
		
		//get all nodes from graph function call by Julius' graph class
//		ArrayList<String> nodesNames = new ArrayList<>();
//		for (node n : graph) {
//			nodesNames.add(n.name());
//		}
//		allNodeNames = (String[])nodesNames.toArray();
		
		//derzeit placeholder:
		//Test:
				String[] a = {
				"Hallo", "2", "3"
				};
				allNodeNames = a;
				//
		//test ende
		
		setChanged();
		notifyObservers(1);							//Event 1 wird gefeuert
	}
	
	public int[][] getHighWayGraph() {
		return this.graph;
	}
	
	public String[] getAllNames() {
		return this.allNodeNames;
	}
	
	public String[] getAlgorithms() {
		return this.Algorithms;
	}

}
