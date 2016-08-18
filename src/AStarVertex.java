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
	
	public void setHeuristic(Graph graph, int destination) {
		g = this.getWeight(); 
		h = graph.getGraph()[this.getVertex()][destination];
		if (h == Double.MAX_VALUE) 
			h = 0.0;
		h = this.getWeight();
		f = g + h;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof AStarVertex) {
			AStarVertex vertex = (AStarVertex) other;
			return (this.getVertex() == vertex.getVertex()) ? true : false;
		}
		return false;
	}
	
	public int compare(AStarVertex firstVertex, AStarVertex secondVertex) {
		if (firstVertex.getF() < secondVertex.getF())
			return -1;
		if (firstVertex.getF() > secondVertex.getF()) 
			return 1;
		if (firstVertex.getVertex() < secondVertex.getVertex())
			return -1;
		return 0;
		
//		if (firstVertex.getWeight() < secondVertex.getWeight())
//			return -1;
//		if (firstVertex.getWeight() > secondVertex.getWeight())
//			return 1;
//		if (firstVertex.getVertex() < secondVertex.getVertex())
//			return -1;
//		return 0;
	}
}
