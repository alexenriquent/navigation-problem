import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AStarGraph implements Iterable<Integer> {
	
	private Map<Integer, AStarVertex> graph;
	
	public AStarGraph() {
		graph = new HashMap<Integer, AStarVertex>();
	}
	
	public Map<Integer, AStarVertex> getGraph() {
		return graph;
	}
	
	public void addVertex(AStarVertex vertex) {
		graph.put(vertex.getVertex(), vertex);
	}
	
	public AStarVertex getVertex(int vertex) {
		return graph.get(vertex);
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return graph.keySet().iterator();
	}
}
