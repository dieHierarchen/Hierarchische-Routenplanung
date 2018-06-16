package Logic;

import java.util.ArrayList;
import java.util.TreeMap;

public class DijkstraAlgorithm {
	
	private int startingNode;
	private int finalNode;
	
	private int[][] graph;
	private int[][] resultGraph;
	
	private TreeMap<Integer, Integer> distance;
	
	private ArrayList<Integer> result;
	private int minDistanceResult = 0;
	
	private boolean founddExactPathAlready;
	
	public ArrayList<Integer>getResultList() {
		return this.result;
	}
	public int getMinDistance() {
		return this.minDistanceResult;
	}
	
	public DijkstraAlgorithm(int startingNode, int finalNode, int[][] graph) {
		this.startingNode = startingNode;
		this.finalNode = finalNode;
		this.graph = graph;
		initializeDijkstra();
	}
	
	private void initializeDijkstra() {
		distance = new TreeMap<>();
		result = new ArrayList<>();
		founddExactPathAlready = false;
		
		resultGraph = new int[graph.length][graph.length];
		for (int i = 0; i < resultGraph.length; i++) {
			for (int k = 0; k < resultGraph.length; k++) {
				resultGraph[i][k] = 0;
			}
		}
	}
	
	public void startAlgorithm() {
		if (startingNode == finalNode) {
			result.add(startingNode);
			minDistanceResult = 0;
		}
		else
		{
			buildSpanningTree();
			minDistanceResult = distance.get(finalNode);
			recursivPathFinder(startingNode, finalNode, new ArrayList<Integer>());
		}
	}
	
	private void buildSpanningTree() {
		distance.put(startingNode, 0);
		do {
			int[] minEdge = minOpenEdge();
			resultGraph[minEdge[0]][minEdge[1]] = 1;
		}while (!distance.containsKey(finalNode));
	}
	
	private int[] minOpenEdge() {
		int[] minEdge = null;	//initial 
		int minValue = 0;		//initial
		
		int actualEdgeValue = 0;
		int actualDistancefromStart = 0;
		
		for (int i = 1; i < graph.length; i++) {
			for (int k = 1; k < graph.length; k++) {
				actualEdgeValue= graph[i][k];
				if (actualEdgeValue != 0 && (distance.containsKey(i) && !distance.containsKey(k))) {
					actualDistancefromStart = actualEdgeValue + distance.get(i);
					if (minEdge == null | actualDistancefromStart < minValue) {
						minEdge = new int[] {i,k};
						minValue = actualDistancefromStart;
					}
				}
			}
			
		}
		distance.put(minEdge[1], minValue);		//mindEdge[1] == k
		return minEdge;
	}
	
	@SuppressWarnings("unchecked")
	private void recursivPathFinder(int node, int finalNode, ArrayList<Integer> resultTemp) {
		if (!founddExactPathAlready)
		{
			resultTemp.add(node);

			if (resultGraph[node][finalNode] == 1) {
				resultTemp.add(finalNode);
				this.result = resultTemp;
				founddExactPathAlready = true;
			}
			else
			{
				for (int i = 0; i < resultGraph.length; i++) {
					if (resultGraph[node][i] == 1) {
						ArrayList<Integer> CopyOfResult;
						try {
							CopyOfResult = (ArrayList<Integer>) resultTemp.clone();
						}
						catch (ClassCastException e) {
							throw new ClassCastException("ResultTemp has to be an ArrayList<Integer>");
						}
						recursivPathFinder(i, finalNode, CopyOfResult);
					}
				}
			}
		}
	}
		
	
}