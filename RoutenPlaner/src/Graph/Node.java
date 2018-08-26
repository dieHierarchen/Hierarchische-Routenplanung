package Graph;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Node implements Comparable<Node>{

	private String label;
	private int id;
	private double lon;
	private double lat;
	private ArrayList<Edge> adjazenzList;

	public Node(String label, int id, double lon, double lat) {

		this.label = label;
		this.id = id;
		this.lon = lon;
		this.lat = lat;
		adjazenzList = new ArrayList<Edge>();
	}

	
	/* Adds edge to the current node */

	public void addEdge(Edge e) throws IllegalArgumentException {

		if (adjazenzList.contains(e)) {
			throw new IllegalArgumentException("The edge is already existing");
		}
		else {
			adjazenzList.add(e);
		}
	}
	

	/* Deletes edge from adjacencylist of the current node */

	public void removeEdge(Edge e) throws NoSuchElementException {

		if (adjazenzList.contains(e)) {
			adjazenzList.remove(e);
			Node tmp = e.getAim();
			Iterator<Edge> i = tmp.adjazenzList.iterator();
			while (i.hasNext()) {
				if (i.next().getAim() == e.getStart()) {
					i.remove();
				}
			}
		}
		else{
			throw new NoSuchElementException("Choosen edge is not existing");
		}

	}

	
	/* Deletes every edge with the choosen node in the graph */

	public void deleteAllEdges(Node n) {
		Edge currentEdge;
		Node targetNode;
		ArrayList<Edge> allEdges = getAllEdges(n);
		for (int i = 0; i < allEdges.size(); i++) {
			currentEdge = (Edge) allEdges.get(i);
			targetNode = currentEdge.getAim();
			targetNode.removeEdge(currentEdge);
		}
	}
	
	
	/* Returns list of all neighbours */

	public ArrayList<Node> getNeighbours()
	{
		ArrayList<Node> allNeighbours = new ArrayList<Node>();
		Iterator<Edge> i = this.getAdjazenzList().iterator();
		while(i.hasNext())
		{
			allNeighbours.add(i.next().getAim());
		}

		return allNeighbours;
	}
	
	
	/* Calculates weight of the edge between nodes in kilometers */
	
	public double getDistance(Node aim)
	{
		final int R = 6371;
		double distanceLat = Math.toRadians(aim.getLat() - this.getLat());
		double distanceLon = Math.toRadians(aim.getLon() - this.getLon());
		double x = Math.sin(distanceLat / 2) * Math.sin(distanceLat / 2)
				   + Math.cos(Math.toRadians(this.getLat())) * Math.cos(Math.toRadians(aim.getLat()))
				   * Math.sin(distanceLon / 2) * Math.sin(distanceLon / 2);
		double y = 2 * Math.atan2(Math.sqrt(x), Math.sqrt(1 - x));
		double distance = R * y;
		
		return distance;
		
	}
	
	
	/* Compares two nodes with each other */ 
	
	@Override
	public int compareTo(Node o) {
		return this.getLabel().compareTo(o.getLabel());
	}

	public ArrayList<Edge> getAllEdges(Node n) {
		return n.adjazenzList;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public ArrayList<Edge> getAdjazenzList() {
		return adjazenzList;
	}

	public void setAdjazenzList(ArrayList<Edge> adjazenzList) {
		this.adjazenzList = adjazenzList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}
}
