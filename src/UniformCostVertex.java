import java.util.Comparator;

public class UniformCostVertex extends Vertex implements Comparator<UniformCostVertex> {
	
	public UniformCostVertex() {
		super();
	}
	
	public UniformCostVertex(int vertex, double weight) {
		super(vertex, weight);
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof UniformCostVertex) {
			UniformCostVertex vertex = (UniformCostVertex) other;
			return (this.getVertex() == vertex.getVertex()) ? true : false;
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
