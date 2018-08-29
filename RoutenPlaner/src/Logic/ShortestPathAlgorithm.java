package Logic;

import java.util.ArrayList;

import Graph.Node;

public interface ShortestPathAlgorithm {
	public void startAlgorithm();
	public ArrayList<Node> getResultList();
	public double getMinDistance();
	
}
