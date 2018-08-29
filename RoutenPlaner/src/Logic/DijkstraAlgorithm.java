/**
 * 
 * @author Robin Schneider
 * @version 0.5
 *
 */


package Logic;

import java.util.ArrayList;
import java.util.TreeMap;

import Graph.Edge;
import Graph.Graph;
import Graph.Node;


public class DijkstraAlgorithm implements ShortestPathAlgorithm {
	
	private Node startingNode;
	private Node finalNode;
	
	private Graph graph;
	private Graph resultGraph;
	
	private TreeMap<Node, Double> distance;
	
	private ArrayList<Node> result;
	private double minDistanceResult = 0;
		
	public ArrayList<Node>getResultList() {
		return this.result;
	}
	public double getMinDistance() {
		return this.minDistanceResult;
	}
	
	
	public DijkstraAlgorithm(Node startingNode, Node finalNode, Graph graph) {
		this.startingNode = startingNode;
		this.finalNode = finalNode;
		this.graph = graph;
		initializeDijkstra();
	}
	
	private void initializeDijkstra() {
		distance = new TreeMap<>();
		result = new ArrayList<>();
		
		resultGraph = new Graph();
		for (Node n : graph.getAllNodes()) {
			resultGraph.addNode(n.getId(), n.getLon(), n.getLat());
		}
		
	}
	
	public void startAlgorithm() {
		if (startingNode.getLabel() == finalNode.getLabel()) {
			result.add(startingNode);
			minDistanceResult = 0;
		}
		else
		{
			buildSpanningTree();
			minDistanceResult = distance.get(finalNode);			
			recursivPathFinder(resultGraph.getNode(startingNode.getId()), resultGraph.getNode(finalNode.getId()), new ArrayList<Node>());
		}
	}
	
	private void buildSpanningTree() {
		distance.put(startingNode, 0.0);
		do {
			Edge minEdge = minOpenEdge();
			//
			System.out.println("");
			//

			//weight in spanning tree doens`t mind -> 1 for easier implementation of findPath
			resultGraph.addEdge(minEdge.getStart().getId(), minEdge.getAim().getId(), minEdge.getWeight()); 	
		}while (!distance.containsKey(finalNode));
	}
	
	private Edge minOpenEdge() {
		Edge minEdge = null;	//initial 
		double minValue = 0.0;		//initial
		
		double actualEdgeValue = 0.0;
		double actualDistancefromStart = 0.0;
		
		for (Node n : distance.keySet()) {
			for (Node neigh : n.getNeighbours()) {
				actualEdgeValue= graph.getEdgeWeight(n.getId(), neigh.getId());
				//
				System.out.println("Edge from " + n.getId() + "and " + neigh.getId() + "with Weight: " + actualEdgeValue);
				//
				if (actualEdgeValue != 0 && (distance.containsKey(n) && !distance.containsKey(neigh))) {
					actualDistancefromStart = actualEdgeValue + distance.get(n);
					//
					System.out.println("actualDistFromStart: " + actualDistancefromStart);
					//
					if (minEdge == null | actualDistancefromStart < minValue) {
						minEdge = new Edge(n, neigh, (float)actualDistancefromStart);
						minValue = actualDistancefromStart;
						//
						System.out.println("Take Edge " + n.getId() + "to " + neigh.getId());
						//
					}
				}
			}
			
		}
		distance.put(minEdge.getAim(), minValue);		//mindEdge.getAim() == neigh 
		return minEdge;							
	}
	
	
	@SuppressWarnings("unchecked")
	private void recursivPathFinder(Node node, Node finalNode, ArrayList<Node> resultTemp) {

		resultTemp.add(node);
		
		if (node == finalNode) {
			this.result = resultTemp;
			return;
		}

		for (Node neigh : node.getNeighbours()) {
			if (!resultTemp.contains(neigh)) {
				
				ArrayList<Node> CopyOfResult;
				try {
					CopyOfResult = (ArrayList<Node>) resultTemp.clone();
				}
				catch (ClassCastException e) {
					throw new ClassCastException("ResultTemp has to be an ArrayList<Integer>");
				}
				recursivPathFinder(neigh, finalNode, CopyOfResult);
			}
		}
		
		
	}	
	
}
