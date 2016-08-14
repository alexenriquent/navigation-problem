import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class UniformCost extends AbstractSearchAlgorithm<UniformCostGraph> {
	
	private int vertexCount;
	private int parentVertices[];
	private double costs[];
	private PriorityQueue<UniformCostVertex> frontier;
    private Set<Integer> explored;
    private LinkedList<Integer> pathList;
        
    public UniformCost(UniformCostGraph graph, int vertexCount, int source, int destination) {
    	super(graph, source, destination);
        this.vertexCount = vertexCount;
        this.costs = new double[vertexCount];
        this.parentVertices = new int[vertexCount];
        this.explored = new HashSet<Integer>();
        this.frontier = new PriorityQueue<UniformCostVertex>(vertexCount, new UniformCostVertex());
        this.pathList = new LinkedList<Integer>();
    }
    
    public List<Integer> search() {
        int currentVertex;
        initialiseCosts();
        costs[this.getSource()] = 0.0;
        frontier.add(new UniformCostVertex(this.getSource(), 0.0));
 
        while (!frontier.isEmpty()) {
            currentVertex = nextVertex();
            if (currentVertex == this.getDestination()) {
                path(this.getSource(), this.getDestination());
                return result();
            } 
            explored.add(currentVertex);
            for (int i = 0; i < vertexCount; i++) {
                if (!explored.contains(i) && this.getGraph().getGraph()[currentVertex][i] != Double.MAX_VALUE) {
                	double distance = this.getGraph().getGraph()[currentVertex][i] + costs[currentVertex];
                    if (costs[i] > distance) {
                        costs[i] = distance;                         
                        parentVertices[i] = currentVertex;
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

    private void initialiseCosts() {
    	for (int i = 0; i < vertexCount; i++) {
            costs[i] = Double.MAX_VALUE;
        }
    }
    
    private int nextVertex() {
        UniformCostVertex vertex = frontier.remove();
        return vertex.getVertex();
    }
    
    private void path(int source, int destination) {
        int vertex = destination;
    	pathList.add(vertex);
        boolean foundPath = false;
        while (!foundPath) {
            if (vertex == source) {
            	foundPath = true;
                break;
            }
            pathList.add(parentVertices[vertex]);
            vertex = parentVertices[vertex];
        }
    }
    
    private List<Integer> result() {
    	Iterator<Integer> iterator = pathList.descendingIterator();
        List<Integer> optimalPath = new ArrayList<Integer>();
        while (iterator.hasNext()) {
            optimalPath.add((iterator.next() + 1));
        }
        return optimalPath;
    }
}
