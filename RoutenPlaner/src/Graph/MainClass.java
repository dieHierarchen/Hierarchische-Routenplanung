package Graph;

public class MainClass {
	public static void main (String[] Args) {
		Graph g1 = new Graph();
		g1.addNode("London");
		g1.addNode("Penis");
		g1.addNode("Paris");
		g1.addNode("Kobold");
		g1.addNode("Goosheim");
		g1.addEdge("Goosheim", "London", 12);
		g1.addEdge("Penis", "Kobold", 123);
		g1.addEdge("Paris", "Penis", 1);
		g1.addEdge("Goosheim", "Penis", 12);
		Node tmp = g1.getNode("Paris");
		g1.getNeighbours(tmp);

	}
}
