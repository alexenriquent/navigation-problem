import java.util.HashMap;
import java.util.Map;

public class AStarGraph {
	
	private Map<Integer, AStarVertex> graph;
	private static final double MAX_VALUE = 1000.0;
	
	public AStarGraph(double adjacencyMatrix[][], int size) {
		graph = new HashMap<Integer, AStarVertex>();
		setGraph(adjacencyMatrix, size);
	}
	
	private void setGraph(double adjacencyMatrix[][], int size) {
		for (int i = 0; i < size; i++) {
			Map<Integer, Double> heuristics = new HashMap<Integer, Double>();
			Map<Integer, Double> edges = new HashMap<Integer, Double>();
			for (int j = 0; j < size; j++) {
				if (i != j && adjacencyMatrix[i][j] == 0.0) {
					heuristics.put(j, MAX_VALUE);
				} else {
					heuristics.put(j, adjacencyMatrix[i][j]);
				}
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
