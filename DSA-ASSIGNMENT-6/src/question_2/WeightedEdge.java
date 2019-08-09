package question_2;
//class to store ending node of a edge and weight
public class WeightedEdge {
	private int vertex;
	private int weight;
	//constructor
	public WeightedEdge(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
    //get the vertex
	public int getVertex() {
		return vertex;
	}
    //set the vertex
	public void setVertex(int vertex) {
		this.vertex = vertex;
	}
    //get the weight of edge
	public int getWeight() {
		return weight;
	}
    //set the weight of edge
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}