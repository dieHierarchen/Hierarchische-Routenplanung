package Graph;

public class Edge {

	private Node start;
	private Node aim;
	private float weight;

	public Edge(Node start, Node aim, float weight) {

		this.start = start;
		this.aim = aim;
		this.weight = weight;

	}

	public float getWeight() {
		return weight;
	}

	public Node getAim() {
		Node aim = this.aim;
		return aim;
	}

	public Node getStart() {
		Node start = this.start;
		return start;
	}

}
