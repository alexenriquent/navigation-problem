import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class AStarVertex extends Vertex implements Comparator<AStarVertex> {
	
	private double g, h, f;
	private Map<Integer, Double> heuristics;
	
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
	
	public void setHeuristic(double distance, int destination) {
		g = distance; 
		h = heuristics.get(destination);
		f = g + h;
	}
	
	public Map<Integer, Double> getHeuristics() {
		return heuristics;
	}
	
	public void setHeuristics(double matrix[][], int size) {
		this.heuristics = new HashMap<Integer, Double>();
		for (int i = 0; i < size; i++) {
			if (matrix[this.getVertex()][i] == Double.MAX_VALUE) {
				this.heuristics.put(i, 0.0);
			} else {
				this.heuristics.put(i, matrix[this.getVertex()][i]);
			}
		}
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
		if (firstVertex.getWeight() < secondVertex.getWeight()) {
			return -1;
		} else if (firstVertex.getWeight() > secondVertex.getWeight()) {
			return 1;
		} else if (firstVertex.getVertex() < secondVertex.getVertex()) {
			return -1;
		} else {
			return 0;
		}
	}
}
