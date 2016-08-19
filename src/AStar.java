import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class AStar extends SearchAlgorithm {
	
	private PriorityQueue<AStarVertex> openSet;
    private Set<Integer> closedSet;
    private AStarVertex root;
        
    public AStar(Graph graph, int source, int destination) {
    	super(graph, source, destination);
    	this.openSet = new PriorityQueue<AStarVertex>(vertexCount, new AStarVertex());
        this.closedSet = new HashSet<Integer>();
        this.root = new AStarVertex(this.source, 0.0);
    }
    
    public List<Integer> search() {
        int currentVertex;
        initialiseCosts();
        costs[this.source] = 0.0;
        root.setHeuristic(this.graph, 0.0, this.destination);
        openSet.add(root);
        while (!openSet.isEmpty()) {
        	AStarVertex nextVertex = openSet.remove();
            currentVertex = nextVertex.vertex;
            if (currentVertex == this.destination) {
                path();
                return result();
            } 
            closedSet.add(currentVertex);
            for (int i = 0; i < vertexCount; i++) {
                if (!closedSet.contains(i)) {
                	if (this.graph.getGraph()[currentVertex][i] != Double.MAX_VALUE) {
                		double g = this.graph.getGraph()[currentVertex][i] + costs[currentVertex];
                		if (costs[i] > g) {
                			costs[i] = g;                         
                			pathList[i] = currentVertex;
                		}
                		AStarVertex vertex = new AStarVertex(i, costs[i]);
                		vertex.setHeuristic(this.graph, costs[i], this.destination);
                		if (openSet.contains(vertex)) {
                			openSet.remove(vertex);
                		}
                		openSet.add(vertex);
                	}
                }
            }
        }
        return null;
    }
}
