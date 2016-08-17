import java.util.List;

public abstract class SearchAlgorithm<T> {

	private T graph;
	private int source;
	private int destination;
	
	public SearchAlgorithm() {
		this.graph = null;
		this.source = 0;
		this.destination = 0;	
	}
	
	public SearchAlgorithm(T graph, int source, int destination) {
		this.graph = graph;
		this.source = source;
		this.destination = destination;	
	}
	
	public T getGraph() {
		return graph;
	}
	
	public int getSource() {
		return source;
	}
	
	public void setSource(int source) {
		this.source = source;
	}
	
	public int getDestination() {
		return destination;
	}
	
	public void setDestination(int destination) {
		this.destination = destination;
	}
	
	public abstract List<Integer> search();
}
