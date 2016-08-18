import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class AStar extends SearchAlgorithm<Graph> {
	
	private int vertexCount;
	private double costs[];
	private int pathList[];
	private LinkedList<Integer> path;
	private PriorityQueue<AStarVertex> openSet;
    private Set<Integer> closedSet;
        
    public AStar(Graph graph, int vertexCount, int source, int destination) {
    	super(graph, source, destination);
        this.vertexCount = vertexCount;
        this.costs = new double[vertexCount];
        this.pathList = new int[vertexCount];
        this.path = new LinkedList<Integer>();
        this.closedSet = new HashSet<Integer>();
        this.openSet = new PriorityQueue<AStarVertex>(vertexCount, new AStarVertex());
    }
    
    public List<Integer> search() {
        int currentVertex;
        initialiseCosts();
        costs[this.getSource()] = 0.0;
        AStarVertex root = new AStarVertex(this.getSource(), 0.0);
        root.setHeuristic(this.getGraph(), 0.0, this.getDestination());
//        System.out.println((root.getVertex() + 1) + " " +root.getG() + " " + root.getH() + " " + root.getF());
        openSet.add(root);
 
        while (!openSet.isEmpty()) {
            currentVertex = nextVertex();
            if (currentVertex == this.getDestination()) {
                path(this.getSource(), this.getDestination());
                return result();
            } 
            closedSet.add(currentVertex);
            for (int i = 0; i < vertexCount; i++) {
                if (!closedSet.contains(i)) {
                	if (this.getGraph().getGraph()[currentVertex][i] != Double.MAX_VALUE) {
                		double g = this.getGraph().getGraph()[currentVertex][i] + costs[currentVertex];
                		if (costs[i] > g) {
                			costs[i] = g;                         
                			pathList[i] = currentVertex;
                		}
                		AStarVertex vertex = new AStarVertex(i, costs[i]);
                		vertex.setHeuristic(this.getGraph(), g, this.getDestination());
//                		System.out.println("	" + (vertex.getVertex() + 1) + " " + vertex.getG() + " " + vertex.getH() + " " + vertex.getF());
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

    private void initialiseCosts() {
    	for (int i = 0; i < vertexCount; i++) {
            costs[i] = Double.MAX_VALUE;
        }
    }
    
    private int nextVertex() {
    	AStarVertex vertex = openSet.remove();
        return vertex.getVertex();
    }
    
    private void path(int source, int destination) {
        int vertex = destination;
    	path.add(vertex);
        boolean foundPath = false;
        while (!foundPath) {
            if (vertex == source) {
            	foundPath = true;
                break;
            }
            path.add(pathList[vertex]);
            vertex = pathList[vertex];
        }
    }
    
    private List<Integer> result() {
    	Iterator<Integer> iterator = path.descendingIterator();
        List<Integer> optimalPath = new ArrayList<Integer>();
        while (iterator.hasNext()) {
            optimalPath.add((iterator.next() + 1));
        }
        return optimalPath;
    }
}
