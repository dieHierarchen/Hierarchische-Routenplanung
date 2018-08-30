/**
 * @author Oliver.Siedler
 */

package UnitTests;

import Logic.*;
import java.util.ArrayList;

import org.junit.*;

import Graph.Graph;
import Graph.Node;

public class UnitTestAStarAlgorithm{
	
	Logic.AStarAlgorithm AStarAlgo;
	private Graph testGraph;
	
	@Before
	public void setpUp() {
		
		//setting up a test graph
		testGraph = new Graph();
		
		testGraph = new Graph();
		testGraph.addNode("1", 8.415789, 55.057728);
		testGraph.addNode("2", 8.415789, 54.456776);
		testGraph.addNode("3", 8.415789, 51.456776);
		testGraph.addNode("6", 8.415789, 50.6);
		testGraph.addNode("5", 8.415789, 50.8);
		
		testGraph.addNode("8", 10.178306,1);
		testGraph.addNode("10", 8.415789, 53.0);
		testGraph.addNode("20", 10.178306, 1);
				
//		//adding edges:
				
		testGraph.addEdge("1","2", 1);
		testGraph.addEdge("2","3", 3);
		testGraph.addEdge("3","6", 2);
		testGraph.addEdge("6","5", 4);
		testGraph.addEdge("1","8", 10);
		testGraph.addEdge("8","5", 20);
		
		testGraph.addEdge("1","10", 1);
		testGraph.addEdge("3","20", 6);
		
		
		//calculate shortest way from node 1 to node 8:
		Node start = testGraph.getNode("1");
		Node aim = testGraph.getNode("5");
		AStarAlgo = new AStarAlgorithm(start, aim);
		AStarAlgo.startAlgorithm();
		
	}
	
	
	@Test
	public void AssertCorrectPath() {
		
		ArrayList<Node> result = AStarAlgo.getResultList();
		
		//Assert:
		Assert.assertTrue(result.get(0).getLabel() == "1");
		Assert.assertTrue(result.get(1).getLabel() == "2");
		Assert.assertTrue(result.get(2).getLabel() == "3");
		Assert.assertTrue(result.get(3).getLabel() == "6");
		Assert.assertTrue(result.get(4).getLabel() == "5");
	}

	
}