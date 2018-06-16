package UnitTests;

import Logic.*;

import java.util.ArrayList;

import org.junit.*;

public class UnitTestDijkstra {
	
	Logic.DijkstraAlgorithm DijkstraAlgo;
	private int[][] testGraph;
	
	@Before
	public void setpUp() {
		//setting up a testing matrix (incidence list of a graph)
		testGraph = new int[10][10];
		for (int i = 0; i < testGraph.length; i++) {
			for (int k = 0; k < testGraph.length; k++) {			//initial =0
				testGraph[i][k] = 0;
			}
		}
		
		//adding edges/values:
		testGraph[1][3] = 5;
		testGraph[1][2] = 6;
		
		testGraph[2][1] = 6;
		testGraph[2][4] = 3;
		testGraph[2][8] = 25;
		testGraph[2][5] = 10;
		
		testGraph[3][1] = 5;
		testGraph[3][4] = 7;
		
		testGraph[4][2] = 3;
		testGraph[4][7] = 4;
		
		testGraph[5][2] = 10;
		testGraph[5][9] = 3;
		
		testGraph[7][4] = 4;
		testGraph[7][8] = 8;
		
		testGraph[8][7] = 8;
		testGraph[8][2] = 25;
		testGraph[8][9] = 3;
		
		testGraph[9][5] = 3;
		testGraph[9][8] = 3;
		
		//calculate shortest way from node 1 to node 8:
		DijkstraAlgo = new DijkstraAlgorithm(1, 8, testGraph);
		DijkstraAlgo.startAlgorithm();
		
	}
	
	@Test
	public void AssertShortestDistance() {
		int shortestDistance = DijkstraAlgo.getMinDistance();
		Assert.assertTrue(shortestDistance == 21);
	}
	
	@Test
	public void AssertCorrectPath() {
		
		ArrayList<Integer> result = DijkstraAlgo.getResultList();
		
		//Assert:
		Assert.assertTrue(result.get(0) == 1);
		Assert.assertTrue(result.get(1) == 2);
		Assert.assertTrue(result.get(2) == 4);
		Assert.assertTrue(result.get(3) == 7);
		Assert.assertTrue(result.get(4) == 8);
	}
	
}
