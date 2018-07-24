package GUI;

import java.util.ArrayList;
import java.util.Observable;

public class Modell extends Observable{
	private ArrayList<Integer> resultListNodes;		//Sp�ter m�ssen hier Knoten statt Int sein
	private int minDistance;
	
	private int[][] graph;							//muss noch gegen graph von Julius getauscht werden
	
	public void setResults(int minDistance, ArrayList<Integer> resultNodes) {
		this.minDistance = minDistance;
		this.resultListNodes = resultNodes;
		setChanged();
		//notifyObservers(2); 						//Event 2 wird gefeuert
	}
	
	public int getminDist() {
		return this.minDistance;
	}
	
	public ArrayList<Integer> getresultList(){
		return this.resultListNodes;
	}
	
								
	public void setHighWayGraph(int[][] graph) {
		this.graph = graph;
		setChanged();
		notifyObservers(1);							//Event 1 wird gefeuert
	}
	
	public int[][] getHighWayGraph() {
		return this.graph;
	}

}
