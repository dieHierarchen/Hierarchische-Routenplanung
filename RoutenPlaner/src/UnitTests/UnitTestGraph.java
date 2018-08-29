package UnitTests;

import java.util.ArrayList;

import org.junit.*;

import Graph.Edge;
import Graph.Graph;
import Graph.Node;


public class UnitTestGraph {

	Graph testGraph;
	
	@Before
	public void setUp() {
		

		
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
						
//				//adding edges:
						
				testGraph.addEdge("1","2", 1);
				testGraph.addEdge("2","3", 3);
				testGraph.addEdge("3","6", 2);
				testGraph.addEdge("6","5", 4);
				testGraph.addEdge("1","8", 10);
				testGraph.addEdge("8","5", 20);
				
				testGraph.addEdge("1","10", 1);
				testGraph.addEdge("3","20", 6);
		
		
			
	}
	
	@Test
	public void AssertCorrectPath(){
		
		/* Check, if nodes are existing */
		
		ArrayList<Node> allNodes = testGraph.getAllNodes();
		Assert.assertTrue(allNodes.get(0).getLabel() == "1");
		Assert.assertTrue(allNodes.get(1).getLabel() == "2");
		Assert.assertTrue(allNodes.get(2).getLabel() == "3");
		Assert.assertTrue(allNodes.get(3).getLabel() == "20");
		Assert.assertTrue(allNodes.get(4).getLabel() == "5");
		Assert.assertTrue(allNodes.get(5).getLabel() == "6");
		Assert.assertTrue(allNodes.get(6).getLabel() == "8");
		Assert.assertTrue(allNodes.get(7).getLabel() == "10");
		
		/* Check, if edges are existing*/
		
		Assert.assertTrue(testGraph.checkEdges("1","2"));
		Assert.assertTrue(testGraph.checkEdges("3","6"));
		Assert.assertTrue(testGraph.checkEdges("5","8"));
		
		/* Check, if deleting edges works */
		
		testGraph.deleteEdge("1", "2");
		Assert.assertTrue(!testGraph.checkEdges("2","1"));
		Assert.assertTrue(!testGraph.checkEdges("1","2"));
		
		/* Check, if deleting nodes works */
		
		Node tmp = testGraph.getNode("8");
		Node tmp1 = testGraph.getNode("20");
		testGraph.deleteNode("8");
		testGraph.deleteNode("20");
		Assert.assertTrue(!testGraph.getAllNodes().contains(tmp));
		Assert.assertTrue(!testGraph.getAllNodes().contains(tmp1));
		
	}

}
