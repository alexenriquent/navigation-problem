import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class UniformCost {
	
	private int vertexCount;
	private int parentVertices[];
	private double costs[];
	private PriorityQueue<UCVertex> priorityQueue;
    private Set<Integer> explored;
    private LinkedList<Integer> pathList;
        
    public UniformCost(int vertexCount) {
        this.vertexCount = vertexCount;
        this.costs = new double[vertexCount];
        this.parentVertices = new int[vertexCount];
        this.explored = new HashSet<Integer>();
        this.priorityQueue = new PriorityQueue<UCVertex>(vertexCount, new UCVertex());
        this.pathList = new LinkedList<Integer>();
    }
    
    public List<Integer> search(double graph[][], int source, int destination) {
        int currentVertex;
 
        initialiseCosts();
        priorityQueue.add(new UCVertex(source, 0.0));
        costs[source] = 0.0;
 
        while (!priorityQueue.isEmpty()) {
            currentVertex = nextVertex();
            if (currentVertex == destination) {
                path(graph, source, destination);
                return result();
            } 
            explored.add(currentVertex);
            for (int i = 0; i < vertexCount; i++) {
                if (!explored.contains(i) && graph[currentVertex][i] != Double.MAX_VALUE) {
                    if (costs[i] > graph[currentVertex][i] + costs[currentVertex]) {
                        costs[i] = graph[currentVertex][i] + costs[currentVertex];                         
                        parentVertices[i] = currentVertex;
                    }
                    UCVertex vertex = new UCVertex(i, costs[i]);
                    if (priorityQueue.contains(vertex)) {
                        priorityQueue.remove(vertex);
                    }
                    priorityQueue.add(vertex);
                }
            }
        }
        return null;
    }
    
    public double[][] setGraph(double graph[][], int size) {
    	double matrix[][] = cloneGraph(graph, size);		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j) {
					matrix[i][j] = 0.0;
				} else if (matrix[i][j] == 0.0) {
					matrix[i][j] = Double.MAX_VALUE;
				}
			}
		}
		return matrix;
    }
    
    private double[][] cloneGraph(double graph[][], int size) {
    	double matrix[][] = new double[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = graph[i][j];
			}
		}
		return matrix;
    }

    private void initialiseCosts() {
    	for (int i = 0; i < vertexCount; i++) {
            costs[i] = Double.MAX_VALUE;
        }
    }
    
    private int nextVertex() {
        UCVertex vertex = priorityQueue.remove();
        return vertex.getVertex();
    }
    
    private void path(double graph[][], int source, int destination) {
        int vertex = destination;
    	pathList.add(vertex);
        boolean succeed = false;
        while (!succeed) {
            if (vertex == source) {
                succeed = true;
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
