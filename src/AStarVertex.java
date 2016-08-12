import java.util.Comparator;
import java.util.Map;

public class AStarVertex implements Comparator<AStarVertex> {

	private int vertex;
	private double g, h, f;
	private Map<Integer, Double> heuristics;
	private Map<Integer, Double> edges;
	
	public AStarVertex() {
		vertex = 0;
		g = 0.0;
		h = 0.0;
		f = 0.0;
		heuristics = null;
		edges = null;
	}
	
	public AStarVertex(int vertex, Map<Integer, Double> heuristics, 
						Map<Integer, Double> edges) {
		this.vertex = vertex;
		this.g = Double.MAX_VALUE;
		this.heuristics = heuristics;
		this.edges = edges;
	}
	
	public int getVertex() {
		return vertex;
	}
	
	public double getG() {
		return g;
	}
	
	public void setG(double g) {
		this.g = g;
	}
	
	public double getH() {
		return h;
	}
	
	public void setH(int destination) {
		this.h = heuristics.get(destination);
	}
	
	public double getF() {
		return f;
	}
	
	public void setF() {
		this.f = g + h;
	}
	
	public Map<Integer, Double> getHeuristics() {
		return heuristics;
	}
	
	public void setHeuristics(Map<Integer, Double> heuristics) {
		this.heuristics = heuristics;
	}
	
	public Map<Integer, Double> getEdges() {
		return edges;
	}
	
	public void setEdges(Map<Integer, Double> edges) {
		this.edges = edges;
	}
	
	@Override
	public int compare(AStarVertex firstVertex, AStarVertex secondVertex) {
		if (firstVertex.getF() > secondVertex.getF()) {
			return 1;
		} else if (firstVertex.getF() < secondVertex.getF()) {
			return -1;
		} else {
			return 0;
		}
	}
}
