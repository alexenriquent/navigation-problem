import java.util.Comparator;

public class UniformCostVertex implements Comparator<UniformCostVertex> {
	
	private int vertex;
	private double weight;
	
	public UniformCostVertex() {
		this.vertex = 0;
		this.weight = 0.0;
	}
	
	public UniformCostVertex(int vertex, double weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
	
	public int getVertex() {
		return vertex;
	}
	
	public double getWeight() {
		return weight;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof UniformCostVertex) {
			UniformCostVertex ucVertex = (UniformCostVertex) other;
			return (this.vertex == ucVertex.getVertex()) ? true : false;
		}
		return false;
	}
	
	@Override 
	public int compare(UniformCostVertex firstVertex, UniformCostVertex secondVertex) {
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
