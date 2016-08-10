import java.util.Comparator;

public class UCVertex implements Comparator<UCVertex> {
	
	private int vertex;
	private double weight;
	
	public UCVertex() {
		this.vertex = 0;
		this.weight = 0.0;
	}
	
	public UCVertex(int vertex, double weight) {
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
		if (other instanceof UCVertex) {
			UCVertex ucVertex = (UCVertex) other;
			return (this.vertex == ucVertex.getVertex()) ? true : false;
		}
		return false;
	}
	
	@Override 
	public int compare(UCVertex firstVertex, UCVertex secondVertex) {
		if (firstVertex.getWeight() < secondVertex.getWeight()) {
			return -1;
		} else if (firstVertex.getWeight() > secondVertex.getWeight()) {
			return 1;
		} else if (firstVertex.getVertex() < secondVertex.getVertex()) {
			return -1;
		}
		return 0;
	}
}
