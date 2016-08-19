import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class SearchAlgorithm {

	protected Graph graph;
	protected int source;
	protected int destination;
	protected int vertexCount;
	protected double costs[];
	protected int pathList[];
	protected LinkedList<Integer> path;
	
	public SearchAlgorithm() {
		this.graph = null;
		this.source = 0;
		this.destination = 0;
		this.vertexCount = 0;
        this.costs = null;
        this.pathList = null;
        this.path = null;
	}
	
	public SearchAlgorithm(Graph graph, int source, int destination) {
		this.graph = graph;
		this.source = source;
		this.destination = destination;	
		this.vertexCount = this.graph.getSize();
        this.costs = new double[vertexCount];
        this.pathList = new int[vertexCount];
        this.path = new LinkedList<Integer>();
	}
	
	public abstract List<Integer> search();
	
	protected void initialiseCosts() {
    	for (int i = 0; i < vertexCount; i++) {
            costs[i] = Double.MAX_VALUE;
        }
    }
	
	protected void path() {
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
	
	protected List<Integer> result() {
    	Iterator<Integer> iterator = path.descendingIterator();
        List<Integer> optimalPath = new ArrayList<Integer>();
        while (iterator.hasNext()) {
            optimalPath.add((iterator.next() + 1));
        }
        return optimalPath;
    }
}
