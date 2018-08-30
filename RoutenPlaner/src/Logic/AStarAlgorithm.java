package Logic;

import Graph.Edge;
import Graph.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class AStarAlgorithm implements ShortestPathAlgorithm {
	private Node startingNode;
	private Node finalNode;
	private List<Node> openList = new LinkedList<Node>();
	private List<Node> closedList = new LinkedList<Node>();
	
	private ArrayList<Node> resultList;
	
	public AStarAlgorithm(Node startingNode, Node finalNode) {
		this.startingNode = startingNode;
		this.finalNode = finalNode;
	}
	
	public void startAlgorithm() {
		System.out.println("done");
		resultList = new ArrayList<Node>();
		List<Node> result = search(startingNode, finalNode);
		ListIterator<Node> iter = result.listIterator(result.size());
		
		while(iter.hasPrevious()) {
			resultList.add(iter.previous());
		}
	}
	
	//Kosten zwischen den Knoten in Luftlinie
	private double estimateCost(Node node, Node target) {
		final int R = 6371;
 		double distanceLat = Math.toRadians(target.getLat() - node.getLat());
		double distanceLon = Math.toRadians(target.getLon() - node.getLon());
		double x = Math.sin(distanceLat / 2) * Math.sin(distanceLat / 2)
				   + Math.cos(Math.toRadians(node.getLat())) * Math.cos(Math.toRadians(target.getLat()))
				   * Math.sin(distanceLon / 2) * Math.sin(distanceLon / 2);
		double y = 2 * Math.atan2(Math.sqrt(x), Math.sqrt(1 - x));
		double distance = R * y;
		
		return distance;
	}
	
	@Override
	public ArrayList<Node> getResultList() {
		return resultList;
	}
	
	private List<Node> reconstructPath(Node node){
		List<Node> path = new LinkedList<Node>();
		path.add(node);
		while (node.getPredecessor() != null) {
			node = node.getPredecessor();
			path.add(node);
		}
		return path;
	}
	
	//Geringste Distanz suchen und aus Liste entfernen/zurückgeben
	private Node pollLowestFCost(List<Node> nodes) {
		Node lowestNode = nodes.get(0);
		for(Node node: nodes) {
			if(node.getFCost() < lowestNode.getFCost()) {
				lowestNode = node;
			}
		}
		nodes.remove(lowestNode);
		return lowestNode;
	}
	
	private List<Node> search(Node fromNode, Node toNode){
		openList.add(fromNode);
		
		while(!openList.isEmpty()) {
			Node node = pollLowestFCost(openList);
			closedList.add(node);
			if (node.getId() == toNode.getId()) {
				return reconstructPath(node);
			}
			System.out.println("from " + node.getLabel());
			for (Edge edge: node.getAdjazenzList()) {
				Node succ = edge.getAim();
				System.out.println("to " + succ.getLabel());
				if (closedList.contains(succ)){
					continue;
				}
				Edge edgeToSucc = null;
				for (Edge e: node.getAdjazenzList()) {
					if (e.getAim() == succ) {
						edgeToSucc = e;
						break;
					}
				}
				double tf = node.getGCost() + edgeToSucc.getWeight() + estimateCost(succ, toNode);
				if (openList.contains(succ) && tf > succ.getFCost()) {
					continue;
				}
				
				succ.setPredecessor(node);
				succ.setGCost(tf);
				succ.setFCost(node.getGCost() + edgeToSucc.getWeight());
				if(openList.contains(succ)) {
					openList.remove(succ);
				}
				openList.add(succ);
			}
		}
		System.out.println("null");
		return null;
	}

	@Override
	public double getMinDistance() {
		int size = resultList.size();
		if (size > 0) {
			return estimateCost(resultList.get(0), resultList.get(size - 1));
		}
		return 0;
	}
}
