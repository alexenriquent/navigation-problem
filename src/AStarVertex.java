import java.util.Comparator;

public class AStarVertex extends Vertex implements Comparator<AStarVertex> {
	
	private double g, h, f;
	
	public AStarVertex() {
		super();
		initialise();
	}
	
	public AStarVertex(int vertex, double weight) {
		super(vertex, weight);
		initialise();
	}
	
	private void initialise() {
		g = 0.0;
		h = 0.0;
		f = 0.0;
	}
	
	public double getG() {
		return g;
	}
	
	public double getH() {
		return h;
	}
	
	public double getF() {
		return f;
	}
	
	public void setHeuristic(Graph graph, double distance, int destination) {
		g = distance; 
//		h = graph.getGraph()[this.vertex][destination];
		h = this.weight;
		f = g + h;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof AStarVertex) {
			AStarVertex vertex = (AStarVertex) other;
			return (this.vertex == vertex.vertex) ? true : false;
		}
		return false;
	}
	
	public int compare(AStarVertex firstVertex, AStarVertex secondVertex) {
		if (firstVertex.getF() < secondVertex.getF())
			return -1;
		if (firstVertex.getF() > secondVertex.getF()) 
			return 1;
		if (firstVertex.vertex < secondVertex.vertex)
			return -1;
		return 0;
	}
}
