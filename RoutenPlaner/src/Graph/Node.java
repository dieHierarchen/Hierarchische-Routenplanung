package Graph;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Node {

	private String label;
	private ArrayList<Edge> adjazenzList;

	public Node(String s) {

		label = s;
		adjazenzList = new ArrayList<Edge>();
	}

	/* Fügt Knoten eine Kante hinzu */

	public void addEdge(Edge e) throws IllegalArgumentException {

		if (adjazenzList.contains(e)) {
			throw new IllegalArgumentException("The edge is already existing");
		}

		else {

			adjazenzList.add(e);
		}
	}

	/* Löscht Kante aus Adjazenzliste eines Knotens */

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

		else

		{
			throw new NoSuchElementException("Kante existiert nicht");
		}

	}

	/* Löscht sämtliche Kanten von und zu dem Zielknoten */

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
}
