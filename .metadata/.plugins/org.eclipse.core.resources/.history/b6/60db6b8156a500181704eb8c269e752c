package Graph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

public class Graph {

	String nodeID;
	HashMap<String, Node> nodeMap = new HashMap<String, Node>();

	public Graph() {

	}

	/* Fügt dem Graph einen Knoten hinzu */

	public void addNode(String id) throws IllegalArgumentException {
		if (nodeMap.containsKey(id)) {
			throw new IllegalArgumentException("The node is already existing");
		} else {
			Node n = new Node(id);
			nodeMap.put(id, n);
		}
	}

	/* Fügt dem Graph eine Kante hinzu */

	public void addEdge(String start, String aim, int weight) {
		if(nodeMap.containsKey(start) && nodeMap.containsKey(aim))
		{
			Node from = nodeMap.get(start);
			Node to = nodeMap.get(aim);
			if(!checkEdges(from, to))
			{
				Edge a = new Edge(from, to, weight);
				Edge b = new Edge(to, from, weight);
				from.addEdge(a);
				to.addEdge(b);
			}
			else {
				throw new IllegalArgumentException("The edge is already existing");
			}
		}

		else {
			throw new IllegalArgumentException("The choosen nodes are not valid");
		}
	}

	/* Löscht Knoten aus Graph */

	public void deleteNode(String id) throws NoSuchElementException {

		ArrayList<String> toRemove = new ArrayList<String>();

		if (nodeMap.containsKey(id)) {
			Node n = nodeMap.get(id);
			Iterator<Edge> i = n.getAdjazenzList().iterator();

			while (i.hasNext()) {
				toRemove.add(i.next().getAim().getLabel());
			}

			for (String s : toRemove) {
				deleteEdge(id, s);
			}

			nodeMap.remove(id);

		} else {
			throw new NoSuchElementException();
		}

	}

	/* Löscht Kante aus Graphen */

	public void deleteEdge(String s, String a) {
		if (nodeMap.containsKey(s) && nodeMap.containsKey(a)) {
			Node start = nodeMap.get(s);
			Node aim = nodeMap.get(a);
			Iterator<Edge> i = start.getAdjazenzList().iterator();
			while (i.hasNext()) {
				if (i.next().getAim() == aim)

				{
					i.remove();
					Iterator<Edge> it = aim.getAdjazenzList().iterator();
					while (it.hasNext()) {
						if (it.next().getAim() == start) {
							it.remove();
						}
					}
				}
			}
		}

		else {
			throw new NoSuchElementException();
		}
	}

	/* Gibt einen Knoten des Graphen zurück */

	public Node getNode(String id) throws NoSuchElementException {
		Node n = nodeMap.get(id);
		if (n == null) {
			throw new NoSuchElementException();
		}
		return n;

	}

	/* Checkt, ob es bereits eine Kante zwischen zwei Knoten gibt */

	public boolean checkEdges(Node from, Node to)
	{
		boolean existing = false;
		Iterator<Edge> i = from.getAdjazenzList().iterator();
		while(i.hasNext())
		{
			Edge edge = i.next();
			if(edge.getAim().equals(to))
			{
				existing = true;
			}
		}

		return existing;

	}
	
	/* Gibt Kantenwert zw. den Knoten zur�ck, oder -1, wenn keine Kante existiert */

	public int getEdgeWeight(Node from, Node to)
	{
		Iterator<Edge> i = from.getAdjazenzList().iterator();
		while(i.hasNext())
		{
			Edge edge = i.next();
			if(edge.getAim().equals(to))
			{
				return edge.getWeight();
			}
		}

		return -1;

	}

	/* Gibt Liste aller Knoten im Graphen zurück */

	public ArrayList<Node> getAllNodes()
	{
		ArrayList<Node> allNodes = new ArrayList<Node>();
		for (Entry e : nodeMap.entrySet()){
			Node tmp = (Node) e.getValue();
			allNodes.add(tmp);
		}

		return allNodes;
	}

	/* Gibt Liste aller Nachbarn zurück */
	
	public ArrayList<Node> getNeighbours(Node n)
	{
		ArrayList<Node> allNeighbours = new ArrayList<Node>();
		Iterator<Edge> i = n.getAdjazenzList().iterator();
		while(i.hasNext())
		{
			allNeighbours.add(i.next().getAim());
		}

		return allNeighbours;
	}

	/* Konsolenausgabe aller Knoten und Kanten - für UnitTest */

	public void printNodesAndEdges() {
		for (Entry e : nodeMap.entrySet()) {
			System.out.println("Aktueller Knoten " + e.getKey() + ": \n");
			Node n = (Node) e.getValue();
			Iterator<Edge> i = n.getAdjazenzList().iterator();
			while (i.hasNext()) {
				Edge edge = i.next();
				System.out.println(edge.getAim().getLabel() + " " + edge.getWeight() + "\n");
			}
		}
	}

	/* Konsolenausgabe der Knotenliste - für UnitTest */

	public void printNodeList()
	{
		ArrayList<Node> allNodes = this.getAllNodes();
		Iterator<Node> i = allNodes.iterator();
		while (i.hasNext()) {
			Node tmp = i.next();
			System.out.println(tmp.getLabel());
		}

	}
	
	public void printAllNeighbours(Node n)
	{
		ArrayList<Node> allNeighbours = this.getNeighbours(n);
		Iterator<Node> i = allNeighbours.iterator();
		while (i.hasNext()) {
			Node tmp = i.next();
			System.out.println(tmp.getLabel());
		}
	}
}
