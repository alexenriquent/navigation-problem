import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class UniformCost extends SearchAlgorithm {
	
	private PriorityQueue<UniformCostVertex> frontier;
    private Set<Integer> explored;
        
    public UniformCost(Graph graph, int source, int destination) {
    	super(graph, source, destination);
    	this.frontier = new PriorityQueue<UniformCostVertex>(vertexCount, new UniformCostVertex());
        this.explored = new HashSet<Integer>();
    }
    
    public List<Integer> search() {
        int currentVertex;
        initialiseCosts();
        costs[this.source] = 0.0;
        frontier.add(new UniformCostVertex(this.source, 0.0));
 
        while (!frontier.isEmpty()) {
        	UniformCostVertex nextVertex = frontier.remove();
            currentVertex = nextVertex.vertex;
            if (currentVertex == this.destination) {
                path();
                return result();
            } 
            explored.add(currentVertex);
            for (int i = 0; i < vertexCount; i++) {
                if (!explored.contains(i) && this.graph.getGraph()[currentVertex][i] != Double.MAX_VALUE) {
                	double distance = this.graph.getGraph()[currentVertex][i] + costs[currentVertex];
                    if (costs[i] > distance) {
                        costs[i] = distance;                         
                        pathList[i] = currentVertex;
                    }
                    UniformCostVertex vertex = new UniformCostVertex(i, costs[i]);
                    if (frontier.contains(vertex)) {
                        frontier.remove(vertex);
                    }
                    frontier.add(vertex);
                }
            }
        }
        return null;
    }
}
