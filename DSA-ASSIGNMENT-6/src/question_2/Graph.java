package question_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import sun.misc.Queue;
//class to implement graph interface
public class Graph implements UndirectedWeightedGraph {
	// array for storing vertex is connected or not
	private boolean[] vertices;
	// adjacency list for graph
	private List<List<WeightedEdge>> adjacencyList = new ArrayList<List<WeightedEdge>>();
	// adjacency list for minimum spanning tree
	private List<List<WeightedEdge>> mstList = new ArrayList<List<WeightedEdge>>();
	// for storing weights of edges
	private Set<Integer> weights = new TreeSet<Integer>();
	// 2d array for storing edges
	private int[][] edges;
	private int index = 0;
    //constructor for initializing adjacency and mst list
	public Graph(int numberOfVertices, int numberOfEdges) {
		vertices = new boolean[numberOfVertices];
		edges = new int[3][numberOfEdges];
		// add list in adjacency list
		for (int i = 0; i < numberOfVertices; i++) {
			adjacencyList.add(new ArrayList<WeightedEdge>());
			mstList.add(new ArrayList<WeightedEdge>());
		}
	}

	@Override
	// return true if graph is connected using DFS
	public boolean isConnected() {
		isConnectedRecursive(vertices, 0);
		for (int k = 0; k < vertices.length; k++) {
			if (!vertices[k])
				return false;
		}
		return true;
	}

	/**
	 * @param vertices array for storing vertex is connected or not
	 * @param i vertex from which connection are to be found
	 * @return vertices array
	 */
	//recursive function to check if graph is connected or not
	public boolean[] isConnectedRecursive(boolean[] vertices, int i) {
		// vertex i is connected
		vertices[i] = true;
		for (int j = 0; j < adjacencyList.get(i).size(); j++) {
			if (!vertices[adjacencyList.get(i).get(j).getVertex()]) {
				isConnectedRecursive(vertices, adjacencyList.get(i).get(j).getVertex());
			}
		}
		return vertices;
	}

	@Override
	// return all the nodes reachable from given vertex
	public int[] reachable(int node) {
		// array to store reachable vertices
		int[] reachableNodes;
		// set for storing adjacent nodes
		Set<Integer> nodes = new HashSet<Integer>();
		// if graph is connected then all nodes are reachable
		if (isConnected()) {
			reachableNodes = new int[adjacencyList.size()];
			for (int i = 0; i < adjacencyList.size(); i++)
				reachableNodes[i] = i;
			return reachableNodes;
		}
		// find reachable vertex
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
		for (int j = 0; j < adjacencyList.get(node).size(); j++) {
			// if node is unique and adjacent
			if (nodes.add(adjacencyList.get(node).get(j).getVertex()))
				// recursive call
				findConnections(j, nodes);
		}
		return;
	}

	@Override
	//method to get the minimum spanning tree for the graph
	public List<List<WeightedEdge>> minimumSpanningTree() {
		// set for storing ending node so that loop does not occur
		Set<Integer> endingNode = new HashSet<Integer>();
		for (int weight : weights) {
			for (int j = 0; j < edges[0].length; j++) {
				if (weight == edges[2][j]) {
					// store ending node
					if (endingNode.add(edges[1][j])) {
						mstList.get(edges[0][j]).add(new WeightedEdge(edges[1][j], weight));
						mstList.get(edges[1][j]).add(new WeightedEdge(edges[0][j], weight));
					}
				}
			}
		}
		return mstList;
	}

	@Override
	//method to get the shortest path between given nodes
	public int shortestPath(int node1, int node2) {
		// distance from given node1
		int[] distance = new int[adjacencyList.size()];
		for (int i = 0; i < distance.length; i++)
			distance[i] = Integer.MAX_VALUE;
		distance[node1] = 0;
		boolean[] isVisited = new boolean[adjacencyList.size()];
		boolean[] isInQueue = new boolean[adjacencyList.size()];
		// queue for adjacent nodes
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(node1);
		isInQueue[node1] = true;
		for (int i = 0; i < adjacencyList.size(); i++) {
			try {
				int currentNode = queue.dequeue();
				for (int j = 0; j < adjacencyList.get(currentNode).size(); j++) {
					if (!isVisited[adjacencyList.get(currentNode).get(j).getVertex()]) {
						if (!isInQueue[adjacencyList.get(currentNode).get(j).getVertex()]) {
							queue.enqueue(adjacencyList.get(currentNode).get(j).getVertex());
							isInQueue[adjacencyList.get(currentNode).get(j).getVertex()] = true;
						}
						if (distance[currentNode]+ adjacencyList.get(currentNode).get(j).getWeight() < distance[adjacencyList.get(currentNode).get(j).getVertex()])
							distance[adjacencyList.get(currentNode).get(j).getVertex()] = distance[currentNode]+ adjacencyList.get(currentNode).get(j).getWeight();
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
		adjacencyList.get(start).add(new WeightedEdge(end, weight));
		adjacencyList.get(end).add(new WeightedEdge(start, weight));
		weights.add(weight);
		edges[0][index] = start;
		edges[1][index] = end;
		edges[2][index++] = weight;
	}
}