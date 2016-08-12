import java.util.HashMap;
import java.util.Map;

public class AStarGraph {
	
	private Map<Integer, AStarVertex> graph;
	
	public AStarGraph() {
		graph = new HashMap<Integer, AStarVertex>();
	}
	
	public void setGraph(double adjacencyMatrix[][], int size) {
		for (int i = 0; i < size; i++) {
			Map<Integer, Double> heuristics = new HashMap<Integer, Double>();
			Map<Integer, Double> edges = new HashMap<Integer, Double>();
			for (int j = 0; j < size; j++) {
				heuristics.put(j, adjacencyMatrix[i][j]);
				if (adjacencyMatrix[i][j] != 0.0) {
					edges.put(j, adjacencyMatrix[i][j]);
				}
			}
			AStarVertex vertex = new AStarVertex(i, heuristics, edges);
			this.graph.put(vertex.getVertex(), vertex);
		}
	}
	
	public Map<Integer, AStarVertex> getGraph() {
		return graph;
	}
	
	public AStarVertex getVertex(int vertex) {
		return graph.get(vertex);
	}
}
