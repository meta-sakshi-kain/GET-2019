package question_1;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import sun.misc.Queue;
//class to implement graph interface
public class Graph implements UndirectedWeightedGraph {
	//array for storing vertex is connected or not
	private boolean[] vertices;
	//adjacency matrix for graph
	private int[][] graph;
	private Set<Integer> weights = new TreeSet<Integer>();
	//2d array for storing edges 
	private int[][] edges;
	private int index = 0;

	public Graph(int numberOfVertices, int numberOfEdges) {
		graph = new int[numberOfVertices][numberOfVertices];
		vertices = new boolean[numberOfVertices];
		edges = new int[3][numberOfEdges];
	}
	
	
	@Override
	//return true if graph is connected using DFS 
	public boolean isConnected() {
		int i = 0, j;
		//stack for vertices
		Stack<Integer> stack = new Stack<Integer>();
		//push first vertex
		stack.push(0);
		while (i < vertices.length && (!stack.empty())) {
			vertices[i] = true;
			for (j = 0; j < graph.length; j++) {
				//get next adjacent vertex to i
				if (graph[i][j] > 0 && (!vertices[j])) {
					i = j;
					//push that vertex in stack
					stack.push(i);
					break;
				}
			}
			//if all adjacent vertices of i visited
			if (j >= vertices.length) {
				stack.pop();
				if (!stack.empty())
					i = stack.peek();
			}
		}
		//if any vertex is not connected 
		for (int k = 0; k < vertices.length; k++) {
			if (!vertices[k])
				//graph is not connected
				return false;
		}
		return true;
	}
	
    
	@Override
	// return all the nodes reachable from given vertex
	public int[] reachable(int node) {
		//array to store reachable vertices
		int[] reachableNodes;
		//set for storing adjacent nodes
		Set<Integer> nodes = new HashSet<Integer>();
		//if graph is connected then all nodes are reachable
		if (isConnected()) {
			reachableNodes = new int[graph.length];
			for (int i = 0; i < graph.length; i++)
				reachableNodes[i] = i;
			return reachableNodes;
		} 
		//find reachable vertex
		else {
			nodes.add(node);
			findConnections(node, nodes);
			nodes.remove(node);
		}
		reachableNodes = new int[nodes.size()];
		int i = 0;
		for (int connectedNode : nodes)
			reachableNodes[i++] = connectedNode;
		return reachableNodes;
	}

	/**
	 * recursive function to find connected nodes
	 * @param node from which connected nodes are to be found
	 * @param nodes connected nodes
	 */
	//method to find connections between nodes 
	private void findConnections(int node, Set<Integer> nodes) {
		for (int j = 0; j < graph.length; j++) {
			//if node is unique and adjacent
			if (graph[node][j] > 0) {
				if (nodes.add(j))
					//recursive call
					findConnections(j, nodes);
			}
		}
		return;
	}

	@Override
	//method to get the minimum spanning tree for the graph
	public int[][] minimumSpanningTree() {
		//set for storing ending node so that loop does not occur
		Set<Integer> endingNode = new HashSet<Integer>();
		int[][] mst = new int[graph.length][graph.length];
		for (int weight : weights) {
			for (int j = 0; j < edges[0].length; j++) {
				if (weight == edges[2][j]) {
					//store ending node
					if (endingNode.add(edges[1][j])) {
						mst[edges[0][j]][edges[1][j]] = weight;
						mst[edges[1][j]][edges[0][j]] = weight;
					}
				}
			}
		}
		return mst;
	}

	@Override
	//method to get the shortest path between given nodes
	public int shortestPath(int node1, int node2) {
		//distance from given node1
		int[] distance = new int[graph.length];
		for (int i = 0; i < distance.length; i++)
			distance[i] = Integer.MAX_VALUE;
		distance[node1] = 0;
		boolean[] isVisited = new boolean[graph.length];
		boolean[] isInQueue = new boolean[graph.length];
		//queue for adjacent nodes
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(node1);
		isInQueue[node1] = true;
		for (int i = 0; i < graph.length; i++) {
			try {
				int currentNode = queue.dequeue();
				for (int j = 0; j < graph.length; j++) {
					if (graph[currentNode][j] > 0 && !isVisited[j]) {
						if (!isInQueue[j]) {
							queue.enqueue(j);
							isInQueue[j] = true;
						}
						if (distance[currentNode] + graph[currentNode][j] < distance[j])
							distance[j] = distance[currentNode]
									+ graph[currentNode][j];
					}
				}
				isVisited[currentNode] = true;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return distance[node2];
	}

	/**
	 * @param start source vertex
	 * @param end destination vertex
	 * @param weight weight of path
	 */
	//method to add edge to graph
	public void addEdge(int start, int end, int weight) {
		graph[start][end] = weight;
		graph[end][start] = weight;
		weights.add(weight);
		edges[0][index] = start;
		edges[1][index] = end;
		edges[2][index++] = weight;
	}
}