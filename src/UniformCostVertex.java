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
			return (this.vertex == vertex.vertex) ? true : false;
		}
		return false;
	}
	
	@Override 
	public int compare(UniformCostVertex firstVertex, UniformCostVertex secondVertex) {
		if (firstVertex.weight < secondVertex.weight)
			return -1;
		if (firstVertex.weight > secondVertex.weight)
			return 1;
		if (firstVertex.vertex < secondVertex.vertex)
			return -1;
		return 0;
	}
}
