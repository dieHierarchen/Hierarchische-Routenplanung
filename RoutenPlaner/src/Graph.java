
public interface Graph {
	public void addNode(String name, int idx, float lon, float lat);
	public void addEdge(int startIdx, int endIdx);
}