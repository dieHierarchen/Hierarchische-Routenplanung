/**
 * @author Robin.Schneider
 */

package UnitTests;

import Logic.*;
import java.util.ArrayList;

import org.junit.*;

import Graph.Graph;
import Graph.Node;

public class UnitTestDijkstra {
	
	Logic.DijkstraAlgorithm DijkstraAlgo;
	private Graph testGraph;
	
	@Before
	public void setpUp() {
		
		testGraph = new Graph();
		testGraph.addNode("1");
		testGraph.addNode("2");
		testGraph.addNode("3");
		testGraph.addNode("4");
		testGraph.addNode("5");
		testGraph.addNode("6");
		testGraph.addNode("7");
		testGraph.addNode("8");
		testGraph.addNode("9");
		
		//adding edges:
		
		testGraph.addEdge("1", "3", 5);
		testGraph.addEdge("1", "2", 6);
		testGraph.addEdge("3", "4", 7);
		testGraph.addEdge("2", "4", 3);
		testGraph.addEdge("2", "8", 25);
		testGraph.addEdge("2", "5", 10);
		testGraph.addEdge("4", "7", 4);
		testGraph.addEdge("5", "9", 3);
		testGraph.addEdge("7", "8", 8);
		testGraph.addEdge("8", "9", 3);
		

		
		//calculate shortest way from node 1 to node 8:
		Node start = testGraph.getNode("1");
		Node aim = testGraph.getNode("8");
		DijkstraAlgo = new DijkstraAlgorithm(start, aim, testGraph);
		DijkstraAlgo.startAlgorithm();
		
	}
	
	@Test
	public void AssertShortestDistance() {
		int shortestDistance = DijkstraAlgo.getMinDistance();
		Assert.assertTrue(shortestDistance == 21);
	}
	
	@Test
	public void AssertCorrectPath() {
		
		ArrayList<Node> result = DijkstraAlgo.getResultList();
		
		//Assert:
		Assert.assertTrue(result.get(0).getLabel() == "1");
		Assert.assertTrue(result.get(1).getLabel() == "2");
		Assert.assertTrue(result.get(2).getLabel() == "4");
		Assert.assertTrue(result.get(3).getLabel() == "7");
		Assert.assertTrue(result.get(4).getLabel() == "8");
	}
	
	@Test
	public void AssertGraphTest() {
		Node start = testGraph.getNode("2");
		Node aim = testGraph.getNode("8");
		Node noEdge = testGraph.getNode("6");
		Assert.assertTrue(testGraph.getEdgeWeight(start, aim) == 25);
		Assert.assertTrue(testGraph.getEdgeWeight(noEdge, aim) == -1);
	}
	
}
