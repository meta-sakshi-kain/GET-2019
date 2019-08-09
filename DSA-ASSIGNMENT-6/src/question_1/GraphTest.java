package question_1;

import static org.junit.Assert.*;
import org.junit.Test;
//test class for graph
public class GraphTest {
	//test case to check if graph is connected or not
	@Test
	public void isConnectedTest() {
		Graph graph = new Graph(5, 6);
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 4, 3);
		graph.addEdge(1, 2, 2);
		graph.addEdge(2, 3, 1);
		graph.addEdge(1, 3, 2);
		graph.addEdge(1, 4, 7);
		assertTrue(graph.isConnected());
		Graph graph2 = new Graph(5, 2);
		graph2.addEdge(0, 1, 1);
		graph2.addEdge(0, 4, 3);
		assertFalse(graph.isConnected());
		
	}
	//test case to check if all the nodes are reachable from given node
	@Test
	public void isReachableTest() {
		Graph graph = new Graph(5, 6);
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 4, 3);
		graph.addEdge(1, 2, 2);
		graph.addEdge(2, 3, 1);
		graph.addEdge(1, 3, 2);
		graph.addEdge(1, 4, 7);
		assertArrayEquals(new int[]{0, 1, 2, 3, 4}, graph.reachable(0));
		Graph graph1 = new Graph(4, 2);
		graph1.addEdge(0, 1, 4);
		graph1.addEdge(2, 3, 6);
		assertArrayEquals(new int[]{1}, graph1.reachable(0));
	}
	//get the minimum spanning tree for the matrix
	@Test
	public void minimumSpanningTreeTest() {
		Graph graph = new Graph(5, 6);
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 4, 3);
		graph.addEdge(1, 2, 2);
		graph.addEdge(2, 3, 1);
		graph.addEdge(1, 3, 2);
		graph.addEdge(1, 4, 7);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++)
				System.out.print(graph.minimumSpanningTree()[i][j] + " ");
			System.out.println();
		}
	}
	//test case to check the shortest path between two nodes
	@Test
	public void shortestPathTest() {
		Graph graph = new Graph(5, 6);
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 4, 3);
		graph.addEdge(1, 2, 2);
		graph.addEdge(2, 3, 1);
		graph.addEdge(1, 3, 2);
		graph.addEdge(1, 4, 7);
		assertEquals(4, graph.shortestPath(4, 1));
	}

}